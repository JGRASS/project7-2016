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
			txtOdgovor.setBounds(217, 138, 153, 20);
			txtOdgovor.setColumns(10);
		}
		return txtOdgovor;
	}
	private JLabel getLblOdgovor() {
		if (lblOdgovor == null) {
			lblOdgovor = new JLabel("Odgovor:");
			lblOdgovor.setVisible(false);
			lblOdgovor.setBounds(110, 141, 55, 14);
		}
		return lblOdgovor;
	}
	private JLabel getLblSkor() {
		if (lblSkor == null) {
			lblSkor = new JLabel("SKOR");
			lblSkor.setVisible(false);
			lblSkor.setBounds(131, 231, 46, 14);
		}
		return lblSkor;
	}
	public JTextField getTxtSkor() {
		if (txtSkor == null) {
			txtSkor = new JTextField();
			txtSkor.setVisible(false);
			txtSkor.setText("0");
			txtSkor.setEditable(false);
			txtSkor.setBounds(217, 228, 25, 20);
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
				}
			});
			btnOk.setBounds(217, 180, 89, 23);
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
			mntmPravilaIgre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
			mntmPravilaIgre.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null, "Na postavljeno pitanje unosi se odgovor u odgovarajuce polje. " + 
				" Nisu bitna velika i mala slova. " + "\n" + 
				"Pitanja su razlicite tezine. Prvih pet pitanja su laksa, zatim srednje tezine i na kraju najteza. "+"\n"+
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
					btnPotvrdi.setVisible(false);
					lblImeTakmicara.setVisible(false);
					txtImeTakmicara.setVisible(false);
					lblOdgovor.setVisible(true);
					lblPitanje.setVisible(true);
					lblSkor.setVisible(true);
					txtOdgovor.setVisible(true);
					txtSkor.setVisible(true);
					btnOk.setVisible(true);
					
				}
			});
			btnPotvrdi.setBounds(299, 90, 89, 23);
		}
		return btnPotvrdi;
	}
	private JMenuItem getMntmRangLista() {
		if (mntmRangLista == null) {
			mntmRangLista = new JMenuItem("Rang lista");
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
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.zatvoriProzorDopunska();
				}
			});
		}
		return mntmExit;
	}
}
