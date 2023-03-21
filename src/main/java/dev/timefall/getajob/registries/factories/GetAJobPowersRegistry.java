package dev.timefall.getajob.registries.factories;

import dev.timefall.getajob.powers.ModifyBehaviorPower;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.apoli.power.factory.PowerFactorySupplier;
import io.github.apace100.apoli.registry.ApoliRegistries;
import net.minecraft.util.registry.Registry;

public class GetAJobPowersRegistry {

    public static void register() {
        register(ModifyBehaviorPower::createFactory);
    }

    private static void register(PowerFactorySupplier<?> supplier) {
        register(supplier.createFactory());
    }

    public static void register(PowerFactory<?> serializer) {
        Registry.register(ApoliRegistries.POWER_FACTORY, serializer.getSerializerId(), serializer);
    }
}
