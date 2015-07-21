package com.tk.youindex.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.tk.youindex.domain.enums.Status;

/**
 * Video Section
 * 
 * @author Trim Kadriu <trim.kadriu@gmail.com>
 */
@Entity(name = "yi_video_section")
public class VideoSection extends PersistentObject {

    private static final long serialVersionUID = -3385692403227711030L;

    private String videoId;
    private String channelId;
    private String description;
    private String thumbnail;
    private Status status;
    private Author author;
    private int startTime;
    private int endTime;
    private int viewCount;
    private Set<Tag> tags;
    private Set<VideoSection> videoSections;
    private Set<VideoSection> referalVideoSections;
    private Date dateAdded;
    private User user;

    @NotNull(message = "text.validation.error.NullVideoId")
    @NotEmpty(message = "text.validation.error.EmptyVideoId")
    @Length(min = 5, max = 16, message = "text.validation.error.NotValidVideoIdLength")
    @Column(name = "video_id", nullable = false, length = 16)
    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    @NotNull(message = "text.validation.error.NullVideoChannelId")
    @NotEmpty(message = "text.validation.error.EmptyVideoChannelId")
    @Length(min = 2, max = 128, message = "text.validation.error.NotValidVideoChannelIdLength")
    @Column(name = "channel_id", nullable = false, length = 128)
    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    @NotEmpty(message = "text.validation.error.EmptyVideoDescription")
    @Column(name = "description", nullable = true, length = 512)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull(message = "text.validation.error.NullVideoThumbnailUrl")
    @NotEmpty(message = "text.validation.error.EmptyVideoThumbnailUrl")
    @Length(min = 16, max = 512, message = "text.validation.error.NotValidVideoThumbnailUrl")
    @Column(name = "thumbnail", nullable = false, length = 512)
    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @NotNull(message = "text.validation.error.NullVideoStatus")
    @NotEmpty(message = "text.validation.error.EmptyVideoStatus")
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 2)
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @NotNull(message = "text.validation.error.NullVideoAuthor")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @NotNull(message = "text.validation.error.NullVideoStartTime")
    @NotEmpty(message = "text.validation.error.EmptyVideoStartTime")
    @Length(max = 9, message = "text.validation.error.NotValidVideoIdStartTime")
    @Column(name = "start_time", nullable = false, length = 9)
    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    @NotNull(message = "text.validation.error.NullVideoStartTime")
    @NotEmpty(message = "text.validation.error.EmptyVideoStartTime")
    @Length(max = 9, message = "text.validation.error.NotValidVideoIdStartTime")
    @Column(name = "end_time", nullable = false, length = 9)
    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    @NotNull(message = "text.validation.error.NullVideoViewCount")
    @NotEmpty(message = "text.validation.error.EmptyVideoViewCount")
    @Length(max = 9, message = "text.validation.error.NotValidVideoViewCount")
    @Column(name = "view_count", nullable = false, length = 9)
    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinTable(name = "videosection_tags", joinColumns = { @JoinColumn(name = "videosection_id") }, inverseJoinColumns = { @JoinColumn(name = "tag_id") })
    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinTable(name = "EMPLOYEE_COLLEAGUE", joinColumns = { @JoinColumn(name = "video_id") }, inverseJoinColumns = { @JoinColumn(name = "referal_video_id") })
    public Set<VideoSection> getVideoSections() {
        return videoSections;
    }

    public void setVideoSections(Set<VideoSection> videoSections) {
        this.videoSections = videoSections;
    }

    @ManyToMany(mappedBy = "videoSections", fetch = FetchType.LAZY)
    public Set<VideoSection> getReferalVideoSections() {
        return referalVideoSections;
    }

    public void setReferalVideoSections(Set<VideoSection> referalVideoSections) {
        this.referalVideoSections = referalVideoSections;
    }

    @NotNull(message = "text.validation.error.NullVideoDateAdded")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_added", nullable = false, precision = 3)
    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    @NotNull(message = "text.validation.error.NullVideoUser")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        if (obj instanceof VideoSection) {
            final VideoSection other = (VideoSection) obj;
            return new EqualsBuilder().append(this.id, other.id).isEquals();
        }
        return false;
    }

    @Override
    public String toString() {
        return "VideoSection [videoId=" + videoId + ", author=" + author + ", startTime=" + startTime + ", endTime="
                + endTime + ", dateAdded=" + dateAdded + "]";
    }

}