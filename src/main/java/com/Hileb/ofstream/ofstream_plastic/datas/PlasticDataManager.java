package com.Hileb.ofstream.ofstream_plastic.datas;

import com.Hileb.ofstream.OfstreamPlastic;
import com.Hileb.ofstream.ofstream.DataManager;
import com.Hileb.ofstream.ofstream.IDataOfstream;
import com.Hileb.ofstream.ofstream.OfstreamEvent;
import cpw.mods.modlauncher.api.ITransformationService;
import net.minecraft.client.Minecraft;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.MutableRegistry;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLServiceProvider;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.server.ServerMain;
import net.minecraftforge.server.command.CommandDimensions;
import net.minecraftforge.userdev.FMLDevServerLaunchProvider;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = OfstreamPlastic.MODID)
public class PlasticDataManager {
    public static DataManager POTIONS=new DataManager("potion");
    public static DataManager ENCH=new DataManager("enchantment");
    public static DataManager DIM=new DataManager("dimension");


    @SubscribeEvent
    public static void onRegister(OfstreamEvent.Register event){
        try {
            POTIONS.clear();
            ENCH.clear();
            DIM.clear();

            registerAllDimension();
            registerAllPotions();
            registerAllEnchantment();

            event.register(POTIONS.getRegisterObject());
            event.register(ENCH.getRegisterObject());
            event.register(DIM.getRegisterObject());
        }catch (Exception e){
            OfstreamPlastic.LOGGER.error(e);
            throw new RuntimeException(e);
        }
    }



    public static void registerAllPotions(){
        for(ResourceLocation resourceLocation: ForgeRegistries.POTIONS.getKeys()){
            POTIONS.register(resourceLocation.getNamespace(),new com.Hileb.ofstream.ofstream_plastic.datas.DataPotion(Objects.requireNonNull(ForgeRegistries.POTIONS.getValue(resourceLocation))));
        }
    }

    public static void registerAllEnchantment(){
        for(ResourceLocation resourceLocation:ForgeRegistries.ENCHANTMENTS.getKeys()){
            ENCH.register(resourceLocation.getNamespace(),new com.Hileb.ofstream.ofstream_plastic.datas.DataEnchantmant(Objects.requireNonNull(ForgeRegistries.ENCHANTMENTS.getValue(resourceLocation))));
        }
    }

    public static void registerAllDimension(){
        Registry<DimensionType> dimensionTypes= DynamicRegistries.func_239770_b_().getRegistry(Registry.DIMENSION_TYPE_KEY);

        for(ResourceLocation resourceLocation: dimensionTypes.keySet()){
            DIM.register(resourceLocation.getNamespace(),new com.Hileb.ofstream.ofstream_plastic.datas.DataDimension(resourceLocation,Objects.requireNonNull(dimensionTypes.getOrDefault(resourceLocation))));
        }
    }


    public static void registerSomeBody(IForgeRegistry forgeRegistry,OfstreamEvent.Register event){
        DataManager dataManager=new DataManager(forgeRegistry.getRegistryName().toString());
        for (Object object:forgeRegistry.getKeys()){
            if (object instanceof ResourceLocation){
                ResourceLocation resourceLocation=(ResourceLocation)object;
                dataManager.register(resourceLocation.getNamespace(),new CommonRegister(resourceLocation.toString()));
            }
        }
        event.register(dataManager.getRegisterObject());
    }
    public static class CommonRegister implements IDataOfstream{
        public String registerName;
        public CommonRegister(String name){
            registerName=name;
        }
    }
}
