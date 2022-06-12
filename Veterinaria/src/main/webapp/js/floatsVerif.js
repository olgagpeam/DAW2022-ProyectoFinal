const btn = document.getElementById('button');
const isValid = /^(\d+)$|^(\d+\.{1}\d{2})$|^(\d+\.{1})$|^(\d+\.{1}\d{1})$/;
btn.addEventListener('click', (event) => {
    event.preventDefault();
    let pC = document.getElementById('pC').value;
    let pV = document.getElementById('pV').value;
    var id = document.getElementById('id').value;
    var name = document.getElementById('name').value;
    let form = document.getElementById('formIN');
    if (id === '') {
        alert('Ingrese un ID');
        return;
    }
    if (name === '') {
        alert('Ingrese un Nombre');
        return;
    }
    if (pC === '' | pV === '') {
        if (isValid.test(pC) | isValid.test(pV)) {
            form.submit();
        } else {
            alert('Formato no válido');
        }
        if(pC === '' & pV === ''){
            form.submit();
        }
    } else {
        if (!isValid.test(pC) | !isValid.test(pV)) {
            alert('Formato no válido');
        } else {
            form.submit();
        }
    }
});