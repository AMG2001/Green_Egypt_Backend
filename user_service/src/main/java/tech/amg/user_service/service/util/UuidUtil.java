package tech.amg.user_service.service.util;

import java.util.UUID;

public class UuidUtil {
    public static String generateUuid(){
        return UUID.randomUUID().toString();
    }
}
