
const express = require('express')
const exec = require('child_process').exec
const app = express()
const port = 3000

app.listen('3000', function() {
    console.log('Servidor web escuchando en el puerto 3000');
  });

  app.get('/app/runbatches', (req, res) => {
    res.send('Processing..')
    exec(' start saludo.bat', (err, stdout) =>{
        if(err){
            throw err;
        }
        console.log(' ------> PROCESS SUCCESS <-------');
        console.log(stdout);
    });
    
  });





