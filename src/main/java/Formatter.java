public class Formatter {
    int price; // целая часть стоимости

    Formatter( double _price ){
        price = (int)_price;
    }

    public String getName(){

        //Чтобы отсеять числа, оканчивающиеся на 11 - 19 (11, 111,1011 и т.д.)
        int priceDevided = price % 100;
        if( (priceDevided > 10) && ( priceDevided < 20) )
            return "рублей";

        switch (price % 10){
            case 1:
                return "рубль";
            case 2:
            case 3:
            case 4:
                return "рубля";
        }

        return "рублей";
    }
}
