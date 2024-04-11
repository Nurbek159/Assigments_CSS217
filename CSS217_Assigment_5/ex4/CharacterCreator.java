package ex4;

public class CharacterCreator {
    private CharacterFactory factory;

    public void setFactory(CharacterFactory factory) {
        this.factory = factory;
    }

    public Character createCharacter() {
        Character character = factory.createCharacter();
        Weapon weapon = factory.createWeapon();
        character.setWeapon(weapon);
        return character;
    }
}
