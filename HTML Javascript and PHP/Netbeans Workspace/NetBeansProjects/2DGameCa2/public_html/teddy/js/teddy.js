// Teddy javascript
var canvasWidth = 700;  // all canvases (including double buffers) will have the same width and height
var canvasHeight = 700; // making this width and height bigger will make Teddy smaller
                        
var canvas;  // The screen canvas
var g;       // and its graphic context

var scaleX = 1;
var scaleY = 1;
function setScreenToCanvasScaleFactors()
{
    // sets the scaling factor between the physical screen canvas size and the logical canvas graphics context size
    scaleX = document.getElementById("imageCanvas").clientWidth / canvasWidth;
    scaleY = document.getElementById("imageCanvas").clientHeight / canvasHeight;
}


// Convert from degrees to radians.
Math.radians = function(degrees) 
{
    return degrees * Math.PI / 180;
};


// Convert from radians to degrees.
Math.degrees = function(radians) 
{
  return radians * 180 / Math.PI;
};


var NO_BODYPART = -1;
var selectedBodyPart = NO_BODYPART;
function mouseClickedOnCanvas(e)
{ 
   if(e.which === 1)  // left mouse button pressed
   {
      mouseIsDown = true; 
   }
   document.body.style.cursor = "move";
   for(var i = 0; i < NUMBER_OF_BODY_PARTS; i++)
    {
        if(body[i] !== undefined)
        {
            if(body[i].isHotSpot(e.x, e.y) === true)
            {
                selectedBodyPart = i;
            }
        }
    } 
   oldMouseX = e.x;
   oldMouseY = e.y;
}


function mouseUpOnCanvas(e)
{
    mouseIsDown = false;
    document.body.style.cursor = "auto";
    selectedBodyPart = NO_BODYPART;  
};


function mouseMovedOnCanvas(e)
{ 
    if(mouseIsDown === false)
    {
        return;
    }
    
    // if a bodypart is selected, then move it
    if(selectedBodyPart !== NO_BODYPART)
    {
        body[selectedBodyPart].addDegrees(e.x, e.y, ROTATION_STEP_SIZE);
    }
    
    // update the x and y location
    oldMouseX = e.x;
    oldMouseY = e.y;
   
    drawWholeBody();
}
    
    
function isRotatingClockwise(centerX, centerY, x, y)
{
   // scale physical screen position to canvas logical position
   x /= scaleX;
   y /= scaleY;
   oldMouseX /= scaleX;
   oldMouseY /= scaleY;
   // return true if the mouse is dragging in a clockwise direction, else return false
   if (Math.abs(x - oldMouseX) >= Math.abs(y - oldMouseY))
   {
      // mouse is being moved primarily along the x-axis
      if ((x < oldMouseX))  // mouse is moving to the left
      {
         if (y < centerY)     // mouse is above the image
         {
            return false;
         }
         else   // mouse is below the image
         {
            return true;
         }
      }
      else  // mouse is moving to the right
      {
         if (y < centerY)   // mouse is to the left of the image
         {
            return true;
         }
         else  // mouse is to the right of the image
         {
             return false;
         }
      }
   }
   else // mouse is being moved primarily along the y-axis
   {
      // mouse is being moved primarily along the y-axis
      if (y < oldMouseY)  // mouse is moving to the left
      {
         if (x < centerX)     // mouse is above the image
         {
            return true; 
         }
         else   // mouse is below the image
         {
             return false;
         }
      }
      else  // mouse is moving to the right
      {
         if (x < centerX)   // mouse is to the left of the image
         {
             return false;
         }
         else  // mouse is to the right of the image
         {
             return true;
         }
      }
   }    
};


function drawWholeBody()
{
    // draw all of the body parts on the screen's canvas
    body[TORSO].rotateBodyPartCanvas();
    
    // draw the background image
    g.drawImage(backgroundImage, 0, 0, canvasWidth, canvasHeight);  
    
        // draw all the body parts
    for(var i = NUMBER_OF_BODY_PARTS; i >= 0; i--)
    {
        if(body[i] !== undefined)
        {
            body[i].drawBodyPartOnToTheScreen();    
        }
    }
    
    // overlay the tv on top of the screen canvas
    g.drawImage(tv, 0, 0, canvasWidth, canvasHeight);
}

function pausecomp(millis)
 {
  var date = new Date();
  var curDate = null;
  do { curDate = new Date(); }
  while(curDate-date < millis);
}

