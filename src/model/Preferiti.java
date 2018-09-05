package model;

import java.util.List;

public class Preferiti {
	
String proprietario;
int brano;

public Preferiti() {}

public Preferiti(String proprietario, int brano) {
	this.proprietario = proprietario;
	this.brano = brano;
}

public String getProprietario() {
	return proprietario;
}

public void setProprietario(String proprietario) {
	this.proprietario = proprietario;
}

public int getBrano() {
	return brano;
}

public void setBrano(int brano) {
	this.brano = brano;
}
 /*
public void addBran(Brano brano) {
	brani.add(brano);
}

public void delBrano(Brano brano) {
	brani.remove(brano);
}
*/
}
