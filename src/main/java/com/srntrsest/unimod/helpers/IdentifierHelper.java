package com.srntrsest.unimod.helpers;

import com.srntrsest.unimod.UniMod;
import net.minecraft.util.Identifier;

public class IdentifierHelper {

    public static Identifier createId(String name) {
        return new Identifier(UniMod.MOD_ID, name);
    }

}
