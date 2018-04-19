import main.grep;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class grep_test {

    @Test
    void searchInString() {
        grep grep = new grep("input.txt", true);
        List<String> exp = new ArrayList<>();
        exp.add("blabla car");
        exp.add("me-blabla car");
        assertEquals(exp, grep.rRegex(("(blabla)")));
        assertEquals(exp, grep.rRegex(("blabla")));
        List<String> exp1 = new ArrayList<>();
        grep grep1 = new grep("input.txt", false);
        exp1.add("fhfhg");
        exp1.add("ERrfsf");
        exp1.add("ME-BLabla car");
        assertEquals(exp1, grep1.vRegex("blabla"));
    }
}

