<%-- 
    Document   : productUp
    Created on : Jun 10, 2022, 5:07:42 PM
    Author     : olgag
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.io.*, java.util.*" %>
<%@ page import="javax.servlet.*, java.text.*" %>
<!--DOCTYPE html-->
<html>
    <head>
        <title>Editar producto</title>
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
                        
                        <li><a href="/Veterinaria/views/productDel.jsp">Eliminar producto</a></li>
                    </div>
                    <li><a href="/Veterinaria/productUpdateSe">Historial de movimientos</a></li>
                </ul>
            </div>
            <div id="form">
                <div class="top">
                    Editar información producto
                </div>
                <form method="get" action="/Veterinaria/ProductUp">
                    <input type="text" name="id" placeholder="Codigo de barras" required>
                    <button type="submit" name="search" title="buscar">Editar</button>
                </form>
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


