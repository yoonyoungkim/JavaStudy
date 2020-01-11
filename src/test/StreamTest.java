package test;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import stream.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StreamTest {
    @Test
    public void test() {
        Result result = getResult();

        System.out.println(result.toString());

        assertAll("total summary",
                () -> assertEquals(5, result.getCount()),
                () -> assertEquals(3, result.getCategoryInfoList().size()),
                () -> assertEquals(3.08d, result.getAverage(), 0.000001),
                () -> assertEquals(1.44d, result.getStdDvt(), 0.000001)
        );

        assertAll("category1",
                () -> assertEquals("c1", result.getCategoryInfoList().get(0).getCategory().getId()),
                () -> assertEquals(3d, result.getCategoryInfoList().get(0).getAverage()),
                () -> assertEquals(1.788854382d, result.getCategoryInfoList().get(0).getStdDvt(), 0.0000001),
                () -> assertEquals(1, result.getCategoryInfoList().get(0).getQuestionInfoList().size())
        );

        assertAll("category2",
                () -> assertEquals("c2", result.getCategoryInfoList().get(1).getCategory().getId()),
                () -> assertEquals(3d, result.getCategoryInfoList().get(1).getAverage(), 0.0000001),
                () -> assertEquals(1.549193338d, result.getCategoryInfoList().get(1).getStdDvt(), 0.0000001),
                () -> assertEquals(2, result.getCategoryInfoList().get(1).getQuestionInfoList().size())
        );

//        assertAll("category3",
//                () -> assertEquals("c3", result.getCategoryInfoList().get(2).getCategory().getId()),
//                () -> assertEquals(3.2d, result.getCategoryInfoList().get(2).getAverage(), 0.0000001),
//                () -> assertEquals(1.077032961d, result.getCategoryInfoList().get(2).getStdDvt(), 0.0000001),
//                () -> assertEquals(3, result.getCategoryInfoList().get(2).getQuestionInfoList().size())
//        );

        assertAll("question1",
                () -> assertEquals("q1", result.getCategoryInfoList().get(0).getQuestionInfoList().get(0).getQuestion().getId()),
                () -> assertEquals(5, result.getCategoryInfoList().get(0).getQuestionInfoList().get(0).getCount()),
                () -> assertEquals(3d, result.getCategoryInfoList().get(0).getQuestionInfoList().get(0).getAverage()),
                () -> assertEquals(1.788854382d, result.getCategoryInfoList().get(0).getQuestionInfoList().get(0).getStdDvt(), 0.0000001),
                () -> assertEquals(3, result.getCategoryInfoList().get(0).getQuestionInfoList().get(0).getChoiceInfoList().size()),
                () -> assertEquals("ch1", result.getCategoryInfoList().get(0).getQuestionInfoList().get(0).getChoiceInfoList().get(0).getChoice().getId()),
                () -> assertEquals(2, result.getCategoryInfoList().get(0).getQuestionInfoList().get(0).getChoiceInfoList().get(0).getCount()),
                () -> assertEquals("ch2", result.getCategoryInfoList().get(0).getQuestionInfoList().get(0).getChoiceInfoList().get(1).getChoice().getId()),
                () -> assertEquals(1, result.getCategoryInfoList().get(0).getQuestionInfoList().get(0).getChoiceInfoList().get(1).getCount()),
                () -> assertEquals("ch3", result.getCategoryInfoList().get(0).getQuestionInfoList().get(0).getChoiceInfoList().get(2).getChoice().getId()),
                () -> assertEquals(2, result.getCategoryInfoList().get(0).getQuestionInfoList().get(0).getChoiceInfoList().get(2).getCount())
        );

        assertAll("question2",
                () -> assertEquals("q2", result.getCategoryInfoList().get(1).getQuestionInfoList().get(0).getQuestion().getId()),
                () -> assertEquals(5, result.getCategoryInfoList().get(1).getQuestionInfoList().get(0).getCount()),
                () -> assertEquals(3.4d, result.getCategoryInfoList().get(1).getQuestionInfoList().get(0).getAverage()),
                () -> assertEquals(1.496662955d, result.getCategoryInfoList().get(1).getQuestionInfoList().get(0).getStdDvt(), 0.0000001),
                () -> assertEquals(3, result.getCategoryInfoList().get(1).getQuestionInfoList().get(0).getChoiceInfoList().size()),
                () -> assertEquals("ch1", result.getCategoryInfoList().get(1).getQuestionInfoList().get(0).getChoiceInfoList().get(0).getChoice().getId()),
                () -> assertEquals(1, result.getCategoryInfoList().get(1).getQuestionInfoList().get(0).getChoiceInfoList().get(0).getCount()),
                () -> assertEquals("ch2", result.getCategoryInfoList().get(1).getQuestionInfoList().get(0).getChoiceInfoList().get(1).getChoice().getId()),
                () -> assertEquals(2, result.getCategoryInfoList().get(1).getQuestionInfoList().get(0).getChoiceInfoList().get(1).getCount()),
                () -> assertEquals("ch3", result.getCategoryInfoList().get(1).getQuestionInfoList().get(0).getChoiceInfoList().get(2).getChoice().getId()),
                () -> assertEquals(2, result.getCategoryInfoList().get(1).getQuestionInfoList().get(0).getChoiceInfoList().get(2).getCount())
        );

        assertAll("question3",
                () -> assertEquals("q3", result.getCategoryInfoList().get(1).getQuestionInfoList().get(1).getQuestion().getId()),
                () -> assertEquals(5, result.getCategoryInfoList().get(1).getQuestionInfoList().get(1).getCount()),
                () -> assertEquals(2.6d, result.getCategoryInfoList().get(1).getQuestionInfoList().get(1).getAverage()),
                () -> assertEquals(1.496662955d, result.getCategoryInfoList().get(1).getQuestionInfoList().get(1).getStdDvt(), 0.0000001),
                () -> assertEquals(3, result.getCategoryInfoList().get(1).getQuestionInfoList().get(1).getChoiceInfoList().size()),
                () -> assertEquals("ch1", result.getCategoryInfoList().get(1).getQuestionInfoList().get(1).getChoiceInfoList().get(0).getChoice().getId()),
                () -> assertEquals(2, result.getCategoryInfoList().get(1).getQuestionInfoList().get(1).getChoiceInfoList().get(0).getCount()),
                () -> assertEquals("ch2", result.getCategoryInfoList().get(1).getQuestionInfoList().get(1).getChoiceInfoList().get(1).getChoice().getId()),
                () -> assertEquals(2, result.getCategoryInfoList().get(1).getQuestionInfoList().get(1).getChoiceInfoList().get(1).getCount()),
                () -> assertEquals("ch3", result.getCategoryInfoList().get(1).getQuestionInfoList().get(1).getChoiceInfoList().get(2).getChoice().getId()),
                () -> assertEquals(1, result.getCategoryInfoList().get(1).getQuestionInfoList().get(1).getChoiceInfoList().get(2).getCount())
        );

        assertAll("question5",
                () -> assertEquals("q5", result.getCategoryInfoList().get(2).getQuestionInfoList().get(0).getQuestion().getId()),
                () -> assertEquals(5, result.getCategoryInfoList().get(2).getQuestionInfoList().get(0).getCount()),
                () -> assertEquals(3.4d, result.getCategoryInfoList().get(2).getQuestionInfoList().get(0).getAverage()),
                () -> assertEquals(0.8d, result.getCategoryInfoList().get(2).getQuestionInfoList().get(0).getStdDvt(), 0.0000001),
                () -> assertEquals(2, result.getCategoryInfoList().get(2).getQuestionInfoList().get(0).getChoiceInfoList().size()),
                () -> assertEquals("ch2", result.getCategoryInfoList().get(2).getQuestionInfoList().get(0).getChoiceInfoList().get(0).getChoice().getId()),
                () -> assertEquals(4, result.getCategoryInfoList().get(2).getQuestionInfoList().get(0).getChoiceInfoList().get(0).getCount()),
                () -> assertEquals("ch3", result.getCategoryInfoList().get(2).getQuestionInfoList().get(0).getChoiceInfoList().get(1).getChoice().getId()),
                () -> assertEquals(1, result.getCategoryInfoList().get(2).getQuestionInfoList().get(0).getChoiceInfoList().get(1).getCount())
        );

        assertAll("question6",
                () -> assertEquals("q6", result.getCategoryInfoList().get(2).getQuestionInfoList().get(1).getQuestion().getId()),
                () -> assertEquals(5, result.getCategoryInfoList().get(2).getQuestionInfoList().get(1).getCount()),
                () -> assertEquals(3d, result.getCategoryInfoList().get(2).getQuestionInfoList().get(1).getAverage()),
                () -> assertEquals(1.264911064d, result.getCategoryInfoList().get(2).getQuestionInfoList().get(1).getStdDvt(), 0.0000001),
                () -> assertEquals(3, result.getCategoryInfoList().get(2).getQuestionInfoList().get(1).getChoiceInfoList().size()),
                () -> assertEquals("ch1", result.getCategoryInfoList().get(2).getQuestionInfoList().get(1).getChoiceInfoList().get(0).getChoice().getId()),
                () -> assertEquals(1, result.getCategoryInfoList().get(2).getQuestionInfoList().get(1).getChoiceInfoList().get(0).getCount()),
                () -> assertEquals("ch2", result.getCategoryInfoList().get(2).getQuestionInfoList().get(1).getChoiceInfoList().get(1).getChoice().getId()),
                () -> assertEquals(3, result.getCategoryInfoList().get(2).getQuestionInfoList().get(1).getChoiceInfoList().get(1).getCount()),
                () -> assertEquals("ch3", result.getCategoryInfoList().get(2).getQuestionInfoList().get(1).getChoiceInfoList().get(2).getChoice().getId()),
                () -> assertEquals(1, result.getCategoryInfoList().get(2).getQuestionInfoList().get(1).getChoiceInfoList().get(2).getCount())
        );


    }

    @Test
    public void getResultRefactoring_test() {
        Result result = getResultRefactoring();

        System.out.println(result.toString());

        assertAll("total summary",
                () -> assertEquals(5, result.getCount()),
                () -> assertEquals(3, result.getCategoryInfoList().size()),
                () -> assertEquals(3.08d, result.getAverage(), 0.000001),
                () -> assertEquals(1.44d, result.getStdDvt(), 0.000001)
        );

        assertAll("category1",
                () -> assertEquals("c1", result.getCategoryInfoList().get(0).getCategory().getId()),
                () -> assertEquals(3d, result.getCategoryInfoList().get(0).getAverage()),
                () -> assertEquals(1.788854382d, result.getCategoryInfoList().get(0).getStdDvt(), 0.0000001),
                () -> assertEquals(1, result.getCategoryInfoList().get(0).getQuestionInfoList().size())
        );

        assertAll("category2",
                () -> assertEquals("c2", result.getCategoryInfoList().get(1).getCategory().getId()),
                () -> assertEquals(3d, result.getCategoryInfoList().get(1).getAverage(), 0.0000001),
                () -> assertEquals(1.549193338d, result.getCategoryInfoList().get(1).getStdDvt(), 0.0000001),
                () -> assertEquals(2, result.getCategoryInfoList().get(1).getQuestionInfoList().size())
        );

        assertAll("category3",
                () -> assertEquals("c3", result.getCategoryInfoList().get(2).getCategory().getId()),
                () -> assertEquals(3.2d, result.getCategoryInfoList().get(2).getAverage(), 0.0000001),
                () -> assertEquals(1.077032961d, result.getCategoryInfoList().get(2).getStdDvt(), 0.0000001),
                () -> assertEquals(3, result.getCategoryInfoList().get(2).getQuestionInfoList().size())
        );

        assertAll("question1",
                () -> assertEquals("q1", result.getCategoryInfoList().get(0).getQuestionInfoList().get(0).getQuestion().getId()),
                () -> assertEquals(5, result.getCategoryInfoList().get(0).getQuestionInfoList().get(0).getCount()),
                () -> assertEquals(3d, result.getCategoryInfoList().get(0).getQuestionInfoList().get(0).getAverage()),
                () -> assertEquals(1.788854382d, result.getCategoryInfoList().get(0).getQuestionInfoList().get(0).getStdDvt(), 0.0000001),
                () -> assertEquals(3, result.getCategoryInfoList().get(0).getQuestionInfoList().get(0).getChoiceInfoList().size()),
                () -> assertEquals("ch1", result.getCategoryInfoList().get(0).getQuestionInfoList().get(0).getChoiceInfoList().get(0).getChoice().getId()),
                () -> assertEquals(2, result.getCategoryInfoList().get(0).getQuestionInfoList().get(0).getChoiceInfoList().get(0).getCount()),
                () -> assertEquals("ch2", result.getCategoryInfoList().get(0).getQuestionInfoList().get(0).getChoiceInfoList().get(1).getChoice().getId()),
                () -> assertEquals(1, result.getCategoryInfoList().get(0).getQuestionInfoList().get(0).getChoiceInfoList().get(1).getCount()),
                () -> assertEquals("ch3", result.getCategoryInfoList().get(0).getQuestionInfoList().get(0).getChoiceInfoList().get(2).getChoice().getId()),
                () -> assertEquals(2, result.getCategoryInfoList().get(0).getQuestionInfoList().get(0).getChoiceInfoList().get(2).getCount())
        );

        assertAll("question2",
                () -> assertEquals("q2", result.getCategoryInfoList().get(1).getQuestionInfoList().get(0).getQuestion().getId()),
                () -> assertEquals(5, result.getCategoryInfoList().get(1).getQuestionInfoList().get(0).getCount()),
                () -> assertEquals(3.4d, result.getCategoryInfoList().get(1).getQuestionInfoList().get(0).getAverage()),
                () -> assertEquals(1.496662955d, result.getCategoryInfoList().get(1).getQuestionInfoList().get(0).getStdDvt(), 0.0000001),
                () -> assertEquals(3, result.getCategoryInfoList().get(1).getQuestionInfoList().get(0).getChoiceInfoList().size()),
                () -> assertEquals("ch1", result.getCategoryInfoList().get(1).getQuestionInfoList().get(0).getChoiceInfoList().get(0).getChoice().getId()),
                () -> assertEquals(1, result.getCategoryInfoList().get(1).getQuestionInfoList().get(0).getChoiceInfoList().get(0).getCount()),
                () -> assertEquals("ch2", result.getCategoryInfoList().get(1).getQuestionInfoList().get(0).getChoiceInfoList().get(1).getChoice().getId()),
                () -> assertEquals(2, result.getCategoryInfoList().get(1).getQuestionInfoList().get(0).getChoiceInfoList().get(1).getCount()),
                () -> assertEquals("ch3", result.getCategoryInfoList().get(1).getQuestionInfoList().get(0).getChoiceInfoList().get(2).getChoice().getId()),
                () -> assertEquals(2, result.getCategoryInfoList().get(1).getQuestionInfoList().get(0).getChoiceInfoList().get(2).getCount())
        );

        assertAll("question3",
                () -> assertEquals("q3", result.getCategoryInfoList().get(1).getQuestionInfoList().get(1).getQuestion().getId()),
                () -> assertEquals(5, result.getCategoryInfoList().get(1).getQuestionInfoList().get(1).getCount()),
                () -> assertEquals(2.6d, result.getCategoryInfoList().get(1).getQuestionInfoList().get(1).getAverage()),
                () -> assertEquals(1.496662955d, result.getCategoryInfoList().get(1).getQuestionInfoList().get(1).getStdDvt(), 0.0000001),
                () -> assertEquals(3, result.getCategoryInfoList().get(1).getQuestionInfoList().get(1).getChoiceInfoList().size()),
                () -> assertEquals("ch1", result.getCategoryInfoList().get(1).getQuestionInfoList().get(1).getChoiceInfoList().get(0).getChoice().getId()),
                () -> assertEquals(2, result.getCategoryInfoList().get(1).getQuestionInfoList().get(1).getChoiceInfoList().get(0).getCount()),
                () -> assertEquals("ch2", result.getCategoryInfoList().get(1).getQuestionInfoList().get(1).getChoiceInfoList().get(1).getChoice().getId()),
                () -> assertEquals(2, result.getCategoryInfoList().get(1).getQuestionInfoList().get(1).getChoiceInfoList().get(1).getCount()),
                () -> assertEquals("ch3", result.getCategoryInfoList().get(1).getQuestionInfoList().get(1).getChoiceInfoList().get(2).getChoice().getId()),
                () -> assertEquals(1, result.getCategoryInfoList().get(1).getQuestionInfoList().get(1).getChoiceInfoList().get(2).getCount())
        );

        assertAll("question4",
                () -> assertEquals("q4", result.getCategoryInfoList().get(2).getQuestionInfoList().get(0).getQuestion().getId()),
                () -> assertEquals(0, result.getCategoryInfoList().get(2).getQuestionInfoList().get(0).getCount()),
                () -> assertEquals(0d, result.getCategoryInfoList().get(2).getQuestionInfoList().get(0).getAverage()),
                () -> assertEquals(0d, result.getCategoryInfoList().get(2).getQuestionInfoList().get(0).getStdDvt(), 0.0000001),
                () -> assertEquals(3, result.getCategoryInfoList().get(2).getQuestionInfoList().get(0).getChoiceInfoList().size()),
                () -> assertEquals("ch1", result.getCategoryInfoList().get(2).getQuestionInfoList().get(0).getChoiceInfoList().get(0).getChoice().getId()),
                () -> assertEquals(0, result.getCategoryInfoList().get(2).getQuestionInfoList().get(0).getChoiceInfoList().get(0).getCount()),
                () -> assertEquals("ch2", result.getCategoryInfoList().get(2).getQuestionInfoList().get(0).getChoiceInfoList().get(1).getChoice().getId()),
                () -> assertEquals(0, result.getCategoryInfoList().get(2).getQuestionInfoList().get(0).getChoiceInfoList().get(1).getCount()),
                () -> assertEquals("ch3", result.getCategoryInfoList().get(2).getQuestionInfoList().get(0).getChoiceInfoList().get(2).getChoice().getId()),
                () -> assertEquals(0, result.getCategoryInfoList().get(2).getQuestionInfoList().get(0).getChoiceInfoList().get(2).getCount())
        );

        assertAll("question5",
                () -> assertEquals("q5", result.getCategoryInfoList().get(2).getQuestionInfoList().get(1).getQuestion().getId()),
                () -> assertEquals(5, result.getCategoryInfoList().get(2).getQuestionInfoList().get(1).getCount()),
                () -> assertEquals(3.4d, result.getCategoryInfoList().get(2).getQuestionInfoList().get(1).getAverage()),
                () -> assertEquals(0.8d, result.getCategoryInfoList().get(2).getQuestionInfoList().get(1).getStdDvt(), 0.0000001),
                () -> assertEquals(3, result.getCategoryInfoList().get(2).getQuestionInfoList().get(1).getChoiceInfoList().size()),
                () -> assertEquals("ch1", result.getCategoryInfoList().get(2).getQuestionInfoList().get(1).getChoiceInfoList().get(0).getChoice().getId()),
                () -> assertEquals(0, result.getCategoryInfoList().get(2).getQuestionInfoList().get(1).getChoiceInfoList().get(0).getCount()),
                () -> assertEquals("ch2", result.getCategoryInfoList().get(2).getQuestionInfoList().get(1).getChoiceInfoList().get(1).getChoice().getId()),
                () -> assertEquals(4, result.getCategoryInfoList().get(2).getQuestionInfoList().get(1).getChoiceInfoList().get(1).getCount()),
                () -> assertEquals("ch3", result.getCategoryInfoList().get(2).getQuestionInfoList().get(1).getChoiceInfoList().get(2).getChoice().getId()),
                () -> assertEquals(1, result.getCategoryInfoList().get(2).getQuestionInfoList().get(1).getChoiceInfoList().get(2).getCount())
        );

        assertAll("question6",
                () -> assertEquals("q6", result.getCategoryInfoList().get(2).getQuestionInfoList().get(2).getQuestion().getId()),
                () -> assertEquals(5, result.getCategoryInfoList().get(2).getQuestionInfoList().get(2).getCount()),
                () -> assertEquals(3d, result.getCategoryInfoList().get(2).getQuestionInfoList().get(2).getAverage()),
                () -> assertEquals(1.264911064d, result.getCategoryInfoList().get(2).getQuestionInfoList().get(2).getStdDvt(), 0.0000001),
                () -> assertEquals(3, result.getCategoryInfoList().get(2).getQuestionInfoList().get(2).getChoiceInfoList().size()),
                () -> assertEquals("ch1", result.getCategoryInfoList().get(2).getQuestionInfoList().get(2).getChoiceInfoList().get(0).getChoice().getId()),
                () -> assertEquals(1, result.getCategoryInfoList().get(2).getQuestionInfoList().get(2).getChoiceInfoList().get(0).getCount()),
                () -> assertEquals("ch2", result.getCategoryInfoList().get(2).getQuestionInfoList().get(2).getChoiceInfoList().get(1).getChoice().getId()),
                () -> assertEquals(3, result.getCategoryInfoList().get(2).getQuestionInfoList().get(2).getChoiceInfoList().get(1).getCount()),
                () -> assertEquals("ch3", result.getCategoryInfoList().get(2).getQuestionInfoList().get(2).getChoiceInfoList().get(2).getChoice().getId()),
                () -> assertEquals(1, result.getCategoryInfoList().get(2).getQuestionInfoList().get(2).getChoiceInfoList().get(2).getCount())
        );


    }

    private Result getResult() {
        List<Answer> answers = TestMother.aAnswers(); // 1개의 서베이에 대한 answers
        Survey survey = TestMother.aSurvey();


        double average = answers.stream().collect(Collectors.averagingDouble(answer -> answer.getSelectedChoice().getValue()));
        double stdDvt = getStdDvt(answers.stream().map(answer->answer.getSelectedChoice().getValue()).collect(Collectors.toList()), average);
        Map<String, List<Answer>> answersBySubmissionMap = answers.stream().collect(Collectors.groupingBy(Answer::getSubmissionId));
        Map<String, List<Answer>> answersByCategoryMap = answers.stream().collect(Collectors.groupingBy(answer -> answer.getCategory().getId()));

        List<Result.CategoryInfo> categoryInfoList = answersByCategoryMap.entrySet().stream().map(cEntry -> {
            String categoryId = cEntry.getKey();
            List<Answer> answersByCategory = cEntry.getValue();

            Category category = survey.getCategories().stream().filter(c -> c.getId().equals(categoryId)).findFirst().get();
            double averageByCategory = answersByCategory.stream().collect(Collectors.averagingDouble(answer -> answer.getSelectedChoice().getValue()));
            double stdDvtByCategory = getStdDvt(answersByCategory.stream().map(answer -> answer.getSelectedChoice().getValue()).collect(Collectors.toList()), averageByCategory);

            Map<String, List<Answer>> answersByQuestionMap = answersByCategory.stream().collect(Collectors.groupingBy(answer -> answer.getQuestion().getId()));
            List<Result.QuestionInfo> questionInfoList = answersByQuestionMap.entrySet().stream().map(qEntry -> {
                String questionId = qEntry.getKey();
                List<Answer> answersByQuestion = qEntry.getValue();

                Question question = category.getQuestions().stream().filter(q -> q.getId().equals(questionId)).findFirst().get();
                double averageByQuestion = answersByQuestion.stream().collect(Collectors.averagingDouble(answer -> answer.getSelectedChoice().getValue()));
                double stdDvtByQuestion = getStdDvt(answersByQuestion.stream().map(answer -> answer.getSelectedChoice().getValue()).collect(Collectors.toList()), averageByQuestion);
                Map<String, List<Answer>> answersByChoiceMap = answersByQuestion.stream().collect(Collectors.groupingBy(answer -> answer.getSelectedChoice().getId()));

                List<Result.ChoiceInfo> choiceInfoList = answersByChoiceMap.entrySet().stream().map(chEntry -> {
                    String choiceId = chEntry.getKey();
                    List<Answer> answersByChoice = chEntry.getValue();

                    Choice choice = question.getChoices().stream().filter(c -> c.getId().equals(choiceId)).findFirst().get();
                    return Result.ChoiceInfo.builder()
                            .choice(choice)
                            .count(answersByChoice.size())
                            .build();
                }).collect(Collectors.toList());

                return Result.QuestionInfo.builder()
                        .question(question)
                        .count(answersByQuestion.size())
                        .average(averageByQuestion)
                        .stdDvt(stdDvtByQuestion)
                        .choiceInfoList(toSortedByChoiceId(choiceInfoList))
                        .build();

            }).collect(Collectors.toList());

            return Result.CategoryInfo.builder()
                    .category(category)
                    .questionInfoList(toSortedByQuestionId(questionInfoList))
                    .average(averageByCategory)
                    .stdDvt(stdDvtByCategory)
                    .build();
        }).collect(Collectors.toList());

        return Result.builder().categoryInfoList(toSortedByCategoryId(categoryInfoList))
                .count(answersBySubmissionMap.entrySet().size())
                .average(average)
                .stdDvt(stdDvt)
                .build();
    }

    @NotNull
    private List<Result.CategoryInfo> toSortedByCategoryId(List<Result.CategoryInfo> categoryInfoList) {
        categoryInfoList.sort(Comparator.comparing(o -> o.getCategory().getId()));
        return categoryInfoList;
    }

    @NotNull
    private List<Result.QuestionInfo> toSortedByQuestionId(List<Result.QuestionInfo> questionInfoList) {
        questionInfoList.sort(Comparator.comparing(o -> o.getQuestion().getId()));
        return questionInfoList;
    }

    @NotNull
    private List<Result.ChoiceInfo> toSortedByChoiceId(List<Result.ChoiceInfo> choiceInfoList) {
        choiceInfoList.sort(Comparator.comparing(o -> o.getChoice().getId()));
        return choiceInfoList;
    }

    private Result getResultRefactoring() {
        List<Answer> answers = TestMother.aAnswers(); // 1개의 서베이에 대한 answers
        Survey survey = TestMother.aSurvey();

        double average = answers.stream().collect(Collectors.averagingDouble(answer -> answer.getSelectedChoice().getValue()));
        double stdDvt = getStdDvt(answers.stream().map(answer->answer.getSelectedChoice().getValue()).collect(Collectors.toList()), average);
        Map<String, Long> countBySubmissionMap = answers.stream().collect(Collectors.groupingBy(Answer::getSubmissionId, Collectors.counting()));

        Map<String, List<Answer>> answersByCategoryMap = answers.stream().collect(Collectors.groupingBy(answer -> answer.getCategory().getId()));

        List<Result.CategoryInfo> categoryInfoList = survey.getCategories().stream().map(category -> {
            Result.CategoryInfo.CategoryInfoBuilder categoryInfoBuilder = Result.CategoryInfo.emptyWith(category);
            List<Answer> answersByCategory = answersByCategoryMap.containsKey(category.getId()) ? answersByCategoryMap.get(category.getId()) : new ArrayList<>();
            double averageByCategory = answersByCategory.stream().collect(Collectors.averagingDouble(answer -> answer.getSelectedChoice().getValue()));
            double stdDvtByCategory = getStdDvt(answersByCategory.stream().map(answer -> answer.getSelectedChoice().getValue()).collect(Collectors.toList()), averageByCategory);

            Map<String, List<Answer>> answersByQuestionMap = answersByCategory.stream().collect(Collectors.groupingBy(answer -> answer.getQuestion().getId()));
            List<Result.QuestionInfo> questionInfoList = category.getQuestions().stream().map(question -> {
                Result.QuestionInfo.QuestionInfoBuilder questionInfoBuilder = Result.QuestionInfo.emptyWith(question);
                List<Answer> answersByQuestion = answersByQuestionMap.containsKey(question.getId()) ? answersByQuestionMap.get(question.getId()) : new ArrayList<>();
                double averageByQuestion = answersByQuestion.stream().collect(Collectors.averagingDouble(answer -> answer.getSelectedChoice().getValue()));
                double stdDvtByQuestion = getStdDvt(answersByQuestion.stream().map(answer -> answer.getSelectedChoice().getValue()).collect(Collectors.toList()), averageByQuestion);

                Map<String, List<Answer>> answersByChoiceMap = answersByQuestion.stream().collect(Collectors.groupingBy(answer -> answer.getSelectedChoice().getId()));
                List<Result.ChoiceInfo> choiceInfoList = question.getChoices().stream().map(choice -> {
                    Result.ChoiceInfo.ChoiceInfoBuilder choiceInfoBuilder = Result.ChoiceInfo.emptyWith(choice);
                    List<Answer> answersByChoice = answersByChoiceMap.containsKey(choice.getId()) ? answersByChoiceMap.get(choice.getId()) : new ArrayList<>();
                    return choiceInfoBuilder
                            .choice(choice)
                            .count(answersByChoice.size())
                            .build();
                }).collect(Collectors.toList());
                return questionInfoBuilder
                        .question(question)
                        .choiceInfoList(choiceInfoList)
                        .count(answersByQuestion.size())
                        .average(averageByQuestion)
                        .stdDvt(stdDvtByQuestion)
                        .build();
            }).collect(Collectors.toList());
            return categoryInfoBuilder
                    .category(category)
                    .questionInfoList(questionInfoList)
                    .average(averageByCategory)
                    .stdDvt(stdDvtByCategory)
                    .build();
        }).collect(Collectors.toList());

        return Result.builder()
                .count(countBySubmissionMap.entrySet().size())
                .average(average)
                .stdDvt(stdDvt)
                .categoryInfoList(categoryInfoList)
                .build();
    }

    private double getStdDvt(List<Integer> list, double average) {
        return list.isEmpty()? 0d : Math.sqrt(list.stream().mapToDouble(value -> Math.pow(value-average, 2)).sum()/list.size());
    }
}