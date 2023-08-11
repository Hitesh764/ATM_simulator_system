
package bank.managment.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
    
    JButton back;
    String pinnumber;
    
    BalanceEnquiry(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 690,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 700);
        add(image);
        
        
        back = new JButton("Back");
        back.setBounds(330, 400, 120, 25);
        back.addActionListener(this);
        image.add(back);
        
        Conn c = new Conn();
        int balance = 0;

            
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                while(rs.next()){
                    if(rs.getString("type").equals("Deposite")){
                        balance += Integer.parseInt( rs.getString("amount"));
                    
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    
                    }
                
                }
            }catch(Exception e){
                System.out.println(e);
            
            }
            
            JLabel text = new JLabel("Your current amount is RS: "+ balance);
            text.setForeground(Color.WHITE);
            text.setBounds(160, 240, 400, 30);
            image.add(text);
        
        
        setSize(800,800);
        setLocation(200,0);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new trancation(pinnumber).setVisible(true);
    
    }
    
    
    public static void main(String args[]){
        new BalanceEnquiry("");
        
        
    }
    
}
