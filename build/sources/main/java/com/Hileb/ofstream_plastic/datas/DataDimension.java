package com.Hileb.ofstream_plastic.datas;

import com.Hileb.ofstream.ofstream.IDataOfstream;
import com.Hileb.ofstream.ofstream.lang.LangHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class DataDimension implements IDataOfstream {
    public final String name;

    public final int defaultId;

    public DataDimension(DimensionType enchantment){
        name=enchantment.getName();
        defaultId=enchantment.getId();
    }
}
