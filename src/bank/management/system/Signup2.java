package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Signup2 extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13;
    JButton b;
    JRadioButton r1, r2, r3, r4;
    JTextField t1, t2;
    JComboBox<String> c1, c2, c3, c4, c5;
    String formno;

    Signup2(String formno) {

        this.formno = formno;

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        setLayout(null);

        // ===== LOGO =====
        ImageIcon i1 = new ImageIcon(
                Signup2.class.getResource("/icons/logo.jpg")
        );
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        JLabel l14 = new JLabel(new ImageIcon(i2));
        l14.setBounds(150, 0, 100, 100);
        add(l14);

        // ===== LABELS =====
        l1 = new JLabel("Page 2: Additional Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));

        l2 = new JLabel("Religion:");
        l3 = new JLabel("Category:");
        l4 = new JLabel("Income:");
        l5 = new JLabel("Educational");
        l11 = new JLabel("Qualification:");
        l6 = new JLabel("Occupation:");
        l7 = new JLabel("PAN Number:");
        l8 = new JLabel("Aadhar Number:");
        l9 = new JLabel("Senior Citizen:");
        l10 = new JLabel("Existing Account:");
        l12 = new JLabel("Form No:");
        l13 = new JLabel(formno);

        JLabel[] labels = {l2, l3, l4, l5, l11, l6, l7, l8, l9, l10};
        for (JLabel lbl : labels) {
            lbl.setFont(new Font("Raleway", Font.BOLD, 18));
        }

        l12.setFont(new Font("Raleway", Font.BOLD, 13));
        l13.setFont(new Font("Raleway", Font.BOLD, 13));

        // ===== BUTTON =====
        b = new JButton("Next");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.addActionListener(this);

        // ===== TEXT FIELDS =====
        t1 = new JTextField();
        t2 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 14));
        t2.setFont(new Font("Raleway", Font.BOLD, 14));

        // ===== RADIO BUTTONS =====
        r1 = new JRadioButton("Yes");
        r2 = new JRadioButton("No");
        r3 = new JRadioButton("Yes");
        r4 = new JRadioButton("No");

        JRadioButton[] radios = {r1, r2, r3, r4};
        for (JRadioButton rb : radios) {
            rb.setFont(new Font("Raleway", Font.BOLD, 14));
            rb.setBackground(Color.WHITE);
            rb.setSelected(false);
        }

        ButtonGroup seniorCitizen = new ButtonGroup();
        seniorCitizen.add(r1);
        seniorCitizen.add(r2);

        ButtonGroup existingAccount = new ButtonGroup();
        existingAccount.add(r3);
        existingAccount.add(r4);

        // ===== COMBO BOXES =====
        c1 = new JComboBox<>(new String[]{"Hindu", "Muslim", "Sikh", "Christian", "Other"});
        c2 = new JComboBox<>(new String[]{"General", "OBC", "SC", "ST", "Other"});
        c3 = new JComboBox<>(new String[]{"Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000", "Above 10,00,000"});
        c4 = new JComboBox<>(new String[]{"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Others"});
        c5 = new JComboBox<>(new String[]{"Salaried", "Self-Employed", "Farmer", "Business", "Student", "Retired", "Others"});
        
        c1.setFocusable(false);
        c2.setFocusable(false);
        c3.setFocusable(false);
        c4.setFocusable(false);
        c5.setFocusable(false);


        JComboBox[] combos = {c1, c2, c3, c4, c5};
        for (JComboBox cb : combos) {
            cb.setFont(new Font("Raleway", Font.BOLD, 14));
            cb.setBackground(Color.WHITE);
            cb.setSelectedIndex(-1); // 🔥 NO DEFAULT VALUE
        }

        // ===== POSITIONING =====
        l12.setBounds(700, 10, 60, 30); add(l12);
        l13.setBounds(760, 10, 60, 30); add(l13);
        l1.setBounds(280, 30, 600, 40); add(l1);

        l2.setBounds(100, 120, 100, 30); add(l2);
        c1.setBounds(350, 120, 320, 30); add(c1);

        l3.setBounds(100, 170, 100, 30); add(l3);
        c2.setBounds(350, 170, 320, 30); add(c2);

        l4.setBounds(100, 220, 100, 30); add(l4);
        c3.setBounds(350, 220, 320, 30); add(c3);

        l5.setBounds(100, 270, 150, 30); add(l5);
        l11.setBounds(100, 290, 150, 30); add(l11);
        c4.setBounds(350, 270, 320, 30); add(c4);

        l6.setBounds(100, 340, 150, 30); add(l6);
        c5.setBounds(350, 340, 320, 30); add(c5);

        l7.setBounds(100, 390, 150, 30); add(l7);
        t1.setBounds(350, 390, 320, 30); add(t1);

        l8.setBounds(100, 440, 180, 30); add(l8);
        t2.setBounds(350, 440, 320, 30); add(t2);

        l9.setBounds(100, 490, 150, 30); add(l9);
        r1.setBounds(350, 490, 100, 30); add(r1);
        r2.setBounds(460, 490, 100, 30); add(r2);

        l10.setBounds(100, 540, 180, 30); add(l10);
        r3.setBounds(350, 540, 100, 30); add(r3);
        r4.setBounds(460, 540, 100, 30); add(r4);

        b.setBounds(570, 640, 100, 30); add(b);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 750);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (c1.getSelectedIndex() == -1 || c2.getSelectedIndex() == -1 ||
            c3.getSelectedIndex() == -1 || c4.getSelectedIndex() == -1 ||
            c5.getSelectedIndex() == -1 ||
            t1.getText().isEmpty() || t2.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Fill all the required fields");
            return;
        }

        String scitizen = r1.isSelected() ? "Yes" : "No";
        String eaccount = r3.isSelected() ? "Yes" : "No";

        try {
            Conn c = new Conn();
            String q1 = "insert into signup2 values('" + formno + "','" +
                    c1.getSelectedItem() + "','" +
                    c2.getSelectedItem() + "','" +
                    c3.getSelectedItem() + "','" +
                    c4.getSelectedItem() + "','" +
                    c5.getSelectedItem() + "','" +
                    t1.getText() + "','" +
                    t2.getText() + "','" +
                    scitizen + "','" +
                    eaccount + "')";

            c.s.executeUpdate(q1);
            new Signup3(formno);
            setVisible(false);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup2("");
    }
}
