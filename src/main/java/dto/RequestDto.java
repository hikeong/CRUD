package dto;

public class RequestDto {
    private String title;
    private String content;
    private String writer;

    public String getTitle() { return title; }
    public String getContent() { return content; }
    public String getWriter() { return writer; }

    public void setTitle(String title) { this.title = title; }
    public void setContent(String content) { this.content = content; }
    public void setWriter(String writer) { this.writer = writer; }
}
