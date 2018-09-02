package model;

/**
 * 菜肴
 */
public class Dish {

    public Dish() {
    }

    public Dish(String name, String type, int calories) {
        this.name = name;
        this.type = type;
        this.calories = calories;
    }

    private String name;// 菜名
    private String type;// 类型
    private int calories;// 卡路里

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", tyoe='" + type + '\'' +
                ", calories=" + calories +
                '}';
    }
}
