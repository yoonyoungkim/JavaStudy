package stream;

import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    int count; // 응답 인원
    double average;
    double stdDvt;
    List<CategoryInfo> categoryInfoList;

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class CategoryInfo {
        Category category;
        List<QuestionInfo> questionInfoList;
        double average;
        double stdDvt;

        public static CategoryInfoBuilder emptyWith(Category category) {
            List<QuestionInfo> questionInfoList = category.getQuestions().stream().map(question -> QuestionInfo.emptyWith(question).build()).collect(Collectors.toList());
            return CategoryInfo.builder()
                    .category(category)
                    .questionInfoList(questionInfoList)
                    .average(0d)
                    .stdDvt(0d);
        }

        @Override
        public String toString() {
            return "{" +
                    "\"category\":" + category +
                    ", \"questionInfoList\":" + questionInfoList +
                    ", \"average\":" + average +
                    ", \"stdDvt\":" + stdDvt +
                    "}";
        }
    }

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class QuestionInfo {
        Question question;
        List<ChoiceInfo> choiceInfoList;
        int count;
        double average;
        double stdDvt;

        public static QuestionInfoBuilder emptyWith(Question question) {
            List<ChoiceInfo> choiceInfoList = question.getChoices().stream().map(choice -> ChoiceInfo.emptyWith(choice).build()).collect(Collectors.toList());
            return QuestionInfo.builder()
                    .question(question)
                    .choiceInfoList(choiceInfoList)
                    .count(0)
                    .average(0d)
                    .stdDvt(0d);
        }

        @Override
        public String toString() {
            return "{" +
                    "\"question\":" + question +
                    ", \"choiceInfoList\":" + choiceInfoList +
                    ", \"count\":" + count +
                    ", \"average\":" + average +
                    ", \"stdDvt\":" + stdDvt +
                    "}";
        }
    }

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ChoiceInfo {
        Choice choice;
        int count;
        public static ChoiceInfoBuilder emptyWith(Choice choice) {
            return ChoiceInfo.builder()
                    .choice(choice)
                    .count(0);
        }

        @Override
        public String toString() {
            return "{" +
                    "\"choice\":" + choice +
                    ", \"count\":" + count +
                    "}";
        }
    }

    @Override
    public String toString() {
        return "{" +
                "\"count\":" + count +
                ", \"average\":" + average +
                ", \"stdDvt\":" + stdDvt +
                ", \"categoryInfoList\":" + categoryInfoList +
                "}";
    }
}
