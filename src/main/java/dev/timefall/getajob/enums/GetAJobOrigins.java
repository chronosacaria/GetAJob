package dev.timefall.getajob.enums;

public enum GetAJobOrigins {
    EXPLORER(0, "explorer"),
    FORAGER(1, "forager"),
    NECROMANCER_CORPSE_CARVER(2, "corpse_carver"),
    NECROMANCER_BONE_BUILDER(3, "bone_builder"),
    NECROMANCER_THANATOLOGIST(4, "thanatologist");

    public final int intID;
    public final String originName;

    GetAJobOrigins(int intID, String originName) {
        this.intID = intID;
        this.originName = originName;
    }
}
