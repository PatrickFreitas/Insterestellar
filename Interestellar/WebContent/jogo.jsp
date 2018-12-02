<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="./css/jogo.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.0/animate.min.css">
</head>

<body id="body">
<%
	String usuario = (String)request.getSession().getAttribute("usuario");
	String pontuacao = (String)request.getSession().getAttribute("pontuacao");
%>
<div id="jogo">
    <audio src="./sound/game_over_one.wav" id="gameOver"></audio>
    <audio src="./sound/game_over.4a" id="vozGameOver"></audio>
    <audio src="./sound/interstellar-main-theme.mp3" id="musicaFundo" autoplay loop></audio>

    <div class="container" id="container">
        <div class="animated modal-jogo" id="modal">
            <div class="conteudo-modal">
                <div class="div-logo">
                    <img src="./logo/INTERESTELLARLOGO-01.png" class="logo">
                </div>
                <p class="p-pontuacao">Pontos obtidos:</p>
                <p class="p-pontuacao pontos" id="pontuacao-obtida">999</p>
                <div class="div-btn">
	                <form id="formJogarNovamente" action="RegistrarPontuacao" method="POST" style="width:100%">
	        			<input type="text" name="novaPontuacao" style="display:none" value="10">
                    	<input type="submit" value="Jogar novamente" class="jogar-novamente">
            		</form>
                </div>
            </div>
        </div>
    </div>
    <div class="placar">
        <p class="p-placar" id="nome-jogador"> <%= usuario %></p>
        <p class="p-placar" id="pontuacao">999 Pontos</p>
    </div>
    <div id="jogador">
        <img id="nave" src="./img/ship.png" class="nave">
    </div>
</div>

    <script src="./js/helpers.js"></script>
    <script src="./js/jogo.js"></script>
</body>
</html>