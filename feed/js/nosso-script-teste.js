var
    img = document.getElementById('img-ods'),
      txtColor = document.querySelectorAll("a:not(.notOds), a:hover"),
    bgColor = document.querySelectorAll(".bg-primary, .btn-primary, .nav-pills .nav-link.active, .btn-primary:hover, .painel-ods"),
    brdrColor = document.querySelectorAll(".btn-primary, .btn-primary:hover, .nav-tabs .nav-link.active"),
    brdrTransp = document.querySelectorAll('.card, textarea.form-control');

var ods = [
    "#e52e3d",
    "#e5b735",
    "#4c9f38",
    "#c5192d",
    "#ff3a21",
    "#26bde2",
    "#fcc30b",
    "#a21942",
    "#fd6925",
    "#dd1367",
    "#fd9d24",
    "#c9992d",
    "#3f7e44",
    "#0a97d9",
    "#56c02b",
    "#00689d",
    "#19486a"
];


// aqui eu declaro o q é a função
function start(counter){
  
    setTimeout(function(){

      // aqui eu passo tudo aquilo q precisa de um counter (1~17) 
      console.log(counter);
      img.src = "imagens/paineis-ods/ods"+(counter+1)+".png";
        txtColor.forEach((a) => {
            a.style.color = ods[counter];
        });
        bgColor.forEach((b) => {
            b.style.backgroundColor = ods[counter];
        });
        brdrColor.forEach((bc) => {
            bc.style.borderColor = ods[counter];
        })
        brdrTransp.forEach((bt) => {
            bt.style.borderColor = ods[counter];
        })
      // ...
      
      // aqui o counter atualiza e garante que fique em loop 
      counter++;
      if(counter>16){
          counter = 0;
      }
	  start(counter);
    }, 4000);
  
}

// aqui eu chamo
start(0);
