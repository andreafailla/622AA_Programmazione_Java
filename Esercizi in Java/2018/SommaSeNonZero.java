import java.util.Scanner;

public class SommaSeNonZero {

  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);

    int n;
    int somma=0;
    boolean zero=false;

    do {
      n=input.nextInt();
      if (n>0) somma+=n;
      if (n==0) zero=true;
    } while (n>=0);

    if (zero)
      System.out.println("Inserito zero");
    else
      System.out.println(somma);

  }

}
