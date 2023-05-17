/*
371. Sum of Two Integers

Given two integers a and b, return the sum of the two integers without using the operators + and -.

Example 1:
Input: a = 1, b = 2
Output: 3
Example 2:

Input: a = 2, b = 3
Output: 5

Constraints:
-1000 <= a, b <= 1000

Approach:
    Binary
    use XOR operation(^) to get 1(XOR will be one only if any of the input is 1)
    then use AND operator(&) and left shift by 1 and add it the result if we have any carry

Timecomplexity: O(n)
*/
class Solution {
    public int getSum(int a, int b) {
        while(b!=0){
            int tmp=(a&b)<<1;
            a^=b;
            b=tmp;
        }
        return a;
    }
}