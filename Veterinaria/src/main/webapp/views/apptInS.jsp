<%-- 
    Document   : apptInS
    Created on : Jun 12, 2022, 1:53:57 PM
    Author     : olgag
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.io.*, java.util.*" %>
<%@ page import="javax.servlet.*, java.text.*" %>
<%@ page import="model.User" %>
<%@ page import="model.Owner"%>
<%@ page import="model.Pet"%>
<%@page import="model.Service"%>
<!--DOCTYPE html-->
<html lang="es">
    <head>
        <title>Cita Salon</title>
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
                        <li><a href="/Veterinaria/views/petUp.jsp">Editar</a></li>
                        <li><a href="/Veterinaria/views/petDel.jsp">Eliminar</a></li>
                    </div>

                    <li><a href="/Veterinaria/ApptSe">Citas</a></li>
                    <li><a href="/Veterinaria/ApptSalonR" class="active">Agendar cita salon</a></li>
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
                    <li><a href="/Veterinaria/MedUpdateSeIn">Historial medico</a></li>
                    <br>
                    <br>
                    <button class="drop-login">Cerrar sesión</button>
                </ul>
            </div>
            <div id="form">
                <div class="top">
                    Agendar Cita Salon
                </div>
                <%
                    ArrayList<Owner> owner = (ArrayList<Owner>) session.getAttribute("owner");
                    ArrayList<Pet> pet = (ArrayList<Pet>) session.getAttribute("pet");
                    ArrayList<User> user = (ArrayList<User>) session.getAttribute("user");
                    ArrayList<Service> ser = (ArrayList<Service>) session.getAttribute("ser");

                    if ((user != null && user.size() > 0) && (owner != null && owner.size() > 0)
                            && (pet != null && pet.size() > 0) && (ser != null && ser.size() > 0)) {
                %>
                <form method="post" action="/Veterinaria/ApptSalonSeIn">
                    <div class="word">Personal: </div> 
                    <select name="r_user" class="sel">
                        <%for (User usr : user) {
                        %>          
                        <option class="opt" value="<%=usr.getId()%>"> <%=usr.getName()%> </option>
                        <%}%>
                    </select>
                    <br><div class="word">Mascota/Dueño: </div> 
                    <select name="r_pet" class="sel">
                        <%for (Pet pt : pet) {
                                String duenio = "";
                                String petO = pt.getId() + "." + pt.getR_owner();
                        %>          
                        <option class="opt" value="<%=petO%>">M: <%=pt.getName()%>
                            <%for (Owner ownr : owner) {
                                    if (pt.getR_owner().equals(ownr.getIne())) {
                                        duenio = ownr.getName();
                                    }
                                }
                            %>
                            / D: <%=duenio%></option>
                            <%}%>
                    </select>
                    <input type="text" name="addr" placeholder="Domicilio">
                    <input type="date" name="dateAppt" required>
                    <input type="number" name="hh" min="0" max="23" step="1"placeholder="Hora" required>
                    <input type="number" name="mm"  min="0" max="59" step="1" placeholder="Minutos" required>

                    <div class="word">Servicio: </div> 
                    <select name="r_service">
                        <%for (Service sr : ser) {
                        %>          
                        <option class="opt" value="<%=sr.getId()%>"> <%=sr.getService()%> </option>
                        <%}%>
                    </select>

                    <input type="textarea" name="note"  placeholder="Notas">
                    <button type="submit" name="search" title="agenar">Agendar</button>

                </form>
                <%} else if (owner == null || owner.size() < 0) {%>
                <div style="color: #def0fb; font-size: 125%">Primero se necesita registrar dueños</div>
                <%} else if (pet == null || pet.size() < 0) {%>
                <div style="color: #def0fb; font-size: 125%">Primero se necesita registrar mascotas</div>
                <%} else {%>
                <div style="color: #def0fb; font-size: 125%">Primero se necesita registrar usuarios</div>
                <%}%>
            </div>
        </div>
        <script src="/Veterinaria/js/menu.js"></script>
    </body>
</html>

