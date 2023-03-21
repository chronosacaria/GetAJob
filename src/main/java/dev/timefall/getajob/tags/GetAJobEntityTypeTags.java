package dev.timefall.getajob.tags;

import dev.timefall.getajob.GetAJob;
import net.minecraft.entity.EntityType;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class GetAJobEntityTypeTags {

    public static final TagKey<EntityType<?>> ENTITY_BEHAVIOR_CHECKED_ENTITIES = register("entity_behavior_checked_entities");
    public static final TagKey<EntityType<?>> VILLAGE_DEFENDERS = register("village_defenders");
    public static final TagKey<EntityType<?>> LESSER_UNDEAD = register("lesser_undead");
    public static final TagKey<EntityType<?>> GREATER_UNDEAD = register("greater_undead");

    private static TagKey<EntityType<?>> register(String id) {
        return TagKey.of(Registry.ENTITY_TYPE_KEY, new Identifier(GetAJob.MOD_ID, id));
    }
}
