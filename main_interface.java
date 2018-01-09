package library_project;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



class standardGUI extends JFrame{
	
	public standardGUI() {
		
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);
		this.setVisible(true);
	
	}
	
}

public class main_interface extends standardGUI implements ActionListener{
	
	private JButton b1;
	private JButton b2;
	private Library firstLibrary;
	private Library secondLibrary;
	
	public main_interface() {
		
		this.setTitle("Library System");
		this.setSize(400, 300);
		
		JPanel frame = new JPanel();
		frame.setBounds(0,0,400,300);
		frame.setLayout(null);
		
		JTextField text = new JTextField("which library do you want to enter?");
		
		text.setBounds(90,60,200,30);
		text.setEditable(false);
		
		b1 = new JButton("library 1");
		b1.addActionListener(this);
		
		b2 = new JButton("library 2");
		b2.addActionListener(this);
		
		b1.setBounds(50, 150, 100, 30);
		b2.setBounds(240,150,100,30);
		frame.add(b1);
		frame.add(b2);
		frame.add(text);
		this.setContentPane(frame);
		
	}
	
	public static void main(String[] args) {
		
		main_interface Main = new main_interface();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
		if (e.getSource()==b1) {
			firstLibrary = new Library("10 Main St.");
			firstLibrary.addBook(new Book("The Da Vinci Code"));
			firstLibrary.addBook(new Book("Le Petit Prince"));
			firstLibrary.addBook(new Book("A Tale of Two Cities"));
			firstLibrary.addBook(new Book("The Lord of the Rings"));
			
			libraryGUI GUI1 = new libraryGUI(firstLibrary);
		}
		if (e.getSource()==b2) {
			secondLibrary = new Library("228 Liberty St.");
			libraryGUI GUI2 = new libraryGUI(secondLibrary);
		}
	}
}










class libraryGUI extends standardGUI implements ActionListener{
	
	private JButton a1;
	private JButton a2;
	private JButton a3;
	private Library library;
	
	public libraryGUI(Library library) {
		
		this.library = library;
		this.setTitle("This library is located at " + library.getAddress());
		this.setSize(550,100);
		
		JPanel frame1 = new JPanel();
		
		frame1.setBounds(0,0,550,100);
		GridLayout gl = new GridLayout();
		gl.setHgap(3);
		frame1.setLayout(gl);
		
		a1 = new JButton("check information");
		a1.addActionListener(this);
		
		a3 = new JButton("donate(add)new books");
		a3.addActionListener(this);
		
		a2 = new JButton("borrow/return books");
		a2.addActionListener(this);
		
		frame1.add(a1);
		frame1.add(a2);
		frame1.add(a3);
		
		this.setContentPane(frame1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==a1) {
			JOptionPane.showMessageDialog(null, Library.printOpeningHours());
		}
		if (e.getSource()==a2) {
			borrowGUI borrow1 = new borrowGUI(library);
		}
		if (e.getSource()==a3) {
			String donated_book = JOptionPane.showInputDialog("what's the name of the new book?");
			if (donated_book != "") {
				library.booklist.add(new Book(donated_book));
				JOptionPane.showMessageDialog(null, "Process finished");
			}
		}
	}
	
	
}










class borrowGUI extends standardGUI implements ActionListener{
	
	private JList jlist;
	private JList jlist2;
	private JTextField info;
	private JButton c1;
	private JButton c2;
	private Library library;
	
	public borrowGUI(Library library) {
		super();
		this.library = library;
		setTitle("borrow/return books");
		setSize(400, 600);
		
		JPanel frame2 = new JPanel();
		frame2.setLayout(null);
		frame2.setBounds(0,0,400,600);
		
		
		JTextField tf1 = new JTextField("Unborrowed books");
		tf1.setBounds(0, 0, 400, 20);
		tf1.setEditable(false);
		tf1.setFont(new Font("Arial",Font.BOLD,12));
		tf1.setForeground(Color.red);
		frame2.add(tf1);
		
		JTextField tf2 = new JTextField("borrowed books");
		tf2.setBounds(0, 220, 400, 20);
		tf2.setEditable(false);
		tf2.setFont(new Font("Arial",Font.BOLD,12));
		tf2.setForeground(Color.BLUE);
		frame2.add(tf2);
		
		DefaultListModel listModel = new DefaultListModel();
		
		listModel.addElement(" ************************** ");
				
			for (int i=0; i<library.booklist.size(); i++) {
				if (!library.booklist.get(i).isBorrowed()) {
					listModel.addElement(library.booklist.get(i).getTitle());
				}
			}
		
		DefaultListModel listModel2 = new DefaultListModel();
		
			for (int i=0; i<library.booklist.size(); i++) {
				if (library.booklist.get(i).isBorrowed()) {
					listModel2.addElement(library.booklist.get(i).getTitle());
				}
			}
		
		jlist = new JList(listModel);
		jlist.setBounds(0,20,400,200);
		frame2.add(jlist);
		
		jlist2 = new JList(listModel2);
		jlist2.setBounds(0,240,400,200);
		frame2.add(jlist2);
		
		c1 = new JButton("borrow");
		c1.addActionListener(this);
		c1.setBounds(60, 485, 100, 50);
		frame2.add(c1);
		
		c2 = new JButton("return");
		c2.addActionListener(this);
		c2.setBounds(240,485,100,50);
		frame2.add(c2);
		
		this.setContentPane(frame2);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==c1) {
			String selected_book = (String) jlist.getSelectedValue();
			
			for (int i=0; i<library.booklist.size(); i++) {
				if (library.booklist.get(i).getTitle().equals(selected_book)) {
					library.booklist.get(i).borrowed();
				}
			}
			
			this.dispose();
			borrowGUI newGUI = new borrowGUI(library);
		}
		
		if (e.getSource()==c2) {
			
			String selected_book = (String) jlist2.getSelectedValue();
						
				for (int i=0; i<library.booklist.size(); i++) {
					if (library.booklist.get(i).getTitle().equals(selected_book)) {
						library.booklist.get(i).returned();
					}
				}
				
				this.dispose();
				borrowGUI newGUI = new borrowGUI(library);
		}
	}
}