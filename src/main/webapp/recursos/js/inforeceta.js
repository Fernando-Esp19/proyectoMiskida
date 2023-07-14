var recetaArray = [];
$(document).ready(function () {
    var x = $("#nombre").text();

    console.log(x);
    
    $.get("rc", {"opc": 2, "nombre_rec": x}, function (data) {
        var x = JSON.parse(data);
        console.log(x);


        var binaryData = x.imagen.binaryData;
        var blob = new Blob([new Uint8Array(binaryData)], {type: 'image/png'});
        var reader = new FileReader();

        reader.onload = function (e) {
            var dataURL = e.target.result;

            // Crear la etiqueta <img> y asignar la URL de datos (data URL) como src
            var imagen = $("<img>").attr("src", dataURL);

            // Agregar la imagen al elemento del DOM deseado
            $("#imagen-container").append(imagen);
        };

        reader.readAsDataURL(blob);


    });
  

// Agregar un evento 'change' al input
    $(".small-input").on("change", function () {
        recetaArray = [];
        // Obtener el nuevo valor del input y convertirlo a un número entero
        var cantidadInput = parseInt($(this).val());

        // Limpiar el contenido existente 
        $("#ingrediente").empty();
        $("#paso").empty();
        $("#tiempo").empty();



        // Realizar la solicitud $.get con el nuevo valor del input
        $.get("rc", {"opc": 3, "nombre_rec": x}, function (data2) {
            var y = JSON.parse(data2);
            console.log(data2);
            console.log(y);

            y.forEach(function (data2, index) {
                var nombreInsumo = data2.nombre_insumo;
                var cantidadNecesaria = data2.cantidad_necesaria;
                var unidadCantn = data2.unidad_cantn;

                // Multiplicar la cantidad necesaria por el valor del input
                cantidadNecesaria *= cantidadInput;

                // Crear un elemento <div> para cada registro
                var $div = $("<div class='registro'></div>");

                // Agregar el número de orden en negrita antes del nombre del insumo
                var $orden = $("<span class='orden'></span>").text((index + 1) + ". ");
                $orden.css("font-weight", "bold");

                // Agregar las columnas al elemento <div>
                var $columnaNombreInsumo = $("<div class='columna'></div>").append($orden).append(nombreInsumo);
                var $columnaCantidadNecesaria = $("<div class='columna'></div>").text(cantidadNecesaria);
                var $columnaUnidadCantn = $("<div class='columna'></div>").text(unidadCantn);

                $div.append($columnaNombreInsumo);
                $div.append($columnaCantidadNecesaria);
                $div.append($columnaUnidadCantn);

                // Agregar el elemento <div> al elemento con id "ingrediente"
                $("#ingrediente").append($div);
            });

            // Obtener el máximo ancho de cada columna
            var maxNombreInsumoWidth = Math.max.apply(
                    null,
                    $(".columna:nth-child(1)").map(function () {
                return $(this).width();
            })
                    );

            var maxCantidadNecesariaWidth = Math.max.apply(
                    null,
                    $(".columna:nth-child(2)").map(function () {
                return $(this).width();
            })
                    );

            var maxUnidadCantnWidth = Math.max.apply(
                    null,
                    $(".columna:nth-child(3)").map(function () {
                return $(this).width();
            })
                    );

            // Aplicar el ancho máximo a todas las columnas correspondientes
            $(".columna:nth-child(1)").width(maxNombreInsumoWidth);
            $(".columna:nth-child(2)").width(maxCantidadNecesariaWidth);
            $(".columna:nth-child(3)").width(maxUnidadCantnWidth);
        });




        // Realizar la solicitud $.get con el nuevo valor del input
        $.get("rc", {"opc": 4, "nombre_rec": x}, function (data3) {
            var y = JSON.parse(data3);
            console.log(data3);
            console.log(y);

            y.forEach(function (data3, index) {
                var paso = data3.paso;
                var cantidadNecesaria = data3.cantidad;
                var unidadCantn = data3.unidad;
                var duracion = data3.duracion;

                // Multiplicar la cantidad necesaria por el valor del input
                cantidadNecesaria *= cantidadInput;
                
                var pasoActual = {
                    paso: paso,
                    cantidad: cantidadNecesaria,
                    unidad: unidadCantn,
                    duracion: duracion
                };
                recetaArray.push(pasoActual);


                // Crear un elemento <div> para cada registro
                var $div = $("<div class='pasitos'></div>");
                var $div2 = $("<div class='dura'></div>");
                // Agregar la columna de paso al elemento <div>
                var $columnaPaso = $("<div class='columna'></div>").text("- " + paso);
                $div.append($columnaPaso);

                // Verificar si la cantidad es mayor a 0 y agregar la columna de cantidad necesaria al elemento <div>
                if (cantidadNecesaria > 0) {
                    var $columnaCantidadNecesaria = $("<div class='columna'></div>").text(cantidadNecesaria);
                    $div.append($columnaCantidadNecesaria);
                }

                // Agregar la columna de unidad cantn al elemento <div>
                var $columnaUnidadCantn = $("<div class='columna'></div>").text(unidadCantn);
                $div.append($columnaUnidadCantn);

                var $columnaduracion = $("<div class='columna'></div>").text(duracion + " segundos");
                $div2.append($columnaduracion);
                // Agregar el elemento <div> al elemento con id "paso"
                $("#paso").append($div);
                $("#tiempo").append($div2);
            });

            // Obtener el máximo ancho de cada columna
            var maxPasoWidth = Math.max.apply(
                    null,
                    $(".columna:nth-child(1)").map(function () {
                return $(this).width();
            })
                    );

            var maxCantidadNecesariaWidth = Math.max.apply(
                    null,
                    $(".columna:nth-child(2)").map(function () {
                return $(this).width();
            })
                    );

            var maxUnidadCantnWidth = Math.max.apply(
                    null,
                    $(".columna:nth-child(3)").map(function () {
                return $(this).width();
            })
                    );

            // Aplicar el ancho máximo a todas las columnas correspondientes
            $(".columna:nth-child(1)").width(maxPasoWidth);
            $(".columna:nth-child(2)").width(maxCantidadNecesariaWidth);
            $(".columna:nth-child(3)").width(maxUnidadCantnWidth);

            // Agregar margen derecho a las columnas para separarlas
            $(".columna").css("margin-right", "20px");
            
            console.log(JSON.stringify(recetaArray));
        });
    });

// Disparar el evento 'change' del input al cargar la página
    $(".small-input").change();

});








