import java.util.StringTokenizer;
import java.util.Scanner;

import java.util.*;
import java.io.*;

public class Ordered_Calculator {

    public static int flag = 0;

    public static void main(String[] args) {

        ArrayList<String> input = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your equation:" + "\n");

        while (!sc.hasNext("=")) {
            input.add(sc.next());
        }

        if (sc != null) {
            sc.close();
        }

        ArrayList<String> output = math(input);

        System.out.print(output + "\n");

    }

    public static ArrayList<String> math(ArrayList<String> args) {

        int index1 = 0;
        int index2 = 0;

        if (args.contains("(")) {
            ArrayList<Integer> indexOfBrackets = new ArrayList<>();

            for (int i = 0; i < args.size(); i++) {
                String value = args.get(i);
                if (value.equals("(")) {
                    indexOfBrackets.add(i);
                }
            }

            index1 = Collections.max(indexOfBrackets);

            if (args.contains(")") && args.indexOf(")") > index1) {
                index2 = args.indexOf(")");
            }
        }

        ArrayList<String> input = brackets(args, index1, index2);
        ArrayList<String> exponential = exponent(input);

        ArrayList<String> divided = new ArrayList<>();
        ArrayList<String> multiplied = new ArrayList<>();
        ArrayList<String> added = new ArrayList<>();
        ArrayList<String> output = new ArrayList<>();

        if ((args.contains("/") || args.contains("x")) && (args.indexOf("/") < args.indexOf("x"))) {
            divided = divide(exponential);
            multiplied = multiply(divided);
        } else if ((args.contains("/") || args.contains("x")) && (args.indexOf("x") < args.indexOf("/"))) {
            divided = multiply(exponential);
            multiplied = divide(divided);
        } else {
            divided = divide(exponential);
            multiplied = multiply(divided);
        }

        if ((args.contains("+") || args.contains("-")) && (args.indexOf("+") < args.indexOf("-"))) {
            added = add(multiplied);
            output = subtract(added);
        } else if ((args.contains("+") || args.contains("-")) && (args.indexOf("-") < args.indexOf("+"))) {
            added = subtract(multiplied);
            output = add(added);
        } else {
            added = add(multiplied);
            output = subtract(added);
        }

        return output;
    }

    public static ArrayList<String> brackets(ArrayList<String> args, Integer index1, Integer index2) {

        if (index2 == 0) {
            return args;
        }

        ArrayList<String> brackets = new ArrayList<>(args.subList(index1 + 1, index2));

        ArrayList<String> output = math(brackets);

        Iterator<String> itr = args.iterator();

        int i = 0;

        while (itr.hasNext() && i < (index2 - index1 + 1)) {
            String remove = itr.next();

            if (remove == args.get(index1)) {
                itr.remove();
                i++;
            }

        }

        args.addAll(index1, output);

        if (args.contains("(")) {
            math(args);
        }

        return args;

    }

    public static ArrayList<String> exponent(ArrayList<String> args) {
        if (args.contains("^")) {
            int index1 = args.indexOf("^");
            double base = Double.parseDouble(args.get(index1 - 1));
            double exponent = Double.parseDouble(args.get(index1 + 1));
            double value = Math.pow(base, exponent);

            Iterator<String> itr = args.iterator();

            int i = 0;

            while (itr.hasNext() && i < 3) {
                String remove = itr.next();

                if (remove == args.get(index1 - 1)) {
                    itr.remove();
                    i++;
                }

            }

            args.add(index1 - 1, Double.toString(value));

            if (args.contains("^")) {
                math(args);
            }

            return args;
        }

        else {
            return args;
        }
    }

    public static ArrayList<String> divide(ArrayList<String> args) {
        if (args.contains("/")) {
            int index1 = args.indexOf("/");
            double val1 = Double.parseDouble(args.get(index1 - 1));
            double val2 = Double.parseDouble(args.get(index1 + 1));
            double value = val1 / val2;

            Iterator<String> itr = args.iterator();

            int i = 0;

            while (itr.hasNext() && i < 3) {
                String remove = itr.next();

                if (remove == args.get(index1 - 1)) {
                    itr.remove();
                    i++;
                }

            }

            args.add(index1 - 1, Double.toString(value));

            if (args.contains("/")) {
                math(args);
            }

            return args;
        }

        else {
            return args;
        }
    }

    public static ArrayList<String> multiply(ArrayList<String> args) {
        if (args.contains("x")) {
            int index1 = args.indexOf("x");
            double val1 = Double.parseDouble(args.get(index1 - 1));
            double val2 = Double.parseDouble(args.get(index1 + 1));
            double value = val1 * val2;

            Iterator<String> itr = args.iterator();

            int i = 0;

            while (itr.hasNext() && i < 3) {
                String remove = itr.next();

                if (remove == args.get(index1 - 1)) {
                    itr.remove();
                    i++;
                }

            }

            args.add(index1 - 1, Double.toString(value));

            if (args.contains("x")) {
                math(args);
            }

            return args;
        }

        else {
            return args;
        }
    }

    public static ArrayList<String> add(ArrayList<String> args) {
        if (args.contains("+")) {
            int index1 = args.indexOf("+");
            double val1 = Double.parseDouble(args.get(index1 - 1));
            double val2 = Double.parseDouble(args.get(index1 + 1));
            double value = val1 + val2;

            Iterator<String> itr = args.iterator();

            int i = 0;

            while (itr.hasNext() && i < 3) {
                String remove = itr.next();

                if (remove == args.get(index1 - 1)) {
                    itr.remove();
                    i++;
                }

            }

            args.add(index1 - 1, Double.toString(value));

            if (args.contains("+")) {
                math(args);
            }

            return args;
        }

        else {
            return args;
        }
    }

    public static ArrayList<String> subtract(ArrayList<String> args) {
        if (args.contains("-")) {
            int index1 = args.indexOf("-");
            double val1 = Double.parseDouble(args.get(index1 - 1));
            double val2 = Double.parseDouble(args.get(index1 + 1));
            double value = val1 - val2;

            Iterator<String> itr = args.iterator();

            int i = 0;

            while (itr.hasNext() && i < 3) {
                String remove = itr.next();

                if (remove == args.get(index1 - 1)) {
                    itr.remove();
                    i++;
                }

            }

            args.add(index1 - 1, Double.toString(value));

            if (args.contains("-")) {
                math(args);
            }

            return args;
        }

        else {
            return args;
        }
    }

}