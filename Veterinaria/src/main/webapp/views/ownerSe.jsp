<%-- 
    Document   : ownerSe
    Created on : Jun 4, 2022, 7:57:11 PM
    Author     : olgag
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.io.*, java.util.*" %>
<%@ page import="javax.servlet.*, java.text.*" %>
<%@ page import="model.Owner" %>

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
                    <button class="dropdown-btn">Dueños
                        <i class="fa fa-caret-down"></i>
                    </button>
                    <div class="dropdown-container">
                        <li><a href="/Veterinaria/OwnerSeIn" class="active">Listado</a></li>
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
                    <li><a href="/Veterinaria/MedUpdateSeIn">Historial medico</a></li>
                    <br>
                    <br>
                    <button class="drop-login">Cerrar sesión</button>
                </ul>
            </div>

            <div id="right">
                <div class="top">
                    Listado de dueños
                </div>
                <%
                    ArrayList<Owner> owners = (ArrayList<Owner>) session.getAttribute("owner");
                    if (owners != null && owners.size() > 0) {%>
                <table>
                    <thead>
                        <tr>
                            <th>INE</th>
                            <th>Nombre</th>
                            <th>Fecha de nacimiento</th>
                            <th>Domicilio</th>
                            <th>Celular</th>
                            <th>Telefono</th>
                            <th>Correo electronico</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Owner ownr : owners) {
                                out.print("<tr>"
                                        + "<td>" + ((ownr.getIne() == null) ? "" : ownr.getIne()) + "</td>"
                                        + "<td>" + ((ownr.getName() == null) ? "" : ownr.getName()) + "</td>"
                                        + "<td>" + ((ownr.getBdate() == null) ? "" : ownr.getBdate()) + "</td>"
                                        + "<td>" + ((ownr.getAddr() == null) ? "" : ownr.getAddr()) + "</td>"
                                        + "<td>" + ((ownr.getCel() == null) ? "" : ownr.getCel()) + "</td>"
                                        + "<td>" + ((ownr.getTel() == null) ? "" : ownr.getTel()) + "</td>"
                                        + "<td>" + ((ownr.getEmail() == null) ? "" : ownr.getEmail()) + "</td>"
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
