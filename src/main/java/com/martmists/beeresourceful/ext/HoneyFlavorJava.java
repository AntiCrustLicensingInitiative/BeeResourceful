/*
 * Decompiled with CFR 0.148.
 *
 * Could not load the following classes:
 *  com.martmists.beeresourceful.ext.HoneyFlavorKt$registerNectar
 *  io.github.alloffabric.beeproductive.api.HoneyFlavor
 *  io.github.alloffabric.beeproductive.api.Nectar
 *  io.github.alloffabric.beeproductive.api.hive.Beehive
 *  kotlin.Metadata
 *  kotlin.Unit
 *  kotlin.jvm.functions.Function2
 *  kotlin.jvm.internal.Intrinsics
 *  net.minecraft.entity.passive.BeeEntity
 *  org.jetbrains.annotations.NotNull
 */
package com.martmists.beeresourceful.ext;

import com.martmists.beeresourceful.BeeResourceful;
import io.github.alloffabric.beeproductive.api.HoneyFlavor;
import io.github.alloffabric.beeproductive.api.Nectar;


public final class HoneyFlavorJava {
	public static Nectar registerNectar(HoneyFlavor $this$registerNectar, String name) {
		return BeeResourceful.INSTANCE.registerNectar(name, (bee, hive) -> {
			hive.addHoneyFlavor($this$registerNectar);
		});
	}
}

