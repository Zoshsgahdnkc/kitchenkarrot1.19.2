package io.github.tt432.kitchenkarrot.menu;

import io.github.tt432.kitchenkarrot.blockentity.BrewingBarrelBlockEntity;
import io.github.tt432.kitchenkarrot.menu.base.KKBeMenu;
import io.github.tt432.kitchenkarrot.registries.ModMenuTypes;
import net.minecraft.world.entity.player.Inventory;

/**
 * @author DustW
 **/
public class BrewingBarrelMenu extends KKBeMenu<BrewingBarrelBlockEntity> {
    public BrewingBarrelMenu(int windowId, Inventory inv, BrewingBarrelBlockEntity blockEntity) {
        super(ModMenuTypes.BREWING_BARREL.get(), windowId, inv, blockEntity);

        addSlots();
    }

    void addSlots() {
        var handler = blockEntity.input;
        addSlot(handler, 0, 48, 25);
        addSlot(handler, 1, 68, 25);
        addSlot(handler, 2, 88, 25);
        addSlot(handler, 3, 48, 45);
        addSlot(handler, 4, 68, 45);
        addSlot(handler, 5, 88, 45);

        addResultSlot(blockEntity.result(), 0, 115, 35);
    }
}
