package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Utente;
import persistenceDAO.UtenteDAO;

public class UtenteDaoJDBC implements UtenteDAO {
	DataSource datasource;
	
	public UtenteDaoJDBC (DataSource datasource){
		this.datasource=datasource;
	}
	
	@Override
	public int delFollowUtente(String segue, String seguito) {

		Connection connection = this.datasource.getConnection();

		try{		

			String insert ="DELETE FROM followutente "
						+  " WHERE segue=? and seguito=?";

			PreparedStatement statement =connection.prepareStatement(insert);
			statement.setString(1, segue);
			statement.setString(2, seguito);

			return statement.executeUpdate();		
			
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}		
	}
	
	@Override
	public int delFollowArtista(String segue, int artista) {

		Connection connection = this.datasource.getConnection();

		try{		

			String insert ="DELETE FROM followartista "
						+  " WHERE segue=? and artista=?";

			PreparedStatement statement =connection.prepareStatement(insert);
			statement.setString(1, segue);
			statement.setInt(2, artista);

			return statement.executeUpdate();		
			
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}		
	}
	
	@Override
	public int addFollowUtente(String segue, String seguito) {

		Connection connection = this.datasource.getConnection();

		try{		

			String insert ="INSERT INTO followutente (segue, seguito) "
					+ " VALUES (?,?)";

			PreparedStatement statement =connection.prepareStatement(insert);
			statement.setString(1, segue);
			statement.setString(2, seguito);

			return statement.executeUpdate();		
			
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}		
	}
	
	
	public int addFollowArtista(String segue, int artista) {

		Connection connection = this.datasource.getConnection();

		try{		

			String insert ="INSERT INTO followartista (segue, artista) "
					+ " VALUES (?,?)";

			PreparedStatement statement =connection.prepareStatement(insert);
			statement.setString(1, segue);
			statement.setInt(2, artista);

			return statement.executeUpdate();		
			
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}		
	}
	
	
	@Override
	public int insUtente(Utente utente) {

		Connection connection = this.datasource.getConnection();

		try{		

			String insert ="INSERT INTO utente (username, password, nome, cognome, abbonamento) "
					+ " VALUES (?,?,?,?,NULL)";

			PreparedStatement statement =connection.prepareStatement(insert);
			statement.setString(1, utente.getUsername());
			statement.setString(2, utente.getPassword());
			statement.setString(3, utente.getNome());
			statement.setString(4, utente.getCognome());
			//statement.setInt(5, utente.getAbbonamento());


			return statement.executeUpdate();		
			
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}		
	}
	
	
	@Override
	public int delUtenteByUsername(String username) {

		Connection connection = this.datasource.getConnection();

		try{		

			String insert ="DELETE FROM utente "
						+  " WHERE username=?";

			PreparedStatement statement =connection.prepareStatement(insert);
			statement.setString(1, username);

			return statement.executeUpdate();		
			
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}		
	}
	
	
	@Override
	public Utente getUtenteByUsername(String username) {
		
		Connection connection= datasource.getConnection();
		
		Utente utente= new Utente();
		System.out.println("---------------------sdbdsfnjwrtjnaerna");
		try {
			String query = ""
					+ "SELECT * "
					+ "FROM utente "
					+ "WHERE username =?";
		

		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, username);
		System.out.println("______________query="+query);
		ResultSet resultset = statement.executeQuery();
		
		if(resultset.next())
		  {
			utente.setUsername(resultset.getString("username"));
			utente.setPassword(resultset.getString("password"));
			utente.setNome(resultset.getString("nome"));
			utente.setCognome(resultset.getString("cognome"));
			utente.setAbbonamento(resultset.getInt("abbonamento"));

		  }
		}
		catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return utente;
	}

	@Override
	public List<Utente> getFollowerByUtente(String utente) {
		Connection connection= datasource.getConnection();
		
		List<Utente> utenti= null;
		
		try {
			String query = ""
					+ "SELECT * "
					+ "FROM followUtente "
					+ "WHERE segue ='?'";
			
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, utente);
		
		ResultSet resultset = statement.executeQuery();
		
		if(resultset.next()){
			utenti=new ArrayList<Utente>();
		
			do{
				utenti.add(new Utente(resultset.getString(1), resultset.getString(2), resultset.getString(3), resultset.getString(4), resultset.getInt(5)));

			}while(resultset.next());
		  } //fine if
		}catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return utenti;
	}

	@Override
	public List<Utente> getSeguitiByUtente(String utente) {
		Connection connection= datasource.getConnection();
		
		List<Utente> utenti= null;
		
		try {
			String query = ""
					+ "SELECT * "
					+ "FROM followUtente "
					+ "WHERE seguito ='?'";
			
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, utente);
		
		ResultSet resultset = statement.executeQuery();
		
		if(resultset.next()){
			utenti=new ArrayList<Utente>();
		
			do{
				utenti.add(new Utente(resultset.getString(1), resultset.getString(2), resultset.getString(3), resultset.getString(4), resultset.getInt(5)));

			}while(resultset.next());
		  } //fine if
		}catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return utenti;
	}

	@Override
	public List<Utente> getFollowerByArtista(String artista) {
		Connection connection= datasource.getConnection();
		
		List<Utente> utenti= null;
		
		try {
			String query = ""
					+ "SELECT * "
					+ "FROM followArtista "
					+ "WHERE artista ='?'";
			
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, artista);
		
		ResultSet resultset = statement.executeQuery();
		
		if(resultset.next()){
			utenti=new ArrayList<Utente>();
		
			do{
				utenti.add(new Utente(resultset.getString(1), resultset.getString(2), resultset.getString(3), resultset.getString(4), resultset.getInt(5)));

			}while(resultset.next());
		  } //fine if
		}catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return utenti;
	}
	
	@Override
	public List<Utente> getArtistiSeguitiByUtente(String utente) {
		Connection connection= datasource.getConnection();
		
		List<Utente> utenti= null;
		
		try {
			String query = ""
					+ "SELECT * "
					+ "FROM followArtista "
					+ "WHERE segue ='?'";
			
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, utente);
		
		ResultSet resultset = statement.executeQuery();
		
		if(resultset.next()){
			utenti=new ArrayList<Utente>();
		
			do{
				utenti.add(new Utente(resultset.getString(1), resultset.getString(2), resultset.getString(3), resultset.getString(4), resultset.getInt(5)));

			}while(resultset.next());
		  } //fine if
		}catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return utenti;
	}
