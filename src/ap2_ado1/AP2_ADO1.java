/*
( ) mudar tamanho do vetor para 50
( ) tratar erro de digitar em formato diferente (try and catch)
( ) melhoras as msgs apresentadas ao usuário*/
package ap2_ado1;

import java.util.Scanner;

public class AP2_ADO1 {

    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        String[] listaNomes = new String[5];
        boolean sair = false;

        do {
            int opcao = mostrarMenu();

            switch (opcao) {
                case 0:
                    System.out.println("-- Até mais! --");
                    sair = true;
                    break;
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
                default:
                    System.out.println("-- Escolha inválida --");
            }
        } while (!sair);
    }

    static int mostrarMenu() {
        System.out.println("\n~~ MENU ~~");
        System.out.println("1 - Adicionar um novo nome;\n"
                + "2 - Apresentar os nomes;\n"
                + "3 - Pesquisar um nome;\n"
                + "4 - Remover um nome;\n"
                + "0 - Sair.");
        System.out.print("~Digite a opção desejada: ");
        int opcao = Integer.parseInt(console.nextLine());

        return opcao;
    }

    static String[] adicionaNome(String[] listaNomes) {
        System.out.print("Nome a ser adicionado: ");
        String nome = console.nextLine();
        nome = nome.toUpperCase().trim();

        for (int i = 0; i < listaNomes.length; i++) {
            if (listaNomes[i] == null) {
                listaNomes[i] = nome;
                System.out.println("-- Nome adicionado com sucesso --");
                break;
            } else if (listaNomes[i].equals(nome)) {
                System.out.println("-- Nome já existente na lista --");
                break;
            } else if (i == (listaNomes.length - 1)) {
                System.out.println("-- Lista cheia. Não é possível adicionar mais nomes--");
            }
        }

        return listaNomes;
    }

    /*static void apresentaNomes(String[] listaNomes) {
        int vazio = 0;

        for (int i = 0; i < listaNomes.length; i++) {
            if (listaNomes[i] == null) {
                vazio++;
                //System.out.println("vazios: " +vazio);
            } else {
                System.out.printf("[%d]: %s\n", i, listaNomes[i]);
            }
        }

        if (vazio == listaNomes.length) {
            System.out.println("-- Lista vazia --");
        }
    }*/
    static void apresentaNomes(String[] listaNomes) {
        for (int i = 0; i < listaNomes.length; i++) {
            if (listaNomes[i] != null) {
                System.out.printf("> %s\n", listaNomes[i]);
                if (i == (listaNomes.length - 1)) {
                    System.out.println("-- Fim da lista --");
                }
            } else {
                if (listaNomes[0] == null) {
                    System.out.println("-- Lista vazia --");
                    break;
                } else if (listaNomes[i] == null) {
                    System.out.println("-- Fim da lista --");
                    break;
                }
            }
        }
    }

    static void pesquisaNome(String[] listaNomes) {
        System.out.print("Nome a ser pesquisado: ");
        String pesquisa = console.nextLine();
        pesquisa = pesquisa.toUpperCase().trim();

        for (int i = 0; i < listaNomes.length; i++) {
            if (listaNomes[i].equals(pesquisa)) {
                System.out.printf("-- Nome encontrado na posição [%d] do vetor --", i);
                break;
            } else if (i == (listaNomes.length - 1)) {
                System.out.println("-- Nome não encontrado na lista --");
            }
        }
    }

    /* ~AO REMOVER UM NOME:
( ) A posição que contém o nome a ser removido deve ser preenchida com o próximo nome e assim
sucessivamente. Não podem haver posições vazias no meio do vetor.*/
    //ultimos nomes repetidos
    static String[] removeNome(String[] listaNomes) {
        System.out.print("Nome que deseja remover: ");
        String nomeDelet = console.nextLine();
        nomeDelet = nomeDelet.toUpperCase().trim();

        boolean aus = false;

        for (int i = 0; i < listaNomes.length; i++) {
            //System.out.println("i: " + i);
            if (i == (listaNomes.length - 1) && !aus) {
                System.out.println("-- Nome não encontrado na lista --");
            } else if (listaNomes[i] == null) {
                if (i < (listaNomes.length - 1)) {
                    listaNomes[i] = listaNomes[i + 1];
                }
            } else if (listaNomes[i].equals(nomeDelet)) {
                aus = true;
                listaNomes[i] = null;
                System.out.println("-- Nome removido com sucesso --");

                if (i == 0) {
                    i = 0;
                } else {
                    i--;
                    //System.out.println("i--: " + i);
                }
            }
        }
        return listaNomes;
    }

}
