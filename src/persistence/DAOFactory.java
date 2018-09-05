package persistence;

import persistenceDAO.ArtistaDAO;
import persistenceDAO.BranoDAO;
import persistenceDAO.PlaylistDAO;
import persistenceDAO.UtenteDAO;

public abstract class DAOFactory {
		
		public static final int SQLSERVER = 1;		

		public static final int POSTGRESQL = 2;

		public static final int MYSQL = 3;
		
		

		public static DAOFactory getDAOFactory(int which) {
			switch ( which ) {
			
			case SQLSERVER:
				return new SqlServerDAOFactory();
			case POSTGRESQL:
				return null;
			case MYSQL:
				return new MySqlDAOFactory();
			default:
				return null;
			}
		}
		
		// metodi per l'accesso ai DAO
		public abstract ArtistaDAO getArtistaDAO();
		public abstract BranoDAO getBranoDAO();
		public abstract PlaylistDAO getPlaylistDAO();
		public abstract UtenteDAO getUtenteDAO();
		

	
}
