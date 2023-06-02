package prog5ext;

import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class GUI implements ActionListener {
    static Connection con;

    static JFrame jf = new JFrame("Customer Information");
    static JTextField cusNo=new JTextField(20);
    static JTextField cusName=new JTextField(20);
    static JTextField state=new JTextField(20);
    static JTextField credLim=new JTextField(20);
    static JTextField repNo=new JTextField(20);
    static JButton insertButton=new JButton("Insert");
    static JButton displayAllButton=new JButton("Display all");
    static JButton credFilterButton=new JButton("Display >15k Cred");
    static JTextArea res = new JTextArea();

    static void establishDbConnection() throws Exception
    {	//See the throws exception both in this method and main method
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/suhas";
        String username = "root";
        String password = "root";
        con = DriverManager.getConnection(url, username, password);
        if (con != null)
            System.out.println("Database Connected successfully");
        else
            System.out.println("Database Connection failed");
    }

    public static void main(String[] args) throws Exception {
        establishDbConnection();

        jf.setSize(800,600);
        jf.setLayout(new BoxLayout(jf.getContentPane(),BoxLayout.Y_AXIS));

        jf.add(new JLabel("Customer Number"));
        jf.add(cusNo);
        jf.add(new JLabel("Customer Name"));
        jf.add(cusName);
        jf.add(new JLabel("State"));
        jf.add(state);
        jf.add(new JLabel("Credit limit"));
        jf.add(credLim);
        jf.add(new JLabel("Representative Number"));
        jf.add(repNo);
        jf.add(insertButton);
        jf.add(displayAllButton);

        jf.add(new JLabel("For Credit limit > 15k Click below"));
        jf.add(credFilterButton);

        jf.add(res);

        insertButton.addActionListener(new GUI());
        credFilterButton.addActionListener(new GUI());
        displayAllButton.addActionListener(new GUI());

        jf.setVisible(true);
        jf.pack();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()== insertButton)
        {
            System.out.println("Hell");
            try {
                Statement stm = con.createStatement();
                String ins = "insert into customer values("+cusNo.getText()+",'"+cusName.getText()+"','"+state.getText()+"',"+credLim.getText()+","+repNo.getText()+")";
                stm.executeUpdate(ins);


            } catch (SQLException s) {
                System.out.println(s.toString());
            }
        }

        if(e.getSource()==credFilterButton || e.getSource()==displayAllButton)
        {
            try {
                Statement stm = con.createStatement();
                String ins;
                if(e.getSource()==credFilterButton)
                    ins="select * from customer where CredLim>15000";
                else
                    ins = "select * from customer";
                ResultSet rs= stm.executeQuery(ins);
                res.setText(null);
                res.append("cusNo \t cusName \t state \t credLim \t repNo \n");

                while(rs.next())
                {
                    res.append(rs.getString("cusNo"));
                    res.append("\t");
                    res.append(rs.getString("cusName"));
                    res.append("\t");
                    res.append(rs.getString("state"));
                    res.append("\t");
                    res.append(rs.getString("CredLim"));
                    res.append("\t");
                    res.append(rs.getString("repNo"));
                    res.append("\n");
                }
                jf.pack();

            } catch (SQLException s) {
                System.out.println(s.toString());
            }
        }

    }

}
