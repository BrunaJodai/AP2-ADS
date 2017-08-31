package ap2_ado1;

import java.util.Scanner;

public class AP2_ADO1 {

    static Scanner console = new Scanner(System.in);

    //mudar tamanho do vetor para 50
    //trocar upperCase por ignore case
    public static void main(String[] args) {
        String[] listaNomes = new String[5];
        boolean sair = false;

        do {
            int opcao = mostrarMenu();

            switch (opcao) {
                case 0:
                    System.out.println("*~~ ATÉ MAIS! ~~*");
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
                    System.out.println("--- ESCOLHA INVÁLIDA ---");
            }
        } while (!sair);
    }

    static int mostrarMenu() {
        boolean ok = false;
        int opcao = 0;
        while (!ok) {
            try {
                System.out.println("\n~~ MENU ~~");
                System.out.println("1 - Adicionar um novo nome;\n"
                        + "2 - Apresentar os nomes;\n"
                        + "3 - Pesquisar um nome;\n"
                        + "4 - Remover um nome;\n"
                        + "0 - Sair.");
                System.out.print("~Digite a opção desejada: ");
                opcao = Integer.parseInt(console.nextLine());
                ok = true;
            } catch (Exception e) {
                System.out.println("--- POR FAVOR, DIGITE UMA OPÇÃO VÁLIDA ---");
            }
        }

        return opcao;
    }

    static String[] adicionaNome(String[] listaNomes) {
        System.out.print("Nome a ser adicionado: ");
        String nome = console.nextLine();
        nome = nome.toUpperCase().trim();

        for (int i = 0; i < listaNomes.length; i++) {
            if (listaNomes[i] == null) {
                listaNomes[i] = nome;
                System.out.println("--- NOME ADICIONADO COM SUCESSO ---");
                break;
            } else if (listaNomes[i].equals(nome)) {
                System.out.println("--- NOME JÁ EXISTENTE NA LISTA ---");
                break;
            } else if (i == (listaNomes.length - 1)) {
                System.out.println("--- LISTA CHEIA. NÃO É POSSÍVEL ADICIONAR MAIS NOMES ---");
            }
        }

        return listaNomes;
    }

    //arrumar o erro de qndo remove o primeiro nome, aparece a msg de lista vazia
    //mostra os nomes enquanto a posição no vetor != null, e no final avisa ao usuário de que chegou no fim da lista
    static void apresentaNomes(String[] listaNomes) {
        if (listaNomes[0] == null) {
            System.out.println("--- LISTA VAZIA ---");
        } else {
            for (int i = 0; i < listaNomes.length; i++) {
                if (listaNomes[i] != null) {
                    System.out.printf("> %s\n", listaNomes[i]);
                    if (i == (listaNomes.length - 1)) {
                        System.out.println("--- FIM DA LISTA ---");
                    }
                } else if (listaNomes[i] == null) {
                    System.out.println("--- FIM DA LISTA ---");
                    break;
                }
            }

        }
    }

    /*static void apresentaNomes(String[] listaNomes) {
        for (int i = 0; i < listaNomes.length; i++) {
            if (listaNomes[i] != null) {
                System.out.printf("> %s\n", listaNomes[i]);
                if (i == (listaNomes.length - 1)) {
                    System.out.println("--- FIM DA LISTA ---");
                }
            } else {
                if (listaNomes[0] == null) {
                    System.out.println("--- LISTA VAZIA ---");
                    break;
                } else if (listaNomes[i] == null) {
                    System.out.println("--- FIM DA LISTA ---");
                    break;
                }
            }
        }
    }*/
    //verificar erro qndo nn encontra
    static void pesquisaNome(String[] listaNomes) {
        System.out.print("Nome a ser pesquisado: ");
        String pesquisa = console.nextLine();
        pesquisa = pesquisa.toUpperCase().trim();

        for (int i = 0; i < listaNomes.length; i++) {
            if (pesquisa.equals(listaNomes[i])) {
                System.out.printf("--- NOME ENCONTRADO NA POSIÇÃO [%d] DO VETOR ---", i);
                break;
            } else if (i == (listaNomes.length - 1)) {
                System.out.println("--- NOME NÃO ENCONTRADO NA LISTA ---");
            }
        }
    }

    //erro ao remover nome na primeira posição do vetor
    static String[] removeNome(String[] listaNomes) {
        System.out.print("Nome que deseja remover: ");
        String nomeDelet = console.nextLine();
        nomeDelet = nomeDelet.toUpperCase().trim();

        boolean enc = false;

        for (int i = 0; i < listaNomes.length; i++) {
            if (i == (listaNomes.length - 1) && !enc) {
                System.out.println("--- NOME NÃO ENCONTRADO ---");
                //move os nomes
            } else if (listaNomes[i] == null) {
                if (i < (listaNomes.length - 1)) {
                    listaNomes[i] = listaNomes[i + 1];
                    listaNomes[i + 1] = null;
                }
                //remove o nome e altera o valor de i, para fazer a verificação novamente
            } else if (listaNomes[i].equals(nomeDelet)) {
                enc = true;
                listaNomes[i] = null;
                System.out.println("--- NOME REMOVIDO COM SUCESSO ---");

                if (i == 0) {
                    i = 0;
                } else {
                    i--;
                }
            }
        }
        return listaNomes;
    }

}
