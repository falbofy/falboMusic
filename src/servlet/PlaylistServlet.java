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



import model.Playlist;

import service.PlaylistService;

/**
 * Servlet implementation class SquadraServlet
 */
@WebServlet("/PlaylistServlet")
public class PlaylistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaylistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		PrintWriter out= response.getWriter();
		PlaylistService playlistservice= new PlaylistService();
		

		switch(action)
		{
		case "addbrano":{
			
			String brano= request.getParameter("brano");
			String playlist= request.getParameter("playlist");
			out.println(playlistservice.addBrano(Integer.parseInt(brano), playlist));
			
		   return;
		}
		case "delbrano":{
						
			String brano= request.getParameter("brano");
			String playlist= request.getParameter("playlist");
			out.println(playlistservice.delBrano(Integer.parseInt(brano), playlist));
			
		   return;
		}
		case "newplaylist":{
			
			String utente= request.getParameter("username");
			String playlist= request.getParameter("nome");
			out.println(playlistservice.newPlaylist(utente, playlist));
			
		   return;
		}//getgiornate senza formazione

	 }//switch
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
}
