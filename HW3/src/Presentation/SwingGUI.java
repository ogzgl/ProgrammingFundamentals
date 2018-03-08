/*
 * 
 * @author OðuzGül-BuðrahanDönmez , 220201015-220201053
 * 
 */
package Presentation;

import java.awt.EventQueue;

import domain.Company;
import fileAccess.DataAccessLayer;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class SwingGUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private static Company company = new Company();
	private ArrayList<String> temp = new ArrayList<String>();
	private ArrayList<String> temp1 = new ArrayList<String>();
	private ArrayList<String> temp2 = new ArrayList<String>();
	private String tempPayer = new String();
	private static boolean flag = false;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JButton btnAccept;
	private JButton btnAccepr;
	private JLabel lblNationalId;
	private JLabel lblNewLabel;
	private JLabel lblPhoneNumber;
	private JLabel lblAddress;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JButton btnEndOfThe;
	private static int counter = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingGUI window = new SwingGUI();
					window.frame.setVisible(true);
					if(counter == 0){
						DataAccessLayer reader = new DataAccessLayer();
						reader.readVehicles(company);
						counter = 1;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SwingGUI() {
		initialize();
	}
	
	public static void showLabel(JLabel label){
		label.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(116, 11, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(221, 11, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(34, 85, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		textField_3.setVisible(false);
		
		JLabel lblYourCargoIs = new JLabel("YOUR CARGO IS VALID");
		lblYourCargoIs.setBounds(10, 65, 160, 14);
		frame.getContentPane().add(lblYourCargoIs);
		lblYourCargoIs.setVisible(false);
		
		JLabel lblYourCargoIs_1 = new JLabel("PLEASE CHANGE YOUR PREFERENCES!");
		lblYourCargoIs_1.setBounds(10, 65, 246, 14);
		frame.getContentPane().add(lblYourCargoIs_1);
		lblYourCargoIs_1.setVisible(false);
		
		JLabel lblSenderInfo = new JLabel("SENDER INFO : ");
		lblSenderInfo.setForeground(Color.RED);
		lblSenderInfo.setBounds(10, 159, 110, 14);
		frame.getContentPane().add(lblSenderInfo);
		lblSenderInfo.setVisible(false);
		
		JLabel lblReceiverInfo = new JLabel("RECEIVER INFO : ");
		lblReceiverInfo.setForeground(Color.RED);
		lblReceiverInfo.setBounds(10, 204, 110, 14);
		frame.getContentPane().add(lblReceiverInfo);
		lblReceiverInfo.setVisible(false);
		
		textField_4 = new JTextField();
		textField_4.setBounds(10, 173, 86, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		textField_4.setVisible(false);
		
		textField_5 = new JTextField();
		textField_5.setBounds(101, 173, 86, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		textField_5.setVisible(false);
		
		textField_6 = new JTextField();
		textField_6.setBounds(192, 173, 86, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		textField_6.setVisible(false);
		
		textField_7 = new JTextField();
		textField_7.setBounds(283, 173, 86, 20);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		textField_7.setVisible(false);
		
		textField_8 = new JTextField();
		textField_8.setBounds(10, 229, 86, 20);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		textField_8.setVisible(false);
		
		textField_9 = new JTextField();
		textField_9.setBounds(101, 229, 86, 20);
		frame.getContentPane().add(textField_9);
		textField_9.setColumns(10);
		textField_9.setVisible(false);
		
		textField_10 = new JTextField();
		textField_10.setBounds(192, 229, 86, 20);
		frame.getContentPane().add(textField_10);
		textField_10.setColumns(10);
		textField_10.setVisible(false);
		
		textField_11 = new JTextField();
		textField_11.setBounds(283, 229, 86, 20);
		frame.getContentPane().add(textField_11);
		textField_11.setColumns(10);
		textField_11.setVisible(false);
		
		JLabel lblPayer = new JLabel("PAYER : ");
		lblPayer.setForeground(Color.RED);
		lblPayer.setBounds(130, 204, 85, 14);
		frame.getContentPane().add(lblPayer);
		lblPayer.setVisible(false);
		
		textField_12 = new JTextField();
		textField_12.setBounds(202, 201, 86, 20);
		frame.getContentPane().add(textField_12);
		textField_12.setColumns(10);
		textField_12.setVisible(false);
		
		lblNationalId = new JLabel("National ID");
		lblNationalId.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblNationalId.setBounds(10, 192, 46, 14);
		frame.getContentPane().add(lblNationalId);
		lblNationalId.setVisible(false);
		
		lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblNewLabel.setBounds(101, 191, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setVisible(false);
		
		lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblPhoneNumber.setBounds(192, 191, 86, 14);
		frame.getContentPane().add(lblPhoneNumber);
		lblPhoneNumber.setVisible(false);
		
		lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblAddress.setBounds(282, 191, 66, 14);
		frame.getContentPane().add(lblAddress);
		lblAddress.setVisible(false);
		
		label_1 = new JLabel("National ID");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		label_1.setBounds(10, 247, 46, 14);
		frame.getContentPane().add(label_1);
		label_1.setVisible(false);
		
		label_2 = new JLabel("Name");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		label_2.setBounds(101, 246, 46, 14);
		frame.getContentPane().add(label_2);
		label_2.setVisible(false);
		
		label_3 = new JLabel("Phone Number");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 8));
		label_3.setBounds(192, 246, 86, 14);
		frame.getContentPane().add(label_3);
		label_3.setVisible(false);
		
		label_4 = new JLabel("Address");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 8));
		label_4.setBounds(282, 246, 66, 14);
		frame.getContentPane().add(label_4);
		label_4.setVisible(false);
		
		btnEndOfThe = new JButton("END OF THE DAY");
		btnEndOfThe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataAccessLayer saveFile = new DataAccessLayer();
				try {
					saveFile.saveToDat(company);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEndOfThe.setBounds(266, 56, 145, 23);
		frame.getContentPane().add(btnEndOfThe);
		if(company.getSizeCargoes() == 0){
			btnEndOfThe.setEnabled(false);
		}
		else{
			btnEndOfThe.setVisible(true);
		}
		
		btnAccepr = new JButton("ACCEPT");
		btnAccepr.setVisible(false);
		btnAccepr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp1.add(textField_4.getText());
				temp1.add(textField_5.getText());
				temp1.add(textField_6.getText());
				temp1.add(textField_7.getText());
				temp2.add(textField_8.getText());
				temp2.add(textField_9.getText());
				temp2.add(textField_10.getText());
				temp2.add(textField_11.getText());
				tempPayer = textField_12.getText().toLowerCase();
				company.customerInfo(temp1, temp2, tempPayer);
				company.addCargo();
				btnAccepr.setEnabled(false);
				main(null);
			}
		});
		btnAccepr.setBounds(309, 200, 89, 23);
		frame.getContentPane().add(btnAccepr);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main(null);
			}
		});
		btnCancel.setBounds(98, 125, 89, 23);
		frame.getContentPane().add(btnCancel);
		btnCancel.setVisible(false);
		
		JButton btnAcceptPrice = new JButton("ACCEPT");
		btnAcceptPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_4.setVisible(true);
				textField_5.setVisible(true);
				textField_6.setVisible(true);
				textField_7.setVisible(true);
				textField_8.setVisible(true);
				textField_9.setVisible(true);
				textField_10.setVisible(true);
				textField_11.setVisible(true);
				textField_12.setVisible(true);
				lblSenderInfo.setVisible(true);
				lblReceiverInfo.setVisible(true);
				lblPayer.setVisible(true);
				lblNationalId.setVisible(true);
				lblNewLabel.setVisible(true);
				lblAddress.setVisible(true);
				lblPhoneNumber.setVisible(true);
				label_1.setVisible(true);
				label_2.setVisible(true);
				label_3.setVisible(true);
				label_4.setVisible(true);
				btnAccepr.setVisible(true);
				btnAcceptPrice.setEnabled(false);
				btnCancel.setEnabled(false);
			}
		});
		btnAcceptPrice.setBounds(10, 125, 86, 23);
		frame.getContentPane().add(btnAcceptPrice);
		btnAcceptPrice.setVisible(false);
		
		JButton btnNewButton = new JButton("ACCEPT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp.add(textField.getText());
				temp.add(textField_1.getText());
				temp.add(textField_2.getText().toUpperCase());
				try {
					flag = company.inputCheck(temp);
					if(flag == true){
						showLabel(lblYourCargoIs);
						textField_3.setText(company.getCargoPrice());
						textField_3.setVisible(true);
						btnAcceptPrice.setVisible(true);
						btnCancel.setVisible(true);
						btnNewButton.setEnabled(false);
					}
					else{
						showLabel(lblYourCargoIs_1);
						main(null);
					}
				} catch (ParseException e1) {
				}
				
				
			}
		});
		btnNewButton.setBounds(322, 10, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblWeight = new JLabel("WEIGHT");
		lblWeight.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblWeight.setBounds(10, 30, 86, 14);
		frame.getContentPane().add(lblWeight);
		
		JLabel lblCurrentDate = new JLabel("CURRENT DATE");
		lblCurrentDate.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblCurrentDate.setBounds(116, 30, 86, 14);
		frame.getContentPane().add(lblCurrentDate);
		
		JLabel lblTransportation = new JLabel("TRANSPORTATION");
		lblTransportation.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblTransportation.setBounds(221, 30, 95, 14);
		frame.getContentPane().add(lblTransportation);
		
		JLabel lblMhendislerTaimacilik = new JLabel("M\u00FChendisler \u00E7eker y\u00FCk\u00FC...");
		lblMhendislerTaimacilik.setForeground(Color.BLUE);
		lblMhendislerTaimacilik.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblMhendislerTaimacilik.setBounds(185, 42, 249, 117);
		frame.getContentPane().add(lblMhendislerTaimacilik);
	}
}
