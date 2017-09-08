package ua.step.smirnova.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity
public class News {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private int id;
	@Column
	private String title;
	@Column
	@Type(type = "text")
	private String image;
	@Column
	private String owner_link;
	@Column
	private String content_link;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getOwner_link() {
		return owner_link;
	}

	public void setOwner_link(String owner_link) {
		this.owner_link = owner_link;
	}

	public String getContent_link() {
		return content_link;
	}

	public void setContent_link(String content_link) {
		this.content_link = content_link;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", owner_link=" + owner_link
				+ ", content_link=" + content_link + "]";
	}

}
