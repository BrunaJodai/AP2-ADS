/* Bruna Sayuri Susuke Jodai - ADO2 - Algoritmo e Programação II - 2TADS-B */
package ADO2;

public class Ex02_Pessoa {

    private String nome;
    private int idade;
    private float peso;
    private float altura;
    private float imc;

    public void calculaIMC() {
        imc = peso / (altura * altura);
    }

    public void mostraCategIMC() {
        if (imc < 18.5) {
            System.out.println("Abaixo do peso");
        } else if (imc >= 18.5 && imc <= 24.9) {
            System.out.println("Peso ideal");
        } else if (imc >= 25 && imc <= 29.9) {
            System.out.println("Sobrepeso");
        } else if (imc >= 30 && imc <= 34.9) {
            System.out.println("Obesidade grau I");
        } else if (imc >= 35 && imc <= 39.9) {
            System.out.println("Obesidade grau II");
        } else if (imc > 40) {
            System.out.println("Obesidade grau III");
        }
    }
}
