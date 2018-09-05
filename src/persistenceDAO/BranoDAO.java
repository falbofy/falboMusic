package persistenceDAO;
import model.Brano;

import java.util.HashMap;
import java.util.List;


public interface BranoDAO {

	public Brano getBranoById(int id);
	public List<Brano> getBraniByTitolo(String titolo);
	public List<Brano> getBraniByArtista(String artista);
	public List<Brano> getBraniByGenere(String genere);
	public List<Brano> getPreferitibyUtente(String utente);
	public List<Brano> getAscoltibyUtente(String utente);
	public List<Brano> getBraniByPlaylist(String playlist);
	
	public int insBrano(Brano brano);
	
	//questi vanno qui?
	public int addAscolto(int brano, String Utente);
	public int addPreferito(int brano, String Utente);
	public int delPreferito(String utente, int brano);
	
	public HashMap<Integer,String> getAscoltiByUsername(String username);
	
	
	
	
	
}
