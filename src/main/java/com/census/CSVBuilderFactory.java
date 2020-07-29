package com.census;

public class CSVBuilderFactory {
    public static ICSVBuilder createCSVBuilder() {
       return new OpenCSVBuilder();
    }
}
