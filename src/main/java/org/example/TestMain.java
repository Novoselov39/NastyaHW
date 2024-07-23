package org.example;



public class TestMain {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String text = scanner.nextLine();
//        System.out.println(textModifier(text));

        String text = "t e   xt-yu+iun 123456-78";
        System.out.println(text);
        System.out.println(textModifier(text));
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

        for (int i = 0; i < textSB.length(); i++) { //
            if (textSB.charAt(i) == '+') {
                textSB.insert(i,'!');
                textSB.deleteCharAt(i+1);

            }

        }
        System.out.println(textSB);

        return "";
    }
}

