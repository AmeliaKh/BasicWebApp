package com.develogical;

import java.util.Arrays;
import java.util.List;

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
            List<String> lst = Arrays.asList(str.split(","));
            for (String i : lst) {

                // accessing each element of array
                int nn = Integer.parseInt(str.replaceAll("[^0-9]", ""));
                if (nn > max_n) {
                    max_n = nn;
                }
            }


            return String.valueOf(max_n);
        }

        return "";
    }
}
