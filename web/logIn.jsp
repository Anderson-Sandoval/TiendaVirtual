<!DOCTYPE html>
<html>
    <head>
        <title>Log in</title>
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

                <div class="collapse navbar-collapse  justify-content-end" id="navbarSupportedContent">
                    <form class="form-inline my-2 my-lg-0">
                        <a class="navbar-brand " href="SingIn.jsp"><b class="TextColorBackBlack">Registrarse</b></a>
                    </form>
                </div>
            </div>
        </nav>
        <div class="wrapper" style="background-color: rgba (255, 0,0,0.5)">
            <div id="formContent" class="divUno">
                
                <br>
                <b>iniciar sesión</b>
                <br>
                <br>
                <form method="POST" action="logIn">
                    <input type="text" id="user" name="user" placeholder="Usuario">
                    <input type="text" id="pass" name="pass" placeholder="Contraseña">
                    <input type="submit" value="Ingresar">
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
