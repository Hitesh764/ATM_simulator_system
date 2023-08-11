
package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;




public class Deposite extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton deposite,back;
    String pinnumber;
    
    Deposite(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon (ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 680, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 700);
        add(image);
        
        
        JLabel text = new JLabel("Enter the amount you want deposite");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(155, 230, 480, 35);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,20));
        amount.setBounds(180, 280, 230, 30);
        image.add(amount);
        
        deposite = new JButton("Deposite");
        deposite.setBounds(350, 375, 100, 22);
        deposite.addActionListener(this);
        image.add(deposite);
        
        back = new JButton("Back");
        back.setBounds(350, 400, 100, 22);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(800,800);
        setLocation(200,0);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == deposite){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, " Please Enter the amount");
            
            } else {
                try{
                    
                Conn conn = new Conn();
                String query = "insert into bank values ('"+pinnumber+"' , '"+date+"' , 'Deposite', '"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "RS:"+ number +" Deposite Successfully");
                setVisible(false);
                new trancation (pinnumber).setVisible(true);
            
                
                }catch(Exception e){
                    System.out.println(e);
                
                }
            }
                
        
        } else if(ae.getSource() == back){
            setVisible(false);
            new trancation(pinnumber).setVisible(true);
        
        }
    
    }
    
    public static void main(String args[]){
        
        new Deposite(" ");
    
    
    }
    
}
