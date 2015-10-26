package com.grampabacon.sgreborn.utils;

import com.grampabacon.sgreborn.Main;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

import java.util.List;

/**
 * Created by Adam on 22/09/2015.
 */
public class MetaHandler {
    public static void setMetaData(Player p, Object data, String key){
        p.setMetadata(key, new FixedMetadataValue(Main.getInstance(), data));
    }

    public static Object getMetadata(Player p, String key) {
        List<MetadataValue> values;

        try{
            values = p.getMetadata(key);
            for (MetadataValue value : values) {
                return value.value();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
