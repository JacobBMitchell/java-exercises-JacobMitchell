let value;
console.log(typeof value); // undefined
value = 25;
console.log(typeof value); // number
value = "Hodgepodge";
console.log(typeof value); //string

console.log(.1 +.2);

if (1.5 -1.4){
    console.log("2 is litterally true");
    console.log("0 is false");
}

let message = 'She doesn\'t like y\'all.';           
message = "He keeps doing those stupid \"air quotes\".";
message = "This message\nspans\nmultiple\nlines and contains\ttabs.";

let html = `<html lang="en">
<head>
<title>Document</title>
<body>
    <header>
        <h1 class="main-header">Document Header</h1>
    </header>
    <main id = "content">
    </main>
</body>
</html>`;


let name = "Nomi";
let petCount = 3;
let petType = "dogs";
let verticalJump = 37.68;

message = `${name} has ${petCount} ${petType} and can jump ${verticalJump} inches vertically.`;

console.log(message); // Nomi has 3 dogs and can jump 37.68 inches vertically.

let a = 2.33;
let b = -1.111;

console.log(`${a} + ${b} = ${a + b}`); // 2.33 + -1.111 = 1.219

function loop() {
    console.log(i);

    for (var i = 0; i<3;i++){
        console.log(i);
    }

    console.log(i);
}

loop();

function loop2() {

    // i is not visible here (err).

    for (let i = 0; i < 3; i++) {
        // i is only visible in this block.
        console.log(i);
    }

    // i is not visible here (err).
}

loop2();

// function declaration
function getMathFunction(operator) {
    switch (operator) {
        case "+":
            // function expression
            return function (a, b) {
                return a + b;
            };
        case "-":
            // function expression
            return function (a, b) {
                return a - b;
            };
        case "*":
            // function expression
            return function (a, b) {
                return a * b;
            };
        case "/":
            // function expression
            return function (a, b) {
                return a / b;
            };
        default:
            // function expression
            return function () { };

    }
}

const plus = getMathFunction("+");
const multiply = getMathFunction("*");
const unknown = getMathFunction("arrrgh");

console.log(plus(2, 5));         // 7
console.log(multiply(10.1, -5)); // -50.5
console.log(unknown(1, 1));      // undefined

function goWithArguments() {
    let args = Array.prototype.slice.call(arguments);
    console.log(arguments.length + ": " + args.join());
}

goWithArguments();                                     // 0: 
goWithArguments("maple");                              // 1: maple
goWithArguments("maple", -314);                        // 2: maple,-314
goWithArguments("maple", -314, false);                 // 3: maple,-314,false
goWithArguments("maple", -314, false, "killer squid"); // 4: maple,-314,false,killer squid
goWithArguments(1, 2, 3, 4, 5, 6, 7);                  // 7: 1,2,3,4,5,6,7

//objects
let planet = {};
// Dynamically add 3 properties. Properties can have any type, including `function`.
planet.name = "Jupiter";
planet.moons = ["Io", "Europa", "Ganymede"];
planet.getDescription = function () {
    return "Planet: " + this.name + ", Has " + this.moons.length + " moons.";
};

console.log(planet.getDescription());
//both of these objects are effectively the same
let planet = {
    name: "Jupiter",
    moons: ["Io", "Europa", "Ganymede"],
    getDescription: function () {
        return "Planet: " + this.name + ", Has " + this.moons.length + " moons.";
    }
};