package ADO2;

/* Bruna Sayuri Susuke Jodai - ADO2 - Algoritmo e Programação II - 2TADS-B */
import java.util.Scanner;

public class Ex01_tvMain {

    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        Ex01_tvFuncoes tv = new Ex01_tvFuncoes();

        int canal = -1;
        int opcao = -1;

        do {
            while (opcao < 0 || opcao > 4 || !tv.getLiga()) {
                tv.imprimeInfos();
                opcao = controle();
                if(opcao < 0 || opcao > 4){
                    System.out.println("OPÇÃO INVÁLIDA");
                } else if (!tv.getLiga()){
                    System.out.println("TV DESLIGADA");
                }                
            }

            switch (opcao) {
                case 0:
                    System.out.println("--- ATÉ MAIS! ---");

                    break;
                case 1:
                    if (tv.getLiga()) {
                        tv.desligar();
                    } else {
                        tv.ligar();
                    }
                    break;
                case 2:
                    //canal somente de 0 a 99
                    do {
                        System.out.print("Mudar p/ canal: ");
                        canal = console.nextInt();
                    } while (canal < 0 && canal > 99);
                    tv.setCanal(canal);
                    break;
                case 3:
                    tv.setVol(tv.getVol() + 1);
                    break;
                case 4:
                    tv.setVol(tv.getVol() - 1);
                    break;
            }
        } while (opcao != 0);

    }

    public static int controle() {
        int opcao = -1;
        //do {
        //try {
        System.out.println("\n~~ CONTROLE ~~");
        System.out.println("1 - Liga/Desliga TV;\n"
                + "2 - Muda canal;\n"
                + "3 - Aumenta volume;\n"
                + "4 - Diminui volume;\n"
                + "0 - Cancela.");
        System.out.print("~Digite a opção desejada: ");
        opcao = Integer.parseInt(console.nextLine());
        /*} catch (NumberFormatException e) {
                System.out.println("--- POR FAVOR, DIGITE UMA OPÇÃO VÁLIDA ---");
            }*/
        //} while (opcao < 0 || opcao > 4);

        return opcao;
    }
}
