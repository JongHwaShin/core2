package hello.core2;

import lombok.*;
import org.springframework.stereotype.Service;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setAge(12);
        helloLombok.setName("신종화");
        System.out.println("helloLombok = " + helloLombok);
    }
}
