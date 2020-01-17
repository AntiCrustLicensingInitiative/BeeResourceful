package com.martmists.beeresourceful.nectars

import com.martmists.beeresourceful.BeeResourceful
import com.martmists.beeresourceful.entities.ChanceDropFlavor
import io.github.alloffabric.beeproductive.api.HoneyFlavor
import io.github.alloffabric.beeproductive.init.BeeProdItems
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.potion.PotionUtil
import net.minecraft.util.registry.Registry

object Potions {
    val PotionFlavors = mutableMapOf<String, HoneyFlavor?>("mundane" to null, "awkward" to null, "thick" to null, "water" to null, "empty" to null)

    fun init() {
        Registry.POTION.forEach {
            val name = it.finishTranslationKey("").split("/").last()
            if (name !in PotionFlavors) {
                val flavor = ChanceDropFlavor(ItemStack(Items.HONEYCOMB, 3), PotionUtil.setPotion(ItemStack(Items.POTION, 1), it))
                PotionFlavors[name] = flavor
                BeeResourceful.registerFlavor("potion_$name", flavor)
            }
        }
    }
}
