package com.Hileb.ofstream.ofstream_plastic.datas;

import com.Hileb.ofstream.ofstream.IDataOfstream;
import com.Hileb.ofstream.ofstream.lang.LangHelper;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.text.TranslationTextComponent;


public class DataPotion implements IDataOfstream {
    public final String chineseName;
    public final String englishName;

    public final String registerName;
    public final boolean isBadEffect;
    public final String potionType;

    public final String smallIcon;
    public final String largeIcon;
    public DataPotion(Effect potion){
        registerName=potion.getRegistryName().toString();
        String nameKey=LangHelper.getTranslateKey(potion.getDisplayName());
        chineseName= LangHelper.getI18n(LangHelper.ZH_CN).format(nameKey);
        englishName= LangHelper.getI18n(LangHelper.EN_US).format(nameKey);
        isBadEffect=!potion.isBeneficial();
        potionType=effectType(potion.getEffectType());

        smallIcon=RenderHelperPlastic.getPotionSmallIconInv(potion);
        largeIcon=RenderHelperPlastic.getPotionLargeIconInv(potion);
    }
    public static String effectType(EffectType type){
        if (type==EffectType.BENEFICIAL)return "beneficial";
        else if (type==EffectType.HARMFUL)return "harmful";
        else if (type==EffectType.NEUTRAL)return "neutral";
        else return type.toString();
    }
}
