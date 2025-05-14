# Tarea2

Nombres:
Bryan Aguirre
Javier Castillo
Alfonso Gonzalez

Los cambios en el UML son:

En la clase Asistencia se agregaron:
#invitado: Invitado
-------------------
+getInvitado(): Invitado

Invitado es protected para poder ser usado por clases que estan en el mismo package.
Esto para que la asistencia tome un invitado y poder trabajar con listas de invitables
ademas de poner un toString y un getInvitado


Clase de departamento se agrego solo un setter y getter para el nombre del departamento
(por si se cambia de nombre) al igual que se agrego un toString que te transforma el nombre de departamento
y el array con todos los empleados
Por ultimo se agrego
+addEmpleado(Empleado): Empleado


Clase de Empleados y solo se crearon los getter pertinentes.


Clase Empleado solo se agregaron los getters y el toString respectivos.


En la clase Invitable solo se cambio el parametro que recibe queda tal que:
+invitar() ----> +invitar(Reunion)
solo para saber a que reunion lo estas invitando


En la clase Invitacion se agrego:

-invitado: Invitable
--------------------
+getInvitado(): Invitable

No se hizo mucho cambio solo se agrego un Invitable para saber a que persona se invito y a que hora le llego
la invitacion.
Ademas se agrego un ToString que transforma la hora y el invitado.


Clase Nota solo se agrego el toString.


Clase Retraso se agrego un getHoraAtraso para saber la hora en la que llego atrasado el Invitable
y el toString 


En la clase Reunion se agregaron
#asistencia: Arraylist<Asistencia>
#invitaciones: Arraylist<Invitacion>
#retrasos: Arraylist<Retraso>
#notas:Arraylist<Nota>
#tipoReunion:TipoReunion
-------------------------
+agregarAsistencia(Invitable) : void
+invitarAReunion(Invitable) : void
+estaInvitado(Invitable) : boolean
+crearArchivo(String) : void

Esto es:
El arraylist de Asistencias es para guardar los que vinieron a la reunion ya sea con atrasos o a tiempo,
con el ArrayList de Invitaciones, guarda todas las invitaciones que se enviaron esto es para despues poder
saber cuantos no vinieron a la reunion(Ausencias), con el ArrayList de Retrasos se guardan todas las
personas que llegaron tarde a la reunion, el ArrayList de Notas es para guardar todo lo que escriben las
personas.
Con el metodo estaInvitado agrega un false(no esta invitado) o true(si esta invitado)
Con agregarAsistencia se podran agregar las personas que vinieron a la reunion, si estan invitadas, y ver 
si llegaron tarde o puntuales.
Con invitarAReunion toma un parametro que es Invitable ya que se puede invitar a todo un departamento o a un
empleado.
Por ultimo con crear archivo solo se creara un archivo txt.


Clases ReunionPresencial y ReunionVirtual se agrego el getter, setter y toString pertinentes.


En el Enum(TipoReunion) no se cambio nada.


Tambien se creo una nueva Clase Externo para poder invitar a gente externa a la empresa es lo mismo que empleado
solo que su id es "No es empleado".
