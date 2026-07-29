# HU-01: Registro de Ficha de Viaje

**Como** Encargado de Registro
**Quiero** capturar y almacenar en una estructura de datos externa los datos del carro, del motor, del chofer y del pasajero
**Para** tener centralizada toda la información de un viaje en un único registro

## Criterios de Aceptación:
1. El sistema debe permitir ingresar los datos del carro (obligatorios): placa, marca y modelo.
2. El sistema debe permitir ingresar los datos del motor (obligatorios): número de serie y tipo.
3. El sistema debe permitir ingresar los datos del chofer (obligatorios): cédula, nombre completo y licencia.
4. El sistema debe permitir ingresar los datos del pasajero (obligatorios): cédula y nombre completo.
5. Toda la información se debe guardar temporalmente antes de ser enviada a la base de datos definitiva.
6. El sistema debe validar que todos los campos obligatorios de los 4 conjuntos estén completos antes de permitir confirmar el guardado.
7. Si falta algún dato obligatorio, el sistema debe mostrar un mensaje de error indicando los campos faltantes.
8. Al guardar exitosamente, el sistema debe mostrar un mensaje de confirmación y limpiar los campos para un nuevo registro.
