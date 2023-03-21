package dev.timefall.getajob.interfaces;

import dev.timefall.getajob.util.SelectorContainer;
import net.minecraft.entity.Entity;
import net.minecraft.util.TypeFilter;
import net.minecraft.world.entity.EntityIndex;

import java.util.List;
import java.util.function.Predicate;

public interface IGetAJobEntityView {
    <T extends Entity> List<T> getEntitiesByType(TypeFilter<Entity, T> typeFilter, Predicate<? super T> predicate, SelectorContainer selectorContainer);

    EntityIndex<?> getEntityIndex();

}
