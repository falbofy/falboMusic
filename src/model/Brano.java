package model;


public class Brano {

	int idBrano;
	String titolo;
	float durata;
	String uscita;
	String linkVideo;
	String linkImg;
	String genere;
	//List<Artista> artista;
	
	public Brano(){}
	
	public Brano(int idBrano, String titolo, int durata, String uscita, String linkVideo, String linkImg,
			String genere) {
		this.idBrano = idBrano;
		this.titolo = titolo;
		this.durata = durata;
		this.uscita = uscita;
		this.linkVideo = linkVideo;
		this.linkImg = linkImg;
		this.genere = genere;
	}
	public int getIdBrano() {
		return idBrano;
	}
	public void setIdBrano(int idBrano) {
		this.idBrano = idBrano;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public float getDurata() {
		return durata;
	}
	public void setDurata(int durata) {
		this.durata = durata;
	}
	public String getUscita() {
		return uscita;
	}
	public void setUscita(String uscita) {
		this.uscita = uscita;
	}
	public String getLinkVideo() {
		return linkVideo;
	}
	public void setLinkVideo(String linkVideo) {
		this.linkVideo = linkVideo;
	}
	public String getLinkImg() {
		return linkImg;
	}
	public void setLinkImg(String linkImg) {
		this.linkImg = linkImg;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}

	/*public List<Artista> getArtista() {
		return artista;
	}

	public void setArtista(List<Artista> artista) {
		this.artista = artista;
	}
	
	public void addArtista(Artista artista){
		this.artista.add(artista);
	}
	public void delArtista(Artista artista){
		this.artista.remove(artista);
	}*/
	
	
}
