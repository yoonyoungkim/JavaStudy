package stream;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    String id;
    String surveyId;
    String submissionId;
    Category category;
    Question question;
    Choice selectedChoice;
}
