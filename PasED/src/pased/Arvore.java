package pased;

import java.io.Serializable;
import java.util.ArrayList;

public class Arvore implements Serializable{
    private Elemento raiz;
    
    public Arvore(){
        this.raiz = null;
    }
    
    public void adicionar(Colaborador valor){
        
        Elemento novoElemento = new Elemento(valor);
        if (raiz == null){
            this.raiz = novoElemento;
        }else{
            Elemento atual = this.raiz;
            while(true){
                if((novoElemento.getValor().getNome()).compareTo((atual.getValor().getNome())) < 0){
                    if (atual.getEsquerda() != null){
                        atual = atual.getEsquerda();
                    }else{
                        atual.setEsquerda(novoElemento);
                        break;
                    }
                }else{ 
                    if (atual.getDireita() != null){
                        atual = atual.getDireita();
                    }else{
                        atual.setDireita(novoElemento);
                        break;
                    }
                }
            }
        }
    }

    public Elemento getRaiz() {
        return raiz;
    }
    
    public void emOrdem(Elemento atual){
        if (atual != null){
            emOrdem(atual.getEsquerda());
            System.out.println(atual.getValor());
            emOrdem(atual.getDireita());
        }        
    }
    
    public Elemento buscar(String nome) {
        if (this.raiz == null) return null;
        Elemento atual = this.raiz;

        while ((atual.getValor().getNome()).compareTo(nome) != 0) {
          if(nome.compareTo(atual.getValor().getNome()) < 0){
              atual = atual.getEsquerda();
          }else{
            atual = atual.getDireita();
          }
          if (atual == null){
              return null;
          }
        } 
        return atual;
    }   
    
    public void buscarAmigo(Elemento atual, Colaborador colaborador2, ArrayList<Colaborador> amigosEmComum){
        if (atual != null){
            buscarAmigo(atual.getEsquerda(), colaborador2, amigosEmComum);
            
            Elemento buscado = colaborador2.getAmigos().buscar(atual.getValor().getNome());
            if(buscado != null){
                amigosEmComum.add(buscado.getValor());
            }
            buscarAmigo(atual.getDireita(), colaborador2, amigosEmComum);
        }    
    }


}