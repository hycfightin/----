package com.spring.hycspringboot.repostry;

import com.spring.hycspringboot.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class UserRepository {
    private final ConcurrentMap< Integer,User> reopstiory = new ConcurrentHashMap<>();
    private final static AtomicInteger idGenerate = new AtomicInteger();
    public boolean save (User user) {
        Integer id = idGenerate.incrementAndGet();
        //reopstiory.put(id,user);
        user.setId(id);
        return reopstiory.put(id,user)==null;
    }
    public Collection<User> findAll() {

        return reopstiory.values();
    }


}
