package model;

import java.sql.Date;

public class Ascolto {
String utente;
int brano;
int qnt;

public Ascolto(){}

public Ascolto(String utente, int brano) {
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

public int getQnt() {
	return this.qnt;
}

public void setQnt(int qnt) {
	this.qnt = qnt;
}

/*
public void addBrano(Brano brano) {
	this.brani.add(brano);
}

public void delBrano(Brano brano) {
	this.brani.remove(brano);
}
*/
}
