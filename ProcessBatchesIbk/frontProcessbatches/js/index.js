
const fecth = require("node-fetch")

function runFetch() {
    btnDisabled();
    console.log("Ejecutando request fetch..");
    fetch("http://localhost:3000/app/runbatches")
        .then(successFetch => successFetch.ok)
        .then(success = delayBtnActive())
        .then(success = hideMsnError())
        .catch(err => showMsnError())
}

function messageLogUI(ms) {
    /* var listAdd = document.createElement('li');
     listAdd.appendChild(document.createTextNode(ms));
     document.getElementById('log-container').appendChild(listAdd);*/
}


function readLog() {
    console.log("Leyendo log")
    fetch("http://localhost:3000/app/readfilelog")
        .then(promesaFetch => promesaFetch.ok)
        .then(content = console.log(content))
        .catch(err => console.error(err));
}

function clearLog() {

}


function powerOffServer() {
    alert("Esta seguro que desea apagar el servidor?")
    exec('node index.js', (err, stdout) => {
        if (err) {
            throw err;
        } else {
            alert("Se inició el servidorn correcamente")
            console.log("Iniciando ejecución")
        }
        console.log(stdout);
    });
}


function delayBtnActive() {
    timeoutID = window.setTimeout(btnActive, 2000);
}
function btnDisabled() {
    document.getElementById('btnExecuteBat').disabled = true;
    document.getElementById('content_spinner').innerHTML = `<div id='spinner' class="spinner"> </div>`;
}

function btnActive() {
    document.getElementById('btnExecuteBat').disabled = false;
    document.getElementById("spinner").remove();

}

function showMsnError() {
    document.getElementById('ms-error').innerHTML = 'No se pudo conectar con el servidor';
}

function hideMsnError() {
    document.getElementById('ms-error').innerHTML = '';
}



/*
        function readTxt(){
            var archivoTxt= new XMLHttpRequest();
            var ruta ='Log_Main_10072022_2255.txt';
           
           if(!ruta){
            alert("no se pudo leeer")  
            return;
           }
            archivoTxt.open("GET",ruta,false);
            archivoTxt.send(null);
            var contentFile = archivoTxt.responseText;
            var typeFile= archivoTxt.responseType;
            var pathFile = archivoTxt.responseURL;
            alert("rectura correcta")  
            console.log(typeFile); 
            console.log(pathFile ); 
            console.log(contentFile);  
            document.getElementById('log-container').innerHTML=contentFile
        }*/

