package com.zyj.springboot.handler;

import com.zyj.springboot.dao.CityRepository;
import com.zyj.springboot.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Yujie_Zhao
 * @ClassName CityHandler
 * @Description 处理器类 Handler
 *
 *  //@Component泛指组件，当组件不好归类的时候，使用该注解进行标注
 *  然后用 final 和 @Autowired 标注在构造器注入 CityRepository Bean，
 *
 * Mono：实现发布者，并返回 0 或 1 个元素，即单对象
 * Flux：实现发布者，并返回 N 个元素，即 List 列表对象
 * 有人会问，这为啥不直接返回对象，比如返回 City/Long/List。
 * 原因是，直接使用 Flux 和 Mono 是非阻塞写法，相当于回调方式。利用函数式可以减少了回调，因此会看不到相关接口。
 * 反应了是 WebFlux 的好处：集合了非阻塞 + 异步。
 *
 * Mono.create()：使用 MonoSink 来创建 Mono
 * Mono.justOrEmpty()：从一个 Optional 对象或 null 对象中创建 Mono。
 * Mono.error()：创建一个只包含错误消息的 Mono
 * Mono.never()：创建一个不包含任何消息通知的 Mono
 * Mono.delay()：在指定的延迟时间之后，创建一个 Mono，产生数字 0 作为唯一值
 *
 * @Date 2021/4/16  11:22
 * @Version 1.0
 **/
@Component
public class CityHandler {


    private final CityRepository cityRepository;

    @Autowired
    public CityHandler(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Mono<Long> save(City city) {
        return Mono.create(cityMonoSink -> cityMonoSink.success(cityRepository.save(city)));
    }

    public Mono<City> findCityById(Long id) {
        return Mono.justOrEmpty(cityRepository.findCityById(id));
    }

    public Flux<City> findAllCity() {
        return Flux.fromIterable(cityRepository.findAll());
    }

    public Mono<Long> modifyCity(City city) {
        return Mono.create(cityMonoSink -> cityMonoSink.success(cityRepository.updateCity(city)));
    }

    public Mono<Long> deleteCity(Long id) {
        return Mono.create(cityMonoSink -> cityMonoSink.success(cityRepository.deleteCity(id)));
    }
}