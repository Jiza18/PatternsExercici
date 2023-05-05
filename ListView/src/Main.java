import java.util.List;

class ListView {
    interface Adaptador{
        String valor(int i);
        int cantidad();
    }

    void show(Adaptador adaptador){
        for (int i = 0; i < adaptador.cantidad(); i++) {
            System.out.println(adaptador.valor(i));
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<String> items = List.of("Java","Python","Javascript","C#", "C++", "TypeScript", "PHP");

        ListView listView = new ListView();
        listView.show(new ListView.Adaptador() {


            @Override
            public String valor(int i) {
                return "Lenguaje: " + items.get(i);
            }

            @Override
            public int cantidad() {
                return items.size();
            }
        });

        List<String> items2 = List.of("amd", "intel");

        listView.show(new ListView.Adaptador() {
            @Override
            public String valor(int i) {
                return "marca:" + items2.get(i);
            }

            @Override
            public int cantidad() {
                return items2.size();
            }
        });
    }
}
