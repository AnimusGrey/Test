package domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.w3c.dom.Node;

import java.util.List;

public class News {
    private String date;
    private String description;
    private int id;
    private List<String> keywords;
    private String title;
    private Boolean visible;

    @JsonCreator
    public News(  @JsonProperty(Constants.TAG_DATE)String date,
                  @JsonProperty(Constants.TAG_DESCRIPTION)String description,
                  @JsonProperty(Constants.TAG_KEYWORDS) List<String> keywords,
                  @JsonProperty(Constants.TAG_ID) int id,
                  @JsonProperty(Constants.TAG_TITLE) String title,
                  @JsonProperty(Constants.TAG_VISIBLE)Boolean visible){
        this.date = date;
        this.description = description;
        this.id = id;
        this.keywords = keywords;
        this.title = title;
        this.visible = visible;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    @Override
    public String toString() {
        return "News{" +
                "date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", keywords=" + keywords +
                ", title='" + title + '\'' +
                ", visible=" + visible +
                '}';
    }
}

