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
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

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
	private JLabel lblUnesiteIme;
	private JTextField jtfUnesiteIme;
	private JButton btnPotvrdiUnos;
	public String imeKorisnika;
	private JButton btn5050;
	private JMenuBar menuBar;
	private JMenu mnOIgri;
	private JMenuItem mntmPravilaIgre;
	private JMenuItem mntmAutorIgre;
	private JMenuItem mntmIzadji;
	private JButton btnZamena;
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
		setBounds(100, 100, 517, 425);
		setJMenuBar(getMenuBar_1());
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
		contentPane.add(getLblUnesiteIme());
		contentPane.add(getJtfUnesiteIme());
		contentPane.add(getBtnPotvrdiUnos());
		contentPane.add(getBtn5050());
		contentPane.add(getBtnZamena());
	}
	public JButton getBtnA() {
		if (btnA == null) {
			btnA = new JButton("A");
			btnA.setVisible(false);
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
					if(jtaA.getText().equals(GUIKontroler.vratiTacan())) brojTacnih++;
					JOptionPane.showMessageDialog(null, "Uspesno ste zavrsili igru.Broj poena koje"
							+ " ste osvojili je: " +brojTacnih , "Izvestaj", JOptionPane.INFORMATION_MESSAGE);
					GUIKontroler.zatvoriZaokruzivanjeProzor();
				}
				}
			});
			btnA.setBounds(10, 194, 46, 30);
		}
		return btnA;
	}
	public JTextArea getJtaA() {
		if (jtaA == null) {
			jtaA = new JTextArea();
			jtaA.setEditable(false);
			jtaA.setVisible(false);
			jtaA.setBounds(77, 194, 160, 30);
//			jtaA.setText(pocetniOdgovori[0]);
		}
		return jtaA;
	}
	public JTextArea getJtaB() {
		if (jtaB == null) {
			jtaB = new JTextArea();
			jtaB.setEditable(false);
			jtaB.setVisible(false);
			jtaB.setBounds(327, 194, 160, 30);
		}
		return jtaB;
	}
	public JButton getBtnB() {
		if (btnB == null) {
			btnB = new JButton("B");
			btnB.setVisible(false);
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
			btnB.setBounds(266, 194, 46, 30);
		}
		return btnB;
	}
	public JTextArea getJtaC() {
		if (jtaC == null) {
			jtaC = new JTextArea();
			jtaC.setEditable(false);
			jtaC.setVisible(false);
			jtaC.setBounds(77, 254, 160, 30);
		}
		return jtaC;
	}
	public JButton getBtnC() {
		if (btnC == null) {
			btnC = new JButton("C");
			btnC.setVisible(false);
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
			btnC.setBounds(10, 254, 46, 30);
		}
		return btnC;
	}
	public JTextArea getJtaD() {
		if (jtaD == null) {
			jtaD = new JTextArea();
			jtaD.setVisible(false);
			jtaD.setEditable(false);
			jtaD.setBounds(327, 254, 160, 30);
		}
		return jtaD;
	}
	public JButton getBtnD() {
		if (btnD == null) {
			btnD = new JButton("D");
			btnD.setVisible(false);
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
			btnD.setBounds(266, 254, 46, 30);
		}
		return btnD;
	}
	public JTextArea getJtaPitanje() {
		if (jtaPitanje == null) {
			jtaPitanje = new JTextArea();
			jtaPitanje.setEditable(false);
			jtaPitanje.setVisible(false);
			jtaPitanje.setBounds(51, 65, 381, 57);
			
		}
		return jtaPitanje;
	}
	public JLabel getLblBrPitanja() {
		if (lblBrPitanja == null) {
			lblBrPitanja = new JLabel("Pitanje broj:1");
			lblBrPitanja.setVisible(false);
			lblBrPitanja.setBounds(51, 26, 103, 14);
		}
		return lblBrPitanja;
	}
	public JLabel getLblBrPoena() {
		if (lblBrPoena == null) {
			lblBrPoena = new JLabel("Broj tacnih: 0");
			lblBrPoena.setVisible(false);
			lblBrPoena.setBounds(349, 26, 83, 14);
		}
		return lblBrPoena;
	}
	public JLabel getLblUnesiteIme() {
		if (lblUnesiteIme == null) {
			lblUnesiteIme = new JLabel("Unesite ime");
			lblUnesiteIme.setBounds(66, 150, 77, 14);
		}
		return lblUnesiteIme;
	}
	public JTextField getJtfUnesiteIme() {
		if (jtfUnesiteIme == null) {
			jtfUnesiteIme = new JTextField();
			jtfUnesiteIme.setBounds(164, 147, 110, 20);
			jtfUnesiteIme.setColumns(10);
		}
		return jtfUnesiteIme;
	}
	public JButton getBtnPotvrdiUnos() {
		if (btnPotvrdiUnos == null) {
			btnPotvrdiUnos = new JButton("Potvrdi unos");
			btnPotvrdiUnos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(getJtfUnesiteIme().getText().equals("")){
						JOptionPane.showMessageDialog(null, "Unesite ime u polje","Izvestaj", JOptionPane.WARNING_MESSAGE);
					}else{
						GUIKontroler.refreshPoslePotvrde();
						imeKorisnika=jtfUnesiteIme.getText();
					}
				}
			});
			btnPotvrdiUnos.setBounds(306, 146, 110, 23);
		}
		return btnPotvrdiUnos;
	}
	public JButton getBtn5050() {
		if (btn5050 == null) {
			btn5050 = new JButton("50/50");
			btn5050.setVisible(false);
			btn5050.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.izbaciPitanja();
				}
			});
			btn5050.setBounds(118, 295, 100, 55);
		}
		return btn5050;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnOIgri());
		}
		return menuBar;
	}
	private JMenu getMnOIgri() {
		if (mnOIgri == null) {
			mnOIgri = new JMenu("O igri");
			mnOIgri.add(getMntmPravilaIgre());
			mnOIgri.add(getMntmAutorIgre());
			mnOIgri.add(getMntmIzadji());
		}
		return mnOIgri;
	}
	private JMenuItem getMntmPravilaIgre() {
		if (mntmPravilaIgre == null) {
			mntmPravilaIgre = new JMenuItem("Pravila igre");
			mntmPravilaIgre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
			mntmPravilaIgre.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

						JOptionPane.showMessageDialog(null, "Kviz na temu informacionih tehnologija. " +'\n' + 
						"Sastoji se od 15 pitanja, svako pitanje donosi tacno jedan poen" + "\n" + 
						"Moguce dve vrste pomoci, '50/50' (uklanja dva netacna odgovora) i 'Zamena' (Menja trenutno pitanje novim pitanjem)"+"\n"+
						"Srecno!", "O igri", JOptionPane.INFORMATION_MESSAGE);
					
				}
			});
		}
		return mntmPravilaIgre;
	}
	private JMenuItem getMntmAutorIgre() {
		if (mntmAutorIgre == null) {
			mntmAutorIgre = new JMenuItem("Autor igre");
			mntmAutorIgre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
			mntmAutorIgre.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, "Kviz napravio Andrija Svrkota","Autor", JOptionPane.INFORMATION_MESSAGE);
				}
			});
		}
		return mntmAutorIgre;
	}
	private JMenuItem getMntmIzadji() {
		if (mntmIzadji == null) {
			mntmIzadji = new JMenuItem("Izadji");
			mntmIzadji.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.zatvoriZaokruzivanjeProzor();
				}
			});
			mntmIzadji.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
			
		}
		return mntmIzadji;
	}
	public JButton getBtnZamena() {
		if (btnZamena == null) {
			btnZamena = new JButton("Zamena");
			btnZamena.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.zameniPitanje();
					
					btnZamena.setVisible(false);
				}
			});
			btnZamena.setVisible(false);
			btnZamena.setBounds(266, 295, 100, 55);
		}
		return btnZamena;
	}
}