/*
	@Override
	public int addPreferito(String utente, int brano) {
			
		Connection connection = this.datasource.getConnection();

			try{		

				String insert ="INSERT INTO preferiti (utente, brano) "
						+ " VALUES (?,?)";

				PreparedStatement statement =connection.prepareStatement(insert);
				statement.setString(1, utente);
				statement.setInt(2, brano);

				return statement.executeUpdate();		
				
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new PersistenceException(e.getMessage());
				}
			}		
		}
		
	
	@Override
	public int delPreferito(String utente, int brano) {
			
		Connection connection = this.datasource.getConnection();

			try{		

				String delete ="DELETE FROM preferiti "
						+  " WHERE utente='?' and brano=?";

				PreparedStatement statement =connection.prepareStatement(delete);
				statement.setString(1, utente);
				statement.setInt(2, brano);

				return statement.executeUpdate();		
				
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					throw new PersistenceException(e.getMessage());
				}
			}		
		}
*/
	@Override
public boolean login(String user, String pass) {
		
		Connection connection = datasource.getConnection();
		
try{
			
			String query = ""
					+ "SELECT username "
					+ "FROM utente "
					+ "WHERE utente.username=? AND utente.password=?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, user);
			statement.setString(2, pass);
			ResultSet resultset = statement.executeQuery();
			
			if(resultset.next()){
				return true;
			}
			
			return false;
			
		}  catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}

	@Override
	public boolean existsUsername(String username) {
		
		Connection connection = datasource.getConnection();
		
try{
			
			String query = ""
					+ "SELECT username "
					+ "FROM utente "
					+ "WHERE utente.username=?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);

			ResultSet resultset = statement.executeQuery();
			
			if(resultset.next()){
				return true;
			}
			
			return false;
			
		}  catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}

	/*
	@Override
	public void addCredenziali(String user, String pass) {
		
		Connection connection = this.datasource.getConnection();
	
	try{		
		
		
		String insert ="INSERT INTO credenziali (utente, username, password) "
					+ " VALUES (?,?,?)";
		
		PreparedStatement statement =connection.prepareStatement(insert);
		statement.setInt(1, cred.getUtente());
		statement.setString(2, cred.getUsername());
		statement.setString(3, cred.getPassword());
		
		statement.executeUpdate();		
		
	} catch (SQLException e) {
		throw new PersistenceException(e.getMessage());
	} finally {
		try {
			connection.close();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
	}
		
	}*/
	
	
}
