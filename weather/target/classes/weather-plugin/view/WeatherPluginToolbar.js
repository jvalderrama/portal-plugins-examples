Ext.define('Stackops.portal.plugin.weather-plugin.view.WeatherPluginToolbar', {
    extend : 'Ext.toolbar.Toolbar',
    alias : 'widget.myplugintoolbar',
    layout: {
        overflowHandler: 'Menu'
    },
    items : [{
        xtype : 'button',
        text: Portal.getText('weather-plugin', 'demoButton')
    }]
}); 