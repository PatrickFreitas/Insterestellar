<%@ page language="java" contentType="text/html"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login Interestellar</title>
	<link rel="shortcut icon" href="logo/INTERESTELLARLOGO-01.png"/>
	<link rel="stylesheet" href="./css/ranking.css">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<style type="text/css">
		.container{
			max-width: 960px;
			padding-left: 1rem;
			padding-right: 1rem;
 			margin: auto;
			text-align: center;
		}
		
		.btn{
		    margin-top: 10px;
		    width: 98px;
		    height: 30px;
		    border: none;
		    border-radius: 3px;
		    color: white;
		    transition: all 0.3s;
		    font-size: 15px;
		    padding-top: 5px;
		    font-family: commando;
		    -webkit-text-stroke-width: 0.5px;
		    -webkit-text-stroke-color: #000000;
		    /* text-shadow: 3px 1px 6px rgba(8,31,46,0.78); */
		}
		
		.btn-full {				
		    margin: 20px;
		    width: 100%;
		    background-color: #d5b63f;
		    font-size: 19px;
		    font-weight: bold;
		}
	</style>
</head>
<body>
	<%
		String jsonJogadores = (String)request.getAttribute("jsonJogadores");
	%>
	
	<div class="fullscreen">
		<video src="backgrounds/bg2Video.mp4" autoplay="true" muted="true" loop="true"></video>
		<img src="backgrounds/bg.jpg">
	</div>
	<div class="header-overlay"></div>
	<div class="align-center">
		<div><img src="./logo/INTERESTELLARLOGO-01.png" class="logo"></div>
		<h1 class="titulo">Melhores Jogadores</h1>
		<div>
			<ul>
				<%
					String[] vetJogadores = jsonJogadores.split("-");
					if(vetJogadores.length == 0)
						 out.print("<li class='ranking-list-item' style='text-align: center'> N�o h� pontua��es cadastradas para exibi��o de ranking. </li>");
						
	                for(int i = 0; i < vetJogadores.length; i++){                         
	                    out.print("<li class='ranking-list-item'>" + vetJogadores[i].split(";")[0] + "<span class='spanPts'>" + vetJogadores[i].split(";")[1] + " pts</span></li>");
	                }
                %>
			</ul>
            <a href="pos-login.jsp">
             	<button class="btn btn-full" style="width: 90% !important">Voltar</button>
            </a>
		</div>
	</div>
</body>
</html>
