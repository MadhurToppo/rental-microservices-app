import java.util.*;

public class Main {

  public static void main(String[] args) {


    List<String> nameList = new ArrayList<>(Arrays.asList("Mr.Green", "Mr.Yellow", "Mr.Red"));

    //write your code here
    nameList.stream().forEach((c) -> System.out.println(c));
  }
}