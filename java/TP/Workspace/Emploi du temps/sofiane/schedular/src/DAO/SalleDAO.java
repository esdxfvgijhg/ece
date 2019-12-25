/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Salle;
import Interfaces.ISalleDAO;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hajji
 */
public class SalleDAO implements ISalleDAO {

    private Connection connection;

    private SalleDAO() {
        connection = DataSource.getInstance().getConnection();
    }
    private static ISalleDAO iSalleDAO;

    public static ISalleDAO getInstance() {
        if (iSalleDAO == null) {
            iSalleDAO = new SalleDAO();
        }
        return iSalleDAO;
    }
    @Override
    public boolean insertSalle(Salle s) {
        String requete = "insert into salle (id,libelle,type,successeur,predecesseur,capacite) values (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, s.getId());
            ps.setString(2, s.getLibelle());
            ps.setString(3, s.getType());
            ps.setInt(4, s.getSuccesseur().getId());
            ps.setInt(5, s.getPredecesseur().getId());
            ps.setInt(6,s.getCapacite());
            ps.executeUpdate();
            System.out.println("Ajout salle effectuée avec succès");
            return true;
        } catch (SQLException ex) {
            System.out.println("erreur lors de l'insertion de la salle " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateSalle(Salle s) {
        String requete = "update salle set  libelle=?, type=?, successeur=?, predecesseur=?, capacite=? where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);

            ps.setString(1, s.getLibelle());
            ps.setString(2, s.getType());
            ps.setInt(3, s.getSuccesseur().getId());
            ps.setInt(4, s.getPredecesseur().getId());
            ps.setInt(5,s.getCapacite());
            ps.setInt(6, s.getId());
            ps.executeUpdate();
            System.out.println("Mise à jour salle effectuée avec succès");
            return true;
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour salle " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteSalleById(int id) {
        String requete = "delete from salle where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Suppression salle effectuée avec succès");
            return true;
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression salle " + ex.getMessage());
            return false;
        }
    }

    @Override
    public Salle findSalleById(int id) {
        Salle s = new Salle();
        String requete = "select * from salle where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                s.setId(resultat.getInt(1));
                s.setType(resultat.getString(2));
                s.setLibelle(resultat.getString(3));
                Salle succ=SalleDAO.getInstance().findSalleById(resultat.getInt(4));
                s.setSuccesseur(succ);
                Salle pred=SalleDAO.getInstance().findSalleById(resultat.getInt(5));
                s.setPredecesseur(pred);
                s.setCapacite(resultat.getInt(6));
            }
            return s;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche de etudiant par id " + ex.getMessage());
            return null;
        }
    }

    @Override
    public Salle findSalleByLibelle(String libelle) {
        Salle s = new Salle();
        String requete = "select * from salle where libelle=?";
        try {
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, libelle);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                s.setId(resultat.getInt(1));
                s.setType(resultat.getString(2));
                s.setLibelle(resultat.getString(3));
                Salle succ=SalleDAO.getInstance().findSalleById(resultat.getInt(4));
                s.setSuccesseur(succ);
                Salle pred=SalleDAO.getInstance().findSalleById(resultat.getInt(5));
                s.setPredecesseur(pred);
                s.setCapacite(resultat.getInt(6));
            }
            return s;

        } catch (SQLException ex) {
            System.out.println("erreur lors de la recherche de etudiant par libelle " + ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Salle> displayAllSalle() {
        List<Salle> listeSalle = new ArrayList<Salle>();
        String requete = "select * from salle";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Salle s = new Salle();
                s.setId(resultat.getInt(1));
                s.setType(resultat.getString(2));
                s.setLibelle(resultat.getString(3));
                Salle succ=SalleDAO.getInstance().findSalleById(resultat.getInt(4));
                s.setSuccesseur(succ);
                Salle pred=SalleDAO.getInstance().findSalleById(resultat.getInt(5));
                s.setPredecesseur(pred);
                s.setCapacite(resultat.getInt(6));

                listeSalle.add(s);
            }
            return listeSalle;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des salles " + ex.getMessage());
            return null;
        }
    }
    
}
