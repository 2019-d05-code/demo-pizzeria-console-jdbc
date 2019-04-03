package DAO;



import java.sql.SQLException;
import java.util.List;

import fr.pizzeria.model.Pizza;

public interface IPizzaDAO {
	List<Pizza> findAllPizzas();
	void saveNewPizza (Pizza pizza) throws SQLException;
	void updatePizza (String codePizza, Pizza pizza) throws SQLException;
	void deletePizza (String codePizza) throws SQLException;
	Pizza findPizzaByCode(String codePizza) throws SQLException;

}
