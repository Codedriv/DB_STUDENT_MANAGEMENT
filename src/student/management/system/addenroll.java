
package student.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class addenroll extends JFrame implements ActionListener {
    
    JTextField tfid;
    Choice tfname,tfinstructor;
    JComboBox tfcredit;
    JButton add,view;
    addenroll()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading =new JLabel("Add Enroll");
        heading.setBounds(300, 30,500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD ,25));
        add(heading);
        
        JLabel labelid = new JLabel("Enroll_ID");
        labelid.setBounds(50,150,150,30);
        labelid.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelid);
        
        tfid =new JTextField();
        tfid.setBounds(200, 150, 150, 30);
        add(tfid);
        
        
        JLabel labelname = new JLabel("Roll_No");
        labelname.setBounds(50,220,150,30);
        labelname.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelname);
        
        tfname =new Choice();
        tfname.setBounds(200, 220, 150, 30);
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
        
        tfinstructor =new Choice();
        tfinstructor.setBounds(200, 290, 150, 30);
        add(tfinstructor);
        
        try
        {
            conn c= new conn();
            String query = "Select * from course";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next())
            {
                tfinstructor.add(rs.getString("course_id"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JLabel labeladdres = new JLabel("semester");
        labeladdres.setBounds(50,360,150,30);
        labeladdres.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labeladdres);
        
        String Credit[]={"","1","2","3","4","5","6","7","8"};
        tfcredit =new JComboBox(Credit);
        tfcredit.setBounds(200, 360, 150, 30);
        add(tfcredit);
        
        add = new JButton("Add");
        add.setBounds(220,450,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        view = new JButton("Back");
        view.setBounds(410,450,150,40);
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
            String id=tfid.getText();
            String name =(String) tfname.getSelectedItem();
            String instructor =(String)tfinstructor.getSelectedItem();
            String credit= (String)tfcredit.getSelectedItem();
            
            
                try 
        {
            conn c = new conn();
            String query = "insert into enroll values("+id+","+name+","+instructor+","+credit+")";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Course Enrolled Successfully");
            setVisible(false);
            new viewenroll();
            
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
        new addenroll();
    }
}

