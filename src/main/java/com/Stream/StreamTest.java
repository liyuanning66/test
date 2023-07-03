package com.Stream;

import com.beust.ah.A;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamTest {
    @Test
    public void test(){
        System.out.println("11");
        List<Integer> list = new ArrayList<>();
        //这个可以这样理解 比如我们利用lamda衍生出来表达式(Integer o1, Integer o2) -> o1.compare(o2);
        list.sort(Integer::compareTo);
    }
}
