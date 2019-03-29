package com.thrift;

import org.apache.thrift.TException;

/**
 * Created by jiazhiwen on 2019/3/25.
 */
public class HelloWorldImpl implements HelloWorldService.Iface{
    @Override
    public String sayHello(User user) throws TException {
        return "Hi,My name is " + user.username + " and My age is " + user.age;
    }

}
