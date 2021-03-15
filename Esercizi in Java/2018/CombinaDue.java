import java.util.Scanner;

public class CombinaDue {

  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);

    String s1 = input.nextLine();
    String s2 = input.nextLine();

    if (s1.length()<2 || s2.length()<2)
      System.out.println("ERRORE");
    else
      System.out.println(s1.substring(0,2) + s2.substring(0,2));

  }

}
