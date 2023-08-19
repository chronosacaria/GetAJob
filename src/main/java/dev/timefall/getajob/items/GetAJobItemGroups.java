package dev.timefall.getajob.items;

import dev.timefall.getajob.GetAJob;
import dev.timefall.getajob.registries.ItemsRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class GetAJobItemGroups {
    public static final RegistryKey<ItemGroup> GET_A_JOB_ITEM_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, GetAJob.ID("get_a_job"));

    public static void register() {
        Registry.register(Registries.ITEM_GROUP, new Identifier(GetAJob.MOD_ID, "get_a_job"),
                FabricItemGroup.builder()
                        .displayName(Text.translatable("itemgroup.get_a_job"))
                        .icon(() -> new ItemStack(ItemsRegistry.GILDED_SOUL))
                        .build()
        );
    }
}
