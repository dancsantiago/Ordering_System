import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class receipt extends JFrame {

	private JPanel contentPane;
	public static JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					receipt frame = new receipt();
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
	public receipt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 653);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 592);
		contentPane.add(scrollPane);
		
		 textArea = new JTextArea();
		 textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		bill();
	}
	
	
	public void bill() {
		
		
		
	}
}
