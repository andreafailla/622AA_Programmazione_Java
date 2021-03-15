import java.util.Scanner;

public class Lunghezza {

  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);

    String s = input.nextLine();
    int n = input.nextInt();

    if (controlla(s,n))
      System.out.println("SI");
    else
      System.out.println("NO");

  }

  private static boolean controlla(String s, int n) {
    return s.length()==n;
  }

}
