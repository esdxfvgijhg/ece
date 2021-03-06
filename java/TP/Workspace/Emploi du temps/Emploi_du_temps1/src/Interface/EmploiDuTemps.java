package Interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import Ajouter.AjouterBatiment;
import Ajouter.AjouterEnseignant;
import Ajouter.AjouterEtudiant;
import Ajouter.AjouterGroupe;
import Ajouter.AjouterModule;
import Ajouter.AjouterSalle;
import Ajouter.AjouterSceance;
import Ajouter.AjouterSection;
import sql.DB;
import sql.Recherche;

@SuppressWarnings("serial")
public class EmploiDuTemps extends JFrame implements ActionListener {

	private Recherche service;
	public JMenuBar menubar;
	public JMenuItem quitter,button3,button4,button5,button6,ouvrir;
	public JMenuItem enseignant0,etudiant0,groupe0,matiere0,promotion0,seance0,salle0,batiment0;
	public JMenuItem enseignant1,etudiant1,groupe1,matiere1,promotion1,seance1,salle1,batiment1;
	public JMenuItem enseignant2,etudiant2,groupe2,matiere2,promotion2,seance2,salle2,batiment2;
	public JMenuItem enseignant3,etudiant3,groupe3,matiere3,promotion3,seance3,salle3,batiment3;
//	private ServiceEmploi service;

	public EmploiDuTemps(String titre,DB db){
		
		this.service=new Recherche(db);
		centerFrame(this);
		JMenu fichier=new JMenu("Fichier");
			ouvrir =new JMenuItem("Ouvrir");
			button3=new JMenuItem("Exporter");
			button4=new JMenuItem("Importer");
			button5=new JMenuItem("Ajouter");
			button6=new JMenuItem("Supprimer");
			quitter=new JMenuItem("Quitter");

		JMenu afficher=new JMenu("Afficher");
			enseignant0=new JMenuItem("Enseignant");
			etudiant0=new JMenuItem("Etudiant");
			groupe0=new JMenuItem("Groupe");
			matiere0=new JMenuItem("Matiere");
			promotion0=new JMenuItem("Promotion");
			seance0=new JMenuItem("Seance");
			salle0=new JMenuItem("Salle");
			batiment0=new JMenuItem("Batiment");

		JMenu ajouter=new JMenu("Ajouter");
			enseignant1=new JMenuItem("Enseignant");
			etudiant1=new JMenuItem("Etudiant");
			groupe1=new JMenuItem("Groupe");
			matiere1=new JMenuItem("Matiere");
			promotion1=new JMenuItem("Promotion");
			seance1=new JMenuItem("Seance");
			salle1=new JMenuItem("Salle");
			batiment1=new JMenuItem("Batiment");

		JMenu supprimer=new JMenu("Supprimer");
			enseignant2=new JMenuItem("Enseignant");
			etudiant2=new JMenuItem("Etudiant");
			groupe2=new JMenuItem("Groupe");
			matiere2=new JMenuItem("Matiere");
			promotion2=new JMenuItem("Promotion");
			seance2=new JMenuItem("Seance");
			salle2=new JMenuItem("Salle");
			batiment2=new JMenuItem("Batiment");

		JMenu modifier=new JMenu("Modifier");
			enseignant3=new JMenuItem("Enseignant");
			etudiant3=new JMenuItem("Etudiant");
			groupe3=new JMenuItem("Groupe");
			matiere3=new JMenuItem("Matiere");
			promotion3=new JMenuItem("Promotion");
			seance3=new JMenuItem("Seance");
			salle3=new JMenuItem("Salle");
			batiment3=new JMenuItem("Batiment");

		enseignant3.addActionListener(this);
		etudiant3.addActionListener(this);
		groupe3.addActionListener(this);
		matiere3.addActionListener(this);
		promotion3.addActionListener(this);
		seance3.addActionListener(this);
		salle3.addActionListener(this);
		batiment3.addActionListener(this);

		enseignant2.addActionListener(this);
		etudiant2.addActionListener(this);
		groupe2.addActionListener(this);
		matiere2.addActionListener(this);
		promotion2.addActionListener(this);
		seance2.addActionListener(this);
		salle2.addActionListener(this);
		batiment2.addActionListener(this);

		enseignant1.addActionListener(this);
		etudiant1.addActionListener(this);
		groupe1.addActionListener(this);
		matiere1.addActionListener(this);
		promotion1.addActionListener(this);
		seance1.addActionListener(this);
		salle1.addActionListener(this);
		batiment1.addActionListener(this);

		enseignant0.addActionListener(this);
		etudiant0.addActionListener(this);
		groupe0.addActionListener(this);
		matiere0.addActionListener(this);
		promotion0.addActionListener(this);
		seance0.addActionListener(this);
		salle0.addActionListener(this);
		batiment0.addActionListener(this);

		fichier.add(ouvrir);
		fichier.add(button3);
		fichier.add(button4);
		fichier.add(button5);
		fichier.add(button6);
		fichier.add(quitter);

		afficher.add(enseignant0);
		afficher.add(etudiant0);
		afficher.add(groupe0);
		afficher.add(matiere0);
		afficher.add(promotion0);
		afficher.add(seance0);
		afficher.add(salle0);
		afficher.add(batiment0);

		ajouter.add(enseignant1);
		ajouter.add(etudiant1);
		ajouter.add(groupe1);
		ajouter.add(matiere1);
		ajouter.add(promotion1);
		ajouter.add(seance1);
		ajouter.add(salle1);
		ajouter.add(batiment1);

		supprimer.add(enseignant2);
		supprimer.add(etudiant2);
		supprimer.add(groupe2);
		supprimer.add(matiere2);
		supprimer.add(promotion2);
		supprimer.add(seance2);
		supprimer.add(salle2);
		supprimer.add(batiment2);

		modifier.add(enseignant3);
		modifier.add(etudiant3);
		modifier.add(groupe3);
		modifier.add(matiere3);
		modifier.add(promotion3);
		modifier.add(seance3);
		modifier.add(salle3);
		modifier.add(batiment3);

		menubar=new JMenuBar();
		menubar.setBackground(Color.LIGHT_GRAY);
		menubar.add(fichier);
		menubar.add(afficher);
		menubar.add(ajouter);
		menubar.add(supprimer);
		menubar.add(modifier);
		setJMenuBar(menubar);

		quitter.addActionListener(this);
		ouvrir.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);

