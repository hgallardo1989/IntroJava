package py.edu.uaa.finalTrabajo.graficos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import py.edu.uaa.finalTrabajo.Practica;
import py.edu.uaa.finalTrabajo.conexiones.Conexion;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JFrame {

	private JPanel contentPane;
	
	 Practica ctr = new Practica();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBorder(null);
		desktopPane.setBackground(Color.LIGHT_GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(desktopPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(desktopPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
		);
		
		JButton btnAlumno = new JButton("Alta Alumno");
		btnAlumno.setBackground(SystemColor.inactiveCaption);
		btnAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Principal frm =new Principal();
				frm.setVisible(true);
			}
		});
		btnAlumno.setBounds(57, 130, 131, 64);
		desktopPane.add(btnAlumno);
		
		JButton btnMateria = new JButton("Materia");
		btnMateria.setBackground(SystemColor.inactiveCaption);
		btnMateria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GraficoMateria frm =new GraficoMateria();
				frm.setVisible(true);
			}
		});
		btnMateria.setBounds(169, 256, 131, 64);
		desktopPane.add(btnMateria);
		
		JButton btnNewButton_2 = new JButton("AlumnoCurso");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				GraficoAlumnoMateria frm =new GraficoAlumnoMateria();
				frm.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(SystemColor.inactiveCaption);
		btnNewButton_2.setBounds(379, 256, 131, 64);
		desktopPane.add(btnNewButton_2);
		
		JButton btnPractica = new JButton("Registrar Practica");
		btnPractica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				
				GraficoPractica frm =new GraficoPractica();
				frm.setVisible(true);
			}
		});
		btnPractica.setBackground(SystemColor.inactiveCaption);
		btnPractica.setBounds(492, 130, 131, 64);
		desktopPane.add(btnPractica);
		
		JLabel lblNewLabel = new JLabel("UNIVERSIDAD AUTONOMA DE ASUNCION");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(185, 29, 402, 24);
		desktopPane.add(lblNewLabel);
		
		JLabel lblRegistroDePracticas = new JLabel("SISTEMA DE REGISTRO");
		lblRegistroDePracticas.setForeground(Color.RED);
		lblRegistroDePracticas.setBackground(Color.WHITE);
		lblRegistroDePracticas.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblRegistroDePracticas.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroDePracticas.setBounds(257, 64, 193, 14);
		desktopPane.add(lblRegistroDePracticas);
		
		JLabel lblDe = new JLabel("DE PRACTICAS ASISTIDAS");
		lblDe.setForeground(Color.RED);
		lblDe.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblDe.setBounds(246, 89, 219, 14);
		desktopPane.add(lblDe);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\user\\workspace\\TrabajoFinal\\Recursos\\10917866_872717549418004_4950339618677506114_n.jpg"));
		lblNewLabel_1.setBounds(256, 114, 160, 131);
		desktopPane.add(lblNewLabel_1);
		contentPane.setLayout(gl_contentPane);
		
		

	}
}
