public class SommaSeguenti {

  public static void main(String[] args) {

    int[] numeri = {3,-5,3,4,11,2,9,4,3,2};

    boolean trovato = false;

    /* PRIMA SOLUZIONE - CICLI ANNIDATI*/

    /* 
    for (int i=0; i<numeri.length; i++) {  //OK anche se si mette numeri.length-1
      int somma=0;
      for (int j=i+1; j<numeri.length; j++) {
        somma+=numeri[j];
      }
      if (somma==numeri[i])
        trovato=true;
    }
    if (trovato) 
      System.out.println("OK");
    */


    /* SECONDA SOLUZIONE - CICLI ANNIDATI CON INTERRUZIONE */

    /*
    int i=0;
    while (i<numeri.length && !trovato) { //OK anche se si mette numeri.length-1
      int somma=0;
      for (int j=i+1; j<numeri.length; j++) { 
        somma+=numeri[j];
      }
      if (somma==numeri[i])
        trovato=true;
      i++;
    }
    if (trovato)
      System.out.println("OK");
    */    

    /* TERZA SOLUZIONE - SCANSIONE SEQUENZIALE DAL FONDO */
    
    int somma=0;
    for (int i=numeri.length-1; i>=0; i--) {
      if (numeri[i]==somma)
        trovato=true;
      else
        somma+=numeri[i];
    }
    if (trovato)
      System.out.println("OK");

  }


}
