 /*
 * 
 * @author OðuzGül-BuðrahanDönmez , 220201015-220201053
 * 
 */
package Presentation;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import Domain.AllHouses;
import Domain.House;
import Domain.SearchType;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
public class SwingGUI {
	private JFrame frame;
	private static JTable table_1;
	private JTextField txtMin;
	private JTextField txtMax;
	private JTextField txtMinSize;
	private JTextField txtMaxSize;
	private JRadioButton rdbtnNumberOfRooms;
	private JRadioButton rdbtnSize;
	private JRadioButton rdbtnPrice;
	private JSpinner spinner;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;

	/**
	 * Launch the application.
	 */
	public static void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingGUI window = new SwingGUI();
					window.frame.setVisible(true);
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

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("serial")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		rdbtnNewRadioButton = new JRadioButton("Ascending");
		rdbtnNewRadioButton.setBounds(301, 11, 103, 23);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnNewRadioButton_1.setSelected(false);
			}
		});
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("Descending");
		rdbtnNewRadioButton_1.setBounds(405, 11, 109, 23);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnNewRadioButton.setSelected(false);
			}
		});
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		
		JButton btnOrderHouses = new JButton("Order Houses");
		btnOrderHouses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnNewRadioButton.isSelected()){
					DefaultTableModel ascOrd = new DefaultTableModel(AllHouses.getHouses(AllHouses.ascendingOrder()),new String[] {
							"ID", "Price", "Size", "#Numbers", "#Bathrooms", "AirCond"});
					table_1.setModel(ascOrd);	
				}
				if(rdbtnNewRadioButton_1.isSelected()){
					DefaultTableModel ascOrd = new DefaultTableModel(AllHouses.getHouses(AllHouses.descendingOrder()),new String[] {
							"ID", "Price", "Size", "#Numbers", "#Bathrooms", "AirCond"});
					table_1.setModel(ascOrd);	
				}
			}
		});
		btnOrderHouses.setBounds(519, 11, 123, 23);
		frame.getContentPane().add(btnOrderHouses);
		

		
		JSeparator separator = new JSeparator();
		separator.setBounds(301, 49, 351, 2);
		frame.getContentPane().add(separator);
		
		JButton btnNewButton = new JButton("Add House");
		//opens another screen for add function
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddHouseGUI addHouseScreen = new AddHouseGUI();
				addHouseScreen.setVisible(addHouseScreen);
			}
		});
		btnNewButton.setBounds(305, 192, 171, 42);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remove House");
		// open another screen for remove function
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RemoveHouseGUI removeHouseScreen = new RemoveHouseGUI();
				removeHouseScreen.setVisible(removeHouseScreen);
			}
		});
		btnNewButton_1.setBounds(481, 192, 171, 42);
		frame.getContentPane().add(btnNewButton_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(305, 179, 347, 2);
		frame.getContentPane().add(separator_2);
		
		rdbtnPrice = new JRadioButton("Price");
		rdbtnPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rdbtnNumberOfRooms.setSelected(false);
				rdbtnSize.setSelected(false);
				txtMin.setEnabled(true);
				txtMax.setEnabled(true);
				spinner.setEnabled(false);
				txtMinSize.setEnabled(false);
				txtMaxSize.setEnabled(false);
				txtMinSize.setText("MIN");
				txtMaxSize.setText("MAX");
			}
		});
		rdbtnPrice.setBounds(301, 58, 87, 23);
		frame.getContentPane().add(rdbtnPrice);
		
		rdbtnNumberOfRooms = new JRadioButton("Number of Rooms");
		rdbtnNumberOfRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnPrice.setSelected(false);
				rdbtnSize.setSelected(false);
				txtMin.setEnabled(false);
				txtMax.setEnabled(false);
				spinner.setEnabled(true);
				txtMinSize.setEnabled(false);
				txtMaxSize.setEnabled(false);
				
			}
		});
		rdbtnNumberOfRooms.setBounds(403, 58, 111, 23);
		frame.getContentPane().add(rdbtnNumberOfRooms);
		
		rdbtnSize = new JRadioButton("Size");
		rdbtnSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnPrice.setSelected(false);
				rdbtnNumberOfRooms.setSelected(false);
				txtMin.setEnabled(false);
				txtMax.setEnabled(false);
				txtMin.setText("MIN");
				txtMax.setText("MAX");
				spinner.setEnabled(false);
				txtMinSize.setEnabled(true);
				txtMaxSize.setEnabled(true);
			}
		});
		rdbtnSize.setBounds(519, 58, 53, 23);
		frame.getContentPane().add(rdbtnSize);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 15, 285, 235);
		frame.getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			updateHouses(),
			new String[] {
				"ID", "Price", "Size", "#Numbers", "#Bathrooms", "AirCond"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table_1);
		
		txtMin = new JTextField();
		txtMin.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	txtMin.setText("");
            }
        });
		txtMin.setEnabled(false);
		txtMin.setText("MIN");
		txtMin.setBounds(302, 88, 86, 20);
		frame.getContentPane().add(txtMin);
		txtMin.setColumns(10);
		
		txtMax = new JTextField();
		txtMax.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	txtMax.setText("");
            }
        });
		txtMax.setEnabled(false);
		txtMax.setText("MAX");
		txtMax.setBounds(301, 119, 86, 20);
		frame.getContentPane().add(txtMax);
		txtMax.setColumns(10);
		
		txtMinSize = new JTextField();
		txtMinSize.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	txtMinSize.setText("");
            }
        });
		txtMinSize.setEnabled(false);
		txtMinSize.setText("MIN");
		txtMinSize.setBounds(519, 88, 86, 20);
		frame.getContentPane().add(txtMinSize);
		txtMinSize.setColumns(10);
		
		txtMaxSize = new JTextField();
		txtMaxSize.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
            	txtMaxSize.setText("");
            }
        });
		txtMaxSize.setEnabled(false);
		txtMaxSize.setText("MAX");
		txtMaxSize.setBounds(519, 119, 86, 20);
		frame.getContentPane().add(txtMaxSize);
		txtMaxSize.setColumns(10);
		
		spinner = new JSpinner();
		spinner.setEnabled(false);
		spinner.setBounds(405, 88, 104, 20);
		((SpinnerNumberModel) spinner.getModel()).setMinimum(0);
		frame.getContentPane().add(spinner);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnPrice.isSelected()){
					double removeMin = 0, removeMax = 0;
					boolean flag=true;
					while(flag || txtMin.getText()==null || txtMax.getText()==""){
						try{
							removeMin = Double.parseDouble(txtMin.getText());
							removeMax = Double.parseDouble(txtMax.getText());
							flag=false;
						}
						catch(ClassCastException e1)
						{
							JOptionPane.showMessageDialog(frame, "Given input is not valid. Try again.");
						}
					}
					changeLog(AllHouses.getHouses(AllHouses.searchHouse(removeMin, removeMax, SearchType.PRICE)));
				}
				else if(rdbtnNumberOfRooms.isSelected()){
					double removeMin, removeMax=0;
					removeMin = Double.parseDouble(spinner.getValue().toString());
					changeLog(AllHouses.getHouses(AllHouses.searchHouse(removeMin, removeMax, SearchType.NUMBEROFROOMS)));
				}
				else if(rdbtnSize.isSelected()){
					double removeMin = 0, removeMax = 0;
					boolean flag=true;
					while(flag){
						try{
							removeMin = Double.parseDouble(txtMinSize.getText());
							removeMax = Double.parseDouble(txtMaxSize.getText());
							flag=false;
						}
						catch(ClassCastException error)
						{
							JOptionPane.showMessageDialog(frame, "Given input is not valid. Try again.");
						}
					}
					changeLog(AllHouses.getHouses(AllHouses.searchHouse(removeMin, removeMax, SearchType.SIZE)));
				}
			}
		});
		btnSearch.setBounds(391, 145, 123, 23);
		frame.getContentPane().add(btnSearch);
		
		
		
	}
	public static Object[][] updateHouses(){
		return AllHouses.getHouses();
	}
	public static Object[][] updateHouses(double min, double max, SearchType type){
		return AllHouses.getHouses(AllHouses.searchHouse(min, max, type));
	}
	@SuppressWarnings("serial")
	public static void changeLog(){
		table_1.setModel(new DefaultTableModel(
				updateHouses(),
				new String[] {
					"ID", "Price", "Size", "#Numbers", "#Bathrooms", "AirCond"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
	}
	@SuppressWarnings("serial")
	public static void changeLog(Object[][] x){
		table_1.setModel(new DefaultTableModel(
				x,
				new String[] {
					"ID", "Price", "Size", "#Numbers", "#Bathrooms", "AirCond"
				}
			) {
				Class[] columnTypes = new Class[] {
					String.class, String.class, String.class, String.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
	}
}