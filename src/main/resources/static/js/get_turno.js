window.addEventListener('load', function () {
    loadTurnos();


    (function(){
      let pathname = window.location.pathname;
      if (pathname == "/turnoList.html") {
          document.querySelector(".nav .nav-item a:last").addClass("active");
      }
    })


    })

    function loadTurnos() {
             const url = '/turnos';
              const settings = {
                method: 'GET'
              }

              fetch(url,settings)
              .then(response => response.json())
              .then(data => {
              console.log(data);
              //recorremos la colección de peliculas del JSON
                 for(turno of data){
                    //por cada pelicula armaremos una fila de la tabla
                    //cada fila tendrá un id que luego nos permitirá borrar la fila si eliminamos la pelicula
                    var table = document.getElementById("turnoTable");
                    var turnoRow =table.insertRow();
                    let tr_id = 'tr_' + turno.id;
                    turnoRow.id = tr_id;

                    //por cada pelicula creamos un boton delete que agregaremos en cada fila para poder eliminar la misma
                    //dicho boton invocara a la funcion de java script deleteByKey que se encargará
                    //de llamar a la API para eliminar una pelicula
                    let deleteButton = '<button' +
                                              ' id=' + '\"' + 'btn_delete_' + turno.id + '\"' +
                                              ' type="button" onclick="deleteBy('+turno.id+')" class="btn btn-danger btn_delete">' +
                                              '&times' +
                                              '</button>';

                    //por cada pelicula creamos un boton que muestra el id y que al hacerle clic invocará
                    //a la función de java script findBy que se encargará de buscar la pelicula que queremos
                    //modificar y mostrar los datos de la misma en un formulario.
                    let updateButton = '<button' +
                                              ' id=' + '\"' + 'btn_id_' + turno.id + '\"' +
                                              ' type="button" onclick="findBy('+turno.id+')" class="btn btn-info btn_id">' +
                                              turno.id +
                                              '</button>';

                   const fechaHora = new Date(turno.fechaHora);

                   // Obtener la fecha local formateada
                   const fechaFormateada = fechaHora.toLocaleDateString('es-ES'); // Cambia 'es-ES' por tu configuración regional si es necesario

                   // Obtener la hora local formateada
                   const horaFormateada = fechaHora.toLocaleTimeString('es-ES', { hour: '2-digit', minute: '2-digit' });
                    turnoRow.innerHTML = '<td>' + updateButton + '</td>' +
                            '<td class=\"td_odontologo\">' + turno.odontologo.nombre.toUpperCase()+" "+turno.odontologo.apellido.toUpperCase() + '</td>' +
                            '<td class=\"td_paciente\">' + turno.paciente.nombre.toUpperCase()+" "+turno.paciente.apellido.toUpperCase()  + '</td>' +
                            '<td class=\"td_fechaHora\">'  + fechaFormateada + ' ' + horaFormateada + '</td>' +
                            '<td>' + deleteButton + '</td>';

                };

            })
        }