package stream;

import lombok.*;

import java.util.List;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    String id;
    String text;
    List<Question> questions;

    @Override
    public String toString() {
        return "{" +
                "\"id\":\"" + id + '\"' +
                ", \"text\":\"" + text + '\"' +
                ", \"questions\":" + questions +
                "}";
    }
}
