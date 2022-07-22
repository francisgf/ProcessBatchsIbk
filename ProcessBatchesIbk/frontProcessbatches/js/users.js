

window.onload = function() {
 console.log("inicio");
 getUsers();

  };


function validateUser(){
   let txtUser= document.getElementById('txtuser').value;
   let typeUsert= document.getElementById('typeuser').value;

   if(txtUser.length == 0 || typeUsert==1 ){
   alert("ingrese los datos ")
   }else{
    saveUser();
   }
}
function saveUser(){

}

 
function getUsers(){  

    let url ="http://localhost:3000/app/readfilejson";
  fetch(url)
    .then((response) => response.json())
    .then((data) => mostrarUsers(data))
    .catch((error) => console.log(error));
  
  const mostrarUsers = (data) => {
    console.log(data);
    let html = "";
    for (let i = 0; i < data.length; i++) {
      html += `
      <tr>
        <td>${data[i].type}</td> 
        <td>${data[i].name}</td>
        <td>Editar</td>
      </tr>
      `;
    }  
    let container = document.querySelector("#data");
    container.innerHTML = html;
  };
  
   }