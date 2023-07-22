<%-- 
    Document   : Login
    Created on : 18 jul. 2023, 00:14:29
    Author     : Taily
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../Css/normalize.css" rel="stylesheet" type="text/css"/>
        <link href="recursos/css/EstiloLogin.css" rel="stylesheet" type="text/css"/>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;700&display=swap" rel="stylesheet">
        <script src="JS/validarLogin.js" type="text/javascript"></script>
        <title>JSP Page</title>
    </head>
    <body>
       
        <div class="Contenedor-formulario contenedor">
             <div class="imagen">
                 <img  src="recursos/imagenes/miskida2.png" width=700px; height=680px; alt=""/>
                 
            </div>
          
            <form class="formulario" action="PVC" method="Post" onsubmit="return validar()">

                <div class="texto-formulario">
                    <h2>Bienvenido trabajador</h2>
                    <p>Inicia sesión con tu cuenta</p>
                </div>
                <div class="input">
                    <label for="usuario">Usuario</label>
                    <input placeholder="Ingresa tu usuario" type="text" name="usuario" id="usuario">
                </div>
                <div class="input">
                    <label for="contraseña">Contraseña</label>
                    <input placeholder="Ingresa tu contraseña" type="password" name="contra" id="contraseña">
                </div>
                <div class="input">
                    <input type="submit" name="admi" value="Ingresar como administrador">

                </div>
                <div class="input">

                    <input type="submit" name="pastelero" value="Ingresar como pastelero">
                </div>
            </form>
        </div>   
    </body>
</html>
