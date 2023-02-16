import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;

public class Decrypter extends Cryptage{
        JLabel lblinfo = new JLabel("Message Crypté");
        JLabel lblDeCrytpe = new JLabel("MsgCrypté");
        JButton btnDecrypte = new JButton("Décrypter");
        String messageCypte;
        int cle;

        public Decrypter(String msg , int key){
                this.messageCypte = msg;
                this.cle = key;
                this.setTitle("Décryptage");
                this.setSize(500,200);
                this.setLocationRelativeTo(null);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                lblinfo.setText(this.messageCypte);

                JPanel panelPrincipale = new JPanel();
                JPanel composant = new JPanel();
                JPanel c = new JPanel();

                lblinfo.setPreferredSize(new Dimension(300,25));
                btnDecrypte.setPreferredSize(new Dimension(100,35));
                lblDeCrytpe.setPreferredSize(new Dimension(300,25));

                composant.add(lblinfo);
                composant.setBackground(Color.white);
                lblinfo.setForeground(Color.red);
                lblinfo.setFont(new Font("Serif ", Font.BOLD, 18));
                composant.add(btnDecrypte);
                c.setBackground(Color.GREEN);
                c.add(lblDeCrytpe);


                panelPrincipale.add(composant);
                panelPrincipale.add(c);

                this.getContentPane().add(panelPrincipale);


        }
        public class Main {
                public static void main(String[] args) throws Exception{
                        UIManager.setLookAndFeel(new NimbusLookAndFeel());
                }
        }
}