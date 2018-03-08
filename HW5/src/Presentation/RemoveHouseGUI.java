/*
 * 
 * @author OðuzGül-BuðrahanDönmez , 220201015-220201053
 * 
 */
package Presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JTextField;

import Domain.AllHouses;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoveHouseGUI {

	private JFrame frame;
	private JTextField jtxtID;
	private ArrayList featuresOfRemovedHouse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveHouseGUI window = new RemoveHouseGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RemoveHouseGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public ArrayList getFeaturesOfHouse(){
		return featuresOfRemovedHouse;
	}
	
	public void setVisible(RemoveHouseGUI window){
		window.frame.setVisible(true);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblRemoveHouse = new JLabel("REMOVE HOUSE");
		lblRemoveHouse.setForeground(Color.RED);
		lblRemoveHouse.setFont(new Font("Tekton Pro", Font.PLAIN, 20));
		lblRemoveHouse.setBounds(10, 11, 414, 21);
		frame.getContentPane().add(lblRemoveHouse);
		
		JLabel lblPleaseTypeThe = new JLabel("Please type the ID of the house you want to remove : ");
		lblPleaseTypeThe.setBounds(84, 43, 272, 26);
		frame.getContentPane().add(lblPleaseTypeThe);
		
		jtxtID = new JTextField();
		jtxtID.setBounds(143, 80, 159, 20);
		frame.getContentPane().add(jtxtID);
		jtxtID.setColumns(10);
		
		JButton btnNewButton = new JButton("Remove House");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int response = JOptionPane.showConfirmDialog(null, "The house will be deleted, are you sure?");
			if(response==0){
				boolean flag = true;
				while(flag){
					try{
						int removeID = Integer.parseInt(jtxtID.getText());
						flag = AllHouses.removeHouse(removeID);
						
					}
					catch(ClassCastException error)
					{
						JOptionPane.showMessageDialog(frame, "Id you gave was not valid, Id mus be integer.");
					}
					if(flag = false){
						JOptionPane.showMessageDialog(frame, "Id not found, Try Again.");
					}
				}
				SwingGUI.changeLog();

					frame.dispose();
				}
			}
		});
		btnNewButton.setBounds(143, 132, 159, 80);
		frame.getContentPane().add(btnNewButton);
	}

}
