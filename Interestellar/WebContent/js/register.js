let btnConfirma = $('btnConfirma')
btnConfirma.addEventListener('click', registrar)

function validaExibicaoModal() {
	mensagem = document.getElementById("mensagemCadastro").value;
	if(mensagem != "" && mensagem != null && mensagem != "null")
		alert('Modal:' + mensagem);
}

function registrar(){
    let fldUsuario = $('fldUsuario');
    let fldSenha = $('fldSenha');
    let fldConfirmaSenha = $('fldConfirmaSenha');

    normalizeBorder(fldUsuario);
    normalizeBorder(fldSenha);
    normalizeBorder(fldConfirmaSenha);

    if(!fldUsuario.value.trim()) {
        addRedBorder(fldUsuario)
        return; //alert('O usuário é de preenchimento obrigatório, por gentileza preencha este campo!')
    }

    if(!fldSenha.value.trim()){
        addRedBorder(fldSenha)
        addRedBorder(fldConfirmaSenha)
        return; //alert('A senha é de preenchimento obrigatório, por gentileza preencha este campo!')
    }    

    if(fldSenha.value.trim() != fldConfirmaSenha.value.trim()){
        addRedBorder(fldSenha)
        addRedBorder(fldConfirmaSenha)
        return; //alert('A confirmação da senha está diferente da senha, por favor corrija os campos!')
    }

    if(!fldEmail.value.trim()){
        addRedBorder(fldEmail)
        addRedBorder(fldEmail)
        return; //alert('A confirmação da senha está diferente da senha, por favor corrija os campos!')
    }
    
    $('formCadastro').submit()
}

window.onload = validaExibicaoModal;