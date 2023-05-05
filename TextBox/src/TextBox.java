/*Añade un Builder a la siguiente clase TextBox.

El método build() debe asegurar que:

Los campos alto y ancho son siempre mayores que 0.

El campo ancho siempre es mayor o igual a la longitud del campo texto.

El campo alto es mayor o igual a 1 si el campo texto no está vacío

El campo texto nunca debe ser null.

class TextBox {
    String texto;
    int ancho, alto;

    @Override
    public String toString() {
        return ancho + "x" + alto + "\n" +
                "┏" + "━".repeat(ancho) + "┓\n" +
                ("┃" + " ".repeat(ancho) + "┃\n").repeat((alto - 1) / 2) +
                (alto > 0 ? "┃" + " ".repeat((ancho - texto.length() + 1) / 2) + texto + " ".repeat((ancho - texto.length()) / 2) + "┃\n" : "") +
                ("┃" + " ".repeat(ancho) + "┃\n").repeat(alto / 2) +
                "┗" + "━".repeat(ancho) + "┛\n";
    }
}*/


public class TextBox {
    String texto;
    int ancho, alto;

    @Override
    public String toString() {
        return ancho + "x" + alto + "\n" +
                "┏" + "━".repeat(ancho) + "┓\n" +
                ("┃" + " ".repeat(ancho) + "┃\n").repeat((alto - 1) / 2) +
                (alto > 0 ? "┃" + " ".repeat((ancho - texto.length() + 1) / 2) + texto + " ".repeat((ancho - texto.length()) / 2) + "┃\n" : "") +
                ("┃" + " ".repeat(ancho) + "┃\n").repeat(alto / 2) +
                "┗" + "━".repeat(ancho) + "┛\n";
    }

    static class Builder {

        String texto;
        int ancho, alto;

        Builder setTexto(String texto){
            this.texto = texto;
            return this;
        }

        Builder setAncho(int ancho){
            this.ancho = ancho;
            return this;
        }

        Builder setAlto(int alto){
            this.alto = alto;
            return this;
        }

        TextBox build() {
            TextBox textBox = new TextBox();

            if (this.texto == null) {
                this.texto = "";
            }



            if (this.ancho < this.texto.length()) {
                textBox.ancho = this.texto.length();
            } else {
                textBox.ancho = this.ancho;
            }


            return textBox;
        }
    }
}