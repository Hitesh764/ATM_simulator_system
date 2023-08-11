
package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class SignOne extends JFrame implements ActionListener{ 
    
    long random;
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pinTextField;
    JButton next;
    JRadioButton male,female;
    JDateChooser dateChooser;
    
    SignOne(){
        
        setLayout(null);
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        JLabel formno = new JLabel("APPLICATION FORM NO: " + random);
        formno.setFont(new Font("RALEWAY",Font.BOLD, 38));
        formno.setBounds(100, 20, 600, 40);
        add(formno);
        
        JLabel personalDetails = new JLabel("PAGE 1 Personal Details");
        personalDetails.setFont(new Font("RALEWAY",Font.BOLD, 20));
        personalDetails.setBounds(280, 80, 300, 30);
        add(personalDetails);
        
        JLabel name = new JLabel("NAME:");
        name.setFont(new Font("RALEWAY",Font.BOLD, 18));
        name.setBounds(80, 140, 100, 30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("RALEWAY",Font.BOLD,14));
        nameTextField.setBounds(280, 140, 300, 30);
        add(nameTextField);
        
        
        JLabel fname = new JLabel("Father Name:");
        fname.setFont(new Font("RALEWAY",Font.BOLD, 18));
        fname.setBounds(80, 190, 200, 30);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("RALEWAY",Font.BOLD,14));
        fnameTextField.setBounds(280, 190, 300, 30);
        add(fnameTextField);
        
        JLabel dob = new JLabel("Date Of Birth:");
        dob.setFont(new Font("RALEWAY",Font.BOLD, 18));
        dob.setBounds(80, 240, 200, 30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(280, 240, 300, 30);
        dateChooser.setForeground(Color.BLACK);
        add(dateChooser);
        
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("RALEWAY",Font.BOLD, 18));
        gender.setBounds(80, 290, 200, 30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(280, 290, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(350, 290, 70, 30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        
        JLabel email = new JLabel("Email:");
        email.setFont(new Font("RALEWAY",Font.BOLD, 18));
        email.setBounds(80, 340, 200, 30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("RALEWAY",Font.BOLD,14));
        emailTextField.setBounds(280, 340, 300, 30);
        add(emailTextField);
        
        
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("RALEWAY",Font.BOLD, 18));
        address.setBounds(80, 390, 200, 30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("RALEWAY",Font.BOLD,14));
        addressTextField.setBounds(280, 390, 300, 30);
        add(addressTextField    );
        
        
        JLabel city = new JLabel("City:");
        city.setFont(new Font("RALEWAY",Font.BOLD, 18));
        city.setBounds(80, 440, 200, 30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("RALEWAY",Font.BOLD,14));
        cityTextField.setBounds(280, 440, 300, 30);
        add(cityTextField);
        
        JLabel state = new JLabel("State:");
        state.setFont(new Font("RALEWAY",Font.BOLD, 18));
        state.setBounds(80, 490, 200, 30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("RALEWAY",Font.BOLD,14));
        stateTextField.setBounds(280, 490, 300, 30);
        add(stateTextField);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("RALEWAY",Font.BOLD, 18));
        pin.setBounds(80, 540, 200, 30);
        add(pin);
        
        pinTextField = new JTextField();
        pinTextField.setFont(new Font("RALEWAY",Font.BOLD,14));
        pinTextField.setBounds(280, 540, 300, 30);
        add(pinTextField);
        
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(500, 590, 80, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(750,670);
        setLocation(250,10);
        setVisible(true);
        
    
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        
        } else if(female.isSelected()){
            gender = "Female";
        
        }
        String email = emailTextField.getText();
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String   state = stateTextField.getText();
        String pin = pinTextField.getText();
        
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is requried");
                
            
            } else {
               Conn c = new Conn();
                String query = "Insert into Signup values ( '"+formno+"' , '"+name+"' ,'"+fname+"' ,'"+dob+"','"+gender+"','"+email+"','"+address+"','"+city+"','"+pin+"' , '"+state+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignUpTwo(formno).setVisible(true);
                
            
            }
                
            
        } catch (Exception e){
            
        
        }
    }
    
    public static void main(String args[]){
        
        new SignOne();
    
    }

}