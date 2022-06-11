<%-- 
    Document   : productIn
    Created on : Jun 10, 2022, 5:07:20 PM
    Author     : olgag
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.io.*, java.util.*" %>
<%@ page import="javax.servlet.*, java.text.*" %>
<%@ page import="model.Category" %>

<!--DOCTYPE html-->
<html>
    <head>
        <title>Registar producto</title>
        <meta charset="UTF-8">        
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link href="https://fonts.googleapis.com/css?family=Nunito&display=swap" rel="stylesheet"> 
        <link href="https://fonts.googleapis.com/css?family=Overpass&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="/Veterinaria/style/standard.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style type="text/css"></style>
    </head>
    <body>
        <div id="container"> 
            <div id="left">
                <ul>
                    <button class="dropdown-btn">Inventario<i class="fa fa-caret-down"></i></button>
                    <div class="dropdown-container">
                        <li><a href="/Veterinaria/ProductSeIn">Listado</a></li>
                        <li><a href="/Veterinaria/ProductR_Category" class="active">Registrar producto</a></li>
                        
                        <li><a href="/Veterinaria/views/productUp.jsp">Añadir unidades</a></li>
                        <li><a href="/Veterinaria/views/productUp.jsp">Descontar unidades</a></li>
                        
                        <li><a href="/Veterinaria/views/productUp.jsp">Editar información</a></li>
                        
                        <li><a href="/Veterinaria/views/productUp.jsp">Desactivar producto</a></li>
                        <li><a href="/Veterinaria/views/productUp.jsp">Ractivar producto</a></li>
                        
                        <li><a href="/Veterinaria/views/productDel.jsp">Eliminar producto</a></li>
                    </div>
                    <li><a href="/Veterinaria/productUpdateSe">Historial de movimientos</a></li>
                </ul>
            </div>
            <div id="form">
                <div class="top">
                    Registrar producto
                </div>
                <%
                    ArrayList<Category> cat = (ArrayList<Category>) session.getAttribute("cat");
                    if (cat != null && cat.size() > 0) {
                %>
                <form method="post" action="/Veterinaria/ProductSeIn">
                    <input type="text" name="id" placeholder="Cordigo de barras" required>
                    <input type="text" name="name" placeholder="Nombre producto" required>
                    <input type="textarea" name="description" placeholder="Descripción">
                    <input type="text" name="inStock" placeholder="Cantidad en inventario">
                    <input type="text" name="minStock" placeholder="Cantidad minima">
                    <input type="text" name="priceIn" placeholder="Precio compra">
                    <input type="email" name="priceOut" placeholder="Precio venta">
                    <div class='word'>
                        Categoria:
                    </div>
                    <select name="r_category" class="sel">
                        <%for (Category pro : cat) {
                        %>          <option class="opt" value="<%=pro.getId()%>"> <%=pro.getCategory()%> </option>
                        <%}%>
                    </select>
                    <button type="submit" name="add" title="agregar">Agregar</button>
                </form>
                <%} else {%>
                <div style="color: #def0fb; font-size: 125%">Primero se necesita registrar las categorias
                    <%}%>
                </div>
            </div>
        </div>
        <script>
            var dropdown = document.getElementsByClassName("dropdown-btn");
            var i;

            for (i = 0; i < dropdown.length; i++) {
                dropdown[i].addEventListener("click", function () {
                    this.classList.toggle("active");
                    var dropdownContent = this.nextElementSibling;
                    if (dropdownContent.style.display === "block") {
                        dropdownContent.style.display = "none";
                    } else {
                        dropdownContent.style.display = "block";
                    }
                });
            }
        </script>
    </body>
</html>

