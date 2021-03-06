package kviz.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import java.awt.Font;
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

public class LicitacijeProzor extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JList list;
	private JLabel lblBroj;
	private JLabel lblBrojPoena;
	private JLabel lblVasOdgovor;
	private JLabel lblOsvojeniPoeni;
	private JTextField txtOdgovor;
	private JLabel lblPitanje;
	private JButton btnPotvrdi;
	private JLabel lblTacanOdgovor;
	private JLabel lblTOdgovor;
	private JMenuBar menuBar;
	private JMenu mnMenu;
	private JMenuItem mntmRangLista;
	private JMenuItem mntmAbout;
	private JMenuItem mntmPravilaIgra;
	private JMenuItem mntmExit;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LicitacijeProzor frame = new LicitacijeProzor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public LicitacijeProzor() {
		setTitle("Kviz - licitacije");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 532, 413);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(50, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getScrollPane_1());
		contentPane.add(getLblBroj());
		contentPane.add(getLblBrojPoena());
		contentPane.add(getLblVasOdgovor());
		contentPane.add(getTxtOdgovor());
		contentPane.add(getLblPitanje());
		contentPane.add(getBtnPotvrdi());
		contentPane.add(getLblTacanOdgovor());
		contentPane.add(getLblTOdgovor());
		contentPane.add(getLblOsvojeniPoeni());
		
	}
	
	private JLabel getLblOsvojeniPoeni() {
		if (lblOsvojeniPoeni == null) {
			lblOsvojeniPoeni = new JLabel("");
			lblOsvojeniPoeni.setHorizontalAlignment(SwingConstants.RIGHT);
			lblOsvojeniPoeni.setBounds(349, 325, 46, 14);
			lblOsvojeniPoeni.setVisible(false);
		}
		return lblOsvojeniPoeni;
	}
	private JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setPreferredSize(new Dimension(100, 100));
			scrollPane.setBounds(413, 11, 94, 272);
			scrollPane.setViewportView(getList_1());
		}
		return scrollPane;
	}
	private JList getList_1() {
		if (list == null) {
			list = new JList(new String[]{"15","14","13","12","11","10","9","8","7","6","5","4","3","2","1"});
			list.setSelectedIndex(14);
			list.setEnabled(false);
		}
		return list;
	}
	private JLabel getLblBroj() {
		if (lblBroj == null) {
			lblBroj = new JLabel("Broj poena:");
			lblBroj.setBounds(423, 295, 94, 14);
		}
		return lblBroj;
	}
	private JLabel getLblBrojPoena() {
		if (lblBrojPoena == null) {
			lblBrojPoena = new JLabel("");
			lblBrojPoena.setHorizontalAlignment(SwingConstants.RIGHT);
			lblBrojPoena.setBounds(413, 325, 61, 14);
			lblBrojPoena.setText("0");
		}
		return lblBrojPoena;
	}
	private JLabel getLblVasOdgovor() {
		if (lblVasOdgovor == null) {
			lblVasOdgovor = new JLabel("Vas odgovor:");
			lblVasOdgovor.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblVasOdgovor.setBounds(22, 209, 103, 26);
		}
		return lblVasOdgovor;
	}
	private JTextField getTxtOdgovor() {
		if (txtOdgovor == null) {
			txtOdgovor = new JTextField();
			txtOdgovor.setBounds(118, 214, 160, 20);
			txtOdgovor.setColumns(10);
		}
		return txtOdgovor;
	}
	public JLabel getLblPitanje() {
		if (lblPitanje == null) {
			lblPitanje = new JLabel("New label");
			lblPitanje.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblPitanje.setHorizontalAlignment(SwingConstants.CENTER);
			lblPitanje.setBounds(24, 74, 364, 75);
		}
		return lblPitanje;
	}
	private JButton getBtnPotvrdi() {
		if (btnPotvrdi == null) {
			btnPotvrdi = new JButton("Potvrdi");
			btnPotvrdi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						boolean kraj = false;
						if(list.getSelectedIndex() == 0)
							kraj = true;
						int vrednost = GUIKontroler.proveraOdgovora(Integer.parseInt(txtOdgovor.getText()));
						podesiVidljivostLabela(true);
						lblOsvojeniPoeni.setText("+" + vrednost);
						lblTOdgovor.setText("" + GUIKontroler.vratiOdgovorLicitacije());
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								try {
									Thread.sleep(1000);
								} catch (InterruptedException e) {
								}

								txtOdgovor.setText("");
								lblOsvojeniPoeni.setText("");
								podesiVidljivostLabela(false);

							}
						});
						int poeni = Integer.parseInt(lblBrojPoena.getText()) + vrednost;
						lblBrojPoena.setText(Integer.toString(poeni));
						list.setSelectedIndex(list.getSelectedIndex() - 1);

						if(kraj){
							int poen = Integer.parseInt(lblBrojPoena.getText());
							if(!GUIKontroler.daLiUpisatiNaRangListuLicitacija(poen)){
								GUIKontroler.pokreniLicitacijeScoreDijalog(false, poeni);
							}else {
								GUIKontroler.pokreniLicitacijeScoreDijalog(true, poen);
							}
							GUIKontroler.zatvoriProzor();
						}else{
							GUIKontroler.pronadjiOdgovorLicitacije();

						}

					}catch(NumberFormatException nfe){
						JOptionPane.showMessageDialog(null, "Greska pri unosu odgovora. Odgovor ne sme sadrzati "
								+ "	znakovne vrednosti.","Greska pri unosu",JOptionPane.ERROR_MESSAGE);
						podesiVidljivostLabela(false);

					}
				}
			});
			btnPotvrdi.setFont(new Font("Tahoma", Font.BOLD, 12));
			btnPotvrdi.setBounds(157, 320, 103, 23);
		}
		return btnPotvrdi;
	}
	public int vratiSelektovaniIndeks(){
		if(list != null)
			return (int) list.getSelectedIndex();
		return -1;
	}
	
	private void podesiVidljivostLabela(boolean vidljivost){
		lblTacanOdgovor.setVisible(vidljivost);
		lblTOdgovor.setVisible(vidljivost);
		lblOsvojeniPoeni.setVisible(vidljivost);;
	}
	
	private JLabel getLblTacanOdgovor() {
		if (lblTacanOdgovor == null) {
			lblTacanOdgovor = new JLabel("Tacan odgovor:");
			lblTacanOdgovor.setVisible(false);
			lblTacanOdgovor.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblTacanOdgovor.setBounds(22, 258, 94, 25);
		}
		return lblTacanOdgovor;
	}
	private JLabel getLblTOdgovor() {
		if (lblTOdgovor == null) {
			lblTOdgovor = new JLabel("\r\n");
			lblTOdgovor.setVisible(false);
			lblTOdgovor.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblTOdgovor.setBounds(118, 261, 66, 19);
		}
		return lblTOdgovor;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnMenu());
		}
		return menuBar;
	}
	private JMenu getMnMenu() {
		if (mnMenu == null) {
			mnMenu = new JMenu("Menu");
			mnMenu.setMnemonic('M');
			mnMenu.add(getMntmPravilaIgra());
			mnMenu.add(getMntmRangLista());
			mnMenu.add(getMntmAbout());
			mnMenu.addSeparator();
			mnMenu.add(getMntmExit());
		}
		return mnMenu;
	}
	private JMenuItem getMntmRangLista() {
		if (mntmRangLista == null) {
			mntmRangLista = new JMenuItem("Rang lista");
			mntmRangLista.setIcon(new ImageIcon(LicitacijeProzor.class.getResource("/com/sun/javafx/scene/web/skin/OrderedListNumbers_16x16_JFX.png")));
			mntmRangLista.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
			mntmRangLista.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.pokreniLicitacijeScoreDijalog(false, -1);
				}
			});
		}
		return mntmRangLista;
	}
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.setIcon(new ImageIcon(LicitacijeProzor.class.getResource("/com/sun/java/swing/plaf/motif/icons/Inform.gif")));
			mntmAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(getContentPane(), "Autor kviza licitacije: Marko Popovic.", "About", JOptionPane.PLAIN_MESSAGE);
				}
			});
		}
		return mntmAbout;
	}
	private JMenuItem getMntmPravilaIgra() {
		if (mntmPravilaIgra == null) {
			mntmPravilaIgra = new JMenuItem("Pravila igra");
			mntmPravilaIgra.setIcon(new ImageIcon(LicitacijeProzor.class.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
			mntmPravilaIgra.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
			mntmPravilaIgra.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(getContentPane(), "Kviz je podeljen na 3 nivo." + "\n" + "Pitanja 1-5 su pitanja najlakseg niva,"
							+ "	pitanja 6-10 srednjeg, a pitanja 11-15 najtezeg nivoa." + "\n" + "U zavisnosti od odgovora, na jednom pitanju mozete"
							+ " osvojiti 10, 5, 3 ili 0 poena.", "Pravila igra", JOptionPane.PLAIN_MESSAGE);
				}
			});
		}
		return mntmPravilaIgra;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					LicitacijeProzor.this.dispose();
				}
			});
		}
		return mntmExit;
	}
}
