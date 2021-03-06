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
import javamyadmin.Service.ServiceEmploi;

public class GraphiqueSeance extends JFrame implements ActionListener {

		JTextField id_sceance;
		JComboBox id_module;
		JComboBox id_emploi;
		JTextField date_sceance;
		JTextField time_sceance;
		ServiceEmploi service;

    JButton enregistrer;
    JButton annuler;

    public GraphiqueSeance(ServiceEmploi service){
        
				this.service=service;
				setTitle("Nouvelle seance");
				setBounds(200, 200,270, 290);
				setVisible(true);

        JLabel seance = new JLabel("seance");
        id_sceance = new JTextField(10);
        
        JLabel module = new JLabel("module");
				String vmodule[] = {"module1","module2"};
        id_module = new JComboBox(vmodule);   

        JLabel emploi = new JLabel("emploi");
				String vemploi[] = {"emploi1","emploi2"};
        id_emploi = new JComboBox(vemploi);    

        JLabel dsceance = new JLabel("date");
        date_sceance = new JTextField(10);

        JLabel hsceance = new JLabel("heure");
        time_sceance = new JTextField(10);
 
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
        
        add(id_sceance,gbc,jp,2,0,1,1);
        add(id_module,gbc,jp,2,1,2,1);
        add(id_emploi,gbc,jp,2,2,2,1);
        add(date_sceance,gbc,jp,2,3,1,1);
        add(time_sceance,gbc,jp,2,4,1,1); 

        add(seance,gbc,jp,0,0,1,1);
        add(module,gbc,jp,0,1,2,1);
        add(emploi,gbc,jp,0,2,2,1);
        add(dsceance,gbc,jp,0,3,1,1);
        add(hsceance,gbc,jp,0,4,1,1);

				JPanel jp2 = new JPanel();
				jp2.add (enregistrer);
				jp2.add (annuler);

				getContentPane().add (jp2, BorderLayout.SOUTH);
				
 }

    public void actionPerformed(ActionEvent e){
    	Object source = e.getSource();
    	if (source==enregistrer){
    		SimpleDateFormat formatterDate = new SimpleDateFormat("yy/MM/dd");
				SimpleDateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");
				Module module = new Module();
				module.setName((String)id_module.getSelectedItem());
				module.setId((String)id_module.getSelectedItem());
				Sceance sceance = new Sceance();
				sceance.setId(id_sceance.getText().trim());
				sceance.setIdEmploi((String)id_emploi.getSelectedItem());
				sceance.setModule(module);
				try{
				sceance.setDate(formatterDate.parse(date_sceance.getText().trim()));
				sceance.setTime(formatterTime.parse(time_sceance.getText().trim()));
				}catch(Exception exp){}
				
				service.addSceance(sceance);
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
}
