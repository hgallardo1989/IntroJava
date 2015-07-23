package py.edu.uaa.finalTrabajo.graficos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;

import py.edu.uaa.finalTrabajo.AlumnoCurso;
import py.edu.uaa.finalTrabajo.conexiones.ConexionAlumnoCurso;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GraficoAlumnoMateria extends JFrame {

	private JPanel contentPane;
	private JTextField textnrocedula;
	private JTextField textcodmateria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraficoAlumnoMateria frame = new GraficoAlumnoMateria();
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
	public GraficoAlumnoMateria() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\workspace\\TrabajoFinal\\Recursos\\logo-uaa2015.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 409, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblFormularioDeRegistro = new JLabel("FORMULARIO DE REGISTRO ALUMNO/CURSO");
		lblFormularioDeRegistro.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		
		JLabel lblNroCedula = new JLabel("Nro. Cedula ");
		
		JLabel lblCodMateria = new JLabel("Cod. Materia");
		
		textnrocedula = new JTextField();
		textnrocedula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c = e.getKeyChar();
				if((c<'0' || c> '9') && (c!=(char)KeyEvent.VK_BACK_SPACE)){ e.consume();
				JOptionPane.showMessageDialog(null, "Solo se admite numero", "Validar texto"
						,JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		textnrocedula.setColumns(10);
		
		textcodmateria = new JTextField();
		textcodmateria.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if((c<'0' || c> '9') && (c!=(char)KeyEvent.VK_BACK_SPACE)){ e.consume();
				JOptionPane.showMessageDialog(null, "Solo se admite numero", "Validar texto"
						,JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		textcodmateria.setColumns(10);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					AlumnoCurso curso = new AlumnoCurso();
					
					String nroCedula = textnrocedula.getText();
					
					curso.setNroCedula(Integer.valueOf(nroCedula));
					
					String codmateria = textnrocedula.getText();
					
					curso.setCodMateria(Integer.valueOf(codmateria));

					ConexionAlumnoCurso conexioncurso = new ConexionAlumnoCurso();
					Boolean isInserted = conexioncurso.insertarAlumnoCurso(curso);
					if (isInserted){
						JOptionPane.showMessageDialog(null, "Se inserto correctamente", "", JOptionPane.INFORMATION_MESSAGE);
						textnrocedula.setText(null);
						textcodmateria.setText(null);
					}else{
						JOptionPane.showMessageDialog(null, "No se pudo insertar el registro del alumno y materia", null, JOptionPane.ERROR_MESSAGE, null);
					}
				}catch (SQLException e1) {
			 
						System.out.println(e1.getMessage());
			 
					}
			}
				
		});
		
		JButton btnLimpiarCampos = new JButton("LIMPIAR CAMPOS");
		btnLimpiarCampos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				textnrocedula.setText(null);
				textcodmateria.setText(null);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(103, Short.MAX_VALUE)
					.addComponent(lblFormularioDeRegistro)
					.addGap(100))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnAgregar)
							.addGap(84)
							.addComponent(btnLimpiarCampos))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNroCedula)
								.addComponent(lblCodMateria))
							.addGap(78)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textcodmateria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textnrocedula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(183, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblFormularioDeRegistro)
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNroCedula)
						.addComponent(textnrocedula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(52)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCodMateria)
						.addComponent(textcodmateria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(63)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAgregar)
						.addComponent(btnLimpiarCampos))
					.addContainerGap(73, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
