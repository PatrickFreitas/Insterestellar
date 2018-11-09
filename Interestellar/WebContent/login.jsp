<%@ page language="java" contentType="text/html"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login Interestellar</title>
	<link rel="shortcut icon" href="logo/INTERESTELLARLOGO-01.png"/>
	<link rel="stylesheet" href="./css/index.css">
	<link rel="stylesheet" href="./css/login.css">
	<link rel="stylesheet" href="./css/interestellar.css">
	
	<link href="https://fonts.googleapis.com/css?family=Orbitron:400,500,700,900" rel="stylesheet">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
	
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
	<header class="v-header container">
		<div class="fullscreen">
			<video src="backgrounds/bg2Video.mp4" autoplay="true" muted="true" loop="true"></video>
			<img src="backgrounds/bg.jpg">
		</div>
		<div class="header-overlay"></div>
		<div class="col-dg-6 col-dm-12 col-12 centralDiv">
				<img src="logo/INTERESTELLARLOGO-01.png" class="col-dg-10 col-dm-10 col-10 logo">
				<h3 class="titulo">ENTRAR</h3>
      				<form id="formLogin" action="Logar" method="POST">
					<input 	id="fldUsuario" 
							class="input-ship-icon input-login"
							onfocus="playAudio('laser', 0.3)" 
							onblur="pauseAudio(audioLaser)" 
							onkeydown="playKeySound()"
							type="text" 
							name="usuario" 
							placeholder="Informe seu usuário.">

					<input 	id="fldSenha"
							class="input-ship-icon input-login"
							onfocus="playAudio('laser', 0.3)" 
							onblur="pauseAudio(audioLaser)"
							onkeydown="playKeySound()"
							type="password" 
							name="senha" 
							placeholder="Informe sua senha.">	
                   
				<!-- <div class="lembrarMinhaSenha">
					<input type="checkbox" name="lembrarSenha">
					<label for="lembrarSenha">Lembrar minha senha</label>
				</div>  -->
				
				<div class="esqueciSenha">
					<a href="#"> Esqueci minha senha </a>
				</div>

				<div style="width: 100%">
                   	<a href="index.jsp"><button type="button" class="btn col-dg-4 col-dm-12 col-12 colorBtn1">Cancelar</button></a>
                    <a href="register.jsp"><button type="button" class="btn col-dg-4 col-dm-12 col-12 colorBtn2">Cadastrar</button></a>
                   	<button id="btnLogin" type="submit" class="btn col-dg-4 col-dm-12 col-12 colorBtn3">Entrar</button>
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
	<script src="./js/login.js"></script>
</body>
</html>