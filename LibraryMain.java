import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LibraryMain extends JFrame {
	static LibraryMain frame;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LibraryMain();
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
	public LibraryMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 433);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblLibrarianSection = new JLabel("Library Management System");
		lblLibrarianSection.setForeground(Color.BLUE);
		lblLibrarianSection.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JButton btnSearchBooks = new JButton("Search Books");
		btnSearchBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SearchBooks.main(new String[]{});
				frame.dispose();
			}
		});
		btnSearchBooks.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnBorrowers = new JButton("Borrowers Manage");
		btnBorrowers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Borrowers.main(new String[]{});
				frame.dispose();
			}
		});
		btnBorrowers.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		
		JButton btnLoanedBooks = new JButton("View Loaned Books");
		btnLoanedBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewLoanedBooks.main(new String[]{});
			}
		});
		btnLoanedBooks.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnViewBorrowers = new JButton("View Borrowers");
		btnViewBorrowers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewBorrowers.main(new String[] {});
			}
		});
		btnViewBorrowers.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnLoanBook = new JButton("Loan Book");
		btnLoanBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoanBook.main(new String[]{});
				frame.dispose();
			}
		});
		btnLoanBook.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnBooks.main(new String[]{});
				frame.dispose();
			}
		});
		btnReturnBook.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnSearchBooks, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnBorrowers, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblLibrarianSection)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnReturnBook, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLoanedBooks, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
							.addGap(26)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnViewBorrowers, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLoanBook, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(114, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblLibrarianSection)
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSearchBooks, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBorrowers, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLoanedBooks, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnViewBorrowers, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(46)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnReturnBook, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLoanBook, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(160, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
