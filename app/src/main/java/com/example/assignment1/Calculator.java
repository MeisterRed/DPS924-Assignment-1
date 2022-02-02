package com.example.assignment1;

import java.util.ArrayList;

public class Calculator {

    private ArrayList<String> calcList = new ArrayList<>();
    private ArrayList<String> opList = new ArrayList<String>() {
        {
            add("+");
            add("-");
            add("*");
            add("/");
            add("%");
            add("Pow");
            add("Max");
            add("Min");
        }
    };

    public void push(String value) {
        calcList.add(value);
    }

    public void clear() {
        calcList.clear();
    }

    public int prepareResults(int first, int second, int operand) {
        int res = 0;

        switch (operand) {
            case 0:
                res = first + second;
                break;
            case 1:
                res = first - second;
                break;
            case 2:
                res = first * second;
                break;
            case 3:
                res = first / second;
                break;
            case 4:
                res = first % second;
                break;
            case 5:
                res = (int) Math.pow(first, second);
                break;
            case 6:
                res = Math.max(first, second);
                break;
            case 7:
                res = Math.min(first, second);
                break;
        }
        return res;
    }

    public int calculate() {
     int res = 0;
     int firstDigit = Integer.parseInt(calcList.get(0));
     int op;
     int secondDigit;

     for (int i = 1; i < calcList.size(); i++) {
         op = opList.indexOf(calcList.get(i));
         i++;
         secondDigit = Integer.parseInt(calcList.get(i));

        if (i == 2) {
            res = prepareResults(firstDigit, secondDigit, op);
        }
        else {
            res = prepareResults(res, secondDigit, op);
        }
     }
     return res;
    }
}
