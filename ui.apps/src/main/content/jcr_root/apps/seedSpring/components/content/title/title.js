'use strict';

var global = this;
use(function () {
    var _type = properties.get('type', 'h1');
    var _isBig = properties.get('isBig', false);
    var _typeValue = '';

    if (_isBig == true) {
        _typeValue = _typeValue + ' big';
    }

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
    return {
        settings: settings,
        type: _type,
        typeValue: _typeValue,
        isBig: _isBig
    };
});
