package com.martmists.beeresourceful.entities

import io.github.alloffabric.beeproductive.api.HoneyFlavor
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import java.util.*

class ChanceDropFlavor @JvmOverloads constructor(sheared: ItemStack, bottled: ItemStack = ItemStack(Items.HONEY_BOTTLE, 1), val chanceSheared: Double = 1.0, val chanceBottled: Double = 1.0) : HoneyFlavor(sheared, bottled) {
    @JvmOverloads
    constructor(sheared: Item, bottled: Item = Items.HONEY_BOTTLE, chanceSheared: Double = 1.0, chanceBottled: Double = 1.0) : this(ItemStack(sheared, 1), ItemStack(bottled, 1), chanceSheared, chanceBottled)

    val random = Random()
    override fun getSheared(): ItemStack {
        return ItemStack(super.getSheared().item, if (random.nextDouble() <= chanceSheared) super.getSheared().count else 0 )
    }

    override fun getBottled(): ItemStack {
        return ItemStack(super.getBottled().item, if (random.nextDouble() <= chanceBottled) super.getBottled().count else 0 )
    }
}
