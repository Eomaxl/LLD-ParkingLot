package com.eomaxl;

public class OutputPrinter {

    public void welcome() {
        System.out.println("Welcome to PFR Parking lot.");
    }

    public void end() {
        printWithNewLine("Thanks for using PFR Parking lot service.");
    }

    public void notFound() {
        printWithNewLine("Not found");
    }

    public void statusHeader() {
        printWithNewLine("Slot No.    Registration No    Colour");
    }

    public void parkingLotFull() {
        printWithNewLine("Sorry, parking lot is full");
    }

    public void parkingLotEmpty() {
        printWithNewLine("Parking lot is empty");
    }

    public void invalidFile() {
        System.out.println("Invalid file given.");
    }

    public void printWithNewLine(final String msg) {
        System.out.println(msg);
    }
}