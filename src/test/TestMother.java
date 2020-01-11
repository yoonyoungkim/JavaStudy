package test;

import stream.*;

import java.util.ArrayList;
import java.util.List;

public class TestMother {
    public static Survey aSurvey() {
        List<Choice> choices = new ArrayList<>();
        Choice choice1 = Choice.builder().id("ch1").text("choice1").value(1).build();
        Choice choice2 = Choice.builder().id("ch2").text("choice2").value(2).build();
        Choice choice3 = Choice.builder().id("ch3").text("choice3").value(3).build();
        choices.add(choice1);
        choices.add(choice2);
        choices.add(choice3);

        List<Question> questionsOfCategory1 = new ArrayList<>();
        List<Question> questionsOfCategory2 = new ArrayList<>();
        List<Question> questionsOfCategory3 = new ArrayList<>();
        Question question1 = Question.builder().id("q1").text("question1").type("rating").choices(choices).build();
        Question question2 = Question.builder().id("q2").text("question2").type("rating").choices(choices).build();
        Question question3 = Question.builder().id("q3").text("question3").type("rating").choices(choices).build();
        Question question4 = Question.builder().id("q4").text("question4").type("rating").choices(choices).build();
        Question question5 = Question.builder().id("q5").text("question5").type("rating").choices(choices).build();
        Question question6 = Question.builder().id("q6").text("question6").type("rating").choices(choices).build();
        questionsOfCategory1.add(question1);
        questionsOfCategory2.add(question2);
        questionsOfCategory2.add(question3);
        questionsOfCategory3.add(question4);
        questionsOfCategory3.add(question5);
        questionsOfCategory3.add(question6);
        List<Category> categories = new ArrayList<>();
        Category category1 = Category.builder().id("c1").text("category1").questions(questionsOfCategory1).build();
        Category category2 = Category.builder().id("c2").text("category2").questions(questionsOfCategory2).build();
        Category category3 = Category.builder().id("c3").text("category3").questions(questionsOfCategory3).build();
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);

