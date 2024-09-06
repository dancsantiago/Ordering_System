import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class AddAccount extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAccount frame = new AddAccount();
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
	public AddAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 592);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(0, 0, 684, 66);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Account");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Rockwell", Font.BOLD, 20));
		lblNewLabel_1.setBounds(171, 27, 111, 28);
		panel.add(lblNewLabel_1);
		
		JLabel lblLastName = new JLabel("Name:");
		lblLastName.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblLastName.setBounds(56, 151, 65, 14);
		contentPane.add(lblLastName);
		
		JLabel lblNewLabel_1_1 = new JLabel("First");
		lblNewLabel_1_1.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(133, 175, 86, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Password:");
		lblNewLabel_1_1_1.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(35, 217, 86, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Account type:");
		lblNewLabel_1_1_2.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblNewLabel_1_1_2.setBounds(24, 300, 97, 14);
		contentPane.add(lblNewLabel_1_1_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(133, 149, 97, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(244, 149, 103, 20);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Last");
		lblNewLabel_1_1_3.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblNewLabel_1_1_3.setBounds(244, 175, 86, 14);
		contentPane.add(lblNewLabel_1_1_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"-Select-", "Cashier", "Admin"}));
		comboBox.setBounds(133, 297, 97, 22);
		contentPane.add(comboBox);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(133, 215, 97, 20);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Re-type password:");
		lblNewLabel_1_1_1_1.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblNewLabel_1_1_1_1.setBounds(0, 263, 121, 14);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(133, 261, 97, 20);
		contentPane.add(passwordField_1);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	String acctype =comboBox.getSelectedItem().toString();
				
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeinfo","root","");
					PreparedStatement ps= conn.prepareStatement("insert into accounts (First_Name,Last_Name,Password,Account_type) values (?,?,?,?)");
					
					String fname=textField_1.getText().trim();
					String lname=textField_2.getText().trim();
					String pass=passwordField.getText().trim();
					String rpass=passwordField_1.getText().trim();
					
					ps.setString(1,fname);
					ps.setString(2,lname);
					ps.setString(3,pass);
					ps.setString(4, acctype);
					
				 
					
					
					
					if ( fname.isEmpty() || lname.isEmpty() || pass.isEmpty() || rpass.isEmpty() || acctype.equals("-Select-")) {
						JOptionPane.showMessageDialog(null,"Registration failed");
						
						
					
					}
					
					
					else  
						
					
					
					{

						if (passwordField.getText().equals(passwordField_1.getText()))
						{
							int confirm=JOptionPane.showConfirmDialog(null, "Are u sure?","Warning",JOptionPane.YES_OPTION);
							if (confirm==JOptionPane.YES_OPTION) {
							
							ps.executeUpdate();
							JOptionPane.showMessageDialog(null,"Registration done");
							
						
							textField_1.setText("");
							textField_2.setText("");
							passwordField.setText("");
							passwordField_1.setText("");
							comboBox.setSelectedIndex(0);
							
							AdminUI z=new AdminUI();
							z.setVisible(false);
							z.refreshdata();
							
							}
							
						}
						
						else {
						
							JOptionPane.showMessageDialog(null,"Password do not match");
							
						}
						
						
						
					}
					
				} catch(Exception e1){
					System.out.println(e1);
					
				}
				
			}
		});
		btnNewButton.setBounds(179, 379, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminUI w= new AdminUI();
				w.setVisible(true);
			}
		});
		btnCancel.setBounds(294, 379, 89, 23);
		contentPane.add(btnCancel);
	}
}
