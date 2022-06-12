<%-- 
    Document   : petUp
    Created on : Jun 7, 2022, 9:58:56 PM
    Author     : olgag
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.io.*, java.util.*" %>
<%@ page import="javax.servlet.*, java.text.*" %>
<%@ page import="model.Owner" %>
<!--DOCTYPE html-->
<html>
    <head>
        <title>Editar mascota</title>
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
                        <li><a href="/Veterinaria/views/ownerUp.jsp">Editar</a></li>
                        <li><a href="/Veterinaria/views/ownerDel.jsp">Eliminar</a></li>
                    </div>
                    <button class="dropdown-btn">Mascotas
                        <i class="fa fa-caret-down"></i>
                    </button>
                    <div class="dropdown-container">
                        <li><a href="/Veterinaria/PetSeIn">Listado</a></li>
                        <li><a href="/Veterinaria/views/petIn.jsp">Agregar</a></li>
                        <li><a href="/Veterinaria/views/petUp.jsp"  class="active">Editar</a></li>
                        <li><a href="/Veterinaria/views/petDel.jsp">Eliminar</a></li>
                    </div>
               
                    <li><a href="/Veterinaria/ApptSeIn">Citas</a></li>
                    <li><a href="/Veterinaria/views/apptInS.jsp">Agendar cita salon</a></li>
                    <li><a href="/Veterinaria/views/apptInC.jsp">Agendar consulta</a></li>
                    <li><a href="/Veterinaria/views/apptInH.jsp">Internar</a></li>

                    <button class="dropdown-btn">Editar citas<i class="fa fa-caret-down"></i></button>
                    <div class="dropdown-container">
                        <li><a href="/Veterinaria/apptUpS.jsp">Cita salon</a></li>
                        <li><a href="/Veterinaria/views/apptUpC.jsp">Cita consulta</a></li>
                        <li><a href="/Veterinaria/views/apptUpH.jsp">Ingreso Hospitalario</a></li>
                    </div>

                    <button class="dropdown-btn">Cancelar citas <i class="fa fa-caret-down"></i></button>
                    <div class="dropdown-container">
                        <li><a href="/Veterinaria/apptDelS.jsp">Cita salon</a></li>
                        <li><a href="/Veterinaria/views/apptDelC.jsp">Cita consulta</a></li>
                        <li><a href="/Veterinaria/views/apptDelH.jsp">Ingreso Hospitalario</a></li>
                    </div>
                </ul>
            </div>
            <div id="form">
                <div class="top">
                    Editar información mascota
                </div>
                <form method="get" action="/Veterinaria/PetUp">
                    <input type="text" name="id" placeholder="PetID" required>
                    <button type="submit" name="search" title="buscar">Editar</button>
                </form>
            </div>
        </div>
        <script src="/Veterinaria/js/menu.js"></script>
    </body>
</html>


