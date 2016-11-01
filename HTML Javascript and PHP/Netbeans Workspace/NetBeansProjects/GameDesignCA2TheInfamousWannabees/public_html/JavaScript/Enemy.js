function Enemy(x, y, xMove, yMove, moveDistance, sprite,g) // object for the falling objects
{
    // private object variables
    var width = 35;
    var height = 35;
    var x = x;
    var y = y;
    var xMove = xMove;
    var yMove = yMove;
    var moveDistance = moveDistance;
    var sprite = sprite;
    var speed = 10; // number in range of 1 to 100, where 100 is fastest  
    var interval = setInterval(move, 100 / getSpeed());

    // public methods 
    this.move = move;
    function move()
    {
        /*
        y++;//moves the object down the y axis
        for (var i = 0; i < enemyArray.length; i++) // checks if any object hits the player or goes past the canvas if yes the objects is destroyed
        {
            if (player.isHit(i)) {
                player.destroy();
            }
        }
        */
    }
    this.destroy = destroy;
    function destroy(i)
    {
        object[i] = null;
    }

    this.draw = draw;
    function draw()
    {
        g.drawImage(sprite, x, y, width, height);
    }
}