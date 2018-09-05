package service;

import persistence.DAOFactory;

import persistenceDAO.UtenteDAO;

public class FollowService {
	private DAOFactory factory;
	//private BranoDAO branoDao;
	private UtenteDAO utenteDAO;

 public	FollowService()
 {
	this.factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	//this.branoDao = this.factory.getBranoDAO();
	this.utenteDAO=this.factory.getUtenteDAO();
 }
 
 public int addFollowUtente(String segue, String seguito){
	 return utenteDAO.addFollowUtente(segue, seguito);
 }
 public int addFollowArtista(String segue, int artista){
	 return utenteDAO.addFollowArtista(segue, artista);
 }
 public int delFollowUtente(String segue, String seguito){
	 return utenteDAO.delFollowUtente(segue, seguito);
 }
 public int delFollowArtista(String segue, int artista){
	 return utenteDAO.delFollowArtista(segue, artista);
 }
}
