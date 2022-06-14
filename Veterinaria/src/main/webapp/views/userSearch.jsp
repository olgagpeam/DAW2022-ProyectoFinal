<%-- 
    Document   : userSearch
    Created on : Jun 13, 2022, 6:02:23 PM
    Author     : olgag
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.io.*, java.util.*" %>
<%@ page import="javax.servlet.*, java.text.*" %>

<!--DOCTYPE html-->
<html lang="es">
    <head>
        <title>Agregar usuarios</title>
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
                    <button class="dropdown-btn">Usuarios
                        <i class="fa fa-caret-down"></i>
                    </button>
                    <div class="dropdown-container">
                        <li><a href="/Veterinaria/UserSeIn">Listado</a></li>
                        <li><a href="/Veterinaria/views/userIn.jsp">Agregar</a></li>
                        <li><a href="/Veterinaria/views/userUp.jsp"  class="active">Editar</a></li>
                        <li><a href="/Veterinaria/views/userDel.jsp">Eliminar</a></li>
                    </div>
                    
                    <button class="dropdown-btn">Eliminar resgistro de historial
                        <i class="fa fa-caret-down"></i>
                    </button>
                    <div class="dropdown-container">
                        <li><a href="/Veterinaria/views/medUpDel.jsp">Medico</a></li>
                        <li><a href="/Veterinaria/views/prodUpDel.jsp">Inventario</a></li>
                    </div>
                    <br>
                    <br>
                    <li><a href="/Veterinaria/views/log.jsp">Cerrar sesión</a></li>
                </ul>
            </div>
            <div id="form">
                <div class="top">
                    Registrar usuario
                </div>
                <%
                    String[] res = (String[]) session.getAttribute("result");
                %>
                <form method="post" action="/Veterinaria/UserUp">
                    <input type="text" name="id" placeholder="ID" value="<%=res[9]%>" required>
                    <input type="password" name="pwd" placeholder="Contraseña" value="<%=res[10]%>" required>
                    <input type="text" name="name" placeholder="Nombre" value="<%=res[0]%>" required>
                    <input type="text" name="lname1" placeholder="Apellido 1" value="<%=res[1]%>" required>
                    <input type="text" name="lname2" placeholder="Apellido 2" value="<%=res[2]%>" required>
                    <input type="date" name="bdate"  <% if (res[3] == null) {%> >
                    <%} else {%> value="<%=res[3]%>">
                    <%}%>
                    <input type="text" name="addr" <% if (res[4] == null || "".equals(res[4])) {%> placeholder="Domicilio">
                    <%} else {%> value="<%=res[4]%>">
                    <%}%>
                    <input type="text" name="cel" <% if (res[5] == null || "".equals(res[5])) {%> placeholder="Celular">
                    <%} else {%> value="<%=res[5]%>">
                    <%}%>
                    <input type="text" name="tel" <% if (res[6] == null || "".equals(res[6])) {%> placeholder="Teléfono">
                    <%} else {%> value="<%=res[6]%>">
                    <%}%>
                    <input type="email" name="email" <% if (res[7] == null || "".equals(res[7])) {%> placeholder="Correo Electronico">
                    <%} else {%> value="<%=res[7]%>">
                    <%}%>
                    <select name="r_acct">
                        <option value="VET" <%if (res[8].equals("VET")) {%> selected <%}%> > Veterinario </option>
                        <option value="ADM" <%if (res[8].equals("ADM")) {%> selected <%}%> > Administrador </option>
                        <option value="INV" <%if (res[8].equals("INV")) {%> selected <%}%> > Inventario </option>
                    </select>
                    <button type="submit" name="add" title="ingresar">Agregar</button>
                </form>
            </div>
        </div>
        <script src="/Veterinaria/js/menu.js"></script>
    </body>
</html>
