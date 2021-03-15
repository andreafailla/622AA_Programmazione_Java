import java.util.Scanner;

public class IniziaConA {

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    String s = input.nextLine();

    if (controlla(s,'a') || controlla(s,'A'))
      System.out.println("SI");
    else
      System.out.println("NO");
    
  }

  public static boolean controlla(String str, char c) {

    return (str.charAt(0)==c);

  }

}
