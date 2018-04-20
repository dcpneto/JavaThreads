package Corrida;

/**
 *
 * @author djalmaneto
 */
public class Main {

    public static void main(String[] args) {
        Podio vencedor = new Podio();
        FormulaUm hamilton = new FormulaUm("L. Hamilton", vencedor);
        FormulaUm massa = new FormulaUm("F. Massa", vencedor);

        try {
            hamilton.setName("Hamilton");
            hamilton.start();
            massa.setName("Massa");
            massa.start();
            hamilton.join();
            massa.join();
           


        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        
        
        System.out.println("O vencedor é: " + vencedor.getVencedor() );

        System.out.println("Terminou");

    }

}
