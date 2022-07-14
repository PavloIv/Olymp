package InternationalOlimpic;
//Міжнародна олімпіада з інформатики проводиться кожного року, починаючи з 1989-го року.
//        На першій олімпіаді 1989-го був лише один тур з однією задачею.
//        Наступні три роки (1990-1992 роки) олімпіада уже проходила у два тури, на кожному
//        з яких було по одній задачі.
//        У 1993-му році було два тури. На першому було три задачі, а в другому лише одна.
//        Починаючи з 1994-го року, на олімпіаді було по два тури, на кожному з яких було по три задачі.
//        Єдиним виключенням є 2009 та 2010 роки, у яких на кожному турі було по чотири задачі.
//        Вам дано рік проведення Міжнародної олімпіади з інформатики, визначте кількість задач,
//        які були на цій олімпіаді.

import java.util.Scanner;

public class InternationalOlimpic {
    Scanner scanner;
    int year;
    int result;

    public InternationalOlimpic() {
        scanner = new Scanner(System.in);
        System.out.println("Вкажіть рік олімпіади");
        this.year = scanner.nextInt();
    }
    public int numberChallenge(){
        if (year == 1989){result = 1;}
        if (year >= 1990 && year <= 1992){result = 2;}
        if (year == 1993){result = 4;}
        if (year >= 1994 && year <= 2021 && year != 2009 && year != 2010){result = 6;}
        if (year == 2009 || year == 2010){result = 8;}
        return result;
    }
}

class Start{
    public static void main(String[] args) {
        InternationalOlimpic informatic = new InternationalOlimpic();
        System.out.printf("В %d році  було %d задач",informatic.year,informatic.numberChallenge());
    }
}