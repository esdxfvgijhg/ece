package javamyadmin.Interface;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;
import java.util.*;

public class Interface_EDT implements ActionListener{
	
	public GregorianCalendar maintenant = (GregorianCalendar) GregorianCalendar.getInstance();
	private JLabel    LLundi      = new JLabel();
	private JLabel    LMardi      = new JLabel();
	private JLabel    LMercredi   = new JLabel();
	private JLabel    LJeudi      = new JLabel();
	private JLabel    LVendredi   = new JLabel();
	private JButton   LSemaine    = new JButton();
	private JButton   SemainePrec = new JButton();
	private JButton   SemaineSuiv = new JButton();
	private JTextPane PLundi      = new JTextPane();
	private JTextPane PMardi      = new JTextPane();
	private JTextPane PMercredi   = new JTextPane();
	private JTextPane PJeudi      = new JTextPane();
	private JTextPane PVendredi   = new JTextPane();
	
  private static void AddtexttoPane(String[] initString,String[] initStyles, JTextPane textPane) {
    StyledDocument doc = textPane.getStyledDocument();

    try {
      for (int i=0; i < initString.length; i++) {
          doc.insertString(doc.getLength(), initString[i],doc.getStyle(initStyles[i]));
      }
    } catch (BadLocationException ble) {
      System.err.println("Couldn't insert initial text into text pane.");
    }
  }

	private void Addcourstojour() { //Vector<Vector<?>> tabCours) {

		int nbcours;
		JTextPane textpane;
		/* Calculer le nombre de cours */
		for(int jours=0;jours<5;jours++){
			//Vector<?> listec = tabCours.elementAt(jours);
			//nbcours = listec.size();
			String[] SJour = new String[6*3];
			String[] StyleJour = new String[6*3];
			int j =0;
			for (int i=0;i<=(3*6)-1;i=i+6){
				//on va chercher les cours a afficher pour chaque jour
				//Cours c = listec.elementAt(j);
				SJour[i]="aghiles \n";
				StyleJour[i]="horaire";
				//la matiere
				SJour[i+1]="aghiles\n";
				StyleJour[i+1]="cours";
				//la salle
				SJour[i+2]="Salle \n";
				StyleJour[i+2]="salle";
				//le prof
				SJour[i+3]="aghiles\n";
				StyleJour[i+3]="prof";
				//le groupe
				SJour[i+4]="Groupe \n";
				StyleJour[i+4]="groupe";
				//le delimitement
				SJour[i+5]="******************"+"\n";
				StyleJour[i+5]="cours";
				j++;
			}
	        
			switch(jours) {
				case 0:  textpane= PLundi; break;
				case 1:  textpane = PMardi; break;
				case 2:  textpane = PMercredi; break;
				case 3:  textpane = PJeudi; break;
				case 4:  textpane = PVendredi; break;
				default: textpane = null;
			}
			AddtexttoPane(SJour,StyleJour,textpane);    
		}

	}

	public void afficher_contenu(Jours Semaine){
		//On efface le contenu dans les panels
		PLundi.setText("");
		PMardi.setText("");
		PMercredi.setText("");
		PJeudi.setText("");
		PVendredi.setText("");
		//les labels sont rennomés
		LLundi.setText("     "+Semaine.getStringJour1());
		LMardi.setText("     " +Semaine.getStringJour2());
		LMercredi.setText("     " +Semaine.getStringJour3());
		LJeudi.setText("     " +Semaine.getStringJour4());
		LVendredi.setText("     " +Semaine.getStringJour5());
		LSemaine.setText(" Semaine: "+ Semaine.getStringSemaine());
		SemainePrec.setText(" <<  Semaine " + Semaine.getStringSemaineprec());
		SemaineSuiv.setText(" Semaine " + Semaine.getStringSemaineproch()+"  >> ");
		addtolisteCours(Semaine);
		
	}

	public void addtolisteCours(Jours Semaine){
		try {
			//Vector<Vector<Cours>> liste_cours = (Classeclient.recuperercoursdelasemaine(Semaine));
			Addcourstojour();
		} catch (Exception e) {
			//e.printStackTrace();
		}
		
	}

