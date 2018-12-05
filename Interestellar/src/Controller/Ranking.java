package Controller;

import Model.Jogador;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Ranking", urlPatterns = {"/Ranking"})
public class Ranking extends HttpServlet {

    public List<Jogador> capturaJogadores() throws FileNotFoundException, IOException {
	    List<Jogador> result = new ArrayList<>();
	    String caminhoDir = getServletContext().getRealPath("/WEB-INF");    
	    File arquivo = new File(caminhoDir,"repositorio.txt");
	    if(arquivo.exists()) {
           String linha;
           String cli = getServletContext().getRealPath("/WEB-INF/repositorio.txt");    
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
                j.setPontuacao(vetCliente[4]);
                result.add(j);
              }
           }
           reader.close();
        }
        return result;
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");

            String jsonJogadores = "";
            List<Jogador> listaJogadores = capturaJogadores();
            
            if(listaJogadores.size() <= 0) {
            }
            else {
            	for (int i = 0; i < listaJogadores.size(); i++) {
        			Jogador j = listaJogadores.get(i);
                    jsonJogadores += j.getUsuario() + ";";
                    jsonJogadores += j.getPontuacao() + "-";

            		if(i == 9)
            			break;
    			}
    		}
            
            request.setAttribute("jsonJogadores", jsonJogadores);                
            request.getRequestDispatcher("raking.jsp").forward(request, response);
    }
}
