<%-- 
    Document   : productADD
    Created on : Jun 10, 2022, 11:26:19 PM
    Author     : olgag
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.io.*, java.util.*" %>
<%@ page import="javax.servlet.*, java.text.*" %>
<%@ page import="model.Category" %>
<!--DOCTYPE html-->
<html>
    <head>
        <title>Añadir unidades</title>
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
                        <br>
                        <li><a href="/Veterinaria/views/productADD.jsp" class="active">Añadir unidades</a></li>
                        <li><a href="/Veterinaria/views/productDE.jsp">Descontar unidades</a></li>
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
                    <br>
                    <br>
                    <button class="drop-login">Cerrar sesión</button>
                </ul>
            </div>
            <div id="form">
                <div class="top">
                    Añadir unidades
                </div>
                <%
                    String[] res = (String[]) session.getAttribute("resADD");
                    ArrayList<Category> cat = null;
                    if (res == null) {
                %>
                <form method="get" action="/Veterinaria/ProductUp">
                    <input type="text" name="id" placeholder="Codigo de barras" required>
                    <button type="submit" name="search" value="ADD">Editar</button>
                </form>
            </div>
            <%
            } else {
                cat = (ArrayList<Category>) session.getAttribute("cat");
                if (cat != null && cat.size() > 0) {
            %>
            <form method="post" action="/Veterinaria/ProductUp">
                <div class="word">Codigo: </div>
                <input type="text" name="id" value="<%=res[0]%>" readonly>
                <div class="word">Cantidad actual:</div>
                <input type="text" name="inStock" value="<%=(res[3].equals("-1")) ? 0 : res[3]%>" readonly>
                <div class="word">Cantidad a agregar:</div>
                <input type="number" min="0" step="1" name="upStock">
                <button type="submit" name="up" value="add">Agregar</button>
            </form>
            <%} else {%>
            <div style="color: #def0fb; font-size: 125%">Primero se necesita registrar las categorias
            </div>
            <%}%>
            <%
                }
            %>
        </div>
        <script src="/Veterinaria/js/menu.js"></script>
    </body>
</html>
