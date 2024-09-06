import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;

public class test extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblPosition;
	private JLabel lblTime;
	private JLabel lblDate;
	private JButton btnMenu;
	private JButton btnSales;
	private JButton btnNewButton_4;
	public static JLabel idtxt;
	private JLabel lblNewLabel_1;
	private JTabbedPane tabbedPane;
	private JPanel panel_2;
	private JScrollPane scrollPane;
	private JPanel panel_3;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JPanel panel_4;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			public void dispose() {
				
				test frame = new test();
				frame.setVisible(false);
				
			}
		
		});
	}
	

	/**
	 * Create the frame.
	 */
	public test() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 990, 716);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 974, 71);
		panel.setBackground(Color.RED);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("ID:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(798, 11, 46, 14);
		panel.add(lblNewLabel);
		
		lblPosition = new JLabel("Position");
		lblPosition.setForeground(Color.WHITE);
		lblPosition.setBounds(798, 46, 46, 14);
		panel.add(lblPosition);
		
		lblTime = new JLabel("Time");
		lblTime.setForeground(Color.WHITE);
		lblTime.setBounds(450, 32, 46, 14);
		panel.add(lblTime);
		
		lblDate = new JLabel("Date");
		lblDate.setForeground(Color.WHITE);
		lblDate.setBounds(267, 32, 46, 14);
		panel.add(lblDate);
		
		btnNewButton_4 = new JButton("Logout");
		btnNewButton_4.setBounds(10, 42, 65, 23);
		panel.add(btnNewButton_4);
		
		idtxt = new JLabel("ID:");
		idtxt.setForeground(Color.WHITE);
		idtxt.setBounds(838, 11, 46, 14);
		panel.add(idtxt);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(636, 32, 46, 14);
		panel.add(lblNewLabel_1);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginForm f = new LoginForm();
				f.setVisible(true);
				
				
				
				
				
				
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 75, 142, 612);
		panel_1.setBackground(Color.RED);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Accounts");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
				dispose();
				
				
				
				
			}
		});
		btnNewButton.setBounds(24, 57, 89, 23);
		panel_1.add(btnNewButton);
		
		btnMenu = new JButton("Menu");
		btnMenu.setEnabled(false);
		btnMenu.setBounds(24, 21, 89, 23);
		panel_1.add(btnMenu);
		
		btnSales = new JButton("Sales");
		btnSales.setBounds(24, 91, 89, 23);
		panel_1.add(btnSales);
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeinfo","root","");
								
			String sqql="SELECT * FROM `menu`"; 
			Statement stmt=conn.createStatement();
			ResultSet rs= stmt.executeQuery(sqql);
			
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(146, 75, 828, 526);
			contentPane.add(tabbedPane);
			
			panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
			tabbedPane.addTab("New tab", null, panel_2, null);
			
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 50, 441, 362);
			panel_2.add(scrollPane);
			
			panel_3 = new JPanel();
			panel_3.setLayout(null);
			panel_3.setBounds(461, 56, 341, 356);
			panel_2.add(panel_3);
			
			textField = new JTextField();
			textField.setEditable(false);
			textField.setColumns(10);
			textField.setBounds(50, 55, 141, 20);
			panel_3.add(textField);
			
			textField_1 = new JTextField();
			textField_1.setEditable(false);
			textField_1.setColumns(10);
			textField_1.setBounds(50, 99, 141, 20);
			panel_3.add(textField_1);
			
			textField_2 = new JTextField();
			textField_2.setEditable(false);
			textField_2.setColumns(10);
			textField_2.setBounds(50, 149, 141, 20);
			panel_3.add(textField_2);
			
			textField_3 = new JTextField();
			textField_3.setEditable(false);
			textField_3.setColumns(10);
			textField_3.setBounds(50, 204, 141, 20);
			panel_3.add(textField_3);
			
			textField_4 = new JTextField();
			textField_4.setEditable(false);
			textField_4.setColumns(10);
			textField_4.setBounds(50, 245, 141, 20);
			panel_3.add(textField_4);
			
			btnNewButton_1 = new JButton("New");
			btnNewButton_1.setBounds(10, 322, 89, 23);
			panel_3.add(btnNewButton_1);
			
			btnNewButton_2 = new JButton("Remove");
			btnNewButton_2.setBounds(109, 322, 89, 23);
			panel_3.add(btnNewButton_2);
			
			btnNewButton_3 = new JButton("Update");
			btnNewButton_3.setBounds(208, 322, 89, 23);
			panel_3.add(btnNewButton_3);
			
			panel_4 = new JPanel();
			tabbedPane.addTab("New tab", null, panel_4, null);
			panel_4.setLayout(null);
			
			lblNewLabel_2 = new JLabel("New label");
			lblNewLabel_2.setBounds(388, 5, 46, 14);
			panel_4.add(lblNewLabel_2);
			
			lblNewLabel_3 = new JLabel("New label");
			lblNewLabel_3.setBounds(203, 56, 46, 14);
			panel_4.add(lblNewLabel_3);
			
			lblNewLabel_4 = new JLabel("New label");
			lblNewLabel_4.setBounds(287, 67, 46, 14);
			panel_4.add(lblNewLabel_4);
			}catch (Exception e){
			JOptionPane.showMessageDialog(null,e);
			}
	
	}
}
