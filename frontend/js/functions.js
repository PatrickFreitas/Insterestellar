
function $(idDoCampo){
    return document.getElementById(idDoCampo)
  }

function addRedBorder(field){
    field.style.borderColor = 'red'
}

function normalizeBorder(field){
    field.style.borderColor = '#ffffffff'
}

function playAudio(){
    let audio = $('audio')
    audio.play()
}

function pauseAudio(){
    let audio = $('audio')
    audio.pause()
    audio.currentTime = 0
}

let inputs = document.getElementsByClassName('inputText')

for(let input of inputs){
  input.addEventListener('focus', function(){
    input.style.backgroundPositionX = 'right';
    input.style.backgroundPositionY = '0px';
  })
  input.addEventListener('blur', function(){
    input.style.backgroundPositionX = 'rightpx';
    input.style.backgroundPositionY = '-1920px';
  })
}