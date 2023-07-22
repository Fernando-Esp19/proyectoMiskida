<%-- 
    Document   : AgregarReceta
    Created on : 21 jul. 2023, 15:56:01
    Author     : Taily
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Agregar datos a una tabla</title>
        <link href="recursos/css/EstiloAgregarReceta.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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



        </style>

</head>
<body>
    
    <jsp:include page="Header.jsp" />

    <form action="ac"  method="POST" enctype="multipart/form-data">
    <div class="input-containers">
        <label>Nombre del postre:</label><br><br>
        <input type="text" class="input" id="nombrepostre" name="nombrepostre">
    </div>
    
    
    
    
    <div class="image-upload">
        <label for="image-upload-input" class="image-preview">
            <img id="preview" src="#" alt="Imagen previa" />
            <span class="upload-button">Seleccionar imagen</span>
        </label>
        <input type="file" id="image-upload-input" accept="image/*" name="imagen"/>
    </div>
    
    
    
    
    
    <button >Guardar</button>
</form>
    <script>
     $(document).ready(function() {
              // Cuando se selecciona una imagen, mostrarla en la vista previa
              $("#image-upload-input").change(function(event) {
                var imagen = event.target.files[0];
                var reader = new FileReader();

                reader.onload = function(e) {
                  $("#preview").attr("src", e.target.result);
                };

                reader.readAsDataURL(imagen);
              });
  
    
                });
                </script>
</body>
</html>
