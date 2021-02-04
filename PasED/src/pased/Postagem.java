package pased;

import java.io.Serializable;
import java.util.ArrayList;

public class Postagem implements Serializable{
    private String conteudo;
    private ArrayList<Colaborador> colaboradoresMarcados = new ArrayList<Colaborador>(); //talvez seja um ArrayList<String> e add o nome do 

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
    
    public void adicionarColaborador(Colaborador colaboradorMarcado){
        this.colaboradoresMarcados.add(colaboradorMarcado);
    }
    
    public Postagem(String conteudo){
        this.conteudo = conteudo;
    }

    @Override
    public String toString() {
        return "conteudo=" + conteudo + ", colaboradoresMarcados=" + colaboradoresMarcados;
    }
    
}
