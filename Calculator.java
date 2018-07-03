import java.util.StringTokenizer;
import java.util.Stack;

import java.util.*;
import java.io.*;

public class Calculator {
    public static void main(String[] args) {
        Stack<String> numbers = new Stack<>();
        Stack<String> operations = new Stack<>();
        Stack<String> brackets = new Stack<>();

        double result = Double.parseDouble(args[0]);
        String operation = "a";

        result = math();

        System.out.printf("%f%n", result);

    }

    public static double math (){
        for (int i = 0; i < args.length; i++) {
            if (args[i] == "(") {
                for (k=1; args[i+k] != ")"; k++){
                    if (args[i+k] == '('){
                        math (args[i+k]);
                    }                    
                    double val = evaluatebracket(args[i+k], args[i+1]);
                    value = Double.toString(val);
                    numbers.push(value);
                }                
            }
    
            else if (args[i] == "+") {
                operations.push(args[i]);
            }
    
            else if (args[i] == "-") {
                operations.push(args[i]);
            }
    
            else if (args[i] == "x") {
                operations.push(args[i]);
            }
    
            else if (args[i] == "/") {
                operations.push(args[i]);
            }
    
            else {
                numbers.push(args[i]);
            }
        }
    }

    public static double evaluatebracket(String Input, String Initial){

        operation = Input;
        double j;
        double result = Double.parseDouble(Initial);

        switch (operation) {

        case "+":
            j = Double.parseDouble(args[i + 1]);
            result += j;
            break;
            
        case "-":
            j = Double.parseDouble(args[i + 1]);
            result -= j;
            break;

        case "x":
            j = Double.parseDouble(args[i + 1]);
            result *= j;
            break;

        case "/":
            j = Double.parseDouble(args[i + 1]);
            result /= j;
            break;

        }

    }

}

