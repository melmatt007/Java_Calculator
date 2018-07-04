import java.util.StringTokenizer;
import java.util.Stack;

import java.util.*;
import java.io.*;

public class Ordered_Calculator {
        
    
    public static void main(String[] args) {
        double output = Double.parseDouble(args[0]);
                
        math(args); 

        output = calculate(args[i], i, args, output);

        System.out.print(input.toString() + "\n");
        System.out.print(output + "\n");
                
    }

    public static void math(String[] args){
        brackets(args);
        String [] exponential = exponent(args);
        String [] divided = divide(exponential);
        String [] multiplied = multiply(divided);
        String [] added = add(multiplied);
        String [] subtracted = subtract(added);
    }

    public static void brackets(String[] args) {
        
        for (int i = 0; i < args.length; i++) {
            if (args[i] == '('){
                for (int k=1; args[i+k] != ')'; k++){
                    String [] brackets = args[i+k];
                }
                math(brackets);
            } 
        }

    }

    public static String exponent(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i] == '^'){
                double base =  Double.parseDouble(args[i-1]);
                double exponent =  Double.parseDouble(args[i+1]);
                double value = Math.pow(base, exponent);

                //String [] exponential = 
            }
        }
    }

    public static String divide(String[] args) {

    }

    public static String multiply(String[] args) {

    }

    public static String add(String[] args) {

    }

    public static String subtract(String[] args) {

    }

}