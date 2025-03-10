import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<MenuItem> items = new ArrayList<MenuItem>();
        items.add(new MenuItem("ShackBurger",6900,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        items.add(new MenuItem("SmokeShack",8900,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        items.add(new MenuItem("Cheeseburger",6900,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        items.add(new MenuItem("Hamburger",5400,"비프패티를 기반으로 야채가 들어간 기본버거"));
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("[ SHAKESHACK MENU ]\n");
            for(int num = 0; num < items.size(); num++) {
                System.out.println(num+1 +". "+items.get(num).getName()+"    "+"| W "+items.get(num).getPrice()/1000+" | "+items.get(num).getDescription());
            }
            System.out.println("0. 종료      | 종료");
            int choice = sc.nextInt();
            if (choice == 0) {
                break;
            }
        }

    }
}