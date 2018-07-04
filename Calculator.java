import java.util.StringTokenizer;
import java.util.Stack;

import java.util.*;
import java.io.*;

public class Calculator {

    public static Stack<String> numbers = new Stack<>();
    public static Stack<String> operations = new Stack<>();
       
    
    public static void main(String[] args) {
        double output = Double.parseDouble(args[0]);
                
        for (int i = 0; i < args.length; i++) {
            math(args[i]);
            output = calculate(args[i], i, args, output); 
        }

        System.out.print(numbers.toString() + "\n");
        System.out.print(operations.toString() + "\n");
        System.out.print(output + "\n");
                
    }

    public static void math(String input) {

        if (input.equals("+")) {
            operations.push(input);
        }

        else if (input.equals("-")) {
            operations.push(input);
        }

        else if (input.equals("x")) {
            operations.push(input);
        }

        else if (input.equals("/")) {
            operations.push(input);
        }

        else {
            numbers.push(input);
        }

    }

    public static double calculate(String input, int i, String[] args, double result){
        double value;
        
        
        if (input.equals("+")) {
            value =  Double.parseDouble(args[i+1]);
            result += value;
        }

        else if (input.equals("-")) {
            value =  Double.parseDouble(args[i+1]);
            result -= value;
        }

        else if (input.equals("x")) {
            value =  Double.parseDouble(args[i+1]);
            result *= value;
        }

        else if (input.equals("/")) {
            value =  Double.parseDouble(args[i+1]);
            result /= value;
        }

        return result;
        
    }



}

