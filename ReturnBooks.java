import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReturnBooks extends JFrame {
	static ReturnBooks frame;
	private JPanel contentPane;
	private JTextField textFieldIsbn;
	private JTextField textFieldCardId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ReturnBooks();
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
	public ReturnBooks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblReturnBook = new JLabel("Return Book");
		lblReturnBook.setForeground(Color.GRAY);
		lblReturnBook.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblBookIsbn = new JLabel("Book ISBN:");
		
		JLabel lblCardId = new JLabel("Card Id:");
		
		textFieldIsbn = new JTextField();
		textFieldIsbn.setColumns(10);
		
		textFieldCardId = new JTextField();
		textFieldCardId.setColumns(10);
		
		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.setForeground(Color.BLUE);
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookIsbn=textFieldIsbn.getText();
				int Card_id=Integer.parseInt(textFieldCardId.getText());
				int i=ReturnBookDao.delete(bookIsbn, Card_id);
				
				if(i>0){
					JOptionPane.showMessageDialog(ReturnBooks.this,"Book returned successfully!");
					LibraryMain.main(new String[]{});
					frame.dispose();
					
				}else{
					JOptionPane.showMessageDialog(ReturnBooks.this,"Sorry, unable to return book!");
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("Note: Check the book properly!");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnMain = new JButton("Main");
		btnMain.setForeground(Color.BLUE);
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibraryMain.main(new String[]{});
				frame.dispose();
			}
		});
		
		JButton btnFineCheck = new JButton("Fine Check");
		btnFineCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FineCheck.main(new String[] {});
			}
		});
		btnFineCheck.setForeground(Color.BLUE);
		
		JButton btnPayFine = new JButton("Pay Fine ");
		btnPayFine.setForeground(Color.BLUE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNewLabel)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnMain)
								.addGap(56)
								.addComponent(lblReturnBook)
								.addContainerGap(238, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblBookIsbn, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldIsbn, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(31)
					.addComponent(lblCardId, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(textFieldCardId, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
					.addGap(219))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(51)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnPayFine, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnFineCheck, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
					.addComponent(btnReturnBook, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addGap(47))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblReturnBook)
								.addComponent(btnMain))
							.addGap(40)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblBookIsbn)
								.addComponent(textFieldIsbn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(13)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldCardId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCardId))
							.addGap(43)
							.addComponent(btnFineCheck, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnPayFine, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
							.addComponent(lblNewLabel)
							.addGap(72))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(btnReturnBook, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addGap(149))))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
