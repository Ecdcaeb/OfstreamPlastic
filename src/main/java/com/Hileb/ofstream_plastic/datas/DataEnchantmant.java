package com.Hileb.ofstream_plastic.datas;

import com.Hileb.ofstream.ofstream.IDataOfstream;
import com.Hileb.ofstream.ofstream.lang.LangHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.potion.Potion;

public class DataEnchantmant implements IDataOfstream {
    public final String chineseName;
    public final String englishName;

    public final String registerName;

    public DataEnchantmant(Enchantment enchantment){
        registerName=enchantment.getRegistryName().toString();
        chineseName= LangHelper.getI18n("zh_cn").format(enchantment.getName());
        englishName= LangHelper.getI18n("en_us").format(enchantment.getName());

    }
}
