package javamyadmin.Interface;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javamyadmin.Data.*;
import javamyadmin.Model.*;
import javamyadmin.Interface.*;

public class Accueil extends JFrame implements ActionListener{

	public JMenuBar menubar;
	public JMenuItem quitter,button3,button4,button5,button6,ouvrir;
	public JMenuItem cours0,creneau0,enseignant0,enseignement0,etudiant0,groupe0,matiere0,promotion0,responsable0,seance0,salle0;
	public JMenuItem cours1,creneau1,enseignant1,enseignement1,etudiant1,groupe1,matiere1,promotion1,responsable1,seance1,salle1;
	public JMenuItem cours2,creneau2,enseignant2,enseignement2,etudiant2,groupe2,matiere2,promotion2,responsable2,seance2,salle2;
	public JMenuItem cours3,creneau3,enseignant3,enseignement3,etudiant3,groupe3,matiere3,promotion3,responsable3,seance3,salle3;
	private ServiceEmploi service;
	private String titre;

	public Accueil(String titre,String[] s){
		
		this.titre=titre;
		service = new ServiceEmploi();
		centerFrame(this);
		JMenu fichier=new JMenu("Fichier");
			ouvrir =new JMenuItem("Ouvrir");
			button3=new JMenuItem("Exporter");
			button4=new JMenuItem("Importer");
			button5=new JMenuItem("Ajouter");
			button6=new JMenuItem("Supprimer");
			quitter=new JMenuItem("Quitter");

		JMenu afficher=new JMenu("Afficher");
			cours0=new JMenuItem("Cours");
			creneau0=new JMenuItem("Creneau");
			enseignant0=new JMenuItem("Enseignant");
			enseignement0=new JMenuItem("Enseignement");
			etudiant0=new JMenuItem("Etudiant");
			groupe0=new JMenuItem("Groupe");
			matiere0=new JMenuItem("Matiere");
			promotion0=new JMenuItem("Promotion");
			responsable0=new JMenuItem("Responsable");
			seance0=new JMenuItem("Seance");
			salle0=new JMenuItem("Salle");

		JMenu ajouter=new JMenu("Ajouter");
			cours1=new JMenuItem("Cours");
			creneau1=new JMenuItem("Creneau");
			enseignant1=new JMenuItem("Enseignant");
			enseignement1=new JMenuItem("Enseignement");
			etudiant1=new JMenuItem("Etudiant");
			groupe1=new JMenuItem("Groupe");
			matiere1=new JMenuItem("Matiere");
			promotion1=new JMenuItem("Promotion");
			responsable1=new JMenuItem("Responsable");
			seance1=new JMenuItem("Seance");
			salle1=new JMenuItem("Salle");

		JMenu supprimer=new JMenu("Supprimer");
			cours2=new JMenuItem("Cours");
			creneau2=new JMenuItem("Creneau");
			enseignant2=new JMenuItem("Enseignant");
			enseignement2=new JMenuItem("Enseignement");
			etudiant2=new JMenuItem("Etudiant");
			groupe2=new JMenuItem("Groupe");
			matiere2=new JMenuItem("Matiere");
			promotion2=new JMenuItem("Promotion");
			responsable2=new JMenuItem("Responsable");
			seance2=new JMenuItem("Seance");
			salle2=new JMenuItem("Salle");

		JMenu modifier=new JMenu("Modifier");
			cours3=new JMenuItem("Cours");
			creneau3=new JMenuItem("Creneau");
			enseignant3=new JMenuItem("Enseignant");
			enseignement3=new JMenuItem("Enseignement");
			etudiant3=new JMenuItem("Etudiant");
			groupe3=new JMenuItem("Groupe");
			matiere3=new JMenuItem("Matiere");
			promotion3=new JMenuItem("Promotion");
			responsable3=new JMenuItem("Responsable");
			seance3=new JMenuItem("Seance");
			salle3=new JMenuItem("Salle");

		cours3.addActionListener(this);
		creneau3.addActionListener(this);
		enseignant3.addActionListener(this);
		enseignement3.addActionListener(this);
		etudiant3.addActionListener(this);
		groupe3.addActionListener(this);
		matiere3.addActionListener(this);
		promotion3.addActionListener(this);
		responsable3.addActionListener(this);
		seance3.addActionListener(this);
		salle3.addActionListener(this);

		cours2.addActionListener(this);
		creneau2.addActionListener(this);
		enseignant2.addActionListener(this);
		enseignement2.addActionListener(this);
		etudiant2.addActionListener(this);
		groupe2.addActionListener(this);
		matiere2.addActionListener(this);
		promotion2.addActionListener(this);
		responsable2.addActionListener(this);
		seance2.addActionListener(this);
		salle2.addActionListener(this);

		cours1.addActionListener(this);
		creneau1.addActionListener(this);
		enseignant1.addActionListener(this);
		enseignement1.addActionListener(this);
		etudiant1.addActionListener(this);
		groupe1.addActionListener(this);
		matiere1.addActionListener(this);
		promotion1.addActionListener(this);
		responsable1.addActionListener(this);
		seance1.addActionListener(this);
		salle1.addActionListener(this);

		cours0.addActionListener(this);
		creneau0.addActionListener(this);
		enseignant0.addActionListener(this);
		enseignement0.addActionListener(this);
		etudiant0.addActionListener(this);
		groupe0.addActionListener(this);
		matiere0.addActionListener(this);
		promotion0.addActionListener(this);
		responsable0.addActionListener(this);
		seance0.addActionListener(this);
		salle0.addActionListener(this);

		fichier.add(ouvrir);
		fichier.add(button3);
		fichier.add(button4);
		fichier.add(button5);
		fichier.add(button6);
		fichier.add(quitter);

		afficher.add(cours0);
		afficher.add(creneau0);
		afficher.add(enseignant0);
		afficher.add(enseignement0);
		afficher.add(etudiant0);
		afficher.add(groupe0);
		afficher.add(matiere0);
		afficher.add(promotion0);
		afficher.add(responsable0);
		afficher.add(seance0);
		afficher.add(salle0);

		ajouter.add(cours1);
		ajouter.add(creneau1);
		ajouter.add(enseignant1);
		ajouter.add(enseignement1);
		ajouter.add(etudiant1);
		ajouter.add(groupe1);
		ajouter.add(matiere1);
		ajouter.add(promotion1);
		ajouter.add(responsable1);
		ajouter.add(seance1);
		ajouter.add(salle1);

		supprimer.add(cours2);
		supprimer.add(creneau2);
		supprimer.add(enseignant2);
		supprimer.add(enseignement2);
		supprimer.add(etudiant2);
		supprimer.add(groupe2);
		supprimer.add(matiere2);
		supprimer.add(promotion2);
		supprimer.add(responsable2);
		supprimer.add(seance2);
		supprimer.add(salle2);

		modifier.add(cours3);
		modifier.add(creneau3);
		modifier.add(enseignant3);
		modifier.add(enseignement3);
		modifier.add(etudiant3);
		modifier.add(groupe3);
		modifier.add(matiere3);
		modifier.add(promotion3);
		modifier.add(responsable3);
		modifier.add(seance3);
		modifier.add(salle3);

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

		new Interface_EDT(this);

		setTitle(titre);
		setBounds(100, 100,900, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e){
		try{
		  if (e.getSource()==quitter)
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

/*			else if (e.getSource()==cours0)
			else if (e.getSource()==creneau0)*/
			else if (e.getSource()==enseignant0)
				new Afficher<Professor>("Professor",service.findAllProfessor());
/*			else if (e.getSource()==enseignement0)
			else if (e.getSource()==etudiant0)
			else if (e.getSource()==groupe0)*/
			else if (e.getSource()==matiere0)
				new Afficher<Module>("Module",service.findAllNameModule());
			else if (e.getSource()==promotion0)
				new Afficher<Promotion>("Promotion",service.findAllPromotion());
//			else if (e.getSource()==responsable0)
			else if (e.getSource()==seance0)
				new Afficher<Sceance>("Sceance",service.findAllSceance());
//			else if (e.getSource()==salle0)

/*		}else if (e.getSource()==cours1)
			else if (e.getSource()==creneau1)*/
			else if (e.getSource()==enseignant1)
				new GraphiqueProfessor(service);
/*			else if (e.getSource()==enseignement1)
			else if (e.getSource()==etudiant1)
			else if (e.getSource()==groupe1)*/
			else if (e.getSource()==matiere1)
				new GraphiqueModule(service);
			else if (e.getSource()==promotion1)
				new GraphiquePromotion(service);
//			else if (e.getSource()==responsable1)
			else if (e.getSource()==seance1)
				new GraphiqueSeance(service);
/*			else if (e.getSource()==salle1)

			else if (e.getSource()==cours2)
			else if (e.getSource()==creneau2)
			else if (e.getSource()==enseignant2)
			else if (e.getSource()==enseignement2)
			else if (e.getSource()==etudiant2)
			else if (e.getSource()==groupe2)
			else if (e.getSource()==matiere2)
			else if (e.getSource()==promotion2)
			else if (e.getSource()==responsable2)
			else if (e.getSource()==seance2)
			else if (e.getSource()==salle2)

			else if (e.getSource()==cours3)
			else if (e.getSource()==creneau3)
			else if (e.getSource()==enseignant3)
			else if (e.getSource()==enseignement3)
			else if (e.getSource()==etudiant3)
			else if (e.getSource()==groupe3)
			else if (e.getSource()==matiere3)
			else if (e.getSource()==promotion3)
			else if (e.getSource()==responsable3)
			else if (e.getSource()==seance3)
			else if (e.getSource()==salle3)*/

		}catch(Exception ev){
			JOptionPane.showMessageDialog(this,ev.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
		}
	}

	private void use(){
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
	}

	private void centerFrame(JFrame frame) {
	   Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	   Dimension frameSize = frame.getSize();
	   frame.setLocation((screenSize.width / 2) - ((frameSize.width +210)/ 2), (screenSize.height / 2) - (frameSize.height / 2));
	}
}


 
