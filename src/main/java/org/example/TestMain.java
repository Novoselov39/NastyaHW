package org.example;


import java.util.Scanner;

public class TestMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        System.out.println(textModifier(text));

//        String text = "t e   xt-yu+i1un";
//        System.outmaqqrintln(text);
//        System.out.println(textModifier(text));
    }

    public static String textModifier(String text){
        StringBuilder textSB = new StringBuilder(text);
        // удаляем пробелы

        if (textSB.charAt(0) == ' ')  textSB.deleteCharAt(0);// проверяем первый символ

        for (int i = 1; i < textSB.length(); i++) { // проверяем остальные сиволы и если надо удаляем
            if(textSB.charAt(i) == ' ' & textSB.charAt(i-1)== ' '){
                textSB.deleteCharAt(i);
                i--;
            };
        }
        //System.out.println(textSB);

//        меняем местами "-"
        for (int i = 1; i < textSB.length(); i++) { //
            if (textSB.charAt(i) == '-') {
                textSB.insert(i+1, textSB.charAt(i-1));
                textSB.deleteCharAt(i-1);
                textSB.insert(i-1, textSB.charAt(i+1));
                textSB.deleteCharAt(i+2);
                textSB.deleteCharAt(i);
                i--;
            }

        }
        // замена на восклицательный знак
        for (int i = 0; i < textSB.length(); i++) { //
            if (textSB.charAt(i) == '+') {
                textSB.insert(i,'!');
                textSB.deleteCharAt(i+1);

            }

        }

//        считаем
        int sum=0;

        for (int i = 0; i < textSB.length(); i++) { //
            if (Character.isDigit(textSB.charAt(i))) {
                sum=sum+Integer.parseInt(String.valueOf(textSB.charAt(i)));
                textSB.deleteCharAt(i);
                i--;

            }

        }
        if (sum!=0){
            textSB.append(" "+sum);
        }

//        System.out.println(sum);

//        System.out.println(textSB);

        return textSB.toString();
    }
}

