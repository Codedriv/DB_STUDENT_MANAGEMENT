
package student.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class viewenroll extends JFrame implements ActionListener {
    
    JTable tables;
    Choice id;
    JButton add,back;
    viewenroll()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel searchlbl =new JLabel("Search By Course_id");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);
        
        id = new Choice();
        id.setBounds(180,20,150,20);
        add(id);
        tables = new JTable();
         try
        {
            conn c= new conn();
            ResultSet rs = c.s.executeQuery("Select * from enroll");
            tables.setModel(DbUtils.resultSetToTableModel(rs));
            while(rs.next())
            {
                id.add(rs.getString("enroll_id"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
          try
        {
            conn c= new conn();
            ResultSet rs = c.s.executeQuery("Select * from enroll");
            //tables.setModel(DbUtils.resultSetToTableModel(rs));
            while(rs.next())
            {
                id.add(rs.getString("enroll_id"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JScrollPane jsp =new JScrollPane(tables);
        jsp.setBounds(0,100,900,600);
        add(jsp);
 
        add= new JButton("Enroll");
        add.setBounds(150,70,160,20);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);
        
       setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }
 
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==add)
        {
            setVisible(false);
            new addenroll();
        }
        else
        {
            setVisible(false);
            new home();
        }
        
    }
    public static void main(String [] args)
    {
        new viewenroll();
    }
}
