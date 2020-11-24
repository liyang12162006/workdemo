package com.example.lamdba;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yangyangl
 * @date 2019-02-13 14:00
 */
public class lamdba {


        public static void main(String[] args) {

            List<Person> list = new ArrayList();
            list.add(new Person(1, "haha"));
            list.add(new Person(1, "rere"));
            list.add(new Person(2, "fefe"));

            Map<Integer,List<Person>> ss=list.stream()
                    .collect(Collectors.groupingBy(Person::getId));

            System.out.println(ss);

            List<Person> aa=ss.get(1);
            System.out.println(aa);

            //方式二：
            Map<Boolean,List<Person>> gg=list.stream()
                    .collect(Collectors.partitioningBy(p->p.getId()==1));

            System.out.println(gg);

            List<Person> ff=gg.get(true);
            System.out.println(ff);


        }


}
