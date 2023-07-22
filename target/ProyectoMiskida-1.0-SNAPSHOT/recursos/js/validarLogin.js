/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function validar() {

    var usuario = document.getElementById('usuario').value;
    var contraseña = document.getElementById('contraseña').value;

    if (usuario.length < 3) {
        alert('El usuario debe tener al menos 3 caracteres');
        return false;
    }
    if (contraseña === '') {
        alert('El campo Contraseña no puede estar vacío');
        return false;
    }
    if (contraseña.length < 2) {
        alert('La contraseña debe tener al menos 2 caracteres');
        return false;
    }

    // Validar si la contraseña cumple con ciertos requisitos (por ejemplo, al menos una letra mayúscula, una minúscula y un número)
    /*var requisitosRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)/;
    if (!requisitosRegex.test(contrasena)) {
        alert('La contraseña debe contener al menos una letra mayúscula, una minúscula y un número');
        return false;
    
    }*/


    var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email)) {
        alert('El correo no es válido');
                return false;
    }
    if (dni === '') {
        alert('El campo DNI no puede estar vacío');
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
