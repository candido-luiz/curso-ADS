
package consultorio;

public class Paciente {
    private String nome;
    private String telefone;
    private Secretaria secretaria;
    public Paciente(String nome, Secretaria secretaria){
        this.nome = nome;
        this.secretaria = secretaria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
        
}
