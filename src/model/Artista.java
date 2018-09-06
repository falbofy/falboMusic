package model;

import java.util.List;

public class Artista {
	
int idArtista;
String nome;
String cognome;
String nazionalita;
String alias;
String linkImg;
//List<Utente> follower;

public Artista(){}

public Artista(int idArtista, String nome, String cognome, String nazionalita, String alias, String linkImg ){//,List<Utente> follower) {
	super();
	this.idArtista = idArtista;
	this.nome = nome;
	this.cognome = cognome;
	this.alias = alias;
	this.nazionalita = nazionalita;
	this.linkImg = linkImg;
	//this.follower = follower;
}


/*public List<Utente> getFollower() {
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
}*/

public int getIdArtista() {
	return idArtista;
}

public void setIdArtista(int idArtista) {
	this.idArtista = idArtista;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getCognome() {
	return cognome;
}

public void setCognome(String cognome) {
	this.cognome = cognome;
}

public String getAlias() {
	return alias;
}

public void setAlias(String alias) {
	this.alias = alias;
}

public String getNazionalita() {
	return nazionalita;
}

public void setNazionalita(String nazionalita) {
	this.nazionalita = nazionalita;
}

public String getLinkImg() {
	return linkImg;
}

public void setLinkImg(String linkImg) {
	this.linkImg = linkImg;
}

}
