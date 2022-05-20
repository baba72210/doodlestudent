package fr.istic.tlc.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.CreationTimestamp;

import fr.istic.tlc.services.Utils;


@Entity
@Schema(name="Poll",description="Poll representation to create")
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(readOnly = true)
    private Long id;

    @NotBlank
    @Schema(title="Poll Title")
    private String title;

    private String location;
    private String description;

    private String urlSondage;
    private String urlSondageAdmin;

    private String slug = Utils.getInstance().generateSlug(24);
    private String slugAdmin = Utils.getInstance().generateSlug(24);

    @CreationTimestamp
    private Date createdAt;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pollID")
    @OrderBy("startDate ASC")
    List<Choice> pollChoices;
 

    public Poll(){}

    public Poll(String title, String location, String description,String urlSondage,String urlSondageAdmin, List<Choice> pollChoices){
        this.title = title;
        this.location = location;
        this.description = description;
        this.urlSondage = urlSondage;
        this.urlSondageAdmin=urlSondageAdmin;
        this.pollChoices = pollChoices;    
    }


    public String getTitle(){
        return title;
    }

    public Long getId(){
        return id;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<Choice> getPollChoices() {
        return pollChoices;
    }

    public void setPollChoices(List<Choice> pollChoices) {
        this.pollChoices = pollChoices;
    }

    public String getUrlSondage() {
        return urlSondage;
    }

    public void setUrlSondage(String urlSondage) {
        this.urlSondage = urlSondage;
    }

    public String getUrlSondageAdmin() {
        return urlSondageAdmin;
    }

    public void setUrlSondageAdmin(String urlSondageAdmin) {
        this.urlSondageAdmin = urlSondageAdmin;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getSlugAdmin() {
        return slugAdmin;
    }

    public void setSlugAdmin(String slugAdmin) {
        this.slugAdmin = slugAdmin;
    }

    
}
