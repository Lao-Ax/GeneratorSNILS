package com.action_digital;

public class Main {
    static String digits;
    public static void main(String[] args) {
	    Generator SNILS_Generator = Generator.getInstance();

        byte SNILS_COUNT = 1;
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++){
                String str = args[i];
                switch  (str){
                    case "-c":
                        try {
                            SNILS_COUNT = (byte) Integer.parseInt(args[i + 1]);
                            if (SNILS_COUNT <= 0) {
                                SNILS_COUNT = 1;
                                System.out.println("You've entered invalid SNILS count. Please, type no more 128.");;
                            }
                        } catch (Exception e){
                            System.out.println("You've entered invalid SNILS count.");;
                        }
                        i++;
                        break;
                    default:
                        System.out.println("You've entered one or more unknown parameters.");
                }
            }
        }

        for (byte k = 0; k < SNILS_COUNT; k++) {
            digits = "";
            for (byte i = 0; i < 9; i++)
                digits += Math.round((int) (Math.random() * 10));

            SNILS_Generator.make_SNILS(digits);
            System.out.println(Generator.SNILS);
        }
    }
}
