
package student.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class updatestudent extends JFrame implements ActionListener{
    
    JTextField tfgrades,tfaddress,tfphone,tfemail;
    JLabel lblroll,lblname;
    String rollno;
    JButton view,add;
    updatestudent(String rollno)
    {
        this.rollno = rollno;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading =new JLabel("Update STUDENT DETAIL");
        heading.setBounds(300, 30,500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD ,25));
        add(heading);
        
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,220,150,30);
        labelname.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelname);
        
        lblname =new JLabel();
        lblname.setBounds(150, 220, 150, 30);
        add(lblname);
        
        
        
        
        
        
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
        
        
        tfgrades = new JTextField();
        tfgrades.setBounds(150, 500, 150, 30);
        add(tfgrades);
        
        JLabel labelroll = new JLabel("Roll_No");
        labelroll.setBounds(50,150,150,30);
        labelroll.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelroll);
        
        lblroll =new JLabel();
        lblroll.setBounds(150, 150, 150, 30);
        add(lblroll);
        
        try
        {
            conn c=new conn();
            String query =" select * from student where Roll_No="+rollno+"";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                lblroll.setText(rs.getString("Roll_No"));
                lblname.setText(rs.getString("Name"));
                tfaddress.setText(rs.getString("Address"));
                tfphone.setText(rs.getString("Phone"));
                tfemail.setText(rs.getString("Email"));
                tfgrades.setText(rs.getString("Grade"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        add = new JButton("Update Details");
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
           
            String roll= lblroll.getText();
            String phone =tfphone.getText();
            String email=tfemail.getText();
            String address=tfaddress.getText();
            String grade =  tfgrades.getText();
            
            
                try 
        {
            conn c = new conn();
            String query = "Update student set Address ='"+address+"',Phone ="+phone+",Email ='"+email+"',Grade ='"+grade+"' where Roll_No ="+roll+"";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Details Updated Successfully");
            setVisible(false);
            new viewstudents();
            
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
        new updatestudent("");
    }
}
