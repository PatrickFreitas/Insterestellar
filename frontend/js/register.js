let btnConfirma = $('btnConfirma')
btnConfirma.addEventListener('click', registrar)

function registrar(){
    let fldUsuario = $('fldUsuario')
    let fldSenha = $('fldSenha')
    let fldConfirmaSenha = $('fldConfirmaSenha')

    if(!fldUsuario.value.trim()) {
        addRedBorder(fldUsuario)
        return alert('O usuário é de preenchimento obrigatório, por gentileza preencha este campo!')
      } 
    normalizeBorder(fldUsuario)

    if(!fldSenha.value.trim()){
        addRedBorder(fldSenha)
        addRedBorder(fldConfirmaSenha)
        return alert('A senha é de preenchimento obrigatório, por gentileza preencha este campo!')
      }
    normalizeBorder(fldSenha)
    normalizeBorder(fldConfirmaSenha)

    if(fldSenha.value.trim() != fldConfirmaSenha.value.trim()){
        addRedBorder(fldSenha)
        addRedBorder(fldConfirmaSenha)
        return alert('A confirmação da senha está diferente da senha, por favor corrija os campos!')
      }
    normalizeBorder(fldSenha)
    normalizeBorder(fldConfirmaSenha)


}