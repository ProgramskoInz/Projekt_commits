package programsko;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.TextArea;
import java.awt.Canvas;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Guii extends JFrame {
	private int testvalja=0,treningvalja=0,returnVal;
	private String pathtrening,pathtest,pathcsv,pathdir;
	private JPanel contentPane;
	private  File file;
	private JFileChooser fc;
	private static TextArea textArea;
	private UcitajPodatke ucitavanje;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Guii frame = new Guii(); // ovo je od buildera nista bitno samo pokretanje 
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
	public Guii() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		textArea = new TextArea();
		textArea.setBounds(16, 34, 247, 73);
		
		JButton btnUcitaj = new JButton("Ucitaj");
		btnUcitaj.setBounds(260, 5, 89, 23);
		contentPane.add(btnUcitaj);
		btnUcitaj.setEnabled(false); // ovo stavi da je zatamnjeno dok se ne ucita i trening i test podaci
		
		btnUcitaj.addActionListener(new ActionListener() {  // ucitaj button
			  public void actionPerformed(ActionEvent e) { 
				 try {
					ucitavanje = new UcitajPodatke(pathtrening,pathtest); // poziva objekt i ucitava podatke
					textArea.setText("Podaci spremni"); //ispis da su podaci spremni
					btnUcitaj.setEnabled(false); // kad su podaci spremljeni ne moze se nista pozivati dok se novi odaberu
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}} );
		
		JButton btnUcitajPodatke = new JButton("Trening"); //ucitava trening podatke
		btnUcitajPodatke.setBounds(16, 5, 89, 23);
		btnUcitajPodatke.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				 fc = new JFileChooser();
				  returnVal = fc.showOpenDialog(fc);
				
				    if (returnVal == JFileChooser.APPROVE_OPTION) {
				        file = fc.getSelectedFile();
				        // What to do with the file, e.g. display it in a TextArea
				       	pathtrening = file.getAbsolutePath().toString(); //sprema path od treninga
				       
				        try {
				        	if (pathtrening.endsWith(".arff")) { // ako path treninga fajl podataka zavrsava sa arff
				        		
				        		textArea.append("\nTrening je odabran: "+pathtrening);//ispis puta treninga
				        		treningvalja = 1;//flag da li format trening podataka valja
				        		}else {
				        			textArea.append("\nFormat treninga nije valjan\n"); // oznaka da valja
				        			treningvalja = 0; // format nije zadovoljen
				        		}
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				    } else {
				        System.out.println("File access cancelled by user.");
				    }
				    if(testvalja==1 && treningvalja==1) {
						btnUcitaj.setEnabled(true);//gledal dal moze enablat buton
					}else {
						btnUcitaj.setEnabled(false);	//siv button
			  		}
				  } 
				} );
		
		
		
		Canvas canvas = new Canvas();
		canvas.setBounds(5, 5, 0, 0);
		
		JPanel panel = new JPanel();
		panel.setBounds(412, 90, 22, 175);
		contentPane.setLayout(null);
		contentPane.add(textArea);
		contentPane.add(btnUcitajPodatke);
		contentPane.add(canvas);
		contentPane.add(panel);
		
		JButton btnUcitajTest = new JButton("Test");
		btnUcitajTest.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  fc = new JFileChooser();
				  returnVal = fc.showOpenDialog(fc);
				
				    if (returnVal == JFileChooser.APPROVE_OPTION) {
				        file = fc.getSelectedFile();
				        // What to do with the file, e.g. display it in a TextArea
				       pathtest = file.getAbsolutePath().toString();
				    
				        try {
				        	if (pathtest.endsWith(".arff")) { // ako zavrsava sa arff onda je priznat 
				        		
				        		textArea.append("\nTest je odabran: "+pathtest); // ispis puta testa
				        		testvalja = 1; //format testa valja
				        		
				        		}else {
				        			textArea.append("\nFormat testa nije valjan\n");
				        			testvalja = 0; //format testa ne valja
				        		}
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				    } else {
				        System.out.println("File access cancelled by user.");
				    }
				    if(testvalja==1 && treningvalja==1) {
						btnUcitaj.setEnabled(true); // gleda dal moze enableat button za uctiavanjae
					}else{
						btnUcitaj.setEnabled(false); //ako ne valja gumb je siv
					}
				  } 
				} );
		btnUcitajTest.setBounds(161, 5, 89, 23);
		contentPane.add(btnUcitajTest);
		
		JButton btnCsvarff = new JButton("CSV-ARFF");//pretvorba csv u arff format
		btnCsvarff.setBounds(16, 113, 113, 23);
		contentPane.add(btnCsvarff);
		
		JButton btnRegresija = new JButton("Regresija");
		btnRegresija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(btnUcitaj.isEnabled()) { // ako je moguce ucitanje, tj ako valjaju oba skupa podataka
					//	Regresija.regresija(ucitavanje); //slanje objekta konstruktoru od regresije
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRegresija.setBounds(150, 113, 113, 23);
		contentPane.add(btnRegresija);
		
		JButton btnObradi = new JButton("Obradi");
		btnObradi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 if(testvalja==1 && treningvalja==1) {
						 ThresholdRad.manipuliraj(ucitavanje);
					 }
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnObradi.setBounds(16, 148, 89, 23);
		contentPane.add(btnObradi);
		
		JButton btnOcistiProzor = new JButton("Ocisti prozor");
		btnOcistiProzor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		btnOcistiProzor.setBounds(270, 34, 89, 23);
		contentPane.add(btnOcistiProzor);
		btnCsvarff.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  fc = new JFileChooser();
				  returnVal = fc.showOpenDialog(fc);
				
				    if (returnVal == JFileChooser.APPROVE_OPTION) {
				        file = fc.getSelectedFile();
				        // What to do with the file, e.g. display it in a TextArea
				       pathcsv = file.getAbsolutePath().toString(); //uzima path od fajla
				       pathdir = file.getParentFile().toString(); // uzima path od direktorija tako da zna di ce spremit poslije
				        try {
				        	if (pathcsv.endsWith(".csv")) { // ako zavrsava sa csv
				        		
				        		CSVBiranje prozor = new CSVBiranje(pathcsv,pathdir); // pozivanje novog jframea sa putevima fajla i direkotija
				        		//textArea.setText(pathcsv+pathdir);
				        		prozor.setVisible(true); // posatavi da vidimo novi jframe
				        		}else {
				        			textArea.append("\nFormat CSV nije valjan\n"); // format za pretvorbu ne valja
				        		
				        		}
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				    } else {
				        System.out.println("File access cancelled by user.");
				    }
				    
				  } 
				} );
		
		
	}
	public static void Pisi(String tekst) {
		textArea.setText(tekst); // sluzi za pisanje po textboxu iz drugih klasa
	}
}
