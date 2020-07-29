package com.census;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class CensusAnalyser {
        public int loadIndiaCensusData(String csvFilePath) throws CensusAnalyserException {
                try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
                        Iterator<IndiaCensusCSV> censusCSVIterator = new OpenCSVBuilder().
                                                                        getCSVFileIterator(reader,IndiaCensusCSV.class);
                        return getCount(censusCSVIterator);
                } catch (IOException e) {
                        throw new CensusAnalyserException(e.getMessage(),
                                CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
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
                        throw new CensusAnalyserException(e.getMessage(),
                                CensusAnalyserException.ExceptionType.INCORRECT_DELIMITER_OR_INCORRECT_HEADER);
                }
                return true;
        }

        public int loadIndiaStateCodeData(String csvFilePath) throws CensusAnalyserException {
                try  (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))){
                        Iterator<IndiaStateCodeCSV> stateCodeCSVIterator = new OpenCSVBuilder().
                                                                        getCSVFileIterator(reader,IndiaStateCodeCSV.class);
                        return this.getCount(stateCodeCSVIterator);
                } catch (IOException e) {
                        throw new CensusAnalyserException(e.getMessage(),
                                CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
                }
        }

        private <E> int getCount (Iterator<E> iterator){
                Iterable<E> csvIterable = () -> iterator;
                int numOfEntries = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
                return numOfEntries;
        }
}
