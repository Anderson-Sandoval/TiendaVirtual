<%-- 
    Document   : compras
    Created on : 23-feb-2020, 17:02:14
    Author     : carlos lopez
--%>

<%@page import="SQL.producto"%>
<%@page import="SQL.compras"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Tienda</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>

        <style>
            .producto{

            }
        </style>

    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light navMain"  style="box-shadow: 0 30px 60px 0 rgba(0,0,0,0.1);">
            <div class="container">

                <a class="navbar-brand " href="tienda.jsp?user=<%=request.getParameter("user")%>"><b>&#8226; Inicio</b></a>
                <a class="navbar-brand " href="addProducto.jsp?user=<%=request.getParameter("user")%>"><b>&#8226; Agregar un producto</b></a>

                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
                    <a class="navbar-brand my-2 my-sm-0" href="compras.jsp?user=<%=request.getParameter("user")%>" ><b class="TextColorBackBlack">&#8226; Mis compras</b></a>
                    <a class="navbar-brand my-2 my-sm-0" href="carrito.jsp?user=<%=request.getParameter("user")%>" ><b class="TextColorBackBlack">&#8226; Mi carrito</b></a>
                    <a class="navbar-brand my-2 my-sm-0" href="logIn.jsp" ><b class="TextColorBackBlack">&#8226; Salir</b></a>
                </div>
            </div>
        </nav>
        <br>
        <div class="container-xl" style="background-color: #FFFFFF;">
            <br>

            <div class="producto">
                <%
                    compras c = new compras();
                    for (producto pr : c.consultaCompras(request.getParameter("user"))) {
                %>
                <form method="POST" action="logIn">

                    <hr>
                    <div class="row">

                        <div class="offset-1 col-10">
                            <div class="row">
                                <div class="col-sm-3">
                                    <h3>
                                        <%=pr.id%>
                                    </h3>
                                </div>
                                <div class="col-sm-4">
                                    <b>
                                        <%= pr.nombre%>
                                    </b>
                                </div>
                                <div class="col-sm-1">
                                    <b>
                                        <%= pr.precio%>
                                    </b>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
                <%
                    }

                %>

            </div>
            <br>
            <hr>
            <br>
        </div>




        <script src="js/jQuery.js" type="text/javascript"></script>
        <script src="bootstrap/js/bootstrap.js" type="text/javascript"></script>
    </body>
</html>