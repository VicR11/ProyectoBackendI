window.addEventListener('load', function () {


    //Buscamos y obtenemos el formulario donde estan
    //los datos que el usuario pudo haber modificado de la pelicula
    const formulario = document.querySelector('#update_turno_form');

    formulario.addEventListener('submit', function (event) {

        let pacienteId = document.querySelector('#turno_id').value;

        //creamos un JSON que tendrá los datos de la película
        //a diferencia de una pelicula nueva en este caso enviamos el id
        //para poder identificarla y modificarla para no cargarla como nueva
        const formData = {
               id:document.querySelector('#turno_id').value,
               odontologo: { id: document.querySelector('#nombreOdontologo').value}, // Valor seleccionado del select de odontólogos
               paciente: { id: document.querySelector('#nombrePaciente').value}, // Valor seleccionado del select de pacientes
               fechaHora: document.querySelector('#fechaHora').value // Valor del input datetime-local

        };



        //invocamos utilizando la función fetch la API peliculas con el método PUT que modificará
        //la película que enviaremos en formato JSON
        const url = '/turnos';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())
           .then(data => {
                   console.log(data); // Aquí imprimimos la respuesta JSON parseada
               })


    })
 })

    //Es la funcion que se invoca cuando se hace click sobre el id de una pelicula del listado
    //se encarga de llenar el formulario con los datos de la pelicula
    //que se desea modificar
    function findBy(id) {

          const url = '/turnos/'+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let turno = data;
              document.querySelector('#turno_id').value = turno.id;
              document.querySelector('#nombreOdontologo').value = turno.odontologo.id;
              document.querySelector('#nombrePaciente').value = turno.paciente.id;
              document.querySelector('#fechaHora').value = turno.fechaHora.slice(0, 16);
              //el formulario por default esta oculto y al editar se habilita
              document.querySelector('#div_turno_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
          })
      }