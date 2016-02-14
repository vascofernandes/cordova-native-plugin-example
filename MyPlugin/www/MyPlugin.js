var exec = require('cordova/exec');


var MyPlugin = {};


MyPlugin.myDeal = function (successCallback, errorCallback) {
    exec(
        successCallback, // success callback function
        errorCallback, // error callback function
        'MyPlugin', // mapped to our native Java class called "CalendarPlugin"
        'myDeal', // with this action name
        []
    );
};
    
MyPlugin.toast = function (inputToast, successCallback, errorCallback) {
    exec(
        successCallback, // success callback function
        errorCallback, // error callback function
        'MyPlugin', // mapped to our native Java class called "CalendarPlugin"
        'toast', // with this action name
        [{ toast: inputToast }]
    );
};

module.exports = MyPlugin;