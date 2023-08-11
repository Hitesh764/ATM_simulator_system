
package bank.managment.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Pinchange extends JFrame implements ActionListener{
    
    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;
    
    Pinchange(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800, 690,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 700);
        add(image);
        
        JLabel text = new JLabel("Change Your Pin");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250, 220, 500, 35);
        image.add(text);
        
        JLabel pitext = new JLabel("New Pin:");
        pitext.setForeground(Color.WHITE);
        pitext.setFont(new Font("System",Font.BOLD,16));
        pitext.setBounds(155, 250, 200, 35);
        image.add(pitext);
        
        pin = new JPasswordField();
        pin.setFont(new Font("System",Font.BOLD,16));
        pin.setBounds(270, 260, 180, 25);
        image.add(pin);

        
        
        JLabel repitext = new JLabel("Re-Enter Pin:");
        repitext.setForeground(Color.WHITE);
        repitext.setFont(new Font("System",Font.BOLD,16));
        repitext.setBounds(155, 290, 200, 35);
        image.add(repitext);
        
        
        repin = new JPasswordField();
        repin.setFont(new Font("System",Font.BOLD,16));
        repin.setBounds(270, 300, 180, 25);
        image.add(repin);
        
        
        change = new JButton("Change");
        change.setBounds(320, 350, 120, 25);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("Back");
        back.setBounds(320, 390, 120, 25);
        back.addActionListener(this);
        image.add(back);
        
        setSize(800,800);
        setLocation(200,0);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == change){
        
        try{
            String npin = pin.getText();
            String rpin = repin.getText();
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null,"Pin Doesn't Match");
                return;
            
            }
            
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter New PIN");
                return;
            
            }
            
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null,"Please Re-enter New PIN");
                return;
            
            }
            
            Conn conn = new Conn();
            String query1 = "update bank set pin = '"+rpin+"' where pin='"+pinnumber+"'";
            String query2 = "update login set pin = '"+rpin+"' where pin='"+pinnumber+"'";
            String query3 = "update signupthree set pinnumber = '"+rpin+"' where pinnumber='"+pinnumber+"'";
            
            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);
            conn.s.executeUpdate(query3);
            
            JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
            
            setVisible(false);
            new trancation(rpin).setVisible(true);




            
        
        } catch(Exception e){
            System.out.print(e);
        } 
        
        } else {
            setVisible(false);
            new trancation(pinnumber).setVisible(true);
        
        }
    
    }
    
    
    public static void main(String args[]){
        new Pinchange("").setVisible(true);
    
    }
    
}
