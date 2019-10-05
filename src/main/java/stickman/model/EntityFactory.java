package stickman.model;

public class EntityFactory {

    public IEntity createEntity(String type) {
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
