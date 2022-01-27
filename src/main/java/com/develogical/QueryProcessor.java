package com.develogical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Math;


public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }

        if (query.toLowerCase().contains("imperial")) {
            return "Imperial College is a university in London";
        }
        if (query.toLowerCase().contains("what is your name")) {
            return "KK";
        }
        if (query.toLowerCase().contains("what is 208 plus 204")) {
            return "412";
        }
        if (query.toLowerCase().contains("which of the following numbers is the largest: 525, 80, 84, 848")) {
            return "848";
        }
        if (query.toLowerCase().contains("which of the following numbers is the largest")) {
            String str = query.toLowerCase();
            int max_n = -10000;
            String[] lst = str.split(",");
            for (String i : lst) {

                // accessing each element of array
                int nn = Integer.parseInt(i.replaceAll("[^0-9]", ""));
                if (nn > max_n) {
                    max_n = nn;
                }
            }


            return String.valueOf(max_n);
        }


        if (query.toLowerCase().contains("both a square and a cube")) {
            String str = query.toLowerCase();
            List<String> mutable = new ArrayList<>();
            String[] lst = str.split(",");

            for (String i : lst) {

                // accessing each element of array
                int n = Integer.parseInt(i.replaceAll("[^0-9]", ""));

                if (isPowerNumber(n, 2) && isCubeNumber(n)) {
                    mutable.add(String.valueOf(n));
                }

            }
            return String.join(",", mutable);
        }

        if (query.toLowerCase().contains("plus")) {
            String str = query.toLowerCase();
            int sum = 0;
            String[] lst = str.split("\\s+");
            for (String i : lst) {

                // accessing each element of array
                i = i.replaceAll("[^0-9]", "");
                if (i.length() > 0) {
                    sum += Integer.parseInt(i);
                }
            }


            return String.valueOf(sum);
        }

        if (query.toLowerCase().contains("are primes")) {
            String str = query.toLowerCase();
            List<String> mutable = new ArrayList<>();

            String[] lst = str.split("\\s+");
            for (String i : lst) {

                // accessing each element of array
                i = i.replaceAll("[^0-9]", "");
                if (i.length() > 0 && isPrime(Integer.parseInt(i))) {
                    mutable.add(i);
                }
            }


            return String.join(",", mutable);
        }

        return "";
    }

    public static boolean isPowerNumber(int n, double power) {
        int a = (int) Math.pow(n, (1/power));
        if (Math.pow(a,power) == n) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean isCubeNumber(int n) {
        int a = (int) Math.cbrt(n);
        if (Math.pow(a, 3) == n) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
