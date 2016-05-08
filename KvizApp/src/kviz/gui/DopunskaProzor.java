package kviz.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JProgressBar;

public class DopunskaProzor extends JFrame {

	private JPanel contentPane;
	private JLabel lblPitanje;
	private JTextField txtOdgovor;
	private JLabel lblOdgovor;
	private JLabel lblSkor;
	private JTextField txtSkor;
	private JButton btnOk;
	private JMenuBar menuBar;
	private JMenu mnHelp;
	private JMenuItem mntmAbout;
	private JMenuItem mntmPravilaIgre;
	private JLabel lblImeTakmicara;
	private JTextField txtImeTakmicara;
	private JButton btnPotvrdi;
	private JMenuItem mntmRangLista;
	private JMenuItem mntmExit;
	private JButton btnPocetnoSlovo;
	private JButton btnBrojSlova;
	private JPanel panel;
	private JProgressBar progressBar;
	private JLabel lblOd15;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DopunskaProzor frame = new DopunskaProzor();
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
	public DopunskaProzor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DopunskaProzor.class.getResource("/com/sun/java/swing/plaf/windows/icons/Question.gif")));
		setResizable(false);
		setTitle("Kviz pitalice na dopunu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 487, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblPitanje());
		contentPane.add(getTxtOdgovor());
		contentPane.add(getLblOdgovor());
		contentPane.add(getLblSkor());
		contentPane.add(getTxtSkor());
		contentPane.add(getBtnOk());
		contentPane.add(getMenuBar_1());
		contentPane.add(getLblImeTakmicara());
		contentPane.add(getTxtImeTakmicara());
		contentPane.add(getBtnPotvrdi());
		contentPane.add(getPanel());
		contentPane.add(getProgressBar());
		contentPane.add(getLblOd15());
	}
	public JLabel getLblPitanje() {
		if (lblPitanje == null) {
			lblPitanje = new JLabel("Pitanje");
			lblPitanje.setVisible(false);
			lblPitanje.setHorizontalAlignment(SwingConstants.CENTER);
			lblPitanje.setBounds(10, 29, 451, 66);
		}
		return lblPitanje;
	}
	private JTextField getTxtOdgovor() {
		if (txtOdgovor == null) {
			txtOdgovor = new JTextField();
			txtOdgovor.setVisible(false);
			txtOdgovor.setBounds(188, 138, 153, 20);
			txtOdgovor.setColumns(10);
		}
		return txtOdgovor;
	}
	private JLabel getLblOdgovor() {
		if (lblOdgovor == null) {
			lblOdgovor = new JLabel("Odgovor:");
			lblOdgovor.setVisible(false);
			lblOdgovor.setBounds(87, 141, 55, 14);
		}
		return lblOdgovor;
	}
	private JLabel getLblSkor() {
		if (lblSkor == null) {
			lblSkor = new JLabel("SKOR");
			lblSkor.setVisible(false);
			lblSkor.setBounds(437, 187, 34, 14);
		}
		return lblSkor;
	}
	public JTextField getTxtSkor() {
		if (txtSkor == null) {
			txtSkor = new JTextField();
			txtSkor.setHorizontalAlignment(SwingConstants.CENTER);
			txtSkor.setVisible(false);
			txtSkor.setText("0");
			txtSkor.setEditable(false);
			txtSkor.setBounds(431, 212, 17, 20);
			txtSkor.setColumns(10);
		}
		return txtSkor;
	}
	private JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("OK");
			btnOk.setVisible(false);
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					boolean kraj = false;
					boolean provera = GUIKontroler.proveriOdgovor(getTxtOdgovor().getText().toUpperCase());
					if(provera){
						int skor = Integer.parseInt(getTxtSkor().getText());
						skor = skor+1;
						String s = "" + skor;
						getTxtSkor().setText(s);
					}else{
						JOptionPane.showMessageDialog(null, "Vas skor je: " + getTxtSkor().getText(), "Kraj igre", JOptionPane.INFORMATION_MESSAGE);
						kraj = true;
						GUIKontroler.rangLista();
						GUIKontroler.zatvoriProzorDopunska();
					}
					if(!kraj){
						GUIKontroler.postaviPitanje(Integer.parseInt(getTxtSkor().getText()));
					}
					getTxtOdgovor().setText("");
					progressBar.setValue(Integer.parseInt(getTxtSkor().getText()));
				}
			});
			btnOk.setBounds(188, 169, 89, 23);
		}
		return btnOk;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBounds(0, 0, 471, 21);
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmPravilaIgre());
			mnHelp.add(getMntmRangLista());
			mnHelp.add(getMntmAbout());
			mnHelp.add(getMntmExit());
		}
		return mnHelp;
	}
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.setIcon(new ImageIcon(DopunskaProzor.class.getResource("/com/sun/java/swing/plaf/windows/icons/Question.gif")));
			mntmAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_MASK));
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Pitalice kreirao Sava Pejovic", "O autoru", JOptionPane.INFORMATION_MESSAGE);
				}
			});
		}
		return mntmAbout;
	}
	private JMenuItem getMntmPravilaIgre() {
		if (mntmPravilaIgre == null) {
			mntmPravilaIgre = new JMenuItem("Pravila igre");
			mntmPravilaIgre.setIcon(new ImageIcon(DopunskaProzor.class.getResource("/com/sun/java/swing/plaf/windows/icons/Inform.gif")));
			mntmPravilaIgre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
			mntmPravilaIgre.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null, "Na postavljeno pitanje unosi se odgovor u odgovarajuce polje. " + 
				" Nisu bitna velika i mala slova. " + "\n" + 
				"Pitanja su razlicite tezine. Prvih pet pitanja su laksa, zatim srednje tezine i na kraju najteza. "+"\n"+
				"U toku igre moze se iskoristiti 2 vreste pomoci: "+
				"Za ispisivanje pocetnog slova i broja slova tacnog odgovora."+"\n"+
				"Ako tacno odgovorite na 15 postavljenih pitanja, pobedili ste! Srecno!", "Pravila igre", JOptionPane.INFORMATION_MESSAGE);
				}
			});
		}
		return mntmPravilaIgre;
	}
	private JLabel getLblImeTakmicara() {
		if (lblImeTakmicara == null) {
			lblImeTakmicara = new JLabel("Ime takmicara?");
			lblImeTakmicara.setBounds(156, 81, 98, 14);
		}
		return lblImeTakmicara;
	}
	public JTextField getTxtImeTakmicara() {
		if (txtImeTakmicara == null) {
			txtImeTakmicara = new JTextField();
			txtImeTakmicara.setBounds(131, 107, 123, 20);
			txtImeTakmicara.setColumns(10);
		}
		return txtImeTakmicara;
	}
	private JButton getBtnPotvrdi() {
		if (btnPotvrdi == null) {
			btnPotvrdi = new JButton("Potvrdi");
			btnPotvrdi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(txtImeTakmicara.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Niste uneli ime!", "Greska", JOptionPane.ERROR_MESSAGE);
					}else{
						btnPotvrdi.setVisible(false);
						lblImeTakmicara.setVisible(false);
						txtImeTakmicara.setVisible(false);
						lblOdgovor.setVisible(true);
						lblPitanje.setVisible(true);
						lblSkor.setVisible(true);
						txtOdgovor.setVisible(true);
						txtSkor.setVisible(true);
						btnOk.setVisible(true);
						btnPocetnoSlovo.setVisible(true);
						btnBrojSlova.setVisible(true);
						panel.setVisible(true);
						lblOd15.setVisible(true);
						progressBar.setVisible(true);
					}
				}
			});
			btnPotvrdi.setBounds(299, 90, 89, 23);
		}
		return btnPotvrdi;
	}
	private JMenuItem getMntmRangLista() {
		if (mntmRangLista == null) {
			mntmRangLista = new JMenuItem("Rang lista");
			mntmRangLista.setIcon(new ImageIcon(DopunskaProzor.class.getResource("/com/sun/java/swing/plaf/windows/icons/DetailsView.gif")));
			mntmRangLista.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
			mntmRangLista.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.pokreniProzorDopunskaHighscore();
					
				}
			});
		}
		return mntmRangLista;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.setIcon(new ImageIcon(DopunskaProzor.class.getResource("/com/sun/java/swing/plaf/windows/icons/Error.gif")));
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.zatvoriProzorDopunska();
				}
			});
		}
		return mntmExit;
	}
	private JButton getBtnPocetnoSlovo() {
		if (btnPocetnoSlovo == null) {
			btnPocetnoSlovo = new JButton("Pocetno slovo");
			btnPocetnoSlovo.setBounds(26, 21, 131, 23);
			btnPocetnoSlovo.setVisible(false);
			btnPocetnoSlovo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnPocetnoSlovo.setEnabled(false);
					GUIKontroler.pomocPocetnoSlovo(txtOdgovor);
				}
			});
		}
		return btnPocetnoSlovo;
	}
	private JButton getBtnBrojSlova() {
		if (btnBrojSlova == null) {
			btnBrojSlova = new JButton("Broj slova");
			btnBrojSlova.setBounds(220, 21, 131, 23);
			btnBrojSlova.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnBrojSlova.setEnabled(false);
					GUIKontroler.pomocBrojSlova();
				}
			});
			btnBrojSlova.setVisible(false);
		}
		return btnBrojSlova;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setVisible(false);
			panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "POMOC", TitledBorder.CENTER, TitledBorder.TOP, null, null));
			panel.setBounds(47, 243, 374, 66);
			panel.setLayout(null);
			panel.add(getBtnPocetnoSlovo());
			panel.add(getBtnBrojSlova());
		}
		return panel;
	}
	private JProgressBar getProgressBar() {
		if (progressBar == null) {
			progressBar = new JProgressBar();
			progressBar.setVisible(false);
			progressBar.setMaximum(15);
			progressBar.setBounds(47, 218, 374, 14);
		}
		return progressBar;
	}
	private JLabel getLblOd15() {
		if (lblOd15 == null) {
			lblOd15 = new JLabel("/15");
			lblOd15.setVisible(false);
			lblOd15.setBounds(448, 215, 23, 14);
		}
		return lblOd15;
	}
}
