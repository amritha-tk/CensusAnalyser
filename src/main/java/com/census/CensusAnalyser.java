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
                        CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
                        csvToBeanBuilder.withType(IndiaCensusCSV.class);
                        csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
                        CsvToBean<IndiaCensusCSV> csvToBean = csvToBeanBuilder.build();
                        Iterator<IndiaCensusCSV> censusCSVIterator = csvToBean.iterator();;
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

        public boolean loadIndiaCensusDataToCheckDelimiter(String csvFilePath) throws CensusAnalyserException {
                try {
                        BufferedReader csvReader = new BufferedReader(new FileReader(csvFilePath));
                        String row;
                        while ((row = csvReader.readLine()) != null) {
                                if (row.contains(","))
                                        System.out.println("Delimiter present");
                        }
                } catch (IOException e) {
                        throw new CensusAnalyserException("Delimiter Incorrect",CensusAnalyserException.ExceptionType.INCORRECT_DELIMITER);
                }
                return true;
        }

        public boolean loadIndiaCensusDataToCheckHeader(String csvFilePath) throws CensusAnalyserException {
                try {
                        BufferedReader csvReader = new BufferedReader(new FileReader(csvFilePath));
                        String row;
                        while ((row = csvReader.readLine()) != null) {
                                if (row.contains("State"))
                                        System.out.println("Header present");
                        }
                } catch (IOException e) {
                        throw new CensusAnalyserException("Header Incorrect",CensusAnalyserException.ExceptionType.INCORRECT_HEADER);
                }
                return true;
        }

        public int loadIndiaStateCodeData(String csvFilePath) throws CensusAnalyserException {
                try  (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));){
                        CsvToBeanBuilder<IndiaStateCodeCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
                        csvToBeanBuilder.withType(IndiaStateCodeCSV.class);
                        csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
                        CsvToBean<IndiaStateCodeCSV> csvToBean = csvToBeanBuilder.build();
                        Iterator<IndiaStateCodeCSV> censusCSVIterator = csvToBean.iterator();
                        Iterable<IndiaStateCodeCSV> csvIterable = () -> censusCSVIterator;
                        int numOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
                        return numOfEntries;
                } catch (IOException e) {
                        throw new CensusAnalyserException("Please Enter Correct Path",
                                CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
                } catch (IllegalStateException e) {
                        throw new CensusAnalyserException("Please Enter CSV File",
                                CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE);
                }
        }

        public boolean loadIndiaStateCodeDataToCheckDelimiter(String csvFilePath) throws CensusAnalyserException {
                try {
                        BufferedReader csvReader = new BufferedReader(new FileReader(csvFilePath));
                        String row;
                        while ((row = csvReader.readLine()) != null) {
                                if (row.contains(","))
                                        System.out.println("Delimiter present");
                        }
                } catch (IOException e) {
                        throw new CensusAnalyserException("Delimiter Incorrect",CensusAnalyserException.ExceptionType.INCORRECT_DELIMITER);
                }
                return true;
        }

        public boolean loadIndiaStateCodeDataToCheckHeader(String csvFilePath) throws CensusAnalyserException {
                try {
                        BufferedReader csvReader = new BufferedReader(new FileReader(csvFilePath));
                        String row;
                        while ((row = csvReader.readLine()) != null) {
                                if (row.contains("State"))
                                        System.out.println("Present");
                        }
                } catch (IOException e) {
                        throw new CensusAnalyserException("Header Incorrect",CensusAnalyserException.ExceptionType.INCORRECT_HEADER);
                }
                return true;
        }

}
