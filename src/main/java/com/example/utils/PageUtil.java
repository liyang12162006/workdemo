package com.example.utils;

import com.github.pagehelper.PageInfo;
import com.huitongjy.common.util.entity.Page;
import java.util.List;

/**
 * 分页工具类型
 *
 * @author wangwenru
 * @since 2020/3/17
 */
public class PageUtil {
    public static <T> Page<T> convert(PageInfo source, List<T> list, int pageSize) {
        Page<T> target = new Page();
        target.setPageNum(source.getPageNum());
        // 当 list 为空的时候, source.pageSize 为 0 ,在调用 Page.getPages(); 方法时会抛除 0 异常。
        if (pageSize <= 0) {
            pageSize = 10;
        }
        target.setPageSize(pageSize);
        target.setTotal(((int) source.getTotal()));
        target.setResult(list);

        return target;
    }
}
