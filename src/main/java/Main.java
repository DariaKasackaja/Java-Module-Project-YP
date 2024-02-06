import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Калькулятор счета приветствует вас. ");

        int countPerson = getCountPerson();
        ArrayList<Product> products = getProducts();

        System.out.println("Добавленные товары:");
        for(Product product : products){
            System.out.println("'" + product.name+"' стоимостью " +
                    String.format("%.2f ", product.price) +
                    (new Formatter( product.price ) ).getName() );
        }
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

    public static ArrayList<Product> getProducts(){
        ArrayList<Product> products = new ArrayList<>();

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
                    Product product = new Product(strName, price);
                    products.add(product);
                    System.out.println("Товар '" + strName+"'"+
                            " стоимостью "+
                            String.format("%.2f ", price) +
                            (new Formatter( price ) ).getName()+
                            " добавлен в список.\n");
                }
                else{
                    System.out.println("Вы ввели некорректную стоимость товара: " +
                            strPrice +
                            ". Товар не добавлен в список. Попробуйте еще раз.\n");
                }
            }
        }

        return products;
    }

}