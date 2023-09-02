package com.Hileb.ofstream_plastic.datas;

import com.Hileb.ofstream.ofstream.DataManager;
import com.Hileb.ofstream.ofstream.OfstreamEvent;
import com.Hileb.ofstream_plastic.OfstreamPlastic;
import com.Hileb.ofstream_plastic.config.OfstreamPlasticModConfig;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

@Mod.EventBusSubscriber(modid = OfstreamPlastic.MODID)
public class PlasticDataManager {
    public static DataManager POTIONS=new DataManager("potion");
    public static DataManager ENCH=new DataManager("enchantment");
    public static DataManager DIM=new DataManager("dimension");
    @SubscribeEvent
    public static void onRegister(OfstreamEvent.Register event){
        POTIONS.clear();
        ENCH.clear();
        DIM.clear();

        registerAllDimension();
        registerAllPotions();
        registerAllEnchantment();

        event.register(POTIONS.getRegisterObject());
        event.register(ENCH.getRegisterObject());
        event.register(DIM.getRegisterObject());
    }



    public static void registerAllPotions(){
        for(ResourceLocation resourceLocation:ForgeRegistries.POTIONS.getKeys()){
            Potion potion=ForgeRegistries.POTIONS.getValue(resourceLocation);
            DataPotion dataPotion=new DataPotion(potion);
            boolean can=true;
            if (OfstreamPlasticModConfig.instance.ignoreNoImagePotion){

                if (!potion.shouldRender(new PotionEffect(potion))){
                    can=false;
                    continue;
                }else if ("iVBORw0KGgoAAAANSUhEUgAAACQAAAAkCAYAAADhAJiYAAAAHElEQVR42u3BMQEAAADCoPVPbQdvoAAAAAAAfgMUZAABkfZsKAAAAABJRU5ErkJggg==".equals(dataPotion.smallIcon)){
                    can=false;
                    continue;
                }else if ("iVBORw0KGgoAAAANSUhEUgAAAJAAAACQCAYAAADnRuK4AAAAZ0lEQVR42u3BMQEAAADCoPVP7WkJoAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA4AZEnwABe4vReQAAAABJRU5ErkJggg==".equals(dataPotion.largeIcon)){
                    can=false;
                    continue;
                }
            }
            if (can)POTIONS.register(resourceLocation.getResourceDomain(),dataPotion);
        }
    }

    public static void registerAllEnchantment(){
        for(ResourceLocation resourceLocation:ForgeRegistries.ENCHANTMENTS.getKeys()){
            ENCH.register(resourceLocation.getResourceDomain(),new DataEnchantmant(ForgeRegistries.ENCHANTMENTS.getValue(resourceLocation)));
        }
    }

    public static void registerAllDimension(){
        for(int i: DimensionManager.getStaticDimensionIDs()){
            DIM.register("noModId",new DataDimension(DimensionManager.getProviderType(i)));
        }
    }
}
