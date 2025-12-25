package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField pinnum, repin;
    JButton change, back;
    String pin;   //  GLOBAL VARIABLE

    PinChange(String pin) {
        this.pin = pin;   //  STORE OLD PIN

        setLayout(null);

        ImageIcon i1 = new ImageIcon(
                PinChange.class.getResource("/icons/atm.jpg")
        );
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(250, 280, 500, 35);
        image.add(text);

        JLabel pintext = new JLabel("NEW PIN:");
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setForeground(Color.WHITE);
        pintext.setBounds(165, 320, 180, 25);
        image.add(pintext);

        pinnum = new JPasswordField();
        pinnum.setFont(new Font("Raleway", Font.BOLD, 20));
        pinnum.setBounds(330, 320, 180, 25);
        image.add(pinnum);

        JLabel repintext = new JLabel("Re-Enter New PIN:");
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setForeground(Color.WHITE);
        repintext.setBounds(165, 360, 180, 25);
        image.add(repintext);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 20));
        repin.setBounds(330, 360, 180, 25);
        image.add(repin);

        change = new JButton("CHANGE");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String npin = pinnum.getText();
            String rpin = repin.getText();

            if (ae.getSource() == change) {

                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                    return;
                }

                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Re-enter New PIN");
                    return;
                }

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "PIN does not match");
                    return;
                }

                Conn c1 = new Conn();

                String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pin+"'";
                String q2 = "update login set pin = '"+rpin+"' where pin = '"+pin+"'";
                String q3 = "update signup3 set pin = '"+rpin+"' where pin = '"+pin+"'";

                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
                c1.s.executeUpdate(q3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");

                setVisible(false);
                new Transactions(rpin).setVisible(true);

            } else if (ae.getSource() == back) {
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
