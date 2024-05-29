# You are given an integer n. Return all well-formed parentheses strings that you can generate with n pairs of parentheses.

# Example 1:
# Input: n = 1
# Output: ["()"]

# Example 2:
# Input: n = 3
# Output: ["((()))","(()())","(())()","()(())","()()()"]
# 1 <= n <= 7

# VERY GOOD QUESTION
# LOGIC:
# 1. only add '(' if open < n
# 2. only add ')' if close < open
# 3. valid iff open == close == n
from typing import List

class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        if n < 1 or n > 7:
            return []
        else:
            stack = []  # Stack to hold the current combination of parentheses
            result = []  # List to store all valid combinations
            
            def backtrack(open: int, close: int):
                # If we have used up all pairs, add the current combination to the result
                if open == close == n:
                    result.append(''.join(stack))
                    return
                # If we can still add an open parenthesis, do so and recurse
                if open < n:
                    stack.append('(')
                    backtrack(open + 1, close)
                    stack.pop()  # Remove the last added parenthesis to backtrack, to explore other possibilites
                # If we can add a close parenthesis without violating the rules, do so and recurse
                if close < open:
                    stack.append(')')
                    backtrack(open, close + 1)
                    stack.pop()  # Remove the last added parenthesis to backtrack, to explore other possibilites
            
            backtrack(0, 0)  # Start the backtracking with 0 open and 0 close parentheses
            return result

