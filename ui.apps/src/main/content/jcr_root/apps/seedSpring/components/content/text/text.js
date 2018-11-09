"use strict";

use(["/libs/wcm/foundation/components/utils/AuthoringUtils.js"], function (AuthoringUtils) {

    var CONST = {
        PROP_TEXT: "text",
        PROP_RICH_FORMAT: "textIsRich",
        CONTEXT_TEXT: "text",
        CONTEXT_HTML: "html"
    };

    var text = {};

    // The actual text content
    text.text = granite.resource.properties[CONST.PROP_TEXT]
        || "";

    // Wether the text contains HTML or not
    text.context = granite.resource.properties[CONST.PROP_RICH_FORMAT]
        ? CONST.CONTEXT_HTML : CONST.CONTEXT_TEXT

    // Set up placeholder if empty
    if (!text.text) {
        text.context = CONST.CONTEXT_TEXT;

        // only dysplay placeholder in edit mode
        if (typeof wcmmode != "undefined" && wcmmode.isEdit()) {
            text.cssClass = AuthoringUtils.isTouch
                ? "cq-placeholder"
                : "cq-text-placeholder-ipe";

            text.text = AuthoringUtils.isTouch
                ? ""
                : "Edit text";
        } else {
            text.text = "";
        }
    }

    // Adding the constants to the exposed API
    text.CONST = CONST;


    //TODO: Factorization
    var textColor = '';
    var backgroundColor = '';
    var alignment = '';
    var padding = '';
    var _padding = '';
    var _paddingType = '';
    var margin = '';
    var _margin = '';
    var _marginType = '';
    var border = '';
    var _border = '';
    var _borderType = ''

    var settings = '';

    textColor = properties.get('textColor', '');
    backgroundColor = properties.get('backgroundColor', '');
    alignment = properties.get('alignment', '');

    _padding = properties.get('padding', '');
    _paddingType = properties.get('paddingType', '');

    if (_padding && _paddingType) {
        padding = _paddingType + '-' + _padding;
    }


    _margin = properties.get('margin', '');
    _marginType = properties.get('marginType', '');

    if (_margin && _marginType) {
        margin = _marginType + '-' + _margin;
    }

    _border = properties.get('border', '');
    _borderType = properties.get('borderType', '');

    if (_border && _borderType) {
        border = _borderType + '-' + _border;
    }

    settings = textColor + ' ' + backgroundColor + ' ' + alignment + ' ' + padding + ' ' + margin + ' ' + border;
    ///////////////////////////////////////

    text.settings = settings;
    return text;

});
