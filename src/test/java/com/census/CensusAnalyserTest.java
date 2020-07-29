package com.census;

import org.junit.Test;
import org.junit.Assert;



public class CensusAnalyserTest {

        private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
        private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
        private static final String WRONG_FILETYPE_PATH ="./src/test/resources/IndiaStateCensusData.txt";
        private static final String INCORRECT_DELIMITERANDHEADER_CSVFILE="./src/test/resources/IndiaStateCensusDataWrongDelimiter.csv";
        private static final String INDIA_STATECODE_CSV_FILE_PATH="./src/test/resources/IndiaStateCode.csv";
        private static final String WRONG_STATECODE_CSV_FILE_PATH = "./src/main/resources/IndiaStateCode.csv";
        private static final String WRONG_STATECODE_FILETYPE_PATH ="./src/test/resources/IndiaStateCode.txt";
        private static final String INCORRECT_STATECODE_DELIMITERANDHEADER_CSVFILE="./src/test/resources/IndiaStateCodeWrongDelimiter.csv";

    @Test
    public void givenIndianCensusCSVFile_WhenPassedCorrect_ThenReturnsNumberofRecords()  {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            Assert.assertEquals(29,numOfRecords);
            } catch (CensusAnalyserException e) { }
        }

    @Test
    public void givenIndiaCensusCSVFile_WhenPassedWrong_ThenThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }

    @Test
    public void givenIndianCensusCSVFile_WhenWrongFileTypePassed_ThenThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadIndiaCensusData(WRONG_FILETYPE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }

    }

    @Test
    public void givenIndianCensusCSVFile_WhenDelimiterIncorrect_ThenThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadCSVFileToCheckDelimiterandHeader(INCORRECT_DELIMITERANDHEADER_CSVFILE);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_DELIMITER_OR_INCORRECT_HEADER,e.type);
        }
    }

    @Test
    public void givenIndianCensusCSVFile_WhenHeaderIncorrect_ThenthrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadCSVFileToCheckDelimiterandHeader(INCORRECT_DELIMITERANDHEADER_CSVFILE);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_DELIMITER_OR_INCORRECT_HEADER,e.type);
        }
    }

    @Test
    public void givenIndianStateCodeCSVFile_WhenPassedCorrect_ThenReturnsNumberofRecords()  {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaStateCodeData(INDIA_STATECODE_CSV_FILE_PATH);
            Assert.assertEquals(37,numOfRecords);
        } catch (CensusAnalyserException e) { e.printStackTrace();}
    }

    @Test
    public void givenIndiaStateCodeCSVFile_WhenPassedWrong_ThenThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadIndiaStateCodeData(WRONG_STATECODE_CSV_FILE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }

    @Test
    public void givenIndianStateCodeCSVFile_WhenWrongFileTypePassed_ThenThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadIndiaStateCodeData(WRONG_STATECODE_FILETYPE_PATH);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }

    @Test
    public void givenIndianStateCodeCSVFile_WhenDelimiterIncorrect_ThenThrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadCSVFileToCheckDelimiterandHeader(INCORRECT_STATECODE_DELIMITERANDHEADER_CSVFILE);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_DELIMITER_OR_INCORRECT_HEADER,e.type);
        }
    }

    @Test
    public void givenIndianStateCodeCSVFile_WhenHeaderIncorrect_ThenthrowException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            censusAnalyser.loadCSVFileToCheckDelimiterandHeader(INCORRECT_STATECODE_DELIMITERANDHEADER_CSVFILE);
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.INCORRECT_DELIMITER_OR_INCORRECT_HEADER,e.type);
        }
    }

}

