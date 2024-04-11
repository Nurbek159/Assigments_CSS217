package ex1;


public class Main {
    public static void main(String[] args) {
        CharacterCreator characterCreator = new CharacterCreator();

        // Example: create a Warrior
        characterCreator.setFactory(new WarriorFactory());
        Character warrior = characterCreator.createCharacter("Warrior");
        System.out.println(warrior);

        // Example: create a Mage
        characterCreator.setFactory(new MageFactory());
        Character mage = characterCreator.createCharacter("Mage");
        System.out.println(mage);

        // Example: create an Archer
        characterCreator.setFactory(new ArcherFactory());
        Character archer = characterCreator.createCharacter("Archer");
        System.out.println(archer);
    }
}
