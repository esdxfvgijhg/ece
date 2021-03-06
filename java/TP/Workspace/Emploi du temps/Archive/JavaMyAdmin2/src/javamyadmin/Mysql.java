package javamyadmin;

import java.sql.*;
import javax.swing.*;

public class Mysql {

	private static Connection con;
	private static PreparedStatement st;
	private static ResultSet rs;
	private static String user;
	private static String psw;
	private static Mysql mysql;

	private Mysql(String user,String mdp) throws Exception{
		this.user=user;
		this.psw=mdp;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost",user,mdp);
	}

	public static Mysql getInstance(String user,String psw) throws Exception{
		if (mysql == null)
			mysql = new Mysql(user,psw);
		return mysql;
	}

	public static Connection getConnection(){
		return con;
	}

	public static String[] listData(){
		int i=0;
		String[] tab=new String[10];
		try {
			st=con.prepareStatement("show databases;");
			rs=st.executeQuery();
			if(rs!=null){
				while(rs.next()){
					tab[i]=rs.getString(1);
					i++;
				}
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,e.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
		}
		return tab;
	}
   
	public static void createBase(String  base,String charset){
		try{
			st=con.prepareStatement("create database "+base+" CHARACTER SET "+ charset+" ;");
			int a=st.executeUpdate();
			if(a!=0){
				JOptionPane.showMessageDialog(null,"Base de données cree avec succes");
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,e.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
		}
	}
  
	public static String[] executerSQL(String sql){
		int i=0;
		String[] tab=new String[100];
		try {
			st=con.prepareStatement(sql);
			rs=st.executeQuery();
			if(rs!=null){
				while(rs.next()){
					tab[i]=rs.getString(1);
					i++;
				}
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,e.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
		}
		return tab;
	}

   public static void executer(String sql){
       try{
           st=con.prepareStatement(sql);
           st.executeUpdate(sql);
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,e.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
       }
   }

   public static void supprimer(String sql){
       try{
           st=con.prepareStatement(sql);
           int a=st.executeUpdate();
           if(a!=0){
              JOptionPane.showMessageDialog(null,"Base de données supprimée avec succés"); 
           }
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null,e.getMessage());
       }
   }
   public static void fermerConnexion(){
       try{
           if(con!=null){
               rs.close();
               st.close();
               con.close();
           }
       }catch(Exception e) {
           JOptionPane.showMessageDialog(null,e.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
       }
   }
}
