<%-- 
    Document   : petSe
    Created on : Jun 5, 2022, 2:40:12 AM
    Author     : olgag
--%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.io.*, java.util.*" %>
<%@ page import="javax.servlet.*, java.text.*" %>
<%@ page import="model.Pet" %>
<%@ page import="model.Owner" %>

<!--DOCTYPE html-->
<html>
    <head>
        <title>Mascotas</title>
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
                        <li><a href="/Veterinaria/PetSeIn" class="active">Listado</a></li>
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
                    <li><a href="/Veterinaria/views/log.jsp">Cerrar sesión</a></li>
                </ul>
            </div>
            
            <div id="right">
                <div class="top">
                    Listado de mascotas
                </div>
                <%
                    ArrayList<Pet> pets = (ArrayList<Pet>) session.getAttribute("pet");
                    ArrayList<Owner> ownrs = (ArrayList<Owner>) session.getAttribute("owner");
                    if (pets != null && pets.size() > 0) {%>
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Fecha de nacimiento</th>
                            <th>Especie</th>
                            <th>Raza</th>
                            <th>Sexo</th>
                            <th>Color</th>
                            <th>Dueño</th>
                            <th>Notas</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Pet pet : pets) {
                                String duenio = null;
                                for (Owner owner : ownrs) {
                                    if (owner.getIne().equals(pet.getR_owner())) {
                                        duenio = owner.getName();
                                    }
                                }
                                out.print("<tr>"
                                        + "<td>" + ((String.valueOf(pet.getId()) == null) ? "" : pet.getId()) + "</td>"
                                        + "<td>" + ((pet.getName() == null) ? "" : pet.getName()) + "</td>"
                                        + "<td>" + ((pet.getBdate() == null) ? "" : pet.getBdate()) + "</td>"
                                        + "<td>" + ((pet.getSpecie() == null) ? "" : pet.getSpecie()) + "</td>"
                                        + "<td>" + ((pet.getRace() == null) ? "" : pet.getRace()) + "</td>"
                                        + "<td>" + ((String.valueOf(pet.getR_sex()) == null) ? "" : ((pet.getR_sex() == 'F') ? "Hembra" : "Macho")) + "</td>"
                                        + "<td>" + ((pet.getColor() == null) ? "" : pet.getColor()) + "</td>"
                                        + "<td>" + ((duenio == null) ? "" : duenio) + "</td>"
                                        + "<td>" + ((pet.getOther() == null) ? "" : pet.getOther()) + "</td>"
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
