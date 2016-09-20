import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;

public class Curso
{
    ArrayList <Alumno> Curso = new ArrayList <Alumno>();
    private int opcion;
    Scanner leer = new Scanner(System.in);
    
    public Curso()
    {                
        opcion=0;
    }
    
    public void menu(){
        System.out.println("1 - Ingresar un nuevo Alumno");
        System.out.println("2 - Eliminar Alumno");
        System.out.println("3 - Buscar Alumno según rut");
        System.out.println("0 - Salir");
    }
    
    public void acciones(){
        switch(opcion){
            case 1: IngresarAl();
            break;
            
            case 2: System.out.println("Ingrese numero de matricula");
            eliminarAl();
            break;
            
            case 3:
                    String matricula;
                    do{
                        matricula= leer.next();
                    }while(!validarMatricula(matricula));
                    if(buscarAlumno(matricula)!=-1){
                        System.out.println(Curso.get(buscarAlumno(matricula)).toString());
                    }else{
                        System.out.println("No existe");
                    }
            break;
            
            default: break;
        }
    }
    
    public void eliminarAl(){//Se pueden eliminar por matricula
        String matricula;
        do{
            matricula= leer.next();
        }while(!validarMatricula(matricula));
        
        if(buscarAlumno(matricula)!=-1){
            System.out.println(Curso.get(buscarAlumno(matricula)).toString());
            System.out.print("Eliminado\n");
            Curso.remove(buscarAlumno(matricula));
        }else{
            System.out.println("No existe");
        }
    }
    
    public int buscarAlumno(String matricula){
        
        for(int i=0; i<Curso.size(); i++){
            if(Curso.get(i).getNumMatricula().equals(matricula)){//Si encuentra la matricula en el curso retorna la posicion en la que se encuentra
                return i;
            }
        }
        return -1;//Si no lo encuentra retorna -1
    }
    
    public boolean validarMatricula(String m){
        if(!validarRut(m.substring(0,m.length()-2))){
            return false;
        }else{
            if(!(Character.isDigit(m.charAt(m.length()-2)) && Character.isDigit(m.charAt(m.length()-1)))){//Si los ultimos 2 numeros no son numeros
                return false;
            }
        }
        return true;
    }
    
    public int leerInt(){
        int cont,num=0;
        do{
            cont =0;
            try{
                num=Integer.parseInt(leer.next());
            }catch(NumberFormatException e1){
                cont++;
            }            
        }while(cont!=0);
        return num;
    }
    
    public void IngresarAl(){
        Alumno alumno = new Alumno();
        System.out.println("Nombre: ");
        alumno.setNombre(leer.next());
        System.out.println("Apellido: ");
        alumno.setApellido(leer.next());
        System.out.println("Rut: ");
        alumno.setRut(ingresaRut());
        //Se asume que la matricula es el año de ingreso del estudiante(en este caso el año 2016)
        alumno.setNumMatricula(alumno.getRut()+año());
        Curso.add(alumno);
    }
    
    public String año(){
        Calendar fecha = Calendar.getInstance();
        String año;
        año =""+fecha.get(Calendar.YEAR);
        return año.substring(año.length()-2,año.length());
    }
    
    public String ingresaRut(){
        String rut="";
        do{
            rut=leer.next();
            rut= rut.replace(".","").replace("-","").toLowerCase();                        
        }while(!validarRut(rut));
        return rut;
    }
    
    public boolean validarRut(String rut){
        int aux=0;
         if(rut.substring(0,rut.length()-1).length()<8){
                System.out.println("Ingrese nuevamente");
                return false;
            }else{
                try{
                    aux= Integer.parseInt(rut.substring(0,rut.length()-2));
                }catch(NumberFormatException e1){
                    System.out.println("Ingrese nuevamente");
                    return false;
                }
                if(aux!=0 && !Character.isLetterOrDigit(rut.charAt(rut.length()-1))){
                    System.out.println("Ingrese nuevamente");
                    return false;
                }
            }   
         return true;
    }
    
    public int getOpcion(){
        return this.opcion;
    }
    
    public void setOpcion(int newOp){        
        this.opcion= newOp;
    }
    
    public String toString(){
        return "Curso: \n"+Curso.toString();
    }
}