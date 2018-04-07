package magpie;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

@SuppressWarnings("serial")
public class MagPieWithGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JTextPane textPane;
	JButton button;
	Magpie5 pie = new Magpie5();
	private JScrollPane scrollPane;
	Document document;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MagPieWithGUI frame = new MagPieWithGUI();
					frame.setTitle("magpie chatting robot");
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
	public MagPieWithGUI() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 494);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Consolas", Font.PLAIN, 12));
		textField.setBounds(10, 426, 353, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		button = new JButton("\u53D1\u9001");
		button.setBounds(370, 425, 61, 23);
		contentPane.add(button);
		
		textPane = new JTextPane();
		textPane.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
		textPane.setBounds(10, 10, 421, 406);
		contentPane.add(textPane);
		textPane.setEditable(false);
		
		scrollPane = new JScrollPane(textPane);
		scrollPane.setBounds(10, 10, 421, 406);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane);
		
		document = textPane.getDocument();
		setDocs(pie.getGreeting(), Color.BLACK);
		
		button.addActionListener((e) -> {
			
			String text = textField.getText();
			setDocs("You: "+text, Color.red);
			
			String response = pie.getResponse(text);
			setDocs("Robot: "+response, Color.blue);
			textField.setText("");
		});
		
		textField.addKeyListener(new KeyAdapter() {
	 
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String text = textField.getText();
					setDocs("You: "+text, Color.red);
					
					String response = pie.getResponse(text);
					setDocs("Robot: "+response, Color.blue);
					textField.setText("");
				}
			}
		
		});
	}
	
	public void setDocs(String msg, Color color) {
		SimpleAttributeSet attrset = new SimpleAttributeSet();
		StyleConstants.setForeground(attrset, color);
		insert(msg, attrset);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
	
	public void insert(String msg, SimpleAttributeSet attrset) {
		
		msg = msg+"\n";
		try {
			document.insertString(document.getLength(), msg, attrset);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
}
