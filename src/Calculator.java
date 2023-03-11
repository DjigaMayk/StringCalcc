


public class Calculator {



    public static String Zapirmus(String exp) throws Exception {
        char action;
        String[] data;


        if (exp.contains(" + ")) {
            data = exp.split(" \\+ ");
            action = '+';
        } else if (exp.contains(" - ")) {
            data = exp.split(" - ");
            action = '-';
        } else if (exp.contains(" * ")) {
            data = exp.split(" \\* ");
            action = '*';
        } else if (exp.contains(" / ")) {
            data = exp.split(" / ");
            action = '/';
        } else {
            throw new Exception("Некорректный знак действия");
        }
        if(data[0].length()>10 || data[1].length()>10 ){
            throw new Exception("Символов должно быть не больше 10");
        }

        if (action == '*' || action == '/') {
            if (data[1].contains("\"")) throw new Exception("Строчку можно делить или умножать только на число");
              if (parsable(data[1]) && Integer.parseInt(data[1]) >10 || Integer.parseInt(data[1]) <0){
                throw new Exception("Цифры могут быть от 0 до 10");
            }
        }

        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace("\"", "");
        }
        if(parsable(data[0])){
            throw new Exception("Неверные данные");

        }


        if (action == '+') {
            printInQuotes(data[0] + data[1]);
        } else if (action == '*') {
            int umnozhenie = Integer.parseInt(data[1]);
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < umnozhenie; i++) {
                result.append(data[0]);
            }  if(result.length() >40){

                System.out.println(result.substring(0, 40)+"...");
            } else{
            printInQuotes(String.valueOf(result));}
        } else if (action == '-') {
            int index = data[0].indexOf(data[1]);
            if (index == -1) {
                printInQuotes(data[0]);
            } else {
                String result = data[0].substring(0, index);
                result += data[0].substring(index + data[1].length());
                printInQuotes(result);
            }
        } else {
            int delenie = data[0].length() / Integer.parseInt(data[1]);
            String result = data[0].substring(0, delenie);
            printInQuotes(result);
        }

        return exp;
    }
    static void printInQuotes(String text){
        System.out.println("\""+text+"\"");
}
     static boolean parsable(String str){
         return str.matches("\\d+");
     }
     }
