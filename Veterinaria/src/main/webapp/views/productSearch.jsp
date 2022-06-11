<%-- 
    Document   : productSearch
    Created on : Jun 10, 2022, 5:07:52 PM
    Author     : olgag
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.io.*, java.util.*" %>
<%@ page import="javax.servlet.*, java.text.*" %>
<%@ page import="model.Category" %>
<!--DOCTYPE html-->
<html>
    <head>
        <title>Editar Producto</title>
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
                        <li><a href="/Veterinaria/ProductR_Category">Registrar producto</a></li>

                        <li><a href="/Veterinaria/views/productUp.jsp">Añadir unidades</a></li>
                        <li><a href="/Veterinaria/views/productUp.jsp">Descontar unidades</a></li>

                        <li><a href="/Veterinaria/views/productUp.jsp" class="active">Editar información</a></li>

                        <li><a href="/Veterinaria/views/productUp.jsp">Desactivar producto</a></li>
                        <li><a href="/Veterinaria/views/productUp.jsp">Ractivar producto</a></li>

                        <li><a href="/Veterinaria/views/productDel.jsp" class="active">Eliminar producto</a></li>
                    </div>
                    <li><a href="/Veterinaria/productUpdateSe">Historial de movimientos</a></li>
                </ul>
            </div>
            <div id="form">
                <div class="top">
                    Editar información producto
                </div>
                <%
                    String[] res = (String[]) session.getAttribute("result");
                    ArrayList<Category> cat = (ArrayList<Category>) session.getAttribute("cat");
                    
                    if (cat != null && cat.size() > 0) {
                %>
                <form method="post" action="/Veterinaria/ProductUp">
                    <input type="text" name="id" placeholder="Codigo de barras" required value="<%=res[0]%>">
                    <input type="text" name="name" <% if (res[1] == null) {%> placeholder="Nombre producto">
                    <%} else {%> value="<%=res[1]%>">
                    <%}%>
                    <input type="textarea" name="description" <% if (res[2] == null) {%> placeholder="Descripción">
                    <%} else {%> value="<%=res[2]%>">
                    <%}%>
                    <input type="text" name="inStock" <% if (res[3].equals("-1")) {%> placeholder="Cantidad en inventario">
                    <%} else {%> value="<%=res[3]%>">
                    <%}%>
                    <input type="text" name="minStock" <% if (res[4].equals("-1")) {%> placeholder="Cantidad minima">
                    <%} else {%> value="<%=res[4]%>">
                    <%}%>
                    <input type="text" name="priceIn" <% if (res[5].equals("-1.0")) {%> placeholder="Precio compra">
                    <%} else {%> value="<%=res[5]%>">
                    <%}%>
                    <input type="email" name="priceOut" <% if (res[6].equals("-1.0")) {%> placeholder="Precio venta">
                    <%} else {%> value="<%=res[6]%>">
                    <%}%>
                    <div class="word">Categoria:</div>
                    <select name="r_category">
                        <%for (Category cate : cat) {
                        %>          
                        <option value="<%=String.valueOf(cate.getId())%>" <%if (cate.getId() == Integer.parseInt(res[7])) {%> selected <%}%> > <%=cate.getCategory()%> </option>
                        <%}%>
                    </select>
                    <div class="word">Estado:</div>
                    <select name="isActive">
                        <option value="si" <%if (res[8].equals("si")) {%> selected <%}%> > Activo </option>
                        <option value="no" <%if (res[8].equals("no")) {%> selected <%}%> > Inactivo </option>
                    </select>

                    <button type="submit" name="add" title="agregar">Agregar</button>
                </form>
                <%} else {%>
                <div style="color: #def0fb; font-size: 125%">Primero se necesita registrar las categorias
                    <%}%>
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
