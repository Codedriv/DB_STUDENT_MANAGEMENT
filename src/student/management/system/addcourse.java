
package student.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class addcourse extends JFrame implements ActionListener {
    
    JTextField tfid,tfname,tfinstructor;
    JComboBox tfcredit;
    JButton add,view;
    addcourse()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading =new JLabel("ADD COURSES");
        heading.setBounds(300, 30,500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD ,25));
        add(heading);
        
        JLabel labelid = new JLabel("Course_ID");
        labelid.setBounds(50,150,150,30);
        labelid.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelid);
        
        tfid =new JTextField();
        tfid.setBounds(180, 150, 150, 30);
        add(tfid);
        
        
        JLabel labelname = new JLabel("Course_Name");
        labelname.setBounds(50,220,150,30);
        labelname.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labelname);
        
        tfname =new JTextField();
        tfname.setBounds(180, 220, 150, 30);
        add(tfname);
        
        
        JLabel labeladdress = new JLabel("Instructor");
        labeladdress.setBounds(50,290,150,30);
        labeladdress.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labeladdress);
        
        tfinstructor =new JTextField();
        tfinstructor.setBounds(180, 290, 150, 30);
        add(tfinstructor);
        
        JLabel labeladdres = new JLabel("Credits");
        labeladdres.setBounds(50,360,150,30);
        labeladdres.setFont(new Font("SERIF",Font.PLAIN,20));
        add(labeladdres);
        
        String Credit[]={"","1","2","3"};
        tfcredit =new JComboBox(Credit);
        tfcredit.setBounds(180, 360, 150, 30);
        add(tfcredit);
        
        add = new JButton("Add Course");
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
            String name =tfname.getText();
    
            String instructor =tfinstructor.getText();
            String credit= (String)tfcredit.getSelectedItem();
            
            
                try 
        {
            conn c = new conn();
            String query = "insert into course values("+id+",'"+name+"','"+instructor+"',"+credit+")";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Course Added Successfully");
            setVisible(false);
            new viewcourse();
            
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
        new addcourse();
    }
}
