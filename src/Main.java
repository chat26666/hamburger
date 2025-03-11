
public class Main {
    public static void main(String[] args) {
        String[] name = new String[]{"ShackBurger","SmokeShack","Cheeseburger","Hamburger"};
        double[] price = new double[]{6900, 8900, 6900, 5400};
        String[] description = new String[]{"토마토, 양상추, 쉑소스가 토핑된 치즈버거","베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거",
                                            "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거","비프패티를 기반으로 야채가 들어간 기본버거"};
        String[] name1 = new String[]{"Ice Americano", "Smoody", "Cola", "Cider"};
        double[] price1 = new double[]{1900, 3900, 3200, 5400};
        String[] description1 = new String[]{"시원한 아이스 아메리카노", "플레인 요거트 스무디", "코카콜라","칠성사이다"};

        Menu[] menu = new Menu[]{new Menu("BURGER", name, price, description),new Menu("DRINKS", name1, price1, description1)};
        Kiosk kiosk = new Kiosk(menu);
        kiosk.start();
    }
}