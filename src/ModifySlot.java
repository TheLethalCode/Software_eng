import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.imageio.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;

// Class responsible for modifying the slots and its booking

public class ModifySlot extends JFrame {
	static ModifySlot frame;
	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ModifySlot();
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
	public ModifySlot() {

		// Set Default close operation
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Setting the bounds of the GUI
		setBounds(100, 100, 500, 500);
		
		JPanel bg;
		
		// Set Background Image
        try {
            Image backgroundImage = javax.imageio.ImageIO.read(new File("images/allsports.jpg"));
            final Image bgima = backgroundImage.getScaledInstance(750, 500, Image.SCALE_DEFAULT);
            bg = new JPanel(new BorderLayout()) {
                @Override
                public void paintComponent(Graphics g) {
                    g.drawImage(bgima, -120, 0, null);
                }
            };
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Add the panel to the frame
        setContentPane(bg);
		
		// Heading Label
		JLabel heading = new JLabel("Update Slot Booking");
		heading.setForeground(new Color(200,250,230));
		heading.setFont(new Font("Tahoma", Font.BOLD, 28));
		
		// The ComboBox of all possible sports
		String[] sports = { "--- Choose Activity ---", "Badminton" , "Gym" , "Squash" , "Table Tennis" , "Swimming", "Tennis", "Basket Ball" };
		JComboBox list = new JComboBox(sports);
		list.setBackground(new Color(200,250,214));
		list.setForeground(new Color(10,0,18));

		// The ComboBox of all possible slots
		String[] slots = { "--- Choose Slot ---", "Slot 1" , "Slot 2" , "Slot 3" , "Slot 4" , "Slot 5" };
		JComboBox list_slot = new JComboBox(slots);
		list_slot.setBackground(new Color(200,250,214));
		list_slot.setForeground(new Color(10,0,18));
		
		// Check Slots button
		JButton slotCheck = new JButton("Update Slot");
		slotCheck.setFont(new Font("Tahoma", Font.BOLD, 15));
		slotCheck.setBackground(new Color(180,180,240));
		slotCheck.setForeground(Color.BLACK);
		
			// Action Listener
			slotCheck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					// If Activity and Slot is chosen, increase slot by 1
					if(list.getSelectedIndex() != 0 && list_slot.getSelectedIndex() != 0)
					{
						int ret = SlotDao.update(list.getSelectedItem().toString(),1,list_slot.getSelectedIndex());
						if(ret == 1)
						{
							JOptionPane.showMessageDialog(ModifySlot.this,"Slot updated successfully!");
						}
						else if(ret == 0)
						{
							JOptionPane.showMessageDialog(ModifySlot.this,"Sorry, slot is not available!");
						}
						else
						{
							JOptionPane.showMessageDialog(ModifySlot.this,"Sorry, error updating!");
						}
					}
					else if(list.getSelectedIndex() == 0)
					{
						JOptionPane.showMessageDialog(ModifySlot.this, "Please choose an activity to update slots","Error!", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(ModifySlot.this, "Please choose a slot to update","Error!", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		
		// Clear slots button
		JButton clearSlots = new JButton("Reset Slots");
		clearSlots.setFont(new Font("Tahoma", Font.BOLD, 15));
		clearSlots.setBackground(new Color(180,180,240));
		clearSlots.setForeground(Color.BLACK);

			// Adding action listener
			clearSlots.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					// If a sport is selected
					if(list.getSelectedIndex() != 0)
					{
						// Confirmation dialog box
						int input = JOptionPane.showConfirmDialog(ModifySlot.this, "Do you want to really reset all slots of " + list.getSelectedItem().toString() + " ?","Are you sure?",JOptionPane.YES_NO_OPTION);
						if( input == 0)
						{
							int ret = SlotDao.update(list.getSelectedItem().toString(),-1,list_slot.getSelectedIndex());
							if(ret == 1)
							{
								JOptionPane.showMessageDialog(ModifySlot.this,"All slots of "+list.getSelectedItem().toString()+" resetted successfully");
							}
							else
							{
								JOptionPane.showMessageDialog(ModifySlot.this,"Sorry, error resetting!");
							}
						}
					}
					else
					{
						JOptionPane.showMessageDialog(ModifySlot.this, "Please choose an activity to reset slots","Error!", JOptionPane.ERROR_MESSAGE);
					}
				}
			});

		// Back Button
		JButton btnLogout = new JButton("Back");
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogout.setBackground(new Color(70,70,75));
		btnLogout.setForeground(Color.BLACK);

			// Action Listener
			btnLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int input = JOptionPane.showConfirmDialog(ModifySlot.this, "Do you want to really go back? " ,"Are you sure?",JOptionPane.YES_NO_OPTION);
					if( input == 0)
					{
						GymkhanaSuccess.main(new String[]{});
						frame.dispose();
					}
				}
			});

		// Horizontal and Vertical layout for the panel
		GroupLayout gl_contentPane = new GroupLayout(bg);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(70)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(15)
							.addComponent(heading)
						)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(85)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(list, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
								.addComponent(list_slot, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(20)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(slotCheck, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
										.addComponent(clearSlots, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
									)
									.addGap(75)
									.addComponent(btnLogout)
								)
							)
						)
					)
					.addContainerGap(101, Short.MAX_VALUE)
				)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGap(28)
					.addComponent(heading)
					.addGap(58)
					.addComponent(list,GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(list_slot,GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(108)
					.addComponent(slotCheck,GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(clearSlots, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(48)
					.addComponent(btnLogout)
				)
		);
		bg.setLayout(gl_contentPane);
	}

}
