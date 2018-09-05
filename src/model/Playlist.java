package model;

public class Playlist {
//int idPlaylist;
String nome;
String proprietario;
//List<Brano> brani;

public Playlist(){}

public Playlist(String nome, String proprietario){//, List<Brano> brani) {

	this.nome = nome;
	this.proprietario = proprietario;

	//this.brani = brani;
}

public String getNomePlaylist() {
	return nome;
}

public void setNomePlaylist(String nome) {
	this.nome = nome;
}

public String getProprietario() {
	return proprietario;
}

public void setProprietario(String proprietario) {
	this.proprietario = proprietario;
}

/*
public List<Brano> getBrani() {
	return brani;
}

public void setBrani(List<Brano> brani) {
	this.brani = brani;
}

public void addBrano(Brano brano) {
	brani.add(brano);
}

public void delBrano(Brano brano) {
	brani.remove(brano);
}
*/
}
