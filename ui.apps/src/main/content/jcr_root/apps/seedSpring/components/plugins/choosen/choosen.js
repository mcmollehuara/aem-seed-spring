// Created my micom

'use strict';
var global = this;

use(function () {
    // var data = [{ id: 1, value: "Sheryl" }, { id: 2, value: "Valeria" }, { id: 3, value: "Luana" }, { id: 4, value: "Mikela" }];
    // var data = [{ "id": "1", "value": "Sheryl" }, { "id": "2", "value": "Valeria" }, { "id": "3", "value": "Luana" }, { "id": "4", "value": "Mikela" }];
    var elements = properties.get("data", "");
    var _data = [];
    
    if (elements != "") {
        try {
            var data = [];
            data = JSON.parse(elements);
            _data = data;
        }
        catch (error) {
            if (error instanceof SyntaxError) {
                console.log(error.message);
            }
            else {
                throw error;
            }
        }
    }
    else {
        _data = ["Default"];
    }

    return {
        list: _data
    };
});