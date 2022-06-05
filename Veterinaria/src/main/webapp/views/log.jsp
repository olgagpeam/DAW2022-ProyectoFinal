<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.io.*, java.util.*" %>
<%@ page import="javax.servlet.*, java.text.*" %>
<%@ page import="model.User" %>

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
                        Bienvenido
                    </div>
                    <form id="loginForm" method="get" action="/Veterinaria/controler/userServlets/UserLogin">
                        <input type="text" name="user" placeholder="Usuario" required>
                        <input type="password" name="password" placeholder="Contraseña" required>
                        <button type="submit" name="login" title="ingresar">Ingresar</button>
                    </form>
                    <div class="bottom">
                        <a href="#">¿Olvidaste tu contraseña?</a>
                    </div>
                </div>
                <div class="back">
                    <a href="index.html">Volver</a>
                </div>
            </div>
        </div>
    </body>
</html>
