import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static Calculator calculator = new Calculator();
    public static void main(String[] args) {
        System.out.println("Калькулятор счета приветствует вас. ");

        int countPerson = getCountPerson();
        getProducts();
        calculator.printProductList();
        calculator.splitCheck(countPerson);

    }

    public static int getCountPerson(){
        int countPerson;

        while(true) {
            System.out.println("Введите количество человек. Используйте числа больше 1.");
            String str = scanner.nextLine();
            countPerson = str.matches("\\d+") ? Integer.parseInt(str) : 0;
            if (countPerson > 1) {
                break;
            } else {
                System.out.println("Вы ввели некорректное значение: " +
                        str +
                        ". Введите число больше 1. Попробуйте еще раз.\n");
            }
        }

        return countPerson;
    }

    public static void getProducts(){
        while(true) {
            System.out.println("Введите название товара или команду 'Завершить':");
            String strName = scanner.nextLine();
            if ( strName.equalsIgnoreCase("завершить")){
                break;
            }
            else{
                System.out.println("Введите стоимость товара в формате рр.кк:");
                String strPrice = scanner.nextLine();
                double price = strPrice.matches("\\d{1,}+(\\.\\d{2}+)") ? Double.parseDouble(strPrice) : -1;
                if( price >= 0 ){
                    calculator.add(strName, price);
                }
                else{
                    System.out.println("Вы ввели некорректную стоимость товара: " +
                            strPrice +
                            ". Товар не добавлен в список. Попробуйте еще раз.\n");
                }
            }
        }
    }

}