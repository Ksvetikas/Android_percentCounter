package com.example.svetikaspercentcounter;


import android.annotation.SuppressLint;
import android.view.Gravity;
import android.widget.TextView;

public class Counter{

    public static double tip(double amount, int percent){

        double tip = (amount * ((double)percent / 100));
        return (double)Math.round(tip * 100) / 100;
    }

    @SuppressLint("SetTextI18n")
    public static void allResults(int seekBarValue, double value, String field, TextView[] findView){

        TextView tip = findView [0];
        TextView total = findView [1];
        TextView result = findView [2];

        if (value > 0){

            double tipValue = tip(value, seekBarValue);
            int tipValueInt = (int)Math.floor(tipValue);

            double totalValue = (double)Math.round((value - tipValue)* 100) / 100;
            int totalValueInt = (int) Math.floor(totalValue);
            double totalDecimal = (double)totalValue - totalValueInt;

            if (totalDecimal == 0) {
                tip.setText(String.valueOf(tipValueInt));
                total.setText(String.valueOf(totalValueInt));
                result.setText(result(field, tipValueInt, totalValueInt));

            }else {
                tip.setText(String.valueOf(tipValue));
                total.setText(String.valueOf(totalValue));
                result.setText(result(field, tipValue, totalValue));

            }

            result.setGravity(Gravity.START | Gravity.TOP);

        }else {
            tip.setText("");
            total.setText("");
            result.setText("Result");
            result.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        }
    }

    public static String result(String field, double tipValue, double totalValue){
        return ("Full amount = " + field + "\n" + "Tip amount = " + tipValue + "\n" +"Total = " + totalValue);
    }

    public static String result(String field, int tipValue, int totalValue){
        return ("Full amount = " + field + "\n" + "Tip amount = " + tipValue + "\n" +"Total = " + totalValue);
    }
}
