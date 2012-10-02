Ext.define("Stackops.portal.plugin.weather-plugin.locale.Language",{languages:{es:{pluginName:"Weather Plugin",success:"La temperatura es ",error:"Error al momento de consultar el clima ",demoButton:"Botón"},en:{pluginName:"Weather Plugin",success:"The weather is ",error:"Error at the moment to retrieve the weather ",demoButton:"Button"}}});Ext.define("Stackops.portal.plugin.weather-plugin.WeatherPluginDescriptor",{extend:"Stackops.portal.PluginDescriptor",controllers:[],requires:[],debug:true,id:"weather-plugin-win",shortcutTitle:Portal.getText("weather-plugin","pluginName"),shortcutCls:"myplugin-shortcut",init:function(){this.launcher={text:Portal.getText("weather-plugin","pluginName"),handler:this.createWindow,iconCls:"myplugin-icon",scope:this}
},createWindow:function(){var b=this.app.getDesktop();
var a=b.getWindow(this.id);
if(!a){a=b.createWindow({id:this.id,title:Portal.getText("weather-plugin","pluginName"),width:900,height:480,iconCls:"weather-icon",animCollapse:false,constrainHeader:true,layout:"fit",items:[]})
}Ext.Ajax.request({url:"http://free.worldweatheronline.com/feed/weather.ashx",params:{q:"Madrid",format:"json",num_of_days:5,key:"40b9a71681142740120110"},method:"GET",scope:this,callback:function(d,g,c){console.log("reponse: "+c.responseText);
var e=this,f;
if(g==false){Ext.Msg.show({msg:Portal.getText("weather-plugin","error"),icon:Ext.Msg.ERROR,buttons:Ext.Msg.OK,scope:e})
}else{if(c.responseText!=null){f=Ext.decode(c.responseText)
}else{f=null
}if(f!=null){description=f.data.current_condition[0].temp_C
}else{description="no data retrieved"
}Ext.Msg.show({msg:Portal.getText("weather-plugin","success")+description,icon:Ext.Msg.INFO,buttons:Ext.Msg.OK,scope:e})
}}});
return a
}});