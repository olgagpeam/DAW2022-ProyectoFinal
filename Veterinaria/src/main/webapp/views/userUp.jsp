<%-- 
    Document   : userUp
    Created on : Jun 13, 2022, 5:35:05 PM
    Author     : olgag
--%>
<!--DOCTYPE html-->
<html lang="es">
    <head>
        <title>Editar usuario</title>
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
                    <button class="dropdown-btn">Usuarios
                        <i class="fa fa-caret-down"></i>
                    </button>
                    <div class="dropdown-container">
                        <li><a href="/Veterinaria/UserSeIn">Listado</a></li>
                        <li><a href="/Veterinaria/views/userIn.jsp">Agregar</a></li>
                        <li><a href="/Veterinaria/views/userUp.jsp"class="active">Editar</a></li>
                        <li><a href="/Veterinaria/views/userDel.jsp">Eliminar</a></li>
                    </div>
                    
                    <button class="dropdown-btn">Eliminar resgistro de historial
                        <i class="fa fa-caret-down"></i>
                    </button>
                    <div class="dropdown-container">
                        <li><a href="/Veterinaria/views/medUpDel.jsp">Medico</a></li>
                        <li><a href="/Veterinaria/views/prodUpDel.jsp">Inventario</a></li>
                    </div>
                    <br>
                    <br>
                    <li><a href="/Veterinaria/views/log.jsp">Cerrar sesión</a></li>
                </ul>
            </div>
            <div id="form">
                <div class="top">
                    Editar usuario
                </div>
                <form method="get" action="/Veterinaria/UserUp">
                    <input type="text" name="id" placeholder="ID" required>
                    <button type="submit" name="add" title="ingresar">Editar</button>
                </form>
            </div>
        </div>
        <script src="/Veterinaria/js/menu.js"></script>
    </body>
</html>
