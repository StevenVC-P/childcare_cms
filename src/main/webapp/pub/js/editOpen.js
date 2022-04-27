const addForm = $('#addForm');
const editBtn = $('.edit');

function f1(object){
    const row = object.parentElement.parentElement.nextElementSibling;

        if (row.style.visibility==="hidden") {
            row.style.visibility='visible';
            row.style.display='block';
        } else {
            row.style.visibility = 'hidden';
            row.style.display = 'none';
        }

    for(let i= 0; i< addForm.length; i++) {
        if (addForm[i].style.visibility === "hidden") {
            addForm[i].style.visibility = 'visible';
            addForm[i].style.display = 'block';
        } else {
            addForm[i].style.visibility = 'hidden';
            addForm[i].style.display = 'none';
        }
    }

    for(let i= 0; i< editBtn.length; i++)
        if (editBtn[i].disabled == true) {
        console.log("btn - true")
        editBtn[i].disabled = false;
    } else {
        console.log("btn - false")
        editBtn[i].disabled = true;
    }
}