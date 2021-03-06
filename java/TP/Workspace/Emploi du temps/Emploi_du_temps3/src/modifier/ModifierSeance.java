package modifier;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.function.Supplier;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bdd.Batiment;
import bdd.Cours;
import bdd.Enseignant;
import bdd.Etudiant;
import bdd.Groupe;
import bdd.Module;
import bdd.Salle;
import bdd.Section;
import bdd.TP;
import sql.Recherche;

public class ModifierSeance <T> extends JFrame implements ActionListener {

	JComboBox supprimer;
	JComboBox durree;

    JButton enregistrer;
    JButton annuler;
	Recherche service;
	private final SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss");
	private String[] duree = {"00:30","00:45","01:00","01:15","01:30","01:45","02:00","02:15"
			,"02:30","02:45","03:00","03:30","04:00","05:00","06:00"};

    public ModifierSeance(Recherche service, Supplier<List<T>> f){

		this.service=service;
		setTitle("Modifier une seance");
		setBounds(200, 200,970, 200);
		setVisible(true);

        JLabel label = new JLabel("Modifier ");
        supprimer = new JComboBox(f.get().toArray());
        
		JLabel durree_ = new JLabel("Duree :");
		durree = new JComboBox(duree);
		durree.setSelectedItem("01:15");
 
        enregistrer = new JButton("Modifier");
        enregistrer.addActionListener(this);
        
        annuler = new JButton("Annuler");
        annuler.addActionListener(this);
                
        Container contentPane = getContentPane();
        GridBagLayout gbl = new GridBagLayout();

        JPanel jp = new JPanel();
        jp.setLayout(gbl);
        contentPane.add(jp);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 0;
        gbc.weighty = 0;
        
       	Insets inset = new Insets(10,10,5,5); 
        gbc.insets = inset;

        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL; 
        
        add(supprimer,gbc,jp,1,0,1,1);
        add(durree,gbc,jp,1,1,1,1);
        
        add(label,gbc,jp,0,0,1,1);
        add(durree_,gbc,jp,0,1,1,1);
        
		JPanel jp2 = new JPanel();
		jp2.add (enregistrer);
		jp2.add (annuler);

		getContentPane().add (jp2, BorderLayout.SOUTH);
				
 }

	public void actionPerformed(ActionEvent e){
    	Object source = e.getSource();
    	if (source==enregistrer){
				try{
					
				if(supprimer.getSelectedItem() instanceof TP){
					TP tp = new TP();
					tp = (TP)supprimer.getSelectedItem();
					tp.setDuree((Date) formatTime.parse((String)durree.getSelectedItem()+":00"));
					service.modifierTP(tp);
				}else if(supprimer.getSelectedItem() instanceof Cours){
						Cours cours = new Cours();
						cours = (Cours)supprimer.getSelectedItem();
						cours.setDuree((Date) formatTime.parse((String)durree.getSelectedItem()+":00"));
						service.modifierCours(cours);
				}
					setVisible(false);
				}catch(Exception eh){
					JOptionPane.showMessageDialog(this,eh.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
				}
    	}else if (source==annuler)
				setVisible(false);
    }
    
	public void add (Component c, GridBagConstraints gbc,JPanel jp, int x, int y, int w, int h){
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		jp.add(c,gbc);
	}

/*	private void supprimer(T elm){
		Object o=JOptionPane.showInputDialog(this, "Choisissez la base que vous voulez supprimer",
			"Boite d'options",JOptionPane.QUESTION_MESSAGE,null, elm.toArray(), null);
		//Mysql.executer("use "+(String)o);
		Mysql.supprimer("Drop database "+(String)o+";");
	}*/
}
