<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Registrarse</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light navMain">
            <div class="container">

                <a class="navbar-brand " href="logIn.html"><b class="TextColorBackBlack">Inicio</b></a>

                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
                    <form class="form-inline my-2 my-lg-0">
                        <a class="navbar-brand my-2 my-sm-0" href="logIn.jsp" ><b class="TextColorBackBlack">Iniciar sesión</b></a>
                    </form>
                </div>
            </div>
        </nav>
        
        <div class="wrapper">
            <div id="formContent">
                <br>
                <b>Registrarse</b>
                <br>
                <br>
                <form  method="POST" action="SignIn">
                    <input type="text" id="user" name="user" placeholder="Usuario">
                    <input type="text" id="pass" name="pass" placeholder="Contraseña">
                    <input type="text" id="direccion" name="direccion" placeholder="Direccion">
                    <input type="text" id="nombre" name="nombre" placeholder="Nombre">
                    <input type="text" id="telefono" name="telefono" placeholder="Teléfono">
                    <input type="submit" value="Registrarse">
                </form>
                <br>
                <%
                    try {
                        if (request.getParameter("log").length() > 0) {
                %>
                <span><%=request.getParameter("log")%></span>
                <%
                        }
                    } catch (Exception ex) {

                    }
                %>
            </div>
        </div>
        
        <script src="js/jQuery.js" type="text/javascript"></script>
        <script src="bootstrap/js/bootstrap.js" type="text/javascript"></script>
    </body>
</html>
