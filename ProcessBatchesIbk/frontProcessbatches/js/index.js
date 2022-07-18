 
    const fecth = require("node-fetch")
    const exec= require("c")('child_process').exec
    
    
    function runFetch(){
        readTxt();
     console.log("Ejecutando request fetch..");
     messageLogUI("Iniciando ejecución...")
     messageLogUI("Error en  ejecución...")
     fetch("http://localhost:3000/app/runbatches")
    .then(promesaFetch => promesaFetch.ok)
    .then(content=console.log(content))
    .catch(err => console.error(err) );
  
    }
  
    function messageLogUI(ms){
       /* var listAdd = document.createElement('li');
        listAdd.appendChild(document.createTextNode(ms));
        document.getElementById('log-container').appendChild(listAdd);*/     
    }
    
    function clearLog(){

    }
    
    
    function powerOffServer(){
        alert("Esta seguro que desea apagar el servidor?")
        exec('node index.js', (err, stdout) =>{
            if(err){
                throw err;
            }else{
                alert("Se inició el servidorn correcamente")
                console.log("Iniciando ejecución")
            }     
            console.log(stdout);      
        });  
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

