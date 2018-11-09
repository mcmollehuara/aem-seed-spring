// Created my micom

'use strict';
var global = this;

use(function () {
   
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

    textColor = properties.get('textColor', 'text-primary');
    backgroundColor = properties.get('backgroundColor', 'white-bg');
    alignment = properties.get('alignment', 'text-left');

    _padding = properties.get('padding', 'sm');
    _paddingType = properties.get('paddingType', 'padding');
    padding = _paddingType + '-' + _padding;

    _margin = properties.get('margin', 'none');
    _marginType = properties.get('marginType', 'margin');
    margin = _marginType + '-' + _margin;

    _border = properties.get('border', 'none');
    _borderType = properties.get('borderType', 'border');
    border = _borderType + '-' + _border;

    settings = textColor + ' ' + backgroundColor + ' ' + alignment + ' ' + padding + ' ' + margin + ' ' + border;
    
    return {
        utilSettings: settings,
        //TODO
        identifier: '123456789'
    };
});