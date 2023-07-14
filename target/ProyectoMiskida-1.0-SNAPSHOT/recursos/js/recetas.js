$(document).ready(function () {
  $.get("rc", { "opc": 1 }, function (data) {
      console.log(data);
    var x = JSON.parse(data);
console.log(x);
    x.forEach(function (item) {
            console.log(item);
      var binaryData = item.imagen.binaryData;
      var blob = new Blob([new Uint8Array(binaryData)], { type: 'image/png' });
      var reader = new FileReader();

      reader.onload = function (e) {
        var dataURL = e.target.result;
        var imagen = $("<img>").attr("src", dataURL);

        var recetaDiv = $("<div>").addClass("receta");
        var nombre = $("<p>").text(item.nombre_rec).css("font-weight", "bold");
        var vista = $("<p><span>").text("Vista").css("font-weight", "bold").addClass("vista");
        

        var enlace = $("<a>").attr("href", "inforeceta.jsp?nombre=" + encodeURIComponent(item.nombre_rec)).append(vista);
        enlace.click(function () {
            var nombreReceta = $(this).attr("href").split("=")[1];

            window.location.href = "inforeceta.jsp?nombre=" + nombreReceta;
        });


        recetaDiv.append(imagen, nombre, enlace);
        

        $("#receta-container").append(recetaDiv);
      };

      reader.readAsDataURL(blob);
    });
  });
});