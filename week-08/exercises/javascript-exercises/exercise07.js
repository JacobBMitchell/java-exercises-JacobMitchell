const assert = require("assert");

// FIRST VOWEL
// Complete the function `getFirstVowel`.
// It should return the first vowel in a string.
// If the string doesn't contain vowels, `value` is null, 
// or `value` is undefined, return an empty string.

function getFirstVowel(word) {  
  if (word == null){
      return "";
  }
  for (let i = 0; i < word.length; i++){
      let letter = word.charAt(i);
      switch(letter.toLowerCase()){
            case "a":
            case "e":
            case "i":
            case "o":
            case "u":
                return word.charAt(i);

      }

  }
  return "";

}

// Node's assert library will test your function.
// Execute this exercise.
// If you see the message "success!", all tests pass.

assert.strictEqual(getFirstVowel("magnificent"), "a");
assert.strictEqual(getFirstVowel("winsome"), "i");
assert.strictEqual(getFirstVowel("xxx"), "");
assert.strictEqual(getFirstVowel(), "");
assert.strictEqual(getFirstVowel("mAgnificent"), "A");

console.log("success!");