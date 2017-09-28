/* Bruna Sayuri Susuke Jodai - ADO2 - Algoritmo e Programação II - 2TADS-B */

package ADO2;

import java.util.Scanner;

public class Ex02_PessoaMain {

    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        Ex02_Pessoa pessoa = new Ex02_Pessoa();

        boolean ok = false;
        double peso = 0;
        double altura = 0;

        System.out.print("Nome: ");
        String nome = console.nextLine();
        pessoa.setNome(nome);

        System.out.print("Idade: ");
        int idade = Integer.parseInt(console.nextLine());
        pessoa.setIdade(idade);
        
        //garante que seja lido somente numero válido
        do {
            try {
                System.out.print("Peso: ");
                peso = Double.parseDouble(console.nextLine());
                pessoa.setPeso(peso);

                System.out.print("Altura: ");
                altura = Double.parseDouble(console.nextLine());
                pessoa.setAltura(altura);
                
                ok = true;
            } catch (NumberFormatException exe) {
                System.out.println("\nPeso e/ou altura informado errado");
                System.out.println("~Se não estiver indo com ,(vírgula) use o .(ponto)\n");
            }
        } while (!ok);

        double imc = pessoa.calculaIMC();
        String categoria = pessoa.mostraCategIMC();

        System.out.printf("\n-- DADOS --\n"
                + "%s\n"
                + "%d anos \n"
                + "%.2fkg \n"
                + "%.2fm\n"
                + "IMC: %.2f ║ %s\n", nome, idade, peso, altura, imc, categoria);
    }
}
