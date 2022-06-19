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

    public RomeNumber() {
    }
    public void expressionSeparated() {
        Scanner scanner = new Scanner(System.in);
        this.expression = scanner.nextLine();
        String[] expressionArray = this.expression.split("[^a-zA-Z0-9_]");
        this.firstNumber = expressionArray[0];
        this.secondNumber = expressionArray[1];
    }
    public int romeNumberToArabic(String romeNumber) {
        this.arabicNumber = 0;
        int[] arrayArabicNumber = new int[romeNumber.length()];

        for (int i = 0; i < romeNumber.length(); ++i) {
            if (romeNumber.charAt(i) == 'M') {
                arrayArabicNumber[i] = 1000;
            }

            if (romeNumber.charAt(i) == 'D') {
                arrayArabicNumber[i] = 500;
            }

            if (romeNumber.charAt(i) == 'C') {
                arrayArabicNumber[i] = 100;
            }

            if (romeNumber.charAt(i) == 'L') {
                arrayArabicNumber[i] = 50;
            }

            if (romeNumber.charAt(i) == 'X') {
                arrayArabicNumber[i] = 10;
            }

            if (romeNumber.charAt(i) == 'V') {
                arrayArabicNumber[i] = 5;
            }

            if (romeNumber.charAt(i) == 'I') {
                arrayArabicNumber[i] = 1;
            }

            this.arabicNumber += arrayArabicNumber[i];
            if (i != 0 && arrayArabicNumber[i] > arrayArabicNumber[i - 1]) {
                this.arabicNumber -= 2 * arrayArabicNumber[i - 1];
            }
        }

        return this.arabicNumber;
    }
    public int resultArabicExpression() {
        if (this.expression.contains("+")) {
            this.arabicResult = this.firstArabicNumber + this.secondArabicNumber;
        }

        if (this.expression.contains("-")) {
            this.arabicResult = this.firstArabicNumber - this.secondArabicNumber;
        }

        if (this.expression.contains("*")) {
            this.arabicResult = this.firstArabicNumber * this.secondArabicNumber;
        }

        if (this.expression.contains("/")) {
            this.arabicResult = this.firstArabicNumber / this.secondArabicNumber;
        }

        return this.arabicResult;
    }
    public String arabicNumberToRome(int arabicNumber) {
        String romeNumberResult;
        for (romeNumberResult = ""; arabicNumber >= 1000; arabicNumber -= 1000) {
            romeNumberResult = romeNumberResult + "M";
        }

        if (arabicNumber >= 900) {
            romeNumberResult = romeNumberResult + "CM";
            arabicNumber -= 900;
        }

        while (arabicNumber >= 500) {
            romeNumberResult = romeNumberResult + "D";
            arabicNumber -= 500;
        }

        if (arabicNumber >= 400) {
            romeNumberResult = romeNumberResult + "CD";
            arabicNumber -= 400;
        }

        while (arabicNumber >= 100) {
            romeNumberResult = romeNumberResult + "C";
            arabicNumber -= 100;
        }

        if (arabicNumber >= 90) {
            romeNumberResult = romeNumberResult + "XC";
            arabicNumber -= 90;
        }

        while (arabicNumber >= 50) {
            romeNumberResult = romeNumberResult + "L";
            arabicNumber -= 50;
        }

        if (arabicNumber >= 40) {
            romeNumberResult = romeNumberResult + "XL";
            arabicNumber -= 40;
        }

        while (arabicNumber >= 10) {
            romeNumberResult = romeNumberResult + "X";
            arabicNumber -= 10;
        }

        if (arabicNumber >= 9) {
            romeNumberResult = romeNumberResult + "IX";
            arabicNumber -= 9;
        }

        while (arabicNumber >= 5) {
            romeNumberResult = romeNumberResult + "V";
            arabicNumber -= 5;
        }

        if (arabicNumber >= 4) {
            romeNumberResult = romeNumberResult + "IV";
            arabicNumber -= 4;
        }

        while (arabicNumber >= 1) {
            romeNumberResult = romeNumberResult + "I";
            --arabicNumber;
        }

        return romeNumberResult;
    }
    public String resultRome() {
        this.firstArabicNumber = this.romeNumberToArabic(this.firstNumber);
        this.secondArabicNumber = this.romeNumberToArabic(this.secondNumber);
        this.romeResult = this.arabicNumberToRome(this.resultArabicExpression());
        return this.romeResult;
    }
}
