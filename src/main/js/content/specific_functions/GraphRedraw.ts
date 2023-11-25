let graph = document.querySelector(".svg-graph");

let element = document.querySelector("#graph_points");

function checkBounds(x: number, y: number, r: number) {


    if (x < -5 || x > 5 || y < -5 || y > 3 || r < 1 || r > 4) {
        return false;
    }
    if ((x <= 0) && (y >= 0) && ((x * x + y * y) <= r * r)) {
        return true;
    } else if ((x <= 0) && (y <= 0) && (y >= (-2 * x - r))) {
        return true;
    } else return (x >= 0) && (y <= 0) && (x <= r / 2) && (y >= -r);
}

export default function redraw(r: number) {
    element!.innerHTML = "";
    let x_arr = document.querySelectorAll("#x-col");
    let y_arr = document.querySelectorAll("#y-col");
    let hit_arr = document.querySelectorAll("#hit-col");
    // let r = document.querySelector("#form-block:r");
    // console.log(r);

    for (let i = 0; i < x_arr.length; i++) {
        let x = x_arr[i] as HTMLInputElement
        let y = y_arr[i] as HTMLInputElement
        let hit = hit_arr[i] as HTMLInputElement
        // console.log(parseFloat(x.innerHTML))
        // console.log(x)

        let x_float = (150 + parseFloat(x.innerHTML) * 120 / r);
        let y_float = (150 - parseFloat(y.innerHTML) * 120 / r);
        let circle = document.createElementNS("http://www.w3.org/2000/svg", "circle");
        circle.setAttribute("cx", "" + x_float);
        circle.setAttribute("cy", "" + y_float);
        circle.setAttribute("r", "4");
        // console.log(hit.innerHTML)
        let color;
        console.log(parseFloat(x.innerHTML), parseFloat(y.innerHTML), r);
        if (checkBounds(parseFloat(x.innerHTML), parseFloat(y.innerHTML), r)) {
            color = "green"
        } else {
            color = "red"
        }
        console.log(color)
        circle.setAttribute('style', 'fill:' + color + '; stroke: black; stroke-width: 2;');
        // console.log(circle);
        element?.appendChild(circle);
        // graph?.appendChild(circle);
    }
}

