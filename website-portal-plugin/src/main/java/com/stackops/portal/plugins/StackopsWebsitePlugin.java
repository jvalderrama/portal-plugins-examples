/*
 * Portal App
 * Copyright (C) 2012 Stackops Technologies
 */
package com.stackops.portal.plugins;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import net.xeoh.plugins.base.annotations.PluginImplementation;

import com.stackops.portal.plugin.api.IframePlugin;
import com.stackops.portal.plugin.api.PortalPlugin;

/**
 * Demo plugin implementation.
 * Created from archetype.
 *
 */
@PluginImplementation
public class StackopsWebsitePlugin implements IframePlugin {

    public static final String MY_PLUGIN_ROLE = "MY_PLUGIN_ROLE";

    /* (non-Javadoc)
     * @see com.stackops.portal.plugin.api.PortalPlugin#getKee()
     */
    @Override
    public String getKee() {
        return "stackops-website";
    }

    /* (non-Javadoc)
     * @see com.stackops.portal.plugin.api.PortalPlugin#getName()
     */
    @Override
    public String getName() {
        return "Website Portal Plugin";
    }

    /* (non-Javadoc)
     * @see com.stackops.portal.plugin.api.PortalPlugin#getVersion()
     */
    @Override
    public String getVersion() {
        return "1.0.0-RC1";
    }

    /* (non-Javadoc)
     * @see com.stackops.portal.plugin.api.PortalPlugin#getDescription()
     */
    @Override
    public String getDescription() {
        return "Plugin IFrame to documentation from Stackops Website";
    }

    /* (non-Javadoc)
     * @see com.stackops.portal.plugin.api.PortalPlugin#getDescriptorClassFile()
     */
    @Override
    public String getDescriptorClassFile() {
        return "StackopsWebsitePluginDescriptor";
    }

    /* (non-Javadoc)
     * @see com.stackops.portal.plugin.api.PortalPlugin#getLanguagesClassFile()
     */
    @Override
    public String getLanguagesClassFile() {
        return "locale.Language";
    }

    /* (non-Javadoc)
     * @see com.stackops.portal.plugin.api.PortalPlugin#getConfiguration()
     */
    @Override
    public Properties getConfiguration() {
        return null;
    }

    /* (non-Javadoc)
     * @see com.stackops.portal.plugin.api.PortalPlugin#getRequiredRole()
     */
    @Override
    public List<String> getRequiredRoles() {
        ArrayList<String> roles = new ArrayList<String>();
        roles.add(PortalPlugin.ROLE_ADMIN);
        roles.add(MY_PLUGIN_ROLE);
        return roles;
    }

    /* (non-Javadoc)
     * @see com.stackops.portal.plugin.api.IframePlugin#getIframeURL()
     */
    @Override
    public String getIframeURL() {
        return "http://www.stackops.com";
    }

    /* (non-Javadoc)
     * @see com.stackops.portal.plugin.api.PortalPlugin#getCSSFile()
     */
    @Override
    public String getCSSFile() {
        return "css/StackopsWebsite.css";
    }
}
