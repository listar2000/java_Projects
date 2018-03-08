import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class SendFileFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JList <String> jlist;
	private JButton submit_Button;
	private JButton add_Button;
	
	private AddBookFrame addBookFrame;
	private ArrayList <Book> bookList;
	private DefaultListModel <String> listModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		new SendFileFrame().setVisible(true);

	}

	/**
	 * Create the frame.
	 */
	public SendFileFrame() {
		
		addBookFrame = new AddBookFrame(this);
		bookList = new ArrayList<>();
		
		setTitle("选择书籍");
		setSize(400, 600);
		
		JPanel frame2 = new JPanel();
		frame2.setLayout(null);
		frame2.setBounds(0,0,400,600);
		
		
		JTextField tf1 = new JTextField("Possible Books");
		tf1.setBounds(0, 0, 400, 20);
		tf1.setEditable(false);
		tf1.setFont(new Font("Arial",Font.BOLD,12));
		tf1.setForeground(Color.red);
		frame2.add(tf1);
		
		listModel = new DefaultListModel<>();
		updateModel();
		
		jlist = new JList<>(listModel);
		jlist.setBounds(0,20,400,400);
		frame2.add(jlist);
		
		
		submit_Button = new JButton("提交订单");
		submit_Button.addActionListener(this);
		submit_Button.setBounds(60, 485, 100, 50);
		frame2.add(submit_Button);
		
		add_Button = new JButton("添加书籍");
		add_Button.addActionListener(this);
		add_Button.setBounds(240,485,100,50);
		frame2.add(add_Button);
		
		this.setContentPane(frame2);
	}
	
	public void updateModel() 
	{
		for (int i=0; i<bookList.size(); i++) {
			
			listModel.addElement(bookList.get(i).getName());
			
		}
	}
	
	public boolean isBookExisted(Book book) 
	{
		for (Book b: bookList) {
			if (b.getFile().equals(book.getFile())) return true;
		}
		return false;
	}
	
	public void addBook(Book book) {
		//在List中添加书籍，同时更新Jist
		if (isBookExisted(book)) {
			JOptionPane.showMessageDialog(null, "这本书已经存在了");
			return;
		}
		JOptionPane.showMessageDialog(null, "成功选择： "+book.getName());
		bookList.add(book);
		updateModel();
		jlist.setModel(listModel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add_Button) {
			addBookFrame.exhibit();
		}
	}

}
