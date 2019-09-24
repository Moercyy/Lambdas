package mm.morisch;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static java.lang.StrictMath.sqrt;
import static java.util.stream.LongStream.rangeClosed;

public class NumberTester {
    public interface NumberTest {
        boolean computeTest(int n);
    }


    String FILE = "file.txt";
    Map<Integer, String> map = new HashMap<>();
    String filename;

    public NumberTester(String filename) {
        filename = FILE;
        File file = new File(filename);
        testFile();
    }

    public void setSetOddEvenTester(NumberTest oddTester) {
        oddTester = new NumberTest() {
            @Override
            public boolean computeTest(int n) {
                return (n % 2) == 0;
            }
        };

    }

    public void setPrimeTester(NumberTest primeTester) {
        primeTester = new NumberTest() {
            @Override
            public boolean computeTest(int n) {
                return n > 1 && rangeClosed(2, (int) sqrt(n)).noneMatch(divisor -> n % divisor == 0);
            }
        };

    }

    public void setPalindromeTester(NumberTest palindromeTester) {
        palindromeTester = new NumberTest() {
            @Override
            public boolean computeTest(int n) {
                String result = "";
                for (int i = n + "".length() - 1; i >= 0; i--)
                    result += n + "".charAt(i);
                return result.equals(n + "");
            }
        };
    }


    public void testFile() {

        try (BufferedReader br = Files.newBufferedReader(Paths.get(FILE))) {
            String line;
            String seperator = " ";
            String[] words;
            while ((line = br.readLine()) != null) {
                words = line.split(seperator);
                map.put(Integer.parseInt(words[0]), (words[1]));
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        NumberTest isEven = (n) -> (n % 2) == 0;
        NumberTest isPrime = (o) -> o > 1 && rangeClosed(2, (int) sqrt(o)).noneMatch(divisor -> o % divisor == 0);
        NumberTest palindromeTester;
        palindromeTester = n -> {
            String result = "";
            for (int i = n + "".length() - 1; i >= 0; i--)
                result += n + "".charAt(i);
            if (result.equals(n + "")) {
                return true;
            } else
                return false;
        };

        Map<Integer, String> fMap = new HashMap<>();

        for (Integer key : map.keySet()) {
            switch (key) {
                case 1:
                    //System.out.println(isEven.computeTest(5));
                    boolean num = isEven.computeTest(Integer.parseInt(map.get(key)));
                    if (num) {
                        map.put(key, "EVEN");
                    } else {
                        map.put(key, "ODD");
                    }
                    break;
                case 2:
                    boolean num2 = isPrime.computeTest(Integer.parseInt(map.get(key)));
                    if (num2) {
                        map.put(key, "IS PRIME");
                    } else {
                        map.put(key, "IS NO PRIME");
                    }
                    break;
                case 3:
                    boolean num3 = palindromeTester.computeTest(Integer.parseInt(map.get(key)));
                    if (num3) {
                        map.put(key, "IS PALINDROME");
                    } else {
                        map.put(key, "IS NO PALINDRONE");
                    }
                    break;
            }
        }
        try {
            FileWriter fw = new FileWriter(new File("fileanswers.txt"));

            for (Integer key : map.keySet()) {
                fw.write(key + " " + map.get(key));
            }
            fw.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
