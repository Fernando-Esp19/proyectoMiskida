/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function (){
    listarCate();
   
});

function listarCate(){
    
    $.get("PTC",{"opc":1},function (data) {
        var x = JSON.parse(data);
          $("   #tablita tbody tr").remove(); 
        for(var i = 0;i<x.length;i++){
            $("#tablita").append("<tr><td>"+(i+1)+"</td><td>"+x[i].Id+"</td><td>"+x[i].nombre_pastelero+"</td><td>"+x[i].dnip+"</td><td>"+x[i].tel_pastelero+"</td><td><a  onclick='editar("+x[i].Id+")'><i class='far fa-edit'></i></a></td><td><a  onclick='eliminar("+x[i].Id+")'><i class='fas fa-trash-alt'></i></a></td></tr>");
        }
    });

}

/*function pasar(x){
    window.location.href =  `ModificarPastelero.jsp?dato=${encodeURIComponent(x)}`;
  
   
     
}*/



function editar(x) {

    $.get("PTC", {"opc": 2, "Id": x}, function (data) {

        var x = JSON.parse(data);
        console.log(x);
        $("#id").val(x.Id);
        $("#nombre").val(x.nombre_pastelero);
        $("#dnip").val(x.dnip);
        $("#telef").val(x.tel_pastelero);
        $("#pass").val(x.contra);
         $("#myModal5").modal('show');

    });

}

function eliminar(x){
    
    $.get("PTC",{"Id":x,"opc":5},function () {
        listarCate();
    });
}


    $("#modificar").click(function () {
            var id=$("#id").val();
    var nombre = $("#nombre").val();
    var dnip = $("#dnip").val();
    var telef = $("#telef").val();
    var contra = $("#pass").val();
    $.post("PTC", {"opc": 4, "id":id,"nombre": nombre, "dnip": dnip, "telef": telef, "contra": contra}, function () {
           listarCate();
    });
    $("#myModal5").modal('hide');

});

$("#cerrarmodal").click(function (){
    $("#myModal5").modal('hide');
});







