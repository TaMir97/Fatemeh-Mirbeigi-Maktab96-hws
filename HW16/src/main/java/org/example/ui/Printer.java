package org.example.ui;

public class Printer {

    public static void printItem(String[] item, String title) {

        System.out.println("----------------------------");
        System.out.println("          " + title + "         ");
        System.out.println("----------------------------");
        for (int i = 0; i < item.length; i++) {
            System.out.println("|" + (i + 1) + " - " + item[i]);
        }

    }

}
