/* Bruna Sayuri Susuke Jodai - ADO2 - Algoritmo e Programação II - 2TADS-B */

package ADO2;

public class Ex02_Pessoa {

    private String nome;
    private int idade;
    private double peso;
    private double altura;
    private double imc;

    //metodo construtor
    public Ex02_Pessoa() {
        nome = "Bruna";
        idade = 21;
        peso = 50;
        altura = 1.60;
    }

    
    public double calculaIMC() {
       return imc = peso / (altura * altura);
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }

    //retorna a string com a categoria equivalente
    public String mostraCategIMC() {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc >= 18.5 && imc <= 24.9) {
            return "Peso ideal";
        } else if (imc >= 25 && imc <= 29.9) {
            return "Sobrepeso";
        } else if (imc >= 30 && imc <= 34.9) {
            return "Obesidade grau I";
        } else if (imc >= 35 && imc <= 39.9) {
            return "Obesidade grau II";
        } else if (imc > 40) {
            return "Obesidade grau III";
        }
        return "Inválido";
    }
}
