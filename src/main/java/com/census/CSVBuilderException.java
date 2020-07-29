package com.census;

public class CSVBuilderException extends Exception {

    enum ExceptionType {
        CENSUS_FILE_PROBLEM,UNABLE_TO_PARSE,INCORRECT_DELIMITER_OR_INCORRECT_HEADER;
    }

   ExceptionType type;

    public CSVBuilderException(String message, ExceptionType type) {
        super(message);
        this.type=type;

    }

}
