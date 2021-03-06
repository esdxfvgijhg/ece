/*
#	Le livre de Java 1er langage
#	A. Tasso
#	Chapitre 10 : Collectionner un nombre ind�termin� d'objets
#	Section  : Les fichiers d'objets
#	Fichier  : GestionClasse.java
#	Class    : GestionClasse
*/

import java.io.*;
public class GestionClasse  {
 public static void main (String [] argument) throws IOException, ClassNotFoundException {
	byte choix = 0 ;
	Classe C = new Classe();
	FichierEtudiant F = new FichierEtudiant();
 	F.ouvrir("L");
 	C = F.lire();
 	F.fermer();
 
	

	String pr�nom, nom;
	do {
	  choix = menuPrincipal();
	  switch (choix) {
		case 1 :		C.ajouteUnEtudiant();
		break;
		case 2 :
			System.out.print("Entrer le prenom de l'�tudiant a supprimer ");
			pr�nom = Lire.S();
			System.out.print("Entrer le nom de l'�tudiant a supprimer ");
			nom = Lire.S();
			C.supprimeUnEtudiant(pr�nom, nom);
		break;
		case 3 :		C.afficheLesEtudiants(); 
		break;
		case 4 :
			System.out.print("Entrer le prenom de l'�tudiant recherche ");
			pr�nom = Lire.S();
			System.out.print("Entrer le nom de l'�tudiant recherche ");
			nom = Lire.S();
			C.rechercheUnEtudiant(pr�nom, nom);
		break;
		case 5 : //option 5,  le programme termine son ex�cution
			System.out.println("Sauvegarde des donn�es dans Classe.dat");	
			F.ouvrir("Ecriture"); 
			F.ecrire(C);
			F.fermer();
			sortir();    
		break;
		default : System.out.println("Cette option n'existe pas ");
	 }
  } while (choix != 5);
 }
 public static byte menuPrincipal() {
	byte tmp;
	System.out.println("1. Ajoute un etudiant");
	System.out.println("2. Supprime un etudiant");
	System.out.println("3. Affiche la classe");
	System.out.println("4. Affiche un etudiant");
	System.out.println("5. Sortir");
	System.out.println();
	System.out.print("Votre choix : ");
	tmp  = Lire.b();
	return tmp;
 }
 public static void sortir( ) {
	System.out.println("Au revoir et � bient�t");
	System.exit(0) ;
 }
}