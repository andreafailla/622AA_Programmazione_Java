import java.util.Scanner;

public class TreZeri {

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    int somma = 0;
    int contazeri = 0;
    
    do {
      int n = input.nextInt();
      somma+=n;
      if (n==0) 
        contazeri++;
      else 
        contazeri=0;

    } while (contazeri<3);

    System.out.println(somma);
  }

}
