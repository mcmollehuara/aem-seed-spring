'use strict';
var global = this;

use(function () {
    var CONST = {
        FULL_WIDTH: 'useFullWidth',
        BACKGROUND_COLOR: 'backgroundColor'
    };

    var backgroundColor = global.granite.resource.properties[CONST.BACKGROUND_COLOR];
    var classBackgroundColor = 'gray-bg';
    var id = new Date();
    var numberId = id.getTime();
    var classList = '';
    
    if (backgroundColor) {
        classBackgroundColor = backgroundColor;
    }

    if (global.granite.resource.properties[CONST.FULL_WIDTH] == 'true') {
        classList += ' width-full';
    }

    return {
        classBackgroundColor: classBackgroundColor,
        classList: classList,
        identifier: numberId.toString()
    };
});