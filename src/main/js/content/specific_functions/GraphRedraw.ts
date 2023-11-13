let graph = document.querySelector(".svg-graph");

let element = document.querySelector("#graph_points");


export default function redraw(r:number) {
    element!.innerHTML = "";
    let x_arr = document.querySelectorAll("#x-col");
    let y_arr = document.querySelectorAll("#y-col");


    // console.log(r);

    for (let i = 0; i < x_arr.length; i++) {
        let x = x_arr[i] as HTMLInputElement
        let y = y_arr[i] as HTMLInputElement

        // console.log(parseFloat(x.innerHTML))
        // console.log(x)
        let circle = document.createElementNS("http://www.w3.org/2000/svg", "circle");
        circle.setAttribute("cx", "" + (150 + parseFloat(x.innerHTML) * 120 / r));
        circle.setAttribute("cy", "" + (150 - parseFloat(y.innerHTML) * 120 / r));
        circle.setAttribute("r", "2");
        circle.setAttribute('style', 'fill: blue; stroke: black; stroke-width: 2;');
        // console.log(circle);
        element?.appendChild(circle);
        // graph?.appendChild(circle);
    }
}
