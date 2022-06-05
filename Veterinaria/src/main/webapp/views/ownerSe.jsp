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
                    <li><a href="/Veterinaria/ApptSeIn">Citas</a></li>
                    <li><a href="/Veterinaria/views/apptInS.jsp">Agendar cita salon</a></li>
                    <li><a href="/Veterinaria/views/apptInC.jsp">Agendar consulta</a></li>
                    <li><a href="/Veterinaria/views/apptInH.jsp">Internar</a></li>
                </ul>
            </div>

            <div id="right">
                <div class="top">
                    Listado de dueños
                </div>
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
                            List<Owner> owners = (List<Owner>) session.getAttribute("owner");
                            if (owners != null) {
                                for (Owner ownr : owners) {
                                    out.print("<tr>"
                                            + "<td>" + ownr.getIne() + "</td>"
                                            + "<td>" + ownr.getName() + "</td>"
                                            + "<td>" + ownr.getBdate() + "</td>"
                                            + "<td>" + ownr.getAddr() + "</td>"
                                            + "<td>" + ownr.getCel() + "</td>"
                                            + "<td>" + ownr.getTel() + "</td>"
                                            + "<td>" + ownr.getEmail() + "</td>"
                                            + "</tr>");
                                }
                            }
                        %>
                    </tbody>
                </table>
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
