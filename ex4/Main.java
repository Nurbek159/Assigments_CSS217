package ex4;

public class Main {
    public static void main(String[] args) {
        CharacterCreator creator = new CharacterCreator();
        creator.setFactory(new WarriorSwordFactory());
        Character warrior = creator.createCharacter();

        System.out.println("Character Name: " + warrior.getName());
        System.out.println("Character Class: " + warrior.getClassName());
        System.out.println("Weapon Type: " + warrior.getWeapon().getType());
        // ... Print other properties as needed ...
    }
}