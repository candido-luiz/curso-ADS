package pased;

import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PasED {

    public static void main(String[] args) {
        
        List<Arvore> arvores = new ArrayList<Arvore>();
        arvores = (List<Arvore>)FileUtil.recuperarObjeto(arvores, "arvores.txt");
        
        Arvore cadastros = new Arvore();
        if(arvores.size() == 0){
            arvores.add(cadastros);
        }
        cadastros = arvores.get(0);

        boolean loop = true;
        while (loop){
            Sistema.exibirMenu();

            Scanner scan = new Scanner(System.in);
            System.out.print("\nDigite sua opção: ");
            String entrada = scan.nextLine();
            int opcao = parseInt(entrada);

            switch(opcao){
                case 1:
                    Sistema.cadastrarColaborador(cadastros);
                    break;
                case 2:
                    Sistema.exibirColabores(cadastros);
                    break;
                case 3:
                    Sistema.adicionarAmigo(cadastros);
                    break;
                case 4:
                    Sistema.compartilharConteudo(cadastros);
                    break;
                case 5:
                    Sistema.listarAmigos(cadastros);
                    break;
                case 6:
                    Sistema.amigosEmComum(cadastros);
                    break;
                case 7:
                    Sistema.listarPostagens(cadastros);
                    break;
                case 8: 
                    System.out.println("Saindo do sistema!");
                    scan.close();
                    Sistema.scan.close();
                    arvores.set(0, cadastros);
                    boolean gravou = FileUtil.gravarObjeto(arvores, "arvores.txt");
                    loop = false;
                    break;
                default:
                    System.out.println("Opção inválida, por favor, digite outra.");
                    break;
            }
        }         
    }
    
}
