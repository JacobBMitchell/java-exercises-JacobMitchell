// INTERLEAVE
const first = "abc";
const second = "123";

// 1. Write a loop to interleave two strings to form a new string.
// To interleave, during each loop take one character from the first string and add it to the result
// and take one character from the second string and add it to the result.
// If there are no more characters available, don't add characters.
// 2. Print the result.
let mix = "";
let i = 0;
while (i < Math.min(first.length, second.length)){
    mix += first.charAt(i) + second.charAt(i);
    i++;
}
if (first.length> second.length){
    mix += first.substring(i);
}
else {
    mix += second.substring(i);
}
console.log(mix);

// Examples
// "abc", "123" -> "a1b2c3"
// "cat", "dog" -> "cdaotg"
// "wonder", "o" -> "woonder"
// "B", "igstar" -> "Bigstar"
// "", "huh?" -> "huh?"
// "wha?", "" -> "wha?"