
const express = require('express');
const cors = require('cors');
const exec = require('child_process').exec
const app = express();
const port = 3000;
app.use(cors());
const url='/app/runbatches'

app.listen('3000', function() {
    console.log('Servidor escuchando en el puerto 3000');
  });

  app.get(url, cors(),(req, res) => {
    res.send('Processing..');
    runBatch();
  });

function runBatch(){
     
    exec('start main.bat', (err, stdout) =>{
        if(err){
            throw err;
        }else{
            console.log("Iniciando ejecución")
        }     
        console.log(stdout);      
    });  
}

