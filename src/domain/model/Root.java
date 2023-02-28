package domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Root {
    private String location;
    private String name;
    private List<News> news;

    @JsonCreator
    public Root(@JsonProperty(Constants.TAG_LOCATION) String location,
                @JsonProperty(Constants.TAG_NAME) String name,
                @JsonProperty(Constants.TAG_NEWS) List<News> news){
        this.location = location;
        this.name = name;
        this.news = news;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<News> getNews() {
        return news;
    }
    public void setNews(List<News> news) {
        this.news = news;
    }

    @Override
    public String toString() {
        return "Root{" +
                "location='" + location + '\'' +
                ", name='" + name + '\'' +
                ", news=" + news +
                '}';
    }
}
