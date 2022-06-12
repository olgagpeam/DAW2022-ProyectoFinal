<%-- 
    Document   : categoryDel
    Created on : Jun 10, 2022, 11:24:42 PM
    Author     : olgag
--%>
<!--DOCTYPE html-->
<html lang="es">
    <head>
        <title>Eliminar Categoria</title>
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
                        <li><a href="/Veterinaria/views/productADD.jsp">Añadir unidades</a></li>
                        <li><a href="/Veterinaria/views/productDE.jsp">Descontar unidades</a></li>
                        <br>
                        <li><a href="/Veterinaria/views/productUp.jsp">Editar información</a></li>
                        <br>
                        <li><a href="/Veterinaria/views/productDel.jsp">Eliminar producto</a></li>
                    </div>
                    <li>
                    </li>
                    <button class="dropdown-btn">Categorias<i class="fa fa-caret-down"></i></button>
                    <div class="dropdown-container">
                        <li><a href="/Veterinaria/CategorySeIn">Listado</a></li>
                        <li><a href="/Veterinaria/views/categoryIn.jsp">Registrar categoria</a></li>
                        <li><a href="/Veterinaria/views/categoryUp.jsp">Editar categoria</a></li>
                        <li><a href="/Veterinaria/views/categoryDel.jsp" class="active">Eliminar categoria</a></li>
                    </div>
                    <li><a href="/Veterinaria/ProdUpdateSeIn">Historial de movimientos</a></li>
                </ul>
            </div>
            <div id="form">
                <div class="top">
                    Eliminar categoria
                </div>
                <form method="post" action="/Veterinaria/CategoryDel">
                    <input type="text" name="id" placeholder="ID Categoria" required>
                    <button type="submit" name="search" value="eliminar">Eliminar</button>
                </form>
            </div>
        </div>
        <script src="/Veterinaria/js/menu.js"></script>
    </body>
</html>
