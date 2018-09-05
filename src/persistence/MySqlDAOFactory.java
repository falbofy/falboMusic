package persistence;

import persistenceDAO.ArtistaDAO;
import persistenceDAO.BranoDAO;
import persistenceDAO.PlaylistDAO;
import persistenceDAO.UtenteDAO;

public class MySqlDAOFactory extends DAOFactory {
	
	private static DataSource datasource;
	
	static{
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			datasource= new DataSource("jdbc:mysql://vps411786.ovh.net:3306/falbomusic?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "falbomusic", "1q2w3e4r");		

		} catch (Exception e) {
			
			System.err.println("MySQLDAOFactory.class: failed to load sql server JDBC driver\n"+e);
			e.printStackTrace();

		}
	}

	@Override
	public ArtistaDAO getArtistaDAO() {
      return new ArtistaDaoJDBC(datasource);	
	}

	@Override
	public BranoDAO getBranoDAO() {
		return new BranoDaoJDBC(datasource);
	}

	@Override
	public PlaylistDAO getPlaylistDAO() {
		return new PlaylistDaoJDBC(datasource);
	}

	@Override
	public UtenteDAO getUtenteDAO() {
		return new UtenteDaoJDBC(datasource);
	}
}