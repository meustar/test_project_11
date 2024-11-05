package com.koreait.surl_project_11;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("a")
    @ResponseBody
    public String hi1(
            String age,
            String id
    ) {
        return "안녕, %s번, %s 살이야.".formatted(id, age);
    }

    @GetMapping("b")
    @ResponseBody
    public String plus(
            // http://localhost:8080/b?a=20&b=40
            @RequestParam("a") int num1,
            @RequestParam("b") int num2,
            @RequestParam(name = "c", defaultValue = "10") int num3

    ) {

        System.out.println("a : " + num1);
        System.out.println("b : " + num2);

        return "a + b + c = %d".formatted(num1 + num2 + num3);
    }

    @GetMapping("c")
    @ResponseBody
    public String c(
          Boolean married
    ) {
        if (married == null) return "정보 입력하세요";
        return married ? "기혼" : "미혼";
    }

    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    @GetMapping("person1")
    @ResponseBody
    public String person1(
            String name,
            int age

    ) {

        Person person = new Person(name, age);

        return person.toString();
    }

    @GetMapping("person2")
    @ResponseBody
    public Person person2(
            Person person

    ) {
        return person;
    }

    @GetMapping("e")
    @ResponseBody
    public int e () {
        int age = 10;
        return age;
    }

    @GetMapping("f")
    @ResponseBody
    public boolean f () {
        boolean b = true;
        return b;

        /* 리턴 하는값의 type이 int, boolean 등 String이 아니면.
        웹 브라우저로 통신하는 중에 자바스크립트와 자바의 동일 타입인 String으로 한번더 변환 과정을 겪어
        사실상 웹에 보이는 값은 String 이다.
        * */
    }
}
