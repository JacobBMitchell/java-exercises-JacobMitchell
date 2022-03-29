const assert = require("assert");

// ARE IN ORDER
// Create a function named `areInOrder` that accepts 4 numeric parameters
// and returns boolean `true` if the numbers are in order ascending.
// Ties are considered ordered.
// If the numbers aren't in order, return boolean `false`.
// Use a function expression instead of a function declaration.

// Execute this exercise.
// If you see the message "success!", all tests pass.

function areInOrder(){
    let args = Array.prototype.slice.call(arguments);
    for (i = 1; i< args.length; i++){
        if (args[i-1]> args[i]){
            return false;
        }
    }
    return true;
}

assert.strictEqual(areInOrder(2, 4, 6, 7), true);
assert.strictEqual(areInOrder(4, 1, 1, 8), false);
assert.strictEqual(areInOrder(1, 1, 2, 2), true);
assert.strictEqual(areInOrder(-5, 0, 5, 10), true);
assert.strictEqual(areInOrder(-5, 0, -5, 0), false);

console.log("success!");