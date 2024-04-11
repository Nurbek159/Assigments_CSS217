package ex3;

class Furniture {
    String name;
    String style;
    String material;
    float price;

    public Furniture(String name, String style, String material, float price) {
        this.name = name;
        this.style = style;
        this.material = material;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "name='" + name + '\'' +
                ", style='" + style + '\'' +
                ", material='" + material + '\'' +
                ", price=" + price +
                '}';
    }
}

abstract class FurnitureFactory {
    public abstract Furniture createChair();
    public abstract Furniture createTable();
    public abstract Furniture createSofa();
}

class ModernWoodFactory extends FurnitureFactory {
    @Override
    public Furniture createChair() {
        return new Furniture("Modern Wooden Chair", "Modern", "Wood", 150.0f);
    }

    @Override
    public Furniture createTable() {
        return new Furniture("Modern Wooden Table", "Modern", "Wood", 300.0f);
    }

    @Override
    public Furniture createSofa() {
        return new Furniture("Modern Wooden Sofa", "Modern", "Wood", 700.0f);
    }
}


class TraditionalMetalFactory extends FurnitureFactory {
    @Override
    public Furniture createChair() {
        return null;
    }

    @Override
    public Furniture createTable() {
        return null;
    }

    @Override
    public Furniture createSofa() {
        return new Furniture("Traditional Metal Sofa", "Traditional", "Metal", 550.0f); // Example implementation
    }
}

class Chair extends Furniture {
    public Chair(String name, String style, String material, float price) {
        super(name, style, material, price);
    }
}

class Table extends Furniture {
    public Table(String name, String style, String material, float price) {
        super(name, style, material, price);
    }
}

class Sofa extends Furniture {
    public Sofa(String name, String style, String material, float price) {
        super(name, style, material, price);
    }
}

// 5. Furniture Creator
class FurnitureCreator {
    private FurnitureFactory factory;

    public void setFactory(FurnitureFactory factory) {
        this.factory = factory;
    }

    public Furniture createChair() {
        return factory.createChair();
    }

    public Furniture createTable() {
        return factory.createTable();
    }

    public Furniture createSofa() {
        return factory.createSofa();
    }
}

// 6. Usage Example
public class Main {
    public static void main(String[] args) {
        FurnitureCreator creator = new FurnitureCreator();

        // Modern Wood Furniture
        creator.setFactory(new ModernWoodFactory());
        Furniture modernChair = creator.createChair();
        Furniture modernTable = creator.createTable();

        System.out.println(modernChair);
        System.out.println(modernTable);

    }
}