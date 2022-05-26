package RomeNumber;

import java.util.Scanner;

public class RomeNumber {
    String expression = "";
    String firstNumber = "";
    String secondNumber = "";
    int arabicNumber;
    int firstArabicNumber;
    int secondArabicNumber;
    int arabicResult;
    String romeResult;
    public void expressionSeparated(){
        Scanner scanner = new Scanner(System.in);
        expression = scanner.nextLine();
        String [] expressionArray = expression.split("[^a-zA-Z0-9_]");
        firstNumber = expressionArray[0];
        secondNumber = expressionArray[1];
    }
    public int romeNumberToArabic(String romeNumber){
        arabicNumber = 0;

     int[] arrayArabicNumber = new int[romeNumber.length()];

     for (int i = 0; i < romeNumber.length(); i++) {
         if (romeNumber.charAt(i) =='M'){
             arrayArabicNumber[i] = 1000;
         }
         if (romeNumber.charAt(i) =='D'){
             arrayArabicNumber[i] = 500;
         }
         if (romeNumber.charAt(i) =='C'){
             arrayArabicNumber[i] = 100;
         }
         if (romeNumber.charAt(i) =='L'){
             arrayArabicNumber[i] = 50;
         }
         if (romeNumber.charAt(i) =='X'){
             arrayArabicNumber[i] = 10;
         }
         if (romeNumber.charAt(i) =='V'){
             arrayArabicNumber[i] = 5;
         }
         if (romeNumber.charAt(i) =='I'){
             arrayArabicNumber[i] = 1;
         }
         arabicNumber += arrayArabicNumber[i];
         if ( i !=0 && arrayArabicNumber[i] > arrayArabicNumber[i-1] ){
             arabicNumber -= (2 * arrayArabicNumber[i-1]);
         }
     }
     return arabicNumber;
    }
    public int resultArabicExpression(){
        if (expression.contains("+")){
            arabicResult = firstArabicNumber + secondArabicNumber;
        }
        if (expression.contains("-")){
            arabicResult = firstArabicNumber - secondArabicNumber;
        }
        if (expression.contains("*")){
            arabicResult = firstArabicNumber * secondArabicNumber;
        }
        if (expression.contains("/")){
            arabicResult = firstArabicNumber / secondArabicNumber;
        }
        return arabicResult;
    }
    public String arabicNumberToRome(int arabicNumber){
     String romeNumberResult = "";
     for (;arabicNumber >= 1000; ){
         romeNumberResult += "M";
         arabicNumber = arabicNumber - 1000;
     }
     if (arabicNumber >= 900){
         romeNumberResult += "CM";
         arabicNumber -= 900;
     }
     for (;arabicNumber >= 500; ){
         romeNumberResult += "D";
         arabicNumber = arabicNumber - 500;
     }
     if (arabicNumber >= 400) {
         romeNumberResult += "CD";
         arabicNumber -= 400;
     }
     for (;arabicNumber >= 100;){
         romeNumberResult += "C";
         arabicNumber = arabicNumber - 100;
     }
     if (arabicNumber >= 90) {
         romeNumberResult += "XC";
         arabicNumber -= 90;
     }
     for (;arabicNumber >= 50;){
         romeNumberResult += "L";
         arabicNumber = arabicNumber - 50;
     }
     if (arabicNumber >= 40) {
         romeNumberResult += "XL";
         arabicNumber -= 40;
     }
     for (;arabicNumber >= 10;){
         romeNumberResult += "X";
         arabicNumber = arabicNumber - 10;
     }
     if (arabicNumber >= 9) {
         romeNumberResult += "IX";
         arabicNumber -= 9;
     }
     for (;arabicNumber >= 5;){
         romeNumberResult += "V";
         arabicNumber = arabicNumber - 5;
     }
     if (arabicNumber >= 4) {
         romeNumberResult += "IV";
         arabicNumber -= 4;
     }
     for (;arabicNumber >= 1;){
         romeNumberResult += "I";
         arabicNumber = arabicNumber - 1;
     }
    return romeNumberResult;
    }
    public String resultRome(){
        firstArabicNumber = romeNumberToArabic(firstNumber);
        secondArabicNumber = romeNumberToArabic(secondNumber);
        romeResult = arabicNumberToRome(resultArabicExpression());
        return romeResult;
    }
}
       public class Start{
            public static void main(String[] args) {
                RomeNumber romeNumber = new RomeNumber();
                romeNumber.expressionSeparated();
                romeNumber.resultRome();
                System.out.println(romeNumber.resultRome());
            }
        }
