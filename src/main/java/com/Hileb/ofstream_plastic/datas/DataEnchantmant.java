package com.Hileb.ofstream_plastic.datas;

import com.Hileb.ofstream.ofstream.IDataOfstream;
import com.Hileb.ofstream.ofstream.lang.LangHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public class DataEnchantmant implements IDataOfstream {
    public final String chineseName;
    public final String englishName;

    public final String registerName;

    public final int maxLevel;
    public final int minLevel;
    public final boolean isPositive;

    public DataEnchantmant(Enchantment enchantment){
        registerName=enchantment.getRegistryName().toString();
        maxLevel=enchantment.getMaxLevel();
        minLevel=enchantment.getMinLevel();
        isPositive=!enchantment.isCurse();
        chineseName= LangHelper.getI18n("zh_cn").format(enchantment.getName());
        englishName= LangHelper.getI18n("en_us").format(enchantment.getName());

    }
}
