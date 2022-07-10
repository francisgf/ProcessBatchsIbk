
const express = require('express');
const cors = require('cors');
const exec = require('child_process').exec
const app = express();
const port = 3000;
app.use(cors());

app.listen('3000', function() {
    console.log('Servidor web escuchando en el puerto 3000');
  });

  //main----------------------------------------
  app.get('/app/runbatches', cors(),(req, res) => {
    res.send('Processing..')
    exec('cd ../batchesProcessbatches', (err, stdout) =>{
        if(err){
            throw err;
        }
        
        console.log('posicionamiento correcto');
        exec('start mainExample.bat', (err, stdout) =>{
            if(err){
                throw err;
            }
            console.log(' ------> PROCESS SUCCESS <-------');
            console.log(stdout);
        });
        console.log(stdout);
    });
  });





