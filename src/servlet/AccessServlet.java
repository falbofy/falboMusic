package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.google.gson.Gson;
import com.google.gson.JsonObject;


import model.Utente;
import service.AccountService;

/**
 * Servlet implementation class AccessServlet
 */
@WebServlet("/AccessServlet")
public class AccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 if(request.getParameter("action").equals("logout"))
			{
				request.getSession().invalidate();
				response.sendRedirect(request.getContextPath());
				return;
			}
		 else if(request.getParameter("action").equals("loginpage"))
		 {
			 String nextPage="/jsp/login.jsp";

			 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
			 dispatcher.forward(request, response);
			 return;

		 }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nextPage="-1";
		
		AccountService accountService= new AccountService();
	
		PrintWriter write= response.getWriter();

		
		if(request.getParameter("action").equals("login"))
		{
		Utente utente= accountService.login(request.getParameter("uname"), request.getParameter("psw"));
		
		
		if(utente!=null)
		 {
		 	HttpSession session= request.getSession(true);
			session.setAttribute("loggeduser", utente.getUsername());
			session.setMaxInactiveInterval(-1);
			
			response.setContentType("text/html");
			response.getWriter().print(1);
			
			return;
	    	}
		else
		 {
			
			response.setContentType("text/html");
			response.getWriter().print(0);
			return;
		 }
		}
		else if(request.getParameter("action").equals("register"))
		{
			Utente utente= new Utente();			
			
			utente.setNome(request.getParameter("nome"));
			utente.setCognome(request.getParameter("cognome"));
			utente.setUsername(request.getParameter("usr"));
			utente.setPassword(request.getParameter("psw"));
			
			/*System.out.println(request.getParameter("nome"));
			System.out.println(request.getParameter("psw"));
			System.out.println(utente.getUsername());
			System.out.println(utente.getPassword());*/
			if(!accountService.validaDati(utente, request.getParameter("pswrepeat") ))
				{
				
				response.getWriter().print(3);
			
				return;
				}
			
			boolean done=accountService.registra(utente);//, credenziali);
			
			if(!done)
				{
				
				request.setAttribute("wrongreg", "utente gia' registrato");
				response.getWriter().print(-1);
				
				return;
				}
			else
				{
				HttpSession session= request.getSession(true);
				session.setAttribute("loggeduser", utente.getUsername());
				session.setMaxInactiveInterval(-1);
				
				response.getWriter().print(1);
				
				return;
				}
			
		}//fine register
		else if(request.getParameter("action").equals("logout"))
		{
			request.getSession().invalidate();
			response.sendRedirect(request.getContextPath());
			return;
		}
		else if(request.getParameter("action").equals("checkusername"))
		{
			System.out.println("sono in chechusername");
			String pacchetto = request.getParameter("datapkt");
			
			if (pacchetto != null) {

				JsonObject jsonobject= new Gson().fromJson(pacchetto, JsonObject.class);
				String usern=jsonobject.get("useridea").getAsString(); 
				
				response.setContentType("text/html");
				
				if(accountService.userDisponibile(usern))
				{
					response.getWriter().print(1);
					return;
				}
				else	
				{
					response.getWriter().print(0);
					return;
				}

			}
			
			
		}//checkuser

	}
	
}
