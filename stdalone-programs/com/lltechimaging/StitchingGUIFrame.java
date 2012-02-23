package com.lltechimaging;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class StitchingGUIFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StitchingGUIFrame frame = new StitchingGUIFrame();
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
	public StitchingGUIFrame() {
		getContentPane().setFocusTraversalPolicyProvider(true);
		setTitle("Stitching");
		setResizable(false);
		setBounds(100, 100, 450, 201);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(20, 20));
		
		Box verticalBox = Box.createVerticalBox();
		getContentPane().add(verticalBox, BorderLayout.SOUTH);
		
		JLabel lblFootNote = new JLabel("<html>This program is using components from Fiji<br>\nStitiching plugin:<br>\n   &nbsp;&nbsp;&nbsp;\u00A9 Stephen Preibisch, Max Planck Institute of Molecular Cell Biology and Genetics<br>\n   &nbsp;&nbsp;&nbsp;Enhancements \u00A9 LLTech\n</html>");
		verticalBox.add(lblFootNote);
		lblFootNote.setFont(lblFootNote.getFont().deriveFont(lblFootNote.getFont().getSize() - 3f));
		lblFootNote.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFootNote.setHorizontalAlignment(SwingConstants.CENTER);
		lblFootNote.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblFootNote.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut);
		
		Box verticalBox_1 = Box.createVerticalBox();
		getContentPane().add(verticalBox_1, BorderLayout.NORTH);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalBox_1.add(verticalStrut_1);
		
		JLabel label = new JLabel("Stitching in progress...");
		verticalBox_1.add(label);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(label.getFont().deriveFont(label.getFont().getStyle() | Font.BOLD, label.getFont().getSize() + 2f));

	}

}
