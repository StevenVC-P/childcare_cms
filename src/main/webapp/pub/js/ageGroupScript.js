
function f1(object){
    const row = object.parentElement.parentElement.nextElementSibling;
    console.log(row.length)

        if (row.style.visibility==="hidden") {
            row.style.visibility='visible';
            row.style.display='block';
        } else {
            row.style.visibility = 'hidden';
            row.style.display = 'none';
        }
}