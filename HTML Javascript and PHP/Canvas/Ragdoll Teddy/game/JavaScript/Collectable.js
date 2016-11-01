function Collectable(x, y, spriteArray,g) // object for the falling objects
{
    // private object variables
    var width = 35;
    var height = 35;
    var x = x;
    var y = y;
    var currentSprite = spriteArray[0];
    var sprites = spriteArray;
    var spriteCount = 0;
    var spriteInterval = setInterval(changeSprite, 100);

    // public methods 
    this.changeSprite = changeSprite;
    function changeSprite()
    {
        spriteCount++;
        if(spriteCount<sprites.length){
            currentSprite = sprites[spriteCount];
        }
        else{
            spriteCount = 0;
            currentSprite = sprites[spriteCount];
        }
    }

    this.destroy = destroy;
    function destroy(i)
    {
        object[i] = null;
    }

    this.draw = draw;
    function draw()
    {
        g.drawImage(currentSprite, x, y, width, height);
    }
}