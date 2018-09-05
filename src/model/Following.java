package model;

public class Following {
	String segue;
	String seguito;
	
	public Following(){}
	
	public Following (String segue, String seguito){
		this.segue=segue;
		this.seguito=seguito;
	}
	
	public String getSegue(){
		return segue;
	}
	
	public String getSeguito(){
		return seguito;
	}
	
	public void setSegue(String segue){
		this.segue=segue;
	}
	
	public void setSeguito(String seguito){
		this.seguito=seguito;
	}
}
