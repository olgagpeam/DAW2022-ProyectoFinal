<%-- 
    Document   : owner.jsp
    Created on : Jun 4, 2022, 6:49:02 PM
    Author     : olgag
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.io.*, java.util.*" %>
<%@ page import="javax.servlet.*, java.text.*" %>
<%@ page import="model.Owner" %>

<!--DOCTYPE html-->
<html>
    <head>
        <title>Inicio sesión</title>
        <meta charset="UTF-8">        
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link href="https://fonts.googleapis.com/css?family=Nunito&display=swap" rel="stylesheet"> 
        <link href="https://fonts.googleapis.com/css?family=Overpass&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="/Veterinaria/style/login.css">
        
        <style type="text/css"></style>
    </head>
    <body>
        <div id="container">
            <div id="central">
                <div id="login">
                    <div class="top">
                        Dueños mascotas
                    </div>
                    <form method="post" action="/Veterinaria/OwnerSeIn">
                        <input type="text" name="ine" placeholder="INE" required>
                        <input type="text" name="name" placeholder="Nombre" required>
                        <input type="date" name="bdate" placeholder="Fecha de nacimiento">
                        <input type="text" name="addr" placeholder="Domicilio">
                        <input type="text" name="cel" placeholder="Celular" required>
                        <input type="text" name="tel" placeholder="Teléfono fijo">
                        <input type="email" name="email" placeholder="Correo Electronico">
                        <button type="submit" name="login" title="ingresar">Agregar</button>
                    </form>
                </div>
                <div class="back">
                    <a href="/Veterinaria/VET.html">Volver</a>
                </div>
            </div>
        </div>
    </body>
</html>
