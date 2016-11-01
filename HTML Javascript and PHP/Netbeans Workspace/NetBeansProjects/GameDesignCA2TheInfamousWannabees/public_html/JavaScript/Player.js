function Player(playerSprite,canvasWidth,canvasHeight,g) { // creates a player object
    //objects variables
    var currentSprite = playerSprite;
    var width = 100;
    var height = 100;
    var x = canvasWidth / 2;
    var y = canvasHeight / 2;

    //objects public methods including getters and setters for values
    this.draw = draw;
    function draw()
    {
        g.drawImage(currentSprite, x, y, width, height);// draws the sprite
    }

    this.isHit = isHit;
    function isHit(i)
    {
        //if (object[i] !== undefined && object[i] !== null)
       //{

        //}
        return false;
    }
}