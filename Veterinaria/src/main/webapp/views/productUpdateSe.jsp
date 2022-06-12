<%-- 
    Document   : productUpdateSe
    Created on : Jun 11, 2022, 6:28:20 PM
    Author     : olgag
--%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.io.*, java.util.*" %>
<%@ page import="javax.servlet.*, java.text.*" %>
<%@ page import="model.ProdUpdate" %>
<%@page import="model.Product"%>

<!--DOCTYPE html-->
<html lang="es">
    <head>
        <title>Historial productos</title>
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
                        <li><a href="/Veterinaria/views/productADD.jsp">Añadir unidades</a></li>
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
                    <li><a href="/Veterinaria/ProdUpdateSeIn" class="active">Historial de movimientos</a></li>
                </ul>
            </div>

            <div id="right">
                <div class="top">
                    Listado de productos
                </div>
                <%
                    ArrayList<ProdUpdate> prodUps = (ArrayList<ProdUpdate>) session.getAttribute("prodUp");
                    ArrayList<Product> prods = (ArrayList<Product>) session.getAttribute("prod");
                    if (prodUps != null && prodUps.size() > 0) {%>
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>ID Producto</th>
                            <th>Producto</th>
                            <th>Fecha de actualización</th>
                            <th>Usuario</th>
                            <th>Detalles</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (ProdUpdate prodUp : prodUps) {
                                String prod_name = null;
                                for (Product pro : prods) {
                                    if (pro.getId().equals(prodUp.getR_prod())) {
                                        prod_name = pro.getName();
                                    }
                                }
                                out.print("<tr>"
                                        + "<td>" + ((String.valueOf(prodUp.getId()) == null) ? "" : prodUp.getId()) + "</td>"
                                        + "<td>" + ((String.valueOf(prodUp.getR_prod()) == null) ? "" : prodUp.getR_prod()) + "</td>"
                                        + "<td>" + ((prod_name == null) ? "" : prod_name) + "</td>"
                                        + "<td>" + ((prodUp.getUpdatedAt() == null) ? "" : prodUp.getUpdatedAt()) + "</td>"
                                        + "<td>" + ((prodUp.getR_user() == null) ? "" : prodUp.getR_user()) + "</td>"
                                        + "<td>" + ((prodUp.getNotes() == null) ? "" : prodUp.getNotes()) + "</td>"
                                        + "</tr>");
                            }
                        %>
                    </tbody>
                </table>
                <%} else {%>
                <p>No hay información para mostrar
                    <%}%>
            </div>
        </div>
        <script src="/Veterinaria/js/menu.js"></script>
    </body>
</html>
