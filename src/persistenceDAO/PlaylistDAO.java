package persistenceDAO;

import java.util.List;

import model.Playlist;
import model.Utente; 

public interface PlaylistDAO {
	
public Playlist getPlaylistByNome(String nome);
public List<Playlist> getPlaylistByUtente(String utente);

public int newPlaylist(Playlist playlist);
public int addBranoPlaylist(int brano, String playlist);
public int delBranoPlaylist(int brano, String playlist);

}
