package ex4;

public class WarriorSwordFactory extends CharacterFactory {
    @Override
    public Character createCharacter() {
        Character warrior = new Warrior();
        warrior.setName("Warrior");
        warrior.setClassName("Warrior");
        warrior.setHealth(150);
        warrior.setMana(50);
        return warrior;
    }

    @Override
    public Weapon createWeapon() {
        Weapon sword = new Sword();
        sword.setType("Sword");
        sword.setDamage(25);
        sword.setSpeed(3);
        sword.setRange(1);
        return sword;
    }
}
