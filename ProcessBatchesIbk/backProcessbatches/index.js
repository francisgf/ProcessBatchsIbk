
const express = require('express');
const cors = require('cors');
const exec = require('child_process').exec
const lector = require('fs');
const { StringDecoder } = require('string_decoder');
const { stringWriter } = require('xmlbuilder');
var txt = '';

const app = express();
const port = 3000;
app.use(cors());
const url = '/app/runbatches'
const urlFileTxt = '/app/readfilelog'
const urlFileJson = '/app/readfilejson'
const urlWriteJson = '/app/writefilejson'

app.listen('3000', function () {
    console.log('Servidor escuchando en el puerto 3000');
});

//-------- INI: END POINTS ------------
app.get(url, cors(), (req, res) => {
    res.send('Processing..');
    if (runBatch()) {
        res.sendStatus(200)
    } else {
        res.sendStatus(500)
    }
});

app.get(urlFileTxt, cors(), (req, res) => {

    // let string =readLog();
    res.setHeader('Content-Type', 'text/text')
    //res.writeHead(200)
    res.readFileSync(readLog())

});

app.get(urlFileJson, cors(), (req, res) => {
    let json = readUser();
    res.json(json);
});

app.get(urlWriteJson, cors(), (req, res) => {
    writeUser();
});

//-------- END: END POINTS ------------

function runBatch() {
    let isRun = true;
    exec('start main.bat', (err, stdout) => {
        if (err) {
            isRun = false;
            throw err;
        } else {
            isRun = true;
            console.log("Iniciando ejecución")
        }
        console.log(stdout);
    });
    return isRun;
}

function readLog() {
    lector.readFile('Log_Main_22072022_1851.txt', 'utf-8', (err, data) => {
        if (err) {
            console.log('error: ', err);
            return;
        }
        //console.log(data);
        txt = data
    });
    //   console.log(txt)
    return txt;
}


function readUser() {
    let data = lector.readFileSync('./userConfig/users.json');
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

