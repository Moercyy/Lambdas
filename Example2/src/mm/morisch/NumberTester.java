package mm.morisch;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static java.lang.StrictMath.sqrt;
import static java.util.stream.LongStream.rangeClosed;

public class NumberTester {
    public interface NumberTest{
        boolean computeTest(int n);
    }


    String FILE = "file.txt";
    Map<Integer, String> map = new HashMap<>();
    String filename;
    public NumberTester(String filename){
        filename = FILE;
        File file = new File(filename);
        testFile();
    }

    public void setSetOddEvenTester(NumberTest oddTester){
       oddTester = new NumberTest() {
           @Override
           public boolean computeTest(int n) {
               return (n % 2) == 0;
           }
       };

    }
    public void setPrimeTester(NumberTest primeTester){
        primeTester = new NumberTest() {
            @Override
            public boolean computeTest(int n) {
                return n > 1 && rangeClosed(2, (int) sqrt(n)).noneMatch(divisor -> n % divisor == 0);
            }
        };

    }
    public void setPalindromeTester(NumberTest palindromeTester){
        palindromeTester = new NumberTest() {
            @Override
            public boolean computeTest(int n) {
                String result = "";
                for(int i = n+"".length()-1; i >= 0; i--)
                    result += n+"".charAt(i);
                return result.equals(n+"");
            }
        };
    }
    public void testFile(){

        try (BufferedReader br = Files.newBufferedReader(Paths.get(FILE))) {
            String line;
            String seperator = " ";
            String[] words;
            while ((line = br.readLine()) != null) {
                words = line.split(seperator);
                map.put(Integer.parseInt(words[0]), words[1]);
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }



    }
}
