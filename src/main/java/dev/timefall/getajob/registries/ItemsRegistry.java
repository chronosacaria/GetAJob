package dev.timefall.getajob.registries;

import dev.timefall.getajob.GetAJob;
import dev.timefall.getajob.items.GildedSoulItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemsRegistry {
    public static final Item GILDED_SOUL = new GildedSoulItem(new Item.Settings().group(ItemGroup.MISC).maxCount(64));

    public static void init(){
        Registry.register(Registry.ITEM, new Identifier(GetAJob.MOD_ID, "gilded_soul"), GILDED_SOUL);
    }
}
