<%-- 
    Document   : petSearch
    Created on : Jun 7, 2022, 9:58:31 PM
    Author     : olgag
--%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.io.*, java.util.*" %>
<%@ page import="javax.servlet.*, java.text.*" %>
<%@ page import="model.Owner" %>
<!--DOCTYPE html-->
<html>
    <head>
        <title>Editar Mascota</title>
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
                        <li><a href="/Veterinaria/views/petUp.jsp" class="active">Editar</a></li>
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
                <%
                    String[] res = (String[]) session.getAttribute("result");
                    ArrayList<Owner> ownrs = (ArrayList<Owner>) session.getAttribute("owner");
                %>
                <form method="post" action="/Veterinaria/PetUp">
                    <input type="text" name="id" required value="<%=res[8]%>">
                    <input type="text" name="name" <% if (res[0] == null) {%> placeholder="Nombre">
                    <%} else {%> value="<%=res[0]%>">
                    <%}%>
                    
                    <input type="date" name="bdate" <% if (res[1] == null) {%>>
                    <%} else {%> value="<%=res[1]%>">
                    <%}%>

                    <input type="text" name="specie" <% if (res[2] == null) {%> placeholder="Especie">
                    <%} else {%> value="<%=res[2]%>">
                    <%}%>

                    <input type="text" name="race" <% if (res[3] == null) {%> placeholder="Raza">
                    <%} else {%> value="<%=res[3]%>">
                    <%}%>

                    <div class="word">Sexo:</div> 
                    <select name="sex">
                        <option value="F" <%if (res[4].equals("F")) {%> selected <%}%> > Hembra </option>
                        <option value="M" <%if (res[4].equals("M")) {%> selected <%}%> > Macho </option>
                    </select>

                    <input type="text" name="color" <% if (res[5] == null) {%> placeholder="Color">
                    <%} else {%> value="<%=res[5]%>">
                    <%}%>
                    
                    <div class="word">Dueño:</div>
                    <select name="r_ownr">
                        <%for (Owner owner : ownrs) {
                        %>          
                        <option value="<%=owner.getIne()%>" <%if (owner.getIne().equals(res[6])) {%> selected <%}%> > <%=owner.getName()%> </option>
                        <%}%>
                    </select>
                    
                    <input type="text" name="other_notes" <% if (res[7] == null) {%> placeholder="Notas">
                    <%} else {%> value="<%=res[7]%>">
                    <%}%>

                    <button type="submit" name="save" title="guardar">Guardar Cambios</button>
                </form>
            </div>
        </div>
        <script src="/Veterinaria/js/menu.js"></script>
    </body>
</html>
