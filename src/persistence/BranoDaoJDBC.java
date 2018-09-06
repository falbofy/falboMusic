package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Ascolto;
import model.Brano;
import model.Utente;
import persistenceDAO.BranoDAO;

public class BranoDaoJDBC implements BranoDAO {

	DataSource datasource;
	
	public BranoDaoJDBC (DataSource datasource){
		this.datasource=datasource;
	}
	
	@Override
	public HashMap<Integer,String> getAscoltiByUsername(String username){
	
		Connection connection = this.datasource.getConnection();
		HashMap<Integer,String> mappaAscolti= null;
		
		try {
			String query = ""
					+ "SELECT * "
					+ "FROM ascoltare "
					+ "WHERE utente=? and brano=?";
			
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, username);
		
		ResultSet resultset = statement.executeQuery();
		
		if(resultset.next()){
			mappaAscolti=new HashMap<Integer,String>();
		
			do{
				mappaAscolti.put(resultset.getInt(3), resultset.getString(2));
				
			}while(resultset.next());
		  } //fine if
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
		return mappaAscolti;
	}
	
	@Override
	public int addAscolto(int brano, String utente){

		Connection connection = this.datasource.getConnection();

		try{	
			String queryverifica = ""
					+ "SELECT * "
					+ "FROM ascoltare "
					+ "WHERE brano =? and utente=?";
			//System.out.println("queri verifica"+queryverifica);
		PreparedStatement verificaStatement = connection.prepareStatement(queryverifica);
		verificaStatement.setInt(1, brano);
		verificaStatement.setString(2, utente);
		
		ResultSet resultset = verificaStatement.executeQuery();
		
		if(resultset.next())
		  {
			int qnt= resultset.getInt("qnt");
			qnt++;
			System.out.println("qnt"+qnt);
			String update ="UPDATE ascoltare "
						+  "SET qnt = ? "
						+  "WHERE utente = ? and brano=?;";

			PreparedStatement statement =connection.prepareStatement(update);
			statement.setInt(1, qnt);
			statement.setString(2, utente);
			statement.setInt(3, brano);
			
			System.out.println("update qnt"+statement);
			return statement.executeUpdate();
			
		  }else{
			 
			  String insert ="INSERT INTO ascoltare (utente, brano, qnt) "
						+ " VALUES (?,?,?)";
			  	
				PreparedStatement statement =connection.prepareStatement(insert);
				statement.setString(1, utente);
				statement.setInt(2, brano);
				statement.setInt(3, 1);
				//System.out.println("queri di add ascolto"+statement);
				return statement.executeUpdate();
			
		  }
									
			
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
	public int addPreferito(int brano, String utente) {

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
						+  " WHERE utente=? and brano=?";

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
	
	@Override
	public int insBrano(Brano brano) {

		Connection connection = this.datasource.getConnection();

		try{		
											
			String insert ="INSERT INTO brano (idBrano, titolo, durata, uscita, linkVideo, linkImg, genere) "
					+ " VALUES (?,?,?,?,?,?,?)";

			PreparedStatement statement =connection.prepareStatement(insert);
			statement.setInt(1, brano.getIdBrano());
			statement.setString(2, brano.getTitolo());
			statement.setFloat(3, brano.getDurata());
			statement.setString(4, brano.getUscita());
			statement.setString(5, brano.getLinkVideo());
			statement.setString(6, brano.getLinkImg());
			statement.setString(7, brano.getGenere());
			


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
	public Brano getBranoById(int id) {

		Connection connection= datasource.getConnection();
		Brano brano= new Brano();
		
		try {
			String query = ""
					+ "SELECT * "
					+ "FROM brano "
					+ "WHERE id =?";
			
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, id);
		
		ResultSet resultset = statement.executeQuery();
		
		if(resultset.next())
		  {
			brano.setIdBrano(resultset.getInt("idBrano"));
			brano.setTitolo(resultset.getString("titolo"));
			brano.setDurata(resultset.getInt("durata"));
			brano.setGenere(resultset.getString("genere"));
			brano.setLinkImg(resultset.getString("linkImg"));
			brano.setLinkVideo(resultset.getString("linkVideo"));
			brano.setUscita(resultset.getString("uscita"));
			
			//brano.setArtista(resultset.getString("artista"));	
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
		return brano;
	}

	@Override
	public List<Brano> getBraniByTitolo(String titolo) {
		Connection connection= datasource.getConnection();
		
		List<Brano> brani= null;
		
		try {
			String query = ""
					+ "SELECT * "
					+ "FROM brano "
					+ "WHERE titolo like %?%'";
			
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, titolo);
		
		ResultSet resultset = statement.executeQuery();
		
		if(resultset.next()){
			brani=new ArrayList<Brano>();
		
			do{
				brani.add(new Brano(resultset.getInt(1), resultset.getString(2), resultset.getInt(3), resultset.getString(4), resultset.getString(5), resultset.getString(6), resultset.getString(7)));
			
			}while(resultset.next());
		  } //fine if
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
		return brani;
	}

	@Override
	public List<Brano> getBraniByArtista(String artista) {
		Connection connection= datasource.getConnection();
		
		List<Brano> brani= null;
		
		try {
			String query = ""
					+ "SELECT * "
					+ "FROM brano as br "
					+ "WHERE br.idBrano IN 	SELECT ca.brano	 	 	"
					+ "					 	FROM   cantare as ca	"
					+ "					 	WHERE  ca.artista=?	";
			
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, artista);
		
		ResultSet resultset = statement.executeQuery();
		
		if(resultset.next()){
			brani=new ArrayList<Brano>();
		
			do{
				brani.add(new Brano(resultset.getInt(1), resultset.getString(2), resultset.getInt(3), resultset.getString(4), resultset.getString(5), resultset.getString(6), resultset.getString(7)));
			
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
		return brani;
	}

	@Override
	public List<Brano> getBraniByGenere(String genere) {
		Connection connection= datasource.getConnection();
		
		List<Brano> brani= null;
		
		try {
			String query = ""
					+ "SELECT * "
					+ "FROM brano "
					+ "WHERE genere=?";
			
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, genere);
		
		ResultSet resultset = statement.executeQuery();
		
		if(resultset.next()){
			brani=new ArrayList<Brano>();
		
			do{
				brani.add(new Brano(resultset.getInt(1), resultset.getString(2), resultset.getInt(3), resultset.getString(4), resultset.getString(5), resultset.getString(6), resultset.getString(7)));
			
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
		return brani;
	}

	@Override
	public List<Brano> getPreferitibyUtente(String utente) {
		Connection connection= datasource.getConnection();
		
		List<Brano> brani= null;
		
		try {
			String query = ""
					+ "SELECT * "
					+ "FROM brano as br "
					+ "WHERE br.idBrano IN 	SELECT pr.brano	 	 	"
					+ "					 	FROM   preferiti as pr	"
					+ "					 	WHERE  pr.utente=?	";
			
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, utente);
		
		ResultSet resultset = statement.executeQuery();
		
		if(resultset.next()){
			brani=new ArrayList<Brano>();
		
			do{
				brani.add(new Brano(resultset.getInt(1), resultset.getString(2), resultset.getInt(3), resultset.getString(4), resultset.getString(5), resultset.getString(6), resultset.getString(7)));
			
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
		return brani;
	}

	@Override
	public List<Brano> getAscoltibyUtente(String utente) {
		Connection connection= datasource.getConnection();
		
		List<Brano> brani= null;
		
		try {
			String query = ""
					+ "SELECT * "
					+ "FROM brano as br "
					+ "WHERE br.idBrano IN 	SELECT ascolta.brano	 	"
					+ "					 	FROM   ascolta				"
					+ "					 	WHERE  ascolta.utente=?	";
			
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, utente);
		
		ResultSet resultset = statement.executeQuery();
		
		if(resultset.next()){
			brani=new ArrayList<Brano>();
		
			do{
				brani.add(new Brano(resultset.getInt(1), resultset.getString(2), resultset.getInt(3), resultset.getString(4), resultset.getString(5), resultset.getString(6), resultset.getString(7)));
			
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
		return brani;
	}

	@Override
	public List<Brano> getBraniByPlaylist(String playlist) {
		Connection connection= datasource.getConnection();
		
		List<Brano> brani= null;
		
		try {
			String query = ""
					+ "SELECT * "
					+ "FROM brano as br "
					+ "WHERE br.idBrano IN 	SELECT bp.brano	 	 		"
					+ "					 	FROM   branoplaylist as bp	"
					+ "					 	WHERE  bp.playlist=?		";
			
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, playlist);
		
		ResultSet resultset = statement.executeQuery();
		
		if(resultset.next()){
			brani=new ArrayList<Brano>();
		
			do{
				brani.add(new Brano(resultset.getInt(1), resultset.getString(2), resultset.getInt(3), resultset.getString(4), resultset.getString(5), resultset.getString(6), resultset.getString(7)));
			
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
		return brani;
	}

	public List<Brano> getUtimiBraniInseriti(){
		Connection connection= datasource.getConnection();
		
		List<Brano> brani= null;
		
		try {
			String query = ""
					+ "SELECT * "
					+ "FROM brano as br "
					+ "order by br.idBrano DESC	";
			
		PreparedStatement statement = connection.prepareStatement(query);
		
		ResultSet resultset = statement.executeQuery();
		
		if(resultset.next()){
			brani=new ArrayList<Brano>();
		
			do{
				brani.add(new Brano(resultset.getInt(1), resultset.getString(2), resultset.getInt(3), resultset.getString(4), resultset.getString(5), resultset.getString(6), resultset.getString(7)));
			
			}while(resultset.next() );
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
		return brani;
	}
	
	public List<Brano> getBrani() {
		Connection connection= datasource.getConnection();
		
		List<Brano> brani= null;
		
		try {
			String query = ""
					+ "SELECT * "
					+ "FROM brano  "
					+ " ";
			
		PreparedStatement statement = connection.prepareStatement(query);

		
		ResultSet resultset = statement.executeQuery();
		
		if(resultset.next()){
			brani=new ArrayList<Brano>();
		
			do{
				brani.add(new Brano(resultset.getInt(1), resultset.getString(2), resultset.getInt(3), resultset.getString(4), resultset.getString(5), resultset.getString(6), resultset.getString(7)));
			
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
		return brani;
	}


	
}
