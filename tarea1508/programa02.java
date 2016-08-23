/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa02;
import java.util.Random;
import java.util.Arrays;
/**
 *
 * @author Fabian
 */
public class programa02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random azar = new Random();
        int a,b, sumD1=0,sumD2=0,cont=0;
        byte i;
        byte M[][] = new byte[3][3];
        for ( i = 1; i < 10; i++) {
            do {
                a=azar.nextInt(3);
                b=azar.nextInt(3);
            } while (M[a][b]!=0);
            M[a][b]=i;
        }
        for (int j = 0; j < 3; j++) {
            System.out.println(Arrays.toString(M[j]));
        }
        a=0;
        b=0;
        for ( i = 0; i < 3; i++) { 
            sumD1=M[i][a++];
            sumD2=M[b++][i];
            if (SumaFila(M,i)!=15 || SumaColumna(M,i)!=15 || sumD1!=0 || sumD2!=0) {
                cont++;
                break;
            }                
        }
        if (cont!=0) {
            System.out.println("No es un cuadrado magico");
        }
    }
    public static int SumaFila(byte [][]M, int i){
        int sum=0,j;
        for ( j = 0;j< 3; j++) {
            sum+=M[i][j];
        }
        return sum;
    }
    public static int SumaColumna(byte [][]M, int i){
        int sum=0,j;
        for ( j = 0;j< 3; j++) {
            sum+=M[j][i];
        }
        return sum;
    }
}
