//Approach:using multiple recursion calls
class Solution {
    public int fib(int n) {
        if(n==0)
        return 0;
        if(n==1)
        return 1;
        return fib(n-1)+fib(n-2);
        
    }
}
/**
 * Time Complexity (TC): O(2^n)
 * - The function makes two recursive calls for each value of n, resulting in an exponential growth in the number of function calls.
 * - This results in a total time complexity of O(2^n) because the same Fibonacci numbers are recalculated multiple times.

 * Space Complexity (SC): O(n)
 * - The space complexity is due to the call stack depth of the recursion.
 * - The maximum depth of the recursion stack is n, so the space complexity is O(n).
 */
