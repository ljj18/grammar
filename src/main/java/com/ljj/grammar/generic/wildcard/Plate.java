/**
 * 文件名称:          		Plate.java
 * 版权所有@ 2017-2018 	liangjinjing
 * 编译器:           		JDK1.8
 */

package com.ljj.grammar.generic.wildcard;

/**
 * 盘子(可以放水果、内类)
 * 
 * Version 1.0.0
 * 
 * @author liangjinjing
 * 
 * Date 2019-05-30 10:49
 * 
 */
public class Plate<T> {

    public T t;

    public Plate(T t) {
        this.t = t;
    }

    /**
     * 
     */
    public T get() {
        return t;
    }

    /**
     * 
     */
    public void set(T t) {
        this.t = t;
    }

}
