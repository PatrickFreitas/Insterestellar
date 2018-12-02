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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;  

@WebServlet(name = "RegistrarPontuacao", urlPatterns = {"/RegistrarPontuacao"})
public class RegistrarPontuacao extends HttpServlet {

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
            
            HttpSession session = request.getSession(false);
    		String novaPontuacao = request.getParameter("novaPontuacao");
            if(session != null){  
            	String usuario = (String)session.getAttribute("usuario");            

	            List<Jogador> listaJogadores = capturaJogadores();
	        	for (int i = 0; i < listaJogadores.size(); i++) {
	        			Jogador j = listaJogadores.get(i);
	
	            		if(j.getUsuario().equals(usuario)) {
	            			editaPontuacao(usuario, novaPontuacao);
	            			session.setAttribute("pontuacao", novaPontuacao);
	            		}
	            			
	    		}
            }
                            
            request.getRequestDispatcher("pos-login.jsp").forward(request, response);
    }
    
    public Boolean editaPontuacao(String usuario, String novaPontuacao) throws FileNotFoundException, IOException {
	    String caminhoDir = getServletContext().getRealPath("/WEB-INF");    
	    File arquivo = new File(caminhoDir,"repositorio.txt");
        File arquivoTemp = new File(caminhoDir, "tempRepositorio.txt");
        Boolean flag = false;         
        
	    if(!arquivo.exists()) {
            return flag;
        }
        arquivoTemp.createNewFile();
        String linha;
        String cli = getServletContext().getRealPath("/WEB-INF/repositorio.txt");    
        BufferedReader reader = new BufferedReader(
                               new InputStreamReader(
                                   new FileInputStream(cli), Charset.forName("UTF-8").newDecoder()));
        while(( linha = reader.readLine()) != null)
           if ((linha != null) && (!linha.isEmpty())) {
             String[] vetJogadores = linha.split(";");
             if(vetJogadores[1].equals(usuario)){
                 String f = getServletContext().getRealPath("/WEB-INF/tempRepositorio.txt");    
                 OutputStreamWriter w = new OutputStreamWriter(
                                new FileOutputStream(f,true),Charset.forName("UTF-8").newEncoder());            
                 BufferedWriter bw = new BufferedWriter(w);
                 bw.write(vetJogadores[0]+";");
                 bw.write(vetJogadores[1]+";");
                 bw.write(vetJogadores[2]+";");
                 bw.write(vetJogadores[3]+";");
                 bw.write(novaPontuacao);
                 bw.newLine();
                 bw.flush();
                 bw.close();
             }
             else {
                 String f = getServletContext().getRealPath("/WEB-INF/tempRepositorio.txt");    
                 OutputStreamWriter w = new OutputStreamWriter(
                                new FileOutputStream(f,true),Charset.forName("UTF-8").newEncoder());            
                 BufferedWriter bw = new BufferedWriter(w);
                 bw.write(linha);
                 bw.newLine();
                 bw.flush();
                 bw.close();
             }
           }               
        reader.close();
        Path source = Paths.get(getServletContext().getRealPath("/WEB-INF/tempRepositorio.txt"));
        arquivo.delete();
        Files.move(source, source.resolveSibling("repositorio.txt"));     
        flag = true;
        return flag; 
	}
}
