package stickman.view;

import javafx.scene.Node;
import stickman.model.IEntity;

public interface EntityView {
    void update(double xViewportOffset);

    boolean matchesEntity(IEntity entity);

    void markForDelete();

    Node getNode();

    boolean isMarkedForDelete();
}
