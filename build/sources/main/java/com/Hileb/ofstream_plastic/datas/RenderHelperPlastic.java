package com.Hileb.ofstream_plastic.datas;

import com.Hileb.ofstream.ofstream.irr.FBOHelper;
import com.Hileb.ofstream.ofstream.render.IRenderObject;
import com.Hileb.ofstream.ofstream.render.RenderHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.MathHelper;

import java.util.Arrays;

import static net.minecraft.client.gui.inventory.GuiContainer.INVENTORY_BACKGROUND;

public class RenderHelperPlastic {
    public static FBOHelper fboHelperX36=new FBOHelper(36);
    public static FBOHelper fboHelperX144=new FBOHelper(144);
    public static IRenderObject renderPotionObjectInv= objects -> {
        Potion potion = (Potion) objects[0];
        GlStateManager.enableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.enableAlpha();
        renderPotionInventory(potion);
        GlStateManager.disableTexture2D();
        GlStateManager.disableBlend();
        GlStateManager.disableAlpha();
    };
    public static void renderPotionInventory(Potion potion){
        int i=-6;
        int j=-7;
        GlStateManager.scale((float) 16/18,(float) 16/18,(float) 16/18);
        PotionEffect potioneffect=new PotionEffect(potion);
        if(!potion.shouldRender(potioneffect)) {
            return;
        }
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        Minecraft.getMinecraft().getTextureManager().bindTexture(INVENTORY_BACKGROUND);
        if (potion.hasStatusIcon())
        {
            int i1 = potion.getStatusIconIndex();
            drawTexturedModalRect(0, 0, i1 % 8 * 18, 198 + i1 / 8 * 18, 18, 18);
        }
        potion.renderInventoryEffect(i, j, potioneffect, Minecraft.getMinecraft());
    }
    public static void drawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height)
    {
        float f = 0.00390625F;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
        bufferbuilder.pos((double)(x + 0), (double)(y + height), (double)0).tex((double)((float)(textureX + 0) * 0.00390625F), (double)((float)(textureY + height) * 0.00390625F)).endVertex();
        bufferbuilder.pos((double)(x + width), (double)(y + height), (double)0).tex((double)((float)(textureX + width) * 0.00390625F), (double)((float)(textureY + height) * 0.00390625F)).endVertex();
        bufferbuilder.pos((double)(x + width), (double)(y + 0), (double)0).tex((double)((float)(textureX + width) * 0.00390625F), (double)((float)(textureY + 0) * 0.00390625F)).endVertex();
        bufferbuilder.pos((double)(x + 0), (double)(y + 0), (double)0).tex((double)((float)(textureX + 0) * 0.00390625F), (double)((float)(textureY + 0) * 0.00390625F)).endVertex();
        tessellator.draw();
    }
    public static String getPotionSmallIconInv(Potion potion){
        return RenderHelper.getBase64(fboHelperX36,renderPotionObjectInv,potion);
    }
    public static String getPotionLargeIconInv(Potion potion){
        return RenderHelper.getBase64(fboHelperX144,renderPotionObjectInv,potion);
    }
}
