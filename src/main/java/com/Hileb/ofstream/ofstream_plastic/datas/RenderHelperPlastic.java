package com.Hileb.ofstream.ofstream_plastic.datas;

import com.Hileb.ofstream.ofstream.irr.FBOHelper;
import com.Hileb.ofstream.ofstream.render.IRenderObject;
import com.Hileb.ofstream.ofstream.render.RenderHelper;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.screen.inventory.InventoryScreen;
import net.minecraft.client.renderer.texture.PotionSpriteUploader;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;

import java.util.Arrays;


public class RenderHelperPlastic {
    public static FBOHelper fboHelperX36=new FBOHelper(36);
    public static FBOHelper fboHelperX144=new FBOHelper(144);
    public static IRenderObject renderPotionObjectInv=new IRenderObject(){
        @Override
        public void render(Object... objects) {
            if (objects.length==1){
                Object object= Arrays.stream(objects).iterator().next();
                if (object instanceof Effect){
                    Effect potion=(Effect) object;
                    GlStateManager.enableTexture();
                    GlStateManager.enableBlend();
                    GlStateManager.enableAlphaTest();
                    renderEffects(new MatrixStack(),new EffectInstance(potion));
                    GlStateManager.disableTexture();
                    GlStateManager.disableBlend();
                    GlStateManager.disableAlphaTest();
                }
            }
        }
    };
    public static void renderEffects(MatrixStack matrixStack,EffectInstance effect) {
            RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            int i=-6;
            int j=-7;

            renderEffectSprites(matrixStack, i, j, effect);
    }
    public static void renderEffectSprites(MatrixStack matrixStack, int renderX, int renderY, EffectInstance effectInstance) {
        Effect effect=effectInstance.getPotion();
        PotionSpriteUploader potionspriteuploader = Minecraft.getInstance().getPotionSpriteUploader();

        TextureAtlasSprite textureatlassprite = potionspriteuploader.getSprite(effect);
        Minecraft.getInstance().getTextureManager().bindTexture(textureatlassprite.getAtlasTexture().getTextureLocation());
        AbstractGui.blit(matrixStack, renderX + 6, renderY + 7, 1, 18, 18, textureatlassprite);

        effectInstance.renderInventoryEffect(new InventoryScreen(Minecraft.getInstance().player), matrixStack, renderX, renderY,0);
    }

    public static String getPotionSmallIconInv(Effect potion){
        return RenderHelper.getBase64(fboHelperX36,renderPotionObjectInv,potion);
    }
    public static String getPotionLargeIconInv(Effect potion){
        return RenderHelper.getBase64(fboHelperX144,renderPotionObjectInv,potion);
    }
}
