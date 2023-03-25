package dev.timefall.getajob.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GildedSoulItem extends Item {
    public GildedSoulItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(Text.translatable("item.getajob.gilded_soul.lore"));
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (world.random.nextInt(100) >= 0) {
            user.getMainHandStack().decrement(1);
            world.createExplosion(user, user.getX(), user.getEyeY(), user.getZ(), 2.0f, World.ExplosionSourceType.NONE);
        }
        return super.finishUsing(stack, world, user);
    }
}
