package com.martmists.beeresourceful.entities

import io.github.alloffabric.beeproductive.api.HoneyFlavor
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.Items

class SimpleFlavor : HoneyFlavor {
    constructor(sheared: Item, bottled: Item) : super(ItemStack(sheared, 3), ItemStack(bottled, 1))
    constructor(sheared: ItemStack, bottled: ItemStack) : super(sheared, bottled)

    companion object {
        fun bySheared(sheared: ItemStack) = SimpleFlavor(sheared, ItemStack(Items.HONEY_BOTTLE, 1))
        fun byBottled(bottled: ItemStack) = SimpleFlavor(ItemStack(Items.HONEYCOMB, 3), bottled)
        fun bySheared(sheared: Item) = SimpleFlavor(sheared, Items.HONEY_BOTTLE)
        fun byBottled(bottled: Item) = SimpleFlavor(Items.HONEYCOMB, bottled)
    }
}
