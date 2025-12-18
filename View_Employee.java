package employee.management.system;

import com.mysql.cj.jdbc.result.ResultSetImpl;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class View_Employee extends JFrame implements ActionListener {

    Choice searchid;

    JButton searchbtn,update,print,back;
    JTable table ;

    View_Employee(){


        getContentPane().setBackground(new Color(206,119,117));
        JLabel search = new JLabel("Search Employee by EmpId");
        search.setBounds(50,30,200,20);
        search.setForeground(Color.BLACK);
       // search.setFont(new Font("San_Serif",Font.BOLD,20));
//        setLayout(null);
        add(search);

        searchid = new Choice();
        searchid.setBounds(250,30,150,20);

        searchid.setVisible(true);
        add(searchid);

        try{
            conn c = new conn();
            c.statement.executeQuery("Select * from employee");
            ResultSet resultSet = c.statement.executeQuery("select * from employee");

            while (resultSet.next()){
                searchid.add(resultSet.getString("empid"));

            }


        }catch (Exception e){
            e.printStackTrace();
        }

        table = new JTable();
        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0,100,1000,600);
        add(jp);

         searchbtn = new JButton("Search");
        searchbtn.setBounds(50,60,100,30);
        searchbtn.setForeground(new Color(255, 255, 255));
        searchbtn.setBackground(new Color(0x82ECDC));
        searchbtn.addActionListener(this);
        add(searchbtn);

         update = new JButton("Update");
        update.setBounds(200,60,100,30);
        update.setForeground(new Color(255, 255, 255));
        update.setBackground(new Color(0x82ECDC));
        update.addActionListener(this);
        add(update);

         print = new JButton("Print");
        print.setBounds(350,60,100,30);
        print.setForeground(new Color(255, 255, 255));
        print.setBackground(new Color(0x82ECDC));
        print.addActionListener(this);
        add(print);

         back = new JButton("Back");
        back.setBounds(500,60,100,30);
        back.setForeground(new Color(255, 255, 255));
        back.setBackground(new Color(0x82ECDC));
        back.addActionListener(this);
        add(back);




        setSize(1000,600);
     //   setForeground(new Color(206, 119, 117));
        setLayout(null);
        setLocation(150,50);
        setVisible(true);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == searchbtn) {
            try {
                conn c = new conn();

                ResultSet resultSet =  c.statement.executeQuery("select * from employee where empID = '"+searchid.getSelectedItem()+"'");
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch(Exception E ) {
                E.printStackTrace();

            }
        }else if(e.getSource() == print){
            try{
                table.print();

            }catch ( Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource() == update) {
            setVisible(false);

        }else{
            setVisible(false);
            new Home_Main();
        }

    }

    public static void main(String[] args) {

        new View_Employee();

    }
}
