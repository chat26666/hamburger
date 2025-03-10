import java.util.*;

public class Menu {
    private String category;
    private List<MenuItem> items;

    public Menu(String category, String[] name, double[] price,String[] description) {
        this.category=category;
        items = new ArrayList<>();
        for (int i = 0; i < name.length; i++) {
            items.add(new MenuItem(name[i], price[i], description[i]));
        }
    }
    public List getItems() {
        return this.items;
    }
    public String getCategory() {
        return category;
    }
    public void printMenu() {
        System.out.println("[ "+category+" MENU ]\n");
        for(int num = 0; num < items.size(); num++) {
            System.out.println(num+1 +". "+items.get(num).getName()+"    "+"| W "+items.get(num).getPrice()/1000+" | "+items.get(num).getDescription());
        }
        System.out.println("0. 뒤로가기      | 뒤로");
    }
}
