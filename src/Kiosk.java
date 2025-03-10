import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> items;
    private Scanner sc;

    public Kiosk(Menu[] items) {
        this.items = new ArrayList<>();
        for (Menu item : items) {
            this.items.add(item);
        }
        sc = new Scanner(System.in);
    }
    public void printMainMenu() {
        System.out.println("[ MAIN MENU ]\n");
        for(int num = 0; num < items.size(); num++) {
            System.out.println(num+1 +". "+items.get(num).getCategory());
        }
        System.out.println("0. 종료하기     | 종료");
    }
    public int choiceMenu() {
        try {
            int choice = sc.nextInt();
            if(choice >= 0 && choice <= items.size()) {
                return choice;
            } else {
                System.out.println("1 ~ "+items.size()+" 선택번호를 입력해주세요.\n");
                return -3;
            }
        }
        catch (InputMismatchException e) {
            System.out.println("1 ~ "+items.size()+" 선택번호를 입력해주세요.\n");
            sc.nextLine();
            return -3;
        }
    }
    public int choiceSubMenu(int choice) {
        try {
            int choice2 = sc.nextInt()-1;
            System.out.println(items.get(choice).getItems().size());
            if (choice2 >= -1 && choice2 < items.get(choice).getItems().size()) {
                return choice2;
            } else {
                System.out.println("1 ~ "+items.get(choice).getItems().size()+" 선택번호를 입력해주세요.\n");
                return -3;
            }
        }
        catch (InputMismatchException e) {
            System.out.println("1 ~ "+items.get(choice).getItems().size()+" 선택번호를 입력해주세요.\n");
            sc.nextLine();
            return -3;
        }
    }
    public void start() {
        while (true) {
            printMainMenu();
            int choice = choiceMenu() - 1;
            if (choice == -1) break;
            else if (choice == -4) continue;
            while(true) {
                items.get(choice).printMenu();
                int choice2 = choiceSubMenu(choice);
                if (choice2 == -1) break;
                else if (choice2 == -3) continue;
                List<MenuItem> temp = items.get(choice).getItems();
                System.out.println("선택한 메뉴 : "+temp.get(choice2).getName()+" | W "+temp.get(choice2).getPrice()+
                                   " | "+temp.get(choice2).getDescription());
            }
        }
    }
}
