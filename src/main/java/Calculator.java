import java.util.ArrayList;

public class Calculator {
    ArrayList<Product> products = new ArrayList<>();
    double sum;

    boolean add(String name, double price){
        Product product = new Product(name, price);
        boolean res = products.add(product);
        if( res ){
            System.out.println("Товар '" + name+"'"+
                    " стоимостью "+
                    String.format("%.2f ", price) +
                    (new Formatter( price ) ).getName()+
                    " добавлен в список.\n");
            sum += price;
        }
        return res;
    }

    void printProductList(){
        System.out.println("Добавленные товары:");
        for(Product product : products){
            System.out.println("'" + product.name+"' стоимостью " +
                    String.format("%.2f ", product.price) +
                    (new Formatter( product.price ) ).getName() );
        }
    }

    void splitCheck(int countPerson){
        double amountPerPerson = sum/countPerson;
        System.out.println("\nОбщая сумма: " +
                String.format("%.2f ",sum) +
                (new Formatter( sum ) ).getName());
        System.out.println("Количество человек: " + countPerson);
        System.out.println("С каждого: " +
                String.format("%.2f ", amountPerPerson) +
                (new Formatter( amountPerPerson ) ).getName());
    }

}
