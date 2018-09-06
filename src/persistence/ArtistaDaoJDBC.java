package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Artista;
import persistence.DataSource;
import persistenceDAO.ArtistaDAO;

public class ArtistaDaoJDBC implements ArtistaDAO {
	
	DataSource datasource;
	
	public ArtistaDaoJDBC(DataSource datasource){		
		this.datasource=datasource;	
	}
	
	
	@Override
	public Artista getArtistaByAlias(String alias){
		
		Connection connection= datasource.getConnection();
		
		Artista artista= new Artista();
		
		try {
			String query = ""
					+ "SELECT * "
					+ "FROM artista "
					+ "WHERE alias LIKE '%?%'";
			
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, alias);
		
		ResultSet resultset = statement.executeQuery();
		
		if(resultset.next())
		{
			artista.setIdArtista(resultset.getInt("idArtista"));
			artista.setNome(resultset.getString("nome"));
			artista.setCognome(resultset.getString("cognome"));
			artista.setAlias(resultset.getString("alias"));
			artista.setNazionalita(resultset.getString("nazionalita"));
			artista.setLinkImg(resultset.getString("linkImg"));
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
		
		return artista;

	}
	@Override
	public List<Artista> getArtistaByIdBrano(int idBrano){
		
		Connection connection= datasource.getConnection();
		
		List<Artista> artisti= null;
		
		try {
			String query = ""
					+ "SELECT * "
					+ "FROM cantare "
					+ "WHERE artista=idArtista and brano=?";
			
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, idBrano);
		
		ResultSet resultset = statement.executeQuery();
		
		if(resultset.next()){
			artisti=new ArrayList<Artista>();
		
			do{
				artisti.add(new Artista(resultset.getInt(1), resultset.getString(2), resultset.getString(3), resultset.getString(4), resultset.getString(5), resultset.getString(6)));
				
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
		return artisti;
	}
	
	 public List<Artista> getArtisti(){
		 Connection connection= datasource.getConnection();
			
			List<Artista> artisti= null;
			
			try {
				String query = ""
						+ "SELECT * "
						+ "FROM artista "
						+  " ";
				
			PreparedStatement statement = connection.prepareStatement(query);
			
			
			ResultSet resultset = statement.executeQuery();
			
			if(resultset.next()){
				artisti=new ArrayList<Artista>();
			
				do{
					artisti.add(new Artista(resultset.getInt(1), resultset.getString(2), resultset.getString(3), resultset.getString(4), resultset.getString(5), resultset.getString(6)));
					
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
			return artisti;
		}	 
	 

}
