import java.util.StringTokenizer;
import java.util.Stack;

import java.util.*;
import java.io.*;

public class Ordered_Calculator {

    public static Stack<String> input = new Stack<>();
    public static Stack<String> brackets = new Stack<>();
          
    
    public static void main(String[] args) {
        double output = Double.parseDouble(args[0]);
                
        for (int i = 0; i < args.length; i++) {
            input.push(args[i]); 
        }

        math(input); 

        output = calculate(args[i], i, args, output);

        System.out.print(input.toString() + "\n");
        System.out.print(output + "\n");
                
    }

    public static void math(Stack input){
        brackets(input);
        exponent(input);
        divide(input);
        multiply(input);
        add(input);
        subtract(input);
    }

    public static void brackets(Stack args) {
        
        for (int i = 0; i < args.length; i++) {
            if (args[i] == '('){
                brackets.push();

            } 
        }

    }

    public static void exponent(Stack args) {

    }

    public static void divide(Stack args) {

    }

    public static void multiply(Stack args) {

    }

    public static void add(Stack args) {

    }

    public static void subtract(Stack args) {

    }

}