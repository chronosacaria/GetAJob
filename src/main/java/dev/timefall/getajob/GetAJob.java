package dev.timefall.getajob;

import dev.timefall.getajob.items.GetAJobItemGroups;
import dev.timefall.getajob.registries.ItemsRegistry;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class GetAJob implements ModInitializer {

    public static final String MOD_ID = "getajob";
    public static Identifier ID(String path) {
        return new Identifier(MOD_ID, path);
    }

    public static Identifier id(String path) {
        return new Identifier(MOD_ID, path);
    }

    @Override
    public void onInitialize() {
        ItemsRegistry.init();
        GetAJobItemGroups.register();

        /*
        Health Amount  |  Non Explorer  | Explorer w/o Old Friends | Explorer w Old Friends
        100%           |    100%        | 100%                     | 120%
        90%            |    100%        | 87%                      | 92%
        80%            |    100%        | 78%                      | 83%
        70%            |    100%        | 71%                      | 76%
        60%            |    100%        | 65%                      | 70%
        50%            |    100%        | 60%                      | 65%
        40%            |    100%        | 56%                      | 61%
        30%            |    100%        | 53%                      | 58%
        20%            |    100%        | 51%                      | 56%
        10%            |    100%        | 50%                      | 55%
         */
    }
}
