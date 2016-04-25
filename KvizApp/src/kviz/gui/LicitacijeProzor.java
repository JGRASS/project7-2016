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

public class LicitacijeProzor extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JList list;
	private JLabel lblBroj;
	private JLabel lblBrojPoena;
	private JLabel lblVasOdgovor;
	private JTextField txtOdgovor;
	private JLabel lblPitanje;
	private JButton btnPotvrdi;
	private JLabel lblTacanOdgovor;
	private JLabel lblTOdgovor;
	

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 392);
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
						lblTOdgovor.setText("" + GUIKontroler.vratiOdgovorLicitacije());
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
								}

								txtOdgovor.setText("");
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
			btnPotvrdi.setBounds(158, 307, 103, 23);
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
}
