
    $(document).ready(function() {
        $("#reporte-link").click(function(event) {
            event.preventDefault(); // Evitar acción de navegación predeterminada
            
            ejecutarClaseJava();
        });
    });
    
    function ejecutarClaseJava() {
        $.ajax({
            url: "rec",
            type: "POST",
            success: function(response) {
                // Aquí puedes manejar la respuesta del servidor después de ejecutar la clase Java
                console.log(response);
            },
            error: function(xhr, status, error) {
                // Manejo de errores de la solicitud AJAX
                console.log("Error en la solicitud AJAX: " + status + ", " + error);
            }
        });
    }


