import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        Array array = new Array();

        System.out.print("Введите выражение: ");
        Scanner scn = new Scanner(System.in);
        String ex = scn.nextLine();
        array.setArrayCheck(ex);
        if (array.checkArray()==false){
            System.out.println("Введены неверные данные, числа должны быть от 1 до 10 включительно");
            throw new IOException();
        }
        try{
            System.out.println(calc(ex));
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("throws Exception //т.к. строка не является математической операцией");
        } catch (IOException e){
            System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } catch (NullPointerException e){
            System.out.println("throws Exception //т.к. используются одновременно разные системы счисления");
        } catch (Exception e){
            System.out.println("throws Exception //т.к. в римской системе нет отрицательных чисел");
        }
    }
    public static String calc(String input) throws Exception {
       Converter converter = new Converter();
       Array array = new Array();
       array.setArray(input);
       String[] data = array.getData();
       if (data.length>2) throw new IOException();
       int a, b;
       boolean isRoman = converter.isRoman(data[0]);
       if (isRoman) {
           a = converter.romanToInt(data[0]);
           b = converter.romanToInt(data[1]);
       } else {
           a = Integer.parseInt(data[0]);
           b = Integer.parseInt(data[1]);
       }
       int result;
            switch (array.getOperand()) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                default:
                    result = a / b;
                    break;
            }
            if (isRoman) {
                if (result<0) throw new Exception();
                return (converter.intToRoman(result));

            } else {
                return (Integer.toString(result));
            }
    }
}
