
const fecth = require("node-fetch")
const exec= require("c")('child_process').exec

function runFetch(){
 console.log("Ejecutando request fetch..");
 messageLogUI("Iniciando ejecución...")
 messageLogUI("Error en  ejecución...")
 fetch("http://localhost:3000/app/runbatches")
.then(promesaFetch => promesaFetch.ok)
.then(content=console.log(content))
.catch(err => console.error(err) );
}

function messageLogUI(ms){
    var listAdd = document.createElement('li');
    listAdd.appendChild(document.createTextNode(ms));
    document.getElementById('log-container').appendChild(listAdd);
    
}

function clearLog(){
    const list = document.getElementById('log-container');
    list.removeChild(list.childNodes[0]);
}

function powerOffServer(){
    alert("se apago")
    exec('node index.js', (err, stdout) =>{
        if(err){
            throw err;
        }else{
            console.log("Iniciando ejecución")
        }     
        console.log(stdout);      
    });  
}