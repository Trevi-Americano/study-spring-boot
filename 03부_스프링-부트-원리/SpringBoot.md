- POM : Project Object Model
- @SpringBootApplication
    - 1단계 : @ComponentScan
        - @ComponentScan이 선언된 클래스의 하위 패키지 중 @Component을 가진 Component들를 Scan해서 Bean으로 등록
    - 2단계 : @EnableAutoConfiguration
        - @Configuration : Bean을 등록하는 설정 파일
        - spring-boot-autoconfigure-2.0.3.RELEASE.jar!\META-INF\spring.factories
            - org.springframework.boot.autoconfigure.EnableAutoConfiguration
        - 모든 jar 파일의 spring.factories를 찾아서 Key 값에 해당하는 모든 클래스를 확인
        - spring.factories의 자동 설정들이 Condition(조건)에 따라 Bean으로 생성, 등록?
    - 1단계에서 Bean으로 설정하더라도 2단계에서 덮어 설정될 수 있음
        - @ConditionalOnMissingBean을 사용하면 1단계로 설정

- org.springframework.boot.loader.jar.JarFile을 사용해서 내장 JAR를 읽는다.
    - org.springframework.boot.loader.Launcher를 사용해서 실행한다.

- spring-boot-starter : Spring Boot의 의존성들을 관리
    - 의존성 관리를 받는 방법 : maven의 parent와 spring-boot-dependencies

- 프로퍼티 우선 순위