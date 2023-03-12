const nums = [5, 6, 1, 4];
const target = 5;

console.log(twoSum(nums, target));


/*
    HashMap - O(n)
*/
// function twoSum(nums, target) {

//     let res;
//     const map = new Map();

//     for (let i = 0; i < nums.length; i++) {

//         if (map.has(target - nums[i])) {
//             return res = [i, map.get(target - nums[i])];
//         } else {
//             map.set(nums[i], i);
//         }
//     }
// }

/*
    Nested for loops - O(n^2)
*/
function twoSum(nums, target) {

    let res;

    for (let i = 0; i < nums.length; i++) {
        for (let j = i + 1; j < nums.length; j++) {
            if (target - nums[j] == nums[i]) {
                return res = [i, j];
            }
        }
    }
    return null;
}