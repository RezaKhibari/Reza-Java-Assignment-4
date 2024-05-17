package weather;

public class Windy implements Weather {
    public String getWeatherName() {
        return "Windy";
    }

    public double modifyDamage(double damage) {
        return damage * 0.95; // 5% less damage
    }

    public double modifyHitChance(double hitChance) {
        return hitChance * 0.95; // 5% less hit chance
    } 
} // Windy class
