
package com.ljj.grammar.generic;

import com.ljj.grammar.generic.wildcard.Apple;
import com.ljj.grammar.generic.wildcard.Banana;
import com.ljj.grammar.generic.wildcard.Food;
import com.ljj.grammar.generic.wildcard.Fruit;
import com.ljj.grammar.generic.wildcard.GreenApple;
import com.ljj.grammar.generic.wildcard.Plate;
import com.ljj.grammar.generic.wildcard.RedApple;

import junit.framework.TestCase;

/**
 * 泛型之通配符测试 
 *    上界通配符 <? extends xxx>,直白点说：xxx 或 xxx是其基类的对象都可以放到容器
 *      上界通配符副作用是：会使set方法失效，因为编译器只知道容器是基类或基类派生类,但具体是什么类不知道,所有编辑无法确定set类否与容器中标识位是否匹配， 
 *      get方法有效，因为编译器知道标识位是基类
 *      
 *    上界通配符 <? super xxx>,直白点说：xxx 或是 xxx 基类的对象都可以放到容器
 *      上界通配符副作用是：会使get方法失效，因为Object是所以类的基类，如果转换成Object类就会使类型信信息全部丢失
 *      set方法有效，因为下界规定了元素的最小粒度的下限，那么存放的元素是比 super xxx小就行了，
 * 
 *   泛型之通配符选择：
 *      1、如果频繁读取内容，适应上界(<? extends xxx>)
 *      2、如果频繁插入内容，适应下界(<? super xxx>)
 *    
 * @author liangjinjing
 *
 */
public class GenericTest extends TestCase {

    /**
     * 上界通配符 <? extends xxx>,直白点说：xxx 或 xxx是其基类的对象都可以放到容器
     */ 
    @ SuppressWarnings("unused")
    public void testUpper() {
        // 自己
        Plate<Fruit> a = new Plate<Fruit>(new Fruit());
        // 没有用通配符
        // Plate<Fruit> b = new Plate<Apple>(new Apple());
        /*
         * 上界通配符
         */
        Plate< ? extends Fruit> b1 = new Plate<Apple>(new Apple());
        Plate< ? extends Fruit> b2 = new Plate<RedApple>(new RedApple());
        Plate< ? extends Fruit> b3 = new Plate<GreenApple>(new GreenApple());
        Plate< ? extends Fruit> b4 = new Plate<Banana>(new Banana());
    }

    /**
     * 上界通配符 <? extends xxx>,直白点说：xxx 或是 xxx 基类的对象都可以放到容器
     * 
     * 上界通配符副作用是：会使set方法失效，因为编辑器只知道容器是基类或基类派生类,但具体是什么类不知道,所有编辑无法确定set类否与容器中标识是否有效。
     */
    @ SuppressWarnings("unused")
    public void testLower() {
        // 自己
        Plate<Fruit> a = new Plate<Fruit>(new Fruit());
        // 没有用通配符
        // Plate<Fruit> b = new Plate<Apple>(new Apple());
        /*
         * 上界通配符
         */
        Plate< ? super Fruit> b1 = new Plate<Fruit>(new Fruit());
        Plate< ? super Fruit> b2 = new Plate<Food>(new Food());
        // 错误
        //Plate< ? super Fruit> b3 = new Plate<GreenApple>(new GreenApple());
    }
}
