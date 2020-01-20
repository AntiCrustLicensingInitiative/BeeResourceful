package com.martmists.beeresourceful.libcd

import com.martmists.beeresourceful.BeeResourceful
import io.github.alloffabric.beeproductive.api.HoneyFlavor
import io.github.cottonmc.libcd.api.tweaker.TweakerManager
import net.minecraft.item.ItemStack
import net.minecraft.item.Items

/*
* Custom LibCD Tweaker for adding custom nectar
* Note: Requires textures and langs to be added in a resourcepack
* */
object CustomNectar {
    val knownNames = mutableListOf<String>()

    @JvmOverloads
    fun addNectar(name: String, shearing: ItemStack = ItemStack(Items.HONEYCOMB, 3), bottling: ItemStack = ItemStack(Items.HONEY_BOTTLE, 1)) {
        if (name !in knownNames) {
            knownNames.add(name)
            BeeResourceful.registerFlavor(name, HoneyFlavor(shearing, bottling))
        }
    }

    fun __register() {
        TweakerManager.INSTANCE.addAssistant("beeresourceful.libcd.CustomNectar", this)
    }
}