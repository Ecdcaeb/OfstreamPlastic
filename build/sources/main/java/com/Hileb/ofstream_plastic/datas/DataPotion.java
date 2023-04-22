package com.Hileb.ofstream_plastic.datas;

import com.Hileb.ofstream.ofstream.IDataOfstream;
import com.Hileb.ofstream.ofstream.lang.LangHelper;
import net.minecraft.potion.Potion;

public class DataPotion implements IDataOfstream {
    public final String chineseName;
    public final String englishName;

    public final String registerName;
    public final boolean isBadEffect;

    public final String smallIcon;
    public final String largeIcon;
    public DataPotion(Potion potion){
        registerName=potion.getRegistryName().toString();
        chineseName= LangHelper.getI18n("zh_cn").format(potion.getName());
        englishName= LangHelper.getI18n("en_us").format(potion.getName());
        isBadEffect=potion.isBadEffect();

        smallIcon=RenderHelperPlastic.getPotionSmallIconInv(potion);
        largeIcon=RenderHelperPlastic.getPotionLargeIconInv(potion);
    }
}
