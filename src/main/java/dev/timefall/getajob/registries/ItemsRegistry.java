package dev.timefall.getajob.registries;

import dev.timefall.getajob.GetAJob;
import dev.timefall.getajob.items.GetAJobItemGroups;
import dev.timefall.getajob.items.GildedSoulItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ItemsRegistry {
    public static final Item GILDED_SOUL = new GildedSoulItem(new Item.Settings().maxCount(64));

    public static void init(){
        Registry.register(Registries.ITEM, new Identifier(GetAJob.MOD_ID, "gilded_soul"), GILDED_SOUL);
        ItemGroupEvents.modifyEntriesEvent(GetAJobItemGroups.GET_A_JOB_ITEM_GROUP).register(entries -> entries.add(GILDED_SOUL));
    }
}
