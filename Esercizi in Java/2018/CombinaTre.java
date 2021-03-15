import java.util.Scanner;

public class CombinaTre {

  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);

    String s1 = input.nextLine();
    String s2 = input.nextLine();

    if (s1.length()<3 || s2.length()<3)
      System.out.println("ERRORE");
    else
      System.out.println(s1.substring(0,3) + s2.substring(0,3));

  }

}
