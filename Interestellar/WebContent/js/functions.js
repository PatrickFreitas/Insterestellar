
function $(idDoCampo){
    return document.getElementById(idDoCampo)
  }

function addRedBorder(field){
    field.style.borderColor = 'red'
}

function normalizeBorder(field){
    field.style.borderColor = '#ffffffff'
}

function playAudio(nomeAudio, volum){
	urlAudio = './sound/' + nomeAudio + '.wav';
	var audio = new Audio(urlAudio);
	audio.volume = volum;
    audio.play();
}

function pauseAudio(audio){
    audio.pause();
    audio.currentTime = 0;
}

function playKeySound(){
	var ad = new Audio('./sound/key-sound.wav');
	ad.play();
    return false;
}

window.onload = function(){
	document.getElementsByClassName("header-overlay")[0].addEventListener("mousemove", ativarBackgroundSound);
}

function ativarBackgroundSound() {
	backgroundSound = new Audio('./sound/interstellar-main-theme.mp3'); 
	backgroundSound.addEventListener('ended', function() {
	    this.currentTime = 0;
	    this.play();
	}, false);
	backgroundSound.play();
	removeBackgroundSoundHandler()
}

function removeBackgroundSoundHandler() {
    document.getElementsByClassName("header-overlay")[0].removeEventListener("mousemove", ativarBackgroundSound);
}

let inputs = document.getElementsByClassName('inputText');

/*
for(input in inputs){
  input.addEventListener('focus', function(){
    input.style.backgroundPositionX = 'right';
    input.style.backgroundPositionY = '0px';
  })
  input.addEventListener('blur', function(){
    input.style.backgroundPositionX = 'rightpx';
    input.style.backgroundPositionY = '-1920px';
  })
} */