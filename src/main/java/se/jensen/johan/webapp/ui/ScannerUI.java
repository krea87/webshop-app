package se.jensen.johan.webapp.ui;

import java.util.Scanner;

public class ScannerUI implements UI{
    private  Scanner scanner = new Scanner(System.in);


    @Override
    public String prompt(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    @Override
    public void info(String message) {

    }

    @Override
    public String menu() {
        System.out.println("Select 1-4: \n " +
                "1. See all products \n" +
                "2. Add a product \n" +
                "3. Find product \n" +
                "4. Quit");
        return scanner.nextLine();
    }

    public void closeScanner(){
        scanner.close();
    }
}
