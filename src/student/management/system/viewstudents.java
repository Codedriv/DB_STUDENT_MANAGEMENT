
package student.management.system;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class viewstudents  extends JFrame implements ActionListener{
    
    JTable table;
    Choice Roll_No;
    JButton Search,Update,Print,Back;
    viewstudents()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel searchlbl =new JLabel("Search by student id");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);
        
        Roll_No = new Choice();
        Roll_No.setBounds(180,20,150,20);
        add(Roll_No);
        table = new JTable();
      
        
        try
        {
            conn c= new conn();
            ResultSet rs = c.s.executeQuery("Select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            while(rs.next())
            {
                Roll_No.add(rs.getString("Roll_No"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
          try
        {
            conn c= new conn();
            ResultSet rs = c.s.executeQuery("Select * from student");
            //table.setModel(DbUtils.resultSetToTableModel(rs));
            while(rs.next())
            {
                Roll_No.add(rs.getString("Roll_No"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JScrollPane jsp =new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
        Search = new JButton("Search");
        Search.setBounds(20,70,80,20);
        Search.addActionListener(this);
        add(Search);
        
        Print = new JButton("Print ");
        Print .setBounds(120,70,80,20);
        Print .addActionListener(this);
        add(Print );
        
        Update = new JButton("Update");
        Update.setBounds(220,70,80,20);
        Update.addActionListener(this);
        add(Update);
        
        Back = new JButton("Back");
        Back.setBounds(320,70,80,20);
        Back.addActionListener(this);
        add(Back);
        
       setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==Search)
        {
            String query = "select * from student where  Roll_no = "+Roll_No.getSelectedItem()+"";
            try
            {
                conn c=new conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }
        else if(ae.getSource()== Print)
        {
            try
            {
                table.print();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else if(ae.getSource()== Update)
        {
           setVisible(false);
          new updatestudent (Roll_No.getSelectedItem());
            
        }
        else
        {
          setVisible(false);
          new home();
        }
        
    }
    public static void main(String [] args)
    {
        new viewstudents();
        
    }
}
