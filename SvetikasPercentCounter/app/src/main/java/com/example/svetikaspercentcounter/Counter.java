package com.example.svetikaspercentcounter;


public class Counter {

    public static double tip(double amount, int percent){

        double tip = (amount * ((double)percent / 100));
        return (double)Math.round(tip * 100) / 100;
    }

    public static String result(String field, double tipValue, double totalValue){
        return ("Full amount = " + field + "\n" + "Tip amount = " + tipValue + "\n" +"Total = " + totalValue);
    }
}
