package com.census;

public class CensusAnalyserException extends Exception{

    enum ExceptionType {
        CENSUS_FILE_PROBLEM,UNABLE_TO_PARSE,INCORRECT_DELIMITER_OR_INCORRECT_HEADER;
    }

    ExceptionType type;

    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public CensusAnalyserException(String message, String name) {
        super(message);
        this.type=ExceptionType.valueOf(name);
    }

}
