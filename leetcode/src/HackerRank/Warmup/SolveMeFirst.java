package HackerRank.Warmup;
import java.util.*;

/**
 * Created by HuaZ on 10/8/2017.

 Welcome to HackerRank! The purpose of this challenge is to familiarize you with reading input
 from stdin (the standard input stream) and writing output to stdout (the standard output stream)
 using our environment.

 Review the code provided in the editor below, then complete the solveMeFirst function so that
 it returns the sum of two integers read from stdin. Take some time to understand this code
 so you're prepared to write it yourself in future challenges.

 Select a language below, and start coding!

 Input Format

 Code that reads input from stdin is provided for you in the editor.
 There are lines of input, and each line contains a single integer.

 Output Format

 Code that prints the sum calculated and returned by solveMeFirst is provided for you in the editor.

 */



public class SolveMeFirst {
    static int solveMeFirst(int a, int b) {
        // Hint: Type return a+b; below
        return a+b;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a;
        a = in.nextInt();
        int b;
        b = in.nextInt();
        int sum;
        sum = solveMeFirst(a, b);
        System.out.println(sum);
    }
}

