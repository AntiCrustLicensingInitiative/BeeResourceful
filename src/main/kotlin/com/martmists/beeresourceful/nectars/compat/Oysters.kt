package com.martmists.beeresourceful.nectars.compat

import com.martmists.beeresourceful.BeeResourceful
import com.martmists.beeresourceful.entities.SimpleFlavor
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object Oysters {
    val PEARL_FLAVOR = BeeResourceful.registerFlavor("pearl", SimpleFlavor.bySheared(Registry.ITEM.get(Identifier("oysters", "blemished_pearl"))))

    fun init() {}
}