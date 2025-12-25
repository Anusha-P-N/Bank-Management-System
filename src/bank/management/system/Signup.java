package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class Signup extends JFrame implements ActionListener {

    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JRadioButton r1,r2,r3,r4,r5;
    JButton b;
    JDateChooser dateChooser;   // ✅ class-level

    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = "" + Math.abs(first4);

    Signup(){

        setTitle("NEW ACCOUNT APPLICATION FORM");

        ImageIcon i1 = new ImageIcon(
                Signup.class.getResource("/icons/logo.jpg")
        );
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel logo = new JLabel(i3);
        logo.setBounds(20, 0, 100, 100);
        add(logo);

        l1 = new JLabel("APPLICATION FORM NO. " + first);
        l1.setFont(new Font("Raleway", Font.BOLD, 38));

        l2 = new JLabel("Page 1: Personal Details");
        l2.setFont(new Font("Raleway", Font.BOLD, 22));

        l3 = new JLabel("Name:");
        l4 = new JLabel("Father's Name:");
        l5 = new JLabel("Date of Birth:");
        l6 = new JLabel("Gender:");
        l7 = new JLabel("Email Address:");
        l8 = new JLabel("Marital Status:");
        l9 = new JLabel("Address:");
        l10 = new JLabel("City:");
        l11 = new JLabel("Pin Code:");
        l12 = new JLabel("State:");

        JLabel[] labels = {l3,l4,l5,l6,l7,l8,l9,l10,l11,l12};
        for(JLabel lbl : labels) {
            lbl.setFont(new Font("Raleway", Font.BOLD, 20));
        }

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();

        JTextField[] fields = {t1,t2,t3,t4,t5,t6,t7};
        for(JTextField tf : fields) {
            tf.setFont(new Font("Raleway", Font.BOLD, 14));
        }

        // ✅ CORRECT INITIALIZATION
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);

        r1 = new JRadioButton("Male");
        r2 = new JRadioButton("Female");
        r3 = new JRadioButton("Married");
        r4 = new JRadioButton("Unmarried");
        r5 = new JRadioButton("Other");

        JRadioButton[] radios = {r1,r2,r3,r4,r5};
        for(JRadioButton rb : radios){
            rb.setFont(new Font("Raleway", Font.BOLD, 14));
            rb.setBackground(Color.WHITE);
        }

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(r1);
        genderGroup.add(r2);

        ButtonGroup statusGroup = new ButtonGroup();
        statusGroup.add(r3);
        statusGroup.add(r4);
        statusGroup.add(r5);

        b = new JButton("Next");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.addActionListener(this);

        setLayout(null);

        l1.setBounds(140,20,600,40); add(l1);
        l2.setBounds(290,80,600,30); add(l2);

        l3.setBounds(100,140,100,30); add(l3);
        t1.setBounds(300,140,400,30); add(t1);

        l4.setBounds(100,190,200,30); add(l4);
        t2.setBounds(300,190,400,30); add(t2);

        l5.setBounds(100,240,200,30); add(l5);

        l6.setBounds(100,290,200,30); add(l6);
        r1.setBounds(300,290,60,30); add(r1);
        r2.setBounds(450,290,90,30); add(r2);

        l7.setBounds(100,340,200,30); add(l7);
        t3.setBounds(300,340,400,30); add(t3);

        l8.setBounds(100,390,200,30); add(l8);
        r3.setBounds(300,390,100,30); add(r3);
        r4.setBounds(450,390,120,30); add(r4);
        r5.setBounds(600,390,100,30); add(r5);

        l9.setBounds(100,440,200,30); add(l9);
        t4.setBounds(300,440,400,30); add(t4);

        l10.setBounds(100,490,200,30); add(l10);
        t5.setBounds(300,490,400,30); add(t5);

        l11.setBounds(100,540,200,30); add(l11);
        t6.setBounds(300,540,400,30); add(t6);

        l12.setBounds(100,590,200,30); add(l12);
        t7.setBounds(300,590,400,30); add(t7);

        b.setBounds(620,660,80,30); add(b);

        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        String formno = first;
        String name = t1.getText();
        String fname = t2.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();

        String gender = r1.isSelected() ? "Male" : r2.isSelected() ? "Female" : null;
        String email = t3.getText();

        String marital = r3.isSelected() ? "Married" :
                         r4.isSelected() ? "Unmarried" :
                         r5.isSelected() ? "Other" : null;

        String address = t4.getText();
        String city = t5.getText();
        String pincode = t6.getText();
        String state = t7.getText();

        try{
            if(name.equals("") || dob.equals("")){
                JOptionPane.showMessageDialog(null, "Fill all required fields");
            } else {
                Conn c1 = new Conn();
                String q = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
                c1.s.executeUpdate(q);

                new Signup2(formno).setVisible(true);
                setVisible(false);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new Signup();
    }
}
