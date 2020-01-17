package com.martmists.beeresourceful.nectars

import com.martmists.beeresourceful.BeeResourceful
import com.martmists.beeresourceful.entities.ChanceDropFlavor
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import techreborn.init.TRContent

object Oysters {
    val PEARL_FLAVOR = BeeResourceful.registerFlavor("pearl", ChanceDropFlavor(Registry.ITEM.get(Identifier("oysters", "blemished_pearl")), chanceSheared = 0.75))

    fun init() {}
}