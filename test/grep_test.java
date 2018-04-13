import main.grep;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class grep_test {
    private grep grep = new grep("input.txt");

    @Test
    void searchInString() {
        List<String> exp = new ArrayList<>();
        exp.add("blabla car");
        exp.add("me-blabla car");
        grep.thisIgnoreCase(true);
        assertEquals(exp, grep.rRegex(("(blabla)")));
        assertEquals(exp, grep.rRegex(("blabla")));
        List<String> exp1 = new ArrayList<>();
        exp1.add("fhfhg");
        exp1.add("ERrfsf");
        exp1.add("ME-BLabla car");
        grep.thisIgnoreCase(false);
        assertEquals(exp1, grep.vRegex("blabla"));
    }
}

