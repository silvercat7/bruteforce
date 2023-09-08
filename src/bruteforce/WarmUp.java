package bruteforce;

public class WarmUp {
    public static void main(String[] args) {
        String[] names = {"Bilbo", "Elmo", "Wally"};
        String[] colors = {"Gray", "Rainbow", "Blood"};
        String[] descriptions = {"Wizard", "Elf", "Gym Teacher", "Rogue"};
        for (String name : names) {
            for (String color : colors) {
                for (String desc : descriptions) {
                    System.out.println(name + " the " + color + " " + desc);
                }
            }
        }
    }
}