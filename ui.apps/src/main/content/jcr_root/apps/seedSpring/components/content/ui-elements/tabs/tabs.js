// Created my micom

'use strict';
var global = this;

use(function () {
    var elements = properties.get("data", "");
    var _data = [];

    if (elements != "") {
        try {
            var data = [];
            data = JSON.parse(elements);
            // _data = data;
            data.forEach(function (element, index) {
                _data.push({ id: "index-" + index, active: index == 0 ? "active" : "", value: element });
            }, this);

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
        _data = [{ id: "index-0", active: "active", value: "Default" }];
    }

    return {
        list: _data
    };
});