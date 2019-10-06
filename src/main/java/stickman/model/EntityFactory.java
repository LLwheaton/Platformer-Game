package stickman.model;

/**
 * Factory for creating entities based on its type.
 */
public class EntityFactory {

    /**
     * Creates an Entity object.
     * @param type The type of Entity to create.
     * @return The newly created Entity of the given type.
     */
    public Entity createEntity(String type) {
        switch (type.toLowerCase()){
            case "player": return new Player();
            case "cloud": return new Cloud();
            case "slime": return new Slime();
            case "platform": return new Platform();
            case "tree": return new Tree();
            case "coin": return new Coin();
            default: throw new IllegalArgumentException("Invalid type given");
        }
    }
}
