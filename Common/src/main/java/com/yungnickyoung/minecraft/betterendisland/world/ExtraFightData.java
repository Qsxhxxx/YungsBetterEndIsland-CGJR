package com.yungnickyoung.minecraft.betterendisland.world;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.ExtraCodecs;

public class ExtraFightData {
    private boolean firstExitPortalSpawn;
    private boolean hasDragonEverSpawned;
    private int numTimesDragonKilled;
    private boolean arenaLoaded;
    private boolean ok;
    private boolean ok1;
    private int buildY;

    public static final Codec<ExtraFightData> CODEC = RecordCodecBuilder.create((builder) -> builder.group(
                    Codec.BOOL.fieldOf("FirstExitPortalSpawn").orElse(true).forGetter(ExtraFightData::firstExitPortalSpawn),
                    Codec.BOOL.fieldOf("HasDragonEverSpawned").orElse(false).forGetter(ExtraFightData::hasDragonEverSpawned),
                    ExtraCodecs.NON_NEGATIVE_INT.fieldOf("NumberTimesDragonKilled").orElse(0).forGetter(ExtraFightData::numTimesDragonKilled),
                    Codec.BOOL.fieldOf("ArenaLoaded").orElse(false).forGetter(ExtraFightData::arenaLoaded),
                    Codec.BOOL.fieldOf("Ok").orElse(false).forGetter(ExtraFightData::ok),
                    Codec.BOOL.fieldOf("Ok1").orElse(false).forGetter(ExtraFightData::ok1),
                    Codec.INT.fieldOf("BuildY").orElse(65).forGetter(ExtraFightData::buildY))
            .apply(builder, ExtraFightData::new));

    public static final ExtraFightData DEFAULT = new ExtraFightData(true, false, 0, false, false, false, 65);

    public ExtraFightData(boolean firstExitPortalSpawn, boolean hasDragonEverSpawned, int numTimesDragonKilled, boolean arenaLoaded, boolean ok, boolean ok1, int buildY) {
        this.firstExitPortalSpawn = firstExitPortalSpawn;
        this.hasDragonEverSpawned = hasDragonEverSpawned;
        this.numTimesDragonKilled = numTimesDragonKilled;
        this.arenaLoaded = arenaLoaded;
        this.ok = ok;
        this.ok1 = ok1;
        this.buildY = buildY;
    }

    public void setFirstExitPortalSpawn(boolean bl) {
        this.firstExitPortalSpawn = bl;
    }

    public boolean firstExitPortalSpawn() {
        return this.firstExitPortalSpawn;
    }

    public void setHasDragonEverSpawned(boolean bl) {
        this.hasDragonEverSpawned = bl;
    }

    public boolean hasDragonEverSpawned() {
        return this.hasDragonEverSpawned;
    }

    public void setNumTimesDragonKilled(int i) {
        this.numTimesDragonKilled = i;
    }

    public int numTimesDragonKilled() {
        return this.numTimesDragonKilled;
    }

    public boolean arenaLoaded() {
        return this.arenaLoaded;
    }

    public void setArenaLoaded(boolean arenaLoaded) {
        this.arenaLoaded = arenaLoaded;
    }

    public boolean ok() {
        return this.ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public boolean ok1() {
        return this.ok1;
    }

    public void setOk1(boolean ok1) {
        this.ok1 = ok1;
    }

    public int buildY() {
        return this.buildY;
    }

    public void setBuildY(int buildY) {
        this.buildY = buildY;
    }
}
