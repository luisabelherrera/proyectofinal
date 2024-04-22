$.ajax({
    type: 'POST',
    url: '/estudiante/crear',
    data: formulario.serialize(),
    dataType: 'json',
    success: function(respuesta) {
        $('#mensaje').removeClass('alert-danger').addClass('alert-success').text(respuesta.mensaje).show();
        formulario[0].reset(); // Limpia el formulario
    },
    error: function() {
        $('#mensaje').removeClass('alert-success').addClass('alert-danger').text('Error al registrar el estudiante').show();
    }
});
