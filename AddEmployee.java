package employee.management.system;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField tname,tfname,tadrees,tphone,taadhar,temail,tsalary,trole;

    Random ran = new Random();
    int number = ran.nextInt(999999);

    JLabel ranempid;
    JComboBox boxeducation;
    JDateChooser tdob;

    JButton add,back;
    AddEmployee(){

        getContentPane().setBackground(new Color(163,255,188));
        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(340,20,600,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(130,100,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);

        tname = new JTextField();
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

        tdob = new JDateChooser();
        tdob.setBounds(250,150,150,30);
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

        String list[] = {"BBA","BSC","BE", "BTech","MTech","MBA","MCA","BCom","MCom","PHD"};
        boxeducation = new JComboBox(list);
        boxeducation.setBounds(650,250,150,25);
        boxeducation.setBackground(new Color(177,252,197));
        add(boxeducation);

        JLabel aadhar = new JLabel("Aadhar Number");
        aadhar.setBounds(450,300,150,30);
        aadhar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(aadhar);


        taadhar = new JTextField();
        taadhar.setBounds(650,300,150,25);
        taadhar.setBackground(new Color(177,252,197));
        add(taadhar);

        JLabel empid = new JLabel("Emp ID");
        empid.setBounds(110,350,150,30);
        empid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(empid);

        ranempid = new JLabel(""+number);
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

        add = new JButton("Add");
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
    public void actionPerformed(ActionEvent e)  {

        if(e.getSource() == add){
            try {
                String name = tname.getText();
                String fname = tfname.getText();
                String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
                String salary = tsalary.getText();
                String phone = tphone.getText();
                String address = tadrees.getText();
                String aadhar = taadhar.getText();
                String role = trole.getText();
                String education = (String) boxeducation.getSelectedItem();
                String email = temail.getText();
                String empid = (String) ranempid.getText();

                conn conn = new conn();

                String quary = "insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+role+"','"+aadhar+"','"+empid+"')";
                Statement statement;

                conn.statement.executeUpdate(quary);
                JOptionPane.showMessageDialog(null,"Details added Successfully");
                setVisible(false);
                new Home_Main();
//                ResultSet resultset = conn.statement.executeQuery(quary);

            } catch (Exception E){
                E.printStackTrace();
            }



        }else if (e.getSource() == back){
            new Home_Main();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
