
package student.management.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class removestudent extends JFrame implements ActionListener{
    
    Choice croll;
    JLabel lblname,lbladdress,lblphone,lblemail;
    JButton delete,back;
    removestudent()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel labelroll = new JLabel("Roll_No");
        labelroll.setBounds(50,50,100,30);
        add(labelroll);
        
        croll =new Choice();
        croll.setBounds(200,50,150,30);
        add(croll);
        try
        {
            conn c= new conn();
            String query = "Select * from student";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                croll.add(rs.getString("Roll_No"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        JLabel labelname =new JLabel("Name");
        labelname.setBounds (50,100,100,30);
        add(labelname);
        
        lblname =new JLabel();
        lblname.setBounds(200,100,100,30);
        add(lblname);
        
         JLabel labeladdress =new JLabel("Address");
        labeladdress.setBounds(50,150,100,30);
        add(labeladdress);
        
         lbladdress =new JLabel();
        lbladdress.setBounds(200,150,100,30);
        add(lbladdress);
        
        JLabel labelphone =new JLabel("Phone");
        labelphone.setBounds(50,200,100,30);
        add(labelphone);
        
         lblphone =new JLabel();
        lblphone.setBounds(200,200,100,30);
        add(lblphone);
        
        JLabel labelemail =new JLabel("Email");
        labelemail.setBounds(50,250,100,30);
        add(labelemail);
        
         lblemail =new JLabel();
        lblemail.setBounds(200,250,100,30);
        add(lblemail);
        
        /*JLabel labelgrade =new JLabel("Grade");
        labelgrade.setBounds(50,300,100,30);
        add(labelgrade);
        
        JLabel lblgrade =new JLabel();
        lblgrade.setBounds(200,300,100,30);
        add(lblgrade);
      */  
        try
        {
            conn c= new conn();
            String query = "Select * from student where Roll_No = "+croll.getSelectedItem()+"";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                lblname.setText(rs.getString("Name"));
                lbladdress.setText(rs.getString("Address"));
                lblphone.setText(rs.getString("Phone"));
                lblemail.setText(rs.getString("Email"));
                
                
                
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        croll.addItemListener(new ItemListener(){
          public void itemStateChanged(ItemEvent ie){
               try
        {
            conn c= new conn();
            String query = "Select * from student where Roll_No = "+croll.getSelectedItem()+"";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                lblname.setText(rs.getString("Name"));
                lbladdress.setText(rs.getString("Address"));
                lblphone.setText(rs.getString("Phone"));
                lblemail.setText(rs.getString("Email"));
                
                
                
                
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
              
          }
    });
        
        delete = new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.black);
      //  delete.setForeground(Color.red);
      delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(200,300,100,30);
        back.setBackground(Color.black);
      //  delete.setForeground(Color.red);
      back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
        setSize(900,400);
        setVisible(true);
        setLocation(300,150);
    }
    
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== delete)
        {
            try
            {
                conn c= new conn();
                String Query = "delete  from student where Roll_No = "+croll.getSelectedItem()+"";
                c.s.executeUpdate(Query);
                JOptionPane.showMessageDialog(null,"Student Deatils Deleted Successfully");
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
        new removestudent();
    }
}
