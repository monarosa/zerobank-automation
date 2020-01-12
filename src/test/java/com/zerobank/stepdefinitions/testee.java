package com.zerobank.stepdefinitions;


import java.time.LocalDate;

public class testee {
    public static void main(String[] args) {
        String dateDrom = "2012-09-01";
        LocalDate localDate = LocalDate.parse(dateDrom);
        System.out.println(localDate);

        String dateDromLast = "2015-09-01";
        LocalDate localDate1 = LocalDate.parse(dateDromLast);


        System.out.println(localDate.isBefore(localDate1));
    }
}
