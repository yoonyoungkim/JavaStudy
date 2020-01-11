package stream;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Choice {
    String id;
    String text;
    int value;

    @Override
    public String toString() {
        return "{" +
                "\"id\": \"" + id + '\"' +
                ", \"text\":\"" + text + '\"' +
                ", \"value\":" + value +
                "}";
    }
}
