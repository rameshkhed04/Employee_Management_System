package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class Remove_Employee extends JFrame implements ActionListener {
    Choice searchID;
    JButton delete,back;

    Remove_Employee(){

        JLabel employee = new JLabel("Employee ID");
        employee.setBounds(50,50,150,40);
     //   employee.setFont(new Font("San_Serif",Font.BOLD,20));
        add(employee);


        JLabel name = new JLabel("Name");
        name.setBounds(50,100,150,40);
        add(name);

        JLabel phone= new JLabel("Phone");
        phone.setBounds(50,150,150,40);
        add(phone);

        JLabel email = new JLabel("Email id");
        email.setBounds(50,200,150,40);
        add(email);

        JLabel tname = new JLabel();
        tname.setBounds(200,100,150,40);
        add(tname);

        JLabel tphone= new JLabel();
        tphone.setBounds(200,150,150,40);
        add(tphone);

        JLabel temail = new JLabel();
        temail.setBounds(200,200,150,40);
        add(temail);

        try {
            conn c = new conn();
            //String quary = "select * from employee where empid = '"+searchID.getSelectedItem()+"'";
            ResultSet resultSet = c.statement.executeQuery("select * from employee where empid = '"+searchID.getSelectedItem()+"'");
            while (resultSet.next()){
                tname.setText(resultSet.getString("name"));
                tphone.setText(resultSet.getString("phone"));
                temail.setText(resultSet.getString("email"));


            }
        }catch (Exception e){
            e.printStackTrace();
        }


        searchID = new Choice();
        searchID.setBounds(200,60,150,40);
        searchID.setVisible(true);
        add(searchID);

        try{
            conn c = new conn();
            c.statement.executeQuery("Select * from employee");
            ResultSet resultSet = c.statement.executeQuery("select * from employee");

            while (resultSet.next()){
                searchID.add(resultSet.getString("empid"));

            }


        }catch (Exception e){
            e.printStackTrace();
        }

       searchID.addItemListener(new ItemListener() {
           @Override
           public void itemStateChanged(ItemEvent e) {
               try {
                   conn c = new conn();
                   String quary = "select * from employee where empid = '"+searchID.getSelectedItem()+"'";
                   ResultSet resultSet = c.statement.executeQuery(quary);
                   while (resultSet.next()){
                       tname.setText(resultSet.getString("name"));
                       tphone.setText(resultSet.getString("phone"));
                       temail.setText(resultSet.getString("email"));
               }
           }catch ( Exception E){
                   E.printStackTrace();
               }
       }});

        delete = new JButton("Delete");
        delete.setBounds(50,300,150,40);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.white);
        add(delete);

        delete.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(250,300,150,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        add(back);
        back.addActionListener(this);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(500,140,200,200);
        add(img);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
        Image i22 = i11.getImage().getScaledInstance(800,500,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imgae = new JLabel(i33);
        imgae.setBounds(0,0,800,500);
        add(imgae);



        setSize(800,500);
        setLayout(null);
        setLocation(150,50);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == delete){
            try{
                conn c = new conn();
                String quary = "delete from employee where empid='"+searchID.getSelectedItem()+"'";
                c.statement.executeUpdate(quary);
                JOptionPane.showMessageDialog(null,"Deleted Successfully !!");
                setVisible(false);
                new Home_Main();

            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource()==back) {
            setVisible(false);
            new Home_Main();

        }
    }

    public static void main(String []args){

        new Remove_Employee();

    }
}
