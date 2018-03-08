import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class AddBookFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private SendFileFrame sendFileFrame;
	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField urlTextField;
	
	private JButton reset_Button;
	private JButton select_Button;
	private JButton submit_Button;

	private JFileChooser fileChooser;
	private File approvedFile;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddBookFrame frame = new AddBookFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public AddBookFrame(SendFileFrame sendFileFrame) {
		this.sendFileFrame = sendFileFrame;
	}
	
	public void exhibit() 
	{
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("\u6DFB\u52A0\u4E66\u7C4D");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 261);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		select_Button = new JButton("\u83B7\u53D6\u4E66\u7C4D");
		select_Button.setToolTipText("\u6253\u5F00\u6587\u4EF6\u9009\u62E9\u5668\u9009\u62E9\u6587\u4EF6");
		select_Button.setForeground(Color.BLACK);
		select_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		select_Button.setBackground(Color.WHITE);
		select_Button.setBounds(91, 10, 103, 36);
		select_Button.addActionListener(this);
		contentPane.add(select_Button);
		
		JLabel label = new JLabel("\u4E66\u540D\uFF1A");
		label.setBackground(Color.WHITE);
		label.setForeground(Color.DARK_GRAY);
		label.setFont(new Font("ËÎÌå", Font.PLAIN, 14));
		label.setBounds(36, 67, 42, 15);
		contentPane.add(label);
		
		nameTextField = new JTextField();
		nameTextField.setEditable(false);
		nameTextField.setBounds(91, 64, 302, 21);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u8DEF\u5F84\uFF1A");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("ËÎÌå", Font.PLAIN, 14));
		label_1.setBounds(36, 116, 42, 15);
		contentPane.add(label_1);
		
		urlTextField = new JTextField();
		urlTextField.setEditable(false);
		urlTextField.setColumns(10);
		urlTextField.setBounds(91, 113, 302, 21);
		contentPane.add(urlTextField);
		
		reset_Button = new JButton("\u91CD\u7F6E");
		reset_Button.addActionListener(this);
		reset_Button.setToolTipText("\u6253\u5F00\u6587\u4EF6\u9009\u62E9\u5668\u9009\u62E9\u6587\u4EF6");
		reset_Button.setForeground(Color.BLACK);
		reset_Button.setBackground(Color.WHITE);
		reset_Button.setBounds(244, 10, 103, 36);
		reset_Button.addActionListener(this);
		contentPane.add(reset_Button);
		
		submit_Button = new JButton("SUBMIT");
		submit_Button.setBackground(Color.PINK);
		submit_Button.setBounds(168, 155, 93, 46);
		submit_Button.addActionListener(this);
		contentPane.add(submit_Button);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == reset_Button) {
			nameTextField.setText("");
			urlTextField.setText("");
		}
		
		if (e.getSource() == select_Button) 
		{
			fileChooser = new JFileChooser("选择文件");
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			
			int i = fileChooser.showOpenDialog(null);
			
			if (i == JFileChooser.APPROVE_OPTION) {
				
				File file = fileChooser.getSelectedFile();
				String path = file.getPath();
				
				if (!(path.endsWith(".pdf") || path.endsWith(".epub"))) {
					JOptionPane.showMessageDialog(null, "选择的文件必须是epub或者pdf格式");
					return;
				}
				
				approvedFile = file;
				nameTextField.setText(file.getName());
				urlTextField.setText(path);
			}
		}
		
		if (e.getSource() == submit_Button) {
			if (nameTextField.getText().equals("") || nameTextField.getText() == null) 
				JOptionPane.showMessageDialog(null, "选择文件不能为空");
			sendFileFrame.addBook(new Book(approvedFile));
		}
	}

}
