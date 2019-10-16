package com.nixsolutions.serializtion;

import com.nixsolutions.ppp.serializable.SerializableBean;

import java.io.*;

public class SerializableBeanImpl implements SerializableBean {

    private String name;
    private String email;
    private int zip;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name + ";" + email + ";" + zip);
        out.close();
    }

    public void readExternal(ObjectInput in) throws IOException {
        String line;
        try {
            line = in.readObject().toString();
            String[] array = line.split(";");
            setName(array[0]);
            setEmail(array[1]);
            setZip(Integer.parseInt(array[2]));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
