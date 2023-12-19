
package student.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class addstudent  extends JFrame implements ActionListener{
    
    JTextField tfname,tfroll,tfaddress,tfphone,tfemail;
    JComboBox tfgrade;
    JButton view,add;
    addstudent()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading =new JLabel("ADD STUDENT DETAIL");
        heading.setBounds(300, 30,500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD ,25));
        add(heading);
        
        JLabel labelroll = new JLabel("Roll_No");
        labelroll.setBounds(50,150,150,30);
        labelroll.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelroll);
        
        tfroll =new JTextField();
        tfroll.setBounds(150, 150, 150, 30);
        add(tfroll);
        
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,220,150,30);
        labelname.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelname);
        
        tfname =new JTextField();
        tfname.setBounds(150, 220, 150, 30);
        add(tfname);
        
        
        JLabel labeladdress = new JLabel("Address");
        labeladdress.setBounds(50,290,150,30);
        labeladdress.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labeladdress);
        
        tfaddress =new JTextField();
        tfaddress.setBounds(150, 290, 150, 30);
        add(tfaddress);
        
         JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50,360,150,30);
        labelphone.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelphone);
        
         tfphone =new JTextField();
        tfphone.setBounds(150, 360, 150, 30);
        add(tfphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,430,150,30);
        labelemail.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelemail);
        
        tfemail =new JTextField();
        tfemail.setBounds(150,430, 150, 30);
        add(tfemail);
        
        
        JLabel labelgrade = new JLabel("Grade");
        labelgrade.setBounds(50,500,150,30);
        labelgrade.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelgrade);
        
        String QUALIFICATION[]={" ","A","BE","BTECH","BCS","MCS","MBA","OTHERS"};
        tfgrade =new JComboBox(QUALIFICATION);
       tfgrade.setBackground(Color.WHITE);
        tfgrade.setBounds(150, 500, 150, 30);
        add(tfgrade);
        
        add = new JButton("Add Details");
        add.setBounds(220,580,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        view = new JButton("Back");
        view.setBounds(410,580,150,40);
        view.addActionListener(this);
        view.setBackground(Color.BLACK);
        view.setForeground(Color.WHITE);
        add(view);
        
        
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
            
        if(ae.getSource()==add)
        {
            String roll=tfroll.getText();
            String name =tfname.getText();
            
            String phone =tfphone.getText();
            String email=tfemail.getText();
            String address=tfaddress.getText();
            String grade = (String) tfgrade.getSelectedItem();
            
                try 
        {
            conn c = new conn();
            String query = "insert into student values("+roll+",'"+name+"','"+address+"',"+phone+",'"+email+"','"+grade+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Details Added Successfully");
            setVisible(false);
            new home();
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        } 
        else
            {
               setVisible(false);
               new home();
            }
        
    
    }
    public static void main(String [] args)
    {
        new addstudent();
    }
}
