package me.javigs82.training.datastructure.stacks;

import java.util.Stack;

public class BalancedParentheses {

    static boolean isBalancedPar(char exp[]) {
        //declare a stack
        Stack<Character> stack = new Stack<Character>();

        //loop over char expression structure
        for (int i = 0; i < exp.length; i++) {
            //if starting, push onto stack
            if (isStartingBracket(exp[i])) {
                stack.push(exp[i]);
                //if closing, pop and compare. If they are not balanced return false
            } else if (isClosingBracket(exp[i])) {
                if (isMatchingPair(stack.peek(), exp[i]))
                    stack.pop();
                else
                    return false;
            } else {
                throw new IllegalArgumentException("exp[] contains invalid chars");
            }
        }

        if (stack.isEmpty())
            return true;
        else
            return false;
    }

    static boolean isStartingBracket(char bracket) {
        if (bracket == '(' || bracket == '{' || bracket == '[')
            return true;
        else
            return false;
    }

    static boolean isClosingBracket(char bracket) {
        if (bracket == ')' || bracket == '}' || bracket == ']')
            return true;
        else
            return false;
    }

    //evaluate if pair matching
    static boolean isMatchingPair(char exp1, char exp2) {
        if (exp1 == '(' && exp2 == ')')
            return true;
        else if (exp1 == '{' && exp2 == '}')
            return true;
        else if (exp1 == '[' && exp2 == ']')
            return true;
        else
            return false;
    }

    public static void main(String[] args) {

        char[] exp = {'{', '(', ')', '}', '[', ']'};

        if (isBalancedPar(exp))
            System.out.println("Balanced");
        else
            System.out.println("Not Balanced");

    }
}
