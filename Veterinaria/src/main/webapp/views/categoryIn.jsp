<%-- 
    Document   : categoryIn
    Created on : Jun 10, 2022, 11:24:59 PM
    Author     : olgag
--%>
<html lang="es">
    <head>
        <title>Registar categoría</title>
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
                        <li><a href="/Veterinaria/views/productUp.jsp">Añadir unidades</a></li>
                        <li><a href="/Veterinaria/views/productUp.jsp">Descontar unidades</a></li>
                        <br>
                        <li><a href="/Veterinaria/views/productUp.jsp">Editar información</a></li>
                        <br>
                        <li><a href="/Veterinaria/views/productDel.jsp">Eliminar producto</a></li>
                    </div>
                    <li>
                    </li>
                    <button class="dropdown-btn">Categorias<i class="fa fa-caret-down"></i></button>
                    <div class="dropdown-container">
                        <li><a href="/Veterinaria/ProductSeIn">Listado</a></li>
                        <li><a href="/Veterinaria/ProductR_Category"  class="active">Registrar categoria</a></li>
                        <li><a href="/Veterinaria/views/productUp.jsp">Editar categoria</a></li>
                        <li><a href="/Veterinaria/views/productDel.jsp">Eliminar categoria</a></li>
                    </div>
                    <li><a href="/Veterinaria/productUpdateSe">Historial de movimientos</a></li>
                </ul>
            </div>
            <div id="form">
                <div class="top">
                    Registrar categoría
                </div>
                <form id="formIN" method="post" action="/Veterinaria/CategorySeIn">
                    <input type="text" id="name" name="cat" placeholder="Nombre categoria" required>
                    <button type="submit" id="button"  name="add" title="agregar">Agregar</button>
                </form>
            </div>
        </div>
        <script src="/Veterinaria/js/menu.js"></script>
    </body>
</html>

