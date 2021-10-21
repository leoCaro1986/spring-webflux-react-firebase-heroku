package co.com.sofka.questions.model;

public class UserDTO {
    private String id;
    private String userId;
    private String tipoVoto;
    private String answerId;

    public UserDTO(String id) {
        this.id = id;
    }

    public UserDTO(String id, String userId, String tipoVoto, String answerId) {
        this.id = id;
        this.userId = userId;
        this.tipoVoto = tipoVoto;
        this.answerId = answerId;
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

    public String getTipoVoto() {
        return tipoVoto;
    }

    public void setTipoVoto(String tipoVoto) {
        this.tipoVoto = tipoVoto;
    }

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }
}
