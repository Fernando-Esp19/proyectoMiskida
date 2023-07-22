<%-- 
    Document   : AgregarReceta
    Created on : 13 jul. 2023, 20:45:15
    Author     : Taily
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
           <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@400;700&display=swap" rel="stylesheet">
        <link href="recursos/css/EstiloAgregarReceta.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <style>


            .tabla-celda {
                padding: 8px; /* Ajusta el valor según tus necesidades */
                text-align: left;
                border-bottom: 1px solid #ddd;
                width: 300px; /* Ajusta el valor según tus necesidades */
                white-space: nowrap; /* Evita el ajuste automático del texto */
            }

            #dataInput {
                margin-bottom: 10px;
            }

            .image-upload {
                display: flex;
                flex-direction: column;
                align-items: center;
                gap: 10px;
            }

            .image-preview {
                width: 500px;
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

            .table-wrapper {
                height: 200px;
               

            }


            /* Estilo para el contenedor de las tablas */
            .button-container {
                display: flex;
                justify-content: center;
                align-items: center;
                margin-top: 10px; /* Ajusta el margen superior para separar del contenido de la tabla */
            }
            /* Ajusta el ancho de las celdas dentro de las tablas */
            #tablaInsumos th, #tablaInsumos td,
            #tablapasos th, #tablapasos td {
                padding: 12px; /* Ajusta el relleno según tus necesidades */
            }
            .button-container button {
                /* Estilos adicionales para el botón "Guardar" */
                background-color: #009E0F;
                color: aliceblue;
                font-size: 18px;
                font-weight: bold;
                border: none;
                transition: background-color .3s ease-in-out;
                border-radius: 50px;
                padding: 8px 80px;
                justify-content: space-between;
                flex-wrap: wrap;
            }
        </style>
    </head>
    <body>
        <jsp:include page="Header.jsp" />


        <form action="sc"  method="POST" >
            <div class="container">
                <div class="column">
                    <h4>Ingredientes</h4>

                    <input type="hidden" id="postre" name="postre" value="<%= request.getParameter("dato")%>">
                    <div id="dataInput" class="input-container">

                        <div class="form-inline" >

                            <div class="form-group mr-2">
                                <label>Nombre de insumo:</label>

                                <select name="opcion" class="input" id="insumo-select" >
                                    <option value="">Nombre insumo</option>
                                </select>
                            </div>
                            <div class="form-group mr-2">
                                <label>Cantidad:</label>
                                <input type="number" class="input" id="cantidad">
                            </div>
                            <div class="form-group mr-2">
                                <label>Unidades de medida:</label>
                                <select name="opcion" class="input" id="unidades">
                                    <option value=""  >unidades</option>
                                    <option >g</option>
                                    <option >ml</option>
                                    <option >u</option>
                                </select>

                            </div>


                            <span class="insertar" onclick="agregarFila()">Agregar a tabla</span>

                        </div>
                    </div>
                    <div  class="table-container">
                        <div class="table-wrapper">
                            <table id="tablaInsumos" >
                                <tr>
                                    <th class="tabla-celda">Nombre de insumo</th>
                                    <th class="tabla-celda">Cantidad</th> 
                                    <th class="tabla-celda">Unidades de medida</th>
                                </tr>
                            </table>
                            <input type="hidden" name="datos_insumos" id="datos_insumos" value="">
                        </div>
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
                                <input type="number" class="input" value="0.000" id="cantidadp">
                            </div>
                            <div class="form-group mr-2">
                                <label>Unidades de medida:</label>
                                <select name="opcion2" class="input" id="unidades2" >
                                    <option value="null"  >unidades</option>
                                    <option >g</option>
                                    <option >ml</option>
                                    <option >u</option>
                                </select>

                            </div>
                            <div class="form-group mr-2">
                                <label>Duración:</label>
                                <input type="number" class="input" id="duracion">
                            </div>
                            <span  class="insertar" onclick="agregarFila1()">Agregar a tabla</span>

                        </div>
                    </div>
                    <div class="table-container">
                        <div class="table-wrapper">
                            <table id="tablapasos">
                                <tr>
                                    <th class="tabla-celda">Pasos</th>
                                    <th class="tabla-celda">Cantidades</th>
                                    <th class="tabla-celda">Unidades de medida</th>
                                    <th class="tabla-celda">Duración</th>
                                </tr>
                            </table>
                            <input type="hidden" name="datos_pasos" id="datos_pasos" value="">
                        </div>
                    </div>
                </div>
            </div>
            <div class="button-container">
                <button type="submit" onclick="guardarDatos()">Guardar</button>
            </div>
        </form>



        <script>

            $(document).ready(function () {


                insumo();
            });


            function insumo() {

                $.get("ac", {"opc": 1}, function (data) {
                    var x = JSON.parse(data);
                    console.log(x);
                    var select = document.getElementById("insumo-select");

                    x.forEach(function (obj) {

                        var option = document.createElement("option");
                        option.value = obj.nombre_insumo;
                        option.text = obj.nombre_insumo;
                        select.appendChild(option);
                    });
                });

            }




            function agregarFila() {
                var nombre_insumo = document.getElementById("insumo-select").value;
                var cantidad = document.getElementById("cantidad").value;
                var unidades = document.getElementById("unidades").value;

                var tabla = document.getElementById("tablaInsumos");
                var fila = tabla.insertRow(-1);
                var celdaNombre = fila.insertCell(0);
                var celdaCantidad = fila.insertCell(1);
                var celdaUnidades = fila.insertCell(2);
                celdaNombre.innerHTML = nombre_insumo;
                celdaCantidad.innerHTML = cantidad;
                celdaUnidades.innerHTML = unidades;

                limpiarCampos();
            }
            function agregarFila1() {
                var paso = document.getElementById("paso").value;
                var cantidadp = document.getElementById("cantidadp").value;
                var unidades2 = document.getElementById("unidades2").value;
                var duracion = document.getElementById("duracion").value;

                var tabla = document.getElementById("tablapasos");
                var fila = tabla.insertRow(-1);
                var celdaPaso = fila.insertCell(0);
                var celdaCantidadp = fila.insertCell(1);
                var celdaunidad = fila.insertCell(2);
                var celdaDuracion = fila.insertCell(3);
                celdaPaso.innerHTML = paso;
                celdaCantidadp.innerHTML = cantidadp;
                celdaunidad.innerHTML = unidades2;
                celdaDuracion.innerHTML = duracion;

                limpiarCampos1();
            }

            function limpiarCampos() {
                document.getElementById("insumo-select").value = "";
                document.getElementById("cantidad").value = "";
                document.getElementById("unidades").value = "";
            }
            function limpiarCampos1() {
                document.getElementById("paso").value = "";
                document.getElementById("cantidadp").value = "";
                document.getElementById("unidades2").value = "";
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

                // Leer los datos de la primera tabla y construir una matriz
                const tablaInsumos = [];
                const tablaInsumosRows = document.querySelectorAll("#tablaInsumos tr:not(:first-child)");
                tablaInsumosRows.forEach(row => {
                    const cells = row.querySelectorAll("td");
                    const nombre_insumo = cells[0].innerText;
                    const cantidad = cells[1].innerText;
                    const unidades = cells[2].innerText;
                    tablaInsumos.push({nombre_insumo, cantidad, unidades});
                });

                // Leer los datos de la segunda tabla y construir una matriz
                const tablaPasos = [];
                const tablaPasosRows = document.querySelectorAll("#tablapasos tr:not(:first-child)");
                tablaPasosRows.forEach(row => {
                    const cells = row.querySelectorAll("td");
                    const paso = cells[0].innerText;
                    const cantidades = cells[1].innerText;
                    const unidades2 = cells[2].innerText;
                    const duracion = cells[3].innerText;
                    tablaPasos.push({paso, cantidades, unidades2, duracion});
                });

                // Convertir las matrices en formato JSON y asignarlas a los campos ocultos
                document.getElementById("datos_insumos").value = JSON.stringify(tablaInsumos);
                document.getElementById("datos_pasos").value = JSON.stringify(tablaPasos);

                // Enviar el formulario
                document.querySelector("form").submit();






                alert("Los datos se guardaron correctamente.");

            }


        </script>





    </body>
</html>
