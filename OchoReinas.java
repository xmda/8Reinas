/**
 * @(#)Ocho_Reinas.java
 *
 *
 * @author 
 * @version 1.00 2014/4/10
 */

import java.util.Scanner;
 import java.util.Random;

 public class OchoReinas

 {        
 Scanner entrada = new Scanner(System.in);
 Random aleatorio = new Random();
 private int Tamano;
 
 private int Fracasos_Requeridos = 100;
 private int dado1;
 private int dado2;
 private int contador_reinas = 0;


 public void Principal()
 {   
 int accesibilidad;

 System.out.println("\n =====PROGRAMA DE LAS 8 REINAS=====");
 System.out.print("\n Ingrese la cantiidad de casillas que contendrá el tablero.\n");
 Tamano = entrada.nextInt();
 int fracasos = 0;
 int A[][] = new int[Tamano + 1][Tamano + 1];

 while ( Tamano > contador_reinas && fracasos < Fracasos_Requeridos)
 {
 Genera_Casilla(); 
 accesibilidad =  Verifica_Posicion(A);
 if ( 0 == accesibilidad )
 fracasos++;
 else
 A[dado1][dado2] = ++contador_reinas;
 }

 if ( Tamano != contador_reinas)
 System.out.printf("\n No se pudieron colocar todas las reinas, Solo se colocaron %d reinas\n", contador_reinas);
 else
 System.out.printf("\nSE COLOCARON LAS %d REINAS!\n", Tamano);


 Imprime(A);

 }   

 
 public void Genera_Casilla()
 {         
 dado1 = aleatorio.nextInt(Tamano) + 1;
 dado2 = aleatorio.nextInt(Tamano) + 1;
 }

 public int Verifica_Posicion(int B[][] )
 {        
 int estatus = 1;

 if ( 0 == B[dado1][dado2] )
 // Si la casilla generada esta vacia
 {          // Abre if  
 for ( int i = 1; i <= Tamano; i++ )
 for ( int j = 1; j <= Tamano; j++ )
 {  // Abre for  Si la casilla tiene una reina
 if ( 0 != B[i][j] )
 {       // Abre if  Si la reina ataca la misma fila o columna
 if ((( dado1 == i) || (dado2 == j ))  || (Math.abs(dado1 - i) == Math.abs(dado2 - j )) )
 // Retorna Negativo
 {
 estatus = 0;
 break;
 }
 }     
 }   

 }   
 else
 // Si la casilla generada no esta vacia, esta no es viable
 estatus = 0;

 return estatus; // retorna el estatus de la casilla
 
 }       

 

 public void Imprime(int C[][]) // imprime las casillas y las reinas colocas.
 {   

 for ( int k = 1; k <= Tamano; k++ )
 {
 for ( int j = 1; j <= Tamano; j++)
 {
 System.out.printf("%5d", C[k][j]);
 } 
 System.out.println("\n");
 }
 }    

} 