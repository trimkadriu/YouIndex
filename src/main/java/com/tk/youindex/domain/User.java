package com.tk.youindex.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.tk.youindex.domain.enums.Status;

/**
 * User
 * 
 * @author Trim Kadriu <trim.kadriu@gmail.com>
 */
@Entity(name = "yi_user")
public class User extends PersistentObject {

    private static final long serialVersionUID = -6069570845421818066L;

    private String name;
    private String email;
    private String password;
    private String passwordSalt;
    private Date lastLogin;
    private Date dateAdded;
    private Status status;
    private String activationHash;
    private boolean adminUser;
    private Set<VideoSection> videoSections;

    @NotNull(message = "text.validation.error.NullUserName")
    @NotEmpty(message = "text.validation.error.EmptyUserName")
    @Length(min = 2, max = 32, message = "text.validation.error.NotValidUserName")
    @Column(name = "user_name", nullable = false, length = 32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull(message = "text.validation.error.NullUserEmail")
    @NotEmpty(message = "text.validation.error.EmptyUserEmail")
    @Length(min = 5, max = 64, message = "text.validation.error.NotValidLengthUserEmail")
    @Pattern(message = "text.validation.error.NotValidUserEmail", regexp = "^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-+]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
    @Column(name = "email", nullable = false, length = 64)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotNull(message = "text.validation.error.NullUserPassword")
    @NotEmpty(message = "text.validation.error.EmptyUserPassword")
    @Length(max = 128, message = "text.validation.error.NotValidUserPassword")
    @Column(name = "password", nullable = false, length = 128)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotNull(message = "text.validation.error.NullUserPasswordSalt")
    @NotEmpty(message = "text.validation.error.EmptyUserPasswordSalt")
    @Length(max = 128, message = "text.validation.error.NotValidUserPasswordSalt")
    @Column(name = "password_salt", nullable = false, length = 128)
    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    @NotNull(message = "text.validation.error.NullUserLastLogin")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_login", nullable = false, precision = 3)
    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    @NotNull(message = "text.validation.error.NullUserDateAdded")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_added", nullable = false, precision = 3)
    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    @NotNull(message = "text.validation.error.NullUserStatus")
    @NotEmpty(message = "text.validation.error.EmptyUserStatus")
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 2)
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @NotNull(message = "text.validation.error.NullUserActivatonHash")
    @NotEmpty(message = "text.validation.error.EmptyUserActivatonHash")
    @Length(min = 128, max = 128, message = "text.validation.error.NotValidUserActivatonHash")
    @Column(name = "activation_hash", nullable = false, length = 128)
    public String getActivationHash() {
        return activationHash;
    }

    public void setActivationHash(String activationHash) {
        this.activationHash = activationHash;
    }

    @Type(type = "yes_no")
    @Column(name = "admin_user", length = 1)
    public boolean isAdminUser() {
        return adminUser;
    }

    public void setAdminUser(boolean adminUser) {
        this.adminUser = adminUser;
    }

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    public Set<VideoSection> getVideoSections() {
        return videoSections;
    }

    public void setVideoSections(Set<VideoSection> videoSections) {
        this.videoSections = videoSections;
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
        return "User [name=" + name + ", email=" + email + ", status=" + status + ", adminUser=" + adminUser + "]";
    }

}
