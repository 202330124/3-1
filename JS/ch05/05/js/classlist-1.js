const title = document.querySelector("#title");

title.onclick = function() {
    /*
    if(!title.classList.contains("clicked")) {
        title.classList.add("clicked");
    }

    else {
        title.classList.remove("clicked");
    }
    */

    title.classList.toggle("clicked");
}