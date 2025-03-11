import java.util.function.BiFunction;

public enum Buyer {
    PATRIOT(1,(total,discount) -> total - discount/10), //사용자 선택지 1~4, 할인율 메서드 사용
    SOLDIER(2,(total,discount) -> total - discount/20),
    STUDENTS(3,(total,discount) -> total - discount/100*3),
    NORMAL(4,(total,discount) -> total);

    private int num;
    private BiFunction<Double, Double, Double> func;
    Buyer(int num, BiFunction<Double,Double,Double> func) {
        this.num = num;
        this.func = func;
    }
    public int getNum() {
        return num;
    }
    public double getSum(double total, double discount) {
        return func.apply(total, discount);
    }
}
