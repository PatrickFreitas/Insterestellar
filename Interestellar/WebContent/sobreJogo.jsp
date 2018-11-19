<%@ page language="java" contentType="text/html;" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sobre o jogo</title>
    <link rel="shortcut icon" href="logo/INTERESTELLARLOGO-01.png"/>
    <link rel="stylesheet" href="./css/sobreJogo.css">
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
    <div class="col-dg-10 col-dm-10 col-10 align-center">
        <img src="logo/INTERESTELLARLOGO-01.png" class="logo">
        <h1 class="titulo">Jogabilidade</h1>
        <div class="centralDiv ranking-list-item">
            <p class="paragrafo">Interestellar tem como objetivo ganhar o maior numero possivel de pontos, controlando uma nave espacial (tocando na tela) sem deixa-la colidir nos obstaculos. Se a nave tocar em algum obstaculo ou se deixar a nave cair, o jogo termina. Sempre que o personagem passa por um conjunto de obstaculos, o jogador ganha um ponto.</p>
        </div>
        <h1 class="titulo">Tecnologias / Programadores</h1>
        <div class="centralDiv ranking-list-item">
            <p class="paragrafo">Interestellar foi criado e desenvolvido por Patrick Freitas, Luiz Fernando e Lukas Rodrigo. O jogo foi criado na disciplina de Projeto Integrador II</p>
        </div>
        <div style="width: 100%">
            <a href="register.jsp"><button type="button" class="btn colorBtn2">Cadastrar</button></a>
        </div>
    </div>
</header>
</body>
</html>