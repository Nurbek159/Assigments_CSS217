package ex1;

import java.util.List;
import java.util.ArrayList;


class Character {
    private String name;
    private Appearance appearance;
    private List<Ability> abilities;
    private List<Equipment> equipment;
    private Attribute attributes;

    public Character(String name, Appearance appearance, List<Ability> abilities, List<Equipment> equipment, Attribute attributes) {
        this.name = name;
        this.appearance = appearance;
        this.abilities = abilities;
        this.equipment = equipment;
        this.attributes = attributes;
    }



    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", appearance=" + appearance +
                ", abilities=" + abilities +
                ", equipment=" + equipment +
                ", attributes=" + attributes +
                '}';
    }
}

abstract class CharacterFactory {
    public abstract Character createCharacter(String name);
}

class WarriorFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name) {
        return null;
    }
}

class MageFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name) {
        return null;
    }
}

class ArcherFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name) {

        return null;
    }
}

class Appearance {

}

class Ability {
}

class Equipment {
}

class Attribute {

}


class CharacterCreator {
    private CharacterFactory factory;

    public void setFactory(CharacterFactory factory) {
        this.factory = factory;
    }

    public Character createCharacter(String name) {
        if (factory == null) {
            throw new IllegalStateException("Factory not set");
        }
        return factory.createCharacter(name);
    }
}

