package kviz.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class GlavniProzor extends JFrame {

	private JPanel contentPane;
	private JButton btnPitanjaSaPonudjenim;
	private JButton btnPitanjaNaDopunu;
	private JButton btnPitanjaLicitacija;
	private JLabel lblIzaberiteKviz;
	private JLabel lblSlika;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GlavniProzor frame = new GlavniProzor();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public GlavniProzor() {
		setResizable(false);
		setTitle("Kviz");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnPitanjaSaPonudjenim());
		contentPane.add(getBtnPitanjaNaDopunu());
		contentPane.add(getBtnPitanjaLicitacija());
		contentPane.add(getLblIzaberiteKviz());
		contentPane.add(getLblSlika());
		setLocationRelativeTo(null);
	}
	private JButton getBtnPitanjaSaPonudjenim() {
		if (btnPitanjaSaPonudjenim == null) {
			btnPitanjaSaPonudjenim = new JButton("Pitanja sa ponudjenim odgovorima");
			btnPitanjaSaPonudjenim.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.pokreniProzorZaokruzivanje();
					
				}
			});
			btnPitanjaSaPonudjenim.setBounds(71, 181, 293, 23);
		}
		return btnPitanjaSaPonudjenim;
	}
	private JButton getBtnPitanjaNaDopunu() {
		if (btnPitanjaNaDopunu == null) {
			btnPitanjaNaDopunu = new JButton("Pitanja na dopunu");
			btnPitanjaNaDopunu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.pokreniProzorDopunska();
				}
			});
			btnPitanjaNaDopunu.setBounds(70, 218, 294, 23);
		}
		return btnPitanjaNaDopunu;
	}
	private JButton getBtnPitanjaLicitacija() {
		if (btnPitanjaLicitacija == null) {
			btnPitanjaLicitacija = new JButton("Pitanja - licitacija");
			btnPitanjaLicitacija.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.pokreniProzorLicitacije();
				}
			});
			btnPitanjaLicitacija.setBounds(70, 256, 294, 23);
		}
		return btnPitanjaLicitacija;
	}
	private JLabel getLblIzaberiteKviz() {
		if (lblIzaberiteKviz == null) {
			lblIzaberiteKviz = new JLabel("Izaberite kviz :");
			lblIzaberiteKviz.setHorizontalAlignment(SwingConstants.CENTER);
			lblIzaberiteKviz.setFont(new Font("Tahoma", Font.BOLD, 22));
			lblIzaberiteKviz.setBounds(71, 27, 293, 29);
		}
		return lblIzaberiteKviz;
	}
	private JLabel getLblSlika() {
		if (lblSlika == null) {
			lblSlika = new JLabel("");
			lblSlika.setHorizontalAlignment(SwingConstants.CENTER);
			lblSlika.setIcon(new ImageIcon(GlavniProzor.class.getResource("/ikonice/kvizlogo1.png")));
			lblSlika.setBounds(71, 53, 294, 109);
		}
		return lblSlika;
	}
}
