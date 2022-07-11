
const express = require('express');
const cors = require('cors');
const exec = require('child_process').exec
const app = express();
const port = 3000;
app.use(cors());

app.listen('3000', function() {
    console.log('Servidor web escuchando en el puerto 3000');
  });

  app.get('/app/runbatches', cors(),(req, res) => {
    res.send('Processing..')
    console.log("se direcciono a la ruta principal"); 
    exec('cd..', (err, stdout) =>{
        if(err){
            throw err;
        }else{
            directPathBatch();             
        }
        console.log(stdout);
    });
  });

function directPathBatch(){ 
    exec('cd  batchesProcessbatches', (err, ) =>{
        if(err){
            throw err;
        }else{
            console.log("se direcciono a la ruta de los batchs");  
            runBatch()
        }           
    });   
}

function runBatch(){
    exec('start main.bat', (err, stdout) =>{
        if(err){
            throw err;
        }else{
            console.log("se ejecuto el batch")
        }           
    });  
}

