// Created my micom

'use strict';
var global = this;

use(function () {
    var elements = properties.get("data", "");
    var _data = [{ "header": [], "body": [] }];

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
        _data = {
            header: ["Name", "Last Name", "Nick Name"],
            body: [
                ["Mikela", "Condori", "Condorito"],
                ["Luana", "Condori", "Condorito"],
                ["Valeria", "Condori", "Condorito"],
                ["Sheryl", "Condori", "Condorito"]
            ]
        };
        // _data = {
        //     "header": ["Name", "Last Name", "Nick Name", "Email"],
        //     "body": [
        //         ["Mikela", "Condori", "Condorito", "mcondori@one.micom.com"],
        //         ["Luana", "Condori", "Condorito", "lcondori@one.micom.com"],
        //         ["Valeria", "Condori", "Condorito", "vcondori@one.micom.com"],
        //         ["Sheryl", "Condori", "Condorito", "scondori@one.micom.com"]
        //     ]
        // };
    }

    return {
        header: _data.header,
        body: _data.body
    };
});