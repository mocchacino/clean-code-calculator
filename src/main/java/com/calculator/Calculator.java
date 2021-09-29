package com.calculator;

import java.util.*;

class Calculator {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input number and operators that you want to calculate: ");

        try {
            String nextLine = in.next();
            List<String> nuOps= new ArrayList<String>();

            //parsing input menjadi ArrayList berdasarkan angka dan operator
            String temp = "";
            for (int i = 0; i < nextLine.length(); i++) {
                if(nextLine.charAt(i) == '+' || nextLine.charAt(i) == '-' || nextLine.charAt(i) == '/') {
                    nuOps.add(temp);
                    nuOps.add(String.valueOf(nextLine.charAt(i)));

                    temp = "";
                } else {
                    temp = temp + String.valueOf(nextLine.charAt(i));
                }

                if (i == nextLine.length() - 1) {
                    nuOps.add(temp);
                    temp = "";
                }
            }

            //perhitungan
            double t = 0;
            for (int i = 0; i < nuOps.size(); i++) {
                switch (nuOps.get(i)) {
                    case "+":
                        i++;
                        t = t + Double.parseDouble(nuOps.get(i));
                        break;
                    case "-":
                        i++;
                        t = t - Double.parseDouble(nuOps.get(i));
                        break;
                    case "/":
                        i++;
                        t = t / Double.parseDouble(nuOps.get(i));
                        break;
                    default:
                        t = Double.parseDouble(nuOps.get(i));
                }
            }

            System.out.println("** Result: " + t);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }
}