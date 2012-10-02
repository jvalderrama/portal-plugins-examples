Ext.define('Stackops.portal.plugin.weather-plugin.view.WeatherPluginPanel', {
    extend : 'Ext.Panel',
    alias : 'widget.mypluginpanel',
    requires: ['Stackops.portal.plugin.weather-plugin.view.WeatherPluginToolbar'],
    id : 'empty_tab_view',
    title : 'Empty app',
    layout : {
        type: 'vbox',
        align: 'stretch'
    },
    items : [{
        height: 40,
        xtype: 'myplugintoolbar',
    }],
    minWidth : 340,
    minHeight : 450,
    autoScroll : true
}); 