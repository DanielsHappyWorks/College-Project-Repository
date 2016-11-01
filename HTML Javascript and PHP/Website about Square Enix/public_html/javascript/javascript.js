function redirect()
{
    var random= Math.floor((Math.random()*6)+1);
    if (random===1)
    {
        window.location="../home/home.html";
    }
    else if (random===2)
    {
        window.location="../about_us/about_us.html";
    }
    else if (random===3)
    {
        window.location="../contact_us/contact_us.html";
    }
    else if (random===4)
    {
        window.location="../kingdom_hearts/kingdom_hearts.html";
    }
    else if (random===5)
    {
        window.location="../final_fantasy/final_fantasy.html";
    }
    else if (random===6)
    {
        window.location="../dragon_quest/dragon_quest.html";
    }
}
function search()
{
    var value = document.theForm.box1.value;
    if (value==="h"||value==="ho"||value==="hom"||value==="home"){
        window.location="../home/home.html";
    }
    if (value==="a"||value==="ab"||value==="abo"||value==="abou"||value==="about"||value==="about "||value==="about u"||value==="about us"){
    window.location="../about_us/about_us.html";
    }
    
}

