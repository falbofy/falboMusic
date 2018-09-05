package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.Utente;
import model.Brano;
import model.Playlist;
import model.Artista;
import service.SearchService;

/**
 * Servlet implementation class SquadraServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		PrintWriter out= response.getWriter();
		SearchService searchservice= new SearchService();
		

		switch(action)
		{
		case "branibyartista":{
			
			String artista= request.getParameter("artista");
			List<Brano> brani= searchservice.searchBraniByArtista(artista);
			Gson gson=new Gson();
			String jsonclass= gson.toJson(brani);
			response.setContentType("application/json");
			out.println(jsonclass);
			
		   return;
		}
		case "branibytitolo":{
						
			String titolo= request.getParameter("titolo");
			List<Brano> brani= searchservice.searchBraniByTitolo(titolo);
			Gson gson=new Gson();
			String jsonclass= gson.toJson(brani);
			response.setContentType("application/json");
			out.println(jsonclass);
			
		   return;
		}
		case "branibyplaylist":{
			
			String playlist= request.getParameter("playlist");
			List<Brano> brani= searchservice.searchBraniByPlaylist(playlist);
			Gson gson=new Gson();
			String jsonclass= gson.toJson(brani);
			response.setContentType("application/json");
			out.println(jsonclass);
			
		   return;
		}//getgiornate senza formazione
		case "branibygenere":{
			
			String genere= request.getParameter("genere");
			List<Brano> brani= searchservice.searchBraniByGenere(genere);
			Gson gson=new Gson();
			String jsonclass= gson.toJson(brani);
			response.setContentType("application/json");
			out.println(jsonclass);
			
		   return;
		}//getmyteam
		case "playlistbynome":{

			String titolo= request.getParameter("playlist");
			Playlist playlist= searchservice.searchPlaylistByNome(titolo);
			
			Gson gson=new Gson();
			String jsonclass= gson.toJson(playlist);
			response.setContentType("application/json");
			out.println(jsonclass);
			
		   return;
		}//getmyteam
		case "playlistbyutente":{
		
		String username= request.getParameter("username");
		List<Playlist> playlist= searchservice.searchPlaylistByUtente(username);
		
		Gson gson=new Gson();
		String jsonclass= gson.toJson(playlist);
		response.setContentType("application/json");
		out.println(jsonclass);
		
	   return;
	    }
	 }//switch
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}