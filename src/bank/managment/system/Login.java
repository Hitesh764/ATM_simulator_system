 
package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener  {
    
    JButton login,clear,signUp;
    JTextField cardTextField;
    JPasswordField pinTextField;
     
     
    Login(){
        
        setTitle("Automatic Teller Machin");
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);  
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("osward",Font.BOLD,38));
        text.setBounds(200, 40, 400, 40);
        add(text);
        
         JLabel cardNo = new JLabel("Card No :");
        cardNo.setFont(new Font("Raleway",Font.BOLD,28));
        cardNo.setBounds(120, 130, 150, 30);
        add(cardNo);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(260, 135, 240, 30);
        add(cardTextField);
        
         JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("osward",Font.BOLD,28));
        pin.setBounds(120, 180, 150, 30);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(260, 190, 240, 30);
        add(pinTextField);
        
        login = new JButton("SIGN IN");
        login.setBounds(260, 250, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(400, 250, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signUp = new JButton("SIGN UP");
        signUp.setBounds(260, 300, 240, 30);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(700,420);
        setVisible(true);
        setLocation(300,120);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
            
        } else if(ae.getSource() == login){
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            
            try{
                ResultSet rs =  conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new trancation(pinnumber).setVisible(true);
                
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card No or Pin");
                  
                }
                
            
            } catch(Exception e){
                System.out.print(e);
            
            }
        
        } else if(ae.getSource() == signUp){
            setVisible(false);
            new SignOne().setVisible(true);
        
        }
        
    }
        
        
    public static void main(String args[]){
        new Login();
        
    }
    
}
