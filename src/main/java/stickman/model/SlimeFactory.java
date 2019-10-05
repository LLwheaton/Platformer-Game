package stickman.model;

public class SlimeFactory extends EntityFactory {
    @Override
    public IEntity createEntity(double xpos, double ypos, double height, double width) {
        return new Slime(xpos, ypos, height, width);
    }
}
