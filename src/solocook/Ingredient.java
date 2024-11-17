package solocook;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Ingredient {
	//データベースの基準要素
    private String name; //　材料名
    private double quantity;//量
    private LocalDate expirationDate;//消費期限

   // コンストラクタ
    public Ingredient(String name, double quantity, LocalDate expirationDate) {
        this.name = name;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
    }

    //ゲッター
    public String getName() {
        return name;
    }

    public double getQuantity() {
        return quantity;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    //セッター
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    // 賞味期限からコスト
    public double calculateCost() {
        long daysToExpire = ChronoUnit.DAYS.between(LocalDate.now(), expirationDate);//賞味期限までの日数
        // 賞味期限が切れている場合は最大コスト
        if (daysToExpire > 0) {
        	return daysToExpire;
        }
        else {
        	return Double.MAX_VALUE;
        }
    }

    @Override
    //材料の内部状態の表示→Ingrediend{name=材料名,quantity=量,expirationData=賞味期限
    public String toString() {
        return "Ingredient{" + "name='" + name + '\'' + ", quantity=" + quantity + ", expirationDate=" + expirationDate +'}';
    }
}
