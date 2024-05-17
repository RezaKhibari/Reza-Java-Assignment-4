package weather;

public class Sunny implements Weather {
    public String getWeatherName() {
        return "Sunny";
    }

    public double modifyDamage(double damage) {
        return damage; // No change in damage
    }

    public double modifyHitChance(double hitChance) {
        return hitChance; // No change in hit chance
    }
} // Sunny class
