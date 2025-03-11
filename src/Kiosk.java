import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Kiosk {
    private List<Menu> items;
    private HashMap<MenuItem,Integer> carts;
    private Scanner sc;

    public Kiosk(Menu[] items) {
        this.items = new ArrayList<>();
        this.carts = new HashMap<>();
        Arrays.stream(items).forEach(a -> this.items.add(a)); // 람다식 표현으로 for 문을 대체하였습니다.
        sc = new Scanner(System.in);
    }
    public void printMainMenu() {
        System.out.println("[ MAIN MENU ]\n");
        if(carts.size() > 0) {
            IntStream.range(0,items.size()).forEach(num -> System.out.println(num + 1 + ". " + items.get(num).getCategory())); // 람다식 표현으로 for문 대체 index 값(num)의 증가를 위해서 IntStream 사용
            System.out.println("\n[ ORDER MENU ]\n");
            System.out.println(items.size()+1 + ". ORDERS");
            System.out.println(items.size()+2 + ". CANCEL");
        } else IntStream.range(0,items.size()).forEach(num -> System.out.println(num + 1 + ". " + items.get(num).getCategory()));
        System.out.println("0. 종료하기     | 종료");
    }
    public int choiceMenu() throws InputMismatchException {
            int choice = sc.nextInt()-1;
            if((choice >= -1 && choice < items.size()) || (choice >= -1 && choice < items.size()+2 && carts.size() > 0)) return choice;
            else throw new InputMismatchException();
    }
    public int choiceSubMenu(int choice) throws InputMismatchException {
            int choice2 = sc.nextInt()-1;
            if (choice2 >= -1 && choice2 < items.get(choice).getItems().size()) return choice2;
            else throw new InputMismatchException();
    }
    public void shoppingCart() throws InputMismatchException {
        System.out.println("아래와 같이 주문 하시겠습니까?\n");
        carts.forEach((key, value) -> System.out.println(key.getName() + "    " + "| W "
                + key.getPrice() + " | " + key.getDescription() + " " + value + "개"));
        AtomicInteger sum = new AtomicInteger(0);
        carts.forEach((key, value) -> sum.addAndGet((int) (value * key.getPrice())));
        System.out.println("\n[ Total ]\n" + "| W " + sum.get() + " | \n");
        System.out.println("1. 주문      2. 메뉴판");
        int choice = sc.nextInt();
        if (choice == 1) {
            System.out.println("할인 정보를 입력해주세요.\n" +
                    "1. 국가유공자 : 10% \n" +
                    "2. 군인     :  5%\n" +
                    "3. 학생     :  3%\n" +
                    "4. 일반     :  0%");
            int choiceFinal = sc.nextInt();
            if (choiceFinal >= 1 && choiceFinal <= 4) {
                Arrays.stream(Buyer.values()).filter(buyer -> buyer.getNum() == choiceFinal)
                        .forEach(buyer -> System.out.println("주문이 완료되었습니다. 금액은 W " + buyer.getSum(sum.get(), sum.get()) + " 입니다."));
                carts.clear();  //열거형 클래스 사용으로 4~5줄의 if 분기문 대신 한줄의 코드로 대체되었습니다.
            }
            else throw new InputMismatchException();
        }
        else if (choice == 2) System.out.println("메뉴판으로 돌아갑니다.");
        else throw new InputMismatchException();
    }
    public void start() {
        while (true) {
            int choice = 0;
            try {
                printMainMenu();
                choice = choiceMenu();
                if (choice == -1) break;
                else if (choice == 2) {
                    shoppingCart();
                    continue;
                }
                else if (choice == 3) {
                    carts.clear();
                    System.out.println("장바구니를 비웁니다.\n");
                    continue;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("제대로 된 선택번호를 입력해주세요.\n");
                sc.nextLine();
                continue;
            }
            while(true) {
                try {
                    items.get(choice).printMenu();
                    int choice2 = choiceSubMenu(choice);
                    if (choice2 == -1) break;
                    List<MenuItem> temp = items.get(choice).getItems();
                    System.out.println("선택한 메뉴 : "+temp.get(choice2).getName()+
                                       " | W "+temp.get(choice2).getPrice()+
                                       " | "+temp.get(choice2).getDescription());
                    System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?\n" +
                                       "1. 확인        2. 취소");
                    int choice3 = sc.nextInt();
                    if(choice3 == 1) {
                        carts.put(temp.get(choice2), carts.getOrDefault(temp.get(choice2), 0) + 1);
                        System.out.println(temp.get(choice2).getName()+" 이 장바구니에 추가되었습니다.");
                    }
                    else if(choice3 == 2) System.out.println("취소합니다.\n");
                    else throw new InputMismatchException();
                }
                catch (InputMismatchException e) {
                    System.out.println("제대로 된 선택번호를 입력해주세요.\n");
                    sc.nextLine();
                }
            }
        }
    }
}
