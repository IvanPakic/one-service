package rs.raf.prviProjekat.web;

public class User {
    private String setUserName;
    private String setPassWord;

    public User(String setUserName, String setPassWord) {
        this.setUserName = setUserName;
        this.setPassWord = setPassWord;
    }

    public String getSetUserName() {
        return setUserName;
    }

    public void setSetUserName(String setUserName) {
        this.setUserName = setUserName;
    }

    public String getSetPassWord() {
        return setPassWord;
    }

    public void setSetPassWord(String setPassWord) {
        this.setPassWord = setPassWord;
    }
}
