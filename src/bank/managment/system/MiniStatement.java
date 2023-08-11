
package bank.managment.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;


public class MiniStatement extends JFrame{
    
    MiniStatement(String pinnumber){
        setTitle("Mini Statement");
        
        setLayout(null);
        
        JLabel mini = new JLabel();
        mini.setBounds(10, 100, 400, 200);
        add(mini);
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(100, 20, 100, 20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20, 80, 400, 20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(10, 400, 300, 20);
        add(balance);
        
        
        try{
            
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number :"+ rs.getString("cardnumber").substring(0,5)+"-XXXX-XXXX-" + rs.getString("cardnumber").substring(11));
            
            }
            
            
        
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        
        try{
            
            Conn conn = new Conn();
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() +"<html>"+ rs.getString("date")+ "&nbsp;&nbsp;&nbsp;" + rs.getString("type") +"&nbsp;&nbsp;&nbsp;" + rs.getString("amount")+"<br><br><html>" );
                if(rs.getString("type").equals("Deposite")){
                        bal += Integer.parseInt( rs.getString("amount"));
                    
                    } else {
                        bal -= Integer.parseInt(rs.getString("amount"));
                    
                    }
            
            }
            balance.setText("Your current amount is RS:" +bal);
        
        
        } catch(Exception e){
            System.out.println(e);
        
        
        }
        
//        mini.setBounds(10, 100, 400, 200);
        
        
        setSize(350,600);
        setLocation(10 ,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    
    }
    
    
    public static void main(String args[]){
        
        new MiniStatement("");
    
    }
    
}