		new IGraphique(this);
		new Interface_Reservation();

		setTitle(titre);
		setBounds(100, 100,900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e){
		try{
/*		  if (e.getSource()==quitter)
				System.exit(0);
			else if (e.getSource()==ouvrir)
				use();
			else if (e.getSource()==button3)
				new Exporter(this);
			else if (e.getSource()==button4)
				new Importer(this);
			else if (e.getSource()==button5)
     		ajouter();
			else if (e.getSource()==button6)
				supprimer();

			else if (e.getSource()==enseignant0)
				new Afficher<Professor>("Professor",service.findAllProfessor());
			else if (e.getSource()==etudiant0)
					new Afficher<EmploiDuTemps>("Etudiant",service.findAllEmploi());
			else if (e.getSource()==groupe0)
				new Afficher<Classe>("Classe",service.findAllClasse());
			else if (e.getSource()==matiere0)
				new Afficher<Module>("Module",service.findAllModule());
			else if (e.getSource()==promotion0)
				new Afficher<Promotion>("Promotion",service.findAllPromotion());
			else if (e.getSource()==seance0)
				new Afficher<Sceance>("Sceance",service.findAllSceance());
//			else if (e.getSource()==salle0)*/

			if (e.getSource()==enseignant1)
				new AjouterEnseignant(service);
			else if (e.getSource()==etudiant1)
				new AjouterEtudiant(service);
			else if (e.getSource()==groupe1)
				new AjouterGroupe(service);
			else if (e.getSource()==matiere1)
				new AjouterModule(service);
			else if (e.getSource()==promotion1)
				new AjouterSection(service);
			else if (e.getSource()==seance1)
				new AjouterSceance(service);
			else if (e.getSource()==salle1)
				new AjouterSalle(service);
			else if (e.getSource()==batiment1)
				new AjouterBatiment(service);

/*			else if (e.getSource()==enseignant2)
				new Supprimer<Professor> (service,() -> service.findAllProfessor());
			else if (e.getSource()==etudiant2)
				new Supprimer<EmploiDuTemps> (service,() -> service.findAllEmploi());
			else if (e.getSource()==groupe2)
				new Supprimer<Classe> (service,() -> service.findAllClasse());
			else if (e.getSource()==matiere2)
				new Supprimer<AjouterModule> (service,() -> service.findAllModule());
			else if (e.getSource()==promotion2)
				new Supprimer<Promotion> (service,() -> service.findAllPromotion());
			else if (e.getSource()==seance2)
				new Supprimer<AjouterSceance> (service,() -> service.findAllSceance());
//			else if (e.getSource()==salle2)

			else if (e.getSource()==enseignant3)
				new ModifierClasse(service);
/*			else if (e.getSource()==etudiant3)
			else if (e.getSource()==groupe3)
			else if (e.getSource()==matiere3)
			else if (e.getSource()==promotion3)
			else if (e.getSource()==seance3)
			else if (e.getSource()==salle3)
*/

		}catch(Exception ev){
			JOptionPane.showMessageDialog(this,ev.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
		}
	}

/*	private void use(){
		Object a=JOptionPane.showInputDialog(this, "Choisissez la base","Boite d'options",
			JOptionPane.QUESTION_MESSAGE,null,Mysql.listData(),Mysql.listData()[0]);
		Mysql.executer("use "+(String)a);
		setTitle(titre+": "+(String)a);
	}

	private void ajouter(){
		String s=JOptionPane.showInputDialog(this, "Donnez le nom de la base que vous voulez ajouter");
		if (s!=null)
			Mysql.createBase(s,"UTF8");  
	}

	private void supprimer(){
		Object o=JOptionPane.showInputDialog(this, "Choisissez la base que vous voulez supprimer",
			"Boite d'options",JOptionPane.QUESTION_MESSAGE,null, Mysql.listData(), Mysql.listData()[0]);
		Mysql.executer("use "+(String)o);
		Mysql.supprimer("Drop database "+(String)o+";");
	}*/

/*	private <T> void supprimer(List<T> liste, Consumer<T> f){
		Object o=JOptionPane.showInputDialog(this, "Choisissez la base que vous voulez supprimer",
			"Boite d'options",JOptionPane.QUESTION_MESSAGE,null, liste.toArray(), null);
			f.accept(o);
	}*/

	private void centerFrame(JFrame frame) {
	   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	   Dimension frameSize = frame.getSize();
	   frame.setLocation((screenSize.width / 2) - ((frameSize.width +210)/ 2), (screenSize.height / 2) - (frameSize.height / 2));
	}
}


 
