/* Criar um programa para o gerenciamento de uma lista de nomes. Os nomes devem ser armazenados em um
vetor do tipo String de tamanho 50. O programa deve possuir o seguinte menu:
( )1 - Adicionar um novo nome
( )2 - Apresentar os nomes
( )3 - Pesquisar um nome
( )4 - Remover um nome
(x)0 - Sair
Observações
 ~AO ADICIONAR UM NOVO NOME:
(x) O nome deve ser lido via teclado;
( ) O nome deve ser inserido no final da lista;
(x) Caso a lista esteja cheia, apresentar uma mensagem indicativa ao usuário e não adicionar o nome
na lista;
(x) Não é permitido adicionar um nome já existente na lista. Caso já exista o nome na lista, apresentar
uma mensagem indicativa ao usuário.
 ~AO APRESENTAR OS NOMES:
(x) Se a lista estiver vazia, apresentar uma mensagem indicativa ao usuário;
( ) Os nomes devem ser apresentados na ordem em que foram inseridos na lista.
 ~AO PESQUISAR UM NOME:
(x) Ler via teclado o nome a ser pesquisado;
(x) Apresentar uma mensagem informando se o nome foi ou não encontrado. Caso o nome tenha sido
encontrado, apresentar também a posição do nome no vetor.
 ~AO REMOVER UM NOME:
( ) Ler via teclado o nome a ser removido;
( ) Se o nome informado não estiver na lista, apresentar uma mensagem indicativa ao usuário;
( ) A posição que contém o nome a ser removido deve ser preenchida com o próximo nome e assim
sucessivamente. Não podem haver posições vazias no meio do vetor.

( ) tratar erro de digitar em formato diferente (try and catch)*/
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
        System.out.print("Nome: ");
        String nome = console.nextLine();
        nome = nome.toUpperCase().trim();

        for (int i = 0; i < listaNomes.length; i++) {
            if (listaNomes[i] == null) {
                listaNomes[i] = nome;
                System.out.println("-- Nome adicionado com sucesso --\n");
                break;
            } else if (listaNomes[i].equals(nome)) {
                System.out.println("-- Nome já existente na lista --\n");
                break;
            } else if (i == (listaNomes.length - 1)) {
                System.out.println("-- Lista cheia. Não é possível adicionar mais nomes--\n");
            }
        }

        return listaNomes;
    }

    //mostrando somente a primeira posição do vetor
    static void apresentaNomes(String[] listaNomes) {
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
    }

    static void pesquisaNome(String[] listaNomes) {
        System.out.print("Nome a ser pesquisado: ");
        String pesquisa = console.nextLine();
        for (int i = 0; i < listaNomes.length; i++) {
            if (listaNomes[i].equals(pesquisa)) {
                System.out.printf("-- Nome encontrado na posição %d do vetor --\n", i);
                break;
            } else {
                System.out.println("-- Nome não encontrado na lista --\n");
            }
        }
    }

    static String[] removeNome(String[] listaNomes) {
        System.out.print("Nome que deseja remover: ");
        String nomeDelet = console.nextLine();

        for (int i = 0; i < listaNomes.length; i++) {
            if (listaNomes[i].equals(nomeDelet)) {
                listaNomes[i] = "";
                break;
            }
        }
        return listaNomes;
    }

}
