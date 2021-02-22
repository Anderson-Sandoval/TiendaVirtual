var btnSesion = document.getElementById('inicio-sesion');
var btnReg = document.getElementById('registro-sesion');
var registro = document.getElementById('registro');
var login = document.getElementById('login');

btnSesion.addEventListener('click',function(){
    login.classList.toggle('esconder');
    registro.classList.toggle('mostrando');
})
btnReg.addEventListener('click',function(){
    login.classList.toggle('esconder');
    registro.classList.toggle('mostrando');
})