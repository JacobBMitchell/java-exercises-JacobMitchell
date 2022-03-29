const assert = require("assert");
// REMOVE EVERY OTHER
// Create a function named `removeEveryOther` that accepts an array.
// Create a new array by skipping every other element in the parameter array
// starting at the second (index 1).
// Return the new array.
// Hint: `filter` is useful here.


// Execute this exercise.
// If you see the message "success!", all tests pass.
function removeEveryOther(someArray){
    let thisArray = [];
    for (i = 0; i< someArray.length; i+=2){
        thisArray.push(someArray[i])
    }
    return thisArray;
}

assert.deepStrictEqual(removeEveryOther([1, 2, 3, 4, 5]), [1, 3, 5]);
assert.deepStrictEqual(removeEveryOther(["a", "b", "c"]), ["a", "c"]);
assert.deepStrictEqual(removeEveryOther([]), []);
assert.deepStrictEqual(removeEveryOther([22]), [22]);
assert.deepStrictEqual(removeEveryOther([22, 0, 23, 0, 24, 0, 25]), [22, 23, 24, 25]);
assert.deepStrictEqual(removeEveryOther([0, 22, 0, 23, 0, 24, 0, 25]), [0, 0, 0, 0]);

console.log("success!");