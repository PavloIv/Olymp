//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package EasyTask;

import java.util.Scanner;

public class EasyTask {
    public EasyTask() {
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int num = in.nextInt();
        System.out.println(num / 10 + " " + num % 10);
        in.close();
    }
}
