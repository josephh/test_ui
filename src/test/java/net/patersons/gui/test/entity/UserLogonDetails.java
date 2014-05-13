package net.patersons.gui.test.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("userlogondetails")
public class UserLogonDetails {

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo;
    }

    private String username;
    private String userpassword;
    private String newuserpassword;
    
    public String getNewuserpassword() {
        return newuserpassword;
    }

    
    public void setNewuserpassword(String newuserpassword) {
        this.newuserpassword = newuserpassword;
    }

    private String companyNo;

}
