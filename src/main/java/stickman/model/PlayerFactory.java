package stickman.model;

public class PlayerFactory extends EntityFactory {

    @Override
    public IEntity createEntity(double xpos, double ypos, double height, double width) {
        return new Player(xpos, ypos, height, width);
    }
}
