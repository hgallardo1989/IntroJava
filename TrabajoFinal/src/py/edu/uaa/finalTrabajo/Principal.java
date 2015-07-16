package py.edu.uaa.finalTrabajo;

import py.edu.uaa.finalTrabajo.Alumno;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField txtnrocedula;
	private JTextField txtnombreApellido;
	private JTextField txtemail;
	private JTextField txtnroCelular;
	private JButton btnAdd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnAdd = new JButton("ADD");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			try{
				Alumno alumno = new Alumno();
				
				String nroCedula = txtnrocedula.getText();
				
				alumno.setNroCedula(Integer.valueOf(nroCedula));
				
				alumno.setNombreApellido(txtnombreApellido.getText());
				
				alumno.setEmail(txtemail.getText());
				
				alumno.setNroCelular(txtnroCelular.getText());

				Conexion conexion = new Conexion();
				Boolean isInserted = conexion.insertarAlumno(alumno);
				if (isInserted){
					JOptionPane.showMessageDialog(null, "Alumno insertado correctamente", "", JOptionPane.INFORMATION_MESSAGE);

				}else{
					JOptionPane.showMessageDialog(null, "No se pudo insertar el registro del alumno", null, JOptionPane.ERROR_MESSAGE, null);
				}
			}catch (SQLException e1) {
		 
					System.out.println(e1.getMessage());
		 
				}
			}	
		});
		
		JButton btnDel = new JButton("DEL");
		
		JButton btnUpdate = new JButton("UPDATE");
		
		JLabel lblNroCedula = new JLabel("Nro. Cedula");
		
		JLabel lblNewLabel = new JLabel("Nombre y Apelido");
		
		JLabel lblEmail = new JLabel("Email");
		
		JLabel lblCelular = new JLabel("Celular");
		
		txtnrocedula = new JTextField();
		txtnrocedula.setColumns(10);
		
		txtnombreApellido = new JTextField();
		txtnombreApellido.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		
		txtnroCelular = new JTextField();
		txtnroCelular.setColumns(10);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNroCedula)
								.addComponent(lblNewLabel)
								.addComponent(lblEmail)
								.addComponent(lblCelular))
							.addGap(71)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtnrocedula, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
								.addComponent(txtnombreApellido)
								.addComponent(txtemail)
								.addComponent(txtnroCelular)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(67)
							.addComponent(btnAdd)
							.addGap(28)
							.addComponent(btnDel)
							.addGap(29)
							.addComponent(btnUpdate)))
					.addContainerGap(65, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNroCedula)
						.addComponent(txtnrocedula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtnombreApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(txtemail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCelular)
						.addComponent(txtnroCelular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnUpdate)
						.addComponent(btnDel)
						.addComponent(btnAdd))
					.addGap(25))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
