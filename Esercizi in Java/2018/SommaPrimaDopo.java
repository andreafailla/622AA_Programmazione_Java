import java.util.Scanner;

public class SommaPrimaDopo {

  public static void main(String[] args) {
    
    int[] numeri = {8,0,-4,11,5,9,4,6,2,-8};

    boolean trovato=false;

    for (int i=1; i<9; i++) {
      if (numeri[i]==numeri[i-1]+numeri[i+1])
        trovato=true;
    }

    /* SOLUZIONE ALTERNATIVA (interrompe il ciclo se trovato==true)
     *
     * int i=1;
     * do {
     *   if (numeri[i]==numeri[i-1]+numeri[i+1])
     *     trovato=true;
     *   i++;
     * } while (i<9 && !trovato);
     */


    if (trovato)
      System.out.println("OK");
    else
      System.out.println("NO");

  }

}


