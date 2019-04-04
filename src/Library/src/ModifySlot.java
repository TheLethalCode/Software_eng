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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		// contentPane = new JPanel();
		// contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// contentPane.setLayout(new BorderLayout(0, 0));
		// setContentPane(contentPane);
		// String data[][]=null;
		// String column[]=null;
		// try{
		// 	Connection con=DB.getConnection();
		// 	PreparedStatement ps=con.prepareStatement("select * from librarian",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		// 	ResultSet rs=ps.executeQuery();
			
		// 	ResultSetMetaData rsmd=rs.getMetaData();
		// 	int cols=rsmd.getColumnCount();
		// 	column=new String[cols];
		// 	for(int i=1;i<=cols;i++){
		// 		column[i-1]=rsmd.getColumnName(i);
		// 	}
			
		// 	rs.last();
		// 	int rows=rs.getRow();
		// 	rs.beforeFirst();

		// 	data=new String[rows][cols];
		// 	int count=0;
		// 	while(rs.next()){
		// 		for(int i=1;i<=cols;i++){
		// 			data[count][i-1]=rs.getString(i);
		// 		}
		// 		count++;
		// 	}
		// 	con.close();
		// }catch(Exception e){System.out.println(e);}
		
		// table = new JTable(data,column);
		// JScrollPane sp=new JScrollPane(table);
		
		// contentPane.add(sp, BorderLayout.CENTER);
		JPanel bg;
		
		// Set Background Image
        try {
            Image backgroundImage = javax.imageio.ImageIO.read(new File("images/allsports.jpg"));
            final Image bgima = backgroundImage.getScaledInstance(635, 500, Image.SCALE_DEFAULT);
            bg = new JPanel(new BorderLayout()) {
                @Override
                public void paintComponent(Graphics g) {
                    g.drawImage(bgima, 0, 0, null);
                }
            };
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Add the panel to the frame
        setContentPane(bg);
		
		// Heading Label
		JLabel heading = new JLabel("         Modify Slot");
		heading.setForeground(new Color(200,250,230));
		heading.setFont(new Font("Tahoma", Font.BOLD, 28));
		
		// The ComboBox of all possible sports
		String[] sports = { "--- Choose Activity ---", "Badminton" , "Gym" , "Squash" , "Table Tennis" , "Swimming", "Tennis", "BasketBall" };
		JComboBox list = new JComboBox(sports);
		list.setBackground(new Color(43,54,54));
		list.setForeground(new Color(210,180,180));
		
		// Check Slots button
		JButton slotCheck = new JButton("Modify Slots");
		slotCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedIndex() != 0){

				}
				frame.dispose();
			}
		});
		slotCheck.setFont(new Font("Tahoma", Font.BOLD, 15));
		slotCheck.setBackground(new Color(17, 12, 18));
		slotCheck.setForeground(Color.WHITE);
		
		// Logout Button
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Management_System.main(new String[]{});
				frame.dispose();
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogout.setBackground(new Color(17, 12, 18));
		btnLogout.setForeground(Color.WHITE);

		// Horizontal and Vertical layout for the panel
		GroupLayout gl_contentPane = new GroupLayout(bg);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(70)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(heading)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(85)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(list, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(26)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
										.addComponent(slotCheck)
									)
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
					.addGap(188)
					.addComponent(slotCheck, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
				)
		);
		bg.setLayout(gl_contentPane);
	}

}
