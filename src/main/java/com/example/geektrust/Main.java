package com.example.geektrust;


import com.example.geektrust.Entities.CheckIn;
import com.example.geektrust.Enums.PassengerType;
import com.example.geektrust.Enums.Place;
import com.example.geektrust.Interfaces.ICheckInService;
import com.example.geektrust.Interfaces.IMetroCardService;
import com.example.geektrust.Interfaces.IPrintSummary;
import com.example.geektrust.Services.CheckInService;
import com.example.geektrust.Services.MetroCardService;
import com.example.geektrust.Services.PrintSummary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        IMetroCardService metroCardService = new MetroCardService();
        ICheckInService checkInService = new CheckInService(metroCardService);
        IPrintSummary printSummary = new PrintSummary(checkInService);
        //Sample code to read from file passed as command line argument
        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read
            while (sc.hasNextLine()) {
                //Add your code here to process input commands
                String[] input = sc.nextLine().split(" ", 2);
                switch (input[0]){
                    case "BALANCE":
                        String[] properties = input[1].split(" ",2);
                        metroCardService.addCard(properties[0], Integer.parseInt(properties[1]));
                        break;
                    case "CHECK_IN":
                        String[] check_properties = input[1].split(" ",3);
                        PassengerType passengerType = PassengerType.valueOf(check_properties[1]);

                       CheckIn checkIn = new CheckIn(check_properties[0], PassengerType.valueOf(check_properties[1]), Place.valueOf(check_properties[2]));
                        checkInService.checkIn(checkIn);
                        break;
                        case "PRINT_SUMMARY":
                            printSummary.printSummary();
                            break;
                    default:
                        break;
                }
            }
            sc.close(); // closes the scanner
        } catch (IOException e) {
        }

    }
}
