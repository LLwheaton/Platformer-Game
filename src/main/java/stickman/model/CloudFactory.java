package stickman.model;

public class CloudFactory extends EntityFactory {
    @Override
    public IEntity createEntity(double xpos, double ypos, double height, double width) {
        return new Cloud(xpos, ypos, height, width);
    }
}
