<%-- 
    Document   : AgregarPastelero
    Created on : 20 jul. 2023, 00:09:03
    Author     : JOEL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta https-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Agregar Pastelero</title>
        <link rel="stylesheet" href="style.css">
        <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;700&display=swap" rel="stylesheet">
        <link href="recursos/Css/Estilos.css" rel="stylesheet" type="text/css"/>
        <script src="JS/validar.js" type="text/javascript"></script>
    </head>
    <body>
        <jsp:include page="Header.jsp" />
        <div class="content">
            <!-- Add content here if needed -->
        </div>
        <div class="contenedor Contenedor-formularioP">
            <div class="texto-formularioP">
                <h2>Agregar Pastelero</h2>
            </div>
            <form class="formularioP" action="PC" method="post" onsubmit="return validar()">
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
                    <input type="tel" name="telef" id="telef" required>
                </div>
                <div class="input">
                    <label for="pass">Contraseña</label>
                    <input type="password" name="pass" id="pass" required>
                </div>
                <div class="inputb">
                    <input class="inputb1" name="menu" type="submit" value="Agregar">
                    <input class="inputb2" type="submit" value="Cancelar">
                </div>
            </form>
        </div>
    </body>
</html>