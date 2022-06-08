<%-- 
    Document   : ownerSearch
    Created on : Jun 6, 2022, 9:35:55 PM
    Author     : olgag
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.io.*, java.util.*" %>
<%@ page import="javax.servlet.*, java.text.*" %>
<!--DOCTYPE html-->
<html>
    <head>
        <title>Editar Dueño</title>
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
                    <button class="dropdown-btn">Dueños
                        <i class="fa fa-caret-down"></i>
                    </button>
                    <div class="dropdown-container">
                        <li><a href="/Veterinaria/OwnerSeIn">Listado</a></li>
                        <li><a href="/Veterinaria/views/ownerIn.jsp">Agregar</a></li>
                        <li><a href="/Veterinaria/views/ownerUp.jsp" class="active">Editar</a></li>
                        <li><a href="/Veterinaria/views/ownerDel.jsp">Eliminar</a></li>
                    </div>
                    <button class="dropdown-btn">Mascotas
                        <i class="fa fa-caret-down"></i>
                    </button>
                    <div class="dropdown-container">
                        <li><a href="/Veterinaria/PetSeIn">Listado</a></li>
                        <li><a href="/Veterinaria/views/petIn.jsp">Agregar</a></li>
                        <li><a href="/Veterinaria/views/petUp.jsp">Editar</a></li>
                        <li><a href="/Veterinaria/views/petDel.jsp">Eliminar</a></li>
                    </div>
                    <li><a href="/Veterinaria/ApptSeIn">Citas</a></li>
                    <li><a href="/Veterinaria/views/apptInS.jsp">Agendar cita salon</a></li>
                    <li><a href="/Veterinaria/views/apptInC.jsp">Agendar consulta</a></li>
                    <li><a href="/Veterinaria/views/apptInH.jsp">Internar</a></li>
                </ul>
            </div>
            <div id="form">
                <div class="top">
                    Editar información dueño
                </div>
                <%
                    String[] res = (String[]) session.getAttribute("result");
                %>
                <form method="post" action="/Veterinaria/OwnerUp">
                    <input type="text" name="ine" required value="<%=res[6]%>">
                    <input type="text" name="name" <% if (res[0] == null) {%> placeholder="Nombre">
                    <%} else {%> value="<%=res[0]%>">
                    <%}%>
                    
                    <input type="date" name="bdate" <% if (res[1] == null) {%>>
                    <%} else {%> value="<%=res[1]%>">
                    <%}%>

                    <input type="text" name="addr" <% if (res[2] == null) {%> placeholder="Domicilio">
                    <%} else {%> value="<%=res[2]%>">
                    <%}%>

                    <input type="text" name="cel" <% if (res[3] == null) {%> placeholder="Celular">
                    <%} else {%> value="<%=res[3]%>">
                    <%}%>

                    <input type="text" name="tel" <% if (res[4] == null) {%> placeholder="Teléfono">
                    <%} else {%> value="<%=res[4]%>">
                    <%}%>

                    <input type="email" name="email" <% if (res[5] == null) {%> placeholder="Correo electronico">
                    <%} else {%> value="<%=res[5]%>">
                    <%}%>

                    <button type="submit" name="save" title="guardar">Guardar Cambios</button>
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
