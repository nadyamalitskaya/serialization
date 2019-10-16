package com.nixsolutions.serializtion;

import com.nixsolutions.ppp.serializable.SerializableUtils;

import java.io.*;

public class SerializableUtilsImpl implements SerializableUtils {

    public void serialize(OutputStream out, Object obj) {
        if (out == null || obj == null) {
            throw new NullPointerException();
        }
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Object deserialize(InputStream in) {
        if (in == null) {
            throw new NullPointerException();
        }
        Object object;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(in);
            object = objectInputStream.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return object;
    }
}
