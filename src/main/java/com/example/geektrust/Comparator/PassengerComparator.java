package com.example.geektrust.Comparator;

import com.example.geektrust.Entities.PassengerDetails;
import java.util.Comparator;

public class PassengerComparator implements Comparator<PassengerDetails> {

    public int compare(PassengerDetails p1,PassengerDetails p2){

        if(p1.getCount() == p2.getCount()){

           if(p1.getPassengerType().name().charAt(0) > p2.getPassengerType().name().charAt(0)){
               return 1;
           }else{
               return -1;
           }
        }else if(p1.getCount() > p2.getCount()){
            return 0;
        }
            return  1;

    }
}