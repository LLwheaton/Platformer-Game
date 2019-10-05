package stickman.model;

public class TreeFactory extends EntityFactory{
    @Override
    public IEntity createEntity(double xpos, double ypos, double height, double width) {
        return new Tree(xpos, ypos, height, width);
    }
}
