package persistence;

import persistenceDAO.ArtistaDAO;
import persistenceDAO.BranoDAO;
import persistenceDAO.PlaylistDAO;
import persistenceDAO.UtenteDAO;

public class SqlServerDAOFactory extends DAOFactory {
	
	private static DataSource datasource;
	
	static{
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			datasource= new DataSource("jdbc:mysql://vps411786.ovh.net:3306;databaseName=falbomusic", "falbomusic", "famu");
			
		} catch (Exception e) {
			System.err.println("SqlServerDAOFactory.class: failed to load sql server JDBC driver\n"+e);
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