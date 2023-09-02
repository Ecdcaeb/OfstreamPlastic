package com.Hileb.ofstream_plastic.datas;

import com.Hileb.ofstream.ofstream.IDataOfstream;
import net.minecraft.world.DimensionType;

public class DataDimension implements IDataOfstream {
    public final String name;

    public final int defaultId;

    public DataDimension(DimensionType enchantment){
        name=enchantment.getName();
        defaultId=enchantment.getId();
    }
}
