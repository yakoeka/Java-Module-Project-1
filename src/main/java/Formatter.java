public class Formatter {
    String getDeclension(double price) {
        int resultSumIntDiv10 = ((int) price) % 10;
        String rub = "";
        switch (resultSumIntDiv10) {
            case 1:
                rub = "рубль";
                break;
            case 2:
            case 3:
            case 4:
                rub = "рубля";
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 0:
                rub = "рублей";
                break;
        }
        return rub;
    }
}
