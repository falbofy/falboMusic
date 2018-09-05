package persistenceDAO;
import java.util.List;

import model.Artista;

public interface ArtistaDAO {
	
 public Artista getArtistaByAlias(String alias);
 public List<Artista> getArtistaByIdBrano(int id);
}
