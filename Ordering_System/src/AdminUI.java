import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class AdminUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTable table_1;
	public static JLabel idtxt;
	public static JLabel positiontxt;
	public static JLabel lblDate;
	public static JLabel lblTime;
	private JTextField textField_11;
	private JTable table_2;
	private JTable table_3;
	private JTextField textField_10;
	public static JLabel lblNewLabel_6;
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUI frame = new AdminUI();
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
	public AdminUI() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 980, 691);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.RED);
		panel.setBounds(0, 0, 974, 71);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(798, 11, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setForeground(Color.WHITE);
		lblPosition.setBounds(798, 46, 46, 14);
		panel.add(lblPosition);
		
		 lblTime = new JLabel("Time");
		lblTime.setForeground(Color.WHITE);
		lblTime.setBounds(450, 32, 73, 14);
		panel.add(lblTime);
		
		 lblDate = new JLabel("Date");
		lblDate.setForeground(Color.WHITE);
		lblDate.setBounds(267, 32, 82, 14);
		panel.add(lblDate);
		
		
		
		JButton btnNewButton_4 = new JButton("Logout");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				LoginForm s=new LoginForm();
				s.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(10, 42, 73, 23);
		panel.add(btnNewButton_4);
		
		
		
		 positiontxt = new JLabel("Position");
		positiontxt.setForeground(Color.WHITE);
		positiontxt.setBounds(849, 46, 46, 14);
		panel.add(positiontxt);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.RED);
		panel_1.setBounds(0, 72, 142, 612);
		contentPane.add(panel_1);
		
		JButton btnAccounts = new JButton("Accounts");
		btnAccounts.setBounds(24, 57, 89, 23);
		panel_1.add(btnAccounts);
		
		JButton btnMenu = new JButton("Menu");
	
		btnMenu.setEnabled(false);
		btnMenu.setBounds(24, 21, 89, 23);
		panel_1.add(btnMenu);
		
		JButton btnSales = new JButton("Sales");
		
		
		
		
		btnSales.setBounds(24, 91, 89, 23);
		panel_1.add(btnSales);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(152, 45, 812, 596);
		contentPane.add(tabbedPane);
		
		JPanel menupanel = new JPanel();
		tabbedPane.addTab("New tab", null, menupanel, null);
		menupanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 72, 441, 362);
		menupanel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table.getSelectedRow();
				TableModel model = table.getModel();
				textField.setText(model.getValueAt(i,0).toString());
				textField_1.setText(model.getValueAt(i,1).toString());
				textField_2.setText(model.getValueAt(i,2).toString());
				textField_3.setText(model.getValueAt(i,3).toString());
				textField_4.setText(model.getValueAt(i,4).toString());
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(table);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(464, 72, 312, 356);
		menupanel.add(panel_3);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(89, 55, 141, 20);
		panel_3.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(89, 96, 141, 20);
		panel_3.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(89, 137, 141, 20);
		panel_3.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(89, 180, 141, 20);
		panel_3.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(89, 218, 141, 20);
		panel_3.add(textField_4);
		
		JButton btnNewButton_1 = new JButton("New");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AddMenu c=new AddMenu();
				c.setVisible(true);

			
			}
			
		});
		
		btnNewButton_1.setBounds(10, 322, 89, 23);
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Remove");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table.getSelectionModel().isSelectionEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please select a row");
					
				}else {
				
				
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeinfo","root","");
					//String sql="SELECT * FROM `accounts` WHERE Idnumber='"+textField.getText()+"' and Password='"+passwordField.getText()+"'";
					String sqql="DELETE FROM `menu` WHERE Menu_code='"+textField_1.getText()+"'";
					Statement stmt=conn.createStatement();
					stmt.executeUpdate(sqql);
					
						
						JOptionPane.showMessageDialog(null, "deleted");
						refreshmenudata();
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						textField_4.setText("");
				
				
					
					
					
				} catch(Exception e1){
					System.out.println(e1);
					
				}
				}
			}
		});
		btnNewButton_2.setBounds(109, 322, 89, 23);
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectionModel().isSelectionEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please select a row");
					
				}else {
				
				dispose();
				EditMenu x=new EditMenu();
				x.setVisible(true);
				x.comboBox.setSelectedItem(textField.getText());
				x.comboBox_1.setSelectedItem(textField_4.getText());
				x.textField.setText(textField_2.getText());
				x.textField_1.setText(textField_3.getText());
				x.labelcode.setText(textField_1.getText());
				
				}
			}
		});
		btnNewButton_3.setBounds(208, 322, 89, 23);
		panel_3.add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("Category:");
		lblNewLabel_1.setBounds(10, 58, 69, 14);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Menu code:");
		lblNewLabel_1_1.setBounds(10, 99, 69, 14);
		panel_3.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Menu name:");
		lblNewLabel_1_2.setBounds(10, 140, 69, 14);
		panel_3.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Price:");
		lblNewLabel_1_1_1.setBounds(33, 183, 46, 14);
		panel_3.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Status:");
		lblNewLabel_1_1_1_1.setBounds(22, 221, 46, 14);
		panel_3.add(lblNewLabel_1_1_1_1);
		
		JPanel accountspanel = new JPanel();
		tabbedPane.addTab("New tab", null, accountspanel, null);
		accountspanel.setLayout(null);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_1.setBounds(0, 0, 812, 584);
		accountspanel.add(panel_2_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 50, 441, 362);
		panel_2_1.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i=table_1.getSelectedRow();
				TableModel model = table_1.getModel();
				textField_5.setText(model.getValueAt(i,0).toString());
				textField_6.setText(model.getValueAt(i,1).toString());
				textField_7.setText(model.getValueAt(i,2).toString());
				textField_8.setText(model.getValueAt(i,3).toString());
				textField_9.setText(model.getValueAt(i,4).toString());
			}
		});
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		table_1.setDefaultEditor(Object.class, null);
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBounds(461, 56, 341, 356);
		panel_2_1.add(panel_3_1);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(95, 53, 141, 20);
		panel_3_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(95, 97, 141, 20);
		panel_3_1.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(95, 149, 141, 20);
		panel_3_1.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(95, 202, 141, 20);
		panel_3_1.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(95, 244, 141, 20);
		panel_3_1.add(textField_9);
		
		JButton btnNewButton_1_1 = new JButton("New");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AddAccount v=new AddAccount();
				v.setVisible(true);
			}
		});
		btnNewButton_1_1.setBounds(10, 322, 89, 23);
		panel_3_1.add(btnNewButton_1_1);
		
		JButton btnNewButton_2_1 = new JButton("Remove");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(table_1.getSelectionModel().isSelectionEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please select a row");
					
				}else {
				try {
					
					int confirm=JOptionPane.showConfirmDialog(null, "Are u sure?","Warning",JOptionPane.YES_OPTION);
					if (confirm==JOptionPane.YES_OPTION) {
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeinfo","root","");
					//String sql="SELECT * FROM `accounts` WHERE Idnumber='"+textField.getText()+"' and Password='"+passwordField.getText()+"'";
					String sqql="DELETE FROM `accounts` WHERE Idnumber='"+textField_5.getText()+"'";
					Statement stmt=conn.createStatement();
					stmt.executeUpdate(sqql);
					
						
						JOptionPane.showMessageDialog(null, "deleted");
						refreshdata();
						textField_5.setText("");
						textField_6.setText("");
						textField_7.setText("");
						textField_8.setText("");
						textField_9.setText("");
					}
				
				
					
					
					
				} catch(Exception e1){
					System.out.println(e1);
					
				}
				}
			}
		});
		btnNewButton_2_1.setBounds(109, 322, 89, 23);
		panel_3_1.add(btnNewButton_2_1);
		
		JButton btnNewButton_3_1 = new JButton("Update");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table_1.getSelectionModel().isSelectionEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please select a row");
					
				}else {
				
				dispose();
				EditAccount s=new EditAccount();
				s.setVisible(true);
				s.textField.setText(textField_5.getText());
				s.textField_1.setText(textField_6.getText());
				s.textField_2.setText(textField_7.getText());
				s.passwordField.setText(textField_8.getText());
				s.passwordField_1.setText(textField_8.getText());
				s.comboBox.setSelectedItem(textField_9.getText());
				
			}
			}
		});
		btnNewButton_3_1.setBounds(208, 322, 89, 23);
		panel_3_1.add(btnNewButton_3_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID number:");
		lblNewLabel_2.setBounds(10, 56, 75, 14);
		panel_3_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("First Name:");
		lblNewLabel_2_1.setBounds(10, 100, 75, 14);
		panel_3_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Last Name:");
		lblNewLabel_2_2.setBounds(10, 152, 75, 14);
		panel_3_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Password:");
		lblNewLabel_2_3.setBounds(10, 205, 75, 14);
		panel_3_1.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Account_type:");
		lblNewLabel_2_4.setBounds(10, 247, 71, 14);
		panel_3_1.add(lblNewLabel_2_4);
		
		JPanel salespanel = new JPanel();
		tabbedPane.addTab("New tab", null, salespanel, null);
		salespanel.setLayout(null);
		
		
		btnAccounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMenu.setEnabled(true);
				btnSales.setEnabled(true);
				btnAccounts.setEnabled(false);
				tabbedPane.setSelectedIndex(1);
				
			}
		});
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAccounts.setEnabled(true);
				btnSales.setEnabled(true);
				btnMenu.setEnabled(false);
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnSales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMenu.setEnabled(true);
				btnAccounts.setEnabled(true);
				btnSales.setEnabled(false);
				tabbedPane.setSelectedIndex(2);
				
				
				
				double sum=0;
				for(int s =0; s< table_2.getRowCount();s++)
				{
					
					
					sum=sum+Double.parseDouble(table_2.getValueAt(s, 4).toString());
					
					
					lblNewLabel_6.setText(""+sum);
					
				
				
					
				}
			}
			
			
		
		});
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeinfo","root","");
								
			String sqql="SELECT * FROM `sales`";
			
			Statement stmt=conn.createStatement();
			ResultSet rs= stmt.executeQuery(sqql);
			
			JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane_1.setBounds(10, 11, 787, 546);
			salespanel.add(tabbedPane_1);
			
			JPanel panel_2 = new JPanel();
			tabbedPane_1.addTab("Sales", null, panel_2, null);
			panel_2.setLayout(null);
			
			JScrollPane scrollPane_2 = new JScrollPane();
			scrollPane_2.setBounds(10, 59, 762, 360);
			panel_2.add(scrollPane_2);
			
			table_2 = new JTable();
			table_2.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"New column", "New column", "New column", "New column", "New column"
				}
			));
			table_2.setDefaultEditor(Object.class, null);
			scrollPane_2.setViewportView(table_2);
			
			textField_11 = new JTextField();
			textField_11.setBounds(68, 23, 132, 20);
			panel_2.add(textField_11);
			textField_11.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					
				}
				
			
				@Override
				public void keyTyped(KeyEvent e) {
					
					
					DefaultTableModel model=(DefaultTableModel) table_2.getModel();
					TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model);
					table_2.setRowSorter(tr);
					tr.setRowFilter(RowFilter.regexFilter(textField_11.getText().trim()));
				}
			});
			textField_11.setColumns(10);
			
			JLabel lblNewLabel_3 = new JLabel("Search:");
			lblNewLabel_3.setBounds(10, 26, 46, 14);
			panel_2.add(lblNewLabel_3);
			
			JLabel lblNewLabel_5 = new JLabel("Total Sales:");
			lblNewLabel_5.setBounds(10, 430, 77, 14);
			panel_2.add(lblNewLabel_5);
			
			 lblNewLabel_6 = new JLabel("New label");
			lblNewLabel_6.setBounds(80, 430, 46, 14);
			panel_2.add(lblNewLabel_6);
			
			JPanel panel_4 = new JPanel();
			tabbedPane_1.addTab("Sales per product", null, panel_4, null);
			panel_4.setLayout(null);
			
			JScrollPane scrollPane_2_1 = new JScrollPane();
			scrollPane_2_1.setBounds(10, 58, 762, 360);
			panel_4.add(scrollPane_2_1);
			
			table_3 = new JTable();
			table_3.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"New column", "New column", "New column", "New column", "New column"
				}
			));
			table_3.setDefaultEditor(Object.class, null);
			scrollPane_2_1.setViewportView(table_3);
			
			JLabel lblNewLabel_4 = new JLabel("Search:");
			lblNewLabel_4.setBounds(10, 21, 46, 14);
			panel_4.add(lblNewLabel_4);
			
			textField_10 = new JTextField();
			textField_10.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					
					DefaultTableModel model=(DefaultTableModel) table_3.getModel();
					TableRowSorter<DefaultTableModel> tr=new TableRowSorter<DefaultTableModel>(model);
					table_3.setRowSorter(tr);
					tr.setRowFilter(RowFilter.regexFilter(textField_10.getText().trim()));
				}
				
				
			});
			textField_10.setBounds(66, 18, 98, 20);
			panel_4.add(textField_10);
			textField_10.setColumns(10);
			}catch (Exception e){
			JOptionPane.showMessageDialog(null,e);
			}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeinfo","root","");
								
			String sqql="SELECT * FROM `menu`";
			
			Statement stmt=conn.createStatement();
			ResultSet rs= stmt.executeQuery(sqql);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			 idtxt = new JLabel("ID:");
			idtxt.setForeground(Color.WHITE);
			idtxt.setBounds(839, 6, 56, 24);
			
			panel.add(idtxt);
			
			JLabel lblNewLabel_2_5 = new JLabel("Date:");
			lblNewLabel_2_5.setForeground(Color.WHITE);
			lblNewLabel_2_5.setBounds(198, 32, 59, 14);
			panel.add(lblNewLabel_2_5);
			
			JLabel lblNewLabel_2_5_1 = new JLabel("Time:");
			lblNewLabel_2_5_1.setForeground(Color.WHITE);
			lblNewLabel_2_5_1.setBounds(381, 32, 59, 14);
			panel.add(lblNewLabel_2_5_1);
			
			
			}catch (Exception e){
			JOptionPane.showMessageDialog(null,e);
			}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeinfo","root","");
								
			String sqql="SELECT * FROM `accounts`";
			
			Statement stmt=conn.createStatement();
			ResultSet rs= stmt.executeQuery(sqql);
			table_1.setModel(DbUtils.resultSetToTableModel(rs));
			}catch (Exception e){
			JOptionPane.showMessageDialog(null,e);
			}
		
		showDate();
		showTimer();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeinfo","root","");
								
			String sqql="SELECT * FROM `sales`";
			
			Statement stmt=conn.createStatement();
			ResultSet rs= stmt.executeQuery(sqql);
			table_2.setModel(DbUtils.resultSetToTableModel(rs));
			}catch (Exception e){
			JOptionPane.showMessageDialog(null,e);
			}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeinfo","root","");
								
			String sqql="SELECT * FROM `sales_product`";
			
			Statement stmt=conn.createStatement();
			ResultSet rs= stmt.executeQuery(sqql);
			table_3.setModel(DbUtils.resultSetToTableModel(rs));
			}catch (Exception e){
			JOptionPane.showMessageDialog(null,e);
			}
	}
	
	
	
	
	

	
	
		
	 public void refreshdata() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeinfo","root","");
									
				String sqql="SELECT * FROM `accounts`"; 
				Statement stmt=conn.createStatement();
				ResultSet rs= stmt.executeQuery(sqql);
				table_1.setModel(DbUtils.resultSetToTableModel(rs));
				}catch (Exception e){
				JOptionPane.showMessageDialog(null,e);
				}
	 }
			public void refreshmenudata() {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeinfo","root","");
										
					String sqql="SELECT * FROM `menu`"; 
					Statement stmt=conn.createStatement();
					ResultSet rs= stmt.executeQuery(sqql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					}catch (Exception e){
					JOptionPane.showMessageDialog(null,e);
					}
				
				refreshdata();
				

	}
			
			
			void showDate() {
				Date d =new Date();
				SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
				lblDate.setText(s.format(d));
				
			}
			
			
			
			
			void showTimer() {
				new Timer (0,new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						Date d =new Date();
						SimpleDateFormat s=new SimpleDateFormat("hh:mm:ss a");
						lblTime.setText(s.format(d));
					}
					
					
				}).start();
			}
}
