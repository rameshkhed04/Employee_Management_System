package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton login,back;
    JLabel username, password;

    JTextField username1;
    JPasswordField password1;

    public Login(){

         username = new JLabel("Username ");
        username.setBounds(100,30,100,30);
        add(username);

         password = new JLabel("Password ");
        password.setBounds(100,80,100,30);
        add(password);

         username1 = new JTextField();
        username1.setBounds(200,30,150,30);
        add(username1);

         password1 = new JPasswordField();
        password1.setBounds(200,80,150,30);
        add(password1);

         login = new JButton("LOGIN");
        login.setBounds(150,130,150,30);
        login.addActionListener(this);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        add(login);

         back = new JButton("BACK");
        back.setBounds(150,180,150,30);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
//        ImageIcon loginB =
        add(back);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i22 = i11.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imagee = new JLabel(i33);
        imagee.setBounds(370,20,600,300);
        add(imagee);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,600,300);
        add(image);




        setSize(600,300);
        setLayout(null);
        setLocation(300,200);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login){
try {
    String user = username1.getText();
    String pass = password1.getText();
    conn conn = new conn();

    String quary = "select * from login where username ='" + user + "' and password = '" + pass + "'";

    ResultSet resultSet = conn.statement.executeQuery(quary);
    if(resultSet.next()){
        setVisible(false);
//        JOptionPane.showMessageDialog(null,"LOGIN SUCCESSFULLY !!");
        new Home_Main();
    }else {
        JOptionPane.showMessageDialog(null,"Invalid Username or Password");

    }

} catch(Exception E){
    E.printStackTrace();
}

        }else if(e.getSource() == back){
            System.exit(100);
        }
    }

    public static void main(String[] args) {

        new Login();

    }
}
