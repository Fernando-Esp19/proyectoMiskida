<%-- 
    Document   : TablaPastelero
    Created on : 20 jul. 2023, 00:12:33
    Author     : JOEL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Tablas</title>
        <link href="css/EstiloTabla.css" rel="stylesheet" type="text/css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

<!-- JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <jsp:include page="Header.jsp" />
        <div class="container">
            <table class="table" id="tablita">
                <h2 style="display: flex; justify-content: center;">TABLA PASTELERO</h2>
                <thead>
                    <tr>
                        <th>##</th>
                        <th>ID PASTELERO</th>
                        <th>NOMBRE</th>
                        <th>DNI</th>
                        <th>TELEFONO</th>
                        <th >ACCIONES</th>

                    </tr>
                </thead>
                <tbody>   

                </tbody>

            </table>
        </div>

        <div class="modal fade" id="myModal5" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-sm" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Modificar trabajador</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span id="cerrarmodal" aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <input type="hidden" id="id" class="form-control">
                        <div class="form-group">
                            <label>NOMBRE:</label>
                            <input type="text" id="nombre" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>DNI:</label>
                            <input type="text" id="dnip" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>TELÉFONO:</label>
                            <input type="text" id="telef" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>CONTRASEÑA:</label>
                            <input type="text" id="pass" class="form-control">
                        </div> 
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" style="background-color: #009E0F;" id="modificar">Modificar trabajador</button>
                    </div>
                </div>
            </div>
        </div>
        <div style="display: flex; justify-content: center;  "> 
            <button  style=" border-radius: 9px; background-color: #009E0F; color: #ffffff; padding: 8px 20px; border: none; font-family:'Quicksand', sans-serif;" id="bf"  class="agregar-button" onclick="location.href='AgregarPastelero.jsp'">Agregar pastelero</button>
        </div>



        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>   
        <script src="JS/Pastelero.js" type="text/javascript"></script>
    </body>

</html>