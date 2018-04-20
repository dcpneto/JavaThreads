package Ping;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.StringTokenizer;

/**
 *
 * @author djalmaneto
 */
public class Ping {

    public static boolean Ping(String ipstr) {
        boolean retorno = false;
        try {
            InputStream ins = Runtime.getRuntime().exec("ping -n 1 -w 2000 " + ipstr).getInputStream();
            Thread.sleep(3000);
            byte[] prsbuf = new byte[ins.available()];
            ins.read(prsbuf);
            String parsestring = new StringTokenizer(new String(prsbuf), "%")
                    .nextToken().trim();
            if (!parsestring.endsWith("100")) {
                retorno = true;
            }
        } catch (Exception e) {
            retorno = false;
            System.out.println(e);
        }
        return retorno;
    }

    public static boolean testaPortas(int port) {
        try {
            ServerSocket server = new ServerSocket(port);
            server.close();
            server = null;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean pingar(String host) {
        return pingar(host, 3000);
    }

    public static boolean pingar(String host, int timeOut) {
        try {
            return InetAddress.getByName(host).isReachable(timeOut);
        } catch (IOException e) {
            return false;
        }
    }
}
