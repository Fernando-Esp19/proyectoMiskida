/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validar() {
    /*
     nombre = document.getElementById("dni").value();
     nombre = document.getElementById("telefono").value();
     if(nombre==="" || correo==="" || dni==="" || telefono ===""){
     alert("Todos los campos son obligatorios");
     return false; //ahi se queda
     }
     */
    var nombre = document.getElementById('nombre').value;
    var dni = document.getElementById('dnip').value;
    var telefono = document.getElementById('telef').value;
    var contra = document.getElementById('pass').value;

    if (nombre.length < 3) {
        alert('El nombre debe tener al menos 3 caracteres');
        return false;
    }
    const regexSoloLetras = /^[A-Za-z]+$/;

    if (!regexSoloLetras.test(nombre)) {
        alert('Solo se permiten letras en el nombre.');
        return false;
    }
   
    if (nombre === '') {
        alert('El campo nombre no puede estar vacío');
        return false;
    }
    if (dni === '') {
        alert('El campo DNI no puede estar vacío');
        return false;
    }
    if (telefono === '') {
        alert('El campo telefono no puede estar vacío');
        return false;
    }
    if (contra === '') {
        alert('El campo contra no puede estar vacío');
        return false;
    }


    // Validar que el DNI tenga exactamente 8 números
    if (dni.length !== 8) {
        alert('El DNI debe contener 8 números');
        return false;
    }

    var telefonoRegex = /^\d+$/;
    if (!telefonoRegex.test(telefono)) {
        alert('El teléfono debe contener solo números');
        return false;
    }
    if (telefono.length !== 9) {
        alert('El telefono debe contener 9 números');
        return false;
    }
    return true;
}


