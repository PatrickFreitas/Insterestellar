/*
* ------------- DECLARAÇÕES DE VARIÁVEIS E INVOCAÇÕES DE FUNÇÕES -------------
*/
let nave = $('nave');
let coords = nave.getBoundingClientRect();
let naveTop = coords.x + nave.clientHeight;
nave.style.top = naveTop + 'px';

const wHeight = window.innerHeight;
let areaVoo = $('jogo');
let interagiu = false;
let continuar = true;
posicionarNave()
gravidade()

// // para produção
setInterval(function () {
  if (continuar) {
    createBox()
  }
}, 1000)

// enquanto estiver testando
// setTimeout(function(){
//   createBox()
// }, 1000)

$('body').addEventListener('click', function () {
  requestAnimationFrame(subir)
})

document.body.onkeyup = function (e) {
  // espaço para subir
  if (e.which === 32) {
    subir();
  }

  // R para descer
  if (e.which === 82) {
    descer();
  }
}

/*
* ------------- DEFINIÇÕES DE FUNÇÕES -------------
*/

function subir() {
  if (!interagiu) {
    interagiu = true
  }

  if (parseFloat(nave.style.top) >= 15 && continuar) {
    naveTop -= 50
    movimentarNave()
  }
}

function movimentarNave() {
  // console.log(parseFloat(nave.style.top))
  nave.style.top = naveTop + 'px'
}

function descer() {
  naveTop += 15
  movimentarNave()
}

function createBox() {
  let box = document.createElement('div');
  box.classList.add('superior');
  box.classList.add('box');
  let w = areaVoo.clientWidth;
  box.style.left = w + 'px';
  areaVoo.appendChild(box);
  goToLeft(box);

  let h = areaVoo.clientHeight;

  let anotherBox = document.createElement('div');
  anotherBox.classList.add('inferior')
  anotherBox.classList.add('box')

  anotherBox.style.top = (h - 50) + 'px'

  anotherBox.style.left = w + 'px'
  areaVoo.appendChild(anotherBox)

  goToLeft(anotherBox)

}

function posicionarNave() {
  naveTop = wHeight / 2;
  movimentarNave()
}

function goToLeft(box) {
  if (!continuar) return;

  let left = parseFloat(box.style.left);

  let timeout = setTimeout(function () {
    goToLeft(box)
  }, 20);

  if (left >= 10) {
    box.style.left = (left -= 3) + 'px'

    if (box.classList[0] == 'superior') {
      if (detectarColisaoSuperior(box)) {
        clearTimeout(timeout)
      }
    } else {
      if (detectarColisaoInferior(box)) {
        clearTimeout(timeout)
      }
    }

  } else {
    clearTimeout(timeout)
    box.parentNode.removeChild(box)

  }
}

function gravidade() {
  if (interagiu && continuar) {
    // console.log(naveTop)
    naveTop += 5
    movimentarNave()
  }
  setTimeout(function () {
    gravidade()
  }, 75)
}

function alertModal() {
    $("musicaFundo").pause();
    $("gameOver").play();
    $("vozGameOver").play();
    $('modal').classList.add('bounceIn');
    $('container').style.display = 'block';
    $('nave').style.display = 'none';
    $('modal').style.display = 'flex';
    setTimeout(function () {
      $('modal').classList.add('bounceIn');
    },1000)
    setTimeout(function () {
        $("gameOver").pause();
        $("vozGameOver").pause();
    },10000)
}


function detectarColisaoSuperior(obstaculo) {
  let box = obstaculo.getBoundingClientRect();
  let nave = $('nave').getBoundingClientRect();

  if (nave.top <= box.bottom) {
    if (nave.right >= box.left && nave.right <= box.right) {
      alertModal();
      continuar = false
      return true
    }
  }
}

function detectarColisaoInferior(obstaculo) {
  let box = obstaculo.getBoundingClientRect();
  let nave = $('nave').getBoundingClientRect();

  if (nave.bottom >= box.top) {
    if (nave.right >= box.left && nave.right <= box.right) {
      alertModal();
      continuar = false
      return true
    }
  }
}