package com.Hileb.ofstream.ofstream_plastic.datas;

import com.Hileb.ofstream.ofstream.IDataOfstream;
import com.Hileb.ofstream.ofstream.lang.LangHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.world.ForgeWorldType;

import java.util.Objects;

public class DataDimension implements IDataOfstream {


    public final String registerName;

    public DataDimension(ResourceLocation resourceLocation, DimensionType forgeWorldType){
        registerName=resourceLocation.toString();
    }
}
