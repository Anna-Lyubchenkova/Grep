package main;


import java.util.List;

public class grepParser {
    public static void main(String[] args) {
        boolean vRegex = false;
        boolean rRegex = false;
        boolean ignoreCase = false;
        String fileName = null;
        String word = null;
        for (int i = 0; i < args.length - 2; i++) {
            switch (args[i]) {
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
                    System.out.println("некоректный ввод");
                    System.exit(1);

            }
        }
        if (args.length >= 2) {
            word = args[args.length - 2];
            fileName = args[args.length - 1];
        } else {
            System.out.println("некоректный ввод");
            System.exit(1);
        }
        if (!rRegex) {
            word = "\\Q" + word + "\\E";
        }
        try {
            grep g = new grep(fileName, ignoreCase);
            if (word != null) {
                if (vRegex) {
                    printStrings(g.vRegex(word));
                } else
                    printStrings(g.rRegex(word));
            } else {
                System.out.println("некоректный ввод");
                System.exit(1);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("некорректный ввод");
        }
    }

    static void printStrings(List<String> stringList) {
        for (String s : stringList) {
            System.out.println(s);
        }
    }
}
