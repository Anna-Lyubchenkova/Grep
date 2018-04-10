package main;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class grep {
    private List<String> string;
    private boolean ignoreCase;

    public grep(String path){
        try {
            this.string = Files.readAllLines(Paths.get(path));
            //System.out.println(string.size()+" lolol");
        }
        catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }

    }
    public List<String> searchInString(String regex, int key) {
        List<String> result = new ArrayList<>();
        if(ignoreCase){
            regex = regex.toLowerCase();
        }
        Pattern p = Pattern.compile(regex);
        for(String strings : string){
            String testString = strings;
            if(ignoreCase){
                testString=testString.toLowerCase();
            }
            if((p.matcher(testString).find()&& key==1)||(!p.matcher(testString).find()&& key==2)){
                result.add(testString);
            }
             //чисто метод String
//            System.out.println(regex);
//            if ((testString.matches("(.*)"+regex+"(.*)") && key==1) || (!testString.matches(regex) && key==2))
//                result.add(testString);
        }

        return result;
    }
    public List<String> rRegex(String regex){
        return searchInString(regex,1);
    }
    public List<String> vRegex(String regex){
        return searchInString(regex,2);
    }
    public void thisIgnoreCase(boolean ignoreCase){
        this.ignoreCase = ignoreCase;
    }

}