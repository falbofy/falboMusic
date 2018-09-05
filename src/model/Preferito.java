package model;

public class Preferito {
	String utente;
	int brano;
	
	public Preferito(){}
	
	public Preferito(String utente, int brano) {
		this.utente = utente;
		this.brano = brano;
	}
	public String getUtente() {
		return utente;
	}
	public void setUtente(String utente) {
		this.utente = utente;
	}
	public int getBrano() {
		return brano;
	}
	public void setBrano(int brano) {
		this.brano = brano;
	}
	
	
	
}
