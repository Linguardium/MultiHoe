package mod.linguardium.multihoe.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.item.HoeItem;
import net.minecraft.item.MiningToolItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(MiningToolItem.class)
public class MiningToolMixin {
    @ModifyExpressionValue(method="isSuitableFor",at=@At(value="INVOKE",target="Lnet/minecraft/block/BlockState;isIn(Lnet/minecraft/tag/TagKey;)Z"),
            slice=@Slice(from=@At(value="FIELD",target="Lnet/minecraft/item/MiningToolItem;effectiveBlocks:Lnet/minecraft/tag/TagKey;"))
    )
    private boolean hoesBeHoein(boolean isIn) {
        return isIn || ((Object)this instanceof HoeItem);
    }
    @ModifyExpressionValue(method="getMiningSpeedMultiplier",at=@At(value="INVOKE",target="Lnet/minecraft/block/BlockState;isIn(Lnet/minecraft/tag/TagKey;)Z"))
    private boolean hoesBeHoeinWithSpeed(boolean isIn) {
        return isIn || ((Object)this instanceof HoeItem);
    }


}
