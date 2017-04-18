package io.github.zhangdihong.filter;

import com.netflix.zuul.ZuulFilter;

/**
 * <p>Project: io.github.zhangdihong.filter</p>
 * <p>Title: UserZuulFilter.java</p>
 * <p/>
 * <p>Description: UserZuulFilter </p>
 *
 * @author zhangdihong
 * @version 1.0
 * @date 2017/4/4
 */
public class UserZuulFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return null;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() {
        return null;
    }
}
