package py.edu.uaa.finalTrabajo.graficos;

import py.edu.uaa.finalTrabajo.*;
import py.edu.uaa.finalTrabajo.conexiones.ConexionMateria;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class GraficoMateria extends JFrame {

	private JPanel contentPane;
	private JTextField txtcodigoMateria;
	private JTextField txtnombreMateria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraficoMateria frame = new GraficoMateria();
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
	public GraficoMateria() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\workspace\\TrabajoFinal\\Recursos\\logo-uaa2015.jpg"));
		setBounds(100, 100, 509, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnAdd = new JButton("AGREGAR");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					Materia materia = new Materia();
					
					String codigoMateria = txtcodigoMateria.getText();
					
					materia.setCodigoMateria(Integer.valueOf(codigoMateria));
					
					materia.setNombreMateria(txtnombreMateria.getText());

					ConexionMateria conexionmateria = new ConexionMateria();
					Boolean isInserted = conexionmateria.insertarMateria(materia);
					if (isInserted){
						JOptionPane.showMessageDialog(null, "Materia insertada correctamente", "", JOptionPane.INFORMATION_MESSAGE);
						txtcodigoMateria.setText(null);
						txtnombreMateria.setText(null);

					}else{
						JOptionPane.showMessageDialog(null, "No se pudo insertar el registro de la materia", null, JOptionPane.ERROR_MESSAGE, null);
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
				txtcodigoMateria.setText(null);
				txtnombreMateria.setText(null);
			}
		});
		
		JLabel lblNewLabel = new JLabel("Codigo de Materia");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de la Materia");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		
		// Solo permite ingresar numeros
		txtcodigoMateria = new JTextField();
		txtcodigoMateria.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if((c<'0' || c> '9') && (c!=(char)KeyEvent.VK_BACK_SPACE)){ arg0.consume();
				JOptionPane.showMessageDialog(null, "Solo se admite numero", "Validar texto"
						,JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		txtcodigoMateria.setColumns(10);
		
		
		// Solo permite ingresar Letras
		txtnombreMateria = new JTextField();
		txtnombreMateria.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if ((c <'a' | (c > 'z') && (c<'A')|c>'Z') && (c!=(char) KeyEvent.VK_BACK_SPACE) && (c!=(char) KeyEvent.VK_SPACE)){ e.consume();
				JOptionPane.showMessageDialog(null, "Solo se admite texto", "Validar texto"
						,JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		txtnombreMateria.setColumns(10);
		
		JLabel lblFormularioDeRegistro = new JLabel("FORMULARIO DE REGISTRO DE MATERIA");
		lblFormularioDeRegistro.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblFormularioDeRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1))
					.addGap(71)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtcodigoMateria)
						.addComponent(txtnombreMateria, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(67)
					.addComponent(lblFormularioDeRegistro)
					.addContainerGap(110, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(95)
					.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addComponent(btnDel)
					.addGap(114))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblFormularioDeRegistro)
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtcodigoMateria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(txtnombreMateria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnAdd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnDel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addGap(71))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	
}
