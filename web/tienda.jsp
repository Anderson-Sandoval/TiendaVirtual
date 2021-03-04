
                
                
                
                
                
                
                
                <%@page import="logica.usuario"%>


<%@page import="java.nio.file.Files"%>
<%@page import="java.io.InputStream"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.Image"%>
<%@page import="logica.*"%>
<%@page import="Consultas.*"%>
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
        <div class="container-xl" style="background-color: #FFFFFF">
            <div>
                <br>
                <div class="row">
                    <div class="col-sm-5">

                        <label for="sCategoria">Categoria</label>
                        <select id="sCategoria" name="sCategoria" class="form-control" >
                            <option value="%">todos</option>
                            <%
                                CategoriaDAO c = new CategoriaDAO();
                                categoria[] categorias=c.cargarCategoria();
                                for (int i=0;i<categorias.length;i++) {
                            %>

                            <option value="<%=categorias[i].getK_idCategoria()  %>"><%=categorias[i].getN_nombreCategoria() %></option>

                            <%
                                }
                            %>
                        </select>

                    </div>
                    <div class="col-sm-3">
                        <label for="contenido">contenido:</label>
                        <input type="text" id="contenido" name="contenido" placeholder="¿que quiere buscar?" class="form-control" />
                    </div>
                    <div class="col-sm-3">
                        <br>
                        <input type="hidden" value="<%=request.getParameter("user")%>" id="user" name="user"/>
                        <button type="submit" value="Filtrar" class="form-control btn btn-primary" onclick="filtrar()">Filtrar</button>
                    </div>

                </div>
            </div>
        </div>
        <br>
        <div class="container-xl" style="background-color: #FFFFFF">
            <br>

            <div class="producto">
                <%
                    producto p = new producto();
                    String param = "";
                    try {
                        param = request.getParameter("param");
                    } catch (Exception ex) {
                        param = "%";
                    }

                    if (param == null) {
                        param = "%";
                    }

                    if (param.length() <= 0) {
                        param = "%";
                    }
                    ProductoDAO pdao=new ProductoDAO();
                    producto[]productos=pdao.cargarProducto();
                    for (int i =0;i<productos.length;i++) {

                %>
                <form method="POST" action="AgregarACarrito">

                    <hr>
                    <div class="row">

                        <div class="col-sm-1">
                            <h3>
                                <%=productos[i].getK_idProducto() %>
                            </h3>
                        </div>
                        <div class="col-sm-2">
                            <h3>

                                <img src="data:image/jpg;base64,<%=productos[i].getArchivo() %>" width="100" height="100" alt="sin imagen"/>
                            </h3>
                        </div>
                        <div class="col-sm-4">
                            <b>
                                <%= productos[i].getK_idCategoria() %> - <%= productos[i].getN_nombreProducto() %>
                            </b>
                        </div>
                        <div class="col-sm-1">
                            <b>
                                <%= productos[i].getQ_valorProducto() %>
                            </b>
                        </div>
                        <div class="col-sm-2">
                            <input type="hidden" value="<%=request.getParameter("user")%>" id="user" name="user"/>
                            <input type="hidden" value="<%=productos[i].getK_idProducto()  %>" id="prod" name="prod"/>
                            <input type="submit" class="btn btn-primary" value="Agregar al carrito"/>
                        </div>
                    </div>
                </form>
                <%
                    }

                %>

            </div>
        </div>

    </div>
    <br>
    <hr>
    <br>
</div>




<script src="js/jQuery.js" type="text/javascript"></script>
<script src="bootstrap/js/bootstrap.js" type="text/javascript"></script>
<script>

                            function filtrar() {
                                var cat = $("#sCategoria [value="+$("#sCategoria")[0].value+"]")[0].innerHTML;
                                var text = $("#contenido")[0].value;
                                $(".producto form").each(function () {
                                    $(this).show();
                                });
                                
                                $(".producto form").each(function () {
                                    if (cat == "%" && text.trim() == "") {
                                        $(this).show();
                                    } else if (cat == "%" && text.trim() != "") {
                                        if (this.children[1].children[2].textContent.includes(text)) {
                                            $(this).show();
                                        } else {
                                            $(this).hide();
                                        }
                                    } else if (cat != "%" && text.trim() == "") {
                                        if (this.children[1].children[2].textContent.includes(cat)) {
                                            $(this).show();
                                        } else {
                                            $(this).hide();
                                        }
                                    } else {
                                        if (this.children[1].children[2].textContent.includes(cat) || this.children[1].children[2].textContent.includes(text)) {
                                            $(this).show();
                                        } else {
                                            $(this).hide();
                                        }
                                    }



                                });
                            }

</script>
</body>
</html>