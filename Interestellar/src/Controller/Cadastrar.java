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
        File file = new File(path, "jogadores.txt");
        if(!file.exists()) {
            file.createNewFile();
            return quantidadeJogadores;
        } else {
            String fileJogadores = getServletContext().getRealPath("/WEB-INF/jogadores.txt");    
            BufferedReader reader = new BufferedReader(
                                   new InputStreamReader(
                                       new FileInputStream(fileJogadores), Charset.forName("UTF-8").newDecoder()));
            while(reader.readLine() != null)
                quantidadeJogadores++;
            
            reader.close();
            return quantidadeJogadores;
        }
    }
    
    public void registrarJogador(Jogador jogador)
        throws IOException {
            String path = getServletContext().getRealPath("/WEB-INF");    
            File file = new File(path, "jogadores.txt");
            if(!file.exists())
                file.createNewFile();
            String fileJogador = getServletContext().getRealPath("/WEB-INF/jogadores.txt");    
            OutputStreamWriter g = new OutputStreamWriter(
                                       new FileOutputStream(fileJogador,true),Charset.forName("UTF-8").newEncoder());
            BufferedWriter writer = new BufferedWriter(g);
            writer.write(jogador.getId()+";");
            writer.write(jogador.getUsuario()+";");
            writer.write(jogador.getSenha()+";");
            writer.write(jogador.getEmail());
            writer.newLine();
            writer.flush();
            writer.close();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");

            int qtdJogadores = getQtdJogadores();
            Jogador jogador = new Jogador();
            jogador.setId(++qtdJogadores);
            jogador.setUsuario(request.getParameter("usuario"));
            jogador.setSenha(request.getParameter("senha"));
            jogador.setEmail(request.getParameter("email"));
            registrarJogador(jogador);
            response.sendRedirect("login.jsp");
    }
}
