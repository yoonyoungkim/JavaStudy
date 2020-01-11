package stream;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Survey {
    String id;
    String title;
    String teamName;
    String description;
    List<Category> categories;
}
