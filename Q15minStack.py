# You are given an array of strings tokens that represents a valid arithmetic expression in Reverse Polish Notation.
# Return the integer that represents the evaluation of the expression.
# The operands may be integers or the results of other operations.
# The operators include '+', '-', '*', and '/'.
# Assume that division between integers always truncates toward zero.

# Example 1:
# Input: tokens = ["1","2","+","3","*","4","-"]
# Output: 5
# Explanation: ((1 + 2) * 3) - 4 = 5


from typing import List

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []  # Initialize an empty stack to store operands
        for i in tokens:
            if i in {"+", "-", "*", "/"}:  # Check if the current token is an operator
                a = stack.pop()  # Pop the top two elements from the stack
                b = stack.pop()
                if i == "+":  # Perform addition
                    stack.append(b + a)
                elif i == "-":  # Perform subtraction
                    stack.append(b - a)
                elif i == "*":  # Perform multiplication
                    stack.append(b * a)
                elif i == "/":  # Perform division
                    # To ensure truncation towards zero
                    stack.append(int(b / a))  # Use int() to truncate towards zero
            else:
                stack.append(int(i))  # If the token is an operand, convert to int and push to stack
        return stack.pop()  # The result of the expression will be the last element in the stack


