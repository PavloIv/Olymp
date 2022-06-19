package Numbers;

import java.util.Scanner;

public class Numbers {
    public Numbers() {
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        Integer num = in.nextInt();
        System.out.println(num.toString().length());
        in.close();
    }
}