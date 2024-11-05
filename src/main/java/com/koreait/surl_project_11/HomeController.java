package com.koreait.surl_project_11;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Data
    @ToString
    @AllArgsConstructor
    public static class Person {

        private String name;
        private int age;
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
    }

    /*
    리턴 하는값의 type이 int, boolean 등 String이 아니면.
    웹 브라우저로 통신하는 중에 자바스크립트와 자바의 동일 타입인 String으로 한번더 변환 과정을 겪어
    사실상 웹에 보이는 값은 String 이다.
    */

    @GetMapping("g")
    @ResponseBody
    public ArrayList g () {
        ArrayList<int[]> arr = new ArrayList<>();
        arr.add(new int[]{1, 2, 3});
        arr.add(new int[]{2});
        arr.add(new int[]{3});

        return arr;
    }


    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    @ToString
    @EqualsAndHashCode(onlyExplicitlyIncluded = true)  // 객체끼리의 비교중 @EqualsAndHashCode.Include 가 명시된 필드만 비교한다.
    public static class Post {
        @ToString.Exclude
        @JsonIgnore
        @EqualsAndHashCode.Include
        private long id;    // toString, Json에서 빠지게 된다.
        private LocalDateTime createDate;
        private LocalDateTime updateDate;
        @Builder.Default
        private String subject = "제목이야.";
        private String body;

    }

    @GetMapping("/posts")
    @ResponseBody
    public List<Post> getPosts() {
        List<Post> posts = new ArrayList<>() {{
            add(new Post(1L, LocalDateTime.now(), LocalDateTime.now(), "제목1", "내용1"));
            add(new Post(1L, LocalDateTime.now(), LocalDateTime.now(), "제목2", "내용2"));
            add(new Post(1L, LocalDateTime.now(), LocalDateTime.now(), "제목3", "내용3"));
            add(new Post(1L, LocalDateTime.now(), LocalDateTime.now(), "제목4", "내용4"));
        }};
        return posts;
    }

    @GetMapping("/posts2")
    @ResponseBody
    public List<Post> getPosts2() {
        List<Post> posts = new ArrayList<>() {{
//            add(new Post(1L, LocalDateTime.now(), LocalDateTime.now(), "제목1", "내용1"));
            // 해당 클래스에 @Builder 어노테이션이 붙어야 가능한 빌드 방법.
            add(Post
                    .builder()
                    .id(1l)
                    .createDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
//                    .subject("제목1")
                    .body("내용1")
                    .build()
            );
            add(Post
                    .builder()
                    .id(1l)
                    .createDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .subject("제목2")
                    .body("내용2")
                    .build()
            );
            add(Post
                    .builder()
                    .id(1l)
                    .createDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .subject("제목3")
                    .body("내용3")
                    .build()
            );
            add(Post
                    .builder()
                    .id(1l)
                    .createDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .subject("제목4")
                    .body("내용4")
                    .build()
            );
        }};
        return posts;
    }

    @GetMapping("/posts/")
    @ResponseBody
    public Post getPost() {
        Post post = Post.builder()
                            .id(1l)
                            .createDate(LocalDateTime.now())
                            .updateDate(LocalDateTime.now())
                            .body("내용1")
                            .build();
        System.out.println(post);
        return post;
    }

    @SneakyThrows
    @GetMapping("/posts/2")
    @ResponseBody
    public Post getPost2() {
        Post post = Post.builder()
                .id(1l)
                .createDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .body("내용1")
                .build();
        Thread.sleep(2000);

        System.out.println(post);
        return post;
    }
}
