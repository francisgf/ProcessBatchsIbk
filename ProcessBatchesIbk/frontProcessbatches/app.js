const express = require('express');
const path = require('path')
const open = require('open')
const cors = require('cors');

const app= express()
const port=4000;

app.listen(port,()=>{
  console.log(`El servidor esta escuchando en http://${port}/`); 
});

app.get("/app",(req, res) => {
  res.statusCode=200;
  console.log("Run index.js")
  app.use(express.static(__dirname));
  res.sendFile(path.resolve(__dirname+'/index.html'))
});

startPath();
  function startPath(){
    open('http://127.0.0.1:4000/app') 
  }

