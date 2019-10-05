package stickman.model;

public class CoinFactory extends EntityFactory {
    @Override
    public IEntity createEntity(double xpos, double ypos, double height, double width) {
        return new Coin(xpos, ypos, height, width);
    }
}