	public Interface_EDT(JFrame fenetre) {
		
		/* Trouver les jours de la semaine en cours */ 
		Jours Semaine = new Jours(maintenant);
		
		/* Labels et boutons NORD */
		JPanel headerpane = new JPanel();
		headerpane.setLayout(new BorderLayout());
		LSemaine.setBackground(new Color(72,164,255));
		headerpane.add(SemainePrec,BorderLayout.WEST);
		headerpane.add(LSemaine,BorderLayout.CENTER);
		headerpane.add(SemaineSuiv,BorderLayout.EAST);
		
		afficher_contenu(Semaine);
		
		/* Contenu panels dates des jours */
		LLundi.setBorder(new LineBorder(new Color(0,0,0)));
		LLundi.setBackground(new Color(115,167,230));
		LMardi.setBorder(new LineBorder(new Color(0,0,0)));
		LMardi.setBackground(new Color(115,167,230));
		LMercredi.setBorder(new LineBorder(new Color(0,0,0)));
		LMercredi.setBackground(new Color(115,167,230));
		LJeudi.setBorder(new LineBorder(new Color(0,0,0)));
		LJeudi.setBackground(new Color(115,167,230));
		LVendredi.setBorder(new LineBorder(new Color(0,0,0)));
		LVendredi.setBackground(new Color(115,167,230));
		JPanel JoursSemaine = new JPanel();
		JoursSemaine.setLayout(new GridLayout(1,5));
		JoursSemaine.add(LLundi);
		JoursSemaine.add(LMardi);
		JoursSemaine.add(LMercredi);
		JoursSemaine.add(LJeudi);
		JoursSemaine.add(LVendredi);
		
		/* Panel qui regroupe les deux panels du dessus */
		JPanel toppanel = new JPanel();
		toppanel.setLayout(new BorderLayout());
		toppanel.add(headerpane,BorderLayout.NORTH);
		toppanel.add(JoursSemaine,BorderLayout.SOUTH);
		
		fenetre.getContentPane().add(toppanel,BorderLayout.NORTH);
		
		/* Panel qui regroupe les JTextPanes */
		JPanel contenu = new JPanel();
		contenu.setSize(800,400);
		contenu.setLayout(new GridLayout(1,5));
		contenu.setBackground(new Color(255,255,255));
		
		/* Couleurs et bordures des JTextPanes */
		PLundi.setBorder(new LineBorder(new Color(0,0,0)));
		PMardi.setBorder(new LineBorder(new Color(0,0,0)));
		PMercredi.setBorder(new LineBorder(new Color(0,0,0)));
		PJeudi.setBorder(new LineBorder(new Color(0,0,0)));
		PVendredi.setBorder(new LineBorder(new Color(0,0,0)));
		PLundi.setEditable(false);
		PMardi.setEditable(false);
		PMercredi.setEditable(false);
		PJeudi.setEditable(false);
		PVendredi.setEditable(false);
		PLundi.setBackground(new Color(72,164,255));
		PMardi.setBackground(new Color(115,167,230));
		PMercredi.setBackground(new Color(72,164,255));
		PJeudi.setBackground(new Color(115,167,230));
		PVendredi.setBackground(new Color(72,164,255));
		contenu.add(PLundi);
		contenu.add(PMardi);
		contenu.add(PMercredi);
		contenu.add(PJeudi);
		contenu.add(PVendredi);
		
		fenetre.getContentPane().add(contenu,BorderLayout.CENTER);

		LSemaine.addActionListener(this);
		SemaineSuiv.addActionListener(this);
		SemainePrec.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
    if (e.getSource()==LSemaine)
			afficher_contenu(new Jours(maintenant));
		else if (e.getSource()==SemaineSuiv){
			maintenant.add(Calendar.WEEK_OF_YEAR,+1);
			afficher_contenu(new Jours(maintenant));
		}else if (e.getSource()==SemainePrec){
			maintenant.add(Calendar.WEEK_OF_YEAR,-1);
			afficher_contenu(new Jours(maintenant));
		}
	}
}

