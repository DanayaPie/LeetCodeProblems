const s = "III";

console.log(romanToInt(s));

function romanToInt(s) {

    res = 0;

    /*
        Map from Object - slower
    */
    // const map = {
    //     "I": 1,
    //     "V": 5,
    //     "X": 10,
    //     "L": 50,
    //     "C": 100,
    //     "D": 500,
    //     "M": 1000
    // }
    // for (let i = 0; i < s.length; i++) {
    //     let valL = map[s[i]];
    //     let valR = map[s[i + 1]];

    //     if (i + 1 < s.length) {
    //         if (valL >= valR) {
    //             console.log("valL: " + valL);
    //             console.log("valR: " + valR);

    //             res += valL;
    //         } else {
    //             res += valR - valL;
    //             i++;
    //         }
    //     } else {
    //         res += valL;
    //     }


    // };

    // return res;

    /*-
        new Map() from Array - faster
    */
    const map = new Map([
        ["I", 1],
        ["V", 5],
        ["X", 10],
        ["L", 50],
        ["C", 100],
        ["D", 500],
        ["M", 1000]
    ]);

    for (let i = 0; i < s.length; i++) {
        let valL = map.get(s.charAt(i));

        if (i + 1 < s.length) {
            let valR = map.get(s.charAt(i + 1));

            if (valL >= valR) {
                res += valL;
            } else {
                res += valR - valL;
                i++;
            }
        } else {
            res += valL;
        }
    };

    return res;
}