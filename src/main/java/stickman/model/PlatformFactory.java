package stickman.model;

public class PlatformFactory extends EntityFactory {
    @Override
    public IEntity createEntity(double xpos, double ypos, double height, double width) {
        return new Platform(xpos, ypos, height, width);
    }
}
