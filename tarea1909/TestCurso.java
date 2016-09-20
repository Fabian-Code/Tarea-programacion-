
public class TestCurso
{
    
    public TestCurso()
    {
       Curso sala = new Curso();       
       do{
           System.out.println(sala.toString());
           sala.menu();
           sala.setOpcion(sala.leerInt());
           sala.acciones();
        }while(sala.getOpcion()!=0);
    }
    
}
