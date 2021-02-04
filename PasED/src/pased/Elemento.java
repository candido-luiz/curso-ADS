package pased;

import java.io.Serializable;

public class Elemento implements Serializable{
    private Colaborador valor;
    private Elemento esquerda;
    private Elemento direita;
    
    public Elemento(Colaborador novoValor){
        this.valor = novoValor;
        this.esquerda = null;
        this.direita = null;
    }

    public Colaborador getValor() {
        return valor;
    }

    public void setValor(Colaborador valor) {
        this.valor = valor;
    }

    public Elemento getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Elemento esquerda) {
        this.esquerda = esquerda;
    }

    public Elemento getDireita() {
        return direita;
    }

    public void setDireita(Elemento direita) {
        this.direita = direita;
    }

    @Override
    public String toString() {
        return "Elemento{" + "valor=" + valor + ", esquerda=" + esquerda + ", direita=" + direita + '}';
    }
    
    
}