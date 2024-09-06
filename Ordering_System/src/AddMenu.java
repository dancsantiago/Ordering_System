import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class AddMenu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMenu frame = new AddMenu();
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
	public AddMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 396, 445);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(0, 0, 605, 66);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Menu");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Rockwell", Font.BOLD, 20));
		lblNewLabel_1.setBounds(141, 27, 77, 28);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Category:");
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblNewLabel.setBounds(34, 96, 74, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblName.setBounds(34, 130, 74, 23);
		contentPane.add(lblName);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblPrice.setBounds(34, 164, 74, 23);
		contentPane.add(lblPrice);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblStatus.setBounds(34, 198, 74, 23);
		contentPane.add(lblStatus);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"-Select-", "Burgers", "Meals", "Drinks", "Add-ons"}));
		comboBox.setBounds(118, 97, 93, 22);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"-Select-", "Available", "Not Available"}));
		comboBox_1.setBounds(118, 199, 93, 22);
		contentPane.add(comboBox_1);
		
		textField = new JTextField();
		textField.setBounds(118, 132, 93, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(118, 166, 93, 20);
		contentPane.add(textField_1);
		
		
		
	
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
try {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeinfo","root","");
					PreparedStatement ps= conn.prepareStatement("insert into menu (Category,Menu_name,Price,Status) values (?,?,?,?)");
					
					String mname=textField.getText().trim();
					String price=textField_1.getText().trim();
					String category=comboBox.getSelectedItem().toString();
					String status=comboBox_1.getSelectedItem().toString();
				
					
					ps.setString(1,category);
					ps.setString(2,mname);
					ps.setString(3,price);
					ps.setString(4, status);
					
				 
					
					
					
					if ( mname.isEmpty() || price.isEmpty() ||category.equals("-Select-") || status.equals("-Select-") )   {
						
						
						
						
						
						JOptionPane.showMessageDialog(null,"adding failed");
					
						
						
					
					}else {
						int confirm=JOptionPane.showConfirmDialog(null, "Are u sure?","Warning",JOptionPane.YES_OPTION);
						if (confirm==JOptionPane.YES_OPTION) {
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null,"adding successful");
						textField.setText("");
						textField_1.setText("");
						comboBox.setSelectedIndex(0);
						comboBox_1.setSelectedIndex(0);
						}
						else
						{
							
						}
					}
					
					
				
					
				} catch(Exception e1){
					System.out.println(e1);
					
				}
				
			}
		});
		btnNewButton.setBounds(72, 286, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminUI f=new AdminUI();
				f.setVisible(true);
			}
		});
		btnCancel.setBounds(171, 286, 89, 23);
		contentPane.add(btnCancel);
		
		
	}
}
