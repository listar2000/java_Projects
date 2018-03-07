import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class SendFileFrame extends JFrame {

	private JPanel contentPane;
	private int value = 0;
	private AddBookFrame addBookFrame;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		SendFileFrame frame = new SendFileFrame();
		frame.setVisible(true);
			
	}

	/**
	 * Create the frame.
	 */
	public SendFileFrame() {
		
		addBookFrame = new AddBookFrame(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 485, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		label = new JLabel(""+value);
		contentPane.add(label, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("New button");
		contentPane.add(btnNewButton, BorderLayout.SOUTH);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addBookFrame.exhibit();
			}
		});
	}
	
	public void addNum() {
		value ++;
		label.setText(value+"");
	}

}
