<%@ page language="java" contentType="text/html;" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="utf-8">
    <title>Selecione dificuldade</title>
    <link rel="shortcut icon" href="logo/INTERESTELLARLOGO-01.png"/>
    <link rel="stylesheet" href="./css/sobreJogo.css">
    <link rel="stylesheet" href="./css/poslogin.css">
    <link rel="stylesheet" href="./css/interestellar.css">
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
<%
	String usuario = (String)request.getSession().getAttribute("usuario");
	String pontuacao = (String)request.getSession().getAttribute("pontuacao");
%>
<header class="v-header container">
    <div class="fullscreen">
        <video src="backgrounds/bg2Video.mp4" autoplay="true" muted="true" loop="true"></video>
        <img src="backgrounds/bg.jpg">
    </div>
    <div class="header-overlay"></div>
    <div class="col-dg-10 col-dm-10 col-10 align-center">
        <img src="logo/INTERESTELLARLOGO-01.png" class="logo">

        <div class="centralDiv ranking-list-item col-dg-6">
          <p class="paragrafo">
            Bem vindo, <%= usuario %>  </br> </br> Sua pontuacao maxima atingida foi de <%=pontuacao%> pontos, selecione uma dificuldade para jogar novamente.  
          <p>
        </div>


        <h1 class="titulo">Selecione a dificuldade</h1>
        <select class="col-dg-6 col-dm-4 col-10 select-group">
          <option class="select-option" value="facil">Facil</option>
          <option class="select-option">Medio</option>
          <option class="select-option">Dificil</option>
        </select>
        
        <div class="col-dg-6 col-dm-4 col-10">
            <a href="jogo.jsp"><button type="button" class="btn-menu colorBtn2">Jogar</button></a>
        </div>
        <div class="col-dg-6 col-dm-4 col-10">
			<form id="formRanking" action="Ranking" method="POST">
            	<button type="submit" class="btn-menu colorBtn2">Ranking</button>
            </form>
        </div>
    </div>
</header>
</body>
</html>