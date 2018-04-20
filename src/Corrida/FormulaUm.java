package Corrida;

/**
 *
 * @author djalmaneto
 */
public class FormulaUm extends Thread {

    private Podio campeao;
    private String piloto;

    public FormulaUm(String nome, Podio c) {
        piloto = nome;
        campeao = c;
    }

    @Override
    public void run() {

        try {
            int i;
            for (i = 1; i < 66; i++) {

                System.out.println(i + "º.volta - " + piloto);
                int tempo = (int) (Math.random() * 1000);
                sleep(tempo);
            }

            this.campeao.setVencedor(piloto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
