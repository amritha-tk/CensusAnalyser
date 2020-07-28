package com.census;

import org.junit.Test;
import org.junit.Assert;

import java.io.IOException;


public class CensusAnalyserTest {

        private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";

        @Test
        public void givenIndianCensusCSVFileReturnsCorrectRecords() {
            try {
                CensusAnalyser censusAnalyser = new CensusAnalyser();
                int numOfRecords = 0;
                numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
                Assert.assertEquals(29,numOfRecords);
            } catch (IOException e) { }
        }
    }

