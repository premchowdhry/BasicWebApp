package com.develogical;

import java.util.ArrayList;

public class QueryProcessor {

    public static boolean isPrime(int num) {
        int i = 2;
        boolean flag = false;
        while (i <= num / 2) {
            // condition for nonprime number
            if (num % i == 0) {
                flag = true;
                break;
            }

            ++i;
        }
        return !flag;
    }

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        if (query.toLowerCase().contains("wordsworth")) {
            return "William Wordsworth (7 April 1770 – 23 April 1850) was an English " +
                    "Romantic poet who, with Samuel Taylor Coleridge, helped to launch the " +
                    "Romantic Age in English literature with their joint publication Lyrical Ballads (1798)";
        }
        if (query.toLowerCase().contains("what is your name")) {
            return "PRS";
        }
        if (query.toLowerCase().contains("dr no")) {
            return "Sean Connery";
        }
        if (query.toLowerCase().contains("theresa may")) {
            return "2016";
        }
        if (query.toLowerCase().contains("banana")) {
            return "yellow";
        }
        if (query.toLowerCase().contains("eiffel tower")) {
            return "Paris";
        }
        if (query.toLowerCase().contains("largest")) {
            String[] parts = query.split(":");
            String[] numbers = parts[1].split("[\\s,]+");
            int max = 0;
            for (String n : numbers) {
                try {
                    int num = Integer.valueOf(n);
                    max = Math.max(num, max);
                } catch (Exception e) {
                }
            }
            return String.valueOf(max);
        }
        if (query.toLowerCase().contains("prime")) {
            String[] parts = query.split(":");
            String[] numbers = parts[1].split("[\\s,]+");
            ArrayList<Integer> res = new ArrayList<>();
            for (String n : numbers) {
                System.out.println(n);
                try {
                    int num = Integer.valueOf(n);
                    if (isPrime(num)) {
                        System.out.println("is prime");
                        res.add(num);
                    }
                } catch (Exception e) {
                }
            }
            if (res.isEmpty()) {
                return "";
            }
            return res.toString().replace("[", "").replace("]", "");
        }
        if (query.toLowerCase().contains("plus")) {
            String[] parts = query.split(" ");
            int sum = 0;
            for (String n : parts) {
                try {
                    int num = Integer.valueOf(n);
                    sum += num;
                } catch (Exception e) {
                }
            }
            return String.valueOf(sum);
        }
        if (query.toLowerCase().contains("multiplied")) {
            String[] parts = query.split(" ");
            int prod = 1;
            for (String n : parts) {
                try {
                    int num = Integer.valueOf(n);
                    prod *= num;
                } catch (Exception e) {
                }
            }
            return String.valueOf(prod);
        }
        if (query.toLowerCase().contains("square and a cube")) {
            String[] parts = query.split(":");
            String[] numbers = parts[1].split("[\\s,]+");
            ArrayList<Integer> res = new ArrayList<>();
            for (String n : numbers) {
                try {
                    int num = Integer.valueOf(n);
                    double sqrt = Math.sqrt(num);
                    double cbrt = Math.cbrt(num);
                    if (sqrt == Math.floor(sqrt) && cbrt == Math.floor(cbrt)) {
                        res.add(num);
                    }
                } catch (Exception e) {
                }
            }
            if (res.isEmpty()) {
                return "";
            }
            return res.toString().replace("[", "").replace("]", "");
        }
        return "";
    }
}
