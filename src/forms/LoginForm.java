package forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import models.Employee;
import models.UserRole;
import services.EmployeeServices;
import services.LoginServices;
import util.login.CurrentLogginUser;

import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LoginForm {

	public JFrame loginFrame;
	private JTextField textFieldUsername;
	private JPasswordField passwordFieldPw;
	private JButton btnLogin;
	private Employee employee;
	private EmployeeServices employeeServices;
	private LoginServices loginServices;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm window = new LoginForm();
					window.loginFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginForm() {
		initialize();
		initializeDepen();
	}

	public LoginForm(Employee employee) {
		this.employee = employee;
		initializeDepen();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeDepen() {
		this.employeeServices = new EmployeeServices();
		this.loginServices = new LoginServices();
	}

	private void initialize() {
		loginFrame = new JFrame();
		loginFrame.setBounds(100, 100, 450, 300);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.getContentPane().setLayout(null);

		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("MS UI Gothic", Font.BOLD, 18));
		lblWelcome.setBounds(172, 10, 91, 28);
		loginFrame.getContentPane().add(lblWelcome);

		JLabel lblUsername = new JLabel("User Name");
		lblUsername.setBounds(94, 85, 72, 13);
		loginFrame.getContentPane().add(lblUsername);

		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(190, 82, 143, 19);
		loginFrame.getContentPane().add(textFieldUsername);
		textFieldUsername.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(95, 137, 71, 13);
		loginFrame.getContentPane().add(lblPassword);

		passwordFieldPw = new JPasswordField();
		passwordFieldPw.setBounds(190, 134, 143, 19);
		loginFrame.getContentPane().add(passwordFieldPw);

		btnLogin = new JButton(employee != null ? "Create Account" : "Login");
		btnLogin.setBounds(155, 191, 91, 21);
		loginFrame.getContentPane().add(btnLogin);

		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (employee != null) {

					employee.setPassword(String.valueOf(passwordFieldPw.getPassword()));
					employee.setUsername(textFieldUsername.getText());
					System.out.println(employee.getPassword());

					if (!employee.getPassword().isBlank() && !employee.getUsername().isBlank()) {
						employeeServices.updateEmployee(String.valueOf(employee.getEmp_id()), employee);
						JOptionPane.showMessageDialog(null, "Success");
						EmployeeForm employeeForm = new EmployeeForm();
						employeeForm.employeeFrame.setVisible(true);
						loginFrame.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "Input all Fields!");
					}
				} else {
					employee = new Employee();
					String username = textFieldUsername.getText();
					String password = String.valueOf(passwordFieldPw.getPassword());

					if (!username.isBlank() && !password.isBlank()) {
						employee = loginServices.login(username, password);
						if (employee != null) {
							CurrentLogginUser.setCurrentUser(employee);
							AdminForm adminForm=new AdminForm();
							EmployeeForm employeeForm = new EmployeeForm();
							if(employee.getRole().equals(UserRole.ADMIN) ) {
								adminForm.adminFrame.setVisible(true);
								loginFrame.setVisible(false);
							}else {
								employeeForm.employeeFrame.setVisible(true);
								loginFrame.setVisible(false);
							}
						}
					}
				}
			}
		});
	}
}
