import java.io.IOException;
import java.net.InetAddress;

class Pinger {
    interface Adaptador {
        String ip(int i);

        int cantidad();

        default int tiempoEspera() {
            return 500;
        }

        default String onlineText() {
            return " is online";
        }
    }

    void ping(Adaptador adaptador) {
        for (int i = 0; i < adaptador.cantidad(); i++) {
            try {
                if (InetAddress.getByName(adaptador.ip(i)).isReachable(adaptador.tiempoEspera())) {
                    System.out.println(adaptador.ip(i) + adaptador.onlineText());
                } else {
                    System.out.println(adaptador.ip(i) + " is down");
                }
            } catch (IOException ignored) {
            }
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Pinger pinger = new Pinger();

        pinger.ping(new Pinger.Adaptador() {
            @Override
            public String ip(int i) {
                return "10.2.1." + (i + 1);
            }

            @Override
            public int cantidad() {
                return 254;
            }

            @Override
            public String onlineText() {
                return " esta en linia";
            }
        });
    }
}