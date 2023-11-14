const intervalMS = 5000;
function initClock() {
    setDateTime();
    setInterval(setDateTime, intervalMS);
}

function addLeadingZero(number : number) {
    return (number < 10) ? '0' + number : number;
}

function setDate(date : Date) {
    let day: string | number = date.getDate();
    let month: string | number = date.getMonth() + 1;
    let year = date.getFullYear();

    day  = addLeadingZero(day)
    month = addLeadingZero(month)

    $('.clock-date').html(`${day}.${month}.${year}`);
}

function setTime(date: Date) {
    let hours: string | number = date.getHours();
    let minutes: string | number = date.getMinutes();
    let seconds: string | number = date.getSeconds();

    hours = addLeadingZero(hours);
    minutes = addLeadingZero(minutes);
    seconds = addLeadingZero(seconds);

    $('.clock-time').html(`${hours}:${minutes}:${seconds}`);
}

function setDateTime() {
    let date = new Date();
    setDate(date);
    setTime(date);
}

window.addEventListener("load", initClock, false);