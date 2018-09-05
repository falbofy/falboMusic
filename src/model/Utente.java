package model;

import java.util.List;

public class Utente {
	
	String username;
	String password;
	String nome;
	String cognome;
	int abbonamento;
	/*List<Utente> follower;
	List<Utente> seguaci;
	List<Brano> ascolti;
	List<Brano> preferiti;
	*/
	
	public Utente(){}

	public Utente(String username, String password, String nome, String cognome, int abbonamento
			){//,List<Utente> follower, List<Utente> seguaci, List<Brano> ascolti, List<Brano> preferiti) {
		
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.abbonamento = abbonamento;
		/*this.follower = follower;
		this.seguaci = seguaci;
		this.ascolti = ascolti;
		this.preferiti = preferiti;*/
	}

/*
	public List<Brano> getAscolti() {
		return ascolti;
	}

	
	public void setAscolti(List<Brano> ascolti) {
		this.ascolti = ascolti;
	}
	
	public void addAscolti(Brano brano){
		this.ascolti.add(brano);
	}
	
	public void delAscolti(Brano brano){
		this.ascolti.remove(brano);
	}

	
	public List<Brano> getPreferiti() {
		return preferiti;
	}


	public void setPreferiti(List<Brano> preferiti) {
		this.preferiti = preferiti;
	}
	
	public void addPreferiti(Brano brano){
		this.preferiti.add(brano);
	}
	
	public void delpreferiti(Brano brano){
		this.preferiti.remove(brano);
	}

	public List<Utente> getFollower() {
		return follower;
	}

	public void setFollower(List<Utente> follower) {
		this.follower = follower;
	}
	
	public void addFollower(Utente utente){
		this.follower.add(utente);
	}
	
	public void delFollower(Utente utente){
		this.follower.remove(utente);
	}
	
	public void addSeguace(Utente utente){
		this.seguaci.add(utente);
	}
	
	public void delSeguaci(Utente utente){
		this.seguaci.remove(utente);
	}
	
	public List<Utente> getSeguaci() {
		return seguaci;
	}

	public void setSeguaci(List<Utente> seguaci) {
		this.seguaci = seguaci;
	}
*/
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public int getAbbonamento() {
		return abbonamento;
	}

	public void setAbbonamento(int abbonamento) {
		this.abbonamento = abbonamento;
	}
}