/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nwmsufeatureddevelopersthreeb.featureddevelopersthreeb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author s541906
 */
@Entity
@Table(name = "developers", schema = "public")
public class Developers {
  @Id
  @Column(name = "developerid")
  private String developerId;

  @Column(name = "fullname")
  private String fullName;

  @Column(name = "emailaddress")
  private String Emailaddress;

  @Column(name = "goals")
  private String Goals;

  @Column(name = "skills")
  private String Skills;

  @Column(name = "linkedinurl")
  private String Linkedinurl;

  @Column(name = "githuburl")
  private String Githuburl;

  @Column(name = "image")
  private String Image;


  public String getDeveloperId() {
    return developerId;
  }

  public void setDeveloperId(String developerId) {
    this.developerId = developerId;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

    public Developers() {
    }
  
  

    public Developers(String developerId, String fullName, String Emailaddress, String Goals, String Skills, String Linkedinurl, String Githuburl, String Image) {
        this.developerId = developerId;
        this.fullName = fullName;
        this.Emailaddress = Emailaddress;
        this.Goals = Goals;
        this.Skills = Skills;
        this.Linkedinurl = Linkedinurl;
        this.Githuburl = Githuburl;
        this.Image = Image;
    }

  public String getEmailaddress() {
    return Emailaddress;
  }

  public void setEmailaddress(String Emailaddress) {
    this.Emailaddress = Emailaddress;
  }

  public String getGoals() {
    return Goals;
  }

  public void setGoals(String Goals) {
    this.Goals = Goals;
  }

  public String getSkills() {
    return Skills;
  }

  public void setSkills(String Skills) {
    this.Skills = Skills;
  }

  public String getLinkedinurl() {
    return Linkedinurl;
  }

  public void setLinkedinurl(String Linkedinurl) {
    this.Linkedinurl = Linkedinurl;
  }

  public String getGithuburl() {
    return Githuburl;
  }

  public void setGithuburl(String Githuburl) {
    this.Githuburl = Githuburl;
  }

  public String getImage() {
    return Image;
  }

  public void setImage(String Image) {
    this.Image = Image;
  }

  @Override
  public String toString() {
    return "Developers{"
        + "DeveloperId="
        + developerId
        + ", FullName="
        + fullName
        + ", Emailaddress="
        + Emailaddress
        + ", Goals="
        + Goals
        + ", Skills="
        + Skills
        + ", Linkedinurl="
        + Linkedinurl
        + ", "
        + "Githuburl="
        + Githuburl
        + ",Image="
        + Image
        + '}';
  }
}
