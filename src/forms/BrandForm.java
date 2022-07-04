package forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class BrandForm {

	private JFrame brandFrame;
	private JTable tblBrand;
	private DefaultTableModel dtm = new DefaultTableModel();
	private JTextField textFieldSearch;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BrandForm window = new BrandForm();
					window.brandFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BrandForm() {
		initialize();
		setTableDesign();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void setTableDesign() {
		dtm.addColumn("ID");
		dtm.addColumn("Name");
		this.tblBrand.setModel(dtm);
	}
	private void initialize() {
		brandFrame = new JFrame();
		brandFrame.setBounds(100, 100, 800, 600);
		brandFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		brandFrame.getContentPane().setLayout(null);
		
		JLabel lblBrand = new JLabel("Brand Form");
		lblBrand.setFont(new Font("MS UI Gothic", Font.BOLD, 18));
		lblBrand.setBounds(324, 10, 109, 43);
		brandFrame.getContentPane().add(lblBrand);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 63, 318, 408);
		brandFrame.getContentPane().add(scrollPane);

		tblBrand = new JTable();
		tblBrand.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(tblBrand);
		
		JButton btnSearch = new JButton("search");
		btnSearch.setBounds(570, 62, 124, 21);
		brandFrame.getContentPane().add(btnSearch);
		
		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(405, 63, 124, 19);
		brandFrame.getContentPane().add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(405, 342, 91, 21);
		brandFrame.getContentPane().add(btnSave);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(570, 342, 91, 21);
		brandFrame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(405, 450, 91, 21);
		brandFrame.getContentPane().add(btnDelete);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(570, 450, 91, 21);
		brandFrame.getContentPane().add(btnBack);
		
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AdminForm adminForm=new AdminForm();
				adminForm.adminFrame.setVisible(true);
				brandFrame.setVisible(false);
			}
		});
	}
}
