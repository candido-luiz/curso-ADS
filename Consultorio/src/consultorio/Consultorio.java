
package consultorio;

public class Consultorio {

 
    public static void main(String[] args) {
        Secretaria secretaria = new Secretaria();
        Paciente paciente = new Paciente("Joao", secretaria);
        Paciente paciente2 = new Paciente("Ze", secretaria);
        secretaria.setNome("Paula");
        secretaria.setRegistro(123);
        System.out.println(secretaria.getNome());
        
       
        
        
    }
    
}
