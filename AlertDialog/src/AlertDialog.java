/*Crea un clase AlertDialog con los siguientes campos:

String title, text, yesButtonText, noButtonText;
Añade un Builder a la classe AlertDialog:

Los campos title y text son obligatorios.

Los campos yesButtonText y noButtonText son opcionales.

Añade los siguientes métdodos al Builder:

Builder setYes()   // establece el yesButtonText a "Ok"
Builder setNo()   // establece el yesButtonText a "Cancel"
Añade el siguiente método al Builder:

void show(){
    AlertDialog alertDialog = build();

    JPanel jPanel = new JPanel();
    jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.PAGE_AXIS));
    jPanel.add(new JLabel(alertDialog.text));
    if (alertDialog.yesButtonText != null)
        jPanel.add(new JButton(alertDialog.yesButtonText));
    if (alertDialog.noButtonText != null)
        jPanel.add(new JButton(alertDialog.noButtonText));


    JFrame jFrame = new JFrame(title);
    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    jFrame.add(jPanel);
    jFrame.pack();
    jFrame.setLocationRelativeTo(null);
    jFrame.setVisible(true);
}
Comprueba que funciona el AlertDialog:

new AlertDialog.Builder("Suscribirse", "Desea suscribirse a mi canal?")
    .setYes("Sí, suscribeme ahora mismo")
    .setNo("No, otro día")
    .show();
*/

import javax.swing.*;

public class AlertDialog{
    String title, text, yesButtonText, noButtonText;



    static class Builder{
        String title, text, yesButtonText, noButtonText;

        public Builder(String title, String text){
            this.title = title;
            this.text = text;
        }

        Builder setYes(String s){
            if(s == null || s.equals("")){
                yesButtonText = "Ok";
            }
            else{
                yesButtonText = s;
            }
            return this;
        }

        Builder setNo(String s){
            if(s == null || s.equals("")){
                noButtonText = "Cancel";
            }
            else{
                noButtonText = s;
            }
            return this;
        }

        AlertDialog build(){
            AlertDialog alertDialog = new AlertDialog();
            alertDialog.text = this.text;
            alertDialog.title = this.title;
            alertDialog.yesButtonText = this.yesButtonText;
            alertDialog.noButtonText = this.noButtonText;
            return alertDialog;

        }

        void show(){
            AlertDialog alertDialog = build();

            JPanel jPanel = new JPanel();
            jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.PAGE_AXIS));
            jPanel.add(new JLabel(alertDialog.text));
            if (alertDialog.yesButtonText != null)
                jPanel.add(new JButton(alertDialog.yesButtonText));
            if (alertDialog.noButtonText != null)
                jPanel.add(new JButton(alertDialog.noButtonText));


            JFrame jFrame = new JFrame(title);
            jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jFrame.add(jPanel);
            jFrame.pack();
            jFrame.setLocationRelativeTo(null);
            jFrame.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new AlertDialog.Builder("Suscribirse", "Desea suscribirse a mi canal?")
                .setYes("Si, suscribirme ahora mismo")
                .setNo("No, otro día")
                .show();
    }


}