        return Survey.builder().id("s1").title("survey title").teamName("team name").description("survey description").categories(categories).build();
    }

    public static List<Answer> aAnswers() {
        List<Choice> choices = new ArrayList<>();
        Choice choice1 = Choice.builder().id("ch1").text("choice1").value(1).build();
        Choice choice2 = Choice.builder().id("ch2").text("chocie2").value(3).build();
        Choice choice3 = Choice.builder().id("ch3").text("chocie3").value(5).build();
        choices.add(choice1);
        choices.add(choice2);
        choices.add(choice3);

        List<Question> questions1 = new ArrayList<>();
        List<Question> questions2 = new ArrayList<>();
        List<Question> questions3 = new ArrayList<>();
        Question question1 = Question.builder().id("q1").text("question1").type("rating").choices(choices).build();
        Question question2 = Question.builder().id("q2").text("question2").type("rating").choices(choices).build();
        Question question3 = Question.builder().id("q3").text("question3").type("rating").choices(choices).build();
        Question question4 = Question.builder().id("q4").text("question4").type("rating").choices(choices).build();
        Question question5 = Question.builder().id("q5").text("question5").type("rating").choices(choices).build();
        Question question6 = Question.builder().id("q6").text("question6").type("rating").choices(choices).build();
        questions1.add(question1);
        questions2.add(question2);
        questions2.add(question3);
        questions3.add(question4);
        questions3.add(question5);
        questions3.add(question6);

        Category category1 = Category.builder().id("c1").text("category1").questions(questions1).build();
        Category category2 = Category.builder().id("c2").text("category2").questions(questions2).build();
        Category category3 = Category.builder().id("c3").text("category3").questions(questions3).build();

        List<Answer> answers = new ArrayList<>();
        Answer answers1 = Answer.builder().id("a1").surveyId("s1").submissionId("sub1").category(category1).question(question1).selectedChoice(choice1).build();
        Answer answers2 = Answer.builder().id("a2").surveyId("s1").submissionId("sub1").category(category2).question(question2).selectedChoice(choice2).build();
        Answer answers3 = Answer.builder().id("a3").surveyId("s1").submissionId("sub1").category(category2).question(question3).selectedChoice(choice2).build();
//        Answer answers4 = Answer.builder().id("a4").surveyId("s1").submissionId("sub1").category(category3).question(question4).selectedChoice(choice3).build();
        Answer answers5 = Answer.builder().id("a5").surveyId("s1").submissionId("sub1").category(category3).question(question5).selectedChoice(choice3).build();
        Answer answers6 = Answer.builder().id("a6").surveyId("s1").submissionId("sub1").category(category3).question(question6).selectedChoice(choice3).build();

        Answer answers7 = Answer.builder().id("a7").surveyId("s1").submissionId("sub2").category(category1).question(question1).selectedChoice(choice2).build();
        Answer answers8 = Answer.builder().id("a8").surveyId("s1").submissionId("sub2").category(category2).question(question2).selectedChoice(choice1).build();
        Answer answers9 = Answer.builder().id("a9").surveyId("s1").submissionId("sub2").category(category2).question(question3).selectedChoice(choice1).build();
//        Answer answers10 = Answer.builder().id("a10").surveyId("s1").submissionId("sub2").category(category3).question(question4).selectedChoice(choice1).build();
        Answer answers11 = Answer.builder().id("a11").surveyId("s1").submissionId("sub2").category(category3).question(question5).selectedChoice(choice2).build();
        Answer answers12 = Answer.builder().id("a12").surveyId("s1").submissionId("sub2").category(category3).question(question6).selectedChoice(choice2).build();

        Answer answers13 = Answer.builder().id("a13").surveyId("s1").submissionId("sub3").category(category1).question(question1).selectedChoice(choice3).build();
        Answer answers14 = Answer.builder().id("a14").surveyId("s1").submissionId("sub3").category(category2).question(question2).selectedChoice(choice3).build();
        Answer answers15 = Answer.builder().id("a15").surveyId("s1").submissionId("sub3").category(category2).question(question3).selectedChoice(choice1).build();
//        Answer answers16 = Answer.builder().id("a16").surveyId("s1").submissionId("sub3").category(category3).question(question4).selectedChoice(choice1).build();
        Answer answers17 = Answer.builder().id("a17").surveyId("s1").submissionId("sub3").category(category3).question(question5).selectedChoice(choice2).build();
        Answer answers18 = Answer.builder().id("a18").surveyId("s1").submissionId("sub3").category(category3).question(question6).selectedChoice(choice2).build();

        Answer answers19 = Answer.builder().id("a19").surveyId("s1").submissionId("sub4").category(category1).question(question1).selectedChoice(choice3).build();
        Answer answers20 = Answer.builder().id("a20").surveyId("s1").submissionId("sub4").category(category2).question(question2).selectedChoice(choice3).build();
        Answer answers21 = Answer.builder().id("a21").surveyId("s1").submissionId("sub4").category(category2).question(question3).selectedChoice(choice3).build();
//        Answer answers22 = Answer.builder().id("a22").surveyId("s1").submissionId("sub4").category(category3).question(question4).selectedChoice(choice3).build();
        Answer answers23 = Answer.builder().id("a23").surveyId("s1").submissionId("sub4").category(category3).question(question5).selectedChoice(choice2).build();
        Answer answers24 = Answer.builder().id("a24").surveyId("s1").submissionId("sub4").category(category3).question(question6).selectedChoice(choice2).build();

        Answer answers25 = Answer.builder().id("a25").surveyId("s1").submissionId("sub5").category(category1).question(question1).selectedChoice(choice1).build();
        Answer answers26 = Answer.builder().id("a26").surveyId("s1").submissionId("sub5").category(category2).question(question2).selectedChoice(choice2).build();
        Answer answers27 = Answer.builder().id("a27").surveyId("s1").submissionId("sub5").category(category2).question(question3).selectedChoice(choice2).build();
//        Answer answers28 = Answer.builder().id("a28").surveyId("s1").submissionId("sub5").category(category3).question(question4).selectedChoice(choice2).build();
        Answer answers29 = Answer.builder().id("a29").surveyId("s1").submissionId("sub5").category(category3).question(question5).selectedChoice(choice2).build();
        Answer answers30 = Answer.builder().id("a30").surveyId("s1").submissionId("sub5").category(category3).question(question6).selectedChoice(choice1).build();

        answers.add(answers1);
        answers.add(answers2);
        answers.add(answers3);
//        answers.add(answers4);
        answers.add(answers5);
        answers.add(answers6);

        answers.add(answers7);
        answers.add(answers8);
        answers.add(answers9);
//        answers.add(answers10);
        answers.add(answers11);
        answers.add(answers12);

        answers.add(answers13);
        answers.add(answers14);
        answers.add(answers15);
//        answers.add(answers16);
        answers.add(answers17);
        answers.add(answers18);

        answers.add(answers19);
        answers.add(answers20);
        answers.add(answers21);
//        answers.add(answers22);
        answers.add(answers23);
        answers.add(answers24);


        answers.add(answers25);
        answers.add(answers26);
        answers.add(answers27);
//        answers.add(answers28);
        answers.add(answers29);
        answers.add(answers30);
        return answers;
    }

}
