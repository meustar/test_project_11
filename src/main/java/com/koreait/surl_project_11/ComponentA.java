package com.koreait.surl_project_11;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 스프링부트에게 주석을 남겨줌으로 사용의 목적을 알려주는 것. 등록.
@Component
@RequiredArgsConstructor        // 객체 생성할 때 final을 써줌으로써 @Autowired를 생략할 수 있다.
public class ComponentA {

    private final ComponentB componentB;
    private final ComponentC componentC;
    // 위아래 같다. final을 좀더 선호함. (짧아서.)
    @Autowired
    private ComponentD componentD;
    @Autowired
    private ComponentE componentE;

    public String action() {
        return "ComponentA action / " + componentB.getAction();
    }
}
