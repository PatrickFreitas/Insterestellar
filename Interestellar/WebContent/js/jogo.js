let nave = $('nave')
let coords = nave.getBoundingClientRect()
let naveTop = coords.x + nave.clientHeight
nave.style.top = naveTop + 'px'

const h = window.innerHeight

$('jogo').addEventListener('click', function(){

  requestAnimationFrame(subir)
})

function subir(){
  if(parseFloat(nave.style.top) >= 15) {
    naveTop -= 15
    movimentarNave()
  }
}

function movimentarNave(){
  console.log(parseFloat(nave.style.top))
  nave.style.top = naveTop + 'px'

}

function descer(){
  naveTop += 15
  movimentarNave()
}

function createBox(){
  let areaVoo = $('area-voo')
  let box = document.createElement('div')
  box.classList.add('superior')
  box.classList.add('box')
  let w = areaVoo.clientWidth
  box.style.left = w + 'px'
  areaVoo.appendChild(box)
  goToLeft(box)

  let h = areaVoo.clientHeight

  let anotherBox = document.createElement('div')
  anotherBox.classList.add('inferior')
  anotherBox.classList.add('box')

  anotherBox.style.top = (h - 50) + 'px'

  anotherBox.style.left = w + 'px'
  areaVoo.appendChild(anotherBox)

  // console.log(anotherBox.getBoundingClientRect())

  goToLeft(anotherBox)

}


function goToLeft(box){
  let left = parseFloat(box.style.left)

  let timeout = setTimeout(function(){
    goToLeft(box)
  }, 20)

  if(left >= 10){

    box.style.left = (left -= 3) + 'px'

    if(box.classList[0] == 'superior'){
      if(detectarColisaoSuperior(box)){
        clearTimeout(timeout)
      }
    } else {
      if(detectarColisaoInferior(box)){
        clearTimeout(timeout)
      }
    }

  } else {
    clearTimeout(timeout)

    box.parentNode.removeChild(box)

  }
}


// // para produção
// setInterval(function(){
//   createBox()
// }, 1000)

// enquanto estiver testando
setTimeout(function(){
  createBox()
}, 1000)


function detectarColisaoSuperior(obstaculo){
  let box = obstaculo.getBoundingClientRect()
  let nave = $('nave').getBoundingClientRect()

  if(nave.top <= box.bottom ){
    if(nave.right >= box.left && nave.right <= box.right){
      alert('colidiu')
      return true
    }
  }
}

function detectarColisaoInferior(obstaculo){
  let box = obstaculo.getBoundingClientRect()
  let nave = $('nave').getBoundingClientRect()

  if(nave.bottom >= box.top ){
    if(nave.right >= box.left && nave.right <= box.right){
      alert('colidiu')
      return true
    }
  }
}

document.body.onkeyup = function(e){

  // espaço para subir
  if(e.which === 32){
    subir()
  }

  // R para descer
  if(e.which === 82){
    descer()
  }
}