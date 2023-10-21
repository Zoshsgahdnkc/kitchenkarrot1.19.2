package io.github.tt432.kitchenkarrot.dependencies.jei.category;

import io.github.tt432.kitchenkarrot.Kitchenkarrot;
import io.github.tt432.kitchenkarrot.block.BrewingBarrelBlock;
import io.github.tt432.kitchenkarrot.blockentity.BrewingBarrelBlockEntity;
import io.github.tt432.kitchenkarrot.dependencies.jei.JeiPlugin;
import io.github.tt432.kitchenkarrot.item.ModBlockItems;
import io.github.tt432.kitchenkarrot.recipes.recipe.BrewingBarrelRecipe;
import io.github.tt432.kitchenkarrot.registries.ModItems;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.Collections;
import java.util.List;

/**
 * @author DustW
 **/
public class BrewingBarrelRecipeCategory extends BaseRecipeCategory<BrewingBarrelRecipe> {
    public static final ResourceLocation BACKGROUND =
            new ResourceLocation(Kitchenkarrot.MOD_ID, "textures/gui/jei.png");

    public BrewingBarrelRecipeCategory(IGuiHelper helper) {
        super(JeiPlugin.BREWING_BARREL,
                helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlockItems.BREWING_BARREL.get())),
                helper.createDrawable(BACKGROUND, 0, 72, 149, 69));
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, BrewingBarrelRecipe recipe, IFocusGroup focuses) {
        var ingredients = recipe.getIngredient();

        builder.addSlot(RecipeIngredientRole.INPUT, 42, 17).addIngredients(ingredients.get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 62, 17).addIngredients(ingredients.get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 82, 17).addIngredients(ingredients.get(2));
        builder.addSlot(RecipeIngredientRole.INPUT, 42, 37).addIngredients(ingredients.get(3));
        builder.addSlot(RecipeIngredientRole.INPUT, 62, 37).addIngredients(ingredients.get(4));
        builder.addSlot(RecipeIngredientRole.INPUT, 82, 37).addIngredients(ingredients.get(5));
        //builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 21, 17).addItemStack(ModItems.WATER.get().getDefaultInstance());

        builder.addSlot(RecipeIngredientRole.OUTPUT, 109, 27).addItemStack(recipe.getResultItem());
    }

    @Override
    public List<Component> getTooltipStrings(BrewingBarrelRecipe recipe, IRecipeSlotsView recipeSlotsView, double mouseX, double mouseY) {
        if (mouseX >= 20 && mouseX <= 38) {
            if (mouseY >= 16 && mouseY <= 34) return List.of(Component.translatable("info.kitchenkarrot.water", BrewingBarrelBlockEntity.FLUID_CONSUMPTION));
            if (mouseY >= 36 && mouseY <= 54) return List.of(Component.translatable("info.kitchenkarrot.time", recipe.getCraftingTime() / 20));
        }
    return Collections.emptyList();
    }
}
