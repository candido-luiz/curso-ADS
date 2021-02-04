package pased;

import java.io.Serializable;
import java.util.ArrayList;

public class Colaborador implements Serializable{
    private String nome;
    private ArrayList<Postagem> postagens = new ArrayList<Postagem>();
    private Arvore amigos = new Arvore();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Arvore getAmigos() {
        return amigos;
    }
    
    @Override
    public String toString() {
        return nome ;
    }

    public Colaborador(String nome) {
        this.nome = nome;
    }

    int compareTo(Colaborador valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void adicionarAmigo(Colaborador amigo){
        this.amigos.adicionar(amigo);
    }
    
    public void exibirAmigos(){
        if(this.amigos.getRaiz() != null){
            this.amigos.emOrdem(amigos.getRaiz());
        }else{
            System.out.println(this.nome + " ainda não tem amigos adicionados.");
        }
    }

    public void adicionarPostagem(Postagem postagem){
        this.postagens.add(postagem);
    }
    public void exibirPostagens(){
        if(this.postagens != null){
            for (Postagem postagem : this.postagens){
                System.out.println(postagem);
            }
        }else{
            System.out.println("Esse colaborador não possui postagens!");
        }
    }
    
  
}
