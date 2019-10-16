package com.nixsolutions.serializtion;

import com.nixsolutions.ppp.serializable.SingletonBean;

public class SingletonBeanImpl implements SingletonBean {

    private static SingletonBeanImpl singletonBean = new SingletonBeanImpl();

    private SingletonBeanImpl() {
    }

    private static SingletonBeanImpl getInstance() {
        return singletonBean;
    }

    public Object readResolve() {
        return getInstance();
    }
}
