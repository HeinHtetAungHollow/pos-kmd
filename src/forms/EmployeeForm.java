package forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

import models.Employee;
import services.EmployeeServices;

import javax.swing.JTextArea;
import javax.swing.JButton;

public class EmployeeForm {

	public JFrame employeeFrame;
	private JTextField textFieldName;
	private JTextField textFieldPhone;
	private JTextField textFieldEmail;
	private JTextField textFieldRole;
	private JTextArea textAreaAddress;
	private JTable tblEmployee;
	private DefaultTableModel dtm = new DefaultTableModel();
	private EmployeeServices employeeServices;
	private List<Employee> empList = new ArrayList<>();
	private Employee employee;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeForm window = new EmployeeForm();
					window.employeeFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EmployeeForm() {
		initialize();
		initializeDependency();
		setTableDesign();
		loadEmp(Optional.empty());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeDependency() {
		this.employeeServices = new EmployeeServices();
	}

	private void setTableDesign() {
		dtm.addColumn("ID");
		dtm.addColumn("Name");
		dtm.addColumn("Phone");
		dtm.addColumn("Email");
		dtm.addColumn("Address");
		dtm.addColumn("Username");
		dtm.addColumn("Status");
		this.tblEmployee.setModel(dtm);
	}

	public void resetForm() {
		textFieldName.setText("");
		textFieldEmail.setText("");
		textFieldPhone.setText("");
		textFieldRole.setText("");
		textAreaAddress.setText("");
	}

	private void loadEmp(Optional<List<Employee>> optionalList) {
		this.dtm = (DefaultTableModel) this.tblEmployee.getModel();
        this.dtm.getDataVector().removeAllElements();
        this.dtm.fireTableDataChanged();
        
		empList = employeeServices.loadAllEmployees();

		List<Employee> filteredList = optionalList.orElseGet(() -> empList).stream().collect(Collectors.toList());

		filteredList.forEach(e -> {
			Object[] dataRow = new Object[7];
			dataRow[0] = e.getEmp_id();
			dataRow[1] = e.getEmp_name();
			dataRow[2] = e.getEmp_mail();
			dataRow[3] = e.getEmp_phone();
			dataRow[4] = e.getEmp_address();
			dataRow[5] = e.getUsername();
			dataRow[6] = e.getActive();
			dtm.addRow(dataRow);
		});
		this.tblEmployee.setModel(dtm);
	}

	private void initialize() {
		employeeFrame = new JFrame();
		employeeFrame.setBounds(100, 100, 800, 600);
		employeeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		employeeFrame.getContentPane().setLayout(null);

		JLabel lblEmployee = new JLabel("Employee Form");
		lblEmployee.setFont(new Font("MS UI Gothic", Font.BOLD, 16));
		lblEmployee.setBounds(369, 5, 134, 52);
		employeeFrame.getContentPane().add(lblEmployee);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(51, 66, 50, 20);
		employeeFrame.getContentPane().add(lblName);

		textFieldName = new JTextField();
		textFieldName.setBounds(128, 67, 155, 19);
		employeeFrame.getContentPane().add(textFieldName);
		textFieldName.setColumns(45);

		textFieldPhone = new JTextField();
		textFieldPhone.setColumns(45);
		textFieldPhone.setBounds(369, 67, 134, 19);
		employeeFrame.getContentPane().add(textFieldPhone);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(515, 72, 70, 13);
		employeeFrame.getContentPane().add(lblAddress);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(295, 70, 62, 13);
		employeeFrame.getContentPane().add(lblPhone);

		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(45);
		textFieldEmail.setBounds(128, 117, 155, 19);
		employeeFrame.getContentPane().add(textFieldEmail);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(51, 123, 50, 13);
		employeeFrame.getContentPane().add(lblEmail);

		textFieldRole = new JTextField();
		textFieldRole.setColumns(45);
		textFieldRole.setBounds(369, 117, 134, 19);
		employeeFrame.getContentPane().add(textFieldRole);

		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(295, 120, 50, 13);
		employeeFrame.getContentPane().add(lblRole);

		textAreaAddress = new JTextArea();
		textAreaAddress.setBounds(581, 65, 191, 73);
		employeeFrame.getContentPane().add(textAreaAddress);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 164, 721, 292);
		employeeFrame.getContentPane().add(scrollPane);

		tblEmployee = new JTable();
		tblEmployee.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(tblEmployee);

		JButton btnSave = new JButton("Save");
		btnSave.setBounds(49, 480, 91, 21);
		employeeFrame.getContentPane().add(btnSave);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(199, 480, 91, 21);
		employeeFrame.getContentPane().add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(342, 480, 91, 21);
		employeeFrame.getContentPane().add(btnDelete);

		JButton btnHome = new JButton("Home");
		btnHome.setBounds(681, 480, 91, 21);
		employeeFrame.getContentPane().add(btnHome);

		JButton btnAccount = new JButton("Create or edit Account");
		btnAccount.setBounds(477, 480, 176, 21);
		employeeFrame.getContentPane().add(btnAccount);
		
		btnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (employee!=null && employee.getEmp_id()!=0) {
					
					employee.setEmp_name(textFieldName.getText());
					employee.setEmp_mail(textFieldEmail.getText());
					employee.setEmp_phone(textFieldPhone.getText());
					employee.setEmp_address(textAreaAddress.getText());
					employee.setRole(textFieldRole.getText());
					
					if (!employee.getEmp_name().isBlank() && !employee.getEmp_mail().isBlank()
							&& !employee.getEmp_phone().isBlank() && !employee.getEmp_address().isBlank()
							&& !employee.getRole().isBlank()) {
						employeeServices.updateEmployee(String.valueOf(employee.getEmp_id()), employee);
						JOptionPane.showMessageDialog(btnUpdate, "Update Successful","Update Process",1);
						resetForm();
						loadEmp(Optional.empty());
					}else {
						JOptionPane.showMessageDialog(btnUpdate, "Input All Fields","Update Process",0);
					}
				}
			}
		});
		
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				employee = new Employee();
				
				if (!(textFieldName.getText().isBlank()) && !(textFieldEmail.getText().isBlank())
						&& !(textFieldPhone.getText().isBlank()) && !(textFieldRole.getText().isBlank())
						&& !(textAreaAddress.getText().isBlank())) {
					employee.setEmp_name(textFieldName.getText());
					employee.setEmp_address(textAreaAddress.getText());
					employee.setEmp_phone(textFieldPhone.getText());
					employee.setEmp_mail(textFieldEmail.getText());
					employee.setRole(textFieldRole.getText());
					employee.setActive(true);
					employeeServices.saveEmployee(employee);
					JOptionPane.showMessageDialog(btnSave, "Save Successful", "Save Process", 1);
					resetForm();
					loadEmp(Optional.empty());
				} else {
					JOptionPane.showMessageDialog(btnSave, "Save Fail, Please input all Fields", "Save Process", 0);
					resetForm();
				}
			}
		});
		this.tblEmployee.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
			if (!(tblEmployee.getSelectionModel().isSelectionEmpty())) {
				String id=tblEmployee.getValueAt(tblEmployee.getSelectedRow(), 0).toString();
				
				textAreaAddress.setText("");
				employee=this.employeeServices.findEmployeeById(id);
				
				textFieldName.setText(employee.getEmp_name());
				textFieldEmail.setText(employee.getEmp_mail());
				textFieldPhone.setText(employee.getEmp_phone());
				textFieldRole.setText(employee.getRole());
				textAreaAddress.append(employee.getEmp_address());
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (employee!=null && employee.getEmp_id()!=0) {
					employeeServices.deleteEmployee(String.valueOf(employee.getEmp_id()));
					JOptionPane.showMessageDialog(null,"Deleted","Delete Process",1);
					resetForm();
					loadEmp(Optional.empty());
				}else {
					JOptionPane.showMessageDialog(null,"Select Employee","Delete Process",0);
				}
			}
		});
		btnAccount.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (employee!=null) {
					LoginForm loginForm=new LoginForm(employee);
					loginForm.loginFrame.setVisible(true);
					employeeFrame.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "Select Employee");
				}
				
			}
		});
		btnHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AdminForm adminForm = new AdminForm();
				adminForm.adminFrame.setVisible(true);
				employeeFrame.setVisible(false);
			}
		});
	}
}
