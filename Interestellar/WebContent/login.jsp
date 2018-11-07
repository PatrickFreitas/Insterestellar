<%@ page language="java" contentType="text/html"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login Interestellar</title>
	<link rel="shortcut icon" href="logo/INTERESTELLARLOGO-01.png"/>
	<link rel="stylesheet" href="./css/index.css">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<style type="text/css">
		.container{
			max-width: 960px;
			padding-left: 1rem;
			padding-right: 1rem;
 			margin: auto;
			text-align: center;
		}
	</style>
</head>
<body>
	<audio id="audio"><source src="./sound/laser.wav" type="audio/mpeg"></audio>
	
	<header class="v-header container">
			<div class="fullscreen">
				<video src="backgrounds/bg2Video.mp4" autoplay="true" muted="true" loop="true"></video>
				<img src="backgrounds/bg.jpg">
			</div>
			<div class="header-overlay"></div>
				<div class="col-dg-6 col-dm-12 col-12 centralDiv">
						<img src="logo/INTERESTELLARLOGO-01.png" class="logo">
						<h3 class="titulo">ENTRAR</h3>

        				<form id="formLogin" action="Logar" method="POST">
							<input 	id="fldUsuario" 
									class="inputText"
									onfocus="playAudio()" 
									onblur="pauseAudio()" 
									type="text" 
									name="usuario" 
									placeholder="Informe seu usuário.">
	
							<input 	id="fldSenha"
									class="inputText"
									onfocus="playAudio()" 
									onblur="pauseAudio()" 
									type="password" 
									name="senha" 
									placeholder="Informe sua senha.">	
	                    
						<div class="lembrarMinhaSenha">
							<input type="checkbox" name="lembrarSenha">
							<label for="lembrarSenha">Lembrar minha senha</label>
						</div>

						<div style="width: 100%">
                        	<a href="index.jsp"><button type="button" class="btn colorBtn1">Cancelar</button></a>
	                        <a href="register.jsp"><button type="button" class="btn colorBtn2">Cadastrar</button></a>
                        	<button id="btnLogin" type="submit" class="btn colorBtn3">Entrar</button>
						</div>						
	                    </form>
        				<%
        					String msg = (String)request.getAttribute("mensagem");
        					if(msg != null)
                        		out.print("<p style='color:white;font-size:13px;margin-top:25px;display:inline-block;font-weight:700;'>" + msg + "</p>");
        				%>
				</div>
	</header>
	
	<script src="./js/functions.js"></script>
	<script src="./js/index.js"></script>
</body>
</html>