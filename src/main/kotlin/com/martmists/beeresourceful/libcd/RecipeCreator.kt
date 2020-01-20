package com.martmists.beeresourceful.libcd

import io.github.alloffabric.beeproductive.api.HoneyFlavor
import io.github.cottonmc.libcd.api.tweaker.recipe.RecipeTweaker
import net.minecraft.inventory.CraftingInventory
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.potion.PotionUtil
import net.minecraft.recipe.Ingredient
import net.minecraft.recipe.RecipeSerializer
import net.minecraft.recipe.SpecialCraftingRecipe
import net.minecraft.recipe.SpecialRecipeSerializer
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import net.minecraft.world.World

object RecipeCreator {
    val flavors = mutableMapOf<String, HoneyFlavor>()
    val potionFlavors = mutableMapOf<String, HoneyFlavor>()

    fun ___registerRecipes() {
        flavors.forEach { (name, flavor) ->
            // TODO: LibCD needs to support ItemStacks before this works
            val air = Ingredient.EMPTY
            RecipeTweaker.INSTANCE.addShaped(
                    arrayOf(
                            arrayOf(air, flavor.sheared, air),
                            arrayOf(flavor.sheared, flavor.bottled, flavor.sheared),
                            arrayOf(air, flavor.sheared, air)
                    ),
                    ItemStack(Registry.ITEM.get(Identifier(
                            "beeresourceful",
                            name + "_nectar"
                    )), 8)
            )
        }
    }

    class PotionItemRecipe(id: Identifier) : SpecialCraftingRecipe(id) {
        override fun craft(inv: CraftingInventory): ItemStack {
            return if (matches(inv)) {
                val potion = PotionUtil.getPotion(inv.getInvStack(4))
                val name = potionFlavors.filterValues { potion == PotionUtil.getPotion(it.bottled) }.keys.first()
                val resultID = Identifier(
                        "beeresourceful",
                        name + "_nectar"
                )
                ItemStack(Registry.ITEM.get(resultID), 8)
            } else {
                ItemStack.EMPTY
            }
        }

        override fun fits(width: Int, height: Int): Boolean {
            return width == 3 && height == 3
        }

        override fun getSerializer(): RecipeSerializer<*> {
            return potion_serializer
        }

        override fun matches(inv: CraftingInventory, world: World): Boolean {
            return matches(inv)
        }

        private fun matches(inv: CraftingInventory): Boolean {
            return arrayOf(0, 2, 6, 8).all { inv.getInvStack(it).isEmpty } && arrayOf(1, 3, 5, 7).all { inv.getInvStack(it).item == Items.HONEYCOMB } && potionFlavors.values.any {
                inv.getInvStack(4).item == Items.POTION && PotionUtil.getPotion(inv.getInvStack(4)) == PotionUtil.getPotion(it.bottled)
            }
        }
    }

    val potion_serializer: SpecialRecipeSerializer<PotionItemRecipe> = Registry.register(Registry.RECIPE_SERIALIZER, Identifier("beeresourceful", "crafting_special_beeresourceful_potions"), SpecialRecipeSerializer { identifier: Identifier -> PotionItemRecipe(identifier) })
}