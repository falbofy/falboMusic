package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.google.gson.Gson;
import com.google.gson.JsonObject;

import model.Artista;
import model.Brano;
import model.Utente;
import service.AccountService;
import service.BraniService;
import service.PreferitiService;
import service.SearchService;

/**
 * Servlet implementation class AccessServlet
 */
@WebServlet("/FunctionServlet")
public class FunctionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FunctionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out= response.getWriter();
		
		 if(request.getParameter("action").equals("ultimiinseriti"))
			{
			
			 BraniService braniservice = new BraniService();
			 List<Brano> brani= braniservice.ultimiBraniInseriti();
			 //System.out.println(brani.toString());
			 Gson gson=new Gson();
				String risjson= gson.toJson(brani);
				response.setContentType("application/json");
				out.println(risjson);
				return;			
			}
		 else if(request.getParameter("action").equals("branibygenere"))
		 {
				
			 SearchService searchservice = new SearchService();
			 List<Brano> brani= searchservice.searchBraniByGenere("rock");
			 System.out.println(brani.toString());
			 Gson gson=new Gson();
				String risjson= gson.toJson(brani);
				response.setContentType("application/json");
				out.println(risjson);
				return;			
			}
		 else if(request.getParameter("action").equals("allbrani"))
		 {
				
			 BraniService braniservice = new BraniService();
			 List<Brano> brani= braniservice.getAllBrani();
			 System.out.println(brani.toString());
			 Gson gson=new Gson();
				String risjson= gson.toJson(brani);
				response.setContentType("application/json");
				out.println(risjson);
				return;			
			}
		 else if(request.getParameter("action").equals("allartisti"))
		 {
				
			 BraniService braniservice = new BraniService();
			 List<Artista> brani= braniservice.getAllArtisti();
			 System.out.println(brani.toString());
			 Gson gson=new Gson();
				String risjson= gson.toJson(brani);
				response.setContentType("application/json");
				out.println(risjson);
				return;			
			}
		 else if(request.getParameter("action").equals("artistibyidbrano"))
		 {	
					
				 String idbrano=request.getParameter("idbrano");
				 BraniService braniservice = new BraniService();
				 List<Artista> artisti= braniservice.getArtistaByIdBrano(Integer.parseInt(idbrano));
				 
						 
				 Gson gson=new Gson();
					String risjson= gson.toJson(artisti);
					response.setContentType("application/json");
					out.println(risjson);
					return;				
		 }
		 else if(request.getParameter("action").equals("addascolto"))
		 {	
			 response.setContentType("text/html");
			 String u= (String) request.getSession().getAttribute("loggeduser");
			// String linkVideo= (String) request.getSession().getAttribute("linkVideo");
			//System.out.println("il link nuovo e:"+linkVideo);
				if( u==null || u.isEmpty()){
					//System.out.println("ho ascoltato il brano da non loggato");
					response.getWriter().print(0);
					return;
					
				} 
			/*	if( linkVideo==null || linkVideo.isEmpty()){
					response.getWriter().print(0);
					return;
				}*/
				else{
				
				//request.getSession().setAttribute("linkVideo", linkVideo);
				PreferitiService preferitiservice= new PreferitiService();
				//System.out.println("id brano da parametro="+request.getParameter("brano"));
				int idbrano= Integer.parseInt(request.getParameter("brano"));
				preferitiservice.addAscolto(idbrano, u);
				//System.out.println("ho ascoltato il brano da loggato");
				response.getWriter().print(1);
				return; 
	
				}
				
		 }
		 else if(request.getParameter("action").equals("riproduciVideo"))
		 {	
			// response.setContentType("text/html");
			 String u= (String) request.getSession().getAttribute("linkVideo");
			 System.out.println("il link in java e:"+ request.getSession().getAttribute("linkVideo"));
			 if( u==null || u.isEmpty()){
					
					response.getWriter().print(0);
					return;
			 }
			 
			 request.getSession().setAttribute("linkVideo", u);
			 response.getWriter().print(1);
			 return; 
	
				}
				
		 }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



	}
	
}
