/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function randomNumberGenerator(){
    var x= Math.floor((Math.random() * 6)+1);
    return x;
}
function additionQuestion(){
    var output;
    var a=randomNumberGenerator();
    var b=randomNumberGenerator();
    var ans =a+b;
    var equation=a+"+"+b;
    var userInput=parseInt(prompt(equation));
    if(ans===userInput){
        output="Correct! "+a+"+"+b+"="+ans;
    }
    else{
        output="Incorrect! "+a+"+"+b+"="+ans;
    }
    return output;
}
function subtractionQuestion(){
    var output;
    var a=randomNumberGenerator();
    var b=randomNumberGenerator();
    var ans =a-b;
    var equation=a+"-"+b;
    var userInput=parseInt(prompt(equation));
    if(ans===userInput){
        output="Correct! "+a+"-"+b+"="+ans;
    }
    else{
        output="Incorrect! "+a+"-"+b+"="+ans;
    }
    return output;
}
function divisionQuestion(){
    var output;
    var a=randomNumberGenerator();
    var b=randomNumberGenerator();
    var ans =a/b;
    var equation=a+"/"+b;
    var userInput=parseFloat(prompt(equation));
    if(ans===userInput){
        output="Correct! "+a+"/"+b+"="+ans;
    }
    else{
        output="Incorrect! "+a+"/"+b+"="+ans;
    }
    return output;
}
function multiplicationQuestion(){
    var output;
    var a=randomNumberGenerator();
    var b=randomNumberGenerator();
    var ans =a*b;
    var equation=a+"*"+b;
    var userInput=parseInt(prompt(equation));
    if(ans===userInput){
        output="Correct! "+a+"*"+b+"="+ans;
    }
    else{
        output="Incorrect! "+a+"*"+b+"="+ans;
    }
    return output;
}
function logOut(){
    var userInput=parseInt(prompt("Enter 1 to confirm you want to log out"));
    if (userInput===1){
            window.location.href='../index.php';
        }
}
