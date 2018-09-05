package model;

import java.sql.Date;

public class Abbonamento {
int idAbbonamento;
Date scadenza;
//Utente proprietario;


public Abbonamento(int idAbbonamento, Date scadenza){ //,Utente proprietario) {
	this.idAbbonamento = idAbbonamento;
	this.scadenza = scadenza;
	//this.proprietario = proprietario;
}


public int getIdAbbonamento() {
	return idAbbonamento;
}


public void setIdAbbonamento(int idAbbonamento) {
	this.idAbbonamento = idAbbonamento;
}


public Date getScadenza() {
	return scadenza;
}

public boolean rinnovaAbbonamento(int mesi) {
	//rinnovare l'abbonamento per altri "mesi" mesi.
	return true;
}

public void setScadenza(Date scadenza) {
	this.scadenza = scadenza;
}

/*
public Utente getProprietario() {
	return proprietario;
}


public void setProprietario(Utente proprietario) {
	this.proprietario = proprietario;
}
*/

}
