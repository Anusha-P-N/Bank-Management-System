package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Transactions extends JFrame implements ActionListener {

	JButton deposit, withdrawl, statement, pinchange, balance, fastcash, exit;
	String pin;
	    Transactions(String pin){
	    	this.pin = pin;                         //storing local variable in global variable
	    	
	    	setLayout(null);
	        
	        ImageIcon i1 = new ImageIcon(
	                Transactions.class.getResource("/icons/atm.jpg")
	        );
	        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
	        ImageIcon i3 = new ImageIcon(i2);
	        JLabel image = new JLabel(i3);
	        image.setBounds(0, 0, 900, 900);
	        add(image);
	        
	        
	        
            JLabel text = new JLabel("Please Select Your Transaction");
	        text.setBounds(210, 300, 700, 35);
 	        text.setForeground(Color.WHITE);
	        text.setFont(new Font("System", Font.BOLD, 16));
	        image.add(text);
	        

	        deposit = new JButton("DEPOSIT");
	        deposit.setBounds(170,415,150,30);
	        deposit.addActionListener(this);
	        image.add(deposit);
	        
	        withdrawl = new JButton("CASH WITHDRAWL");
	        withdrawl.setBounds(355,415,150,30);
	        withdrawl.addActionListener(this);
	        image.add(withdrawl);
	        
	        fastcash = new JButton("FASTCASH");
	        fastcash.setBounds(170,450,150,30);
	        fastcash.addActionListener(this);
	        image.add(fastcash);
	        
	        statement = new JButton("MINI STATEMENT");
	        statement.setBounds(355,450,150,30);
	        statement.addActionListener(this);
	        image.add(statement);
	        
	        pinchange = new JButton("PIN CHANGE");
	        pinchange.setBounds(170,485,150,30);
	        pinchange.addActionListener(this);
	        image.add(pinchange);
	        
	        balance = new JButton("BALANCE ENQUIRY");
	        balance.setBounds(355,485,150,30);
	        balance.addActionListener(this);
	        image.add(balance);
	        
	        exit = new JButton("EXIT");
	        exit.setBounds(355,520,150,30);
	        exit.addActionListener(this);
	        image.add(exit);
            
	        setSize(900,900);
	        setLocation(300,0);
//	        setUndecorated(true);
	        setVisible(true);
	        
	        
	        
	    }
	    
	    public void actionPerformed(ActionEvent ae){
	     if(ae.getSource()==exit){ 
	            System.exit(0);            
	     }else if(ae.getSource()==deposit){ 
	            setVisible(false);
	        new Deposit(pin).setVisible(true);
	     }else if(ae.getSource()==withdrawl){ 
	            setVisible(false);
	        new Withdrawl(pin).setVisible(true);            
	     }else if(ae.getSource()==fastcash){ 
	        	setVisible(false);
	            new FastCash(pin).setVisible(true);
	     }else if(ae.getSource()==pinchange){ 
	        	setVisible(false);
	            new PinChange(pin).setVisible(true);
	     }else if(ae.getSource()==balance){ 
	        	setVisible(false);
	            new BalanceEnquiry(pin).setVisible(true);
	     }else if(ae.getSource()==statement){ 
	        	setVisible(false);
	            new MiniStatement(pin).setVisible(true);
//	            new MiniStatement(pin).setVisible(true);
//	        }else if(ae.getSource()==b5){ 
//	            setVisible(false);
//	            new Pin(pin).setVisible(true);
//	        }else if(ae.getSource()==b6){ 
//	            this.setVisible(false);
//	            new BalanceEnquiry(pin).setVisible(true);
//	        }else if(ae.getSource()==b7){ 
//	            System.exit(0);
        }
  }
	    
	    public static void main(String[] args){
	        new Transactions("");              //.setVisible(true);
	    }
	}