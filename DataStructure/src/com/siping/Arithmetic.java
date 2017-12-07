package com.siping;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 四则运算表达式
 * @author siping-yx
 */
public class Arithmetic {

    /**
     * 比较两个表达式的优先级
     * @param operator1
     * @param operator2
     * @return 右括号或者优先级低于栈顶元素返回true
     */
    public static boolean comparePrior(String operator1, String operator2) {
        // 右括号或者优先级低于栈顶元素
        return ")".equals(operator1) || (("+".equals(operator1) || "-".equals(operator1)) && ("*".equals(operator2)) || "/".equals(operator2));
    }

    /**
     * 中缀表达式转后缀表达式
     * @return
     */
    public static String[] nifixToPostfixExpression(String[] expressionStrs) {
        Stack<String> stack = new Stack<String>();
        List<String> resStrs = new ArrayList<String>(expressionStrs.length);
        for (String str : expressionStrs) {
            if ("(".equals(str)) { // 如果是左括号,则入栈
                stack.push(str);
            } else if ("+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str)) {
                if (!stack.empty()) { // 取出先入栈的运算符
                    String s = stack.pop();
                    if (!comparePrior(str, s)) { // 如果栈值优先级小于要入栈的值,则继续压入栈
                        stack.push(s);
                    } else { // 否则取出值
                        resStrs.add(s);
                    }
                }
                stack.push(str);
            } else if (")".equals(str)) { // 如果是")",则出栈,一直到遇到"("
                while (!stack.empty()) {
                    String s = stack.pop();
                    if (!"(".equals(s)) {
                        resStrs.add(s);
                    } else {
                        break;
                    }
                }
            } else {
                resStrs.add(str);
            }
        }
        while (!stack.empty()) {  
            String s = stack.pop();  
            resStrs.add(s);  
        }  
        return (String[]) resStrs.toArray();
    }

    public static boolean isNumberic(String str) {
        return str.matches("[0-9]+");
    }

    public static void main(String[] args) {
        String str = "9;+;(;3;-;1;);*;3;+;10;/;2";
        String[] expressionStrs = str.split(";");
        String[] nifixToPostfixExpression = nifixToPostfixExpression(expressionStrs);
        System.out.println(nifixToPostfixExpression.toString());
    }
}
