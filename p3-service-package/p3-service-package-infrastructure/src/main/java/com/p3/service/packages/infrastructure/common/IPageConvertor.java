package com.p3.service.packages.infrastructure.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;
import java.util.function.Function;

public class IPageConvertor {

    public static <S, R> Page<R> convertor(IPage<S> source) {

        return new Page<R>(source.getCurrent(), source.getSize(), source.getTotal());
    }

    public static <T, S, R extends Page<T>> R convertor(IPage<S> source, List<T> records, Function<Page<T>, R> creator) {

        return creator.apply(new Page<T>(source.getCurrent(), source.getSize(), source.getTotal()).setRecords(records));
    }
}
