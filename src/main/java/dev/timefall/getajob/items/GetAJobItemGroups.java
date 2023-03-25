package dev.timefall.getajob.items;

import dev.timefall.getajob.GetAJob;
import dev.timefall.getajob.registries.ItemsRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class GetAJobItemGroups {
    public static final ItemGroup GET_A_JOB_ITEM_GROUP = FabricItemGroup.builder(
            new Identifier(GetAJob.MOD_ID, "get_a_job"))
            .displayName(Text.translatable("itemgroup.get_a_job"))
            .icon(() -> new ItemStack(ItemsRegistry.GILDED_SOUL))
            .build();
}
