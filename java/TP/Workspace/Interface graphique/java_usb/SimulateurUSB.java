import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimulateurUSB {
			
	public static void main (String[] args){
		final MemoireUSB usb = new MemoireUSB (1024);	//on alloue 1Go comme taille de la clé USB	
		final JFrame frame = new JFrame ("Simulateur de clé USB");//on crée une fenêtre qui porte le nom "Simulateur de clé USB"
		final JComponent usbComponent = Interface.createComponent (usb);//on crée une interface avec usb comme paramètre 
		frame.getContentPane().add (usbComponent, BorderLayout.CENTER);// intégrer l'interface à la fenetre  
		
		final JTextField nom = new JTextField ("nom du Fichier");	//création d'un édit pour saisire le nom du fichier à ajouter
		final JTextField taille = new JTextField ("Taille du Fichier");//création d'un édit pour saisire la taille du fichier à ajouter
		
		JButton ajout = new JButton ("Ajouter");//creation d'un boutton "ajouter"		
		ajout.addActionListener (new ActionListener()	//donner une fonction au boutton
		{
			public void actionPerformed (ActionEvent event)
			{		
				try{				
					int s = Integer.parseInt (taille.getText());//convertir le contenu de l'edit "taille" en entier
					if(s<0){	//si la taille saisie est negative on affiche un message d'erreur
						JOptionPane.showMessageDialog (frame," Saisissez une taille correcte ", "Erreur", JOptionPane.ERROR_MESSAGE);
						return;
					}	
					String name = nom.getText(); //affecter le contenu de l'edit "nom" à "name"
					
					//si le nom du fichier existe on affiche un message d'erreur
					for(int i=0;i<usb.getTailleBlocs();i++) if (usb.getBlocs(i).getNom().equals(name)){
						JOptionPane.showMessageDialog (frame, name+" existe deja ", "Erreur", JOptionPane.ERROR_MESSAGE);
						return;	
				}									
						usb.ajout (new Fichier (name, createData (s)));//on ajoute le fichier
						usbComponent.repaint();//on refait notre interface 
				}
				catch (NumberFormatException exception){
					//si la saisie est incorrecte on affiche un message d'erreur
					JOptionPane.showMessageDialog (frame, "Taille de fichier erroné ", "Erreur", JOptionPane.ERROR_MESSAGE);
					return;
				}
				catch (RuntimeException exception)
				{//si la memoire est insufisante on affiche un  message d'erreur
					JOptionPane.showMessageDialog (frame, "Memoire insuffisante ", "Error :", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});
		final JTextField supprimer_nom = new JTextField ("nom du Fichier");
				//création d'un édit pour saisire le nom du fichier à supprimer
		JButton suppression = new JButton ("Supprimer");		//creation d'un boutton "supprimer"
		suppression.addActionListener (new ActionListener()		//donner une fonction au boutton
		{
			public void actionPerformed (ActionEvent event)
			{
				try
				{
					usb.suppression (supprimer_nom.getText());	//on supprime le fichier 
					usbComponent.repaint();//on refait notre interface
				}
				catch (RuntimeException exception)//si le fichier n'existe pas on affiche un message d'erreur
				{
					JOptionPane.showMessageDialog (frame, "Fichier introuvable ", "Erreur", JOptionPane.ERROR_MESSAGE);
					return;
				}
			}
		});
		
		//creer des étiquetes pour chaque edit
		JPanel controlbox = new JPanel();
		controlbox.add (new JLabel ("      Nom"));
		controlbox.add (nom);
		controlbox.add (new JLabel ("Taille"));
		controlbox.add (taille);
		controlbox.add (ajout);
		controlbox.add (new JLabel ("Index"));
		controlbox.add (supprimer_nom);
		controlbox.add (suppression);
		
		
		frame.getContentPane().add (controlbox, BorderLayout.SOUTH);//mettre les étiquetes en bas 
		
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);//creer un boutton pour quiter l'application 
		frame.setSize (new Dimension (1033,150));//donner les dimensions de la fenetre
		frame.setVisible (true);//afficher la fenetre
	}
	
	private static String createData (int taille){	//creation une chaine de caractere de taille "taille"
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < taille; i++) builder.append (' ');
		return builder.toString();
	}
}
