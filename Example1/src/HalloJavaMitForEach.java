import java.util.ArrayList;
import java.util.List;

public class HalloJavaMitForEach {


    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        stringList.add("Str1");
        stringList.add("Str2");
        stringList.add("Str3");
        stringList.add("Str4");
        System.out.println("Normal ausgeben");
        for (String str : stringList) {
            System.out.println(str);
        }
        System.out.println("Mit forEach ausgeben");
        stringList.forEach (s -> System.out.println(s));
    }
}
