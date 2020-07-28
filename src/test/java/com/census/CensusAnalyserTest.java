package com.census;

import org.junit.Test;
import org.junit.Assert;
import org.junit.rules.ExpectedException;

import java.io.IOException;


public class CensusAnalyserTest {

        private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
        private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
        private static final String WRONG_FILETYPE_PATH ="./src/test/resources/IndiaStateCensusData.txt";

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
            Assert.assertEquals(CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE,e.type);
        }

    }
}

