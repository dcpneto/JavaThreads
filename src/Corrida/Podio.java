package Corrida;

/**
 *
 * @author djalmaneto
 */
public class Podio {

    private String vencedor;
    private boolean fim = false;

    public void setVencedor(String vencedor) {

        if (fim == false) {
            this.vencedor = vencedor;
            fim = true;
        }
    }

    public String getVencedor() {
        return vencedor;
    }
}
