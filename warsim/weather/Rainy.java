package weather;

public class Rainy implements Weather {
    public String getWeatherName() {
        return "Rainy";
    }

    public double modifyDamage(double damage) {
        return damage * 0.9; // 10% less damage
    }

    public double modifyHitChance(double hitChance) {
        return hitChance * 0.9; // 10% less hit chance
    }  
} // Rainy class
