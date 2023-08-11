
package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener{
    
    JButton deposit,withdraw,fastcash,ministatement,pinchange,blanceEnquiry,exit;
    String pinnumber;
    
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon im = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = im.getImage().getScaledInstance(800, 680, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 770);
        add(image);
        
        JLabel text = new JLabel("Selsect withdraw amount");
        text.setBounds(185, 250, 480, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        deposit = new JButton("RS 100");
        deposit.setBounds(150, 350, 130, 23 );
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdraw = new JButton("RS 500");
        withdraw.setBounds(320, 350, 130, 23 );
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        fastcash = new JButton("RS 1000");
        fastcash.setBounds(150, 380, 130, 23 );
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement = new JButton("RS 2000");
        ministatement.setBounds(320, 380, 130, 23 );
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("RS 5000");
        pinchange.setBounds(150, 410, 130, 23 );
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        blanceEnquiry = new JButton("RS 10000");
        blanceEnquiry.setBounds(320, 410, 130, 23 );
        blanceEnquiry.addActionListener(this);
        image.add(blanceEnquiry);
        
        exit = new JButton("Back");
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
            setVisible(false);
            new trancation(pinnumber).setVisible(true);
        
        }else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposite")){
                        balance += Integer.parseInt( rs.getString("amount"));
                    
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    
                    }
                
                }
                
                if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                
                }
                Date date = new Date();
                String query = "insert into bank  values ('"+pinnumber+"' ,'"+date+"', 'Withdraw' , '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "RS "+amount+" Sucessfully Debit");
                
                setVisible(false);
                new trancation(pinnumber).setVisible(true);
            
            }catch(Exception e){
                System.out.print(e);
            
            }
        
       
        }
    
    }
    public static void main(String args []){
        new FastCash(" ");
    
    }
}
