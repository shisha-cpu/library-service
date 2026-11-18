package com.example.demo.domain.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Document(indexName = "books")
public class BookDocument {
    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Integer)
    private int readTime;

    @Field(type = FieldType.Keyword)
    private String genreName;


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getReadTime() {
        return readTime;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReadTime(int readTime) {
        this.readTime = readTime;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
