package hra;

import hra.listenery.PripojeniListener;
import hra.listenery.RespawnHrace;
import hra.listenery.SmrtHrace;
import hra.teleporteri.commands.*;
import hra.teleporteri.listenery.*;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        //listenery
        getServer().getPluginManager().registerEvents(new VidlakListener(), this);
        getServer().getPluginManager().registerEvents(new GolemListener(), this);
        getServer().getPluginManager().registerEvents(new OhnivakListener(), this);
        getServer().getPluginManager().registerEvents(new LucistnikListener(), this);
        getServer().getPluginManager().registerEvents(new DuchListener(), this);
        getServer().getPluginManager().registerEvents(new SmrtHrace(), this);
        getServer().getPluginManager().registerEvents(new RespawnHrace(), this);
        getServer().getPluginManager().registerEvents(new PripojeniListener(), this);


        //commands
        getCommand("_Duch").setExecutor(new Duch());
        getCommand("_Golem").setExecutor(new Golem());
        getCommand("_Lucistnik").setExecutor(new Lucistnik());
        getCommand("_Ohnivak").setExecutor(new Ohnivak());
        getCommand("_Vidlak").setExecutor(new Vidlak());
    }
}