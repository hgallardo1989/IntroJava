package py.edu.uaa.finalTrabajo;

import py.edu.uaa.finalTrabajo.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnAdd = new JButton("ADD");
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

					}else{
						JOptionPane.showMessageDialog(null, "No se pudo insertar el registro de la materia", null, JOptionPane.ERROR_MESSAGE, null);
					}
				}catch (SQLException e1) {
			 
						System.out.println(e1.getMessage());
			 
					}
			}
		});
		
		
		JButton btnDel = new JButton("DEL");
		
		JButton btnUpdate = new JButton("UPDATE");
		
		JLabel lblNewLabel = new JLabel("Codigo de Materia");
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de la Materia");
		
		txtcodigoMateria = new JTextField();
		txtcodigoMateria.setColumns(10);
		
		txtnombreMateria = new JTextField();
		txtnombreMateria.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(71)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(txtnombreMateria, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
								.addComponent(txtcodigoMateria, GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(36)
							.addComponent(btnDel)
							.addGap(50)
							.addComponent(btnUpdate)))
					.addGap(94))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(62)
					.addComponent(btnAdd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(292))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtcodigoMateria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(txtnombreMateria, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(55)
					.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDel)
						.addComponent(btnUpdate))
					.addGap(40))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
