package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Playlist;
import model.Utente;
import persistenceDAO.PlaylistDAO;

public class PlaylistDaoJDBC implements PlaylistDAO {
	
	DataSource datasource;
	
	public PlaylistDaoJDBC(DataSource datasource){
		this.datasource=datasource;
	}

	@Override
	public Playlist getPlaylistByNome(String nome) {
		
		Connection connection= datasource.getConnection();
		
		Playlist playlist= new Playlist();
		
		try {
			String query = ""
					+ "SELECT * "
					+ "FROM playlist "
					+ "WHERE nome = ?";
			
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, nome);
		
		ResultSet resultset = statement.executeQuery();
		
		if(resultset.next())
		  {
			playlist.setNomePlaylist(resultset.getString("nome"));
			playlist.setProprietario(resultset.getString("proprietario"));
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
		
		return playlist;
	}

	@Override
	public List<Playlist> getPlaylistByUtente(String username) {

		Connection connection= datasource.getConnection();
		
		List<Playlist> playlists= null;
		
		
		try{
			
			String query = ""
					+ "SELECT * "
					+ "FROM playlist "
					+ "WHERE proprietario=?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, username);
			ResultSet resultset = statement.executeQuery();
			
			if(resultset.next()){
				playlists=new ArrayList<Playlist>();
			
				do{
					playlists.add(new Playlist(resultset.getString(1),resultset.getString(2)));
				}while(resultset.next());
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
		return playlists;	
	}

	@Override
	public int newPlaylist(Playlist playlist) {
		
		Connection connection = this.datasource.getConnection();

		try{		
											
			String insert ="INSERT INTO playlist (nome, utente) "
					+ " VALUES (?,?)";

			PreparedStatement statement =connection.prepareStatement(insert);
			statement.setString(1, playlist.getNomePlaylist());
			statement.setString(2, playlist.getProprietario());

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
	public int addBranoPlaylist(int brano, String playlist) {
		
		Connection connection = this.datasource.getConnection();

		try{		
											
			String insert ="INSERT INTO branoplaylist (brano, playlist) "
					+ " VALUES (?,?)";

			PreparedStatement statement =connection.prepareStatement(insert);
			statement.setInt(1, brano);
			statement.setString(2, playlist);

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
	public int delBranoPlaylist(int brano, String playlist) {
		
		Connection connection = this.datasource.getConnection();

		try{		
											
			String delete ="DELETE FROM branoplaylist  "
						+ " WHERE brano=? and playlist='?'";

			PreparedStatement statement =connection.prepareStatement(delete);
			statement.setInt(1, brano);
			statement.setString(2, playlist);

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

}
