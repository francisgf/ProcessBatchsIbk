
const fecth = require("node-fetch")
function runFetch(){

 console.log("Ejecutando request fetch..");
 fetch("http://localhost:3000/app/runbatches")
.then(promesaFetch => promesaFetch.ok)
.then(content=console.log(content))
.catch(err => console.error(err.console.log("Ocurrio un error en la solicitud")) );

}