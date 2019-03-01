package jp.co.tis.climate.albumweb.service;

import jp.co.tis.climate.albumweb.dao.HelloDao;
import jp.co.tis.climate.albumweb.model.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HelloService {

    @Autowired
    private HelloDao helloDao;

    public Optional<Hello> getHello(){
        return helloDao.findAll().stream().findFirst();
    }
}
