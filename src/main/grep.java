package main;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class grep {
    private List<String> string;
    private boolean ignoreCase;

    public grep(String path, boolean ignoreCase) {
        this.ignoreCase = ignoreCase;
        try {
            this.string = Files.readAllLines(Paths.get(path));
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }

    }

    private List<String> searchInString(String regex, boolean invert) {
        List<String> result = new ArrayList<>();
        if (ignoreCase) {
            regex = regex.toLowerCase();
        }
        Pattern p = Pattern.compile(regex);
        for (String strings : string) {
            String testString = strings;
            if (ignoreCase) {
                testString = testString.toLowerCase();
            }
            if (p.matcher(testString).find() != invert) {
                result.add(testString);
            }
        }

        return result;
    }

    public List<String> rRegex(String regex) {
        return searchInString(regex, false);
    }

    public List<String> vRegex(String regex) {
        return searchInString(regex, true);
    }

}