package com.martmists.beeresourceful.libcd

import io.github.alloffabric.beeproductive.BeeProductive
import io.github.alloffabric.beeproductive.api.HoneyFlavor
import io.github.cottonmc.libcd.api.tweaker.TweakerManager
import io.github.cottonmc.libcd.api.tweaker.recipe.RecipeTweaker
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.recipe.Ingredient
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object _InternalNectarRecipeConfiguration {
    val flavors = mutableMapOf<String, HoneyFlavor>()

    fun ___registerAllRecipes() {
        flavors.forEach { (name, flavor) ->
            // TODO: LibCD needs to support ItemStacks before this works
            val sheared = Ingredient.ofStacks(ItemStack(flavor.sheared.item, 1))
            val air = Ingredient.ofItems(Items.AIR)
            RecipeTweaker.INSTANCE.addShaped(
                    arrayOf(
                            arrayOf(air, sheared, air),
                            arrayOf(sheared, Ingredient.ofStacks(flavor.bottled), sheared),
                            arrayOf(air, sheared, air)
                    ),
                    ItemStack(Registry.ITEM.get(Identifier(
                            "beeresourceful",
                            name+"_nectar"
                    )), 2)
            )
        }
    }

    fun __register() {
        TweakerManager.INSTANCE.addAssistant("beeresourceful.libcd._InternalNectarRecipeConfiguration", this)
    }
}