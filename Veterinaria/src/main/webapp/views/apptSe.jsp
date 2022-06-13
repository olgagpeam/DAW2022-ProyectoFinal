<%-- 
    Document   : apptSe
    Created on : Jun 12, 2022, 10:53:21 PM
    Author     : olgag
--%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.io.*, java.util.*" %>
<%@ page import="javax.servlet.*, java.text.*" %>
<%@ page import="model.ApptConsult" %>
<%@ page import="model.ApptSalon" %>
<%@ page import="model.ApptHospital" %>

<!--DOCTYPE html-->
<html>
    <head>
        <title>Citas</title>
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

                    <li><a href="/Veterinaria/ApptSe" class="active">Citas</a></li>
                    <li><a href="/Veterinaria/ApptSalonR">Agendar cita salon</a></li>
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
                    Listado de citas
                </div>
                <%
                    ArrayList<ApptConsult> apptC = (ArrayList<ApptConsult>) session.getAttribute("apptC");
                    ArrayList<ApptHospital> apptH = (ArrayList<ApptHospital>) session.getAttribute("apptH");
                    ArrayList<ApptSalon> apptS = (ArrayList<ApptSalon>) session.getAttribute("apptS");

                    if ((apptC != null && apptC.size() > 0) || (apptS != null && apptS.size() > 0) || (apptH != null && apptH.size() > 0)) {%>
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Personal</th>
                            <th>Dueño</th>
                            <th>Mascota</th>
                            <th>Fecha cita</th>
                            <th>Hora</th>
                            <th>Tipo cita</th>
                            <th>Domicilio</th>
                            <th>Padecimiento/ Diagnostico</th>
                            <th>Procedimientos</th>
                            <th>Medicamentos</th>
                            <th>Tipo consulta</th>
                            <th>Referencias de domicilio</th>
                            <th>Tipo servicio</th>
                            <th>Hora termino</th>
                            <th>Productos</th>
                            <th>Notas</th>
                        </tr>
                    </thead>
                    <tbody>
                         <%
                            for (ApptConsult aC : apptC) {
                                out.print("<tr>"
                                        + "<td>" + aC.getId() + "</td>"
                                        + "<td>" + aC.getR_user() + "</td>"
                                        + "<td>" + aC.getR_owner() + "</td>"
                                        + "<td>" + aC.getR_pet() + "</td>"
                                        + "<td>" + aC.getDateAppt() + "</td>"
                                        + "<td>" + aC.getInHour() + "</td>"
                                        + "<td>" + aC.getR_sector() + "</td>"
                                        + "<td>" + ((aC.getAddr() == null) ? "" : aC.getAddr()) + "</td>"
                                        + "<td>" + ((aC.getDiagnosis() == null) ? "" : aC.getDiagnosis()) + "</td>"
                                        + "<td>" + ((aC.getProcedures() == null) ? "" : aC.getProcedures()) + "</td>"
                                        + "<td>" + ((aC.getMed() == null) ? "" : aC.getMed()) + "</td>"
                                        + "<td>" + aC.getR_consult() + "</td>"
                                        + "<td>" + aC.getAddrRef() + "</td>"
                                        + "<td>" + "</td>"
                                        + "<td>" + "</td>"
                                        + "<td>" + "</td>"
                                        + "<td>" + aC.getNote() + "</td>"
                                        + "</tr>");
                            }
                        %>
                        <%
                            for (ApptHospital aH : apptH) {
                                out.print("<tr>"
                                        + "<td>" + aH.getId() + "</td>"
                                        + "<td>" + aH.getR_user() + "</td>"
                                        + "<td>" + aH.getR_owner() + "</td>"
                                        + "<td>" + aH.getR_pet() + "</td>"
                                        + "<td>" + aH.getDateAppt() + "</td>"
                                        + "<td>" + aH.getInHour() + "</td>"
                                        + "<td>" + aH.getR_sector() + "</td>"
                                        + "<td>" + ((aH.getAddr() == null) ? "" : aH.getAddr()) + "</td>"
                                        + "<td>" + ((aH.getIllness() == null) ? "" : aH.getIllness()) + "</td>"
                                        + "<td>" + ((aH.getProcedures() == null) ? "" : aH.getProcedures()) + "</td>"
                                        + "<td>" + ((aH.getMed() == null) ? "" : aH.getMed()) + "</td>"
                                        + "<td>" + "</td>"
                                        + "<td>" + "</td>"
                                        + "<td>" + "</td>"
                                        + "<td>" + "</td>"
                                        + "<td>" + "</td>"
                                        + "<td>" + aH.getNote() + "</td>"
                                        + "</tr>");
                            }
                        %>
                        <%
                            for (ApptSalon aS : apptS) {
                                out.print("<tr>"
                                        + "<td>" + aS.getId() + "</td>"
                                        + "<td>" + aS.getR_user() + "</td>"
                                        + "<td>" + aS.getR_owner() + "</td>"
                                        + "<td>" + aS.getR_pet() + "</td>"
                                        + "<td>" + aS.getDateAppt() + "</td>"
                                        + "<td>" + aS.getInHour() + "</td>"
                                        + "<td>" + aS.getR_sector() + "</td>"
                                        + "<td>" + ((aS.getAddr() == null) ? "" : aS.getAddr()) + "</td>"
                                        + "<td>" + "</td>"
                                        + "<td>" + "</td>"
                                        + "<td>" + "</td>"
                                        + "<td>" + "</td>"
                                        + "<td>" + "</td>"
                                        + "<td>" + aS.getR_service() + "</td>"
                                        + "<td>" + aS.getOutHour() + "</td>"
                                        + "<td>" + aS.getProducts() + "</td>"
                                        + "<td>" + aS.getNote() + "</td>"
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

