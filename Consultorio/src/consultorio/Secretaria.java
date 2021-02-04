
package consultorio;

import java.util.ArrayList;


public class Secretaria {
    private String nome;
    private int registro;
    public ArrayList<Paciente> pacientes;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }
    
    public void incluirPaciente(Paciente paciente){
        
        pacientes.add(paciente);
    }
    
    public void excluir(){
    
    }
    
    public void alterar(){
    
    }
    
    public Secretaria(){
        pacientes = new ArrayList<Paciente>();
    }
}
