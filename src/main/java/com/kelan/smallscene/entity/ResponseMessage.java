package com.kelan.smallscene.entity;

/**
 * <p></p>
 *
 * @author JG
 * @version V1.0.0
 * @date 2019/1/7 17:45
 * @see
 */
public class ResponseMessage {
  private String id;
  private String name;
  private String content;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
