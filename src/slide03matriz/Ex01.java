/* Faça um programa para somar duas matrizes.*/
package slide03matriz;

import java.util.Scanner;

public class Ex01 {

    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("~TAMANHO DA MATRIZ~ ");
        System.out.print("Linhas: ");
        int linha = Integer.parseInt(console.nextLine());
        System.out.print("Colunas: ");
        int coluna = Integer.parseInt(console.nextLine());

        System.out.println("MATRIZ 1: ");
        int[][] matriz1 = criaPopulaMatriz(linha, coluna);
        System.out.println("MATRIZ 2: ");
        int[][] matriz2 = criaPopulaMatriz(linha, coluna);
        
        int[][] somaMatrizes = somaMatrizes(linha, coluna, matriz1, matriz2);
        
        imprimeMatriz(somaMatrizes);

    }

    static int[][] criaPopulaMatriz(int linha, int coluna) {
        // não é necessário informar o tamanho da coluna, ou seja, pode deixar nulo
        int[][] matriz = new int[linha][coluna];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("[%d][%d]: ", i, j);
                matriz[i][j] = Integer.parseInt(console.nextLine());
            }
            System.out.println("");
        }
        return matriz;
    }

    static int[][] somaMatrizes(int linha, int coluna, int [][]matriz1, int[][] matriz2) {
        int[][] somaMatrizes = new int[linha][coluna];

        for (int i = 0; i < somaMatrizes.length; i++) {
            for (int j = 0; j < somaMatrizes[i].length; j++) {
                somaMatrizes[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }
        return somaMatrizes;
    }
    
    static void imprimeMatriz (int[][]somaMatrizes) {
        System.out.println("RESULTADO DA SOMA DAS MATRIZES");
        for (int i = 0; i < somaMatrizes.length; i++) {
            for (int j = 0; j < somaMatrizes[i].length; j++) {
                System.out.printf("[%d][%d]: [%d]\n", i, j, somaMatrizes[i][j]);
            }
        }
    }
}
