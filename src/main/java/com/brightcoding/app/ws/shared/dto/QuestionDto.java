package com.brightcoding.app.ws.shared.dto;




public class QuestionDto {
    private Integer id;
    private String questionId;
    private String premier;
    private String deuxieme;
    private String troiseme;
   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getPremier() {
        return premier;
    }

    public void setPremier(String premier) {
        this.premier = premier;
    }

    public String getDeuxieme() {
        return deuxieme;
    }

    public void setDeuxieme(String deuxieme) {
        this.deuxieme = deuxieme;
    }

    public String getTroiseme() {
        return troiseme;
    }

    public void setTroiseme(String troiseme) {
        this.troiseme = troiseme;
    }

	public void setCondidat(CondidatDto condidatDto) {
		// TODO Auto-generated method stub
		
	}

    
}
