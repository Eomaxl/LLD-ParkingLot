package com.eomaxl;

public class OutputPrinter {

    public void Welcome() {
        printWithNewLine("Welcome to PFR Parking lot.");
    }

    public void end() {
        printWithNewLine("Thanks for using PFR Parking lot");
    }

    public void notFound() {
        printWithNewLine("Not found");
    }

    public void statusHeader() {
        printWithNewLine("Slot No. Registration No  Color");
    }

    public void parkingLotFull(){
        printWithNewLine("Sorry, parking lot is full");
    }

    public void parkingLotEmpty(){
        printWithNewLine("Parking lot is empty");
    }

    public void invalidFile(){
        printWithNewLine("Invalid file");
    }

    public void printWithNewLine(final String msg){System.out.println(msg);}
}