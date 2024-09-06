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
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;

public class EditAccount extends JFrame {

	private JPanel contentPane;
	public static JTextField textField;
	public static JTextField textField_1;
	public static JTextField textField_2;
	public static JPasswordField passwordField;
	public static JPasswordField passwordField_1;
	public static JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditAccount frame = new EditAccount();
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
	public EditAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(Color.WHITE);
		contentPane_1.setBounds(0, 0, 684, 474);
		contentPane.add(contentPane_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(0, 0, 684, 66);
		contentPane_1.add(panel);
		
		JLabel lblNewLabel = new JLabel("ID NUMBER:");
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblNewLabel.setBounds(35, 103, 86, 14);
		contentPane_1.add(lblNewLabel);
		
		JLabel lblLastName = new JLabel("Name:");
		lblLastName.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblLastName.setBounds(56, 151, 65, 14);
		contentPane_1.add(lblLastName);
		
		JLabel lblNewLabel_1_1 = new JLabel("First");
		lblNewLabel_1_1.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(133, 175, 86, 14);
		contentPane_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Password:");
		lblNewLabel_1_1_1.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(35, 217, 86, 14);
		contentPane_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Account type:");
		lblNewLabel_1_1_2.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblNewLabel_1_1_2.setBounds(24, 300, 97, 14);
		contentPane_1.add(lblNewLabel_1_1_2);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(133, 101, 97, 20);
		contentPane_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(133, 149, 97, 20);
		contentPane_1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(244, 149, 103, 20);
		contentPane_1.add(textField_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Last");
		lblNewLabel_1_1_3.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblNewLabel_1_1_3.setBounds(244, 175, 86, 14);
		contentPane_1.add(lblNewLabel_1_1_3);
		
		 comboBox = new JComboBox();
		 comboBox.setModel(new DefaultComboBoxModel(new String[] {"-Select-", "Cashier", "Admin"}));
		comboBox.setBounds(133, 297, 97, 22);
		contentPane_1.add(comboBox);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(133, 215, 97, 20);
		contentPane_1.add(passwordField);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Re-type password:");
		lblNewLabel_1_1_1_1.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblNewLabel_1_1_1_1.setBounds(0, 263, 121, 14);
		contentPane_1.add(lblNewLabel_1_1_1_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(133, 261, 97, 20);
		contentPane_1.add(passwordField_1);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
try {
	
	String fname=textField_1.getText().trim();
	String lname=textField_2.getText().trim();
	String pass=passwordField.getText().trim();
	String rpass=passwordField_1.getText().trim();
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeinfo","root","");
					PreparedStatement ps= conn.prepareStatement("UPDATE `accounts` SET `First_name`='"+fname+"',Last_name='"+lname+"',Password='"+pass+"',Account_type='"+comboBox.getSelectedItem()+"' WHERE Idnumber='"+textField.getText()+"'");
					
					
					
			
					String type=comboBox.getSelectedItem().toString();;
				 
					
					
					
					if ( fname.isEmpty() || lname.isEmpty() || pass.isEmpty() || rpass.isEmpty() || type.equals("-Select-")) {
						JOptionPane.showMessageDialog(null,"update failed");
						
						
					
					}
					
					
					else  
						
					
					
					{

						if (passwordField.getText().equals(passwordField_1.getText()))
						{
							int confirm=JOptionPane.showConfirmDialog(null, "Are u sure?","Warning",JOptionPane.YES_OPTION);
							if (confirm==JOptionPane.YES_OPTION) {
							
							ps.executeUpdate();
							JOptionPane.showMessageDialog(null,"update done");
							
							textField.setText("");
							textField_1.setText("");
							textField_2.setText("");
							passwordField.setText("");
							passwordField_1.setText("");
							comboBox.setSelectedIndex(0);
							
							dispose();
							AdminUI z=new AdminUI();
							z.setVisible(true);
							
							
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
		btnNewButton.setBounds(83, 379, 89, 23);
		contentPane_1.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				AdminUI z=new AdminUI();
				z.setVisible(true);
			}
			
		});
		btnCancel.setBounds(215, 379, 89, 23);
		contentPane_1.add(btnCancel);
		
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
		chckbxNewCheckBox.setBounds(236, 214, 97, 23);
		contentPane_1.add(chckbxNewCheckBox);
	}
}
