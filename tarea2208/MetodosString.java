/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosstring;
import java.util.Scanner;
import java.util.Arrays;
/**
 *
 * @author Fabian
 */
public class MetodosString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String cadena="";
        do {
            cadena = leerString();
            imprimirResultados(cadena);
        } while (continuar());                
    }
    
    public static boolean continuar(){
        String opc=leerString();        
        if (opc.equals("0")) {
            return false;
        }
        return true;
    }
    
    public static String leerString (){
        Scanner leer = new Scanner (System.in);        
        String cadena=leer.nextLine();
        return cadena;
    }
    
    public static int largoCadena (String str){
        int nCaracter = str.length();
        return nCaracter;
    }
    
    public static int contarVocales (String str){
        int contVocales=0;
        str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='i' || str.charAt(i)=='o' || str.charAt(i)=='u') {
                contVocales++;
            }
        }
        return contVocales;
    }
    
    public static int contarConsonantes(String str){
        int contCons=0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                contCons++;
            }
        }
        contCons= contCons-contarVocales(str);
        return contCons;
    }
    
    public static String invertirString(String str){
        String cadena="";
        for (int i = str.length()-1; i >=0; i--) {
            cadena = cadena + str.charAt(i);            
        }
        return cadena;
    }
    
    public static boolean existeChar(String str, char ch){
        for (int i = 0; i < str.length(); i++) {
            if (ch==str.charAt(i)) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean existeSubString (String str, String substr){
        if (substr.length()>str.length()) {
            return false;            
        }else{
            if (str.contains(substr)) {
                return true;
            }
        }
        return false;
    }
    
    public static char [] crearArrayChar(String str){
        char matrizChar[] = new char [str.length()];
        matrizChar= str.toCharArray();
        return matrizChar;
    } 
    
    public static void imprimirResultados(String str){
        char caracter;
        String substr;
        System.out.println("El largo de la cadena es "+largoCadena(str));
        System.out.println("La cantidad de vocales contenidas en la cadena es "+contarVocales(str));
        System.out.println("La cantidad de consonantes contenidas en la cadena es "+contarConsonantes(str));
        System.out.println("la cadena invertida es "+ invertirString(str));
        System.out.println("Ingrese un caracter");
        caracter = leerString().charAt(0);
        if (existeChar(str,caracter)) {
            System.out.println("El caracter SI se encuentra en la cadena");
        }else{
            System.out.println("El caracter NO se encuentra en la cadena");            
        }
        System.out.println("Ingrese una sub cadena");
        substr=leerString();
        if (existeSubString(str,substr)) {
            System.out.println("La subcadena SI se encuentra en la cadena");
        }else{
            System.out.println("La subcadena NO se encuentra en la cadena");            
        }
        System.out.println("La cadena como matriz es "+Arrays.toString(crearArrayChar(str)));        
        System.out.println("¿Desea ingresar otra cadena?. Ingrese 0 si quiere salir");
    }
}
