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

@WebServlet(name = "Cadastrar", urlPatterns = {"/Cadastrar"})
public class Cadastrar extends HttpServlet {
 
    public int getQtdJogadores() throws FileNotFoundException, IOException {
        int quantidadeJogadores = 0;
        String path = getServletContext().getRealPath("/WEB-INF");    
        File file = new File(path, "repositorio.txt");
        if(!file.exists()) {
            file.createNewFile();
            return quantidadeJogadores;
        } else {
            String fileJogadores = getServletContext().getRealPath("/WEB-INF/repositorio.txt");    
            BufferedReader reader = new BufferedReader(
                                   new InputStreamReader(
                                       new FileInputStream(fileJogadores), Charset.forName("UTF-8").newDecoder()));
            while(reader.readLine() != null)
                quantidadeJogadores++;
            
            reader.close();
            return quantidadeJogadores;
        }
    }
    
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
    
    public void registrarJogador(Jogador jogador)
        throws IOException {
            String path = getServletContext().getRealPath("/WEB-INF");    
            File file = new File(path, "repositorio.txt");
            if(!file.exists())
                file.createNewFile();
            String fileJogador = getServletContext().getRealPath("/WEB-INF/repositorio.txt");    
            OutputStreamWriter g = new OutputStreamWriter(
                                       new FileOutputStream(fileJogador,true),Charset.forName("UTF-8").newEncoder());
            BufferedWriter writer = new BufferedWriter(g);
            writer.write(jogador.getId()+";");
            writer.write(jogador.getUsuario()+";");
            writer.write(jogador.getSenha()+";");
            writer.write(jogador.getEmail()+";");
            writer.write(jogador.getPontuacao());
            writer.newLine();
            writer.flush();
            writer.close();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");

            int qtdJogadores = getQtdJogadores();
            List<Jogador> listaJogadores = capturaJogadores();
    		String mensagemCadastro = "Não foi possível localizar a mensagem para esse cenário.";
    		String destino = "";
            
            if(listaJogadores.size() <= 0) {
	            Jogador jogador = new Jogador();
	            jogador.setId(++qtdJogadores);
	            jogador.setUsuario(request.getParameter("usuario"));
	            jogador.setSenha(request.getParameter("senha"));
	            jogador.setEmail(request.getParameter("email"));
	            jogador.setPontuacao("0");
	            registrarJogador(jogador);
				destino = "login.jsp";
            }
            else {
            	for (int i = 0; i < listaJogadores.size(); i++) {
        			Jogador j = listaJogadores.get(i);
        			if(j.getUsuario().equals(request.getParameter("usuario"))) { 
        				mensagemCadastro = "Já existe um usuário"; 
        				destino = "register.jsp";
        	            request.setAttribute("mensagemCadastro", mensagemCadastro);
        				break;
        			}
        			if(i == listaJogadores.size() - 1) {
        	            Jogador jogador = new Jogador();
        	            jogador.setId(++qtdJogadores);
        	            jogador.setUsuario(request.getParameter("usuario"));
        	            jogador.setSenha(request.getParameter("senha"));
        	            jogador.setEmail(request.getParameter("email"));
        	            jogador.setPontuacao("0");
        	            registrarJogador(jogador);
        				destino = "login.jsp";
        			}
        		}
            }

            request.setAttribute("mensagemCadastro", mensagemCadastro);
        	request.getRequestDispatcher(destino).forward(request, response);
    }
}
