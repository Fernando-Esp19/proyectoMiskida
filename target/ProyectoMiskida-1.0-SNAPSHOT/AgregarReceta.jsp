<%-- 
    Document   : AgregarReceta
    Created on : 13 jul. 2023, 20:45:15
    Author     : Taily
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Agregar datos a una tabla</title>
        <link href="css/EstiloAgregarReceta.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <style>
            table {
                border-collapse: collapse;
            }

            table, th, td {
                border: 1px solid black;
                padding: 5px;
            }

            #dataInput {
                margin-bottom: 10px;
            }

            .custom-header {
                background-color: #ffc0cb; /* Color rosa claro */
            }

            .image-upload {
                display: flex;
                flex-direction: column;
                align-items: center;
                gap: 10px;
            }

            .image-preview {
                width: 700px;
                height: 200px;
                border: 2px dashed #ccc;
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                cursor: pointer;
            }

            .upload-button {
                padding: 10px 20px;
                background-color: #009E0F;
                color: #fff;
                border-radius: 4px;
            }

            #image-upload-input {
                display: none;
            }



        </style>
    </style>
</head>
<body>
    <jsp:include page="Header.jsp" />

    <div class="input-containers">
        <label>Nombre del postre:</label><br><br>
        <input type="text" class="input" id="nombrepostre">
    </div>
    <div class="image-upload">
        <label for="image-upload-input" class="image-preview">
            <img id="preview" src="#" alt="Imagen previa" />
            <span class="upload-button">Seleccionar imagen</span>
        </label>
        <input type="file" id="image-upload-input" accept="image/*" />
    </div>
    <div class="container">
        <div class="column">
            <h4>Ingredientes</h4>

            <div id="dataInput" class="input-container">

                <div class="form-inline" >

                    <div class="form-group mr-2">
                        <label>Nombre de insumo:</label>
                        <input type="text" class="input" id="nombreInsumo">
                    </div>
                    <div class="form-group mr-2">
                        <label>Cantidad:</label>
                        <input type="text" class="input" id="cantidad">
                    </div>
                    <div class="form-group mr-2">
                        <label>Unidades de medida:</label>
                        <input type="text" class="input" id="unidades">
                    </div>

                    <button onclick="agregarFila()">Agregar a tabla</button>

                </div>
            </div>
            <div  class="table-container">
                <table id="tablaInsumos" >
                    <tr>
                        <th>Nombre de insumo</th>
                        <th>Cantidad</th> 
                        <th>Unidades de medida</th>
                    </tr>
                </table>
            </div>
        </div>
        <div class="column">
            <h4 id="procedimientoTitulo">Procedimiento</h4>

            <div id="dataInputs" class="input-container">

                <div class="form-inline">
                    <div class="form-group mr-2">
                        <label>Paso:</label>
                        <input type="text" class="input" id="paso">
                    </div>
                    <div class="form-group mr-2">
                        <label>Cantidad:</label>
                        <input type="text" class="input" id="cantidadp">
                    </div>
                    <div class="form-group mr-2">
                        <label>Duración:</label>
                        <input type="text" class="input" id="duracion">
                    </div>
                    <button  onclick="agregarFila1()">Agregar a tabla</button>
                </div>
            </div>
            <div class="table-container">
                <table id="tablapasos">
                    <tr>
                        <th>Pasos</th>
                        <th>Cantidades</th>
                        <th>Duración</th>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <button onclick="guardarDatos()">Guardar</button>

    <script>
        function agregarFila() {
            var nombreInsumo = document.getElementById("nombreInsumo").value;
            var cantidad = document.getElementById("cantidad").value;
            var unidades = document.getElementById("unidades").value;

            var tabla = document.getElementById("tablaInsumos");
            var fila = tabla.insertRow(-1);
            var celdaNombre = fila.insertCell(0);
            var celdaCantidad = fila.insertCell(1);
            var celdaUnidades = fila.insertCell(2);
            celdaNombre.innerHTML = nombreInsumo;
            celdaCantidad.innerHTML = cantidad;
            celdaUnidades.innerHTML = unidades;

            limpiarCampos();
        }
        function agregarFila1() {
            var paso = document.getElementById("paso").value;
            var cantidadp = document.getElementById("cantidadp").value;
            var duracion = document.getElementById("duracion").value;

            var tabla = document.getElementById("tablapasos");
            var fila = tabla.insertRow(-1);
            var celdaPaso = fila.insertCell(0);
            var celdaCantidadp = fila.insertCell(1);
            var celdaDuracion = fila.insertCell(2);
            celdaPaso.innerHTML = paso;
            celdaCantidadp.innerHTML = cantidadp;
            celdaDuracion.innerHTML = duracion;

            limpiarCampos1();
        }

        function limpiarCampos() {
            document.getElementById("nombreInsumo").value = "";
            document.getElementById("cantidad").value = "";
            document.getElementById("unidades").value = "";
        }
        function limpiarCampos1() {
            document.getElementById("paso").value = "";
            document.getElementById("cantidadp").value = "";
            document.getElementById("duracion").value = "";
        }
        function limpiarTabla() {
            // Limpiar campos de entrada de datos
            document.getElementById("nombreInsumo").value = "";
            document.getElementById("cantidad").value = "";
            document.getElementById("unidades").value = "";

            // Limpiar tabla
            var tabla = document.getElementById("tablaInsumos");
            while (tabla.rows.length > 1) {
                tabla.deleteRow(1);
            }
        }
        function guardarDatos() {
            //var = document.getElementById("nombrepostre");
            var tabla2 = document.getElementById("tablaInsumos");
            var tabla = document.getElementById("tablaPasos");
            var filas = tabla.getElementsByTagName("tr");
            var filas2 = tabla2.getElementsByTagName("tr");

            var datos2 = [];
            var datos = [];
            for (var i = 1; i < filas.length; i++) {
                var celdas = filas[i].getElementsByTagName("td");
                var nombreInsumo = celdas[0].innerHTML;
                var cantidad = celdas[1].innerHTML;
                var unidades = celdas[2].innerHTML;

                datos.push({
                    nombreInsumo: nombreInsumo,
                    cantidad: cantidad,
                    unidades: unidades
                });
            }
            console.log(datos);
            // Aquí puedes realizar una acción con los datos, como enviarlos a un servidor o almacenarlos localmente.
            for (var i = 1; i < filas2.length; i++) {
                var celdas2 = filas2[i].getElementsByTagName("td");
                var paso = celdas2[0].innerHTML;
                var cantidadp = celdas2[1].innerHTML;
                var duracion = celdas2[2].innerHTML;

                datos2.push({
                    paso: paso,
                    cantidadp: cantidadp,
                    duracion: duracion
                });
            }
            console.log(datos2);

            for (var i = 0; i < datos.length; i++) {
                var dato = datos[i];

                $.get("IC", {
                    opc: 1,
                    nombre_insumo: dato.nombreInsumo,
                    cantidad: dato.cantidad,
                    unidades: dato.unidades
                }, function () {
                    // Tu código de respuesta aquí
                });
            }

            for (var i = 0; i < datos2.length; i++) {
                var dato2 = datos2[i];

                $.get("IC", {
                    opc: 1,
                    paso: dato2.paso,
                    cantidadp: dato2.cantidadp,
                    duracion: dato2.duracion
                }, function () {
                    // Tu código de respuesta aquí
                });
            }






            alert("Los datos se guardaron correctamente.");
            limpiarTabla();
        }

    </script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</body>
</html>
