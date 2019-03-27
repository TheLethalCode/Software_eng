import javax.imageio.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;


import javax.swing.JTextArea;
public class Management_System extends JFrame {

    static Management_System frame;

	public static void main(String[] args) {
        
        // Puts it into the event queue so that it can be invoked later
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
                    // Initialise the main class
					frame= new Management_System();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} 

    Management_System()
    {
        // Set the bounds
        setBounds(100,100,500,500);
        JPanel bg;

        // Set Background Image
        try {
            Image backgroundImage = javax.imageio.ImageIO.read(new File("images/bg5.jpg"));
            final Image bgima = backgroundImage.getScaledInstance(500, 500, Image.SCALE_DEFAULT);
            bg = new JPanel(new BorderLayout()) {
                @Override
                public void paintComponent(Graphics g) {
                    g.drawImage(bgima, 0, 80, null);
                }
            };
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Add the panel to the frame
        setContentPane(bg);

        // Set Heading
        JTextArea heading = new JTextArea("\n   Gymkhana Sports Management System");
        heading.setFont(new Font("DejaVu Sans", Font.BOLD, 20));
        heading.setForeground(new Color(172,11,243));
        heading.setBackground(new Color(52,0,100));
        heading.setEditable(false);

        // Login Button for Gymkhana Authorities
        JButton btnGymkhanaLogin = new JButton("Admin Login");
		btnGymkhanaLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			GymkhanaLogin.main(new String[]{});
			frame.dispose();
			}
		});
		btnGymkhanaLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        // Login Button for Users
		JButton btnUserLogin = new JButton("User Login");
		btnUserLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserLogin.main(new String[]{});
				frame.dispose();
			}
        });
        btnUserLogin.setFont(new Font("Tahoma", Font.BOLD, 14));

         
        GroupLayout gl_contentPane = new GroupLayout(bg);
        
        // Set the horizontal layout
        gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(heading, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(13)
                            .addComponent(btnGymkhanaLogin, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                            .addGap(210)
                            .addComponent(btnUserLogin, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                        )
                    )
                    .addContainerGap(95, Short.MAX_VALUE)
                )
        );
        
        // Set the vertical layout
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
                    .addComponent(heading, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                    .addGap(330)
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
					.addComponent(btnGymkhanaLogin, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUserLogin, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    )
                    .addContainerGap(40, Short.MAX_VALUE)
                )
        );
		bg.setLayout(gl_contentPane);

    }
};