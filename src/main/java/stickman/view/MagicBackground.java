package stickman.view;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import stickman.model.GameEngine;

public class MagicBackground implements BackgroundDrawer {

    private double width;
    private Image[] images;
    private ImageView[] imageViews;
    private double[] parallaxEffect;

    @Override
    public void draw(GameEngine model, Pane pane) {
        this.width = pane.getWidth();
        double height = pane.getHeight();

        createImageArray();
        createParallaxEffectArray();

        this.imageViews = new ImageView[4];

        for (int i = 0;i < 4; i++) {
            imageViews[i] = new ImageView(images[i]);
            double rawHeight = images[i].getHeight();
            double rawWidth = images[i].getWidth() / 2; // images are all double stitched

            imageViews[i].setViewOrder(1001.0 + i);
            imageViews[i].setFitHeight(height);
            imageViews[i].setFitWidth(width);
            imageViews[i].setX(0);
            imageViews[i].setY(0);
            imageViews[i].setViewport(new Rectangle2D(0, 0, rawWidth, rawHeight));

            pane.getChildren().add(imageViews[i]);
        }
    }

    @Override
    public void update(double xViewportOffset) {

        for (int i = 0;i < 4; i++) {
            double rawHeight = images[i].getHeight();
            double rawWidth = images[i].getWidth() / 2; // images are all double stitched
            double widthScale = rawWidth / width;
            double translation = (xViewportOffset * widthScale * parallaxEffect[i]) % rawWidth;
            imageViews[i].setViewport(new Rectangle2D(translation, 0, rawWidth, rawHeight));
        }
    }

    private void createParallaxEffectArray(){
        this.parallaxEffect = new double[4];
        parallaxEffect[0] = 0.5;
        parallaxEffect[1] = 0.4;
        parallaxEffect[2] = 0.2;
        parallaxEffect[3] = 0.05;
    }

    private void createImageArray(){
        this.images = new Image[4];
        images[0] = new Image("BGFront.png");
        images[1] = new Image("BGBack.png");
        images[2] = new Image("CloudsFront.png");
        images[3] = new Image("CloudsBack.png");
    }
}