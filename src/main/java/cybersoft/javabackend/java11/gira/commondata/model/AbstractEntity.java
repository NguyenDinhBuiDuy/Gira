package cybersoft.javabackend.java11.gira.commondata.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import cybersoft.javabackend.java11.gira.util.DateUtils;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // dung khi data base co chuc nang auto increasement
	@Column(updatable = false)
	protected long id ;
	
	@Version
	protected int version;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_FORMAT)// giup json hieu nen in format date nhu da quy dinh truoc
	@CreatedDate
	@DateTimeFormat (pattern = DateUtils.DATE_FORMAT)
	@Column(name = "create_at", updatable = false, nullable = false)
	protected LocalDateTime createdAt;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_FORMAT)
	@LastModifiedDate
	@DateTimeFormat (pattern = DateUtils.DATE_FORMAT)
	@Column(name = "update_at", updatable = false, nullable = false)
	protected LocalDateTime updateAt;
	
//	public AbstractEntity() {
//		createdAt = LocalDateTime.now();
//		updateAt = LocalDateTime.now();
//	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}
	
	

}
