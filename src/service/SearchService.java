package service;

import java.util.List;

import model.Brano;
import model.Playlist;
import persistence.DAOFactory;
import persistenceDAO.ArtistaDAO;
import persistenceDAO.BranoDAO;
import persistenceDAO.PlaylistDAO;

public class SearchService {
	private DAOFactory factory;
	private ArtistaDAO artistaDao;
	private BranoDAO branoDao;
	private PlaylistDAO playlistDAO;

 public	SearchService()
 {
	this.factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
	this.artistaDao = this.factory.getArtistaDAO();
	this.branoDao = this.factory.getBranoDAO();
	this.playlistDAO=this.factory.getPlaylistDAO();
 }

 public List<Brano> searchBraniByTitolo(String titolo){
	 return branoDao.getBraniByTitolo(titolo);
 }
 
 public List<Brano> searchBraniByArtista(String artista){
	 return branoDao.getBraniByArtista(artista);
 }
 
 public List<Brano> searchBraniByPlaylist(String playlist){
	 return branoDao.getBraniByPlaylist(playlist);
 }
 
 public List<Brano> searchBraniByGenere(String genere){
	 return branoDao.getBraniByGenere(genere);
 }
 
 public Playlist searchPlaylistByNome(String nome){
	 return playlistDAO.getPlaylistByNome(nome);
 }
 
 public List<Playlist> searchPlaylistByUtente(String username){
	 return playlistDAO.getPlaylistByUtente(username);
 }
 
}