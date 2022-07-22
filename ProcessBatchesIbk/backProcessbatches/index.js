
const express = require('express');
const cors = require('cors');
const exec = require('child_process').exec
const lector = require('fs');

const app = express();
const port = 3000;
app.use(cors());
const url = '/app/runbatches'
const urlFileTxt = '/app/readfiletxt'
const urlFileJson = '/app/readfilejson'
const urlWriteJson = '/app/writefilejson'

app.listen('3000', function () {
    console.log('Servidor escuchando en el puerto 3000');
});

//-------- INI: END POINTS ------------
app.get(url, cors(), (req, res) => {
    res.send('Processing..');
});

app.get(urlFileTxt, cors(), (req, res) => {
    readLog()
});

app.get(urlFileJson, cors(), (req, res) => {
   let json= readUser();
    res.json(json);
});

app.get(urlWriteJson, cors(), (req, res) => {
writeUser();
 });

//-------- END: END POINTS ------------

function runBatch() {

    exec('start main.bat', (err, stdout) => {
        if (err) {
            throw err;
        } else {
            console.log("Iniciando ejecución")
        }
        console.log(stdout);
    });
}

function readLog() {
    lector.readFile('Log_Main_10072022_2255.txt', 'utf-8', (err, data) => {
        if (err) {
            console.log('error: ', err);
            return;
        }
        console.log(data);
        return data;
    });

}


function readUser() {
   let data= lector.readFileSync('./userConfig/users.json');     
        let users = JSON.parse(data).users;
        console.log("data---->");
        console.log(users);  
        return users;
}

/*
function readUser2(){
lector.readFile('./userConfig/users.json', (err, data) => {
    if (err) throw err;
        let users = JSON.parse(data).users;
        console.log(users);       
        return users;
    
});
}*/

function writeUser() {

let usersWrite = { 
    name: 'Mike',
    age: 30, 
    gender: 'Male',
    department: 'car',
    car: 'Honda' 
};
 
let data = JSON.stringify(usersWrite);
lector.writeFileSync('usersWrite.json', data);
}

