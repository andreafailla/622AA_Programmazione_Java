import java.util.Scanner;

public class SommaSePositivi {

  public static void main(String[] args) {
    
    Scanner input = new Scanner(System.in);

    int n;
    int somma=0;
    boolean negativo=false;

    do {
      n=input.nextInt();
      somma+=n;
      if (n<0) negativo=true;
    } while (n!=0);

    if (negativo)
      System.out.println("Inserito negativo");
    else
      System.out.println(somma);

  }

}
