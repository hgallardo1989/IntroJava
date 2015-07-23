package py.edu.uaa.finalTrabajo.graficos;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.text.SimpleDateFormat;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import javax.swing.SwingConstants;

import py.edu.uaa.finalTrabajo.Practica;
import py.edu.uaa.finalTrabajo.conexiones.ConexionPractica;


import java.awt.*;

public class GraficoPractica extends JFrame {
	
	public static String fechaActual() {
		Date fecha=new Date();
		SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MM/yyyy");
		
		return formatoFecha.format(fecha);
	}
	private JPanel contentPane;
	private JTextField textnrocedula;
	private JTextField textcodmateria;
	private JTextField textcantidadhoras;
	private JTextField textfecha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraficoPractica frame = new GraficoPractica();
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
	public GraficoPractica() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\user\\workspace\\TrabajoFinal\\Recursos\\logo-uaa2015.jpg"));
		setBounds(100, 100, 493, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Nro. Cedula");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblCodigoMateria = new JLabel("Codigo Materia");
		lblCodigoMateria.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblCodigoMateria.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblCantidadDeHoras = new JLabel("Cantidad de horas");
		lblCantidadDeHoras.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblCantidadDeHoras.setHorizontalAlignment(SwingConstants.CENTER);
		
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
		
		textcantidadhoras = new JTextField();
		textcantidadhoras.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c = e.getKeyChar();
				if((c<'0' || c> '9') && (c!=(char)KeyEvent.VK_BACK_SPACE)){ e.consume();
				JOptionPane.showMessageDialog(null, "Solo se admite numero", "Validar texto"
						,JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		textcantidadhoras.setColumns(10);
		
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					Practica practica = new Practica();
					
					String nroCedula = textnrocedula.getText();
					
					practica.setNroCedula(Integer.valueOf(nroCedula));
					
					String codmateria = textcodmateria.getText();
					
					practica.setCodigoMateria(Integer.valueOf(codmateria));
					
					practica.setFecha(textfecha.getText());
					
					String cantidadHoras = textcantidadhoras.getText();
					
					practica.setCantidadHoras(Integer.valueOf(cantidadHoras));

					ConexionPractica conexionpractica = new ConexionPractica();
					Boolean isInserted = conexionpractica.insertarPractica(practica);
					if (isInserted){
						JOptionPane.showMessageDialog(null, "Practica insertada correctamente", "", JOptionPane.INFORMATION_MESSAGE);
						textnrocedula.setText(null);
						textcodmateria.setText(null);
						textcantidadhoras.setText(null);
						textfecha.setText(null);
					}else{
						JOptionPane.showMessageDialog(null, "No se pudo insertar el registro de la materia", null, JOptionPane.ERROR_MESSAGE, null);
					}
				}catch (SQLException e1) {
			 
						System.out.println(e1.getMessage());
			 
					}
			}
		});
			

		
		JButton btnCancelar = new JButton("LIMPIAR CAMPOS");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				textnrocedula.setText(null);
				textcodmateria.setText(null);
				textcantidadhoras.setText(null);
				textfecha.setText(null);
			}
		});
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		textfecha = new JTextField(fechaActual());
		textfecha.setColumns(10);
		
		JLabel lblFormularioDeRegistro = new JLabel("FORMULARIO DE REGISTRO DE HORAS PRACTICAS");
		lblFormularioDeRegistro.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblFormularioDeRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnGuardar)
							.addGap(105)
							.addComponent(btnCancelar))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(52)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lblFormularioDeRegistro)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(lblNewLabel)
											.addComponent(lblCantidadDeHoras)
											.addComponent(lblCodigoMateria))
										.addGap(27)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(textcodmateria, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
											.addComponent(textnrocedula, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
											.addComponent(textcantidadhoras, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
											.addComponent(textfecha, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblFecha)
									.addPreferredGap(ComponentPlacement.RELATED, 492, GroupLayout.PREFERRED_SIZE)))))
					.addGap(93))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFormularioDeRegistro)
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(textnrocedula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(26)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCodigoMateria)
								.addComponent(textcodmateria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(27)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFecha)
								.addComponent(textfecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(28)
							.addComponent(lblCantidadDeHoras))
						.addComponent(textcantidadhoras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnGuardar))
					.addGap(32))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
}
