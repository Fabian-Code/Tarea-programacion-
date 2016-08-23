/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa01;
import java.util.Scanner;
/**
 *
 * @author Fabian
 */
public class programa01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Cantidad de Hombres o mujeres encuestados");
        int n= leerInt();
        int i=0,j=0;
        char encuestas [][]= new char[2][n];       
        String resp="";
        do {
            do {                
                System.out.println("Hombre o Mujer (1=hombre , 2=mujer)");
                n=leerInt();
                if (i>=encuestas[0].length && n==1) {
                    System.out.println("Error!! - Cantidad de hombres sobrepasada");                    
                }else{
                    if (j>=encuestas[0].length && n==2) {
                        System.out.println("Error!! - Cantidad de mujeres sobrepasada");                        
                    }
                }
            } while((n!=1 || i>=encuestas[0].length) && (n!=2 || j>=encuestas[0].length));
            System.out.println("¿Aprueba la gestion del Gobierno?");
            System.out.println("'s' : si aprueba la gestión del gobierno");
            System.out.println("'n' : no aprueba la gestión del gobierno");
            System.out.println("'x' : no sabe o no responde ");
            if (n==1) {                
                encuestas [0][i++]=leerOpcion();
            }else{
                encuestas [1][j++]=leerOpcion();
            }            
            do {
                System.out.println("¿Continuar haciendo encuestas?(si/no)");
                resp= leer.next();
            } while (!(resp.equals("si")|| resp.equals("no")));
            if (resp.equals("no")) {
                break;
            }
        } while (i!=encuestas[0].length || j!=encuestas[0].length);        
        System.out.println("Cantidad de hombres que aprueban la gestion del gobierno");
        System.out.println(CantAprueban(encuestas,"s".charAt(0),0));
        System.out.println("Cantidad de mujeres que desaprueban la gestión del gobierno");
        System.out.println(CantAprueban(encuestas,"n".charAt(0),1));
        System.out.println("Porsentaje de encuestados que aprueba la gestion del gobierno");
        PorcAprueba(encuestas);
        System.out.println("Cantidad de personas que participaron en la encuesta");
        System.out.println(CantEncuestados(encuestas));
    }
    public static int leerInt (){
        Scanner leer = new Scanner(System.in);
        int num=0, error;
        do {
            error=0;
            try{
                num= Integer.parseInt(leer.next());                
            }catch(NumberFormatException e1){
                System.out.println("Error!! - Ingrese el dato nuevamente");
                error++;
            }
        } while (error!=0);
        return num;
    }
    public static char leerOpcion (){
        Scanner leer = new Scanner(System.in);
        char eleccion=0;
        do {            
            eleccion = (leer.next()).charAt(0);
            if ("n".charAt(0)!=eleccion && "s".charAt(0)!=eleccion && "x".charAt(0)!=eleccion) {
                System.out.println("Error!! - Ingrese nuevamente su elección");
            }
        } while("n".charAt(0)!=eleccion && "s".charAt(0)!=eleccion && "x".charAt(0)!=eleccion);        
        return eleccion;
    }
    public static int CantAprueban (char [][]M, char op, int i){
        int cont=0,j;       
        for (j = 0; j < M[0].length; j++) {
            if (op==M[i][j]) {
                cont++;
            }
        }        
        return cont;
    }
    public static void PorcAprueba (char [][]m){
        float cant= CantAprueban(m,"s".charAt(0),0)+CantAprueban(m,"s".charAt(0),1);
        cant = cant*100/CantEncuestados(m);
        System.out.println(cant+"%");
    }
    public static int CantEncuestados (char [][]matriz){
        int cont=0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j]!=0) {
                    cont++;
                }
            }
        }
        return cont;
    }
}
