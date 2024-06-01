package calc;

class Rub {

    static String returnRubLine(double payment){
        String rub;

        if ((int)(Math.floor(payment)) % 100 > 10 && (int)(Math.floor(payment)) % 100 < 15)
            { rub = "рублей"; }
            else {
            rub = switch ((int)(Math.floor(payment))%10)    
            {   
                case 1 -> "рубль";
                case 2, 3, 4 -> "рубля";
                default -> "рублей";
            };
            }
        return rub;
    }
}