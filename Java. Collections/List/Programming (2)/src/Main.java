import java.util.*;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) {

    List<String> nameList = new ArrayList<>(Arrays.asList("Mr.Green", "Mr.Yellow", "Mr.Red"));


    //write your code here
    String[] strArray = nameList.stream().toArray(String[]::new);

    for (int i = 0; i < strArray.length; i++) {
      System.out.println(strArray[i]);
    }

  }
}