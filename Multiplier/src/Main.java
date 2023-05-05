



class Multiplicador {

    interface Adaptador {
        int param1();
        int param2();
    }

    int multiplica(Adaptador adaptador){
        return adaptador.param1()* adaptador.param2();
    }
}

public class Main {
    public static void main(String[] args) {
        Multiplicador multiplicador = new Multiplicador();

        int resultado = multiplicador.multiplica(new Multiplicador.Adaptador() {
            @Override
            public int param1() {
                return 500;
            }

            @Override
            public int param2() {
                return 10;
            }
        });

        System.out.println(resultado);
    }
}

