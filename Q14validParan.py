
# You are given a string s consisting of the following characters: '(', ')', '{', '}', '[' and ']'.
# The input string s is valid if and only if:
# Every open bracket is closed by the same type of close bracket.
# Open brackets are closed in the correct order.
# Every close bracket has a corresponding open bracket of the same type.
# Return true if s is a valid string, and false otherwise.

# Example 1:
# Input: s = "[]"
# Output: true

# Example 2:
# Input: s = "([{}])"
# Output: true

# Example 3:
# Input: s = "[(])"
# Output: false

class Solution:
    def isValid(self, s: str) -> bool:
        pu = ['(', '{', '[']  # List of opening brackets
        po = [')', '}', ']']  # List of closing brackets
        stack = []  # Initialize an empty stack to keep track of opening brackets

        for i in s:
            if i in pu:  # Check if the character is an opening bracket
                stack.append(i)  # Push the opening bracket onto the stack
            else:
                if not stack:  # If stack is empty, it means there's no matching opening bracket
                    return False
                x = stack.pop()  # Pop the top element from the stack (last unmatched opening bracket)
                if po.index(i) != pu.index(x):  # Check if the popped bracket matches the current closing bracket
                    return False
        return len(stack) == 0  # If the stack is empty, all brackets are matched and closed properly


