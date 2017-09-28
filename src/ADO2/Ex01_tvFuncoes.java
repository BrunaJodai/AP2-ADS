/* Bruna Sayuri Susuke Jodai - ADO2 - Algoritmo e Programação II - 2TADS-B */
package ADO2;

public class Ex01_tvFuncoes {

    private boolean liga;
    private int canal;
    private int vol;

    //metodo construtor
    public Ex01_tvFuncoes() {
        liga = false;
        canal = 2;
        vol = 10;
    }

    public void ligar() {
        liga = true;
    }

    public void desligar() {
        liga = false;
    }

    public boolean getLiga() {
        return liga;
    }

    public int getCanal() {
        return canal;
    }

    public void setCanal(int canal) {
        this.canal = canal;
    }

    public int getVol() {
        return vol;
    }

    public void setVol(int vol) {
        if (vol >= 0 && vol <= 20) {
            this.vol = vol;
        }
    }
}
