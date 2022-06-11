<%-- 
    Document   : productSe
    Created on : Jun 10, 2022, 5:07:29 PM
    Author     : olgag
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.io.*, java.util.*" %>
<%@ page import="javax.servlet.*, java.text.*" %>
<%@ page import="model.Product" %>
<%@page import="model.Category" %>

<!--DOCTYPE html-->
<html>
    <head>
        <title>Productos</title>
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
                        <li><a href="/Veterinaria/ProductSeIn" class="active">Listado</a></li>
                        <li><a href="/Veterinaria/ProductR_Category">Registrar producto</a></li>
                        
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

            <div id="right">
                <div class="top">
                    Listado de productos
                </div>
                <%
                    ArrayList<Product> pro = (ArrayList<Product>) session.getAttribute("prod");
                    ArrayList<Category> cats = (ArrayList<Category>) session.getAttribute("cat");
                    if (pro != null && pro.size() > 0) {%>
                <table>
                    <thead>
                        <tr>
                            <th>Codigo</th>
                            <th>Producto</th>
                            <th>Descripción</th>
                            <th>Inventario</th>
                            <th>Min. inventario</th>
                            <th>Precio compra</th>
                            <th>Precio venta</th>
                            <th>Categoria</th>
                            <th>Fecha creación</th>
                            <th>Fecha actualización</th>
                            <th>Estado</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Product prod : pro) {
                                String cat_name = null;
                                for (Category cat : cats) {
                                    if (cat.getId() == prod.getR_category()) {
                                        cat_name = cat.getCategory();
                                    }
                                }
                                out.print("<tr>"
                                        + "<td>" + ((String.valueOf(prod.getId()) == null) ? "" : prod.getId()) + "</td>"
                                        + "<td>" + ((prod.getName() == null) ? "" : prod.getName()) + "</td>"
                                        + "<td>" + ((prod.getDescription() == null) ? "" : prod.getDescription()) + "</td>"
                                        + "<td>" + ((prod.getInStock() == -1) ? "" : prod.getInStock()) + "</td>"
                                        + "<td>" + ((prod.getMinStock() == -1) ? "" : prod.getMinStock()) + "</td>"
                                        + "<td>" + ((prod.getPriceIn() == -1) ? "" : prod.getPriceIn()) + "</td>"
                                        + "<td>" + ((prod.getPriceOut() == -1) ? "" : prod.getPriceOut()) + "</td>"
                                        + "<td>" + ((cat_name == null) ? "" : cat_name) + "</td>"
                                        + "<td>" + ((prod.getCreatedAt() == null) ? "" : prod.getCreatedAt()) + "</td>"
                                        + "<td>" + ((prod.getUpdatedAt() == null) ? "" : prod.getUpdatedAt()) + "</td>"
                                        + "<td>" + ((prod.getIsActive()) ? "Activo" : "Inactivo" ) + "</td>"
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
