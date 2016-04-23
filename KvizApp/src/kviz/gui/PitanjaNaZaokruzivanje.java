package kviz.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kviz.logika.ZaokruzivanjeLogika;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PitanjaNaZaokruzivanje extends JFrame {

	private JPanel contentPane;
	private JButton btnA;
	private JTextArea jtaA;
	private JTextArea jtaB;
	private JButton btnB;
	private JTextArea jtaC;
	private JButton btnC;
	private JTextArea jtaD;
	private JButton btnD;
	private JTextArea jtaPitanje;
	private JLabel lblBrPitanja;
	private int brojTacnih = 0;
	private int brojac = 1;
	private JLabel lblBrPoena;
//	private String[] pocetnaPitanja;
//	private String[] pocetniOdgovori;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PitanjaNaZaokruzivanje frame = new PitanjaNaZaokruzivanje();
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
	public PitanjaNaZaokruzivanje() {
		setTitle("Kviz");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnA());
		contentPane.add(getJtaA());
		contentPane.add(getJtaB());
		contentPane.add(getBtnB());
		contentPane.add(getJtaC());
		contentPane.add(getBtnC());
		contentPane.add(getJtaD());
		contentPane.add(getBtnD());
		contentPane.add(getJtaPitanje());
		contentPane.add(getLblBrPitanja());
		contentPane.add(getLblBrPoena());
	}
	public JButton getBtnA() {
		if (btnA == null) {
			btnA = new JButton("A");
			btnA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(brojac<15){
					if(jtaA.getText().equals(GUIKontroler.vratiTacan())){
						brojTacnih++;
						lblBrPoena.setText("Broj tacnih: " +brojTacnih);
					}
					
					brojac++;
					GUIKontroler.resetujPitanja();
				}else{
					JOptionPane.showMessageDialog(null, "Uspesno ste zavrsili igru.Broj poena koje"
							+ " ste osvojili je: " +brojTacnih , "Izvestaj", JOptionPane.INFORMATION_MESSAGE);
					GUIKontroler.zatvoriZaokruzivanjeProzor();
				}
				}
			});
			btnA.setBounds(10, 155, 46, 30);
		}
		return btnA;
	}
	public JTextArea getJtaA() {
		if (jtaA == null) {
			jtaA = new JTextArea();
			jtaA.setEditable(false);
			jtaA.setBounds(77, 155, 160, 30);
//			jtaA.setText(pocetniOdgovori[0]);
		}
		return jtaA;
	}
	public JTextArea getJtaB() {
		if (jtaB == null) {
			jtaB = new JTextArea();
			jtaB.setEditable(false);
			jtaB.setBounds(327, 155, 160, 30);
		}
		return jtaB;
	}
	public JButton getBtnB() {
		if (btnB == null) {
			btnB = new JButton("B");
			btnB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(brojac<15){
					if(jtaB.getText().equals(GUIKontroler.vratiTacan())){
						brojTacnih++;
						lblBrPoena.setText("Broj tacnih: " +brojTacnih);
					}
					
					brojac++;
					GUIKontroler.resetujPitanja();
				}else{
					JOptionPane.showMessageDialog(null, "Uspesno ste zavrsili igru.Broj poena koje"
							+ " ste osvojili je: " +brojTacnih , "Izvestaj", JOptionPane.INFORMATION_MESSAGE);
					GUIKontroler.zatvoriZaokruzivanjeProzor();
				}
				}
				
			});
			btnB.setBounds(266, 155, 46, 30);
		}
		return btnB;
	}
	public JTextArea getJtaC() {
		if (jtaC == null) {
			jtaC = new JTextArea();
			jtaC.setEditable(false);
			jtaC.setBounds(77, 215, 160, 30);
		}
		return jtaC;
	}
	public JButton getBtnC() {
		if (btnC == null) {
			btnC = new JButton("C");
			btnC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(brojac<15){
					if(jtaC.getText().equals(GUIKontroler.vratiTacan())){
						brojTacnih++;
						lblBrPoena.setText("Broj tacnih: " +brojTacnih);
					}
					
					brojac++;
					GUIKontroler.resetujPitanja();
				}else{
					JOptionPane.showMessageDialog(null, "Uspesno ste zavrsili igru.Broj poena koje"
							+ " ste osvojili je: " +brojTacnih , "Izvestaj", JOptionPane.INFORMATION_MESSAGE);
					GUIKontroler.zatvoriZaokruzivanjeProzor();
				}
				}
			});
			btnC.setBounds(10, 215, 46, 30);
		}
		return btnC;
	}
	public JTextArea getJtaD() {
		if (jtaD == null) {
			jtaD = new JTextArea();
			jtaD.setEditable(false);
			jtaD.setBounds(327, 215, 160, 30);
		}
		return jtaD;
	}
	public JButton getBtnD() {
		if (btnD == null) {
			btnD = new JButton("D");
			btnD.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(brojac<15){
					if(jtaD.getText().equals(GUIKontroler.vratiTacan())){
						brojTacnih++;
						lblBrPoena.setText("Broj tacnih: " +brojTacnih);
					}
					
					brojac++;
					GUIKontroler.resetujPitanja();
				}else{
					JOptionPane.showMessageDialog(null, "Uspesno ste zavrsili igru.Broj poena koje"
							+ " ste osvojili je: " +brojTacnih , "Izvestaj", JOptionPane.INFORMATION_MESSAGE);
					GUIKontroler.zatvoriZaokruzivanjeProzor();
				}
				}
			});
			btnD.setBounds(266, 215, 46, 30);
		}
		return btnD;
	}
	public JTextArea getJtaPitanje() {
		if (jtaPitanje == null) {
			jtaPitanje = new JTextArea();
			jtaPitanje.setEditable(false);
			jtaPitanje.setBounds(51, 65, 381, 57);
			
		}
		return jtaPitanje;
	}
	public JLabel getLblBrPitanja() {
		if (lblBrPitanja == null) {
			lblBrPitanja = new JLabel("Pitanje broj:1");
			lblBrPitanja.setBounds(209, 11, 103, 14);
		}
		return lblBrPitanja;
	}
	public JLabel getLblBrPoena() {
		if (lblBrPoena == null) {
			lblBrPoena = new JLabel("Broj tacnih: 0");
			lblBrPoena.setBounds(209, 36, 102, 14);
		}
		return lblBrPoena;
	}
}
