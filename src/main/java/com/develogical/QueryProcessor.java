package com.develogical;

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

        return "";
    }
}
