package Controller;

import Model.Jogador;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Logar", urlPatterns = {"/Logar"})
public class Logar extends HttpServlet {

    public List<Jogador> capturaJogadores() throws FileNotFoundException, IOException {
	    List<Jogador> result = new ArrayList<>();
	    String caminhoDir = getServletContext().getRealPath("/WEB-INF");    
	    File arquivo = new File(caminhoDir,"jogadores.txt");
	    if(arquivo.exists()) {
           String linha;
           String cli = getServletContext().getRealPath("/WEB-INF/jogadores.txt");    
           BufferedReader reader = new BufferedReader(
                                  new InputStreamReader(
                                      new FileInputStream(cli), Charset.forName("UTF-8").newDecoder()));
           while(( linha = reader.readLine()) != null) {
              if ((linha != null) && (!linha.isEmpty())) {
            	Jogador j = new Jogador();
                String[] vetCliente = linha.split(";");
                j.setId(Integer.parseInt(vetCliente[0]));
                j.setUsuario(vetCliente[1]);
                j.setSenha(vetCliente[2]);
                j.setEmail(vetCliente[3]);
                result.add(j);
              }
           }
           reader.close();
        }
        return result;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            
            List<Jogador> jogadores = capturaJogadores();
            if(!jogadores.isEmpty()) {
               request.setAttribute("jogadores", jogadores);
               request.getRequestDispatcher("Exibicao.jsp").forward(request, response);        
            }
            else
                 request.getRequestDispatcher("Exibicao2.jsp").forward(request, response);                    
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		String mensagem = "Não foi possível localizar a mensagem para esse cenário.";
		String destino = "";
		
        List<Jogador> jogadores = capturaJogadores();
        request.setAttribute("jogadores", jogadores);
        
        if(jogadores.size() <= 0) {
        	mensagem = "Não há nenhum registro com essas informações.";
	       request.setAttribute("mensagem", mensagem);
	       request.getRequestDispatcher("login.jsp").forward(request, response);        
        }
        else {
        	for (int i = 0; i < jogadores.size(); i++) {
    			Jogador j = jogadores.get(i);
    			if(j.getUsuario().equals(usuario) && j.getSenha().equals(senha)) { 
    				mensagem = "Usuário localizado, parabéns pelo Login!"; 
    				destino = "pos-login.jsp";
    				break;
    			}
    			if(i == jogadores.size() - 1) {
    	        	mensagem = "Não há nenhum registro com essas informações.";
    				destino = "login.jsp";
    			}
    		}

            request.setAttribute("mensagem", mensagem);
        	request.getRequestDispatcher(destino).forward(request, response);
        }
            
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
