package com.tk.youindex.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Author of that video section
 * 
 * @author Trim Kadriu <trim.kadriu@gmail.com>
 */
@Entity(name = "yi_author")
public class Author extends PersistentObject {

    private static final long serialVersionUID = -2080186831320046066L;

    private String name;
    private byte[] photo;
    private String personalPage;
    private String pageContent;
    private Set<VideoSection> videoSections;
    private Date dateAdded;

    @NotNull(message = "text.validation.error.NullAuthorName")
    @NotEmpty(message = "text.validation.error.EmptyAuthorName")
    @Length(min = 2, max = 32, message = "text.validation.error.NotValidAuthorName")
    @Column(name = "name", nullable = false, length = 32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Lob
    @Column(name = "photo", nullable = true)
    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @NotEmpty(message = "text.validation.error.EmptyAuthorPersonalPage")
    @Length(min = 5, max = 128, message = "text.validation.error.NotValidAuthorPersonalPage")
    @Column(name = "personal_page", nullable = false, length = 128)
    public String getPersonalPage() {
        return personalPage;
    }

    public void setPersonalPage(String personalPage) {
        this.personalPage = personalPage;
    }

    @NotEmpty(message = "text.validation.error.EmptyAuthorPageContent")
    @Length(min = 10, max = 1024, message = "text.validation.error.NotValidAuthorPageContent")
    @Column(name = "page_content", nullable = false, length = 1024)
    public String getPageContent() {
        return pageContent;
    }

    public void setPageContent(String pageContent) {
        this.pageContent = pageContent;
    }

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    public Set<VideoSection> getVideoSections() {
        return videoSections;
    }

    public void setVideoSections(Set<VideoSection> videoSections) {
        this.videoSections = videoSections;
    }

    @NotNull(message = "text.validation.error.NullAuthorDateAdded")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_added", nullable = false, precision = 3)
    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.id).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Author) {
            final Author other = (Author) obj;
            return new EqualsBuilder().append(this.id, other.id).isEquals();
        }
        return false;
    }

    @Override
    public String toString() {
        return "Author [Name=" + name + "]";
    }

}
