package ap2_ado1;

import java.util.Scanner;

public class AP2_ADO1 {
    
    static Scanner console = new Scanner (System.in);
    
    public static void main(String[] args) {
        String [] listaNomes = new String [5];
        
        int opcao = mostrarMenu();
        
        switch (opcao) {
            case 1:
                adicionaNome(listaNomes);
                break;
            case 2:
                apresentaNomes(listaNomes);
                break;
            case 3:
                pesquisaNome(listaNomes);
                break;
            case 4:
                removeNome(listaNomes);
                break;
            case 5:
                
                break;
            default:
                System.out.println("Escolha inválida.");
                
        }
    }
    
    //mostra o menu 
    static int mostrarMenu () {
        System.out.println("1 - Adicionar um novo nome;\n"
                + "2 - Apresentar os nomes;\n"
                + "3 - Pesquisar um nome;\n"
                + "4 - Remover um nome;\n"
                + "5 - Sair.");
        System.out.print("Digite a opção desejada: ");
        int opcao = Integer.parseInt(console.nextLine());
     
        return opcao;
    }
    
    static String[] adicionaNome (String []listaNomes) {
        System.out.print("Nome: ");
        String nome = console.nextLine();
        
        for(int i = 0; i < listaNomes.length; i++) {
            if (listaNomes[i].equals("")) {
                listaNomes[i] = nome;
            }else if (listaNomes[i].equals(nome)) {
                System.out.println("Nome já existente na lista.");
            } else {
                System.out.println("Lista cheia. Não é possível adicionar mais.");
            }
        }
        return listaNomes;
    }
    
    static void apresentaNomes (String[]listaNomes) {
        for (int i = 0; i <listaNomes.length; i++) {
            System.out.println(listaNomes[i]);
        }
    }
    
    static void pesquisaNome (String[]listaNomes) {
        System.out.print("Nome a ser pesquisado: ");
        String pesquisa = console.nextLine();
        for (int i = 0; i <listaNomes.length; i++) {
            if (listaNomes[i].equals(pesquisa)) {
                System.out.printf("Nome encontrado na posição %d do vetor." ,i);
            } else {
                System.out.println("Nome não encontrado na lista.");
            }
        }
    }
    
    static String[] removeNome (String[]listaNomes) {
        System.out.print("Nome que deseja remover: ");
        String nomeDelet = console.nextLine();
        
        for (int i = 0; i < listaNomes.length; i++) {
            if (listaNomes[i].equals(nomeDelet)){
                listaNomes[i] = "";
                break;
            }
        }
        return listaNomes;
    }

}
