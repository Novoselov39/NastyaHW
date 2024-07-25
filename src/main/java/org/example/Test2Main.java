package org.example;

import java.util.Scanner;
import java.util.StringTokenizer;

    public class Test2Main {
        public static void main(String[] args) {
            System.out.println(textModifier());
        }
        public static String textModifier() {
            System.out.println("Введите текст: ");
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            str = removingSpaces(str);
            str=chekWord(str); // !!!!!!!!!ищем слова и убираем лишние пробелы
            str = swappingCharacters(str, '-');
            str = str.replace("+", "!");
            int sumDigits = calculateSum(str);


            str = str.replaceAll("\\d", ""); //!!!!!!!!!!поправил регулярное выражение



//            str = str.replaceAll(String.valueOf(0), ""); //!!!! зачем это строка? мы строкой выше уже удалили все числа
            str=str.trim();                                     //!!!!!!!!!Удаляем последний пробел, который прилетело к нам из removingSpaces()
            if (sumDigits != 0)
                str += " " + sumDigits;
            return str;
        }
        public static String removingSpaces(String text) {  //метод для удаления пробелов
            StringTokenizer st = new StringTokenizer(text, " ");
            StringBuffer sb = new StringBuffer();
            while (st.hasMoreElements()) {
                sb.append(st.nextElement()).append(" ");
            }
            return sb.toString();
        }
        public static String swappingCharacters(String text, char ch) { //замена символов местами при услловии что есть знак -
            String index = "-";
            int nextIndex = 0;
            char[] c = text.toCharArray();
            int num = text.indexOf(index);
            while ((num = text.indexOf(index, nextIndex)) >= 0) {
                nextIndex = num + 1;
                char buf = c[num + 1];
                c[num + 1] = c[num - 1];
                c[num - 1] = buf;
            }
            String s = new String(c);
            return s.replace("-","");
        }

        public static int calculateSum(String text) {         //!!!!!!!!переписал
            int sum = 0;

            for (int i = 0; i < text.length(); i++) {
                char chrs = text.charAt(i);
                if (Character.isDigit(chrs)) {
                    sum += Integer.parseInt(String.valueOf(chrs));

                }


            }
            return sum;
        }

        public static String chekWord(String str){
            StringBuilder strSB = new StringBuilder(str.trim());
            for (int i = 2; i < strSB.length()-2; i++) { // проверяем на целостность слов

                if((strSB.charAt(i-2)== ' ' || strSB.charAt(i-2)== '+')  & (strSB.charAt(i+2)== ' ' || strSB.charAt(i+2)== '+')& strSB.charAt(i) == ' '){

                    strSB.deleteCharAt(i);
                    i--;
                }
            }
            return strSB.toString();

        }
    }

