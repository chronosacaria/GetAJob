package dev.timefall.getajob.registries;

import dev.timefall.getajob.GetAJob;
import io.github.apace100.apoli.power.factory.condition.ConditionFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import io.github.apace100.calio.data.SerializableData;
import io.github.apace100.calio.data.SerializableDataTypes;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;

import java.util.List;

public class GetAJobEntityConditions {
    public static void register() {
        register(new ConditionFactory<>(
                GetAJob.id("entities_in_radius"), new SerializableData()
                .add("tag", SerializableDataTypes.ENTITY_TAG)
                .add("radius", SerializableDataTypes.FLOAT),
                (data, player) -> {
                    float radius = data.getFloat("radius");
                    List<Entity> entityList = data.get("entity_condition");
                    boolean locatedEntity = false;
                    for(Entity entity : entityList) {
                        locatedEntity = locatedEntity
                                || !player.world.getEntitiesByType(
                                        entity.getType(),
                                        new Box(
                                                new Vec3d(
                                                        player.getX() - radius,
                                                        player.getY() - radius,
                                                        player.getZ() - radius),
                                                new Vec3d(player.getX() + radius,
                                                        player.getY() + radius,
                                                        player.getZ() + radius)
                                        ),
                                (entity1) -> true).isEmpty();
                    }
                    return locatedEntity;
                }));
    }

    private static void register(ConditionFactory<Entity> conditionFactory) {
        Registry.register(ApoliRegistries.ENTITY_CONDITION, conditionFactory.getSerializerId(), conditionFactory);
    }


}