import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

 public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 361);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.RED);
		panel.setBounds(0, 0, 507, 63);
		contentPane.add(panel);
		
		JLabel lblNewLabel_4 = new JLabel("Chick n' chill");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Rockwell", Font.PLAIN, 29));
		lblNewLabel_4.setBounds(10, 11, 247, 53);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("ID NUMBER:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(28, 111, 89, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(140, 108, 138, 20);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(28, 141, 84, 14);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(140, 139, 138, 20);
		contentPane.add(passwordField);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Show");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (chckbxNewCheckBox.isSelected()) {
					
					passwordField.setEchoChar((char)0);
				}else {
					
					passwordField.setEchoChar('*');
				}
			}
		});
		chckbxNewCheckBox.setBackground(Color.WHITE);
		chckbxNewCheckBox.setBounds(134, 176, 114, 23);
		contentPane.add(chckbxNewCheckBox);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"-Select-", "Admin", "Cashier"}));
		comboBox.setBounds(191, 254, 87, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String typee=comboBox.getSelectedItem().toString();
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeinfo","root","");
					//String sql="SELECT * FROM `accounts` WHERE Idnumber='"+textField.getText()+"' and Password='"+passwordField.getText()+"'";
					String sqql="SELECT Idnumber,Password,Account_type FROM `accounts` WHERE Idnumber='"+textField.getText()+"'and Password='"+passwordField.getText()+"'and Account_type='"+typee+"'";
					Statement stmt=conn.createStatement();
					ResultSet rs= stmt.executeQuery(sqql);
				
					if(rs.next()) {
						
									if (typee.equals("Admin")) {
						JOptionPane.showMessageDialog (null, "Login Successfully");
										dispose();
									
									
									AdminUI sad=new AdminUI();
									
									String id=textField.getText();
									sad.idtxt.setText(textField.getText());
									sad.positiontxt.setText(typee);
									sad.setVisible(true);
									
									
									}
									
									else {
										JOptionPane.showMessageDialog (null, "Login Successfully");
									dispose();
									
									
									//CashierUI saa=new CashierUI();
									//saa.setVisible(true); 
									//saa.idtxt.setText(textField.getText());
									dispose();
									CashierrUI s=new CashierrUI();
									s.setVisible(true);
									s.idtxt.setText(textField.getText());
						
									}
								
								
					}
						
					else {
						
						JOptionPane.showMessageDialog(null, "Login Failed");
						textField.setText("");
						passwordField.setText("");
					}
			
					
		
						
					
					
					
				} catch(Exception e1){
					System.out.println(e1);
					
				}
			}
			
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setBounds(84, 213, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnExit.setBackground(Color.RED);
		btnExit.setBounds(189, 213, 89, 23);
		contentPane.add(btnExit);
		
		
		
		JLabel lblLogInAs = new JLabel("Log in as:");
		lblLogInAs.setFont(new Font("Arial", Font.BOLD, 12));
		lblLogInAs.setBounds(113, 258, 61, 14);
		contentPane.add(lblLogInAs);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\icons8-name-24.png"));
		lblNewLabel_2.setBounds(288, 112, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\icons8-password-1-24.png"));
		lblNewLabel_3.setBounds(288, 142, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\User\\Downloads\\1604236237193.png"));
		lblNewLabel_5.setBounds(254, 63, 269, 346);
		contentPane.add(lblNewLabel_5);
	}
}
