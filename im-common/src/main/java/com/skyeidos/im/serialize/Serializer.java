package com.skyeidos.im.serialize;

import com.skyeidos.im.protocol.JsonCodec;

public interface Serializer {

    byte JSON_SERIALIZE = 1;

    Serializer DEFAULT = new JSONSerializer();

    byte getSerializerAlgorithm();

    byte[] serialize(Object object);

    <T> T deSerialize(byte[] bytes, Class<T> clazz);

    default void registerSerializer() {
        JsonCodec.registerSerialize(getSerializerAlgorithm(), this);
    }
}
