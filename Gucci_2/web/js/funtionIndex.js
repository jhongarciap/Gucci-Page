
function loadElementDynamically(url, elemento){
    var request = new XMLHttpRequest();
    request.open("GET", url, false);
    request.send(null);
    elemento.innerHTML = request.responseText;
}

function loatadd(){
    loadElementDynamically("options.html", document.getElementById("dynamicContent"));
}
