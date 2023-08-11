
package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SignUpTwo extends JFrame implements ActionListener{ 
    
    JButton next;
    JTextField pan,adharText;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category,income,occupation;
    String formno;
    
    SignUpTwo( String formno){
        this.formno = formno;
        
        setLayout(null);
        
        
       setTitle("NEW ACCOUNT APPLICATION FROM - PAGE 2");
        
        JLabel additionalDetails = new JLabel("PAGE 2 Additional Details");
        additionalDetails.setFont(new Font("RALEWAY",Font.BOLD, 20));
        additionalDetails.setBounds(280, 80, 300, 30);
        add(additionalDetails);
        
        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("RALEWAY",Font.BOLD, 18));
        name.setBounds(80, 140, 100, 30);
        add(name);
        
        String valReligion[] = {"Hindu","Muslim","Sikh","Christion","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(280, 140, 300, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
          
        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("RALEWAY",Font.BOLD, 18));
        fname.setBounds(80, 190, 200, 30);
        add(fname);
        
        String valCategory[] = {"Obc","Genral","sc","St","Other"};
        category = new JComboBox(valCategory);
        category.setBounds(280, 190, 300, 30);
        category.setBackground(Color.WHITE);
        add(category);
        
        
        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("RALEWAY",Font.BOLD, 18));
        dob.setBounds(80, 240, 200, 30);
        add(dob);
        
        String incomeCategory[] = {"Null","<1,50,000","<2,50,000","<5,00,000","10,00,000"};
        income = new JComboBox(incomeCategory);
        income.setBounds(280, 240, 300, 30);
        income.setBackground(Color.WHITE);
        add(income);
        
       
        
        JLabel gender = new JLabel("Occupation:");
        gender.setFont(new Font("RALEWAY",Font.BOLD, 18));
        gender.setBounds(80, 290, 200, 30);
        add(gender);
        
        String occuptionCategory[] = {"Salaried","Bussiness","Self-employed","Student","Other"};
        occupation = new JComboBox(occuptionCategory);
        occupation.setBounds(280, 290, 300, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
      
        
        JLabel pann = new JLabel("PAN No:");
        pann.setFont(new Font("RALEWAY",Font.BOLD, 18));
        pann.setBounds(80, 340, 200, 30);
        add(pann);
        
        pan = new JTextField();
        pan.setFont(new Font("RALEWAY",Font.BOLD,14));
        pan.setBounds(280, 340, 300, 30);
        add(pan);
        
        
        JLabel adhar = new JLabel("Adhar No:");
        adhar.setFont(new Font("RALEWAY",Font.BOLD, 18));
        adhar.setBounds(80, 390, 200, 30);
        add(adhar);
        
        adharText = new JTextField();
        adharText.setFont(new Font("RALEWAY",Font.BOLD,14));
        adharText.setBounds(280, 390, 300, 30);
        add(adharText);
        
        
        JLabel city = new JLabel("Senior Citizen:");
        city.setFont(new Font("RALEWAY",Font.BOLD, 18));
        city.setBounds(80, 440, 200, 30);
        add(city);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 440, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450, 440, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup citizengroup = new ButtonGroup();
        citizengroup.add(syes);
        citizengroup.add(sno);
        
       
        
        JLabel state = new JLabel("Existing Account:");
        state.setFont(new Font("RALEWAY",Font.BOLD, 18));
        state.setBounds(80, 490, 200, 30);
        add(state);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 490, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450, 490, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup egroup = new ButtonGroup();
        egroup.add(eyes);
        egroup.add(eno);
        
       
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
        
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorCitizen = null;
        if(syes.isSelected()){
            seniorCitizen = "Yes";
        
        } else if(sno.isSelected()){
            seniorCitizen = "No";
        
        }
        
        String existingAccount = null;
        if(eyes.isSelected()){
            seniorCitizen = "Yes";
        
        }else if(eno.isSelected()){
            seniorCitizen = "No";
        
        }
        
        String span = pan.getText();
        String sadhar = adharText.getText();
       
        
        
        try{
            
                Conn c = new Conn();
                String query = "Insert into SignUpTwo values ( '"+formno+"' , '"+sreligion+"' ,'"+scategory+"' ,'"+sincome+"','"+soccupation+"','"+span+"','"+sadhar+"','"+seniorCitizen+"')";
                c.s.executeUpdate(query);
                
                
                setVisible(false);
                new SignUpThree(formno).setVisible(true);
                
            
          
        } catch (Exception e){
            System.out.println(e  );
        
        }
    }
    
    public static void main(String args[]){
        
        new SignUpTwo(" ");
    
    }
    
}
