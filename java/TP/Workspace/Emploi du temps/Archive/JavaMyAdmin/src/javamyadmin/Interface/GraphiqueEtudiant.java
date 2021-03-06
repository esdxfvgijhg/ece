package javamyadmin.Interface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
import javamyadmin.Model.*;
import javamyadmin.Data.ServiceEmploi;

public class GraphiqueEtudiant extends JFrame implements ActionListener {

		JTextField id_etudiant;
		JTextField name;
		JTextField firstname;

    JButton enregistrer;
    JButton annuler;
		ServiceEmploi service;

    public GraphiqueEtudiant (ServiceEmploi service){
        
				this.service=service;
				setTitle("Nouveau Etudiant");
				setBounds(200, 200,270, 290);
				setVisible(true);

        JLabel etudiant = new JLabel("Etudiant");
        id_etudiant = new JTextField(10);

        JLabel nom = new JLabel("Nom");  
        name = new JTextField(10);

        JLabel prenom = new JLabel("Prenom");  
        firstname = new JTextField(10);
 
        enregistrer = new JButton("Enregistrer");
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

        add(id_etudiant,gbc,jp,2,0,1,1);
        add(name,gbc,jp,2,1,1,1);
        add(firstname,gbc,jp,2,2,1,1);

        add(etudiant,gbc,jp,0,0,1,1);
        add(nom,gbc,jp,0,1,2,1);
        add(prenom,gbc,jp,0,2,1,1);

				JPanel jp2 = new JPanel();
				jp2.add (enregistrer);
				jp2.add (annuler);

				getContentPane().add (jp2, BorderLayout.SOUTH);
				
 }

    public void actionPerformed(ActionEvent e){
    	Object source = e.getSource();
    	if (source==enregistrer)
				try{
					EmploiDuTemps emploi = new EmploiDuTemps();
					emploi.setId((String)id_etudiant.getText().trim());
					emploi.setClasse((String)name.getText().trim());
					service.addEmploi(emploi);
				}catch(Exception ex){
					JOptionPane.showMessageDialog(this,ex.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);					
				}
    	else if (source==annuler)
				setVisible(false);
    }
    
	public void add (Component c, GridBagConstraints gbc,JPanel jp, int x, int y, int w, int h){
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = w;
		gbc.gridheight = h;
		jp.add(c,gbc);
	}
}
