package com.tk.youindex.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Tags
 * 
 * @author Trim Kadriu <trim.kadriu@gmail.com>
 */
@Entity(name = "yi_tag")
public class Tag extends PersistentObject {

    private static final long serialVersionUID = 8162208157027403783L;

    private String name;
    private Set<VideoSection> videoSections;

    @NotNull(message = "text.validation.error.NullTagName")
    @NotEmpty(message = "text.validation.error.EmptyTagName")
    @Length(min = 3, max = 32, message = "text.validation.error.NotValidTagName")
    @Column(name = "name", nullable = false, length = 32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @ManyToMany(mappedBy="videoSections", fetch = FetchType.LAZY)
    public Set<VideoSection> getVideoSections() {
        return videoSections;
    }

    public void setVideoSections(Set<VideoSection> videoSections) {
        this.videoSections = videoSections;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Tag) {
            final Tag other = (Tag) obj;
            return new EqualsBuilder().append(name, other.name).isEquals();
        }
        return false;
    }

    @Override
    public String toString() {
        return "Tag [name=" + name + "]";
    }

}
