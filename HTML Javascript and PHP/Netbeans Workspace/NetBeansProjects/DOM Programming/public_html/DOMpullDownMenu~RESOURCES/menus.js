window.onload = init;

var activeMenu = null;
var clipHeight;
var timeID;

function init(){
    var menus = new Array();
    var allElems = document.getElementsByTagName('*');
    
    for(i=0; i<allElems.length; i++){
        if(allElems[i].className === "menu"){
            menus.push(allElems[i]);
        }
    }

    for(i=0; i<menus.length; i++){
        menus[i].onclick = changeMenu;
        menus[i].onmouseover = moveMenu;
    }
    
    document.getElementById("logo").onmouseover = closeOldMenu;
    document.getElementById("linkList").onmouseover = closeOldMenu;
    document.getElementById("main").onmouseover = closeOldMenu;
    
}

function changeMenu(){
    closeOldMenu();
    
    menuID = this.id + 'List';
    activeMenu = document.getElementById(menuID);
    activeMenu.style.clip = 'rect(0px,150px,0px,0px)';
    activeMenu.style.display = 'block';
    timeID = setInterval('rollDown()',1);
}
function moveMenu(){
    closeOldMenu();
    
    menuID = this.id + 'List';
    activeMenu = document.getElementById(menuID);
    activeMenu.style.clip = 'rect(0px,150px,0px,0px)';
    activeMenu.style.display = 'block';
    timeID = setInterval('rollDown()',1);
}
function closeOldMenu(){
    if(activeMenu){
        clearInterval(timeID);
        activeMenu.style.display = 'none';
        activeMenu = null;
    }
}
function rollDown(){
    clipHeight = clipHeight+3;
    
    if(clipHeight<400){
        activeMenu.style.clip = 'rect(0px,150px,'+clipHeight+'px,0px)';
    }
    else{
        clearInterval(timeID);
        clipHeight = 0;
    }
}
