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
                        <br>
                        <li><a href="/Veterinaria/views/productUp.jsp">Añadir unidades</a></li>
                        <li><a href="/Veterinaria/views/productUp.jsp">Descontar unidades</a></li>
                        <br>
                        <li><a href="/Veterinaria/views/productUp.jsp">Editar información</a></li>
                        <br>
                        <li><a href="/Veterinaria/views/productDel.jsp">Eliminar producto</a></li>
                    </div>
                    <li>
                    </li>
                    <button class="dropdown-btn">Categorias<i class="fa fa-caret-down"></i></button>
                    <div class="dropdown-container">
                        <li><a href="/Veterinaria/CategorySeIn">Listado</a></li>
                        <li><a href="/Veterinaria/views/categoryIn.jsp">Registrar categoria</a></li>
                        <li><a href="/Veterinaria/views/categoryUp.jsp">Editar categoria</a></li>
                        <li><a href="/Veterinaria/views/categoryDel.jsp">Eliminar categoria</a></li>
                    </div>
                    <li><a href="/Veterinaria/ProdUpdateSeIn">Historial de movimientos</a></li>
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
                <form id="formIN" method="post" action="/Veterinaria/ProductSeIn">
                    <input type="text" id="id" name="id" placeholder="Codigo de barras" required>
                    <input type="text" id="name" name="name" placeholder="Nombre producto" required>
                    <input type="textarea" name="description" placeholder="Descripción">
                    <input type="number" name="inStock" min="0" step="1" title="Solo numeros enteros positivos" placeholder="Cantidad en inventario">
                    <input type="number" name="minStock"  min="0" step="1" title="Solo numeros enteros positivos" placeholder="Cantidad minima">
                    <input type="text" id="pC" name="priceIn"  placeholder="Precio compra 00.00">
                    <input type="text" id="pV" name="priceOut"  placeholder="Precio venta 00.00">
                    <div class='word'>
                        Categoria:
                    </div>
                    <select name="r_category" class="sel">
                        <%for (Category pro : cat) {
                        %>          <option class="opt" value="<%=pro.getId()%>"> <%=pro.getCategory()%> </option>
                        <%}%>
                    </select>
                    <button type="submit" id="button"  name="add" title="agregar">Agregar</button>
                </form>
                <%} else {%>
                <div style="color: #def0fb; font-size: 125%">Primero se necesita registrar las categorias
                    <%}%>
                </div>
            </div>
        </div>
        <script src="/Veterinaria/js/menu.js"></script>
        <script src="/Veterinaria/js/floatsVerif.js"></script>
    </body>
</html>

