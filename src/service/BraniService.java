package service;

import java.util.List;

import model.Artista;
import model.Brano;
import persistence.DAOFactory;
import persistenceDAO.ArtistaDAO;
import persistenceDAO.BranoDAO;

public class BraniService {
	private DAOFactory factory;
	private BranoDAO branodao;
	private ArtistaDAO artistadao;

	public BraniService() {
		this.factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		this.branodao = factory.getBranoDAO();
		this.artistadao = factory.getArtistaDAO();
	}

	public List<Artista> getArtistaByIdBrano(int idbrano) {
		return artistadao.getArtistaByIdBrano(idbrano);
	}

	public List<Brano> ultimiBraniInseriti() {
		return branodao.getUtimiBraniInseriti();
	}

	public List<Artista> getAllArtisti() {
		return artistadao.getArtisti();
	}

	public List<Brano> getAllBrani() {
		return branodao.getBrani();
	}

	public String getGenerePiuAscoltato(String utente) {
		return branodao.generePiuAscoltato(utente);
	}

}