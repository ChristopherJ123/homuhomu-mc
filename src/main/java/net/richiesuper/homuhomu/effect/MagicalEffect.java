package net.richiesuper.homuhomu.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.richiesuper.homuhomu.item.ModItems;

public class MagicalEffect extends StatusEffect {
    public MagicalEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {

        if (!entity.world.isClient() && entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;
            if (!player.getInventory().contains(new ItemStack(ModItems.SOUL_GEM)) && player.isAlive()) {
                player.sendMessage(Text.literal(player.getEntityName() + " lost their Soul Gem and died!"));
                player.kill();
            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
