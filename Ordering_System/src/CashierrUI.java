import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CashierrUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField mcodetxt;
	private JTextField nametxt;
	public JTextField qtytxt;
	private JTextField pricetxt;
	private JTextField statustxt;
	public static JTextField textField_5;
	public static JLabel datetxt;
	public static JLabel timetxt;
	public static JLabel lblTotal_1_1;
	public static JLabel lblTotal_1_4;
	public static JLabel idtxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CashierrUI frame = new CashierrUI();
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
	public CashierrUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1212, 729);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(0, -11, 1196, 701);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(10, 48, 1176, 39);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Cashier ID:");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblNewLabel_1.setBounds(996, 14, 77, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Date:");
		lblNewLabel_1_1.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(273, 14, 42, 14);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Time:");
		lblNewLabel_1_2.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblNewLabel_1_2.setBounds(508, 14, 42, 14);
		panel_1.add(lblNewLabel_1_2);
		
		 idtxt = new JLabel("1");
		idtxt.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		idtxt.setBounds(1074, 14, 77, 14);
		panel_1.add(idtxt);
		
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginForm a =new LoginForm();
				a.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(10, 11, 89, 23);
		panel_1.add(btnNewButton_2);
		
		 datetxt = new JLabel("Date:");
		datetxt.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		datetxt.setBounds(312, 15, 89, 14);
		panel_1.add(datetxt);
		
		 timetxt = new JLabel("Date:");
		timetxt.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		timetxt.setBounds(549, 15, 107, 14);
		panel_1.add(timetxt);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 141, 671, 331);
		panel.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int i=table.getSelectedRow();
				TableModel model = table.getModel();
				//codetxt.setText(model.getValueAt(i,1).toString());
				nametxt.setText(model.getValueAt(i,2).toString());
				pricetxt.setText(model.getValueAt(i,3).toString());
				statustxt.setText(model.getValueAt(i,4).toString());
				mcodetxt.setText(model.getValueAt(i,1).toString());
				
				
				 
				
				qtytxt.setText("");
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(768, 141, 359, 331);
		panel.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Menu code", "Menu name", "quantity", "price", "sub-total"
			}
		));
		table_1.setDefaultEditor(Object.class, null);
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel = new JLabel("Menu code:");
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 17));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(32, 505, 142, 27);
		panel.add(lblNewLabel);
		
		JLabel lblMenuName = new JLabel("Menu name:");
		lblMenuName.setForeground(Color.WHITE);
		lblMenuName.setFont(new Font("Rockwell", Font.BOLD, 17));
		lblMenuName.setBounds(27, 543, 142, 27);
		panel.add(lblMenuName);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setForeground(Color.WHITE);
		lblQuantity.setFont(new Font("Rockwell", Font.BOLD, 17));
		lblQuantity.setBounds(27, 577, 107, 27);
		panel.add(lblQuantity);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("Rockwell", Font.BOLD, 17));
		lblPrice.setBounds(316, 505, 95, 27);
		panel.add(lblPrice);
		
		JLabel lblTotal = new JLabel("Status:");
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setFont(new Font("Rockwell", Font.BOLD, 17));
		lblTotal.setBounds(316, 543, 95, 27);
		panel.add(lblTotal);
		
		mcodetxt = new JTextField();
		mcodetxt.setEditable(false);
		mcodetxt.setBounds(153, 511, 124, 20);
		panel.add(mcodetxt);
		mcodetxt.setColumns(10);
		
		nametxt = new JTextField();
		nametxt.setEditable(false);
		nametxt.setColumns(10);
		nametxt.setBounds(153, 549, 124, 20);
		panel.add(nametxt);
		
		qtytxt = new JTextField();
		qtytxt.setColumns(10);
		qtytxt.setBounds(153, 583, 124, 20);
		panel.add(qtytxt);
		
		pricetxt = new JTextField();
		pricetxt.setEditable(false);
		pricetxt.setColumns(10);
		pricetxt.setBounds(380, 511, 124, 20);
		panel.add(pricetxt);
		
		statustxt = new JTextField();
		statustxt.setEditable(false);
		statustxt.setColumns(10);
		statustxt.setBounds(380, 549, 124, 20);
		panel.add(statustxt);
		
		JLabel lblTotal_1 = new JLabel("Total:");
		lblTotal_1.setForeground(Color.WHITE);
		lblTotal_1.setFont(new Font("Rockwell", Font.BOLD, 17));
		lblTotal_1.setBounds(989, 483, 64, 27);
		panel.add(lblTotal_1);
		
		 lblTotal_1_1 = new JLabel("0");
		lblTotal_1_1.setForeground(Color.WHITE);
		lblTotal_1_1.setFont(new Font("Rockwell", Font.BOLD, 17));
		lblTotal_1_1.setBounds(1063, 483, 64, 27);
		panel.add(lblTotal_1_1);
		
		JButton btnNewButton = new JButton("Add to cart");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(table.getSelectionModel().isSelectionEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please select a row");
					
				}else if (qtytxt.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Enter quantity");
				}else {
				totals();
				}
			}
		});
		btnNewButton.setBounds(547, 510, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int rowss=table_1.getRowCount();
				 String norows = Integer.toString(rowss);
				
				if(table_1.getSelectionModel().isSelectionEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please select a row");
					
		
					
				}else if (norows.equals("1")) {
					
						
						DefaultTableModel modell=(DefaultTableModel)table_1.getModel();
						int SelectedRowIndex = table_1.getSelectedRow();
						modell.removeRow(SelectedRowIndex);
						lblTotal_1_4.setText("0");
						lblTotal_1_1.setText("0");
					
					
					
				}
				
				
				
				
				else {
					
					
					
					
					
				DefaultTableModel modell=(DefaultTableModel)table_1.getModel();
				int SelectedRowIndex = table_1.getSelectedRow();
				modell.removeRow(SelectedRowIndex);
				getSum();
				}
				
				
				
				
			}
		});
		btnRemove.setBounds(865, 488, 89, 23);
		panel.add(btnRemove);
		
		JLabel lblTotal_1_2 = new JLabel("Total:");
		lblTotal_1_2.setForeground(Color.WHITE);
		lblTotal_1_2.setFont(new Font("Rockwell", Font.BOLD, 17));
		lblTotal_1_2.setBounds(790, 543, 64, 27);
		panel.add(lblTotal_1_2);
		
		JLabel lblTotal_1_3 = new JLabel("Payment:");
		lblTotal_1_3.setForeground(Color.WHITE);
		lblTotal_1_3.setFont(new Font("Rockwell", Font.BOLD, 17));
		lblTotal_1_3.setBounds(759, 577, 95, 27);
		panel.add(lblTotal_1_3);
		
		 lblTotal_1_4 = new JLabel("0");
		lblTotal_1_4.setForeground(Color.WHITE);
		lblTotal_1_4.setFont(new Font("Rockwell", Font.BOLD, 17));
		lblTotal_1_4.setBounds(864, 543, 64, 27);
		panel.add(lblTotal_1_4);
		
		textField_5 = new JTextField();
		textField_5.setBounds(865, 584, 116, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		
		
		
		JButton btnNewButton_1 = new JButton("PROCESS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
		
				
				int rowss=table_1.getRowCount();
				 String norows = Integer.toString(rowss);
				
				if (norows.equals("0")) {
					JOptionPane.showMessageDialog(null,"no items in cart");
					
					}else {
				
				double total=Double.parseDouble(lblTotal_1_4.getText());
				double payment=Double.parseDouble(textField_5.getText());
				double change=payment-total;
				int lastinsertid=0;
					
	try {
						
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeinfo","root","");
						PreparedStatement ps= conn.prepareStatement("insert into sales (Cashier_id,date,time,subtotal,payment,changee) values (?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
						
			
						
						if (payment < total || payment <= 0 || textField_5.getText().isEmpty()  ) {
							JOptionPane.showMessageDialog(null, "Error");
						}else {
							JOptionPane.showMessageDialog(null, "Change: "+change);
							
							
							ps.setString(1,idtxt.getText() );
							ps.setString(2,datetxt.getText() );
							ps.setString(3,timetxt.getText() );
							ps.setDouble(4,total);
							ps.setDouble(5,payment);
							ps.setDouble(6,change);
							ps.executeUpdate();
							 ResultSet generatekey = ps.getGeneratedKeys();
							if (generatekey.next()) {
								lastinsertid=generatekey.getInt(1);
								
								
								
								int rows=table_1.getRowCount();
								
								PreparedStatement ps1= conn.prepareStatement("insert into sales_product (sales_id,menu_code,price,qty,total) values (?,?,?,?,?)");
								
							String price="";
							String qty="";
							double totals=0;
							String menucode="";
								
								
										for (int i=0; i<table_1.getRowCount();i++)
										{
										menucode=(String)table_1.getValueAt(i,0);
										qty=(String)table_1.getValueAt(i,2);
										price=(String)table_1.getValueAt(i,3);
										totals=(double)table_1.getValueAt(i,4);
										
										double mcode=Double.parseDouble(menucode);
										double Price=Double.parseDouble(price);
										double Qty=Double.parseDouble(qty);
										
										
									
								ps1.setInt(1,lastinsertid);
								ps1.setDouble(2,mcode);
								ps1.setDouble(3,Price);
								ps1.setDouble(4,Qty);
								ps1.setDouble(5,totals);
								ps1.executeUpdate();
										
										}
										ps1.addBatch();
										JOptionPane.showMessageDialog(null, "added");
										receipt r=new receipt();
										r.setVisible(true);
										;
										r.textArea.setText(r.textArea.getText()+"================================================================");
										r.textArea.setText(r.textArea.getText()+"\n \t \t JDD Foodtrips \n");
										r.textArea.setText(r.textArea.getText()+"================================================================");
										r.textArea.setText(r.textArea.getText()+"\n Sales No:"+lastinsertid);
										r.textArea.setText(r.textArea.getText()+"\n Cashier ID:"+idtxt.getText());
										r.textArea.setText(r.textArea.getText()+"\n Date: "+datetxt.getText());
										r.textArea.setText(r.textArea.getText()+"\n Time: "+timetxt.getText());
										r.textArea.setText(r.textArea.getText()+"\n \n  Name: \t Price: \t Quantity: \t Subtotal: ");
										for (int a =0; a <table_1.getRowCount();a++){
											String names=table_1.getValueAt(a,1).toString();
											String quantity=table_1.getValueAt(a,2).toString();
											String prays=table_1.getValueAt(a,3).toString();
											String subTotal=table_1.getValueAt(a,4).toString();
											
											r.textArea.setText(r.textArea.getText()+"\n"+names+"\t"+quantity+"\t"+prays+"\t"+subTotal+"\n"+"\n \n Total Amount:"+lblTotal_1_1.getText()+
													"\n Cash Tendered:"+textField_5.getText()+"\nChange:"+change);
								

											}

											
							
								
								
							}
							
							
						
							
							
						}
						
						
					
						
					} catch(Exception e1){
						System.out.println(e1);
						
					}
				
				
				
				
			}
			}
			
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(835, 636, 237, 43);
		panel.add(btnNewButton_1);
		
		
		showTimer();
		showDate();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeinfo","root","");
								
			String sqql="SELECT * FROM `menu`";
			
			Statement stmt=conn.createStatement();
			ResultSet rs= stmt.executeQuery(sqql);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e1){
			System.out.println(e1);
			
		}
		
	}
	
	
	public void totals() {
		double price= Double.parseDouble(pricetxt.getText());
		 double qty= Double.parseDouble(qtytxt.getText());
		if (qty >0 && statustxt.getText().equals("Available") ) {
	
		double total=price*qty;
		lblTotal_1_1.setText(""+total);
		DefaultTableModel modell=(DefaultTableModel)table_1.getModel();
		modell.addRow(new Object[] {mcodetxt.getText(),nametxt.getText(),qtytxt.getText(),pricetxt.getText(),total});
		qtytxt.setText("");
		
		getSum();
		
	
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "Error");
		}
		
		
		
		
	}
public void getSum() {
		
		double sum=0;
		for(int s =0; s< table_1.getRowCount();s++)
		{
			
			
			sum=sum+Double.parseDouble(table_1.getValueAt(s, 4).toString());
			
			int count= table_1.getModel().getRowCount();
			
		
			lblTotal_1_1.setText(Double.toString(sum));
			lblTotal_1_4.setText(Double.toString(sum));
			
		}
		
		
		
		
	
		
		
	
	}

	
	

	
	
	void showDate() {
		Date d =new Date();
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
		datetxt.setText(s.format(d));
		
	}
	
	void showTimer() {
		new Timer (0,new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Date d =new Date();
				SimpleDateFormat s=new SimpleDateFormat("hh:mm:ss a");
				timetxt.setText(s.format(d));
			}
			
			
		}).start();
		
	}
}
