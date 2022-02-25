import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchBooks extends JFrame {
	static SearchBooks frame;
	private JPanel contentPane;
	private JTable table;
	private JButton btnMain;
	private JButton btnSaearch;
	private JTextField textFieldSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				    frame = new SearchBooks();
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
	public SearchBooks() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnMain = new JButton("Main");
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibraryMain.main(new String[]{});
				frame.dispose();
			}
		});
		btnMain.setBounds(6, 6, 63, 29);
		contentPane.add(btnMain);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(117, 6, 217, 26);
		contentPane.add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		btnSaearch = new JButton("Saearch");
		btnSaearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSaearch.setBounds(346, 6, 98, 29);
		contentPane.add(btnSaearch);
		
		
		
		String data[][]=null;
		String column[]=null;
		try{
			Connection con=DB.getConnection();
			//select from the LOAN and BOOKS 
			PreparedStatement ps=con.prepareStatement("SELECT BOOKS.Isbn,Title,AUTHORS.Author_id,Name FROM BOOKS JOIN BOOK_AUTHORS ON BOOKS.Isbn=BOOK_AUTHORS.Isbn "
					+ "JOIN AUTHORS ON AUTHORS.Author_id=BOOK_AUTHORS.Author_id limit 3;" + 
					"",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String SearchText=textFieldSearch.getText();
			ps.setString(1,SearchText);
			ps.setString(2,SearchText);
			ps.setString(3,SearchText);
			
			ResultSet rs=ps.executeQuery();
			
			ResultSetMetaData rsmd=rs.getMetaData();
			
			int cols=rsmd.getColumnCount();
			column=new String[cols];
			for(int i=1;i<=cols;i++){
				column[i-1]=rsmd.getColumnName(i);
			}
			
			rs.last();
			int rows=rs.getRow();
			rs.beforeFirst();

			data=new String[rows][cols];
			int count=0;
			while(rs.next()){
				for(int i=1;i<=cols;i++){
					data[count][i-1]=rs.getString(i);
				}
				count++;
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		contentPane.setLayout(null);
		
		table = new JTable(data,column);
		JScrollPane sp=new JScrollPane(table);
		sp.setBounds(0, 47, 454, 231);
		
		contentPane.add(sp);
		
		
	}

}
