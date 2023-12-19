
package student.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class home  extends JFrame implements ActionListener{
    JButton view,add,update,remove,course,enroll,grade;
    home()
    {
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/campus.jpeg"));
        Image i2 =i1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,1120,630);
        add(image);
        
        JLabel heading = new JLabel("Student Managemnet System");
        heading.setBounds(620,20,400,40);
        heading.setFont(new Font("Raleway",Font.BOLD,25));
        image.add(heading);
        
        add = new JButton("Add Student");
        add.setBounds(650,80,150,40);
        add.addActionListener(this);
        image.add(add);
        
        view = new JButton("View Student");
        view.setBounds(820,80,150,40);
        view.addActionListener(this);
        image.add(view);
        
         update = new JButton("Update Student");
        update.setBounds(820,140,150,40);
        update.addActionListener(this);
        image.add(update);
        
        
        remove = new JButton("Remove Student");
        remove.setBounds(650,140,150,40);
        remove.addActionListener(this);
        image.add(remove);
        
        course = new JButton("Course");
        course.setBounds(650,200,150,40);
        course.addActionListener(this);
        image.add(course);
        
        enroll = new JButton("Enroll");
        enroll.setBounds(820,200,150,40);
        enroll.addActionListener(this);
        image.add(enroll);
        
        grade = new JButton("Results");
        grade.setBounds(740,260,150,40);
        grade.addActionListener(this);
        image.add(grade);
        
      
        
        
        setSize(1120,630);
        setLocation(250,100);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==add)
        {
            setVisible(false);
            new addstudent();
        }
        else if(ae.getSource()==view)
        {
            
            setVisible(false);
            new viewstudents();
        }
        else if(ae.getSource()==update)
        {
           setVisible(false);
           new viewstudents();
        }
        else if(ae.getSource()==course)
        {
            setVisible(false);
            new viewcourse();
        }
        else if(ae.getSource()==enroll)
        {
            setVisible(false);
            new viewenroll();
        }
        else if(ae.getSource()== grade)
        {
            setVisible(false);
            new viewgrade();
            
        }
        else
        {
            setVisible(false);
            new removestudent();
            
        }
    }
    public static void main(String [] args)
    {
        new home();
    }
    
}
