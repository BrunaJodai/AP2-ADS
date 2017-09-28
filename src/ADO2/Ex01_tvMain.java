/* Bruna Sayuri Susuke Jodai - ADO2 - Algoritmo e Programação II - 2TADS-B */
package ADO2;

import java.util.Scanner;

public class Ex01_tvMain {

    static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        Ex01_tvFuncoes tv = new Ex01_tvFuncoes();

        boolean ligada;
        int canal;
        int vol;
        int opcao = -1;
        boolean ok = false;

        do {

            ligada = tv.getLiga();
            canal = tv.getCanal();
            vol = tv.getVol();

            imprimeInfos(ligada, canal, vol);
            opcao = controle();

            if (!ligada && opcao != 1&&opcao!=0) {
                System.out.println("--- TV DESLIGADA. POR FAVOR, LIGUE A TV ---");
            } else {
                switch (opcao) {
                    case 0:
                        System.out.println("--- ATÉ MAIS! ---");
                        ok = true;
                        break;
                    case 1:
                        if (ligada) {
                            tv.desligar();
                        } else {
                            tv.ligar();
                        }
                        break;
                    case 2:
                        //canal somente de 0 a 99. "Obriga" a digitar um canal válido
                        do {
                            System.out.print("-> Mudar p/ canal: ");
                            canal = Integer.parseInt(console.nextLine());
                        } while (canal < 0 && canal > 99);
                        tv.setCanal(canal);
                        break;
                    case 3:
                        tv.setVol(vol + 1);
                        break;
                    case 4:
                        tv.setVol(vol - 1);
                        break;
                }
            }

        } while (!ok);

    }

    //optei por deixar o ligar e desligar na mesma opção, no switch no main tem a condição p/ determinar o que fazer
    public static int controle() {
        int opcao = -1;
        do {
            try {
                System.out.println("\n~~ CONTROLE ~~");
                System.out.println("1 - Ligar/Desligar TV;\n"
                        + "2 - Mudar canal;\n"
                        + "3 - Aumentar volume;\n"
                        + "4 - Diminuir volume;\n"
                        + "0 - Cancelar/Sair.");
                System.out.print("~Digite a opção desejada: ");
                opcao = Integer.parseInt(console.nextLine());

            } catch (NumberFormatException exe) {
                System.out.println("--- POR FAVOR, DIGITE UMA OPÇÃO VÁLIDA ---");
            }

            //mensagem só para orientar o usuário
            if (opcao < 0 || opcao > 4) {
                System.out.println("--- OPÇÃO INVÁLIDA ---");
            }

        } while (opcao < 0 || opcao > 4);

        return opcao;
    }

    public static void imprimeInfos(boolean ligada, int canal, int vol) {
        String status;
        if (ligada) {
            status = "Ligada";
        } else {
            status = "Desligada";
        }

        System.out.println("");
        System.out.println("╔═ ═ ═ ═ ═ ═ ═ ═ ═ ═╗");
        System.out.println("    STATUS TV: " + status);
        System.out.println("        CANAL: " + canal);
        System.out.println("       VOLUME: " + vol);
        System.out.println("╚═ ═ ═ ═ ═ ═ ═ ═ ═ ═╝");
    }
}
