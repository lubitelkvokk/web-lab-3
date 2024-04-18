/*
 * ATTENTION: The "eval" devtool has been used (maybe by default in mode: "development").
 * This devtool is neither made for production nor for readable output files.
 * It uses "eval()" calls to create a separate source file in the browser devtools.
 * If you are trying to read the output file, select a different devtool (https://webpack.js.org/configuration/devtool/)
 * or disable the default devtool with "devtool: false".
 * If you are looking for production-ready output files, see mode: "production" (https://webpack.js.org/configuration/mode/).
 */
/******/ (() => { // webpackBootstrap
/******/ 	"use strict";
/******/ 	var __webpack_modules__ = ({

/***/ "./content/index.ts":
/*!**************************!*\
  !*** ./content/index.ts ***!
  \**************************/
/***/ (function(__unused_webpack_module, exports, __webpack_require__) {

eval("\nvar __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {\n    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }\n    return new (P || (P = Promise))(function (resolve, reject) {\n        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }\n        function rejected(value) { try { step(generator[\"throw\"](value)); } catch (e) { reject(e); } }\n        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }\n        step((generator = generator.apply(thisArg, _arguments || [])).next());\n    });\n};\nvar __importDefault = (this && this.__importDefault) || function (mod) {\n    return (mod && mod.__esModule) ? mod : { \"default\": mod };\n};\nObject.defineProperty(exports, \"__esModule\", ({ value: true }));\nconst Validation_1 = __webpack_require__(/*! ./utils/Validation */ \"./content/utils/Validation.ts\");\nconst GraphRedraw_1 = __importDefault(__webpack_require__(/*! ./specific_functions/GraphRedraw */ \"./content/specific_functions/GraphRedraw.ts\"));\nlet timeZone = Intl.DateTimeFormat().resolvedOptions().timeZone;\n//Прослушивание кнопки X\n// xButtonsListening();\n//Проверка на change Y\n// yTextListening();\n//Проверка на change Y\n// rTextListening();\n// graphClickListener();\n// document.querySelector(\".svg-graph\")!.addEventListener(\"click\", function () {\n//\n// })\nlet r_block = document.getElementById('form-block:r-input-block');\nlet r = null;\nfunction graphRedrawing() {\n    return __awaiter(this, void 0, void 0, function* () {\n        while (true) {\n            yield new Promise(resolve => setTimeout(resolve, 500));\n            r = document.getElementById('form-block:r');\n            if ((0, Validation_1.validateR)()) {\n                (0, GraphRedraw_1.default)(parseFloat(r.value));\n            }\n        }\n    });\n}\nsetTimeout(() => graphRedrawing(), 1000);\ndocument.querySelector(\"#form-submit\").addEventListener(\"click\", function () {\n    if ((0, Validation_1.validateR)()) {\n        (0, GraphRedraw_1.default)(parseFloat(r.value));\n    }\n});\nfunction addRowToTable(html) {\n    document.querySelector(\"#hit-results\").innerHTML += html;\n}\n\n\n//# sourceURL=webpack://web-lab-2/./content/index.ts?");

/***/ }),

/***/ "./content/specific_functions/GraphRedraw.ts":
/*!***************************************************!*\
  !*** ./content/specific_functions/GraphRedraw.ts ***!
  \***************************************************/
/***/ ((__unused_webpack_module, exports) => {

eval("\nObject.defineProperty(exports, \"__esModule\", ({ value: true }));\nlet graph = document.querySelector(\".svg-graph\");\nlet element = document.querySelector(\"#graph_points\");\nfunction checkBounds(x, y, r) {\n    if (x < -5 || x > 5 || y < -5 || y > 3 || r < 1 || r > 4) {\n        return false;\n    }\n    if ((x <= 0) && (y >= 0) && ((x * x + y * y) <= r * r)) {\n        return true;\n    }\n    else if ((x <= 0) && (y <= 0) && (y >= (-2 * x - r))) {\n        return true;\n    }\n    else\n        return (x >= 0) && (y <= 0) && (x <= r / 2) && (y >= -r);\n}\nfunction redraw(r) {\n    element.innerHTML = \"\";\n    let x_arr = document.querySelectorAll(\"#x-col\");\n    let y_arr = document.querySelectorAll(\"#y-col\");\n    let hit_arr = document.querySelectorAll(\"#hit-col\");\n    // let r = document.querySelector(\"#form-block:r\");\n    // console.log(r);\n    for (let i = 0; i < x_arr.length; i++) {\n        let x = x_arr[i];\n        let y = y_arr[i];\n        let hit = hit_arr[i];\n        // console.log(parseFloat(x.innerHTML))\n        // console.log(x)\n        let x_float = (150 + parseFloat(x.innerHTML) * 120 / r);\n        let y_float = (150 - parseFloat(y.innerHTML) * 120 / r);\n        let circle = document.createElementNS(\"http://www.w3.org/2000/svg\", \"circle\");\n        circle.setAttribute(\"cx\", \"\" + x_float);\n        circle.setAttribute(\"cy\", \"\" + y_float);\n        circle.setAttribute(\"r\", \"4\");\n        // console.log(hit.innerHTML)\n        let color;\n        console.log(parseFloat(x.innerHTML), parseFloat(y.innerHTML), r);\n        if (checkBounds(parseFloat(x.innerHTML), parseFloat(y.innerHTML), r)) {\n            color = \"green\";\n        }\n        else {\n            color = \"red\";\n        }\n        console.log(color);\n        circle.setAttribute('style', 'fill:' + color + '; stroke: black; stroke-width: 2;');\n        // console.log(circle);\n        element === null || element === void 0 ? void 0 : element.appendChild(circle);\n        // graph?.appendChild(circle);\n    }\n}\nexports[\"default\"] = redraw;\n\n\n//# sourceURL=webpack://web-lab-2/./content/specific_functions/GraphRedraw.ts?");

/***/ }),

/***/ "./content/specific_functions/SelectionResults.ts":
/*!********************************************************!*\
  !*** ./content/specific_functions/SelectionResults.ts ***!
  \********************************************************/
/***/ ((__unused_webpack_module, exports) => {

eval("\nObject.defineProperty(exports, \"__esModule\", ({ value: true }));\nexports.getRErrorField = exports.getYErrorField = exports.getXErrorField = exports.getValue = exports.getR = exports.getY = exports.getX = void 0;\nfunction getX() {\n    const xButtons = document.querySelectorAll('input[name=\"xChoice\"]');\n    for (let x of xButtons) {\n        if (x.classList.contains(\"active\")) {\n            if (x.value) {\n                return x;\n            }\n        }\n    }\n    return document.createElement(\"input\");\n}\nexports.getX = getX;\nfunction getY() {\n    const y = document.querySelector('input[name=\"yChoice\"]');\n    return y !== null ? y : document.createElement(\"input\");\n}\nexports.getY = getY;\nfunction getR() {\n    const r = document.querySelector('input[name=\"rChoice\"]');\n    return r !== null ? r : document.createElement(\"input\");\n}\nexports.getR = getR;\nfunction getValue(element) {\n    return element.value;\n}\nexports.getValue = getValue;\nfunction getXErrorField() {\n    return document.querySelector(\"#x-error\");\n}\nexports.getXErrorField = getXErrorField;\nfunction getYErrorField() {\n    return document.querySelector(\"#y-error\");\n}\nexports.getYErrorField = getYErrorField;\nfunction getRErrorField() {\n    return document.querySelector(\"#r-error\");\n}\nexports.getRErrorField = getRErrorField;\n\n\n//# sourceURL=webpack://web-lab-2/./content/specific_functions/SelectionResults.ts?");

/***/ }),

/***/ "./content/utils/Validation.ts":
/*!*************************************!*\
  !*** ./content/utils/Validation.ts ***!
  \*************************************/
/***/ ((__unused_webpack_module, exports, __webpack_require__) => {

eval("\nObject.defineProperty(exports, \"__esModule\", ({ value: true }));\nexports.cleanAllErrors = exports.validateR = exports.validateInputElement = void 0;\nconst SelectionResults_1 = __webpack_require__(/*! ../specific_functions/SelectionResults */ \"./content/specific_functions/SelectionResults.ts\");\nfunction validation(x, y, r, xError, yError, rError) {\n    let isValid = true;\n    if (!xError || !yError || !rError) {\n        console.error(\"Some fields for errors not exists or access\");\n        isValid = false;\n    }\n    // Проверка X\n    if ((x === null || x === void 0 ? void 0 : x.value) == \"\") {\n        xError.textContent = \"Value X must be chosen\";\n        isValid = false;\n    }\n    else {\n        xError.textContent = \"\";\n    }\n    // Проверка y\n    if (y.value == \"\" || y == null) {\n        yError.textContent = \"Value Y must be chosen\";\n        isValid = false;\n    }\n    else {\n        let y_number = parseFloat(y.value.slice(0, 5));\n        // console.log(/^\\s*[0-9]+.?[0-9]*\\s*$/.test(y.value));\n        // console.log(!(/^\\s*[0-9]+.?[0-9]*\\s*$/.test(y.value)) || (y_number <= -5 || y_number >= 5))\n        if (!(/^\\s*-?[0-9]+\\.?[0-9]*\\s*$/.test(y.value)) || (y_number <= -5 || y_number >= 5)) {\n            yError.textContent = \"-5 < Y < 5\";\n            isValid = false;\n        }\n        else {\n            yError.textContent = \"\";\n        }\n    }\n    // Проверка R\n    if (r.value == \"\" || r == null) {\n        rError.textContent = \"Value R must be chosen\";\n        isValid = false;\n    }\n    else {\n        let r_number = parseFloat(r.value.slice(0, 5));\n        // console.log(/^\\s*[0-9]+.?[0-9]*\\s*$/.test(y.value));\n        // console.log(!(/^\\s*[0-9]+.?[0-9]*\\s*$/.test(r.value)) || (r_number <= 2 || r_number >= 5))\n        if (!(/^\\s*[0-9]+.?[0-9]*\\s*$/.test(r.value)) || (r_number <= 2 || r_number >= 5)) {\n            rError.textContent = \"2 < R < 5\";\n            isValid = false;\n        }\n        else {\n            rError.textContent = \"\";\n        }\n    }\n    return isValid;\n}\nexports[\"default\"] = validation;\nfunction validateInputElement(r, rError, lowerLimit, upperLimit) {\n    let isValid = true;\n    // Проверка R\n    if (r.value == \"\" || r == null) {\n        // rError!.textContent = `Value must be chosen`;\n        isValid = false;\n    }\n    else {\n        let r_number = parseFloat(r.value.slice(0, 5));\n        // console.log(/^\\s*[0-9]+.?[0-9]*\\s*$/.test(y.value));\n        // console.log(!(/^\\s*[0-9]+.?[0-9]*\\s*$/.test(r.value)) || (r_number <= 2 || r_number >= 5))\n        if (!(/^\\s*[0-9]+.?[0-9]*\\s*$/.test(r.value)) || (r_number < lowerLimit || r_number > upperLimit)) {\n            // rError!.textContent = `${lowerLimit} < R < ${upperLimit}`;\n            isValid = false;\n        }\n        else {\n            // rError!.textContent = \"\";\n        }\n    }\n    return isValid;\n}\nexports.validateInputElement = validateInputElement;\nfunction validateR() {\n    return validateInputElement(document.getElementById(\"form-block:r\"), (0, SelectionResults_1.getRErrorField)(), 1, 4);\n}\nexports.validateR = validateR;\nfunction cleanAllErrors() {\n    let x_error = (0, SelectionResults_1.getXErrorField)();\n    let y_error = (0, SelectionResults_1.getYErrorField)();\n    let r_error = (0, SelectionResults_1.getRErrorField)();\n    // console.log(y_error!.textContent);\n    if (x_error !== null) {\n        x_error.textContent = \"\";\n    }\n    if (y_error !== null) {\n        y_error.textContent = \"\";\n    }\n    if (r_error !== null) {\n        r_error.textContent = \"\";\n    }\n}\nexports.cleanAllErrors = cleanAllErrors;\n\n\n//# sourceURL=webpack://web-lab-2/./content/utils/Validation.ts?");

/***/ })

/******/ 	});
/************************************************************************/
/******/ 	// The module cache
/******/ 	var __webpack_module_cache__ = {};
/******/ 	
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/ 		// Check if module is in cache
/******/ 		var cachedModule = __webpack_module_cache__[moduleId];
/******/ 		if (cachedModule !== undefined) {
/******/ 			return cachedModule.exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = __webpack_module_cache__[moduleId] = {
/******/ 			// no module.id needed
/******/ 			// no module.loaded needed
/******/ 			exports: {}
/******/ 		};
/******/ 	
/******/ 		// Execute the module function
/******/ 		__webpack_modules__[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/ 	
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/ 	
/************************************************************************/
/******/ 	
/******/ 	// startup
/******/ 	// Load entry module and return exports
/******/ 	// This entry module is referenced by other modules so it can't be inlined
/******/ 	var __webpack_exports__ = __webpack_require__("./content/index.ts");
/******/ 	
/******/ })()
;