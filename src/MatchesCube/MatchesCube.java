//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package MatchesCube;

import java.util.Scanner;

public class MatchesCube {
    Scanner scanner;
    int cubeNumber;
    int matches;
    public MatchesCube() {
        this.scanner = new Scanner(System.in);
        this.cubeNumber = this.scanner.nextInt();
        this.matches = 0;
    }
    public int matches() {
        if (this.cubeNumber == 1) {
            this.matches = 12;
        } else {
            this.matches = (this.cubeNumber - 1) * 8 + 12;
        }
        return this.matches;
    }
}
