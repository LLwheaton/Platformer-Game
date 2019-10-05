package stickman.model;

public abstract class EntityFactory{

    public abstract IEntity createEntity(double xpos, double ypos, double height, double width);
}