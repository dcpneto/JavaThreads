package Ping;

import static Ping.Ping.Ping;
//import static Ping.Ping.pingar;
//import static Ping.Ping.testaPortas;

/**
 *
 * @author djalmaneto
 */
public class Main {

    public static void main(String[] args) {
        String host = "8.8.8.8";
        String ipstr = "8.8.8.8";
        int timeOut = 3000;
        int port = 80;
        while (true) {
            //System.out.println(host + "=" + pingar(host, timeOut));
            //System.out.println("Porta:" + testaPortas(port));
            System.out.println("Server " + Ping(ipstr) + " Alive");
        }
    }
}
