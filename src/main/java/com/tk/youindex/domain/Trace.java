package com.tk.youindex.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Trace table for video chain play tracking
 * 
 * @author Trim Kadriu <trim.kadriu@gmail.com>
 */
//@Entity(name = "yi_trace")
public class Trace extends PersistentObject {

    /*private static final long serialVersionUID = -7346962233206812568L;

    private VideoSection videoId;
    private VideoSection referalVideoId;

    @NotNull(message = "text.validation.error.NullVideoId")
    @NotEmpty(message = "text.validation.error.EmptyVideoId")
    @Length(min = 5, max = 16, message = "text.validation.error.NotValidVideoIdLength")
    @ManyToOne
    @JoinColumn(name = "video_id")
    public VideoSection getVideoId() {
        return videoId;
    }

    public void setVideoId(VideoSection videoId) {
        this.videoId = videoId;
    }

    @NotNull(message = "text.validation.error.NullReferalVideoId")
    @NotEmpty(message = "text.validation.error.EmptyReferalVideoId")
    @Length(min = 5, max = 16, message = "text.validation.error.NotValidReferalVideoIdLength")
    @ManyToOne
    @JoinColumn(name = "video_id")
    public VideoSection getReferalVideoId() {
        return referalVideoId;
    }

    public void setReferalVideoId(VideoSection referalVideoId) {
        this.referalVideoId = referalVideoId;
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
        return "Trace [videoId=" + videoId + ", referalVideoId=" + referalVideoId + "]";
    }*/

}