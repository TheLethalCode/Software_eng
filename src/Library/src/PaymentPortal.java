import javax.imageio.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.sql.*;

public class PaymentPortal extends JFrame {
	static PaymentPortal frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new PaymentPortal(args[0]);
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
	public PaymentPortal(String sport) {

		// Set the default close operation.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the bounds
        setBounds(100,100,500,500);
		JPanel bg;
		
		// Set Background Image
        try {
            Image backgroundImage = javax.imageio.ImageIO.read(new File("images/sbi_new.jpg"));
            final Image bgima = backgroundImage.getScaledInstance(700, 500, Image.SCALE_DEFAULT);
            bg = new JPanel(new BorderLayout()) {
                @Override
                public void paintComponent(Graphics g) {
                    g.drawImage(bgima, -100, 0, null);
                }
            };
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Add the panel to the frame
        setContentPane(bg);
		
		// The Title
		JLabel heading = new JLabel("Payment Portal");
		heading.setForeground(new Color(110,150,110));
		heading.setFont(new Font("Tahoma", Font.BOLD, 34));
		
		
		/* All TextFields */
		
		// Username TextField
		JTextField textFieldName = new JTextField("Account Holder Name");
		textFieldName.setBackground(new Color(200,200,205));
		textFieldName.setFont(new Font("Tahoma", Font.ITALIC, 12));
		textFieldName.setHorizontalAlignment(0);

			// Adding focus listener
			textFieldName.addFocusListener(new FocusListener() {
				@Override
				public void focusGained(FocusEvent e) {
					if (textFieldName.getText().equals("Account Holder Name")) {
						textFieldName.setText("");
						textFieldName.setForeground(new Color(0,0,45));
						textFieldName.setFont(new Font("Tahoma", Font.BOLD, 14));
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if (textFieldName.getText().isEmpty()) {
						textFieldName.setForeground(new Color(45,45,80));
						textFieldName.setFont(new Font("Tahoma", Font.ITALIC, 12));
						textFieldName.setHorizontalAlignment(0);
						textFieldName.setText("Account Holder Name");
					}
				}
				});

		//account number
		JTextField textFieldNumber = new JTextField("Account Number");
		textFieldNumber.setBackground(new Color(200,200,205));
		textFieldNumber.setFont(new Font("Tahoma", Font.ITALIC, 12));
		textFieldNumber.setHorizontalAlignment(0);

			// Adding focus listener
			textFieldNumber.addFocusListener(new FocusListener() {
				@Override
				public void focusGained(FocusEvent e) {
					if (textFieldNumber.getText().equals("Account Number")) {
						textFieldNumber.setText("");
						textFieldNumber.setForeground(new Color(0,0,45));
						textFieldNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if (textFieldNumber.getText().isEmpty()) {
						textFieldNumber.setForeground(new Color(45,45,80));
						textFieldNumber.setFont(new Font("Tahoma", Font.ITALIC, 12));
						textFieldNumber.setHorizontalAlignment(0);
						textFieldNumber.setText("Account Number");
					}
				}
				});

		//amount
		JTextField textFieldAmount = new JTextField("Rupees 500/-");
		textFieldAmount.setBackground(new Color(200,200,205));
		textFieldAmount.setFont(new Font("Tahoma", Font.ITALIC, 12));
		textFieldAmount.setHorizontalAlignment(0);
		textFieldAmount.setEditable(false);
			
		
		//account cvv
		JTextField textFieldCVV = new JTextField("Account CVV");
		textFieldCVV.setBackground(new Color(200,200,205));
		textFieldCVV.setFont(new Font("Tahoma", Font.ITALIC, 12));
		textFieldCVV.setHorizontalAlignment(0);

			// Adding focus listener
			textFieldCVV.addFocusListener(new FocusListener() {
				@Override
				public void focusGained(FocusEvent e) {
					if (textFieldCVV.getText().equals("Account CVV")) {
						textFieldCVV.setText("");
						textFieldCVV.setForeground(new Color(0,0,45));
						textFieldCVV.setFont(new Font("Tahoma", Font.BOLD, 14));
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if (textFieldCVV.getText().isEmpty()) {
						textFieldCVV.setForeground(new Color(45,45,80));
						textFieldCVV.setFont(new Font("Tahoma", Font.ITALIC, 12));
						textFieldCVV.setHorizontalAlignment(0);
						textFieldCVV.setText("Account CVV");
					}
				}
				});

		
		
		// IFSC TextField
		JTextField textFieldIFSC = new JTextField("Enter IFSC");
		textFieldIFSC.setBackground(new Color(200,200,205));
		textFieldIFSC.setFont(new Font("Tahoma", Font.ITALIC, 12));
		textFieldIFSC.setHorizontalAlignment(0);

			// Adding focus listener
			textFieldIFSC.addFocusListener(new FocusListener() {
				@Override
				public void focusGained(FocusEvent e) {
					if (textFieldIFSC.getText().equals("Enter IFSC")) {
						textFieldIFSC.setText("");
						textFieldIFSC.setForeground(new Color(0,0,45));
						textFieldIFSC.setFont(new Font("Tahoma", Font.BOLD, 14));
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if (textFieldIFSC.getText().isEmpty()) {
						textFieldIFSC.setForeground(new Color(45,45,80));
						textFieldIFSC.setFont(new Font("Tahoma", Font.ITALIC, 12));
						textFieldIFSC.setHorizontalAlignment(0);
						textFieldIFSC.setText("Enter IFSC");
					}
				}
				});


		/* All Buttons */

		// Add Pay Button
		JButton btnNewButton = new JButton("Pay");
		btnNewButton.setBackground(new Color(9, 9, 42));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));

			// Action Listener for the button
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(PaymentPortal.this,"Payment Successful!");
				DisplaySlot.main(new String[]{sport});
				frame.dispose();	

				}
			});
		
		// Back button
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(9, 9, 9));
		btnBack.setForeground(Color.WHITE);
		btnBack.setFocusPainted(false);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));

			// Focus Listener
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				DisplaySlot.main(new String[]{sport});
				frame.dispose();
				}
			});

		// Layout for the background
		GroupLayout gl_contentPane = new GroupLayout(bg);

		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(150)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textFieldName, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
						.addComponent(textFieldNumber, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
						.addComponent(textFieldAmount, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
						.addComponent(textFieldCVV, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
						.addComponent(textFieldIFSC, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
					)
					
				)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(110)
					.addComponent(heading)
					.addGap(144)
				)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(180)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(250)
				)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(205)
					.addComponent(btnBack)
					.addGap(40)
				)
		);
		// addComponent(textFieldName, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
		// .addComponent(textFieldNumber, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
		// .addComponent(textFieldAmount, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
		// .addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
		// .addComponent(textFieldIFSC

		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					
					.addGap(15)
					.addComponent(heading)
					
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(textFieldNumber, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						)
					)
					
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						// .addComponent(lblEmailIcon)
						.addComponent(textFieldAmount, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					)

					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						// .addComponent(lblIDIcon)
						.addComponent(textFieldCVV, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					)

					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						// .addComponent(lblPhoneIcon)
						.addComponent(textFieldIFSC, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					)

					.addGap(40)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					
					.addGap(25)
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
				)
		);
		bg.setLayout(gl_contentPane);
	}

}
