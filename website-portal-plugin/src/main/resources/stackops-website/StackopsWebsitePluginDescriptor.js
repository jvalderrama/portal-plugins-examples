Ext.define('Stackops.portal.plugin.stackops-website.StackopsWebsitePluginDescriptor', {
    extend: 'Stackops.portal.PluginDescriptor',
    controllers: [],
    debug: true,
    id: 'stackops-website-win',
    shortcutTitle: Portal.getText('stackops-website', 'pluginName'),
    shortcutCls: 'myplugin-shortcut',
    init : function(){
        this.launcher = {
            text: Portal.getText('stackops-website', 'pluginName'),
            iconCls: 'myplugin-icon',
            handler : this.createWindow,
            scope: this
        };
    },
    createWindow : function() {
        var me = this;
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(this.id);
        if(!win){
            win = desktop.createWindow({
                id: this.id,
                title: Portal.getText('stackops-website', 'pluginName'),
                width:900,
                height:480,
                animCollapse:false,
                constrainHeader:true,
                iconCls: 'myplugin-icon',
                layout: 'fit',
                items: [{
                    xtype: 'component',
                    autoEl: {
                        tag: 'iframe',
                        src: me.iframeURL
                    }
                }]
            });
        }
        win.show();
        return win;
    }
});
