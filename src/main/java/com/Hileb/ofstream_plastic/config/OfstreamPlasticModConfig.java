package com.Hileb.ofstream_plastic.config;

import com.Hileb.ofstream_plastic.OfstreamPlastic;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


@Config(modid = OfstreamPlastic.MODID, category = "")
public class OfstreamPlasticModConfig {
    @Mod.EventBusSubscriber(modid = OfstreamPlastic.MODID)
    private static class EventHandler {

        private EventHandler() {
        }

        @SubscribeEvent
        public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(OfstreamPlastic.MODID)) {
                ConfigManager.sync(OfstreamPlastic.MODID, Config.Type.INSTANCE);
            }
        }
    }

    @Config.LangKey("")
    @Config.Comment("")
    @Config.RequiresMcRestart
    public static ModConfigInstance instance=new ModConfigInstance();

    public static class ModConfigInstance {
        @Config.LangKey("")
        @Config.Comment("")
        @Config.RequiresMcRestart
        public boolean ignoreNoImagePotion=true;
    }

}
