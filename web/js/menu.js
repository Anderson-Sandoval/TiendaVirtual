var btnMenu = document.getElementById('btn-menu');
var nav = document.getElementById('nav-menu');
var up = document.getElementById('btn-inicio');

btnMenu.addEventListener('click',function () {
    nav.classList.toggle('mostrar');
})

if(document.body.scrollTop == 0){
    up.classList.toggle('ocultar');
    console.log("0");
}
if(document.body.scrollTop != 0){
    up.classList.toggle('mostrar'); 
    console.log("1");
}