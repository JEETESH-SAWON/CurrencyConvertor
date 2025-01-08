package org.example;

import java.io.IOException;

// Main method of a program
public class Main {
    public static void main(String[] args) throws IOException {
        DataFetcher.datafetch();
        new CurrencyConvertor();
    }
}