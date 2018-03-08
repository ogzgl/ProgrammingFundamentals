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
import java.awt.Window;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JTextField;

import Domain.AllHouses;
import Domain.House;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddHouseGUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField jtxtPrice;
	private JTextField jtxtSize;
	private JTextField jtxtRooms;
	private JTextField jtxtBathrooms;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddHouseGUI window = new AddHouseGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddHouseGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	
	public void setVisible(AddHouseGUI window){
		window.frame.setVisible(true);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAddHouse = new JLabel("ADD HOUSE");
		lblAddHouse.setForeground(Color.RED);
		lblAddHouse.setFont(new Font("Tekton Pro", Font.PLAIN, 20));
		lblAddHouse.setBounds(10, 11, 414, 21);
		frame.getContentPane().add(lblAddHouse);
		
		JLabel lblPrice = new JLabel("Price($) : ");
		lblPrice.setBounds(20, 77, 61, 14);
		frame.getContentPane().add(lblPrice);
		
		jtxtPrice = new JTextField();
		jtxtPrice.setColumns(10);
		jtxtPrice.setBounds(95, 74, 86, 20);
		frame.getContentPane().add(jtxtPrice);
		
		JLabel lblSizem = new JLabel("Size(m^2) : ");
		lblSizem.setBounds(20, 104, 61, 23);
		frame.getContentPane().add(lblSizem);
		
		jtxtSize = new JTextField();
		jtxtSize.setColumns(10);
		jtxtSize.setBounds(95, 105, 86, 20);
		frame.getContentPane().add(jtxtSize);
		
		JLabel lblRooms = new JLabel("Rooms : ");
		lblRooms.setBounds(20, 138, 46, 14);
		frame.getContentPane().add(lblRooms);
		
		jtxtRooms = new JTextField();
		jtxtRooms.setBounds(95, 135, 86, 20);
		frame.getContentPane().add(jtxtRooms);
		jtxtRooms.setColumns(10);
		
		JLabel lblBathrooms = new JLabel("Bathrooms : ");
		lblBathrooms.setBounds(20, 165, 61, 21);
		frame.getContentPane().add(lblBathrooms);
		
		jtxtBathrooms = new JTextField();
		jtxtBathrooms.setColumns(10);
		jtxtBathrooms.setBounds(95, 166, 86, 20);
		frame.getContentPane().add(jtxtBathrooms);
		
		JLabel lblAc = new JLabel("AC : ");
		lblAc.setBounds(20, 208, 46, 14);
		frame.getContentPane().add(lblAc);
		
		JRadioButton rdbtnYes = new JRadioButton("Yes");
		rdbtnYes.setBounds(95, 193, 109, 23);
		frame.getContentPane().add(rdbtnYes);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(95, 219, 109, 23);
		frame.getContentPane().add(rdbtnNo);
		
		JButton btnNewButton = new JButton("Add House");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				House newHouse = new House();
				newHouse.setPrice(Double.parseDouble(jtxtPrice.getText()));
				newHouse.setSize(Double.parseDouble(jtxtSize.getText()));
				newHouse.setNumberOfRooms(Double.parseDouble(jtxtSize.getText()));
				newHouse.setNumberOfBathrooms(Integer.parseInt(jtxtBathrooms.getText()));
				if(rdbtnYes.isSelected()){
					newHouse.setHavingAirconditioner(true);
				}
				AllHouses.addHouse(newHouse);
				JOptionPane.showMessageDialog(frame, "House successfully added.");
				SwingGUI.changeLog();
				frame.dispose();
			}
		});
		btnNewButton.setBounds(247, 84, 139, 63);
		frame.getContentPane().add(btnNewButton);
	}
}