// Obtener el botón "Iniciar Procedimiento" por su ID
var btnIniciarProcedimiento = document.getElementById("btnIniciarProcedimiento");

btnIniciarProcedimiento.addEventListener("click", function() {
  // Verificar si existen pasos en la receta
  if (recetaArray.length > 0) {
    // Obtener el primer paso de la receta
    var primerPaso = recetaArray[0];
        if (recetaArray[0] ===0.000) {
            
        } else {
            primerPaso.cantidad = "";
        }

    // Crear el cuadro de diálogo para mostrar el primer paso
    $("<div></div>")
      .attr("title", "Primer Paso de la Receta")
        
      .html("<p>Paso: " + primerPaso.paso+" "+primerPaso.cantidad+" "+primerPaso.unidad + "</p>")
      .dialog({
        modal: true,
        buttons: {
          Siguiente: function() {
            // Cerrar el cuadro de diálogo
            $(this).dialog("close");
            
            // Remover el primer paso de la receta
            recetaArray.shift();

            // Mostrar el siguiente paso (si hay alguno)
            mostrarSiguientePaso();
          }
        }
      });
  }
});
// Función para mostrar el siguiente paso de la receta
function mostrarSiguientePaso() {
  // Verificar si existen pasos en la receta
  if (recetaArray.length > 0) {
    // Obtener el siguiente paso de la receta
    var siguientePaso = recetaArray[0];
    console.log(siguientePaso.cantidad);
        
    
    // Crear un cuadro de diálogo para mostrar el siguiente paso
    var dialogo = $("<div></div>").attr("title", "Siguiente Paso de la Receta");
    if (siguientePaso.cantidad===0) {
            var contenido = $("<p></p>").text("Paso: " + siguientePaso.paso);
        } else {
            var contenido = $("<p></p>").text("Paso: " + siguientePaso.paso+" "+siguientePaso.cantidad+" "+siguientePaso.unidad );
        }
    
    dialogo.append(contenido);

    // Mostrar el cuadro de diálogo
    dialogo.dialog({
      modal: true,
      buttons: {
        Siguiente: function() {
          // Cerrar el cuadro de diálogo
          $(this).dialog("close");
          
          // Remover el siguiente paso de la receta
          recetaArray.shift();

          // Mostrar el siguiente paso (si hay alguno)
          mostrarSiguientePaso();
        }
      }
    });
  }
}