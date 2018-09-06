package service;


import model.Utente;
import persistence.DAOFactory;
import persistenceDAO.UtenteDAO;

public class AccountService {
	
	private DAOFactory factory;
	private UtenteDAO utentedao;


	
	public AccountService(){
		
		this.factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		this.utentedao = this.factory.getUtenteDAO();

	}
	
	public Utente login(String user, String pass)
	{
		Utente u=null;
		
		if(utentedao.login(user, pass))
		{
			u= utentedao.getUtenteByUsername(user);
		}	
		
		return u;
	}
	
	public boolean validaDati(Utente utente, String pswrep) 
	{
		if(utente.getNome().isEmpty()||utente.getCognome().isEmpty()||utente.getUsername().isEmpty()||utente.getPassword().isEmpty())//||utente.getEmail().isEmpty())
			return false;
		System.out.println(utente.getNome());
		System.out.println(utente.getCognome());
		System.out.println(utente.getUsername());
		System.out.println(utente.getPassword());
		
		if(!utente.getPassword().equals(pswrep))
			return false;
		
		/*if(utente.getEmail().chars().filter(num -> num == '@').count()!=1)
				return false;*/
				
		return true;
	}
	
	public boolean registra(Utente u)//, Credenziali cred)
	{
		int i= utentedao.insUtente(u);
		
		if(i==-1)
			return false;
		
		//cred.setUtente(i);
		
		//credenzialidao.addCredenziali(cred);
		
		return true;
	}
	/*
	public boolean validaCredenziali(Credenziali cred, String pswrep)
	{
		if(cred.getPassword().isEmpty())
			return false;
		
		if(!cred.getPassword().equals(pswrep))
			return false;
		
		
		return true;
	}
	*/
	public boolean userDisponibile(String user)
	{
		if(!utentedao.existsUsername(user))
			return true;
		else
			return false;
	}
	
	/*
	public int userId(String user)
	{
		return utentedao.getUtentebyUser(user);
	
	}*/
	
}
