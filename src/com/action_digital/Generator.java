package com.action_digital;

/**
 * Created by Alex on 20.01.2015 020.
 */
public class Generator {

    static String SNILS;

    private static Generator instance;
    private Generator (){
    }

    public static Generator getInstance()
    {
        if (instance == null) instance = new Generator();
        return instance;
    }

    private int calculate_the_check_digit(String anyNumber){
        char[] anyNumberC = anyNumber.toCharArray();

        int the_check_digit = 0;
        for (byte i = 0; i < 9; i++){
            the_check_digit += Character.digit(anyNumberC[i], 10) * (9-i);
            //System.out.println(anyNumberC[i] + " * " + (9-i));
        }

        the_check_digit %= 101;
        if ((the_check_digit == 0) || (the_check_digit == 100)){
            the_check_digit = 0;
        }
        return the_check_digit;
    }

    public void make_SNILS(String anyNumber){
        SNILS = "";
        String the_check_digit = Integer.toString(calculate_the_check_digit(anyNumber));
        if (the_check_digit.length() == 1) the_check_digit ='0'+ the_check_digit;
        SNILS = anyNumber + '-' + the_check_digit;
    }
}
