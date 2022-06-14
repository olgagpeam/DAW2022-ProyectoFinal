<%-- 
    Document   : userSe
    Created on : Jun 13, 2022, 5:35:27 PM
    Author     : olgag
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.io.*, java.util.*" %>
<%@ page import="javax.servlet.*, java.text.*" %>
<%@ page import="model.User" %>

<!--DOCTYPE html-->
<html>
    <head>
        <title>Dueños</title>
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
                        <li><a href="/Veterinaria/UserSeIn" class="active">Listado</a></li>
                        <li><a href="/Veterinaria/views/userIn.jsp">Agregar</a></li>
                        <li><a href="/Veterinaria/views/userUp.jsp">Editar</a></li>
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

            <div id="right">
                <div class="top">
                    Listado de dueños
                </div>
                <%
                    ArrayList<User> users = (ArrayList<User>) session.getAttribute("user");
                    if (users != null && users.size() > 0) {%>
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Apellidos</th>
                            <th></th>
                            <th>Fecha de nacimiento</th>
                            <th>Domicilio</th>
                            <th>Celular</th>
                            <th>Telefono</th>
                            <th>Correo electronico</th>
                            <th>Tipo de cuenta</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (User usr : users) {
                                out.print("<tr>"
                                        + "<td>" + ((usr.getId() == null || "".equals(usr.getId())) ? "" : usr.getId()) + "</td>"
                                        + "<td>" + usr.getName() + "</td>"
                                        + "<td>" + usr.getLname1() + "</td>"
                                        + "<td>"+ usr.getLname2() + "</td>"
                                        + "<td>" + ((usr.getBdate() == null || "".equals(usr.getBdate())) ? "" : usr.getBdate()) + "</td>"
                                        + "<td>" + ((usr.getAddr() == null || "".equals(usr.getAddr())) ? "" : usr.getAddr()) + "</td>"
                                        + "<td>" + ((usr.getCel() == null || "".equals(usr.getCel())) ? "" : usr.getCel()) + "</td>"
                                        + "<td>" + ((usr.getTel() == null || "".equals(usr.getTel())) ? "" : usr.getTel()) + "</td>"
                                        + "<td>" + ((usr.getEmail() == null || "".equals(usr.getEmail())) ? "" : usr.getEmail()) + "</td>"
                                        + "<td>" + ((usr.getR_acct() == null || "".equals(usr.getR_acct())) ? "" : usr.getR_acct()) + "</td>"
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
