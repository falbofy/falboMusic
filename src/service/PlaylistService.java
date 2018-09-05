package service;

import java.util.List;


import model.Playlist;
import persistence.DAOFactory;

import persistenceDAO.PlaylistDAO;

public class PlaylistService {
	private DAOFactory factory;
	//private BranoDAO branoDao;
	private PlaylistDAO playlistDAO;

 public	PlaylistService()
 {
	this.factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	//this.branoDao = this.factory.getBranoDAO();
	this.playlistDAO=this.factory.getPlaylistDAO();
 }
 
 public int newPlaylist(String titolo, String utente){
	 Playlist p=new Playlist(titolo,utente);
	 return playlistDAO.newPlaylist(p);
 }
 
 public int addBrano(int brano, String playlist){
	 return playlistDAO.addBranoPlaylist(brano, playlist);
 }
 
 public int delBrano( int brano, String playlist){
	 return playlistDAO.delBranoPlaylist(brano, playlist);
 }
 
 
}