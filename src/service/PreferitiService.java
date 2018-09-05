package service;

import java.util.List;

import model.Ascolto;
import model.Brano;
import persistence.DAOFactory;
import persistenceDAO.BranoDAO;


public class PreferitiService {
	private DAOFactory factory;

	private BranoDAO branoDAO;

 public	PreferitiService()
 {
	this.factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	this.branoDAO = this.factory.getBranoDAO();

 }
 
	public List<Brano> getPreferitibyUtente(String utente){
		return branoDAO.getPreferitibyUtente(utente);
 }
	public List<Brano> getAscoltibyUtente(String utente){
		return branoDAO.getAscoltibyUtente(utente);
	}
	public int addAscolto(int brano, String utente){
		return branoDAO.addAscolto(brano, utente);
	}
	public int addPreferito(int brano, String Utente){
		return branoDAO.addPreferito(brano, Utente);
	}
}