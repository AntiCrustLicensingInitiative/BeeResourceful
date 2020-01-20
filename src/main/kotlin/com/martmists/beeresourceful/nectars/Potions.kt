package com.martmists.beeresourceful.nectars

import com.martmists.beeresourceful.BeeResourceful
import com.martmists.beeresourceful.entities.SimpleFlavor
import io.github.alloffabric.beeproductive.api.HoneyFlavor
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.potion.Potion
import net.minecraft.potion.PotionUtil
import net.minecraft.util.registry.Registry

object Potions {
    val PotionFlavors = mutableMapOf<String, HoneyFlavor?>("mundane" to null, "awkward" to null, "thick" to null, "water" to null, "empty" to null)

    fun registerPotion(it: Potion) {
        val name = it.finishTranslationKey("").split("/").last()
        if (name !in PotionFlavors) {
            val flavor = SimpleFlavor.byBottled(PotionUtil.setPotion(ItemStack(Items.POTION, 1), it))
            PotionFlavors[name] = flavor
            BeeResourceful.registerFlavor("potion_$name", flavor)
        }
    }

    fun init() {
        Registry.POTION.forEach {
            registerPotion(it)
        }
        RegistryEntryAddedCallback.event(Registry.POTION).register(RegistryEntryAddedCallback<Potion> { p0, p1, p2 -> registerPotion(p2) })
    }
}
