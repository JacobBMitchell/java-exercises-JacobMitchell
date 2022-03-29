const button = document.querySelector("#button");
const input = document.querySelector("#name");

console.log(input);
const submitName = () => {
    console.log(input.value);
}


button.addEventListener("click", submitName);
input.addEventListener("keydown", event => {
    if(event.keyCode === 13){
        submitName();
    }
});



// let doSomething = (eventObj) => {
//     console.log(eventObj);
//     console.log(eventObj.clientX);
//     console.log(eventObj.clientY); //uses data from the event

// }

// button.addEventListener("click", doSomething); //note no parentesis for the fxn

