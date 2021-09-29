package com.calculator;
import java.util.*;

public class AnswerAssignmentCalculator {
    static List<String> mathProblem= new ArrayList<String>();
    static String tempChar = "";

    static boolean isOperator(char readNextChar){
        if(readNextChar == '+' || readNextChar == '-' || readNextChar == '/' || readNextChar == '*'){
            return true;
        }else return false;
    }

    static double addition(double firstNum, double secondNum){
        return firstNum + secondNum;
    }

    static double subtraction(double firstNum, double secondNum){
        return firstNum - secondNum;
    }

    static double multiplication(double firstNum, double secondNum){
        return firstNum * secondNum;
    }

    static double division(double firstNum, double secondNum){
        return firstNum / secondNum;
    }

    static double calculate(List<String> mathProblem){
        String getOperator = "";
        double total =0;

        //perhitungan
        for (int indexCharInMathProblem = 0; indexCharInMathProblem < mathProblem.size(); indexCharInMathProblem++) {
            getOperator = mathProblem.get(indexCharInMathProblem);

            if(getOperator.equals("+")){
                indexCharInMathProblem++;
                total = addition(total, Double.parseDouble(mathProblem.get(indexCharInMathProblem)));
            }else if(getOperator.equals("-")){
                indexCharInMathProblem++;
                total = subtraction(total, Double.parseDouble(mathProblem.get(indexCharInMathProblem)));
            }else if(getOperator.equals("/")){
                indexCharInMathProblem++;
                total = division(total, Double.parseDouble(mathProblem.get(indexCharInMathProblem)));
            }else if(getOperator.equals("*")){
                indexCharInMathProblem++;
                total = multiplication(total, Double.parseDouble(mathProblem.get(indexCharInMathProblem)));
            }else{
                total = Double.parseDouble(mathProblem.get(indexCharInMathProblem));
            }
        }
        return total;
    }

    static void addParsingChar(int indexParsingChar, String inputFromCommand){
        char readNextChar = inputFromCommand.charAt(indexParsingChar);
        if(isOperator(readNextChar)) {
            mathProblem.add(tempChar);
            mathProblem.add(String.valueOf(readNextChar));
            tempChar = "";
        } else {
            tempChar = tempChar + String.valueOf(readNextChar);
        }
    }

    static boolean isLastChar(int indexParsingChar, String inputFromCommand){
        if(indexParsingChar == inputFromCommand.length() - 1){
            return true;
        }else return false;
    }

    static void lastChar(int indexParsingChar,  String nextLine){
        if (isLastChar(indexParsingChar, nextLine)) {
            mathProblem.add(tempChar);
            tempChar = "";
        }
    }

    static void printResult(double total){
        total = calculate(mathProblem);
        System.out.println("** Result: " + total);
    }

    static String inputMathProblem(){
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Input number and operators that you want to calculate: ");
        String inputFromCommand = inputScanner.next();

        return inputFromCommand;
    }

    static void parsingStringToArray(String inputFromCommand){
        for (int indexParsingChar = 0; indexParsingChar < inputFromCommand.length(); indexParsingChar++) {
            addParsingChar(indexParsingChar, inputFromCommand);
            lastChar(indexParsingChar, inputFromCommand);
        }
    }

    public static void main(String args[]) {

        try {
            String inputFromCommand = inputMathProblem();
            double total = 0;

            //parsing input menjadi ArrayList berdasarkan angka dan operator
            parsingStringToArray(inputFromCommand);

            //perhitungan dan print result
            printResult(total);


        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
        }
    }

}
