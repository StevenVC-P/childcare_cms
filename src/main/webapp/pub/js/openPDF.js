const invoiceName = document.getElementsByName('invoice');

function f1(){
    for(i = 0; i < invoiceName.length; i++) {
        if(invoiceName[i].checked) {
            window.open('/Export/PrintPdf/' + invoiceName[i].value);
        }
    }
}
