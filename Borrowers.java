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
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Borrowers extends JFrame {
	static Borrowers frame;
	private JPanel contentPane;
	private JTextField textFieldSsn;
	private JTextField textFieldLname;
	private JTextField textFieldAddress;
	private JTextField textFieldCity;
	private JTextField textFieldPhone;
	private JTextField textFieldState;
	private JTextField textFieldCardid;
	private JTextField textFieldFname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Borrowers();
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
	public Borrowers() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAddLibrarian = new JLabel("Add Borrower");
		lblAddLibrarian.setForeground(new Color(64, 64, 64));
		lblAddLibrarian.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblSsn = new JLabel("Ssn");		
		JLabel lblFname = new JLabel("First Name");		
		JLabel lblLname = new JLabel("Last Name");	
		JLabel lblAddress = new JLabel("Address:");
		JLabel lblCity = new JLabel("City:");
		JLabel lblState = new JLabel("State");
		JLabel lblPhoneNo = new JLabel("Phone No:");
		
		textFieldSsn = new JTextField();
		textFieldSsn.setColumns(10);
		
		textFieldFname = new JTextField();
		textFieldFname.setColumns(10);
		
		textFieldLname = new JTextField();
		textFieldLname.setColumns(10);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setColumns(10);
		
		textFieldCity = new JTextField();
		textFieldCity.setColumns(10);
		
		textFieldState = new JTextField();
		textFieldState.setColumns(10);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setColumns(10);

		
		
		
		JButton btnAddBorrower = new JButton("Add Borrower");
		btnAddBorrower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			String Ssn=textFieldSsn.getText();	
			String Fname=textFieldFname.getText();
			String Lname=textFieldLname.getText();	
			String Address=textFieldAddress.getText();
			String City=textFieldCity.getText();
			String State=textFieldState.getText();
			String Phone=textFieldPhone.getText();
			
			boolean valid=BorrowersEdit.validate(Ssn);//check the SSN if it is valid
			if(!valid) {
			int i=BorrowersEdit.save(Ssn,Fname, Lname, Address, City, State, Phone);
			if(i>0){
				JOptionPane.showMessageDialog(Borrowers.this,"Borrower added successfully!");
				// frame.dispose();
				
			}else{
				JOptionPane.showMessageDialog(Borrowers.this,"Sorry, unable to save!");
			}
			}
			
			else {
				JOptionPane.showMessageDialog(Borrowers.this,"This Ssn is already exit and unable to save another!");
			}
			}
		});
		btnAddBorrower.setForeground(Color.BLUE);
		
		
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.BLUE);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			LibraryMain.main(new String[]{});
			frame.dispose();
			}
		});
		
		
		
		
		JLabel lblDeleteBorrower = new JLabel("Delete Borrower");
		lblDeleteBorrower.setForeground(Color.DARK_GRAY);
		lblDeleteBorrower.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JLabel lblCardid = new JLabel("Card_id");
		
		textFieldCardid = new JTextField();
		textFieldCardid.setColumns(10);
		
		JButton btnDeleteBorrow = new JButton("Delete Borrow");
		btnDeleteBorrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cardid=textFieldCardid.getText();
				if(cardid==null||cardid.trim().equals("")){
					JOptionPane.showMessageDialog(Borrowers.this,"Id can't be blank");
				}else{
					int id=Integer.parseInt(cardid);
					int i=BorrowersEdit.delete(id);
					if(i>0){
						JOptionPane.showMessageDialog(Borrowers.this,"Record deleted successfully!");
					}else{
						JOptionPane.showMessageDialog(Borrowers.this,"Unable to delete given id!");
					}
				}
			}
				
			
		});
		btnDeleteBorrow.setForeground(Color.BLUE);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblCardid)
							.addGap(24)
							.addComponent(textFieldCardid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblAddLibrarian)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblSsn)
								.addComponent(lblAddress, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblCity, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPhoneNo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblLname)
								.addComponent(lblFname))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldAddress, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(textFieldCity, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
												.addComponent(textFieldLname, Alignment.LEADING))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblState, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
										.addComponent(textFieldPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnAddBorrower, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldState, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addComponent(btnBack)
											.addComponent(btnDeleteBorrow, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))))
								.addComponent(textFieldSsn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldFname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblDeleteBorrower, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddLibrarian)
						.addComponent(btnBack))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSsn)
						.addComponent(textFieldSsn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFname)
						.addComponent(textFieldFname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLname)
						.addComponent(textFieldLname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddress)
						.addComponent(textFieldAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCity)
						.addComponent(textFieldCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblState)
						.addComponent(textFieldState, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPhoneNo)
						.addComponent(textFieldPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddBorrower, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(25)
							.addComponent(lblDeleteBorrower, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCardid)
								.addComponent(textFieldCardid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDeleteBorrow, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
					.addGap(17))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
