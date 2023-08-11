
package bank.managment.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class SignUpThree extends JFrame implements ActionListener{
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    
    SignUpThree(String formno){
        this.formno = formno;
        
        setLayout(null);
        
        JLabel l1 = new JLabel("Page 3 : Account Details");
        l1.setFont(new Font("RALEWAY",Font.BOLD, 20));
        l1.setBounds(280, 40, 300, 30);
        add(l1);
        
          
        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("RALEWAY",Font.BOLD, 20));
        type.setBounds(100, 140, 200, 30);
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setBounds(100, 180, 150, 20);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposite Account");
        r2.setBounds(350, 180, 200, 20);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setBounds(100, 220, 150, 20);
        add(r3);
        
        r4 = new JRadioButton("Recurring Account");
        r4.setBounds(350, 220, 150, 20);
        add(r4);
        
        ButtonGroup groupButton = new ButtonGroup();
        groupButton.add(r1);
        groupButton.add(r2);
        groupButton.add(r3);
        groupButton.add(r4);
        
        JLabel card = new JLabel("Card Number :");
        card.setFont(new Font("RALEWAY",Font.BOLD, 20));
        card.setBounds(100, 280, 200, 30);
        add(card);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-8721 ");
        number.setFont(new Font("RALEWAY",Font.BOLD, 20));
        number.setBounds(310, 280, 300, 30);
        add(number);
        
        JLabel pin = new JLabel("PIN : ");
        pin.setFont(new Font("RALEWAY",Font.BOLD, 20));
        pin.setBounds(100, 340, 200, 30);
        add(pin);
        
        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("RALEWAY",Font.BOLD, 20));
        pnumber.setBounds(310, 340, 300, 30);
        add(pnumber);
        
        JLabel service = new JLabel("Service Requried :");
        service.setFont(new Font("RALEWAY",Font.BOLD, 20));
        service.setBounds(100, 400, 300, 30);
        add(service);
        
        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Ralewat",Font.BOLD,16));
        c1.setBounds(100, 430, 200, 25);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350, 430, 200, 25);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100, 470, 200, 25);
        add(c3);
        
        c4 = new JCheckBox("Email & SMS");
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350, 470, 200, 25);
        add(c4);
        
        c5 = new JCheckBox("Check Book");
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100, 520, 200, 25);
        add(c5);
        
        c6 = new JCheckBox("E-statement");
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350, 520, 200, 25);
        add(c6);
        
        c7 = new JCheckBox("I heared declare that above the details");
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100, 550, 400, 30);
        add(c7);
        
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(250, 600, 100, 30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(400, 600, 100, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        
        getContentPane().setBackground(Color.white);
        
        
        
        setSize(750,670);
        setLocation(250,10);
        setVisible(true);
        
    
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String accountType = null;
            if(r1.isSelected()){
                accountType = "Saving Account";
            } else if(r2.isSelected()){
                accountType = "Fixed Disposite Account";
            
            }else if(r3.isSelected()){
                accountType = "Currrent Account";
            
            }else if(r4.isSelected()){
                accountType = "Reccurin Account";
            
            }
            Random random = new Random();
            String cardnumber = " " + Math.abs((random.nextLong() % 9000L)) + 5040936000L;
            
            String pinnumber = " " + Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String faclity = " ";
            
            if(c1.isSelected()){
                faclity = faclity + "ATM Card";
            
            } else if(c2.isSelected()){
                faclity = faclity + "Internet Banking";
            
            } else if(c3.isSelected()){
                faclity = faclity + "Mobile Banking";
            
            } else if(c4.isSelected()){
                faclity = faclity + "Email & SMS";
            
            } else if(c5.isSelected()){
                faclity = faclity + "Check Book";
            
            } else if(c6.isSelected()){
                faclity = faclity + "E-statement";  
            
            }
            
            try {
                if(accountType.equals(" ")){
                    JOptionPane.showMessageDialog(null, "Account type is requried");
                    
                
                } else {
                   Conn conn = new Conn();
                   String query1 = "insert into signupthree values('"+formno+"' , '"+accountType+"','"+cardnumber+"'  , '"+pinnumber+"' , '"+faclity+"')";
                   String query2 = "insert into login values('"+formno+"' , '"+cardnumber+"'  , '"+pinnumber+"')";

                   conn.s.executeUpdate(query1);
                   conn.s.executeUpdate(query2);
                   
                   JOptionPane.showMessageDialog(null, "Card Number:"+cardnumber+"\n PIN:"+pinnumber);
                   
                   setVisible(false);
                   new Deposite(pinnumber).setVisible(false);

                
                }
            
            } catch (Exception e){
                System.out.println(e);
            
            }
            
          
        
        } else if(ae.getSource() == cancel){
            
            setVisible(false);
            new Login().setVisible(true);
        
        }
    
    }
        
    public static void main(String args[]){
       new SignUpThree("");
    
    }
    
}
