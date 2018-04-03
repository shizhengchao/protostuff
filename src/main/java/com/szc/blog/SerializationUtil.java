package com.szc.blog;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

/**
 * protostuff是一款高性能的序列化和反序列化工具，在各方面的测试中， protostuff各方面性能优于protobuff
 * 
 * @author shizhengchao
 * @version
 */
public class SerializationUtil {

    private static Map<Class<?>, Schema<?>> cachedSchema = new ConcurrentHashMap<Class<?>, Schema<?>>();

    private static Objenesis objenesis = new ObjenesisStd(true);

    private SerializationUtil() {
    }

    /**
     * 构建Schema
     * @param cls
     * @return
     * @version
     */
    @SuppressWarnings("unchecked")
    private static <T> Schema<T> getSchema(Class<T> cls) {
	Schema<T> schema = (Schema<T>) cachedSchema.get(cls);
	if (schema == null) {
	    schema = RuntimeSchema.createFrom(cls);
	    if (schema != null) {
		//构建schema的过程可能会比较耗时，因此希望使用过的类对应的schema能被缓存起来
		cachedSchema.put(cls, schema);
	    }
	}
	return schema;
    }

    /**
     * 序列化
     * @param obj
     * @return
     * 
     * @author hz17052992
     * @date 2018年4月3日 上午11:01:37
     * @version
     */
    @SuppressWarnings("unchecked")
    public static <T> byte[] serialize(T obj) {
	//1.获得对象的类
	Class<T> cls = (Class<T>) obj.getClass();
	//2.使用LinkedBuffer分配一块默认大小的buffer空间
	LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
	try {
	    //通过对象的类构建对应的schema
	    Schema<T> schema = getSchema(cls);
	    //使用给定的schema将对象序列化为一个byte数组，并返回
	    return ProtostuffIOUtil.toByteArray(obj, schema, buffer);
	} catch (Exception e) {
	    throw new IllegalStateException(e.getMessage(), e);
	} finally {
	    buffer.clear();
	}
    }

    public static <T> T deserialize(byte[] data, Class<T> cls) {
	try {
	    //1.使用objenesis实例化一个类的对象
	    T message = (T) objenesis.newInstance(cls);
	    //2.通过对象的类构建对应的schema
	    Schema<T> schema = getSchema(cls);
	    ///使用给定的schema将byte数组和对象合并，并返回
	    ProtostuffIOUtil.mergeFrom(data, message, schema);
	    return message;
	} catch (Exception e) {
	    throw new IllegalStateException(e.getMessage(), e);
	}
    }
}
