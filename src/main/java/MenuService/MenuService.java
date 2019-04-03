package MenuService;

import java.sql.SQLException;
import java.util.Scanner;

import DAO.PizzaBddDao;
import fr.pizzeria.exception.StockageException;

public abstract class MenuService {
	
	public abstract void executeUC(Scanner scanner, PizzaBddDao dao) throws StockageException, SQLException;
}
