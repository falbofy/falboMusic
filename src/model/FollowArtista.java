package model;

public class FollowArtista {

		String utente;
		String artista;
		
		public FollowArtista(){}
		
		public FollowArtista (String utente, String artista){
			this.utente=utente;
			this.artista=artista;
		}

		public String getUtente() {
			return utente;
		}

		public void setUtente(String utente) {
			this.utente = utente;
		}

		public String getArtista() {
			return artista;
		}

		public void setArtista(String artista) {
			this.artista = artista;
		}

		
	
}
