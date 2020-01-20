package com.martmists.beeresourceful.libcd

import com.martmists.beeresourceful.BeeResourceful
import io.github.alloffabric.beeproductive.api.HoneyFlavor
import net.minecraft.item.ItemStack
import net.minecraft.item.Items

object CustomNectar {
    val knownNames = mutableListOf<String>()

    @JvmOverloads
    fun addNectar(name: String, shearing: ItemStack = ItemStack(Items.HONEYCOMB, 3), bottling: ItemStack = ItemStack(Items.HONEY_BOTTLE, 1)) {
        if (name !in knownNames) {
            knownNames.add(name)
            BeeResourceful.registerFlavor(name, HoneyFlavor(shearing, bottling))
        }
    }
}