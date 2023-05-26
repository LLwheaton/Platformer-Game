# Stickman

![alt text](https://github.com/LLwheaton/StickmanStage2/blob/master/stickmansample.PNG "Stickman Level")


Java style guide used for project: https://google.github.io/styleguide/javaguide.html

Stickman is a 2D platformer game where players control Stickman to progress through multiple levels by avoiding or killing enemy slimes, picking up coins, 
and reaching the chest at the end of each level!

A configuration file 'default.json' is given in the resources directory for the user to configure the quantities and positions of entities within a level.
The current configuration file can change:
- The location of the finish line (FinishLine).
- The size, location and velocity of Stickman. Sizes can be 'tiny', 'normal', 'large', 'giant'.
- The quantity, position, and velocity of Clouds and Slimes.
- The quantity and position of Platforms, Trees and Coins.

<strong>JSON file:</strong> src/main/resources/default.json

## How to run:
- Clone project
- Install gradle locally https://gradle.org/install/
- Navigate to root folder and use "gradle run"

## Testing:
- In root folder use "gradle test"

#### Game Assets sources:
https://startledpixels.itch.io/2d-pixel-item-asset-pack <br>
https://ansimuz.itch.io/magic-cliffs-environment
