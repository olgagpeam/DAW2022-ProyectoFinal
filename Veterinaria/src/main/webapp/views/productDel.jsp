<%-- 
    Document   : productDel
    Created on : Jun 10, 2022, 5:07:07 PM
    Author     : olgag
--%>
<!--DOCTYPE html-->
<html>
    <head>
        <title>Eliminar Mascotas</title>
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
                    <button class="dropdown-btn">Inventario<i class="fa fa-caret-down"></i></button>
                    <div class="dropdown-container">
                        <li><a href="/Veterinaria/ProductSeIn">Listado</a></li>
                        <li><a href="/Veterinaria/ProductR_Category">Registrar producto</a></li>
                        <br>
                        <li><a href="/Veterinaria/views/productADD.jsp">A�adir unidades</a></li>
                        <li><a href="/Veterinaria/views/productDE.jsp">Descontar unidades</a></li>
                        <br>
                        <li><a href="/Veterinaria/views/productUp.jsp">Editar informaci�n</a></li>
                        <br>
                        <li><a href="/Veterinaria/views/productDel.jsp" class="active">Eliminar producto</a></li>
                    </div>
                    <li>
                    </li>
                    <button class="dropdown-btn">Categorias<i class="fa fa-caret-down"></i></button>
                    <div class="dropdown-container">
                        <li><a href="/Veterinaria/CategorySeIn">Listado</a></li>
                        <li><a href="/Veterinaria/views/categoryIn.jsp">Registrar categoria</a></li>
                        <li><a href="/Veterinaria/views/categoryUp.jsp">Editar categoria</a></li>
                        <li><a href="/Veterinaria/views/categoryDel.jsp">Eliminar categoria</a></li>
                    </div>
                    <li><a href="/Veterinaria/ProdUpdateSeIn">Historial de movimientos</a></li>
                    <br>
                    <br>
                    <li><a href="/Veterinaria/views/log.jsp">Cerrar sesi�n</a></li>
                </ul>
            </div>
            <div id="form">
                <div class="top">
                    Eliminar producto
                </div>
                <form method="post" action="/Veterinaria/ProductDel">
                    <input type="text" name="id" placeholder="Codigo de barras" required>
                    <button type="submit" name="search" value="eliminar">Eliminar</button>
                </form>
            </div>
        </div>
        <script src="/Veterinaria/js/menu.js"></script>
    </body>
</html>
