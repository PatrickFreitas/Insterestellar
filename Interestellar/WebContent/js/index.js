let btnLogin = $('btnLogin')

btnLogin.addEventListener('click', validarFormulario)

function validarFormulario(){
  let fldUsuario = $('fldUsuario');
  let fldSenha = $('fldSenha');

  normalizeBorder(fldUsuario)
  normalizeBorder(fldSenha)
  
  if(!fldUsuario.value.trim()) {
    addRedBorder(fldUsuario)
    return; //alert('O usuário é de preenchimento obrigatório, por gentileza preencha este campo!')
  } 
  
  if(!fldSenha.value.trim()){
    addRedBorder(fldSenha)
    return; //alert('A senha é de preenchimento obrigatório, por gentileza preencha este campo!')
  }
  
  $('formLogin').submit();
}
