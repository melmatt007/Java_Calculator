import java.util.StringTokenizer;
import java.util.Scanner;

import java.util.*;
import java.io.*;

public class Ordered_Calculator {

    public static int flag = 0;
        
    public static void main(String[] args) {

        ArrayList<String> input = new ArrayList<>();

        Scanner sc=new Scanner(System.in);

        System.out.print("Enter your equation:" + "\n");

        while (!sc.hasNext("=")){
            input.add(sc.next());
        }              
           
        
        ArrayList<String> output = math(input); 

        System.out.print(input + "\n");
        System.out.print(output + "\n");
                
    }

    public static ArrayList<String> math(ArrayList<String> args){
        ArrayList<String> value = brackets(args);
        ArrayList<String> exponential = exponent(value);
        ArrayList<String> divided = divide(exponential);
        ArrayList<String> multiplied = multiply(divided);
        ArrayList<String> added = add(multiplied);
        ArrayList<String> subtracted = subtract(added);
        ArrayList<String> output = renew(input, subtracted);
        return output; 
    }

    public static ArrayList<String> brackets(ArrayList<String> args) {
        if (args.contains("(")){
            int index1 = args.indexOf("(");

            if(args.contains(")")){
                int index2 = args.indexOf(")");
                ArrayList<String> brackets = new ArrayList<>(args.subList(index1+1, index2));
                System.out.print(brackets + "\n");
                flag = 1;
                //args.add(Integer.toString(index1));
                //args.add(Integer.toString(index2));

                ArrayList<String> output = math(brackets);
                
                for (int i = index1; i <= index2; i++){
                    args.remove(i);
                }
                args.addAll(index1, output);
                
                return args;                           
                
            }


        }

        else {
            return args;
        }
     

    }

    public static ArrayList<String> exponent(ArrayList<String> args) {
        if (args.contains("^")){
            int index1 = args.indexOf("^");
            double base =  Double.parseDouble(args.object(index1-1));
            double exponent =  Double.parseDouble(args.object(index1+1));
            double value = Math.pow(base, exponent);
            
            args.remove(subList(index1-1,index1+1));
            args.add(index1-1, Double.toString(value));
            return args; 
        }

        else {
            return args; 
        }
    }

    public static ArrayList<String> divide(ArrayList<String> args) {
        if (args.contains("/")){
            int index1 = args.indexOf("/");
            double value = args.object(index1-1)/args.object(index1+1);
            
            args.remove(subList(index1-1,index1+1));
            args.add(index1-1, Double.toString(value));
            return args; 
        }

        else {
            return args; 
        }
    }

    public static ArrayList<String> multiply(ArrayList<String> args) {
        if (args.contains("x")){
            int index1 = args.indexOf("x");
            double value = args.object(index1-1)*args.object(index1+1);
            
            args.remove(subList(index1-1,index1+1));
            args.add(index1-1, Double.toString(value));
            return args; 
        }

        else {
            return args; 
        }
    }

    public static ArrayList<String> add(ArrayList<String> args) {
        if (args.contains("+")){
            int index1 = args.indexOf("+");
            double value = args.object(index1-1)+args.object(index1+1);
            
            args.remove(subList(index1-1,index1+1));
            args.add(index1-1, Double.toString(value));
            return args; 
        }

        else {
            return args; 
        }
    }

    public static ArrayList<String> subtract(ArrayList<String> args) {
        if (args.contains("-")){
            int index1 = args.indexOf("-");
            double value = args.object(index1-1)-args.object(index1+1);
            
            args.remove(subList(index1-1,index1+1));
            args.add(index1-1, Double.toString(value));
            return args; 
        }

        else {
            return args; 
        }
    }

    public static ArrayList<String> renew(ArrayList<String> args, ArrayList<String> subtracted) {
        if (flag == 1){
            int index1 = args.get(args.size()-1);
            int index2 = args.get(args.size());
            args.remove(args.size()-1);
            args.remove(args.size());
            args.remove(subList(index1,index2));

            args.addAll(index1, subtracted);
            math(args);
        }

        else {
            return subtracted; 
        }
    }

}