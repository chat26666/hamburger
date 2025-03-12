import java.util.*;
import java.util.stream.IntStream;

public class Menu {
    private String category;
    private List<MenuItem> items;

    public Menu(String category, String[] name, double[] price,String[] description) {
        this.category=category;
        items = new ArrayList<>();
        IntStream.range(0, name.length).forEach(i -> items.add(new MenuItem(name[i], price[i], description[i]))); // 람다식 표현으로 변경, 배열의 인덱스가 순차적으로 늘어나는 기능이 필요하기 때문에 IntStream 을 사용하였습니다
    }
    public List getItems() {
        return this.items;
    }
    public String getCategory() {
        return category;
    }
    public void printMenu() {
        System.out.println("[ "+category+" MENU ]\n");                                                              // 메뉴카테고리는 별다른 기능없이 해당 카테고리에 출력 메소드정도만 존재합니다
        IntStream.range(0, items.size()).forEach(num -> System.out.println(num+1 +". "+items.get(num).getName()+
                        "    "+"| W "+items.get(num).getPrice()/1000+" | "+items.get(num).getDescription()));
        System.out.println("0. 뒤로가기      | 뒤로");
    }
}
