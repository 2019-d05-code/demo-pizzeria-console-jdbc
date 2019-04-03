package MenuService;

import java.sql.SQLException;
import java.util.Scanner;

import DAO.PizzaBddDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.ListeCodesPostaux;
import fr.pizzeria.model.Pizza;
import utils.NumberUtils;

public class AjouterPizzaService extends MenuService {
	
	public void executeUC(Scanner questionMenu, PizzaBddDao toto) throws StockageException, SQLException {
		// TODO Auto-generated method stub
		System.out.println("Ajout d'une nouvelle pizza");
		// Il va falloir cr�er une pizza
		// D'abord on r�cup�re les nos de pizza et les code
		System.out.println("Un nom pour cette pizza ?");
		String nomPizza = questionMenu.nextLine();

		System.out.println("Ecrivez également un raccourci de 3 lettres");
		String raccourci = questionMenu.nextLine();
		
		System.out.println(
				"Quel type voulez-vous pour votre pizza ?");
		System.out.println("Tapez 1 pour une pizza à la viande");
		System.out.println("Tapez 2 pour une pizza au poisson");
		System.out.println("Tapez 3 pour une pizza végétarienne");
		String questionTypeSrt = questionMenu.nextLine();

		if (NumberUtils.isNumber(questionTypeSrt) == false) {
			throw new StockageException("Ceci n'est pas un numéro, doofus");
		}
		if (!(questionTypeSrt.equals("1") || questionTypeSrt.equals("2") || questionTypeSrt.equals("3"))) {
			throw new StockageException("Vous n'avez pas tap� le bon choix");
		}

		System.out.println("A combien voulez-vous vendre cette pizza ? (indiquez un prix sans les euros)");
		String prixStr = questionMenu.nextLine();
		double prix = Double.parseDouble(prixStr);
		
		CategoriePizza categorie = CategoriePizza.Viande;
		if (questionTypeSrt.equals("1")) {
			categorie = CategoriePizza.Viande;
		} else if (questionTypeSrt.equals("2")) {
			categorie = CategoriePizza.Poisson;
		} else if (questionTypeSrt.equals("3")) {
			categorie = CategoriePizza.Végétarienne;
		}

		// Définition de la nouvelle pizza
		Pizza nvpizza = new Pizza(raccourci, nomPizza, categorie, prix);
		toto.saveNewPizza(nvpizza);
		System.out.println("Votre pizza a bien été ajoutée");
	}
}
