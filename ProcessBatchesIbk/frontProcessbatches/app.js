const express = require('express');
const open = require('open')
const cors = require('cors');
const { serialize } = require('v8');

const app= express()
const port=4000;

app.listen(port,()=>{
  console.log(`El servidor esta escuchando en http://${port}/`); 
});
app.get("/app",(req, res) => {
  res.statusCode=200;
  console.log("Run app")
  res.send("hola mundo")
  //res.render("index.html",{title:"hola"})
});
startPath();
  function startPath(){
    open('http://127.0.0.1:4000/app') 
  }


