<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
  <title>Receta</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <link href="recursos/css/inforecetaestilo.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
    <jsp:include page="Header.jsp" />
    <%
  String nombreReceta = request.getParameter("nombre");
  // Aquí puedes trabajar con el valor de nombreReceta
%>
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <h1 id="nombre" class="title"><%= nombreReceta %></h1>
      </div>
    </div>
    <div class="row">
      <div class="col-md-6">
          <div class="rec" id="imagen-container"></div>
      </div>
      <div class="col-md-6">
        <input type="number" value="1" class="form-control small-input" placeholder="Cantidad" min="1">
      </div>
    </div>
    <div class="row">
      <div class="col-md-4">
        <h3>Ingredientes</h3>
        <ul id="ingrediente" class="ingredientes">

        </ul>
      </div>
      <div class="col-md-6">
        <h3>Procedimiento</h3>
        <ul id="paso" class="paso">

        </ul>
      </div>
      <div class="col-md-2">
        <h3>Duración</h3>
        <ul id="tiempo" class="tiempo">

        </ul>
      </div>
    </div>
    <div class="row mt-4">
      <div class="col">
        <button class="btn btn-success">Guardar</button>
        <button id="btnIniciarProcedimiento" class="btn btn-success">Iniciar procedimiento</button>
      </div>
    </div>
  </div>
      

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <script src="recursos/js/inforeceta.js" type="text/javascript"></script>
</body>
</html>