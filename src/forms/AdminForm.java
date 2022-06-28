package forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AdminForm {

	public JFrame adminFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminForm window = new AdminForm();
					window.adminFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		adminFrame = new JFrame();
		adminFrame.setBounds(100, 100, 800, 600);
		adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		adminFrame.getContentPane().setLayout(null);
		
		JLabel lblAdmin = new JLabel("Admin Form");
		lblAdmin.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 18));
		lblAdmin.setBounds(288, 10, 127, 40);
		adminFrame.getContentPane().add(lblAdmin);
		
		JButton btnEmployee = new JButton("Employee List");
		btnEmployee.setBounds(60, 86, 146, 74);
		adminFrame.getContentPane().add(btnEmployee);
		
		JButton btnProduct = new JButton("Product List");
		btnProduct.setBounds(269, 86, 146, 74);
		adminFrame.getContentPane().add(btnProduct);
		
		JButton btnBrand = new JButton("Brand List");
		btnBrand.setBounds(467, 86, 146, 74);
		adminFrame.getContentPane().add(btnBrand);
		
		JButton btnCategory = new JButton("Category List");
		btnCategory.setBounds(60, 245, 146, 74);
		adminFrame.getContentPane().add(btnCategory);
		
		JButton btnSupplier = new JButton("Supplier List");
		btnSupplier.setBounds(269, 245, 146, 74);
		adminFrame.getContentPane().add(btnSupplier);
		
		btnEmployee.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				EmployeeForm employeeForm=new EmployeeForm();
				employeeForm.employeeFrame.setVisible(true);
				adminFrame.setVisible(false);
			}
		});
	}
}
