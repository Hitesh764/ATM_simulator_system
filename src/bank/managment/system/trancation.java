
package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class trancation extends JFrame implements ActionListener{
    
    JButton deposit,withdraw,fastcash,ministatement,pinchange,blanceenquiry,exit;
    String pinnumber;
    
    trancation(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = im.getImage().getScaledInstance(800, 680, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 770);
        add(image);
        
        JLabel text = new JLabel("Please select your trancation");
        text.setBounds(185, 250, 480, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(150, 350, 130, 23 );
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdraw = new JButton("Cash Withdraw");
        withdraw.setBounds(320, 350, 130, 23 );
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        fastcash = new JButton("Fastcash");
        fastcash.setBounds(150, 380, 130, 23 );
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("Ministatement");
        ministatement.setBounds(320, 380, 130, 23 );
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("Pin change");
        pinchange.setBounds(150, 410, 130, 23 );
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        blanceenquiry = new JButton(" Blance Enquiry");
        blanceenquiry.setBounds(320, 410, 130, 23 );
        blanceenquiry.addActionListener(this);
        image.add(blanceenquiry);
        
        exit = new JButton("Exit");
        exit.setBounds(320, 440, 130, 21 );
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(800,800);
        setLocation(200,0);
        setUndecorated(true);
        setVisible(true);
    
    }
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == exit){
            System.exit(0);
        
        }else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposite(pinnumber).setVisible(true);
        
        } else if(ae.getSource() == withdraw){
            setVisible(false);
            new Withdraw(pinnumber).setVisible(true);
        
        } else if(ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        
        } else if(ae.getSource() == pinchange){
            setVisible(false);
            new Pinchange(pinnumber).setVisible(true);
        
        } else if(ae.getSource() == blanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        
        } else if(ae.getSource() == ministatement){
            new MiniStatement(pinnumber).setVisible(true);
        
        }
    
    }
    public static void main(String args []){
        new trancation(" ");
    
    }
}
