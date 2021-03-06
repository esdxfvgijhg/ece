package DAO;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import javax.swing.JOptionPane;

import BDD.Section;
import IDAO.ISectionDAO;
import SQL.DB;
import SQL.SQL;

public class SectionDAO implements ISectionDAO {
	
    private DB db;
	private SQL queryString = new SQL();
	private SimpleDateFormat formatterDate = new SimpleDateFormat("yy-MM-dd");

    private SectionDAO() {
    	db = DB.getInstance();
    }
    private static ISectionDAO iSectionDAO;

    public static ISectionDAO getInstance() {
        if (iSectionDAO == null) {
            iSectionDAO = new SectionDAO();
        }
        return iSectionDAO;
    }
	
	public Stream<Section> getAllSection(){
		List<Section> listPromo = new ArrayList<Section>();
		try{
			String[] table = { "Section" };
			String t = queryString.Query_Select(table, sectionAtt, "");
			ResultSet result = db.Get_DB(t);
			while (result.next()) {
				Section promo = new Section();
				promo.setIdSection(result.getInt(1));
				promo.setAnnee((Date) formatterDate.parse(result.getString(2)));
				listPromo.add(promo);
			}
		}catch(Exception x){
			JOptionPane.showMessageDialog(null,x.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
		}
		return listPromo.stream();
	}

	public Section getSectionById(Integer idSection) throws Exception{
		Section section = new Section();
		String[] table = { "Section" };
		String t = queryString.Query_Select(table, sectionAtt, "idSection = '"+idSection+"'");
		ResultSet result = db.Get_DB(t);
		while (result.next()) {
			section.setIdSection(result.getInt(1));
			section.setAnnee((Date) formatterDate.parse(result.getString(2)));
		}
		
		return section;
	}
	
	public Stream<Integer> getIdSection(){
		List<Integer> listPromo = new ArrayList<Integer>();
		try{
			String[] table = { "Section" };
			String[] champ = { "idSection" };
			String t = queryString.Query_Select(table, champ, "");
			ResultSet result = db.Get_DB(t);
			while (result.next()) 
				listPromo.add(result.getInt(1));
		}catch(Exception x){
			JOptionPane.showMessageDialog(null,x.getMessage(),"Erreur",JOptionPane.ERROR_MESSAGE);
		}
		return listPromo.stream();
	}
	
	public void ajouterSection(Section section) throws Exception {
		String t = queryString.Query_Insert("Section", sectionAtt, sectionVal(section));
		if (db.Execute_DB(t)) System.out.println("Ok!");
	}

	public boolean supprimerSection(Section Section) throws Exception {
		String condition = "idSection = '" + Section.getIdSection() + "'";
		String t = queryString.Query_Delete("Section", condition);
		return (db.Execute_DB(t));
	}

	public void modifierSection(Section section) throws Exception {
		String condition = "idSection = '" + section.getIdSection() + "'";
		String t = queryString.Query_Update("Section", sectionAtt, sectionVal(section), condition);
		if (db.Execute_DB(t)) System.out.println("Ok!");
	}
	
	private String[] sectionAtt = { "idSection","annee" };
	private String[] sectionVal(Section section) {
		String[] res = new String[2];
		res[0] = section.getIdSection().toString();
		res[1] = formatterDate.format(section.getAnnee());
		return res;
	}
}
