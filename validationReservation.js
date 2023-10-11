var submitButton = document.getElementById('submitBtn');
var reservationForm = document.getElementById('reservationForm');

submitButton.addEventListener('click', function () {
    var inputs = reservationForm.getElementsByTagName('input');
    var isValid = true;

    for (var i = 0; i < inputs.length; i++) {
        var input = inputs[i];
        if (input.required && input.value.trim() === '') {
            isValid = false;
            input.classList.add('is-invalid');
        } else if (input.id === 'phone') {
            var phoneValue = input.value.replace(/[^0-9]/g, '');
            if (phoneValue.length !== 12) {
                isValid = false;
                input.classList.add('is-invalid');
            }
        }
    }

    var dateInput = document.getElementById('date');
    if (dateInput.value.trim() === '') {
        isValid = false;
        dateInput.classList.add('is-invalid');
    }

    var timeInput = document.getElementById('time');
    if (timeInput.value.trim() === '') {
        isValid = false;
        timeInput.classList.add('is-invalid');
    }

    if (isValid) {
        window.location.href = "TicketPage.html";
    }
});