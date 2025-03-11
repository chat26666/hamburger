
public class Main {
    public static void main(String[] args) {
        String[] name = new String[]{"ShackBurger","SmokeShack","Cheeseburger","Hamburger"};
        double[] price = new double[]{6900, 8900, 6900, 5400};
        String[] description = new String[]{"토마토, 양상추, 쉑소스가 토핑된 치즈버거","베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거",
                                            "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거","비프패티를 기반으로 야채가 들어간 기본버거"};
        String[] name1 = new String[]{"Ice Americano", "Smoody", "Cola", "Cider"};
        double[] price1 = new double[]{1900, 3900, 3200, 5400};
        String[] description1 = new String[]{"시원한 아이스 아메리카노", "플레인 요거트 스무디", "코카콜라","칠성사이다"};

        //Menu 클래스가 생성자 매개변수로 배열을 받기 때문에 더 많은 종류의 제품이 생긴다 하더라도 수용가능합니다.
        //필요한 카테고리를 더 생성하거나 또다른 신제품이 있을 경우, 메인 메서드에서 선언후, Menu 배열에 입력하면됩니다.

        Menu[] menu = new Menu[]{new Menu("BURGER", name, price, description),new Menu("DRINKS", name1, price1, description1)};
        Kiosk kiosk = new Kiosk(menu);
        kiosk.start();
    }
}