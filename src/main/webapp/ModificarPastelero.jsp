<%-- 
    Document   : ModificarPastelero
    Created on : 20 jul. 2023, 00:11:08
    Author     : JOEL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta https-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Modificar Pastelero</title>
        <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;700&display=swap" rel="stylesheet">
        <link href="recursos/Css/Estilos.css" rel="stylesheet" type="text/css"/>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link href="recursos/Css/EstiloTabla.css" rel="stylesheet" type="text/css"/>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;700&display=swap" rel="stylesheet">

    </head>
    <body>
        <nav>
            <div class="logo">
                MISKIDA
            </div>
            <ul>
                <li><a href="home">Home</a></li>
                <li><a href="nueva-receta">+ Nueva Receta</a></li>
                <li><a href="receta">Receta</a></li>
                <li><a href="pastelero">Pastelero</a></li>
                <li><a href="calcular lista">Calculador lista</a></li>
                <li><a href="reporte">Reporte</a></li>

            </ul>
        </nav>
        <div class="content">
            <!-- Add content here if needed -->
        </div>
        <div class="contenedor Contenedor-formularioP">
            <div class="texto-formularioP">
                <h2>Modificar Pastelero</h2>
            </div>
            <form class="formularioP" method="post" onsubmit="return validar()">
                <input type="hidden" id="id" class="form-control">
                <div class="input">
                    <label for="nombre">Nombre</label>
                    <input type="text" name="nombre" id="nombre" required>
                </div>
                <div class="input">
                    <label for="dnip">Dni</label>
                    <input type="text" name="dnip" id="dnip" required>
                </div>

                <div class="input">
                    <label for="telef">Teléfono</label>
                    <input type="text" name="telef" id="telef" required>
                </div>
                <div class="input">
                    <label for="pass">Contraseña</label>
                    <input type="password" name="pass" id="pass" required>
                </div>
                <div class="inputb">
                    <input class="inputb1" id="modificar" name="modificar" type="submit" value="Modificar">
                    <input class="inputb2" type="submit" value="Cancelar">
                </div>
            </form>
        </div>

    </body>
</html>
