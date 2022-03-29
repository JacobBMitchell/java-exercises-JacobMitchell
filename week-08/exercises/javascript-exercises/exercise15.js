const rightAlign = (arr1) => {
    max = 0;

    for (const ind in arr1){
        max = Math.max(max, arr1[ind].length);
    }

    for (const ind in arr1){
        spaces = max-arr1[ind].length;
        let toPrint = " ".repeat(spaces) + arr1[ind];
        console.log(toPrint);
    }
}

arr = ["one", "two hundred", "fifty"];

rightAlign(arr);