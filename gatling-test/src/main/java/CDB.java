import dao.CompanyDaoImp;
import dao.ComputerDaoImp;
import dao.DaoFactory;
import view.View;

public class CDB {

	public static void main(String[] args) {
		
		/*String name= "MacBook Pro 15.4 inch";
		Timestamp introduction = null;
		Timestamp discontinuation= null;
		int company_id = 1;
		Computer computer = new Computer (name, company_id, discontinuation, introduction);
		
		//List<Company> list= new ArrayList<Company>();*/
		CompanyDaoImp companyDao = new CompanyDaoImp();
		ComputerDaoImp computerDao = new ComputerDaoImp();
		View view = new View(companyDao, computerDao);

	}

}
