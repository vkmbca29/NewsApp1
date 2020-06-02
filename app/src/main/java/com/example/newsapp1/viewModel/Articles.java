package com.example.newsapp1.viewModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Articles
{
    @SerializedName("publishedAt")
    @Expose
    private String publishedAt;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("urlToImage")
    @Expose
    private String urlToImage;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("source")
    @Expose
    private Source source;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("content")
    @Expose
    private String content;

    public String getPublishedAt ()
    {
        return publishedAt;
    }

    public void setPublishedAt (String publishedAt)
    {
        this.publishedAt = publishedAt;
    }

    public String getAuthor ()
    {
        return author;
    }

    public void setAuthor (String author)
    {
        this.author = author;
    }

    public String getUrlToImage ()
    {
        return urlToImage;
    }

    public void setUrlToImage (String urlToImage)
    {
        this.urlToImage = urlToImage;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public Source getSource ()
    {
        return source;
    }

    public void setSource (Source source)
    {
        this.source = source;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    public String getContent ()
    {
        return content;
    }

    public void setContent (String content)
    {
        this.content = content;
    }

    @Override
    public String toString()
    {
        return "Results [publishedAt = "+publishedAt+", author = "+author+", urlToImage = "+urlToImage+", description = "+description+", source = "+source+", title = "+title+", url = "+url+", content = "+content+"]";
    }
}