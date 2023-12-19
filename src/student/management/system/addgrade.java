
package student.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class addgrade extends JFrame implements ActionListener {
    
 
   
    Choice tfname,tfcredit;
    JComboBox tfgrade;
    JButton add,view;
    JLabel lbladdress,lbladdresses;

    addgrade()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading =new JLabel("Add Grade");
        heading.setBounds(300, 30,500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD ,25));
        add(heading);
        
        
        
        JLabel labelname = new JLabel("Roll_No");
        labelname.setBounds(50,220,150,30);
        labelname.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelname);
        
        tfname =new Choice();
        tfname.setBounds(250, 220, 150, 30);
        add(tfname);
        try
        {
            conn c= new conn();
            String query = "Select * from student";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                tfname.add(rs.getString("Roll_No"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        
        JLabel labeladdress = new JLabel("course_id");
        labeladdress.setBounds(50,290,150,30);
        labeladdress.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labeladdress);
        
         lbladdress =new JLabel();
        lbladdress.setBounds(250,290,150,30);
        add(lbladdress);
        
       
       
        
        JLabel labeladdreses = new JLabel("semester");
        labeladdreses.setBounds(50,360,150,30);
        labeladdreses.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labeladdreses);
        
        lbladdresses =new JLabel();
        lbladdresses.setBounds(250,360,150,30);
        add(lbladdresses);
        
 
            JLabel labeladdres = new JLabel("grade");
        labeladdres.setBounds(50,430,150,30);
        labeladdres.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labeladdres);
        
        
        
        String Credit[]={"A","B","C","D","E","F"};
        tfgrade =new JComboBox(Credit);
        tfgrade.setBounds(250, 430, 150, 30);
        add(tfgrade);
         
        try
        {
            conn c= new conn();
            String query = "Select * from enroll where Roll_No = "+tfname.getSelectedItem()+"";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                
                lbladdress.setText(rs.getString("Course_ID"));
                lbladdresses.setText(rs.getString("semester"));
                labeladdres.setText(rs.getString("grade"));
                
                
                
                
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        tfname.addItemListener(new ItemListener(){
          public void itemStateChanged(ItemEvent ie){
               try
        {
            conn c= new conn();
            String query = "Select * from enroll where Roll_No = "+tfname.getSelectedItem()+"";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
               
                lbladdress.setText(rs.getString("Course_ID"));
                lbladdresses.setText(rs.getString("semester"));
                labeladdres.setText(rs.getString("grade"));
                
                
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
              
          }
        });
        
        
        add = new JButton("Add");
        add.setBounds(220,470,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        view = new JButton("Back");
        view.setBounds(420,470,150,40);
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
            
            String name =(String) tfname.getSelectedItem();
            String instructor= lbladdress.getText();
            String credit= lbladdresses.getText();
            String grade = (String) tfgrade.getSelectedItem();
            
            
                try 
        {
            conn c = new conn();
            String query = "insert into grade values("+name+","+instructor+","+credit+",'"+grade+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Grade Added Successfully");
            setVisible(false);
            new viewgrade();
            
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
    public static void main(String[] args)
    {
        new addgrade();
    }
}



