document.getElementByid("copybtn").onclick = function(){
    document.getElementByid("outputid").select();
    document.execCommand('copy');
}