package fr.pizzeria.console;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

import DAO.PizzaBddDao;
import MenuService.AjouterPizzaService;
import MenuService.ListerPizzasService;
import MenuService.ModifierPizzaService;
import MenuService.SupprimerPizzaService;
import fr.pizzeria.exception.DataAccessException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) throws SQLException, StockageException {

		new Driver();
		
		PizzaBddDao dao = new PizzaBddDao();
		Scanner questionMenu = new Scanner(System.in);

		int cpt = 8;

		// Afficher les options du menu
		System.out.println("***** Pizzeria Administration*****");
		System.out.println("1. Lister les pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");

		boolean fin = false;
		while (fin == false) {

			// On demande quelle action l'utilisateur veut faire
			System.out.println("Menu principal. Veuillez faire votre choix");

			String z = questionMenu.nextLine();
			int question = Integer.parseInt(z);
			try {
			if (question != 99) {
				fin = false;
				switch (question) {
				case 1:
					ListerPizzasService liste = new ListerPizzasService();
					liste.executeUC(questionMenu, dao);

					break;
				case 2:
					AjouterPizzaService ajout = new AjouterPizzaService();
					
						ajout.executeUC(questionMenu, dao);
					

					break;
				case 3:
					ModifierPizzaService modif = new ModifierPizzaService();
					
						modif.executeUC(questionMenu, dao);
					
					break;
				case 4:
					SupprimerPizzaService suppression = new SupprimerPizzaService();
					suppression.executeUC(questionMenu, dao);
					break;

				default:
					System.out.println("Je n'ai pas compris votre choix, merci de réessayer");

				}

			} else

			{
				System.out.println("Au revoir !");
				fin = true;
			}
			
			} catch (StockageException | DataAccessException e) {
				System.out.println(e.getMessage());
			}
		}
		questionMenu.close();

	}
}
