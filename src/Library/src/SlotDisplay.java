import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SlotDisplay extends JFrame {
	static SlotDisplay frame;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame= new SlotDisplay();
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
	public SlotDisplay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel sportsManagement = new JLabel("Slots");
		sportsManagement.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sportsManagement.setForeground(Color.GRAY);
		
		JLabel sportsManagement = new JLabel("Slot 1 : 6:00 AM to 7:00AM");
		sportsManagement.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sportsManagement.setForeground(Color.GRAY);
		JLabel sportsManagement = new JLabel("Slot 2 : 7:00 AM to 8:00AM");
		sportsManagement.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sportsManagement.setForeground(Color.GRAY);
		JLabel sportsManagement = new JLabel("Slot 3 : 5:00 PM to 6:00PM");
		sportsManagement.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sportsManagement.setForeground(Color.GRAY);
		JLabel sportsManagement = new JLabel("Slot 4 : 6:00 AM to 7:00PM");
		sportsManagement.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sportsManagement.setForeground(Color.GRAY);
		JLabel sportsManagement = new JLabel("Slot 5 : 7:00 PM to 8:00PM");
		sportsManagement.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sportsManagement.setForeground(Color.GRAY);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(64)
							.addComponent(sportsManagement))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(140)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnUserLogin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnGymkhanaLogin, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))))
					.addContainerGap(95, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(sportsManagement)
					.addGap(32)
					.addComponent(btnGymkhanaLogin, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnUserLogin, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(70, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
