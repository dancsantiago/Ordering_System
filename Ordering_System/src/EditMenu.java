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
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class EditMenu extends JFrame {

	private JPanel contentPane;
	public static JTextField textField;
	public static JTextField textField_1;
	public static JComboBox comboBox;
	public static JComboBox comboBox_1;
	public static JLabel labelcode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditMenu frame = new EditMenu();
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
	public EditMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(Color.WHITE);
		contentPane_1.setBounds(0, 0, 380, 406);
		contentPane.add(contentPane_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(0, 0, 605, 66);
		contentPane_1.add(panel);
		
		JLabel lblNewLabel = new JLabel("Category:");
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblNewLabel.setBounds(34, 126, 74, 23);
		contentPane_1.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblName.setBounds(34, 160, 74, 23);
		contentPane_1.add(lblName);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblPrice.setBounds(34, 194, 74, 23);
		contentPane_1.add(lblPrice);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblStatus.setBounds(34, 228, 74, 23);
		contentPane_1.add(lblStatus);
		
		 comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"-Select-", "Burger", "Meals", "Drinks", "Add-ons"}));
		comboBox.setBounds(118, 134, 93, 22);
		contentPane_1.add(comboBox);
		
		 comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"-Select-", "Available", "Not available"}));
		comboBox_1.setBounds(118, 229, 93, 22);
		contentPane_1.add(comboBox_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(118, 167, 93, 20);
		contentPane_1.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(118, 198, 93, 20);
		contentPane_1.add(textField_1);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String mname=textField.getText().trim();
				String price=textField_1.getText().trim();
				String category=comboBox.getSelectedItem().toString();
				String status=comboBox_1.getSelectedItem().toString();
			
				
						try {
							
							Class.forName("com.mysql.jdbc.Driver");
							Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeinfo","root","");
							PreparedStatement ps= conn.prepareStatement("UPDATE `menu` SET `Category`='"+category+"',`Menu_name` ='"+mname+"',`Price`='"+price+"',`Status`='"+status+"' WHERE Menu_code='"+labelcode.getText()+"'");
							
							

							
						 
							
							
							
							if ( mname.isEmpty() || price.isEmpty() ||category.equals("-Select-") || status.equals("-Select-") )   {
								
								
								
								
								
								JOptionPane.showMessageDialog(null,"edit failed");
							
								
								
							
							}else {
								int confirm=JOptionPane.showConfirmDialog(null, "Are u sure?","Warning",JOptionPane.YES_OPTION);
								if (confirm==JOptionPane.YES_OPTION) {
								ps.executeUpdate();
								JOptionPane.showMessageDialog(null," successfully updated");
								textField.setText("");
								textField_1.setText("");
								comboBox.setSelectedIndex(0);
								comboBox_1.setSelectedIndex(0);
								dispose();
								AdminUI v=new AdminUI();
								v.setVisible(true);
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
		btnUpdate.setBounds(72, 286, 89, 23);
		contentPane_1.add(btnUpdate);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminUI v=new AdminUI();
				v.setVisible(true);
			}
		});
		btnCancel.setBounds(171, 286, 89, 23);
		contentPane_1.add(btnCancel);
		
		 labelcode = new JLabel("New label");
		labelcode.setBounds(118, 97, 46, 14);
		contentPane_1.add(labelcode);
		
		JLabel lblMenuCode = new JLabel("Menu code:");
		lblMenuCode.setFont(new Font("Rockwell", Font.BOLD, 13));
		lblMenuCode.setBounds(19, 92, 89, 23);
		contentPane_1.add(lblMenuCode);
	}
}