var MAX_FRAMES = 100; // there can be at most MAX_FRAMES in an animation
function Animation(body)
{
    // an animation consists of one or more AnimaitonFrames
    // constructor variables
    m_body = body;
    
    // private variables
    
    var thetha = [14];    
    for(var x = 0; x < 100; x++)
    {
        thetha[x] = [];    
        for(var y = 0; y < 100; y++)
        { 
            thetha[x][y] = x * y;    
        }    
    }
    var m_currentFrame = 0;
    var m_playingFrame = 0;
 
    var animationFrameRate = 1;    // numer of frames to display per second
 // derek MAX_BODYPARTS needs to be defined    
    this.createFrame = createFrame;
    function createFrame()
    {
        for(var i = 0; i < 14; i++)
        {
            // store the body part's details
            var temp = new BodyPart() ;
            temp= body[i];
            thetha[m_currentFrame][i] = temp.getThetha();
        }
        m_currentFrame++;
    }
  
    this.resetAnimation = resetAnimation;
    function resetAnimation()
    {
        m_currentFrame = 0;
        m_playingFrame = 0;
        // position the bodyparts
        for(var i = 0; i < 14; i++)
        {
            body[i].setThetha(thetha[m_currentFrame][i]);           
        }
        
        // draw the body
        drawWholeBody();   
    }
    
    
    var animationInterval;
    this.playFrame = playFrame;
    function playFrame()
    {     
        // stop the animatin if all the frames have been played
        if(m_playingFrame === m_currentFrame)
        {
            clearInterval(animationInterval);
            resetAnimation();
        }
        
        // position the bodyparts
        for(var i = 0; i < 14; i++)
        {
            body[i].setThetha(thetha[m_playingFrame][i]);           
        }
        
        // draw the body
        drawWholeBody();         

        
      
        // set the next frame to be displayed
        m_playingFrame++;
    }    
    

    this.playAnimation = playAnimation;
    function playAnimation()
    {
        // start animation at the first frame
        m_playingFrame = 0;
        
        // do the animation
        animationInterval = setInterval(playFrame, 1000 / animationFrameRate); 

    }
    
                                     
}



