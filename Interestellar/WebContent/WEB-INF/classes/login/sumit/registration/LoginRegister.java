package login.sumit.registration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginRegister")
public class LoginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginRegister() {
        
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PlayerDAO pl = new PlayerDAOImplement();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String submitType = request.getParameter("submit");
		Player p = pl.getPlayer(username, password);
		
		if(submitType.equals("login") && p.getUsername() != null) {
			request.setAttribute("message", "Bem vindo ".concat(p.getUsername()));
			request.getRequestDispatcher("index.jsp").forward(request, response);			
		} else if(submitType.equals("register")) {

			Player alredayExist = pl.getPlayer(username);
			
			if(alredayExist.getUsername() != null) {
				request.setAttribute("message", "Nome de usuário inválido");
				request.getRequestDispatcher("register.jsp").forward(request, response);				
			} else {			
				p.setEmail(request.getParameter("email"));
				p.setUsername(username);
				p.setPassword(password);
				pl.insertPlayer(p);
				request.setAttribute("message", "Registrado com sucesso, faça login para continuar.");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("message", "Dados informados não encontrados, favor validar as informações!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
