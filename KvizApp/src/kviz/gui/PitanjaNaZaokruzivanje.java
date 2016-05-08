package kviz.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
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
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class PitanjaNaZaokruzivanje extends JFrame {

	private JPanel contentPane;
	private JButton btnA;
	private JButton btnB;
	private JButton btnC;
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
	private Thread thread;
	private JLabel lblBackground;
	private JLabel lblUkupanBrojPoena;
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 218, 205);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblUkupanBrojPoena());
		contentPane.add(getBtnA());
		contentPane.add(getBtnB());
		contentPane.add(getBtnC());
		contentPane.add(getBtnD());
		contentPane.add(getJtaPitanje());
		contentPane.add(getLblBrPitanja());
		contentPane.add(getLblUnesiteIme());
		contentPane.add(getLblBrPoena());
		contentPane.add(getJtfUnesiteIme());
		contentPane.add(getBtnPotvrdiUnos());
		contentPane.add(getBtn5050());
		contentPane.add(getBtnZamena());
		contentPane.add(getLblBackground());
		thread = new Thread();
	}
	public JButton getBtnA() {
		if (btnA == null) {
			btnA = new JButton("A");
			
			btnA.setVisible(false);
			btnA.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					if(brojac<15){
					if(btnA.getText().equals(GUIKontroler.vratiTacan())){
						brojTacnih++;
						lblBrPoena.setText(""+brojTacnih);
						
					}
					
					brojac++;
					GUIKontroler.resetujPitanja();
				}else{
					if(btnA.getText().equals(GUIKontroler.vratiTacan())) brojTacnih++;
					JOptionPane.showMessageDialog(null, "Uspesno ste zavrsili igru.Broj poena koje"
							+ " ste osvojili je: " +brojTacnih , "Izvestaj", JOptionPane.INFORMATION_MESSAGE);
					GUIKontroler.zaokruzivanjeRangLista();
					GUIKontroler.zatvoriZaokruzivanjeProzor();
				}
				}
			});
			btnA.setBounds(49, 175, 200, 30);
		}
		return btnA;
	}
	public JButton getBtnB() {
		if (btnB == null) {
			btnB = new JButton("B");

			
			btnB.setVisible(false);
			btnB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(brojac<15){
					if(btnB.getText().equals(GUIKontroler.vratiTacan())){
						brojTacnih++;
						lblBrPoena.setText(""+brojTacnih);
					}
					
					brojac++;
					GUIKontroler.resetujPitanja();
				}else{
					JOptionPane.showMessageDialog(null, "Uspesno ste zavrsili igru.Broj poena koje"
							+ " ste osvojili je: " +brojTacnih , "Izvestaj", JOptionPane.INFORMATION_MESSAGE);
					GUIKontroler.zaokruzivanjeRangLista();
					GUIKontroler.zatvoriZaokruzivanjeProzor();
				}
				}
				
			});
			btnB.setBounds(266, 175, 200, 30);
		}
		return btnB;
	}
	public JButton getBtnC() {
		if (btnC == null) {
			btnC = new JButton("C");

			
			btnC.setVisible(false);
			btnC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(brojac<15){
					if(btnC.getText().equals(GUIKontroler.vratiTacan())){
						brojTacnih++;
						lblBrPoena.setText(""+brojTacnih);
					}
					
					brojac++;
					GUIKontroler.resetujPitanja();
				}else{
					JOptionPane.showMessageDialog(null, "Uspesno ste zavrsili igru.Broj poena koje"
							+ " ste osvojili je: " +brojTacnih , "Izvestaj", JOptionPane.INFORMATION_MESSAGE);
					GUIKontroler.zaokruzivanjeRangLista();
					GUIKontroler.zatvoriZaokruzivanjeProzor();
				}
				}
			});
			btnC.setBounds(49, 216, 200, 30);
		}
		return btnC;
	}
	public JButton getBtnD() {
		if (btnD == null) {
			btnD = new JButton("D");

			
			btnD.setVisible(false);
			btnD.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(brojac<15){
					if(btnD.getText().equals(GUIKontroler.vratiTacan())){
						brojTacnih++;
						lblBrPoena.setText(""+brojTacnih);
					}
					
					brojac++;
					GUIKontroler.resetujPitanja();
				}else{
					JOptionPane.showMessageDialog(null, "Uspesno ste zavrsili igru.Broj poena koje"
							+ " ste osvojili je: " +brojTacnih , "Izvestaj", JOptionPane.INFORMATION_MESSAGE);
					GUIKontroler.zaokruzivanjeRangLista();
					GUIKontroler.zatvoriZaokruzivanjeProzor();
				}
				}
			});
			btnD.setBounds(266, 216, 200, 30);
		}
		return btnD;
	}
	public JTextArea getJtaPitanje() {
		if (jtaPitanje == null) {
			jtaPitanje = new JTextArea();
			jtaPitanje.setAlignmentX(CENTER_ALIGNMENT);
			jtaPitanje.setAlignmentY(CENTER_ALIGNMENT);
			jtaPitanje.setEditable(false);
			jtaPitanje.setVisible(false);
			jtaPitanje.setBounds(49, 40, 381, 60);
			
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
			lblBrPoena = new JLabel("0");
			lblBrPoena.setFont(new Font("Tahoma", Font.BOLD, 22));
			lblBrPoena.setForeground(Color.WHITE);
			lblBrPoena.setVisible(false);
			lblBrPoena.setBounds(518, 160, 39, 30);
		}
		return lblBrPoena;
	}
	public JLabel getLblUnesiteIme() {
		if (lblUnesiteIme == null) {
			lblUnesiteIme = new JLabel("Unesite ime");
			lblUnesiteIme.setHorizontalAlignment(SwingConstants.CENTER);
			lblUnesiteIme.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblUnesiteIme.setBounds(49, 40, 110, 30);
		}
		return lblUnesiteIme;
	}
	public JTextField getJtfUnesiteIme() {
		if (jtfUnesiteIme == null) {
			jtfUnesiteIme = new JTextField();
			jtfUnesiteIme.setBounds(49, 74, 110, 20);
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
			btnPotvrdiUnos.setBounds(49, 104, 110, 23);
		}
		return btnPotvrdiUnos;
	}
	public JButton getBtn5050() {
		if (btn5050 == null) {
//			Icon zam = new ImageIcon("fajlovi/zamenaDugme.png");
//			btnZamena = new JButton(zam);
//			btnZamena.setOpaque(false);
//			btnZamena.setContentAreaFilled(false);
//			btnZamena.setBorderPainted(false);
//			btnZamena.setFocusPainted(false);
			Icon dugme5050 = new ImageIcon("src/ikonice/5050dugme.png");
			Icon hoverDugme5050 = new ImageIcon("src/ikonice/hover5050.png");
			btn5050 = new JButton(dugme5050);
			btn5050.setOpaque(false);
			btn5050.setContentAreaFilled(false);
			btn5050.setBorderPainted(false);
			btn5050.setFocusPainted(false);
			btn5050.setVisible(false);
			btn5050.setRolloverIcon(hoverDugme5050);
			btn5050.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.izbaciPitanja();
				}
			});
			btn5050.setBounds(122, 276, 100, 55);
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
			mnOIgri.addSeparator();
			mnOIgri.add(getMntmAutorIgre());
			mnOIgri.addSeparator();
			mnOIgri.add(getMntmIzadji());
		}
		return mnOIgri;
	}
	private JMenuItem getMntmPravilaIgre() {
		if (mntmPravilaIgre == null) {
			mntmPravilaIgre = new JMenuItem("Pravila igre");
			mntmPravilaIgre.setIcon(new ImageIcon(PitanjaNaZaokruzivanje.class.getResource("/ikonice/pravila.jpg")));
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
			mntmAutorIgre.setIcon(new ImageIcon(PitanjaNaZaokruzivanje.class.getResource("/ikonice/about.jpg")));
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
			mntmIzadji.setIcon(new ImageIcon(PitanjaNaZaokruzivanje.class.getResource("/ikonice/exit.jpg")));
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
			Icon zam = new ImageIcon("src/ikonice/zamenaDugme.png");
			Icon hoverZamena = new ImageIcon("src/ikonice/hoverZamena.png");
			
			btnZamena = new JButton(zam);
			btnZamena.setOpaque(false);
			btnZamena.setContentAreaFilled(false);
			btnZamena.setBorderPainted(false);
			btnZamena.setFocusPainted(false);
			btnZamena.setRolloverIcon(hoverZamena);
			btnZamena.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.zameniPitanje();
					
					btnZamena.setVisible(false);
				}
			});
			btnZamena.setVisible(false);
			btnZamena.setBounds(270, 276, 100, 55);
		}
		return btnZamena;
	}
	public String getBrTacnih(){
		return brojTacnih+"";
	}
	public JLabel getLblBackground() {
		if (lblBackground == null) {
			lblBackground = new JLabel("");
			lblBackground.setIcon(new ImageIcon(PitanjaNaZaokruzivanje.class.getResource("/ikonice/layoutKviz.jpg")));
			lblBackground.setVisible(false);
			lblBackground.setBounds(0, 0, 640, 360);
		}
		return lblBackground;
	}
	public JLabel getLblUkupanBrojPoena() {
		if (lblUkupanBrojPoena == null) {
			lblUkupanBrojPoena = new JLabel("15");
			lblUkupanBrojPoena.setVisible(false);
			lblUkupanBrojPoena.setForeground(Color.WHITE);
			lblUkupanBrojPoena.setFont(new Font("Tahoma", Font.BOLD, 22));
			lblUkupanBrojPoena.setBounds(582, 160, 34, 30);
		}
		return lblUkupanBrojPoena;
	}
}
