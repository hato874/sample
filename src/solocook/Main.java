package solocook;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        IngredientDatabase database = new IngredientDatabase();
        
        // 材料を追加
        database.addIngredient(new Ingredient("卵", 12, LocalDate.of(2024, 12, 1)));
        database.addIngredient(new Ingredient("小麦粉", 1000, LocalDate.of(2024, 11, 20)));
        database.addIngredient(new Ingredient("牛乳", 1500, LocalDate.of(2024, 11, 15)));
        database.addIngredient(new Ingredient("トマト", 6, LocalDate.of(2024, 11, 13)));
        // 他の材料も同様に追加...

        // 複数のメニューを作成
        List<Menu> menus = new ArrayList<>();
        Map<String, Double> menu1Ingredients = new HashMap<>();
        menu1Ingredients.put("卵", 3.0);
        menu1Ingredients.put("小麦粉", 200.0);
        menu1Ingredients.put("牛乳", 500.0);
        menus.add(new Menu("パンケーキ", menu1Ingredients));

        Map<String, Double> menu2Ingredients = new HashMap<>();
        menu2Ingredients.put("トマト", 2.0);
        menu2Ingredients.put("牛乳", 300.0);
        menus.add(new Menu("トマトスープ", menu2Ingredients));

        MenuMatcher matcher = new MenuMatcher(database);

        // 幅優先探索で最適なメニューを選択
        Menu optimalMenu = matcher.findOptimalMenuBFS(menus);
        if (optimalMenu != null) {
            System.out.println("\n最適なメニューは: " + optimalMenu.getName());
        } else {
            System.out.println("利用可能なメニューがありません。");
        }
    }
}
