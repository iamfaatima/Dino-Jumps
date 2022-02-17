score = 0;
//var result = 0;
cross = true;
audio = new Audio('moosic.mp3');
audiogo= new Audio('moosic.mp3');
 setTimeout(() => {
           audio.play(); 
        }, 1000);  //stop it after 1000 milli secs
 
document.onkeydown = function(e){ //key is being pressed
    console.log("Key code is: ", e.keyCode)
    if(e.keyCode==38){ //arrow up ka keyCode
        dino = document.querySelector('.dino');
        dino.classList.add('animateDino');
        setTimeout(() => {
            dino.classList.remove('animateDino')
        }, 1000);
        /*this time is in milli seconds*/
    }
    if(e.keyCode==39){
        dino = document.querySelector('.dino');
       dinoX =  parseInt(window.getComputedStyle(dino, null).getPropertyValue('left'));
        dino.style.left= dinoX + 112+"px";
    }
     if(e.keyCode==37){
        dino = document.querySelector('.dino');
       dinoX =  parseInt(window.getComputedStyle(dino, null).getPropertyValue('left'));
        dino.style.left= (dinoX - 112)+"px";
    }
}
setInterval(() => { //do this body code for some interval
         dino = document.querySelector('.dino');
         gameOver = document.querySelector('.gameOver');
         obstacle =  document.querySelector('.obstacle');
    //x axis k hisaab se current left value dx se milygi
         dx = parseInt(window.getComputedStyle(dino, null).getPropertyValue('left'));
         dy = parseInt(window.getComputedStyle(dino, null).getPropertyValue('top'));
         ox = parseInt(window.getComputedStyle(obstacle, null).getPropertyValue('left'));
         oy = parseInt(window.getComputedStyle(obstacle, null).getPropertyValue('top'));
    
        offsetX = Math.abs(dx-ox); //absolute value
        //calculating these to detect collision
        offsetY = Math.abs(dy-oy);
    

   // console.log(offsetX , offsetY);
    if(offsetX < 73 && offsetY < 52){

        gameOver.innerHTML= "Game Over - Reload to start over";
        obstacle.classList.remove('obstacleAni');
        audiogo.play();
         setTimeout(() => {
           audiogo.pause();
           audio.pause();
        }, 1000);

        document.getElementById("scoreinput1").value = score;
        document.user.submit();
    }
    else if(offsetX < 145 && cross){
        score+=1;
        updateScore(score);
        cross= false;
        setTimeout(() => {
           cross = true;
        }, 1000);
         setTimeout(() => {
           cross = true;
        }, 500);
        //animation duration for obstacle
        aniDur = parseFloat(window.getComputedStyle(obstacle, null).getPropertyValue('animation-duration'));
        newDur = aniDur - 0.05;
        obstacle.style.animationDuration = newDur + 's';
    }
        }, 100);

        
function updateScore(score){
    scoreCont.innerHTML = score;
   // scoreCont2.innerHTML = score;
}