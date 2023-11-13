import validation, { validateR } from "./utils/Validation";
import { rTextListening, xButtonsListening, yTextListening } from "./specific_functions/ButtonsListening";
import { getR, getRErrorField, getX, getXErrorField, getY, getYErrorField } from "./specific_functions/SelectionResults";
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

let r_block = document.getElementById('form-block:r-input-block') as HTMLInputElement;
let r: any = null;
r_block.addEventListener("mouseover", function () {
    setTimeout(() => {
        r = document.getElementById('form-block:r') as HTMLInputElement;
        if (validateR()) {

            redraw(parseFloat(r.value));
        }
    }, 600)

})

r_block.addEventListener("input", function () {
    setTimeout(() => {
        r = document.getElementById('form-block:r') as HTMLInputElement;
        if (validateR()) {
            redraw(parseFloat(r.value));
        }
    }, 600)
})



document.querySelector("#form-submit")!.addEventListener("click", function () {
    if (validateR()) {
        redraw(parseFloat(r.value));
    }
})



function addRowToTable(html: string) {
    document.querySelector("#hit-results")!.innerHTML += html;
}




