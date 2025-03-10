import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<MenuItem> items;

    public Kiosk(String[] name, double[] price, String[] description) {
        items = new ArrayList<>();
        for (int i = 0; i < name.length; i++) {
            items.add(new MenuItem(name[i], price[i], description[i]));
        }
    }
    public void start() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("[ SHAKESHACK MENU ]\n");
            for(int num = 0; num < items.size(); num++) {
                System.out.println(num+1 +". "+items.get(num).getName()+"    "+"| W "+items.get(num).getPrice()/1000+" | "+items.get(num).getDescription());
            }
            System.out.println("0. 종료      | 종료");
            try {
                int choice = sc.nextInt();
                if (choice == 0) {
                    break;
                } else if (choice >= 1 && choice <= items.size()) {
                    System.out.println(items.get(choice - 1).getName() + " 선택\n");
                } else {
                    System.out.println("1 ~ "+items.size()+" 선택번호를 입력해주세요.\n");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("1 ~ "+items.size()+" 선택번호를 입력해주세요.\n");
                sc.nextLine();
            }
        }
    }
}
