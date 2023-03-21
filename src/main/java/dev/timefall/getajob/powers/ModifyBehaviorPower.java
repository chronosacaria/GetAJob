package dev.timefall.getajob.powers;

import dev.timefall.getajob.GetAJob;
import io.github.apace100.apoli.data.ApoliDataTypes;
import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.calio.data.SerializableData;
import io.github.apace100.calio.data.SerializableDataType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;

import java.util.List;

public class ModifyBehaviorPower extends Power {
    List<EntityType<?>> affectedEntities;
    EntityBehavior desiredBehavior;

    public ModifyBehaviorPower(PowerType<?> type, LivingEntity player, EntityBehavior desiredBehavior, List<EntityType<?>> affectedEntities) {
        super(type, player);
        this.affectedEntities = affectedEntities;
        this.desiredBehavior = desiredBehavior;
    }

    public boolean checkEntity(EntityType<?> type) {
        return affectedEntities.contains(type);
    }

    public EntityBehavior getDesiredBehavior() {
        return this.desiredBehavior;
    }

    public enum EntityBehavior {
        HOSTILE,
        NEUTRAL,
        PASSIVE
    }

    public static PowerFactory createFactory() {
        return new PowerFactory<ModifyBehaviorPower>(GetAJob.id("modify_entity_behavior"),
                new SerializableData()
                        .add("entity_condition", ApoliDataTypes.ENTITY_CONDITION, null)
                        .add("behavior", SerializableDataType.enumValue(ModifyBehaviorPower.EntityBehavior.class)),
                data -> (type, player) -> new ModifyBehaviorPower(type, player, data.get("behavior"), data.get("entity_condition")))
                .allowCondition();
    }
}