function BodyPart(name, sourceImage, width, height, thetha, centreOfRotationX, centreOfRotationY, hotSpotX, hotSpotY, hotSpotRadius)
{
    // There needs to be one body part for each seperate part of the body
    // For example, the left arm consists of 3 body parts: LEFT_ARM_UPPER, LEFT_ARM_LOWER and LEFT_HAND
    
    // constructor variables
    var m_name = name; // Not strictly need, but useful for debugging
    var m_sourceImage = sourceImage; // the image file that contains this body part
    
    var m_width = width;        // width and height of the body part in canvas coordinates
    var m_height = height;
    var m_thetha = thetha;      // the angle of rotation (in radiants)
    var m_centreOfRotationX = centreOfRotationX;  // the point around which rotations occur
    var m_centreOfRotationY = centreOfRotationY;
    
    var m_hotSpotX = hotSpotX;             // hot spot for identifying where the user can drag the mouse to 
    var m_hotSpotY = hotSpotY;             // rotate this body part
    var m_hotSpotRadius = hotSpotRadius;   // size of the hotspot
    
    
    // Object state variables
    var m_children = new Array(MAX_DECENDENTS);  // list of direct children. 
                                                 // E.g. LEFT_ARM_LOWER is the only direct child of LEFT_ARM_UPPER 
    var m_numberOfChildren = 0;                    // used to keep track of the number of children in 
                                                 // the m_children array above.
    
    var m_doubleBuffer = document.createElement('canvas'); // each body part has its own double buffer
    var m_doubleBufferG = m_doubleBuffer.getContext('2d');
    
    // connection to parent body part    
    var m_parentX;           // the parent coordinates are the point on the parent bodyPart
    var m_parentY;           // that m_centreOfRotationX and m_centreOfRotationX will attach to
    var m_originalParentX;   // the parent coordinates are in the parent's coordinate space
    var m_originalParentY;
    
    // flags
    var m_drawHotSpot = false;  // by default, do not draw the hotspot on the screen
    var m_rotateLocked = false; // by default, all bodyparts can rotate
    var m_isVisible = true;     // by default, all body parts are visible


    // initialisation    
    m_doubleBuffer.width = canvasWidth;
    m_doubleBuffer.height = canvasHeight;
    
    var m_bodyPartImageFile = m_sourceImage;   
   // m_bodyPartImageFile.src = m_sourceImage;


    // public methods
    this.rotateBodyPartCanvas = rotateBodyPartCanvas;
    function rotateBodyPartCanvas()
    {
        // This function will draw the rotated body part image onto this body part's double buffer canvas.
        var centreOfRotationX;
        var centreOfRotationY;
        
        centreOfRotationX = m_parentX;
        centreOfRotationY = m_parentY;

        // rotate each child's centre of rotation and hotspot around this bodypart's centre of rotation
        for(var i = 0; i < m_numberOfChildren; i++)
        {
            if(m_children[i] !== undefined)
            {                
                // set the child's parentX and parentY
                m_children[i].SetParentXandY(centreOfRotationX, centreOfRotationY, m_thetha, m_centreOfRotationX, m_centreOfRotationY);                                
            }
        }                          

        m_doubleBufferG.clearRect(0, 0, canvasWidth, canvasWidth);
        
        // rotate this canvas around this body part's centre of rotation      
        rotateCanvas(m_thetha, m_parentX, m_parentY);
        
        // draw this body part on the double buffer
        if(m_isVisible === true)
        {
           m_doubleBufferG.drawImage(m_bodyPartImageFile, centreOfRotationX - m_centreOfRotationX, centreOfRotationY - m_centreOfRotationY, m_width, m_height);
        }
       
        // reset the canvas back to its original position
        rotateCanvas(-m_thetha, m_parentX, m_parentY);          
        
        // if required, draw the the hotspot
        if (m_drawHotSpot === true)
        {
            drawHotSpot();
        }
              
        // recursively rotate each child body part about its own centre of rotation
        for(var i = 0; i < m_numberOfChildren; i++)
        {
            if(m_children[i] !== undefined)
            {
                m_children[i].rotateBodyPartCanvas();
            }
        }
    }
  
    
    this.drawBodyPartOnToTheScreen = drawBodyPartOnToTheScreen;
    function drawBodyPartOnToTheScreen()
    {
        if(m_isVisible === false)
        {
            return;
        } 
        
        // draw this body part's canvas onto the screen
        g.drawImage(m_doubleBuffer, 0, 0, canvasWidth, canvasHeight);   
    }
    
    
    this.rotateCanvas = rotateCanvas;
    function rotateCanvas(thetha, centreX, centreY)
    {
        // rotate the double buffer of this body part around this the given centre of rotation    
        m_doubleBufferG.translate(centreX, centreY);
        m_doubleBufferG.rotate(thetha);
        m_doubleBufferG.translate(-centreX, -centreY);        
    }

        
    this.rotateHotSpot = rotateHotSpot;
    function rotateHotSpot(centreOfRotationX, centreOfRotationY, thetha, offsetX, offsetY)
    {
        // rotate hotspot
        m_hotSpotX -= offsetX;
        m_hotSpotY -= offsetY; 
        
        newX = m_hotSpotX * Math.cos(thetha) - m_hotSpotY * Math.sin(thetha);
        m_hotSpotY = m_hotSpotX * Math.sin(thetha) + m_hotSpotY * Math.cos(thetha);
        m_hotSpotX = newX;
   
        m_hotSpotX += centreOfRotationX;
        m_hotSpotY += centreOfRotationY;       
    }
    
    
    this.addDegrees = addDegrees;
    function addDegrees(canvasX, canvasY, degrees) 
    {   
        // do not rotate if this bodyp part is locked
        if(m_rotateLocked === true)
        {
            return;
        }
        
        if(isRotatingClockwise(m_parentX, m_parentY, canvasX, canvasY) === true)
        {
            m_thetha += degrees;
        }
        else
        {
            m_thetha -= degrees;
        }
    }
   
    
    this.isHotSpot = isHotSpot;
    function isHotSpot(canvasX, canvasY)    
    {
        // allow for differences in the physical and the logical size of the canvas
        canvasX /= scaleX;
        canvasY /= scaleY;
        
        var hotSpotX = m_parentX - m_centreOfRotationX + m_hotSpotX;
        var hotSpotY = m_parentY - m_centreOfRotationY + m_hotSpotY;
        
        // rotate the hotspot around the parentX and parentY
        hotSpotX -= m_parentX;
        hotSpotY -= m_parentY; 
        
        newX = hotSpotX * Math.cos(m_thetha) - hotSpotY * Math.sin(m_thetha);
        hotSpotY = hotSpotX * Math.sin(m_thetha) + hotSpotY * Math.cos(m_thetha);
        hotSpotX = newX;
   
        hotSpotX += m_parentX;
        hotSpotY += m_parentY;   
        
        if((canvasX > hotSpotX - m_hotSpotRadius) && (canvasX < hotSpotX + m_hotSpotRadius) &&
           (canvasY > hotSpotY - m_hotSpotRadius) && (canvasY < hotSpotY + m_hotSpotRadius))
        {
            return true; 
        }
        else
        {
            return false;
        }
    }

   
    this.drawHotSpot = drawHotSpot;
    function drawHotSpot()    
    {
        if(m_drawHotSpot === false)
        {
            return;
        }
        
        // do not draw a hot spot if the body part is invisible
        if(m_isVisible === false)
        {
            return;
        }
        var hotSpotX = m_parentX - m_centreOfRotationX + m_hotSpotX;
        var hotSpotY = m_parentY - m_centreOfRotationY + m_hotSpotY;
        
        // rotate the hotspot around the parentX and parentY
        hotSpotX -= m_parentX;
        hotSpotY -= m_parentY; 
        
        newX = hotSpotX * Math.cos(m_thetha) - hotSpotY * Math.sin(m_thetha);
        hotSpotY = hotSpotX * Math.sin(m_thetha) + hotSpotY * Math.cos(m_thetha);
        hotSpotX = newX;
   
        hotSpotX += m_parentX;
        hotSpotY += m_parentY;           
             
        
        // draw the hotspot
        m_doubleBufferG.globalAlpha = 0.15;
        m_doubleBufferG.beginPath();
        m_doubleBufferG.fillStyle = "blue";
        m_doubleBufferG.arc(hotSpotX, hotSpotY, m_hotSpotRadius, 0, Math.PI * 2);
        m_doubleBufferG.fill();
        m_doubleBufferG.closePath(); 
        m_doubleBufferG.globalAlpha = 1;              
    }
    
    
    // getter functions 
    this.getName = getName;
    function getName()
    {
        return m_name;
    }


    this.getThetha = getThetha;
    function getThetha()
    {
        return m_thetha;
    }     

        
    // setter functions
    this.setChild = setChild;
    function setChild(child, parentX, parentY)
    {
        // set a direct child of this body part
        // For example, LEFT_ARM_UPPER has one direct child, which is LEFT_ARM_LOWER
        m_children[m_numberOfChildren] = child;
        child.setParentXandY(parentX, parentY); 
        m_numberOfChildren++;
    }
 
 
    this.setParentXandY = setParentXandY;
    function setParentXandY(newParentX, newParentY)
    {
        // This function ties the parent's coordinates to the child's centreOfRotation coordinates
        // The parent's coordinates are the x,y values of the joint on the parent where
        // the child's rotation x,y coordinates will attach to
        
        m_parentX = newParentX;
        m_parentY = newParentY;
        m_originalParentX = m_parentX;
        m_originalParentY = m_parentY;
    } 


    this.SetParentXandY = SetParentXandY;
    function SetParentXandY(centreOfRotationX, centreOfRotationY, thetha, offsetX, offsetY)
    {
        // rotate parentX and parentY
        m_parentX = m_originalParentX;
        m_parentY = m_originalParentY;
        m_parentX -= offsetX;
        m_parentY -= offsetY; 
        
        newX = m_parentX * Math.cos(thetha) - m_parentY * Math.sin(thetha);
        m_parentY = m_parentX * Math.sin(thetha) + m_parentY * Math.cos(thetha);
        m_parentX = newX;
   
        m_parentX += centreOfRotationX;
        m_parentY += centreOfRotationY;   
    }       

        
    this.setRotateLocked = setRotateLocked;
    function setRotateLocked(state)
    {
        m_rotateLocked = state;
        
        // recursively lock each child of this body part
        // If you want to lock a parent, but unlock a child, then
        // setRotateLocked(true) for the parent followed by setRotateLocked(false) for the child
        for(var i = 0; i < m_numberOfChildren; i++)
        {
            if(m_children[i] !== undefined)
            {
                m_children[i].setRotateLocked(state);
            }
        }        
    }

    this.setThetha = setThetha;
    function setThetha(thetha)
    {
        m_thetha = thetha;
    } 
    
    
    this.setIsVisible = setIsVisible;
    function setIsVisible(state)
    {
        m_isVisible = state;
        
        // recursively set each child of this body part to be also invisible
        // because it makes no sense for a body part to be visible if its parent is not visible
        // For example, you should not be able to see the RIGHT_HAND if you cannot see the RIGHT_ARM_LOWER
        for(var i = 0; i < m_numberOfChildren; i++)
        {
            if(m_children[i] !== undefined)
            {
                m_children[i].setIsVisible(state);
            }
        }           
    }        

        
    this.setDrawHotSpot = setDrawHotSpot;
    function setDrawHotSpot(state)
    {
        // Not strictly necessary, but might be useful as a guide to showing younger users where to drag
        m_drawHotSpot = state;
    }    
}





