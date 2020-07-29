package com.census;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class CensusAnalyser {
        public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyserException {
                try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));) {
                        Iterator<IndiaCensusCSV> censusCSVIterator = this.getCSVFileIterator(reader,IndiaCensusCSV.class);
                        Iterable<IndiaCensusCSV> csvIterable = () -> censusCSVIterator;
                        int numOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
                        return numOfEntries;
                } catch (IOException e) {
                        throw new CensusAnalyserException("Please Enter Correct Path", CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
                } catch (IllegalStateException e) {
                        throw new CensusAnalyserException("Please Enter CSV File",
                                CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE);
                }
        }

        public boolean loadCSVFileToCheckDelimiterandHeader(String csvFilePath) throws CensusAnalyserException {
                try {
                        BufferedReader csvReader = new BufferedReader(new FileReader(csvFilePath));
                        String row;
                        while ((row = csvReader.readLine()) != null) {
                                if (row.contains(",")|| (row.contains("State")))
                                        System.out.println("Delimiter present or Header present");
                        }
                } catch (IOException e) {
                        throw new CensusAnalyserException(e.getMessage(),CensusAnalyserException.ExceptionType.INCORRECT_DELIMITER_OR_INCORRECT_HEADER);
                }
                return true;
        }

        public int loadIndiaStateCodeData(String csvFilePath) throws CensusAnalyserException {
                try  (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));){
                        Iterator<IndiaStateCodeCSV> censusCSVIterator = this.getCSVFileIterator(reader,IndiaStateCodeCSV.class);
                        return this.getCount(censusCSVIterator);
                } catch (IOException e) {
                        throw new CensusAnalyserException("Please Enter Correct Path",
                                CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
                } catch (IllegalStateException e) {
                        throw new CensusAnalyserException("Please Enter CSV File",
                                CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE);
                }
        }

        private <E> int getCount (Iterator<E> iterator){
                Iterable<E> csvIterable = () -> iterator;
                int numOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
                return numOfEntries;
        }

        private <E> Iterator<E> getCSVFileIterator(Reader reader,Class csvClass) throws CensusAnalyserException{
                try{
                        CsvToBeanBuilder<E> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
                        csvToBeanBuilder.withType(csvClass);
                        csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
                        CsvToBean<E> csvToBean = csvToBeanBuilder.build();
                        return csvToBean.iterator();

                }catch (IllegalStateException e){
                        throw new CensusAnalyserException("Please Enter CSV File",
                                CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE);
                }
        }

}
