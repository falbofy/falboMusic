package persistenceDAO;
import java.util.List;

import model.Utente;

public interface UtenteDAO {

	public boolean existsUsername(String username);
	public Utente getUtenteByUsername(String username);
	public List<Utente> getFollowerByUtente(String utente);
	public List<Utente> getSeguitiByUtente(String utente);
	public List<Utente> getFollowerByArtista(String artista);
	public List<Utente> getArtistiSeguitiByUtente(String utente);
	
	public int insUtente(Utente utente);
	
	public int delUtenteByUsername(String username);
	
	public boolean login(String user, String pass);
	//public void addCredenziali(String user, String pass);
	
	
	//devono stare qui???
	
	public int addFollowUtente(String segue, String seguito);
	public int addFollowArtista(String segue, int artista);
	public int delFollowUtente(String segue, String seguito);
	public int delFollowArtista(String segue, int artista);
//	public int addPreferito(String utente, int brano); //sono gia un brano
//	public int delPreferito(String utente, int brano); //sono gia un brano
	
	
	
	
	

}
