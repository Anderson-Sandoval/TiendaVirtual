<%-- 
    Document   : addProducto
    Created on : 23-feb-2021, 12:14:25
--%>

<%@page import="logica.*"%>
<%@page import="Consultas.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo producto</title>
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <style>
            label{

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
        <div class="container-xl"  style="background-color: #FFFFFF">
            <div class="row">
                <div class="col-5">
                    <center>
                        <br>
                        <b>Nueva categoria</b>
                        <br>
                        <br>
                        <form method="POST" action="Categoria">
                            <input type="text" id="cat" name="cat" placeholder="categoria" class="form-control">
                            <br>
                            <br>
                            <input type="hidden" value="<%=request.getParameter("user")%>" id="user" name="user"/>
                            <input type="submit" value="Agregar">
                        </form>
                    </center>
                </div>
                <div class="col-1">
                    <div style="border-left:1px solid #eee;height:500px"></div>
                </div>
                <div class="col-5">
                    <center>
                        <br>
                        <b>Nuevo producto</b>
                        <br>
                        <br>
                    </center>
                    <form method="POST" action="nuevoProducto" enctype="multipart/form-data">
                        <label for="categoria" style="align-self: flex-start">Categoria:</label>
                        <select id="categoria" name="categoria" class="form-control" >
                            <%
                                CategoriaDAO catdao= new CategoriaDAO();
                                categoria[] c = catdao.cargarCategoria();
                                for (int i =0; i<c.length;i++) {

                            %>

                            <option value="<%=c[i].getK_idCategoria() %>"><%=c[i].getN_nombreCategoria() %></option>

                            <%
                                }
                            %>

                        </select>
                        <br>
                        <label for="nombre">Nombre:</label>
                        <input type="text" id="nombre" name="nombre" placeholder="Nombre" class="form-control"/>   
                        <br>
                        <label for="precio" >Precio:</label>
                        <input type="number" id="precio" name="precio" placeholder="Precio" class="form-control" />   

                        <br>
                        <br>
                        <input type="file" name="file" id="file" accept=".png,.jpg,.jpeg,.gif">
                        <input type="hidden" value="<%=request.getParameter("user")%>" id="user" name="user"/>
                        <input type="submit" value="Agregar">
                    </form>

                </div>
            </div>
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

        <script src="js/jQuery.js" type="text/javascript"></script>
        <script src="bootstrap/js/bootstrap.js" type="text/javascript"></script>

    </body>
</html>
