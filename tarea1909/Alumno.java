
public class Alumno
{
    // instance variables - replace the example below with your own
    private String nombre;
    private String apellido;
    private String rut;
    private String numMatricula;    
   
    public Alumno()
    {
       nombre = "";
       apellido = "";
       rut = "";
       numMatricula="";
    }
    
    public Alumno(String name, String lastName, String nRut, String matricula){
        nombre = name;
        apellido = lastName;
        rut = nRut;
        numMatricula = matricula;
    }
    
    public String getNombre(){
       return this.nombre;
   }
    
   public void setNombre(String newName){
       newName = newName.toLowerCase();
       newName = newName.substring(0,1).toUpperCase() + newName.substring(1,newName.length());
        this.nombre = newName;
   }
   
   public String getApellido(){
       return this.apellido;
    }
   
    public void setApellido(String newApellido){
        newApellido = newApellido.toLowerCase();
        newApellido = newApellido.substring(0,1).toUpperCase() + newApellido.substring(1,newApellido.length());
        this.apellido=newApellido;
    }
    
    public String getRut(){
        return this.rut;
    }
    
    public void setRut(String newRut){
        this.rut = newRut;
    }
    
    public String getNumMatricula(){
        return this.numMatricula;
    }
    
    public void setNumMatricula(String matricula){
        this.numMatricula = matricula;
    }
    
    
    
    public String toString(){
        return "Nombre: "+nombre+" " +apellido+"\nRut: "+rut+"\nNumero de Matricula: "+numMatricula+
        "\n------------------------------------------------------------------------------------------------\n";
    }
        
}
