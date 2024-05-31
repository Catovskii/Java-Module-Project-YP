package calc;

class Rub {
    static String returnRubLine(double payment){
        String rub;
        if (payment > 10 && payment <20)  { rub = "рублей"; } // Добавлен вариант с десятками
            else {
            rub = switch ((int)(Math.floor(payment))%10)    // Сумма может быть и 123.04 Нас интересует только цифра 3.
            {   
                case 1 -> "рубль";
                case 2, 3, 4 -> "рубля";
                default -> "рублей";
            };
            }
        return rub;
    }
}