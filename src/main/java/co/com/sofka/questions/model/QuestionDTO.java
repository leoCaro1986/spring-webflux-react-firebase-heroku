package co.com.sofka.questions.model;


import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class QuestionDTO {
    private String id;
    @NotBlank
    private String userId;
    @NotBlank
    private String question;
    @NotBlank
    private String type;
    @NotBlank
    private String category;
    private List<AnswerDTO> answers;
    @NotBlank
    private String userEmail;
    private Integer numberOfReviews = 0;
    private Integer sumOfReviewScores = 0;
    private List<String> userReviews = new ArrayList<>();


    public QuestionDTO() {

    }

    public QuestionDTO(String userId, String question, String type, String category, String userEmail) {
        this.userId = userId;
        this.question = question;
        this.type = type;
        this.category = category;
        this.userEmail = userEmail;
    }

    public QuestionDTO(String id, String userId, String question, String type, String category, String userEmail, Integer numberOfReviews, Integer sumOfReviewScores, List<String> userReviews) {
        this.id = id;
        this.userId = userId;
        this.question = question;
        this.type = type;
        this.category = category;
        this.userEmail= userEmail;
        this.numberOfReviews= numberOfReviews;
        this.sumOfReviewScores = sumOfReviewScores;
        this.userReviews= userReviews;
    }
    public List<AnswerDTO> getAnswers() {
        this.answers = Optional.ofNullable(answers).orElse(new ArrayList<>());
        return answers;
    }

    public void setAnswers(List<AnswerDTO> answers) {
        this.answers = answers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "QuestionDTO{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", question='" + question + '\'' +
                ", type='" + type + '\'' +
                ", category='" + category + '\'' +
                ", answer='" + answers + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", numberOfReviews=" + numberOfReviews +
                ", sumOfReviewScores=" + sumOfReviewScores +
                ", userReviews=" + userReviews +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionDTO that = (QuestionDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(userId, that.userId) && Objects.equals(question,that.question)&& Objects.equals(type,that.type)&&Objects.equals(category, that.category) && Objects.equals(answers, that.answers) && Objects.equals(userEmail, that.userEmail);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userId, question, type, category, answers, userEmail);
    }


    public Integer getNumberOfReviews() {
        return numberOfReviews;
    }

    public void setNumberOfReviews(Integer numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }

    public Integer getSumOfReviewScores() {
        return sumOfReviewScores;
    }

    public void setSumOfReviewScores(Integer sumOfReviewScores) {
        this.sumOfReviewScores = sumOfReviewScores;
    }

    public List<String> getUserReviews() {
        return userReviews;
    }

    public void setUserReviews(List<String> userReviews) {
        this.userReviews = userReviews;
    }
}
