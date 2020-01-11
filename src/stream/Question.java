package stream;

import lombok.*;

import java.util.List;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    String id;
    String text;
    String type;
    List<Choice> choices;

    @Override
    public String toString() {
        return "{" +
                "\"id\":\"" + id + '\"' +
                ", \"text\":\"" + text + '\"' +
                ", \"type:\":\"" + type + '\"' +
                ", \"choices\":" + choices +
                "}";
    }
}
