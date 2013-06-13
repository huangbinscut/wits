package tel.wits.servicematrix.model.infomodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import tel.wits.common.model.AbstractModel;


@Entity
@Table(name = "tbl_access_token")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AccessTokenModel extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "token_id", nullable = false)
    private int tokenId;
    
    @Column(name = "individual_id", nullable = false)
    private int individualId;

    @Column(name = "channel_id", nullable = false)
    private int channelId;

    @Column(name = "access_uid", nullable = false)
    private String accessUid;
    
    @Column(name = "token_code", nullable = false)
    private String tokenCode;
    
    @Column(name = "generate_time", nullable = false)
    private Date generateTime;
    
    @Column(name = "expire_time", nullable = false)
    private int expireTime;
    
    @Column(name = "refresh_token", nullable = false)
    private String refreshToken;

    @Column(name = "token_type", nullable = false)
    private String tokenType;

    @Column(name = "access_scope", nullable = false)
    private int accessScope;
    
	
	
	public int getTokenId() {
		return tokenId;
	}
	public void setTokenId(int tokenId) {
		this.tokenId = tokenId;
	}
	public int getIndividualId() {
		return individualId;
	}
	public void setIndividualId(int individualId) {
		this.individualId = individualId;
	}
	public int getChannelId() {
		return channelId;
	}
	public void setChannelId(int channelId) {
		this.channelId = channelId;
	}
	public String getAccessUid() {
		return accessUid;
	}
	public void setAccessUid(String accessUid) {
		this.accessUid = accessUid;
	}
	public String getTokenCode() {
		return tokenCode;
	}
	public void setTokenCode(String tokenCode) {
		this.tokenCode = tokenCode;
	}
	public Date getGenerateTime() {
		return generateTime;
	}
	public void setGenerateTime(Date generateTime) {
		this.generateTime = generateTime;
	}
	public int getExpireTime() {
		return expireTime;
	}
	public void setExpireTime(int expireTime) {
		this.expireTime = expireTime;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public String getTokenType() {
		return tokenType;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	public int getAccessScope() {
		return accessScope;
	}
	public void setAccessScope(int accessScope) {
		this.accessScope = accessScope;
	}
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + tokenId;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AccessTokenModel other = (AccessTokenModel) obj;
        if (tokenId != other.tokenId)
            return false;
        return true;
    }
    
    
    
}
