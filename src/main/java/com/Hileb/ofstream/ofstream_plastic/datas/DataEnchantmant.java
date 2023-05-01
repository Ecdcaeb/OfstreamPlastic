package com.Hileb.ofstream.ofstream_plastic.datas;

import com.Hileb.ofstream.ofstream.IDataOfstream;
import com.Hileb.ofstream.ofstream.lang.LangHelper;
import net.minecraft.enchantment.Enchantment;

public class DataEnchantmant implements IDataOfstream {
    public final String chineseName;
    public final String englishName;

    public final String registerName;

    public DataEnchantmant(Enchantment enchantment){
        registerName=enchantment.getRegistryName().toString();
        chineseName= LangHelper.getI18n(LangHelper.ZH_CN).format(enchantment.getName());
        englishName= LangHelper.getI18n(LangHelper.EN_US).format(enchantment.getName());

    }
}
