<%-- 
    Document   : petIn
    Created on : Jun 5, 2022, 2:40:01 AM
    Author     : olgag
--%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.io.*, java.util.*" %>
<%@ page import="javax.servlet.*, java.text.*" %>
<%@ page import="model.Owner" %>

<!--DOCTYPE html-->
<html>
    <head>
        <title>Agregar mascotas</title>
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
                        <li><a href="/Veterinaria/views/petIn.jsp" class="active">Agregar</a></li>
                        <li><a href="/Veterinaria/views/petUp.jsp">Editar</a></li>
                        <li><a href="/Veterinaria/views/petDel.jsp">Eliminar</a></li>
                    </div>

                    <li><a href="/Veterinaria/ApptSe">Citas</a></li>
                    <li><a href="/Veterinaria/ApptSalonR" >Agendar cita salon</a></li>
                    <li><a href="/Veterinaria/ApptConsR">Agendar consulta</a></li>
                    <li><a href="/Veterinaria/ApptHospR">Internar</a></li>

                    <button class="dropdown-btn">Editar citas<i class="fa fa-caret-down"></i></button>
                    <div class="dropdown-container">
                        <li><a href="/Veterinaria/views/apptUpS.jsp">Cita salon</a></li>
                        <li><a href="/Veterinaria/views/apptUpC.jsp">Cita consulta</a></li>
                        <li><a href="/Veterinaria/views/apptUpH.jsp">Ingreso Hospitalario</a></li>
                    </div>

                    <button class="dropdown-btn">Cancelar citas <i class="fa fa-caret-down"></i></button>
                    <div class="dropdown-container">
                        <li><a href="/Veterinaria/views/apptDelS.jsp">Cita salon</a></li>
                        <li><a href="/Veterinaria/views/apptDelC.jsp">Cita consulta</a></li>
                        <li><a href="/Veterinaria/views/apptDelH.jsp">Ingreso Hospitalario</a></li>
                    </div>
                    <br>
                    <br>
                    <button class="drop-login">Cerrar sesión</button>
                </ul>
            </div>
            <div id="form">
                <div class="top">
                    Registrar mascota
                </div>
                <%
                    ArrayList<Owner> owners = (ArrayList<Owner>) session.getAttribute("owner");
                    if (owners != null && owners.size() > 0) {
                %>
                <form method="post" action="/Veterinaria/PetSeIn">
                    <input type="text" name="name" placeholder="Nombre" required>
                    <input type="date" name="bdate">
                    <input type="text" name="specie" placeholder="Especie">
                    <input type="text" name="race" placeholder="Raza">
                    <div class="word">Sexo:</div> 
                    <select name="sex">
                        <option value="F"> Hembra </option>
                        <option value="M"> Macho </option>
                    </select>
                    <input type="text" name="color" placeholder="Color">
                    <br><div class="word">Dueño:</div>
                    <select name="r_ownr" class="sel">
                        <%for (Owner owner : owners) {
                        %>          <option class="opt" value="<%=owner.getIne()%>"> <%=owner.getName()%> </option>
                        <%}%>
                    </select>
                    <input type="textarea" name="other_notes" placeholder="Otros">
                    <button type="submit" name="add" title="ingresar">Agregar</button>
                </form>
                <%} else {%>
                <div style="color: #def0fb; font-size: 125%">Primero se necesita registrar al dueño
                    <%}%>
                </div>
            </div>
            <script src="/Veterinaria/js/menu.js"></script>
    </body>
</html>
