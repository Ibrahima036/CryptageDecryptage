import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cryptage extends JFrame {
        JTextField txtmsg = new JTextField();
        JTextField txtcle = new JTextField();
        JLabel lblmessage = new JLabel("Message : ");
        JLabel lblcle = new JLabel("Clé : ");
        JButton btncrypte = new JButton("Crypter");
        JLabel erreur = new JLabel("Champs ");

        public Cryptage(){
                super("Le Cryptage");
                this.setSize(500,200);
                this.setLocationRelativeTo(null);
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JPanel panePrincipale = new JPanel();

                JPanel paneComposant1 = new JPanel();
                paneComposant1.setLayout(new FlowLayout());
                JPanel paneComposant2 = new JPanel(new FlowLayout());

                //Définitions des tailles préférées des composants
                txtmsg.setPreferredSize(new Dimension(300,35));
                txtcle.setPreferredSize(new Dimension(50,35));
                btncrypte.setPreferredSize(new Dimension(200,35));

                //Définition de la mise en forme des composants
                Border labordureComposant1 = BorderFactory.createLoweredBevelBorder();
                Border labordureComposant2 = BorderFactory.createRaisedBevelBorder();
                paneComposant1.setBorder(labordureComposant1);
                paneComposant2.setBorder(labordureComposant2);
                lblmessage.setFont(new Font("Serif", Font.BOLD, 20));
                lblcle.setFont(new Font("Tohama", Font.BOLD, 18));
                btncrypte.setFont(new Font("Tohama", Font.BOLD, 18));
                erreur.setForeground(Color.red);

                paneComposant1.setBackground(Color.white);
                panePrincipale.setBackground(Color.LIGHT_GRAY);
                btncrypte.setBackground(Color.red);
                btncrypte.setForeground(Color.white);

                btncrypte.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent event) {
                               CyptageDuMessage(event);
                        }
                });


                paneComposant1.add(lblmessage);
                paneComposant1.add(txtmsg);
                paneComposant2.add(lblcle);
                paneComposant2.add(txtcle);
                paneComposant2.add(btncrypte);


                panePrincipale.add(paneComposant1);
                panePrincipale.add(paneComposant2);

                this.getContentPane().add(panePrincipale);
        }
        //Définitions des fonction utililes

        /*
        * Une fonction de cryptage qui utilise le cryptage de Cessar(le décalage des lettres)
        * On vérifie si tous les champs ne sont pas remplis
        *       Si oui
        *               on affiche un message d'alerte
        * Sinon si
        *       On vérifie si y'a au moins un champs n'on rempli
        *               Si oui -> on spécifie le champs qui est vide
        * Sinon
        *       On récupere le contenu des champs(txtmsg, txtcle) dépuis le formulaire
        *       ==========Principe de Cessar===========
        *       1.C'est du décalage de lettre
        *       2.Les épaces restent des espaces
        *       3.La même clé pour crypté et decrypté
        *
        * On essaie de respecter cet principe dans ce code d'oû les bloc de test
        * Quant on appuie sur le bouton Crypté dirrectement y'a une nouvelle fenetre qui s'active qui contidra le msg crypté.
        * */
        private void CyptageDuMessage(ActionEvent event){
                try {
                        String msgCrypte ="";
                        int key;
                        if(txtmsg.getText().isEmpty() && txtcle.getText().isEmpty()){
                                JOptionPane.showMessageDialog(this,erreur.getText()+" Message vide " +
                                        "\n "+erreur.getText()+" Clé vide " +
                                        "\n Veuilliez les remplirs");
                        }else if(txtmsg.getText().isEmpty()){
                                JOptionPane.showMessageDialog(this,erreur.getText()+" Message vide " +
                                        "\n Veuilliez le remplirs");
                        }else if(txtmsg.getText().isEmpty()){
                                JOptionPane.showMessageDialog(this, erreur.getText()+" Clé vide " +
                                        "\n Veuilliez le remplirs");
                        }else {
                                String msg = txtmsg.getText();
                                key = Integer.parseInt(txtcle.getText());
                                int vAssci;
                                char cararatereRecup;

                                for(int index = 0; index < msg.length(); ++index){
                                        cararatereRecup = msg.charAt(index);
                                        vAssci = (int) cararatereRecup + key;
                                        if(cararatereRecup == ' '){
                                                //msgCrypte += String.valueOf(cararatereRecup);
                                                msgCrypte += "-";
                                        }else if ( vAssci > 122 ) {
                                                vAssci = vAssci % 123 + 97;
                                                cararatereRecup = (char ) vAssci;
                                                msgCrypte += String.valueOf(cararatereRecup);
                                        }else {
                                                cararatereRecup = (char ) vAssci;
                                                msgCrypte += String.valueOf(cararatereRecup);
                                        }
                                }
                                super.dispose();
                                new Decrypter(msgCrypte, key).setVisible(true);

                        }

                }catch ( Exception e ){
                        JOptionPane.showMessageDialog(this,"Une erreur ici !! "+e.getMessage());
                }


        }
        public boolean isAlphaBet(char c){
                if(c >= 'a' && c <= 'b' || c >= 'A' && c <= 'B'){
                        return true;
                }
                return false;
        }

}
