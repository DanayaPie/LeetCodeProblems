const x = 121;

console.log(isPalindrome(x))

/*
    Modulus - O(n)
*/
function isPalindrome(x) {

    var reverse = 0;

    if (x < 0 || (x % 10 == 0 && x != 0)) {
        return false;
    } else {
        while (x > reverse) {
            reverse = x % 10 + reverse * 10;
            x = Math.floor(x / 10);
        }

    }
    if (x == reverse || x == Math.floor(reverse / 10)) {
        return true;
    }
    return false;
}

/*
    For loop - O(2n)
*/
// function isPalindrome(x) {

//     var input = x.toString();
//     var reverse = '';

//     for (var i = input.length - 1; i >= 0; i--) {
//         reverse += input[i];
//     }
//     if (reverse == input) {
//         return true;
//     }

//     return false;
// }