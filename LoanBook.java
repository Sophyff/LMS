import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoanBook extends JFrame {
	static LoanBook frame;
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
					frame = new LoanBook();
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
	public LoanBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Loan Book ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.BLUE);
		
		JLabel lblBookIsbn = new JLabel("Book ISBN:");
		
		textFieldIsbn = new JTextField();
		textFieldIsbn.setColumns(10);
		
		textFieldCardId = new JTextField();
		textFieldCardId.setColumns(10);
		
		JLabel lblCardId = new JLabel("Card Id:");
		
		JButton btnIssueBook = new JButton("Loan Book");
		btnIssueBook.setForeground(Color.BLUE);
		btnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String bookisbn=textFieldIsbn.getText();
			int cardid=Integer.parseInt(textFieldCardId.getText());
			
			
			if(LoanBookDao.checkBorrowerNum(cardid)){
			
			int i=LoanBookDao.save(bookisbn, cardid);
			if(i>0){
				int j=LoanBookDao.updatebook(bookisbn);
				if(j>0) {
				JOptionPane.showMessageDialog(LoanBook.this,"Book issued successfully!");
				LibraryMain.main(new String[]{});
				frame.dispose();
				}
				
			}else{
				JOptionPane.showMessageDialog(LoanBook.this,"Sorry, unable to issue!");
			}//end of save if-else
			
			}
			else{
				JOptionPane.showMessageDialog(LoanBook.this,"Sorry, this borrower has already loaned 3 books!");
			}//end of checkbook if-else
			
			}
		});
		
		JButton btnMain = new JButton("Main");
		btnMain.setForeground(Color.BLUE);
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibraryMain.main(new String[]{});
				frame.dispose();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Note: Please check Card ID Carefully before loaning book!");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setForeground(Color.RED);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCardId)
								.addComponent(lblBookIsbn))
							.addGap(47))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(16)
							.addComponent(btnMain)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(82)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(106, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldIsbn, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldCardId, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
							.addGap(230))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addComponent(lblNewLabel_1)
					.addContainerGap(164, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(160)
					.addComponent(btnIssueBook, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(262, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(13)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMain))
					.addGap(67)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBookIsbn)
						.addComponent(textFieldIsbn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCardId)
						.addComponent(textFieldCardId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addComponent(btnIssueBook, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(112)
					.addComponent(lblNewLabel_1)
					.addGap(38))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
