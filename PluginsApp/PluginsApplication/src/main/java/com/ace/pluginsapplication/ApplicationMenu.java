/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ace.pluginsapplication;

import com.ace.pluginsapplication.interfaces.IPluginsAppPlugin;
import com.ace.pluginsapplication.interfaces.IShape;
import java.util.ArrayList;

/**
 *
 * @author catalin
 */
public class ApplicationMenu{
    
    private PluginManager pluginMan;
    private Menu mainMenu = null;
    public ApplicationMenu(PluginManager pluginMan)
    {
        this.pluginMan = pluginMan;                
    }
    
    public void load()
    {
        pluginMan.loadPlugins("/plugins");
        ArrayList<IMenuItem> menuItems = new ArrayList();
        
        int shortCut = 1;
        var plugins = pluginMan.getPlugins();
        
        for (int i = 0 ; i < plugins.size(); i++)
        {      
           var currentPlugin = plugins.get(i); 
           MenuItem currentItem = new MenuItem(plugins.get(i).getDisplayText(), shortCut++, (parameters)->{
               IShape shape = currentPlugin.getShape();
               shape.read();
           });
           menuItems.add(currentItem);
       
        }
        mainMenu = new Menu("Main Menu", -1, menuItems);
        
    }
    
    public void execute()
    {
        mainMenu.execute();
    }
    
}
