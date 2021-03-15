import java.util.Scanner;

public class TagliaEstremi {

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    String s = input.nextLine();

    if (s.length()>=3) {
      String sub = s.substring(1,s.length()-1);
      System.out.println(sub);
    }
  }

}
