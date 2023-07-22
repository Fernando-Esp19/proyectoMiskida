<%-- 
    Document   : Header
    Created on : 13 jul. 2023, 20:15:17
    Author     : Taily
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <title>JSP Page</title>
        <style>
            .custom-header {
                background-color: #ffc0cb; /* Color rosa claro */
                font-family: var(--fuente);
                text-align: left; /* Alineación del texto a la izquierda */
            }
            .nav-link {
                color: blue; /* Color del texto de los enlaces */

                font-size: 18px; /* Tamaño de fuente */
            }
            .custom-header {
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* Sombra al header */
                border-bottom: 1px solid #ccc; /* Borde en la parte inferior */
            }

            .navbar-collapse {
                transition: max-height 0.3s ease-in-out; /* Transición suave */

                overflow: hidden;
            }

            .navbar-collapse.show {
                max-height: 500px; /* Altura máxima del menú al abrirse */
            }
            .nav-link {
                color: #333; /* Color del texto de los enlaces */
                text-align: left; /* Alineación del texto a la izquierda */
                transition: color 60s; /* Transición suave para el cambio de color */
            }
            .nav-link:hover {
                color: #FF8099; /* Color del texto al pasar el cursor por encima */
            }

        </style>
    </head>
    <body>
        <header class="navbar navbar-expand-lg navbar-light custom-header" >
            <div class="container">
                <a class="navbar-brand" href="#">
                    <img src="recursos/imagenes/logomiskida.jpg" alt="Logo de la empresa" width="40" height="40" class="d-inline-block align-top">
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="index.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="AgregarReceta.jsp">+ Nueva Receta</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Recetas</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="TablaPastelero.jsp">Pastelero</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="CalculadoraInsumos.jsp">+ Calculadora Lista</a>
                        </li>
                        
                    </ul>
                </div>
            </div>
        </header>
    </body>
</html>
