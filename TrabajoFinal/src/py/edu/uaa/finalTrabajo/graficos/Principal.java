package py.edu.uaa.finalTrabajo.graficos;

import py.edu.uaa.finalTrabajo.Alumno;
import py.edu.uaa.finalTrabajo.conexiones.Conexion;

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
import java.sql.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.*;
import javax.swing.ImageIcon;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField txtnrocedula;
	private JTextField txtnombreApellido;
	private JTextField txtemail;
	private JTextField txtnroCelular;
	private JButton btnAdd;
	private JLabel lblNewLabel_1;

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
		setForeground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\workspace\\TrabajoFinal\\Recursos\\logo-uaa2015.jpg"));
		setBounds(100, 100, 501, 419);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnAdd = new JButton("AGREGAR");
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
					
					txtnrocedula.setText(null);
					txtnombreApellido.setText(null);
					txtemail.setText(null);
					txtnroCelular.setText(null);

				}else{
					JOptionPane.showMessageDialog(null, "No se pudo insertar el registro del alumno", null, JOptionPane.ERROR_MESSAGE, null);
					
					
					
				}
			}catch (SQLException e1) {
		 
					System.out.println(e1.getMessage());
		 
				}
			}	
		});
		
		JButton btnDel = new JButton("LIMPIAR CAMPOS");
		btnDel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				txtnrocedula.setText(null);
				txtnombreApellido.setText(null);
				txtemail.setText(null);
				txtnroCelular.setText(null);
			}
		});
		
		
		JLabel lblNroCedula = new JLabel("Nro. Cedula");
		lblNroCedula.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
		JLabel lblNewLabel = new JLabel("Nombre y Apelido");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
		// Solo permite ingresar numeros
		txtnrocedula = new JTextField();
		txtnrocedula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if((c<'0' || c> '9') && (c!=(char)KeyEvent.VK_BACK_SPACE)){ e.consume();
				JOptionPane.showMessageDialog(null, "Solo se admite numero", "Validar texto"
						,JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		txtnrocedula.setColumns(10);
		
		// Solo permite ingresar Letras
		txtnombreApellido = new JTextField();
		txtnombreApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ev) {
				char c = ev.getKeyChar();
				if ((c <'a' | (c > 'z') && (c<'A')|c>'Z') && (c!=(char) KeyEvent.VK_BACK_SPACE) && (c!=(char) KeyEvent.VK_SPACE)){ ev.consume();
				JOptionPane.showMessageDialog(null, "Solo se admite texto", "Validar texto"
						,JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		txtnombreApellido.setColumns(10);
		
		//ValidaEmail es la clase que valida el formato de un mail
		txtemail = new JTextField();
		ValidarEmail ve = new ValidarEmail();
		txtemail.setInputVerifier(ve);
		txtemail.setColumns(10);
		
		// Solo permite ingresar numeros
		txtnroCelular = new JTextField();
		txtnroCelular.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				char c = arg0.getKeyChar();
				if((c<'0' || c> '9') && (c!=(char)KeyEvent.VK_BACK_SPACE)){ arg0.consume();
				JOptionPane.showMessageDialog(null, "Solo se admite numero", "Validar texto"
						,JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		txtnroCelular.setColumns(10);
		
		JLabel lblFormularioDeRegistro = new JLabel("FORMULARIO DE REGISTRO DE ALUMNO");
		lblFormularioDeRegistro.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\user\\workspace\\TrabajoFinal\\Recursos\\634.jpg"));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(96)
							.addComponent(lblFormularioDeRegistro))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNroCedula)
							.addGap(108)
							.addComponent(txtnrocedula, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel)
							.addGap(71)
							.addComponent(txtnombreApellido, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(lblEmail)
							.addGap(147)
							.addComponent(txtemail, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(lblCelular)
							.addGap(136)
							.addComponent(txtnroCelular, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(92, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDel, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1)
					.addGap(43))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblFormularioDeRegistro)
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNroCedula)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(txtnrocedula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(txtnombreApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEmail)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(txtemail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCelular)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(txtnroCelular, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(btnDel, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 139, Short.MAX_VALUE)
							.addContainerGap())))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
