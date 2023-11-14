import validation, {validateR} from "./utils/Validation";
import {rTextListening, xButtonsListening, yTextListening} from "./specific_functions/ButtonsListening";
import {getR, getRErrorField, getX, getXErrorField, getY, getYErrorField} from "./specific_functions/SelectionResults";
import graphClickListener from "./utils/GraphClickCoordinates";
import redraw from "./specific_functions/GraphRedraw";


let timeZone = Intl.DateTimeFormat().resolvedOptions().timeZone;
//Прослушивание кнопки X
// xButtonsListening();

//Проверка на change Y
// yTextListening();

//Проверка на change Y
// rTextListening();

// graphClickListener();

// document.querySelector(".svg-graph")!.addEventListener("click", function () {
//
// })


let r_block = document.getElementById('form-block:r-input-block') as HTMLInputElement;
let r: any = null;


async function graphRedrawing() {
    while (true) {
        await new Promise(resolve => setTimeout(resolve, 500));
        r = document.getElementById('form-block:r') as HTMLInputElement;
        if (validateR()) {
            redraw(parseFloat(r.value));
        }
    }
}

setTimeout(() => graphRedrawing(), 1000)


document.querySelector("#form-submit")!.addEventListener("click", function () {
    if (validateR()) {
        redraw(parseFloat(r.value));
    }
})


function addRowToTable(html: string) {
    document.querySelector("#hit-results")!.innerHTML += html;
}




