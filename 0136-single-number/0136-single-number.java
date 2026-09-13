// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//         Arrays.sort(nums);

//         for(int i = 0; i < nums.length - 1; i++) {
//             if(nums[i] != nums[i + 1]) {
//                 return nums[i];
//             }
//         }


//     }
// }


class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }

        return result;
    }
}