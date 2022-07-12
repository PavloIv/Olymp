package Corruption;
//Задача 21
//З метою боротьби з тіньовою економікою банк запровадив об’єднання N рахунків фірми в один. За одну операцію
// об’єднуються 2 рахунки і банк автоматично відраховує на власний рахунок Р% від суми об’єднання за виконання
// операції та закриття одного з рахунків. Яка найбільша кількість коштів може залишитись на рахунку фірми? На
// кожному з рахунків до впровадження політики об’єднання було не більше ніж G грн.


import java.util.Arrays;
import java.util.Scanner;

public class Corruption {
    Scanner scanner;
    private String firstInputString;
    private String secondInputStream;
    private Integer numberAccount;
    private Integer procentComission;
    private float[] ArraySumOnAccount;
    public float result;

    public Corruption() {
        this.scanner = new Scanner(System.in);
        System.out.println("Вкажіть кількість рахунків та процент за операцію");
        System.out.println("Числа вказувати через один пробіл");
        this.firstInputString = scanner.nextLine();
        System.out.println("Вкажіть суми на рахунках");
        System.out.println("Числа вказувати через один пробіл");
        this.secondInputStream = scanner.nextLine();

        String[] temparyArrayFirstInputString = new String[2];
        temparyArrayFirstInputString = firstInputString.strip().split(" ");
        this.numberAccount = Integer.parseInt(temparyArrayFirstInputString[0]);
        this.procentComission = Integer.parseInt(temparyArrayFirstInputString[1]);

        String[] temparyArraySecondInputString = new String[numberAccount];
        temparyArraySecondInputString = secondInputStream.strip().split(" ");
        this.ArraySumOnAccount = new float[numberAccount];
        for (int i = 0; i < numberAccount; i++) {
            ArraySumOnAccount[i] = Float.parseFloat(temparyArraySecondInputString[i]);
        }
    }

    public float maxFinance() {
        int k = numberAccount;
        Arrays.sort(ArraySumOnAccount);
        while (k >= 2) {
            if (k % 2 == 0) {
                int j = 0;
                for (int i = 0; i < k; ) {
                    float procenComisionDec = (float) procentComission / 100;
                    float comissionIteration = (ArraySumOnAccount[i] + ArraySumOnAccount[i + 1]) * procenComisionDec;
                    ArraySumOnAccount[j] = (ArraySumOnAccount[i] + ArraySumOnAccount[i + 1] - comissionIteration);
                    j++;
                    i = i + 2;
                }
                k = k / 2;
            }
            if (k % 2 != 0) {
                int j = 1;
                for (int i = 0; i < k - 1; ) {
                    float procenComisionDec = (float) procentComission / 100;
                    float comissionIteration = (ArraySumOnAccount[i] + ArraySumOnAccount[i + 1]) * procenComisionDec;
                    ArraySumOnAccount[j] = (ArraySumOnAccount[i] + ArraySumOnAccount[i + 1] - comissionIteration);
                    j++;
                    i = i + 2;
                }
                ArraySumOnAccount[0] = ArraySumOnAccount[k - 1];
                k = (k + 1) / 2;
            }
            result = ArraySumOnAccount[0];
        }

        return result;
    }
}

class Start {
    public static void main(String[] args) {
        Corruption firmOne = new Corruption();
        System.out.println("Максимум грошей залишиться" + firmOne.maxFinance());

    }
}