<%-- 
    Document   : CalculadoraInsumos
    Created on : 11 jul. 2023, 23:18:48
    Author     : Taily
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Formulario de Insumos</title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;700&display=swap" rel="stylesheet">
        <link href="css/EstiloRegistros.css" rel="stylesheet" type="text/css"/>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        
    </head>
    <body>
        
        
        <div class="Contenedor-formularioP contenedor">
            <div class="texto-formularioP">
                <h2>Formulario de Insumos</h2>
            </div>

            <form id="formularioInsumos" action="CC" method="Post">
                <div class="input">
                    <label for="insumo">Insumo:</label>
                    <input type="text" id="insumo" name="insumo" required>
                </div>
                <div class="input">
                    <label for="cantidadNecesaria">Cantidad Necesaria:</label>
                    <input type="number" id="cantidadNecesaria" name="cantidadNecesaria" min="0" required>
                </div>
                <div class="input">
                    <label for="cantidadAlmacenada">Cantidad Almacenada:</label>
                    <input type="number" id="cantidadAlmacenada" name="cantidadAlmacenada" min="0" required>
                </div>
                <div id="formularioInsumos-color">
                    <div class="input3">
                        <label for="cantidadFaltante">Cantidad Faltante:</label>
                        <input type="number" id="cantidadFaltante" name="cantidadFaltante" readonly>
                    </div>
                </div>
                <div class="inputb">
                    <input type="submit" name="menu" value="Calcular">
                    <input type="submit" value="Cancelar">
                    <input type="submit" name ="menu" id="Agregar" value="Agregar">
                </div>
            </form>

            <script>
                document.getElementById("formularioInsumos").addEventListener("submit", function (event) {
                    event.preventDefault(); // Evitar el envío del formulario por defecto

                    var insumo = document.getElementById("insumo").value;
                    var cantidadNecesaria = parseInt(document.getElementById("cantidadNecesaria").value);
                    var cantidadAlmacenada = parseInt(document.getElementById("cantidadAlmacenada").value);
                    var cantidadFaltante = Math.max(cantidadNecesaria - cantidadAlmacenada, 0);

                    
                    document.getElementById("cantidadFaltante").value = cantidadFaltante;

                    $("#Agregar").click(function () {
                        $.get("CC", {"opc": 1, "cantidadf": cantidadFaltante, "cantidada": cantidadAlmacenada, "cantidadn": cantidadNecesaria, "nombre": insumo}, function () {
                        });
                        limpiar();
                    });

                });
                function limpiar() {
                    $("#insumo").val("");
                    $("#cantidadNecesaria").val("");
                    $("#cantidadAlmacenada").val("");
                    $("#cantidadFaltante").val("");
                }
            </script>
        </div>

    </body>
</html>