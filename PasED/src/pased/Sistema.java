package pased;

import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    static Scanner scan = new Scanner(System.in);
    
    public static void exibirMenu(){
        System.out.println("\n\nEscolha alguma das seguintes opções:");
        System.out.println("1 - Cadastrar Colaborador");
        System.out.println("2- Exibir Colaboradores");
        System.out.println("3 - Adicionar um amigo");
        System.out.println("4 - Compartilhar conteúdo");
        System.out.println("5 - Listar amigos");
        System.out.println("6 - Listar amigos em comum");
        System.out.println("7 - Listar postagens");
        System.out.println("8 - Sair do sistema");
    }
    
    public static void cadastrarColaborador(Arvore cadastros){
        System.out.print("\n Digite o nome do colaborador -> ");
        String nomeColaborador = scan.nextLine();
        cadastros.adicionar(new Colaborador(nomeColaborador));
    }
    
    public static void exibirColabores(Arvore cadastros){
        if(cadastros.getRaiz() == null){
            System.out.println("Nenhum colaborador cadastrado!");
        }else{
            System.out.println("Nome dos colaboradores cadastrados:");
            cadastros.emOrdem(cadastros.getRaiz());
        }
        
    }
    public static void adicionarAmigo(Arvore cadastros){
        System.out.print("Digite o nome do colaborador que deseja adicionar um amigo -> ");
        String nomeColaborador = scan.nextLine();
        
        if(cadastros.buscar(nomeColaborador) != null){
            
            Colaborador colaborador1 = cadastros.buscar(nomeColaborador).getValor();
            System.out.print("Digite o nome do amigo -> ");
            String nomeColaborador2 = scan.nextLine();
            
            if(cadastros.buscar(nomeColaborador2) != null){
                //alterar aqui embaixo
                if(colaborador1.getAmigos().buscar(nomeColaborador2) == null){
                
                //alterando aí em cima
                Colaborador colaborador2 = cadastros.buscar(nomeColaborador2).getValor();
                
                colaborador1.adicionarAmigo(colaborador2);
                colaborador2.adicionarAmigo(colaborador1);
                }else{//adicionei esse ELSE aqui também
                    System.out.println(nomeColaborador +" já adicionou " + nomeColaborador2 + " como amigo.");
                }
            }else{
                System.out.println("Colaborador não encontrado!");
            }
        }else{
            System.out.println("Colaborador não encontrado!");
        }
    }
    
    public static void compartilharConteudo(Arvore cadastros){
        Postagem postagem;
        System.out.print("Digite o nome do colaborador que deseja compartilhar um conteúdo -> ");
        String nomeColaborador = scan.nextLine();
        
        if(cadastros.buscar(nomeColaborador) != null){
            Colaborador colaborador = cadastros.buscar(nomeColaborador).getValor();
            System.out.print("Digite o conteúdo de sua postagem -> ");
            String conteudo = scan.nextLine();
            postagem = new Postagem(conteudo);
            
            System.out.print("Deseja marcar outros colaboradores (s para sim/ outra tecla para não)? -> ");
            String opcao = scan.nextLine();
            
            if("s".equals(opcao)){
                String colaboradorMarcado;
                boolean loop = true;
                while(loop){
                    System.out.print("Digite o nome do colaborador -> ");
                    colaboradorMarcado = scan.nextLine();
                    
                    if(cadastros.buscar(colaboradorMarcado) != null){
                        postagem.adicionarColaborador(cadastros.buscar(colaboradorMarcado).getValor());
                    }else{
                        System.out.println("Colaborador não encontrado!");
                    }
                    
                    System.out.print("Adicionar outro colaborador (s para sim/ outra tecla para não)? -> ");
                    opcao = scan.nextLine();
                    
                    if(!"s".equals(opcao)){
                        loop = false;
                    }
                }
            }
            
            colaborador.adicionarPostagem(postagem);
        }else{
            System.out.println("Colaborador não encontrado!");
        }
    }
    
    public static void listarAmigos(Arvore cadastros){
        System.out.print("Digite o nome do colaborar para ver sua lista de amigos -> ");
        String nomeColaborador = scan.nextLine();
        
        if(cadastros.buscar(nomeColaborador) != null){
            Colaborador colaborador = cadastros.buscar(nomeColaborador).getValor();
            colaborador.exibirAmigos();
        }else{
            System.out.println("Colaborador não encontrado!");
        }
    }
    
    public static void amigosEmComum(Arvore cadastros){
        System.out.print("Digite o nome do primeiro colaborador -> ");
        String nomeColaborador1 = scan.nextLine();
        
        if(cadastros.buscar(nomeColaborador1) != null){
            Colaborador colaborador1 = cadastros.buscar(nomeColaborador1).getValor();
            System.out.print("Digite o nome do segundo colaborador -> ");
            String nomeColaborador2 = scan.nextLine();
            if(cadastros.buscar(nomeColaborador2) != null){
                Colaborador colaborador2 = cadastros.buscar(nomeColaborador2).getValor();
                ArrayList<Colaborador> amigos = Sistema.ElementosEmComum(colaborador1, colaborador2);
                //Alterar aqui para o caso de não haver amigos em comum (Adicionar um else)
                if(amigos.size() != 0){
                    System.out.println("Os amigos em comum entre " + colaborador1.getNome() + "e " + colaborador2.getNome() + "são: ");
                    for(Colaborador amigo : amigos){
                        System.out.println(amigo);
                    }
                }else{
                    System.out.println("Os colaboradores " + colaborador1.getNome() + " e " + colaborador2.getNome() + " não possuem amigos em comum.");
                }
            }else{
                System.out.println("Colaborador não encontrado!");
            }
        }else{
            System.out.println("Colaborador não encontrado!");
        }
    }
    
    public static void listarPostagens(Arvore cadastros){
        System.out.print("Digite o nome do colaborador que deseja listar as postagens -> ");
        String nomeColaborador = scan.nextLine();
        
        if(cadastros.buscar(nomeColaborador) != null){
            Colaborador colaborador = cadastros.buscar(nomeColaborador).getValor();
            colaborador.exibirPostagens();
        }else{
            System.out.println("Colaborador não encontrado!");
        }
    }
    
    public static ArrayList<Colaborador> ElementosEmComum(Colaborador colaborador1, Colaborador colaborador2){
        Arvore arvoreAmigos = colaborador1.getAmigos();
        ArrayList<Colaborador> amigosEmComum = new ArrayList<Colaborador>();
        arvoreAmigos.buscarAmigo(arvoreAmigos.getRaiz(), colaborador2, amigosEmComum);
        return amigosEmComum;
    }
    
}
