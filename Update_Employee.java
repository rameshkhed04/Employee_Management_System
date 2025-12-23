package employee.management.system;

import javax.swing.*;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

public class Update_Employee extends JFrame implements  ActionListener{

    JTextField teducation,tfname,tadrees,tphone,taadhar,temail,tsalary,trole;
    JButton add,back;

    String number;


    Update_Employee(String number){

        this.number = number;
        getContentPane().setBackground(new Color(163,255,188));
        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(340,20,600,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(130,100,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);

        JLabel tname = new JLabel();
        tname.setBounds(250,100,150,25);
        tname.setBackground(new Color(163,255,188));
        add(tname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(450,100,150,30);
        fname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(650,100,150,25);
        tfname.setBackground(new Color(163,255,188));
        add(tfname);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(70,150,150,30);

        dob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(dob);

        JLabel tdob = new JLabel();
        tdob.setBounds(250,150,150,30);
        tdob.setFont(new Font("Tahoma",Font.BOLD,15));
        setBackground(new Color(163,255,188));
        add(tdob);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(450,150,150,30);
        salary.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(650,150,150,25);
        tsalary.setBackground(new Color(163,255,188));
        add(tsalary);

        JLabel address = new JLabel("Address");
        address.setBounds(110,200,150,30);
        address.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(address);

        tadrees = new JTextField();
        tadrees.setBounds(250,200,150,25);
        tadrees.setBackground(new Color(163,255,188));
        add(tadrees);

        JLabel phone = new JLabel("Phone");
        phone.setBounds(450,200,150,30);
        phone.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(650,200,150,25);
        tphone.setBackground(new Color(163,255,188));
        add(tphone);

        JLabel email = new JLabel("Email");
        email.setBounds(110,250,150,30);
        email.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(email);

        temail = new JTextField();
        temail.setBounds(250,250,150,25);
        temail.setBackground(new Color(163,255,188));
        add(temail);

        JLabel education = new JLabel("Education");
        education.setBounds(450,250,150,30);
        education.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(education);

        teducation = new JTextField();
        teducation.setBounds(650,250,150,25);
        teducation.setBackground(new Color(163,255,188));
        add(teducation);

//       JLabel educationl = new JLabel();
//        educationl.setBounds(650,250,150,25);
//        educationl.setBackground(new Color(177,252,197));
//        add(educationl);

        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(450,300,150,30);
        aadhar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(aadhar);


       JLabel taadhar = new JLabel();
        taadhar.setBounds(650,300,150,25);
        taadhar.setBackground(new Color(177,252,197));
        add(taadhar);

        JLabel empid = new JLabel("Emp ID");
        empid.setBounds(110,350,150,30);
        empid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(empid);

        JLabel ranempid = new JLabel(number);
        ranempid.setBounds(250,350,150,25);
        ranempid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        ranempid.setForeground(Color.RED);
        add(ranempid);



        JLabel designation = new JLabel("Designation");
        designation.setBounds(70,300,150,30);
        designation.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(designation);

        trole = new JTextField();
        trole.setBounds(250,300,150,25);
        trole.setBackground(new Color(163,255,188));
        add(trole);

        try {
            conn c = new conn();
            String quary = "select * from employee where empid = '"+number+"'";
            ResultSet resultSet = c.statement.executeQuery(quary);
            while (resultSet.next()){
                tname.setText(resultSet.getString("name"));
                tfname.setText(resultSet.getString("fname"));
                tdob.setText(resultSet.getString("dob"));
                tadrees.setText(resultSet.getString("address"));
                tsalary.setText(resultSet.getString("salary"));
                tphone.setText(resultSet.getString("phone"));
                temail.setText(resultSet.getString("email"));
                teducation.setText(resultSet.getString("education"));
                trole.setText(resultSet.getString("role"));
                taadhar.setText(resultSet.getString("aadhar"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }




        add = new JButton("Update");
        add.setBounds(260,450,150,40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.white);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBounds(450,450,150,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);








        setSize(900,600);
        setLayout(null);
        setLocation(200,40);
        setVisible(true);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add){
            String fname = tfname.getText();
            String salary = tsalary.getText();
            String address = tadrees.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = teducation.getText();
            String role = trole.getText();

            try{
                conn c = new conn();
                String quary = "update employee set fname='"+fname+"',salary='"+salary+"',address='"+address+"',phone = '"+phone+"',email = '"+email+"',education = '"+education+"',role = '"+role+"' where empid = '"+number+"' ";

                c.statement.executeUpdate(quary);
                JOptionPane.showMessageDialog(null,"Details added Successfully ");
                setVisible(false);
                new View_Employee();

            }catch (Exception E){
                E.printStackTrace();
            }

        }else{
            setVisible(false);
            new View_Employee();
        }

    }

    public static void main(String[] args) {
        new Update_Employee("");
    }
}


