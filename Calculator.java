import java.util.StringTokenizer;
import java.util.Stack;

import java.util.*;
import java.io.*;



public class Calculator {

    public static Stack<String> numbers = new Stack<>();
    public static Stack<String> operations = new Stack<>();
    
    public static void main(String[] args) {
        double result = Double.parseDouble(args[0]);
        double output; 
        String operation = "a";


        for (int i = 0; i < args.length; i++) {
            math(args[i]);
        }
        System.out.printf("%f%n", result);

    }

    public static void math(String input) {

        if (input == "+") {
            operations.push(input);
        }

        else if (input == "-") {
            operations.push(input);
        }

        else if (input == "x") {
            operations.push(input);
        }

        else if (input == "/") {
            operations.push(input);
        }

        else {
            numbers.push(input);
        }

    }



}

