/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {


    editar();
    $("#modificar").click(function () {
    var id = $("#id").val();
    var nombre = $("#nombre").val();
    var dnip = $("#dnip").val();
    var telef = $("#telef").val();
    var contra = $("#pass").val();
    $.post("PTC", {"opc": 4,"id":id, "nombre": nombre, "dnip": dnip, "telef": telef, "contra": contra}, function () {
    });
});
    


});




function editar() {
    const urlParams = new URLSearchParams(window.location.search);
    const dato = urlParams.get('dato');

    $.get("PTC", {"opc": 2, "Id": dato}, function (data) {

        var x = JSON.parse(data);
        console.log(x);
        document.getElementById("id").value = x.Id;
        document.getElementById("nombre").value = x.nombre_pastelero;
        document.getElementById("dnip").value = x.dnip;
        document.getElementById("telef").value = x.tel_pastelero;
        document.getElementById("pass").value = x.contra;

    });

}

function eliminar(){
    
    $.get("PTC",{"Id":dato,"opc":5},function () {
    });
}




