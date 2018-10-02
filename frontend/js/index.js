let btnLogin = $('btnLogin')
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

function playAudio(){
  let audio = $('audio')
  audio.play()
}

function pauseAudio(){
  let audio = $('audio')
  audio.pause()
  audio.currentTime = 0
}

btnLogin.addEventListener('click', validarFormulario)

function validarFormulario(){
  let fldUsuario = $('fldUsuario')
  let fldSenha = $('fldSenha')

  if(!fldUsuario.value.trim()) {
    addRedBorder(fldUsuario)
    return alert('O usuário é de preenchimento obrigatório, por gentileza preencha este campo!')
  } 
  normalizeBorder(fldUsuario)
  
  if(!fldSenha.value.trim()){
    addRedBorder(fldSenha)
    return alert('A senha é de preenchimento obrigatório, por gentileza preencha este campo!')
  }
  normalizeBorder(fldSenha)

  console.log(fldUsuario.value)
  console.log(fldSenha.value)
}
