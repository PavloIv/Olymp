package Dragon;

import java.util.Scanner;

//Умова задачі
//У кожної S-ніжки 1 голова. Знайти кількість ніг N у K-голового дракона, якщо разом у всіх A голів і B ніг.
//Вхідні дані
//4 числа: S, K, A, B. Всі числа не перевищують 1000
//Вихідні дані
//Кількість ніг у дракона. Якщо вхідні дані суперечні, вивести у вихідний файл -1, у випадку наявності декількох
// розв’язків – вивести довільний з них.
public class Dragon {
    Scanner scanner;
    int s;//millipedeFoot
    int k;//dragonHead
    int a;//allHead
    int b;//allFoot
    int n;//dragonFoot


    public Dragon() {
        this.scanner = new Scanner(System.in);
        System.out.println("Вкажіть кількість ніг багатоніжки");
        this.s = this.scanner.nextInt();
        System.out.println("Вкажіть кількість голів дракона");
        this.k = this.scanner.nextInt();
        System.out.println("Вкажіть загальну кількість голів");
        this.a = this.scanner.nextInt();
        System.out.println("Вкажіть загальну кількість ніг");
        this.b = this.scanner.nextInt();
        this.n = 0;
    }
    public int dragonFoot(){
        try {
            for (int i = 1; i <= a ; i++) {
                //i millipede numbers
                int j = (a-i)/k;//dragons numbers
                n = (b - s*i)/j;
                if (n >= 0 && n % 1 == 0 && ((i*s)+(j*n)) == b && (i + (j*k) == a)){
                    return n;
                }
            }
        }catch (ArithmeticException e){
           //nop
        }

        return -1;
    }
}
class Start{
    public static void main(String[] args) {
        Dragon gorynych = new Dragon();
        System.out.println("Кількість ніг у драконів :" + gorynych.dragonFoot());

    }
}
