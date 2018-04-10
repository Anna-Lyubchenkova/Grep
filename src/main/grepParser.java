package main;

import java.util.Scanner;

public class grepParser {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] string =in.nextLine().split(" ");
        boolean grep = false;
        boolean vRegex = false;
        boolean rRegex = false;
        boolean ignoreCase = false;
        String fileName = null;
        String word = null;
        for (String elem:string) {
            switch (elem) {
                case "grep":
                    grep = true;
                    break;
                case "-v":
                    vRegex = true;
                    break;
                case "-r":
                    rRegex = true;
                    break;
                case "-i":
                    ignoreCase = true;
                    break;
                default:
                    if (elem.matches("(.*).txt"))
                        fileName = elem;
                    else
                        word = elem;
                    break;
            }
        }
        try {
            grep g = new grep(fileName);
            if (grep && word != null){
                if(ignoreCase){
                    g.thisIgnoreCase(ignoreCase);
                }
                if(vRegex){
                    System.out.println(g.vRegex(word));
                }
                else
                    System.out.println(g.rRegex(word));
            }
            else{
                System.out.println("некоректный ввод");
                System.exit(0);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("некорректный ввод");
        }
    }
}
