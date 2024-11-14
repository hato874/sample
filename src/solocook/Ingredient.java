package solocook;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Ingredient {
    private String name;
    private double quantity;
    private LocalDate expirationDate;

    public Ingredient(String name, double quantity, LocalDate expirationDate) {
        this.name = name;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public double getQuantity() {
        return quantity;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    // 賞味期限から使用コストを計算（期限が近いほど低コスト）
    public double calculateCost() {
        long daysToExpire = ChronoUnit.DAYS.between(LocalDate.now(), expirationDate);
        return daysToExpire > 0 ? 1.0 / daysToExpire : Double.MAX_VALUE;  // 賞味期限が切れている場合は最大コスト
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
